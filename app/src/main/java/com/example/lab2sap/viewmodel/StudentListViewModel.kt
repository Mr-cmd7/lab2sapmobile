package com.example.lab2sap.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab2sap.StudentRepository

class StudentListViewModel : ViewModel() {
    private val studentRepository = StudentRepository.get();
    val studentListLiveData = studentRepository.getStudents()
}