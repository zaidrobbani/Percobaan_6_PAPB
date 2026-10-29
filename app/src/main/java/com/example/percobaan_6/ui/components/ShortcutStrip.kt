package com.example.percobaan_6.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/** Tiga pintasan berjajar di Home, dipisah garis vertikal seperti menu koran. */
@Composable
fun ShortcutStrip(
    onOpenDetail: () -> Unit,
    onOpenProfile: () -> Unit,
    onOpenAbout: () -> Unit
) {
    Column {
        Hairline()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PageGutter)
                .height(IntrinsicSize.Min)
        ) {
            ShortcutItem("Detail", "No. 2026", onOpenDetail, Modifier.weight(1f))
            VerticalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            ShortcutItem("Profil", "Penyusun", onOpenProfile, Modifier.weight(1f))
            VerticalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            ShortcutItem("Tentang", "Aplikasi", onOpenAbout, Modifier.weight(1f))
        }
        Hairline()
    }
}
