package com.example.percobaan_6.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.percobaan_6.ui.components.Hairline
import com.example.percobaan_6.ui.components.Page
import com.example.percobaan_6.ui.components.PageGutter
import com.example.percobaan_6.ui.components.PageHeader
import com.example.percobaan_6.ui.components.SectionLabel
import com.example.percobaan_6.ui.components.Tag
import com.example.percobaan_6.ui.theme.Percobaan_6Theme

private val features = listOf(
    "Daftar mahasiswa" to "Diambil dari repository lewat HomeViewModel.",
    "Halaman detail" to "Menerima argumen studentId dari rute navigasi.",
    "State terpusat" to "Setiap screen membaca UiState dari ViewModel-nya.",
    "Navigasi" to "Empat tujuan dalam satu NavHost."
)

private val techStack = listOf(
    "Kotlin", "Jetpack Compose", "Material 3", "Navigation Compose", "ViewModel"
)

@Composable
fun AboutScreen(onBack: () -> Unit) {
    Page {
        PageHeader(
            kicker = "Tentang aplikasi",
            title = "Navigation\nLab",
            onBack = onBack
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Aplikasi praktikum untuk latihan berpindah antar layar dengan Navigation Compose.",
            style = MaterialTheme.typography.headlineSmall.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = PageGutter)
        )
        Spacer(Modifier.height(36.dp))

        SectionLabel("Isi")
        Spacer(Modifier.height(4.dp))
        features.forEachIndexed { index, (title, description) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = PageGutter, vertical = 16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = (index + 1).toString().padStart(2, '0'),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier
                        .width(40.dp)
                        .padding(top = 2.dp)
                )
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Hairline()
        }
        Spacer(Modifier.height(36.dp))

        SectionLabel("Dibangun dengan")
        Spacer(Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.padding(horizontal = PageGutter),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            techStack.forEach { Tag(text = it) }
        }
        Spacer(Modifier.height(40.dp))

        SectionLabel("Kolofon")
        Spacer(Modifier.height(16.dp))
        Column(
            modifier = Modifier.padding(horizontal = PageGutter),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "Disusun oleh Muhammad Zaid Robbani",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "NIM 245150207111012\nPAPB · FILKOM UB · 2026",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutScreenPreview() {
    Percobaan_6Theme {
        AboutScreen(onBack = {})
    }
}
