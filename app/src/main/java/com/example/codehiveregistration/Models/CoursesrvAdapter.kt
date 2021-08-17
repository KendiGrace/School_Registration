package com.example.codehiveregistration.Models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.R

class CoursesrvAdapter(var courseList:List<Course>,var context:Context):RecyclerView.Adapter<CourseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
   var itemView=LayoutInflater.from(parent.context).inflate(R.layout.coourse_lists,parent,false)
        return CourseViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
   var currentCourse=courseList.get(position)
        holder.name.text=currentCourse.courseName
        holder.description.text=currentCourse.courseDescription
        holder.id.text=currentCourse.courseId
        holder.trainer.text=currentCourse.courseTrainer
    }

    override fun getItemCount(): Int {
   return courseList.size
    }


}
class CourseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var name=itemView.findViewById<TextView>(R.id.tvCourseName)
    var description=itemView.findViewById<TextView>(R.id.tvCourseDescription)
    var trainer=itemView.findViewById<TextView>(R.id.tvTrainer)
    var id=itemView.findViewById<TextView>(R.id.tvCourseId)



}