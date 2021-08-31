package com.example.codehiveregistration.Repository

import com.example.codehiveregistration.Api.ApiClient
import com.example.codehiveregistration.Api.ApiInterface
import com.example.codehiveregistration.Models.Course
import com.example.codehiveregistration.Models.CourseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CourseRepository {
    val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun fetchCourses(accessToken: String): Response<List<CourseResponse>> =
        withContext(Dispatchers.IO) {
            return@withContext retrofit.fetchCourses(accessToken)
        }
}
