package com.example.codehiveregistration.Models

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
<<<<<<< HEAD
    var name: String,
    @SerializedName("phone_number") var phone: String,
    @SerializedName("date_of_birth") var Dob: String,
    var nationality: String,
    var email: String,
    var password: String,
    @SerializedName("student_id") var studentId: String
=======
    var name:String,
    @SerializedName("phone_number") var phone:String,
    @SerializedName("Date_of_birth") var Dob:String,
    var nationality:String,
    var email:String,
    var password:String,
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7

)