package com.example.codehiveregistration.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.Models.Course
import com.example.codehiveregistration.Models.CourseResponse
import com.example.codehiveregistration.Repository.CourseRepository
import kotlinx.coroutines.launch

class CourseViewModel : ViewModel() {
    var courseRepository = CourseRepository()
    lateinit var coursesResponseLiveData: LiveData<List<Course>>
    var courseserrorData = MutableLiveData<String>()

    fun fetchCourses(accessToken: String) {
        viewModelScope.launch {
            courseRepository.fetchCourses(accessToken)

        }
    }
    fun getDBCourses(){
        coursesResponseLiveData= courseRepository.getCoursesFromDB()

    }
}