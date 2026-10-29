package com.example.percobaan_6.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

/** Kepala halaman ala masthead: tombol kembali, kicker, lalu judul serif besar. */
@Composable
fun PageHeader(
    kicker: String,
    title: String,
    onBack: (() -> Unit)? = null,
    lead: String? = null
) {
    Column(modifier = Modifier.padding(horizontal = PageGutter)) {
        if (onBack != null) {
            Text(
                text = "← KEMBALI",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .clickable(onClick = onBack)
                    .padding(vertical = 10.dp, horizontal = 2.dp)
            )
        }
        Spacer(Modifier.height(if (onBack != null) 20.dp else 32.dp))
        Kicker(kicker)
        Spacer(Modifier.height(10.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        if (lead != null) {
            Spacer(Modifier.height(14.dp))
            Text(
                text = lead,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
