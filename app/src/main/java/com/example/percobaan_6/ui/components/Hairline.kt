package com.example.percobaan_6.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Garis pemisah tipis selebar konten halaman. */
@Composable
fun Hairline(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier.padding(horizontal = PageGutter),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.outlineVariant
    )
}
