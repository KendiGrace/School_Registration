package com.example.codehiveregistration

import android.app.Application
import android.content.Context

class CodeHiveRegApplication: Application() {
    companion object{
        lateinit var appContext:Context
    }
    override fun onCreate(){
        super.onCreate()
        appContext=applicationContext
    }
}