package com.example.o2input

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.o2input.ui.theme.LocalCustomColorsPalette
import com.example.o2input.ui.theme.O2InputTheme
import com.example.o2input.ui.widget.InputView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            O2InputTheme {
                Scaffold(
                    containerColor = LocalCustomColorsPalette.current.surfaceXLow,
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    InputView(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.padding(innerPadding),
                        label = "Input",
                        placeholder = "Placeholder"
                    )
                }
            }
        }
    }
}