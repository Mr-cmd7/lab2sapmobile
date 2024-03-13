package com.example.lab2sap.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab2sap.R
import com.example.lab2sap.databinding.FragmentDetailStudentBinding

class DetailStudentFragment : Fragment(R.layout.fragment_detail_student) {
    private lateinit var binding: FragmentDetailStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentDetailStudentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailStudentFragment().apply {

            }
    }
}