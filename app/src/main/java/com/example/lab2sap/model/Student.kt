package com.example.lab2sap.model

import androidx.room.PrimaryKey
import java.util.UUID

class Student(@PrimaryKey val id:UUID=UUID.randomUUID(), var lastName:String,var group:String,
    var year:Int, var physics:Int,var mathematic:Int, var informatic:Int) {
}