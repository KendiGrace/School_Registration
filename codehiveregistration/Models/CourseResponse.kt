package com.example.codehiveregistration.Models

data class CourseResponse(
    var date_created: String,
    var date_updated: String,
    var created_by: String,
    var active: Boolean,
    var update_by: String,
    var course_id: String,
    var course_name: String,
    var course_code: String,
    var description: String,
    var instructor: String

)
