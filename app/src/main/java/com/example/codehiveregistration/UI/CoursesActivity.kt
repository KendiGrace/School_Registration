package com.example.codehiveregistration.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.Models.Course
import com.example.codehiveregistration.Models.CoursesrvAdapter
import com.example.codehiveregistration.R

class CoursesActivity : AppCompatActivity() {
    lateinit var rvCourse:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        displayCourses()

    }
    fun displayCourses() {
        var coursesList = listOf(
            Course(
                "Front-end Development",
                "JavaScript for building websites",
                "FrontEnd101",
                "Purity Maina"
            ),
            Course("IOT", "Internet of Things", "IOT101", "Barre Yasin"),
            Course(
                "Mobile Development",
                "Introduction to Android Development",
                "android101",
                "John Owuor"
            ),
            Course("Back-end Development", "Server-side using Python", "Python101", "James Mwai"),
            Course("Start-up ", "Entrepreneurship", "Start-up101", "Kelly Gatwiri"),
            Course("UX Development", "HTML,CSS", "Developer101", "Wendy Orengo"),
            Course("UI/UX Design", "Human-centered Design", "Design01", "Eric Asiago"),
            Course("UX Research", "Design Thinking Process", "Research101", "Joy Taracha")
        )
        rvCourse=findViewById(R.id.rvCourses)
        var coursesAdapter=CoursesrvAdapter(coursesList,baseContext)
        rvCourse.apply {
            layoutManager=LinearLayoutManager(baseContext)
            rvCourse.adapter=coursesAdapter
        }

    }
}