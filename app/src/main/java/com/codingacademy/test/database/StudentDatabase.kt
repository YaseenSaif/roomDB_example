package com.codingacademy.test.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.codingacademy.test.*

@Database(entities = [ Student::class ], version=1)
@TypeConverters(StudentTypeConverters::class)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun  studentDAO(): StudentDAO
}