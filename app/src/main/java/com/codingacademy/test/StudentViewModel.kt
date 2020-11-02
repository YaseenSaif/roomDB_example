package com.codingacademy.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codingacademy.test.database.StudentDAO
import java.util.*
import com.codingacademy.test.*

class StudentViewModel:ViewModel() {
//    val students = mutableListOf<Student>()
//    init {
//
//   }
    private val studentRepository = Repository.get()
    val studentListLiveData = studentRepository.getStudents()
    fun addStudent(stu: Student) {
        studentRepository.addStudent(stu)
    }

}