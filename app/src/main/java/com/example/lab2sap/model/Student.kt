package com.example.lab2sap.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.UUID
@Entity
data class Student(@PrimaryKey val id:UUID=UUID.randomUUID(),
                   var lastName:String="",var group:String="",
    var year:Int=0, var physics:Int=0,var mathematic:Int=0, var informatic:Int=0) : Serializable