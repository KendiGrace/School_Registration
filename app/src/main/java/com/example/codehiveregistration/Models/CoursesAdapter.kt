package com.example.codehiveregistration.Models

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.R

class CoursesAdapter(var courseResponse: List<CourseResponse>) :
    RecyclerView.Adapter<CoursesResponseViewHolder>() {

    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesResponseViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.coourse_list, parent, false)
        return CoursesResponseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesResponseViewHolder, position: Int) {
        var courseList = courseResponse[position]
        holder.tvDateCreated.text = courseList.date_created
        holder.tvDateUpdated.text = courseList.date_updated
        holder.tvUpdatedBy.text = courseList.update_by
        holder.tvCourseId.text = courseList.course_id
        holder.tvCoursename.text = courseList.course_name
        holder.tvCourseCode.text = courseList.course_code
        holder.tvCourseDescription.text = courseList.description
        holder.tvCreatedBy.text = courseList.created_by
        holder.tvActive.text = courseList.active.toString()
        holder.tvInstructor.text = courseList.instructor

    }

    override fun getItemCount(): Int {
        return courseResponse.size
    }
}

class CoursesResponseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvDateCreated = itemView.findViewById<TextView>(R.id.tvDateCreated)
    var tvDateUpdated = itemView.findViewById<TextView>(R.id.tvDateUpdated)
    var tvUpdatedBy = itemView.findViewById<TextView>(R.id.tvUpdatedBy)
    var tvCourseId = itemView.findViewById<TextView>(R.id.tvCourseId)
    var tvCoursename = itemView.findViewById<TextView>(R.id.tvCoursename)
    var tvCourseCode = itemView.findViewById<TextView>(R.id.tvCourseCode)
    var tvCourseDescription = itemView.findViewById<TextView>(R.id.tvCourseDescription)
    var tvCreatedBy = itemView.findViewById<TextView>(R.id.tvCreatedBy)
    var tvActive = itemView.findViewById<TextView>(R.id.tvActive)
    var tvInstructor = itemView.findViewById<TextView>(R.id.tvInstructor)

}