package com.codingacademy.test

import android.app.Application

class StudentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Repository.initialize(this)
    }
}