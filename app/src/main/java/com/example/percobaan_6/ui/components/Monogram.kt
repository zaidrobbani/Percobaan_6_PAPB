package com.example.percobaan_6.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.percobaan_6.ui.theme.DisplaySerif

/** Inisial nama dalam kotak bergaris, ditulis serif miring. */
@Composable
fun Monogram(
    name: String,
    modifier: Modifier = Modifier,
    size: Dp = 56.dp
) {
    val initials = name.split(" ")
        .filter { it.isNotBlank() }
        .take(2)
        .joinToString("") { it.first().uppercase() }

    Box(
        modifier = modifier
            .size(size)
            .border(1.dp, MaterialTheme.colorScheme.onBackground, RoundedCornerShape(2.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            fontFamily = DisplaySerif,
            fontStyle = FontStyle.Italic,
            fontSize = (size.value * 0.44f).sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
