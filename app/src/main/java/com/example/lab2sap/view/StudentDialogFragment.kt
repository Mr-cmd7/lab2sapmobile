package com.example.lab2sap.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab2sap.databinding.StudentDialogBinding
import com.example.lab2sap.model.Student
import com.example.lab2sap.viewmodel.StudentViewModel

private const val ARG_STUDENT = "student"
class StudentDialogFragment: DialogFragment() {
    companion object {
        fun newInstance(student: Student): StudentDialogFragment {
            val args = Bundle().apply {
                putSerializable(ARG_STUDENT, student)
            }

            return StudentDialogFragment().apply {
                arguments = args
            }
        }
    }
    private lateinit var binding: StudentDialogBinding
    private lateinit var student: Student
    private val studentViewModel: StudentViewModel by lazy {
        ViewModelProvider(this).get(StudentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= StudentDialogBinding.inflate(inflater, container, false)
        var studentArgs: Student
        if(arguments!=null) {
            studentArgs = arguments?.getSerializable(ARG_STUDENT) as Student
            studentViewModel.loadStudent(studentArgs.id)
        }
        studentViewModel.studentLiveData.observe(viewLifecycleOwner
        ) { student ->
            student?.let {
                if (arguments != null) {
                    this.student = student
                    binding.etFIO.setText(student.lastName)
                    binding.etGroup.setText(student.group)
                    binding.etAge.setText(student.year.toString())
                    binding.etMarkInfo.setText(student.informatic.toString())
                    binding.etMarkMath.setText(student.mathematic.toString())
                    binding.etMarkPhis.setText(student.physics.toString())
                }
            }
        }
        binding.btOk.setOnClickListener {

            if (arguments != null) {
                student.lastName = binding.etFIO.text.toString()
                student.group = binding.etGroup.text.toString()
                student.year = binding.etAge.text.toString().toInt()
                student.physics = binding.etMarkPhis.text.toString().toInt()
                student.mathematic = binding.etMarkMath.text.toString().toInt()
                student.informatic = binding.etMarkInfo.text.toString().toInt()
                studentViewModel.updateStudent(student)
            }
            else
            {
                this.student= Student()
                student.lastName = binding.etFIO.text.toString()
                student.group = binding.etGroup.text.toString()
                student.year = binding.etAge.text.toString().toInt()
                student.physics = binding.etMarkPhis.text.toString().toInt()
                student.mathematic = binding.etMarkMath.text.toString().toInt()
                student.informatic = binding.etMarkInfo.text.toString().toInt()
                studentViewModel.saveStudent(student)
            }
            dismiss()
        }
        binding.btCancel.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
}