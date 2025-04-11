package com.example.o2input

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.o2input.ui.theme.LocalColors
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

                var input by remember { mutableStateOf("") }
                var errorInput by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                Scaffold(
                    containerColor = LocalColors.current.surfaceXLow,
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(
                                horizontal = LocalSpacing.current.m,
                                vertical = LocalSpacing.current.xs
                            ),
                        verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.m)
                    ) {
                        InputView(
                            value = input,
                            onValueChange = {
                                input = it
                            },
                            label = "Input",
                            placeholder = "Placeholder"
                        )

                        InputView(
                            value = errorInput,
                            onValueChange = {
                                errorInput = it
                            },
                            isError = true,
                            label = "Error Input",
                            placeholder = "Placeholder"
                        )

                        PasswordInput(
                            password = password,
                            label = stringResource(R.string.password_title),
                            onPasswordChange = {
                                password = it
                            }
                        )
                    }
                }
            }
        }
    }
}