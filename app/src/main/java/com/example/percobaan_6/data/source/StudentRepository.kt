package com.example.percobaan_6.data.source

import com.example.percobaan_6.data.model.Student
import com.example.percobaan_6.data.repository.StudentLocalDataSource

interface StudentRepository {
    fun getStudentById(id: Int): Student?
    fun getStudents(): List<Student>
}

class DefaultStudentRepository (
    private val dataSource: StudentLocalDataSource
) : StudentRepository {
    override fun getStudents(): List<Student> {
        return dataSource.getStudents()
    }

    override fun getStudentById(id: Int): Student? {
        return dataSource.getStudentById(id)
    }
}