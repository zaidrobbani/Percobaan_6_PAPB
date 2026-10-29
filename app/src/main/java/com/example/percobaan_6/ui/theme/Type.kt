package com.example.percobaan_6.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.percobaan_6.R

// Serif untuk judul, mono untuk label/angka, sans bawaan untuk teks biasa
val DisplaySerif = FontFamily(
    Font(R.font.instrument_serif_regular),
    Font(R.font.instrument_serif_italic, style = FontStyle.Italic)
)

val Mono = FontFamily(
    Font(R.font.plex_mono_regular),
    Font(R.font.plex_mono_medium, FontWeight.Medium)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = DisplaySerif,
        fontSize = 60.sp,
        lineHeight = 58.sp,
        letterSpacing = (-1.2).sp
    ),
    displayMedium = TextStyle(
        fontFamily = DisplaySerif,
        fontSize = 46.sp,
        lineHeight = 46.sp,
        letterSpacing = (-0.8).sp
    ),
    headlineSmall = TextStyle(
        fontFamily = DisplaySerif,
        fontSize = 28.sp,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontFamily = DisplaySerif,
        fontSize = 26.sp,
        lineHeight = 30.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 22.sp
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Mono,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        letterSpacing = 1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Mono,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        letterSpacing = 1.2.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Mono,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 1.2.sp
    )
)
