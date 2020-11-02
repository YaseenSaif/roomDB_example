package com.codingacademy.test

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.codingacademy.test.database.StudentDAO
import com.codingacademy.test.database.StudentDatabase
import java.util.*
import java.util.concurrent.Executors

private const val DATABASE_NAME = "student-database"

class Repository private constructor(context: Context) {
    private val database: StudentDatabase = Room.databaseBuilder(
        context.applicationContext,
        StudentDatabase::class.java,
        DATABASE_NAME
    ).build()
    private val studentDAO = database.studentDAO()
    fun getStudents(): LiveData<List<Student>> = studentDAO.getStudents()

    private val executor = Executors.newSingleThreadExecutor()

    companion object {
        private var INSTANCE: Repository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = Repository(context)
            }
        }
        fun get(): Repository {
            return INSTANCE
                ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
    fun addStudent(student: Student) {
        executor.execute {
            studentDAO.addStu(student)
        }
    }
}

