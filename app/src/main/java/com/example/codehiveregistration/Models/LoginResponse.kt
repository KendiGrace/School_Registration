package com.example.codehiveregistration.Models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
<<<<<<< HEAD
    var message:String,
    @SerializedName("access_token") var accessToken:String,
    @SerializedName("student_id") var studentId: String
=======
    var email:String,
    var password:String,
    var message:String,
    @SerializedName("access_token") var accessToken:String,
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
)
