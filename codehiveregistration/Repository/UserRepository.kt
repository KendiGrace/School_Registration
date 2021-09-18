package com.example.codehiveregistration.Repository

import com.example.codehiveregistration.Api.ApiClient
import com.example.codehiveregistration.Api.ApiInterface
import com.example.codehiveregistration.Models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

    class UserRepository {
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        suspend fun registerStudent(registrationRequest: RegistrationRequest): Response<RegistrationResponse> =
            withContext(Dispatchers.IO) {
                var response = retrofit.registerStudent(registrationRequest)
                return@withContext response
            }

        suspend fun studentLogin(loginRequest: LoginRequest):
                Response<LoginResponse> =
            withContext(Dispatchers.IO) {
                var response = retrofit.studentLogin(loginRequest)
                return@withContext response
            }


    }

