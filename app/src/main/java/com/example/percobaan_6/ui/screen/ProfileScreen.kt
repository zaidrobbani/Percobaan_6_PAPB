package com.example.percobaan_6.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.percobaan_6.ui.components.FieldRow
import com.example.percobaan_6.ui.components.Monogram
import com.example.percobaan_6.ui.components.Page
import com.example.percobaan_6.ui.components.PageGutter
import com.example.percobaan_6.ui.components.PageHeader
import com.example.percobaan_6.ui.components.SectionLabel
import com.example.percobaan_6.ui.theme.Percobaan_6Theme

@Composable
fun ProfileScreen(
    onBack: () -> Unit
) {
    Page {
        PageHeader(
            kicker = "Profil penyusun",
            title = "Muhammad\nZaid Robbani",
            onBack = onBack
        )
        Spacer(Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PageGutter),
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "NIM",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "245150207111012",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 20.sp, letterSpacing = 1.5.sp),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Monogram(name = "Zaid Robbani", size = 64.dp)
        }
        Spacer(Modifier.height(36.dp))

        SectionLabel("Akademik")
        Spacer(Modifier.height(4.dp))
        FieldRow(label = "Fakultas", value = "Fakultas Ilmu Komputer, Universitas Brawijaya")
        FieldRow(label = "Mata kuliah", value = "Pemrograman Aplikasi Perangkat Bergerak")
        FieldRow(label = "Praktikum", value = "Navigation Compose Lab")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    Percobaan_6Theme {
        ProfileScreen(onBack = {})
    }
}
