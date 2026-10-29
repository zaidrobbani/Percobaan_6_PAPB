package com.example.percobaan_6.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.percobaan_6.data.source.StudentRepository

class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    init {
        loadStudents()
    }

    fun loadStudents() {
        val students = repository.getStudents()
        uiState = if (students.isNotEmpty()) {
            HomeUiState(students = students)
        } else {
            HomeUiState(isError = "Belum ada data mahasiswa")
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(repository) as T
                }
            }
    }
}
