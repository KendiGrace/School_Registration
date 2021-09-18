package com.example.codehiveregistration.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.Models.CourseResponse
import com.example.codehiveregistration.Repository.CourseRepository
import kotlinx.coroutines.launch

class CourseViewModel : ViewModel() {
    var courseRepository = CourseRepository()
    var coursesResponseLiveData = MutableLiveData<List<CourseResponse>>()
    var courseserrorData = MutableLiveData<String>()

    fun fetchCourses(accessToken: String) {
        viewModelScope.launch {
            var response = courseRepository.fetchCourses(accessToken)
            if (response.isSuccessful) {
                coursesResponseLiveData.postValue(response.body())
            } else {
                courseserrorData.postValue(response.errorBody()?.string())
            }
        }
    }
}