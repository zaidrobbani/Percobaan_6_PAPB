package com.example.percobaan_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.percobaan_6.navigation.NavigationLabApp
import com.example.percobaan_6.ui.theme.Percobaan_6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Warna icon status bar mengikuti tema terang/gelap
        enableEdgeToEdge()
        setContent {
            Percobaan_6Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Tiap screen mengatur inset sendiri supaya header gradien bisa sampai ke status bar
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavigationLabApp()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    Percobaan_6Theme {
        MainScreen()
    }
}
