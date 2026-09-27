package com.example.adaptivestudentlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Custom BaseAdapter for inflating student list items into a ListView.
 */
class StudentAdapter(
    private val context: Context,
    private val students: List<Student>
) : BaseAdapter() {

    override fun getCount(): Int = students.size

    override fun getItem(position: Int): Any = students[position]

    override fun getItemId(position: Int): Long = students[position].id.toLong()

    private class ViewHolder(view: View) {
        val imgProfile: ImageView = view.findViewById(R.id.imgStudentProfile)
        val tvName: TextView = view.findViewById(R.id.tvStudentName)
        val tvUsn: TextView = view.findViewById(R.id.tvStudentUsn)
        val tvCourse: TextView = view.findViewById(R.id.tvStudentCourse)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val student = students[position]

        holder.imgProfile.setImageResource(student.imageResId)
        holder.imgProfile.contentDescription = "Profile picture of ${student.name}"
        holder.tvName.text = student.name
        holder.tvUsn.text = context.getString(R.string.usn_format, student.usn)
        holder.tvCourse.text = context.getString(R.string.course_format, student.course)

        return view
    }
}
