package com.example.adaptivestudentlist

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imgDetailProfile: ImageView
    private lateinit var tvDetailName: TextView
    private lateinit var tvDetailUsn: TextView
    private lateinit var tvDetailCourse: TextView
    private lateinit var lvStudents: ListView

    private lateinit var studentList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        imgDetailProfile = findViewById(R.id.imgDetailProfile)
        tvDetailName = findViewById(R.id.tvDetailName)
        tvDetailUsn = findViewById(R.id.tvDetailUsn)
        tvDetailCourse = findViewById(R.id.tvDetailCourse)
        lvStudents = findViewById(R.id.lvStudents)

        // Initialize student dataset
        studentList = listOf(
            Student(
                id = 1,
                name = "Utsav Choudhary",
                usn = "25MCAR0125",
                course = "MCA",
                imageResId = R.drawable.ic_student_1,
                email = "utsav.choudhary@example.com",
                year = "1st Year"
            ),
            Student(
                id = 2,
                name = "Ananya Sharma",
                usn = "25MCAR0102",
                course = "MCA",
                imageResId = R.drawable.ic_student_2,
                email = "ananya.sharma@example.com",
                year = "1st Year"
            ),
            Student(
                id = 3,
                name = "Rahul Verma",
                usn = "25MCAR0115",
                course = "MCA",
                imageResId = R.drawable.ic_student_3,
                email = "rahul.verma@example.com",
                year = "1st Year"
            ),
            Student(
                id = 4,
                name = "Priya Nair",
                usn = "25MCAR0134",
                course = "MCA",
                imageResId = R.drawable.ic_student_4,
                email = "priya.nair@example.com",
                year = "1st Year"
            ),
            Student(
                id = 5,
                name = "Rohan Patel",
                usn = "25MCAR0148",
                course = "MCA",
                imageResId = R.drawable.ic_student_5,
                email = "rohan.patel@example.com",
                year = "1st Year"
            )
        )

        // Set custom adapter
        val adapter = StudentAdapter(this, studentList)
        lvStudents.adapter = adapter

        // Display default student (Utsav Choudhary) on launch
        displayStudentDetails(studentList[0])

        // Handle item click events
        lvStudents.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedStudent = studentList[position]
            displayStudentDetails(selectedStudent)

            val toastMessage = getString(R.string.toast_selected, selectedStudent.name)
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayStudentDetails(student: Student) {
        imgDetailProfile.setImageResource(student.imageResId)
        imgDetailProfile.contentDescription = "Profile picture of ${student.name}"
        tvDetailName.text = student.name
        tvDetailUsn.text = getString(R.string.usn_format, student.usn)
        tvDetailCourse.text = getString(R.string.course_format, student.course)
    }
}
