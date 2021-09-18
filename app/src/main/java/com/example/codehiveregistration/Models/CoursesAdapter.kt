package com.example.codehiveregistration.Models

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.R
import com.example.studentregistration.models.CourseResponse

class CoursesAdapter(var courseResponse: List<CourseResponse>) :RecyclerView.Adapter<CoursesResponseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesResponseViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.coourse_list, parent, false)
        return CoursesResponseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesResponseViewHolder, position: Int) {
        var courseList = courseResponse[position]
        holder.tvCoursename.text = courseList.course_name
        holder.tvCourseCode.text = courseList.course_code
        holder.tvCourseDescription.text = courseList.description
        holder.tvInstructor.text = courseList.instructor

    }

    override fun getItemCount(): Int {
        return courseResponse.size
    }
}

class CoursesResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvCoursename = itemView.findViewById<TextView>(R.id.tvCoursename)
    var tvCourseCode = itemView.findViewById<TextView>(R.id.tvCourseCode)
    var tvCourseDescription = itemView.findViewById<TextView>(R.id.tvCourseDescription)
    var tvInstructor = itemView.findViewById<TextView>(R.id.tvInstructor)

}