package com.example.percobaan_6.navigation

object routes {
    const val HOME = "home"
    const val PROFILE = "profile"
    const val DETIL = "detil/{studentId}"
    const val ABOUT = "about"

    fun detil(studentid: Int): String = "detil/$studentid"
}

