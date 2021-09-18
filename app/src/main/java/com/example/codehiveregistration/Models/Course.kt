package com.example.codehiveregistration.Models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Courses")
data class Course(
    @PrimaryKey @NonNull @SerializedName("course_id") var courseId:String,
    @PrimaryKey @NonNull @SerializedName("course_name")var courseName:String,
    @PrimaryKey @NonNull @SerializedName("course_code")var courseCode:String,
    var courseDescription:String,
    var courseTrainer:String
)
