package com.codingacademy.test.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.util.*
import com.codingacademy.test.*

@Dao
interface StudentDAO {

    @Query("SELECT * FROM Student")
    fun getStudents(): LiveData<List<Student>>


    @Insert
    fun addStu(stu :Student)
}