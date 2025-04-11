package com.example.o2input

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.o2input.ui.theme.LocalCustomColorsPalette
import com.example.o2input.ui.theme.LocalSpacing
import com.example.o2input.ui.theme.O2InputTheme
import com.example.o2input.ui.widget.InputView
import com.example.o2input.ui.widget.PasswordInput

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            O2InputTheme {

                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                Scaffold(
                    containerColor = LocalCustomColorsPalette.current.surfaceXLow,
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                    ) {
                        InputView(
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            label = "Input",
                            placeholder = "Placeholder"
                        )

                        Spacer(modifier = Modifier.height(LocalSpacing.current.m))

                        PasswordInput(
                            password = password,
                            label = stringResource(R.string.password_title),
                            onValueChange = {
                                password = it
                            }
                        )
                    }
                }
            }
        }
    }
}