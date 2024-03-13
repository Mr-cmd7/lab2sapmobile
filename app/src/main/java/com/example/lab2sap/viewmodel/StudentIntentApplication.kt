package com.example.lab2sap.viewmodel

import android.app.Application
import com.example.lab2sap.database.StudentRepository

class StudentIntentApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        StudentRepository.initialize(this)
    }
}