package com.example.o2input.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorsPalette(
    // surface colors
    val surfaceXHigh: Color = Color.Unspecified,
    val surfaceXLow: Color = Color.Unspecified,
    val surfaceBrand: Color = Color.Unspecified,
    val surfaceDanger: Color = Color.Unspecified,
    val surfaceDangerVariant: Color = Color.Unspecified,
    val surfaceWarning: Color = Color.Unspecified,
    val surfaceWarningVariant: Color = Color.Unspecified,

    // content colors
    val contentOnNeutralXXHigh: Color = Color.Unspecified,
    val contentOnNeutralMedium: Color = Color.Unspecified,
    val contentOnNeutralLow: Color = Color.Unspecified,
    val contentOnNeutralDanger: Color = Color.Unspecified,
    val contentOnNeutralWarning: Color = Color.Unspecified,

    // state colors
    val stateDefaultHover: Color = Color.Unspecified,
    val stateDefaultFocus: Color = Color.Unspecified
)

val LocalColors = staticCompositionLocalOf { CustomColorsPalette() }