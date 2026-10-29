package com.example.percobaan_6.data.repository;
import com.example.percobaan_6.data.model.Student;

class StudentLocalDataSource {
    private val students = listOf(
        Student(2026, "Alya Putri", "Teknik Informatika", 2026),
        Student(2027, "Bima Pratama", "Teknik Informatika", 2026),
        Student(2028, "Citra Lestari", "Teknik Informatika", 2026)
    )
    fun getStudentById(id: Int): Student? {
        return students.find { it.id == id }
    }
    fun getStudents(): List<Student> = students
}
