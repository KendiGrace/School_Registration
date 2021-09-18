package com.example.codehiveregistration.Api

<<<<<<< HEAD
import com.example.codehiveregistration.Models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest): Response<RegistrationResponse>

    @POST("/students/login")
    suspend fun studentLogin(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("/courses")
    suspend fun fetchCourses(@Header("Authorization") token: String): Response<List<CourseResponse>>
=======
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.Models.LoginResponse
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register/")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest): Response<RegistrationResponse>

    @POST("/students/login/")
    suspend fun studentLogin(@Body loginRequest: LoginRequest):Response<LoginResponse>
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
}
