package com.example.codehiveregistration.UI

<<<<<<< HEAD
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.Models.Constants
import com.example.codehiveregistration.Models.CoursesAdapter
import com.example.codehiveregistration.ViewModels.CourseViewModel
import com.example.codehiveregistration.ViewModels.UserViewModel
import com.example.codehiveregistration.databinding.ActivityCoursesBinding

class CoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoursesBinding
    val CourseViewModel: CourseViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences
    lateinit var rvCourses: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        sharedPreferences = getSharedPreferences(Constants.Prefs_File, Context.MODE_PRIVATE)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
    }

    override fun onResume() {
        super.onResume()
        CourseViewModel.getDBCourses()
        CourseViewModel.coursesResponseLiveData.observe(this{
            courses
        })

        var accessToken = sharedPreferences.getString(Constants.toString(), "Access_Token")
        var bearer = "Bearer $accessToken"
        if (accessToken!!.isNotEmpty()) {
            CourseViewModel.fetchCourses(accessToken)
        } else {
            startActivity(Intent(baseContext, LoginActivity::class.java))
        }
        var rvCoursesResponseAdapter = binding.rvCourses
        rvCoursesResponseAdapter.layoutManager = LinearLayoutManager(baseContext)
        CourseViewModel.coursesResponseLiveData.observe(this, { coursesList ->

            var coursesResponseAdapter = CoursesAdapter(coursesList)
            rvCoursesResponseAdapter.adapter = coursesResponseAdapter
            Toast.makeText(baseContext, "${coursesList.size} courses fetched", Toast.LENGTH_LONG)
                .show()
        })
        CourseViewModel.courseserrorData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })

    }
}



=======
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
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
