package com.example.percobaan_6.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// primary = tinta (tombol, progress), tertiary = aksen vermilion yang dipakai seperlunya
private val DarkColorScheme = darkColorScheme(
    primary = Bone,
    onPrimary = Night,
    tertiary = VermilionLight,
    onTertiary = Night,
    background = Night,
    onBackground = Bone,
    surface = Night,
    onSurface = Bone,
    surfaceVariant = NightRaised,
    onSurfaceVariant = BoneMuted,
    outline = BoneMuted,
    outlineVariant = RuleDark
)

private val LightColorScheme = lightColorScheme(
    primary = Ink,
    onPrimary = Paper,
    tertiary = Vermilion,
    onTertiary = Paper,
    background = Paper,
    onBackground = Ink,
    surface = Paper,
    onSurface = Ink,
    surfaceVariant = PaperRaised,
    onSurfaceVariant = InkMuted,
    outline = InkMuted,
    outlineVariant = Rule
)

@Composable
fun Percobaan_6Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}
