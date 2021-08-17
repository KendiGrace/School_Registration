package com.example.codehiveregistration.Models

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    var name:String,
    @SerializedName("phone_number") var phone:String,
    @SerializedName("Date_of_birth") var Dob:String,
    var nationality:String,
    var email:String,
    var password:String,

)