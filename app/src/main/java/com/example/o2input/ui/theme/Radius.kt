package com.example.o2input.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Radius(
    val input: Dp = 12.dp
)

val LocalRadius = compositionLocalOf { Radius() }