package com.example.o2input

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.o2input.ui.theme.O2InputTheme
import com.example.o2input.ui.widget.Input

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            O2InputTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Input(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}