package com.example.lab2sap.database

import androidx.room.TypeConverter
import java.util.UUID

class StudentTypeConverter {
    @TypeConverter
    fun toUUID(uuid: String?): UUID?{
        return UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid: UUID?):String? {
        return uuid?.toString()
    }
}