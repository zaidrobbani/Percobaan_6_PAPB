package com.example.percobaan_6.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.percobaan_6.data.model.Student
import com.example.percobaan_6.ui.components.FieldRow
import com.example.percobaan_6.ui.components.InkButton
import com.example.percobaan_6.ui.components.Monogram
import com.example.percobaan_6.ui.components.Notice
import com.example.percobaan_6.ui.components.Page
import com.example.percobaan_6.ui.components.PageGutter
import com.example.percobaan_6.ui.components.PageHeader
import com.example.percobaan_6.ui.components.SectionLabel
import com.example.percobaan_6.ui.detil.DetilUiState
import com.example.percobaan_6.ui.theme.Percobaan_6Theme

@Composable
fun DetilScreen(
    uiState: DetilUiState,
    onBack : () -> Unit
) {
    Page {
        val student = uiState.student

        PageHeader(
            kicker = if (student != null) "Arsip mahasiswa · No. ${student.id}" else "Arsip mahasiswa",
            title = student?.name?.replace(" ", "\n") ?: "Detail",
            onBack = onBack
        )

        when {
            uiState.isLoading -> Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(strokeWidth = 2.dp)
            }

            uiState.isError != null -> {
                Spacer(Modifier.height(32.dp))
                Notice(
                    title = "Data tidak ditemukan",
                    message = "${uiState.isError}. Coba pilih nama lain dari indeks."
                )
            }

            student != null -> {
                Spacer(Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = PageGutter),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = student.program,
                        style = MaterialTheme.typography.headlineSmall.copy(fontStyle = FontStyle.Italic),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.weight(1f)
                    )
                    Monogram(name = student.name, size = 64.dp)
                }
                Spacer(Modifier.height(36.dp))

                SectionLabel("Keterangan")
                Spacer(Modifier.height(4.dp))
                FieldRow(label = "No. Induk", value = student.id.toString(), mono = true)
                FieldRow(label = "Nama lengkap", value = student.name)
                FieldRow(label = "Program studi", value = student.program)
                FieldRow(label = "Angkatan", value = student.year.toString(), mono = true)
            }
        }

        Spacer(Modifier.height(32.dp))
        InkButton(text = "Kembali ke indeks", onClick = onBack)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetilScreenPreview() {
    Percobaan_6Theme {
        DetilScreen(
            uiState = DetilUiState(
                student = Student(2026, "Alya Putri", "Teknik Informatika", 2026)
            ),
            onBack = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetilScreenErrorPreview() {
    Percobaan_6Theme {
        DetilScreen(
            uiState = DetilUiState(isError = "Student tidak ditemukan"),
            onBack = {}
        )
    }
}
