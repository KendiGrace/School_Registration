package com.example.codehiveregistration.Repository

import com.example.codehiveregistration.Api.ApiClient
import com.example.codehiveregistration.Api.ApiInterface
<<<<<<< HEAD
import com.example.codehiveregistration.Models.*
=======
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.Models.LoginResponse
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

    class UserRepository {
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
<<<<<<< HEAD
        suspend fun registerStudent(registrationRequest: RegistrationRequest): Response<RegistrationResponse> =
=======
        suspend fun registerStudent(registrationRequest: RegistrationRequest):
                Response<RegistrationResponse> =
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
            withContext(Dispatchers.IO) {
                var response = retrofit.registerStudent(registrationRequest)
                return@withContext response
            }
<<<<<<< HEAD

        suspend fun studentLogin(loginRequest: LoginRequest):
                Response<LoginResponse> =
            withContext(Dispatchers.IO) {
                var response = retrofit.studentLogin(loginRequest)
                return@withContext response
            }

=======
        suspend fun studentLogin(loginRequest: LoginRequest):
                Response<LoginResponse> = withContext(Dispatchers.IO){
            var response=retrofit.studentLogin(loginRequest)
            return@withContext response
        }
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7

    }

