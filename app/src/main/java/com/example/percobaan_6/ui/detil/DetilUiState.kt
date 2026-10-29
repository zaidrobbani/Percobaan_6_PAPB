package com.example.percobaan_6.ui.detil

import com.example.percobaan_6.data.model.Student

data class DetilUiState(
    val student: Student? = null,
    val isLoading: Boolean = false,
    val isError: String? = null
)