package com.example.o2input.ui.widget

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Input(modifier: Modifier = Modifier) {
    return TextField(
        modifier = modifier,
        value = "",
        onValueChange = {}
    )
}

@Preview
@Composable
fun InputPreview() {
    Input()
}