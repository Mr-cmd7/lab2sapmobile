package com.example.lab2sap.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2sap.R
import com.example.lab2sap.databinding.FragmentStudentListBinding

private const val TAG="StudentListFragment"

class StudentListFragment: Fragment(R.layout.fragment_student_list) {
    private lateinit var binding: FragmentStudentListBinding
    private var adapter: StudentAdapter?=StudentAdapter(emptyList())
    private val studentListViewModel:StudentListViewModel by lazy {
        ViewModelProvider(this)[StudentListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentStudentListBinding.inflate(layoutInflater,
            container,false)
        binding.studentRecyclerView.layoutManager= LinearLayoutManager(context)
        //  studentListViewModel.Load()
        studentListViewModel.studentListLiveData.observe(viewLifecycleOwner,
            Observer { students->
                adapter=StudentAdapter(students)
                binding.studentRecyclerView.adapter=adapter
            })

        return binding.root
    }

    private inner class StudentAdapter(var students:List<Student>):
        RecyclerView.Adapter<StudentAdapter.StudentHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
            val view=layoutInflater.inflate(R.layout.list_item_student,parent,false)
            return StudentHolder(view)
        }

        override fun getItemCount(): Int = students.size

        override fun onBindViewHolder(holder: StudentHolder, position: Int) {
            val student=students[position]
//            holder.apply {
//                studentNameTextView.text=student.name
//                studentGroupTextView.text=student.group
//                studentYear.text=student.birthYear.toString()
//            }
            holder.bind(student)
        }
        private inner class StudentHolder(view: View): RecyclerView.ViewHolder(view),
            View.OnClickListener{
            private lateinit var student:Student
            val studentNameTextView: TextView =itemView.findViewById(R.id.student_name)
            val studentGroupTextView: TextView =itemView.findViewById(R.id.student_group)
            val studentYear: TextView =itemView.findViewById(R.id.student_year)
            init {
                itemView.setOnClickListener(this)
            }
            fun bind(student: Student){
                this.student=student
                studentNameTextView.text=student.name
                studentGroupTextView.text=student.group
                studentYear.text=student.birthYear.toString()
            }

            override fun onClick(v: View?) {
                Toast.makeText(context,student.name, Toast.LENGTH_SHORT).show()
            }
        }

    }
    companion object{
        fun newInstance():StudentListFragment{
            return StudentListFragment()
        }
    }
}