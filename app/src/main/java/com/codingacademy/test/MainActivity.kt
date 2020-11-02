package com.codingacademy.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.*
import androidx.lifecycle.Lifecycle.State

class MainActivity : AppCompatActivity() {
    private lateinit var studentTextView :TextView
    private val studentViewModel: StudentViewModel by lazy {
        ViewModelProviders.of(this).get(StudentViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        studentTextView=findViewById(R.id.text_view)
        insertStu()
    }
    fun insertStu(){
    for (i in 0 until 8) {
        val student = Student()
        student.name = "Yaseen"
        student.pass = i % 2 == 0
        studentViewModel.addStudent(student);
    }
}
    override fun onStart() {
        super.onStart()

        studentViewModel.studentListLiveData.observe(this,
            Observer { students ->
                students?.let {
                    Log.i("studentListSize", "Got studentLiveData ${students.size}")
                    printStudentList(students)
                }
            })
    }
    fun printStudentList(stuList :List<Student>){
        stuList.forEach {stu ->
            studentTextView.append("${stu.no} || ${stu.name} || ${stu.pass} \n")
        }
    }
}