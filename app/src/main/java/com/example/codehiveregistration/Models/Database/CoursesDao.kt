package com.example.codehiveregistration.Models.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.codehiveregistration.Models.Course
import com.example.codehiveregistration.Models.CourseResponse

@Dao
interface CoursesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course:Course)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourses(vararg course:Course)

    @Query("SELECT * FROM courses")
    fun getCourses():LiveData<Course>
    abstract fun insertCourse(course: CourseResponse)
}