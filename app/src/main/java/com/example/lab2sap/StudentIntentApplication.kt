package com.example.lab2sap

import android.app.Application

class StudentIntentApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        StudentRepository.initialize(this)
    }
}