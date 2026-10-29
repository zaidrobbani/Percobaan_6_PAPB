package com.example.percobaan_6.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Satu baris pasangan label dan nilai, seperti kolom di buku induk. */
@Composable
fun FieldRow(label: String, value: String, mono: Boolean = false) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PageGutter, vertical = 14.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = label.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .width(118.dp)
                    .padding(top = 4.dp)
            )
            Text(
                text = value,
                style = if (mono) {
                    MaterialTheme.typography.labelLarge.copy(fontSize = 15.sp, letterSpacing = 0.5.sp)
                } else {
                    MaterialTheme.typography.bodyLarge
                },
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.weight(1f)
            )
        }
        Hairline()
    }
}
