package com.example.codehiveregistration.Repository

import androidx.lifecycle.LiveData
import com.example.codehiveregistration.Api.ApiClient
import com.example.codehiveregistration.Api.ApiInterface
import com.example.codehiveregistration.CodeHiveRegApplication
import com.example.codehiveregistration.Models.Course
import com.example.codehiveregistration.Models.CourseResponse
import com.example.codehiveregistration.Models.Database.CodeHiveDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CourseRepository {
    val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
    val db=CodeHiveDataBase.getDataBase(CodeHiveRegApplication.appContext)

    suspend fun fetchCourses(accessToken: String)
            = withContext(Dispatchers.IO) {
        var response=retrofit.fetchCourses(accessToken)
        var Dao=db.getCoursesDao()
        response.body()?.forEach { course->
            Dao.insertCourse(course)
        }

        }
    fun getCoursesFromDB(): LiveData<Course> {
        return db.getCoursesDao().getCourses()

    }

}
