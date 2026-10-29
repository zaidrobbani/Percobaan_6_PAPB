package com.example.percobaan_6.ui.home

import com.example.percobaan_6.data.model.Student

data class HomeUiState(
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = false,
    val isError: String? = null
)