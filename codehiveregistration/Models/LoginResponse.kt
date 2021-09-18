package com.example.codehiveregistration.Models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var message:String,
    @SerializedName("access_token") var accessToken:String,
    @SerializedName("student_id") var studentId: String
)
