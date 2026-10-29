package com.example.percobaan_6.ui.detil

import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.percobaan_6.data.model.Student
import com.example.percobaan_6.data.source.StudentRepository

class DetilViewModel(
    private val repository: StudentRepository
): ViewModel() {
    var uiState by mutableStateOf(DetilUiState())
        private set

    fun loadStudent(id: Int) {
        val student = repository.getStudentById(id)
        uiState = if (student != null) {
            DetilUiState(student = student)
        } else {
            DetilUiState(isError = "Student tidak ditemukan")
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory {
            return object: ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return DetilViewModel(repository) as T
                }
            }
        }
    }
}