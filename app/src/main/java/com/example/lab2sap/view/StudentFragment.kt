package com.example.lab2sap.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lab2sap.R
import com.example.lab2sap.databinding.FragmentStudentBinding
import com.example.lab2sap.model.Student
import com.example.lab2sap.viewmodel.StudentViewModel
import java.util.UUID

private const val ARG_STUDENT_ID="student_id"
private const val TAG="StudentFragment"
private const val ARG_STUDENT = "student"
private const val REQUEST_STUDENT = 0

class StudentFragment : Fragment(R.layout.fragment_student) {

    companion object {
        fun newInstance(studentId: UUID) :StudentFragment {
            val args= Bundle().apply {
                putSerializable(ARG_STUDENT_ID,studentId)
            }
            return StudentFragment().apply {
                arguments=args
            }
        }
    }
    private lateinit var binding: FragmentStudentBinding
    private lateinit var student: Student
    private val studentViewModel: StudentViewModel by lazy {
        ViewModelProvider(this).get(StudentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        student=Student()
        val studentId:UUID=arguments?.getSerializable(ARG_STUDENT_ID) as UUID
        studentViewModel.loadStudent(studentId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentStudentBinding.inflate(layoutInflater,container,false)
        studentViewModel.studentLiveData.observe(viewLifecycleOwner,
            Observer {
                    student->
                student?.let {
                    this.student=student
                    binding.tvFIO.text=student.lastName
                    binding.tvGroup.text=student.group
                    binding.tvBirthDate.text=student.year.toString()
                    binding.tvPhis.text=student.physics.toString()
                    binding.tvMath.text=student.mathematic.toString()
                    binding.tvInfo.text=student.informatic.toString()
                }
            })
        binding.btEdit.setOnClickListener {
                StudentDialogFragment.newInstance(student).apply {
                    setTargetFragment(this@StudentFragment, REQUEST_STUDENT)
                    show(this@StudentFragment.requireFragmentManager(), ARG_STUDENT)
                }
        }
        return binding.root
    }
}