package com.example.codehiveregistration.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
<<<<<<< HEAD
import com.example.codehiveregistration.Models.*
=======
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.Models.LoginResponse
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
import com.example.codehiveregistration.Repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
        var userRepository= UserRepository()
        var registrationResponseLiveData= MutableLiveData<RegistrationResponse>()
        var regErrorLiveData=MutableLiveData<String>()
        var loginResponseLiveData=MutableLiveData<LoginResponse>()
        var logErrorLiveData=MutableLiveData<String>()
<<<<<<< HEAD
    fun registerStudent(registrationRequest: RegistrationRequest) {
        viewModelScope.launch {
            var response = userRepository.registerStudent(registrationRequest)
            if (response.isSuccessful) {
                registrationResponseLiveData.postValue(response.body())
            } else {
                regErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
=======
        fun registerStudent(registrationRequest: RegistrationRequest){
            viewModelScope.launch {
                var response=userRepository.registerStudent(registrationRequest)
                if (response.isSuccessful){
                    registrationResponseLiveData.postValue(response.body())
                }
                else{
                    regErrorLiveData.postValue(response.errorBody()?.string())
                }
            }
        }
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
        fun studentLogin(loginRequest: LoginRequest){
            viewModelScope.launch {
                var response=userRepository.studentLogin(loginRequest)
                if (response.isSuccessful){
                    loginResponseLiveData.postValue(response.body())
                }
                else{
                    logErrorLiveData.postValue(response.errorBody()?.string())
                }
            }
        }
<<<<<<< HEAD

}

=======
    }
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7

