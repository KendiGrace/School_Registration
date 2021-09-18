package com.example.codehiveregistration.UI

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



