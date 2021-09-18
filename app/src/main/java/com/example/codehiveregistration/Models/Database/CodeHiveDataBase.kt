package com.example.codehiveregistration.Models.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.codehiveregistration.Models.Course

@Database(entities = arrayOf(Course::class),version = 1)
abstract class CodeHiveDataBase:RoomDatabase() {
    abstract fun getCoursesDao():CoursesDao

    companion object{
        private var database:CodeHiveDataBase?=null

        fun getDataBase(context: Context):CodeHiveDataBase{
            if(database==null){
                database= Room.databaseBuilder(context,CodeHiveDataBase::class.java,"codeive_db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as CodeHiveDataBase
        }

    }
}