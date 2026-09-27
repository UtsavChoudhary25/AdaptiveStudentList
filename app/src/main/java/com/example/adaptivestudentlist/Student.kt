package com.example.adaptivestudentlist

/**
 * Data class representing a student entry in the directory.
 */
data class Student(
    val id: Int,
    val name: String,
    val usn: String,
    val course: String,
    val imageResId: Int,
    val email: String = "",
    val year: String = "1st Year"
)
