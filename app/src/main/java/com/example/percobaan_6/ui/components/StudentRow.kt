package com.example.percobaan_6.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import com.example.percobaan_6.data.model.Student

/** Item indeks mahasiswa di Home: nomor urut, nama serif, dan nomor induk. */
@Composable
fun StudentRow(
    number: Int,
    student: Student,
    onClick: () -> Unit
) {
    Column(modifier = Modifier.clickable(onClick = onClick)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PageGutter, vertical = 20.dp),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = number.toString().padStart(2, '0'),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier
                    .width(40.dp)
                    .padding(top = 8.dp)
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = student.name,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 30.sp, lineHeight = 34.sp),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "${student.program} · Angkatan ${student.year}".uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(top = 8.dp, start = 12.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "#${student.id}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "→",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
        Hairline()
    }
}
