package com.example.lab2sap.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lab2sap.model.Student

@Database(entities = [Student::class], version = 1)
@TypeConverters(StudentTypeConverter::class)
abstract class StudentDatabase: RoomDatabase() {
    abstract fun studentDao():StudentDao
}
