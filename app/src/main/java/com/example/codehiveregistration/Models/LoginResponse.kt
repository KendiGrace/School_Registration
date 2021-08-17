package com.example.codehiveregistration.Models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var email:String,
    var password:String,
    var message:String,
    @SerializedName("access_token") var accessToken:String,
)
