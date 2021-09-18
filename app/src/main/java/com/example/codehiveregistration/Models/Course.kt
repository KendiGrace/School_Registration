package com.example.codehiveregistration.Models

<<<<<<< HEAD
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
=======
data class Course(
    var courseName:String,
    var courseDescription:String,
    var courseId:String,
>>>>>>> 518a6c6497410ad8711186edd2ce4f0cdca4f3b7
    var courseTrainer:String
)
