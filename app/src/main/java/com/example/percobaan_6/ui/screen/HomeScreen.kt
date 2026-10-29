package com.example.percobaan_6.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.percobaan_6.data.model.Student
import com.example.percobaan_6.ui.components.Notice
import com.example.percobaan_6.ui.components.PageHeader
import com.example.percobaan_6.ui.components.SectionLabel
import com.example.percobaan_6.ui.components.ShortcutStrip
import com.example.percobaan_6.ui.components.StudentRow
import com.example.percobaan_6.ui.home.HomeUiState
import com.example.percobaan_6.ui.theme.Percobaan_6Theme

@Composable
fun HomeScreen(
    onOpenDetail: (Int) -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit,
    uiState: HomeUiState
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        item {
            PageHeader(
                kicker = "Navigation Lab · PAPB",
                title = "Daftar\nMahasiswa",
                lead = "${uiState.students.size} mahasiswa tercatat. Ketuk satu nama untuk membuka arsipnya."
            )
            Spacer(Modifier.height(28.dp))
        }

        item {
            ShortcutStrip(
                onOpenDetail = { onOpenDetail(2026) },
                onOpenProfile = onOpenProfile,
                onOpenAbout = onOpenAbout
            )
            Spacer(Modifier.height(36.dp))
        }

        item {
            SectionLabel("Indeks")
            Spacer(Modifier.height(4.dp))
        }

        when {
            uiState.isLoading -> item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(strokeWidth = 2.dp)
                }
            }

            uiState.isError != null -> item {
                Notice(
                    title = "Indeks kosong",
                    message = uiState.isError,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            else -> itemsIndexed(uiState.students, key = { _, it -> it.id }) { index, student ->
                StudentRow(
                    number = index + 1,
                    student = student,
                    onClick = { onOpenDetail(student.id) }
                )
            }
        }

        item { Spacer(Modifier.navigationBarsPadding()) }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    Percobaan_6Theme {
        HomeScreen(
            onOpenDetail = {},
            onOpenProfile = {},
            onOpenAbout = {},
            uiState = HomeUiState(
                students = listOf(
                    Student(2026, "Alya Putri", "Teknik Informatika", 2026),
                    Student(2027, "Bima Pratama", "Teknik Informatika", 2026),
                    Student(2028, "Citra Lestari", "Teknik Informatika", 2026)
                )
            )
        )
    }
}
