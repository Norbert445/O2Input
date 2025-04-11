package com.example.o2input.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = CustomColorsPalette(
    surfaceXHigh = surfaceXHighDark,
    surfaceXLow = surfaceXLowDark,
    surfaceBrand = surfaceBrandDark,
    surfaceDanger = surfaceDangerDark,
    surfaceDangerVariant = surfaceDangerVariantDark,
    surfaceWarning = surfaceWarningDark,
    surfaceWarningVariant = surfaceWarningVariantDark,
    contentOnNeutralXXHigh = contentOnNeutralXXHighDark,
    contentOnNeutralMedium = contentOnNeutralMediumDark,
    contentOnNeutralLow = contentOnNeutralLowDark,
    contentOnNeutralDanger = contentOnNeutralDangerDark,
    contentOnNeutralWarning = contentOnNeutralWarningDark,
    stateDefaultHover = stateDefaultHoverDark,
    stateDefaultFocus = stateDefaultFocusDark
)

private val LightColorScheme = CustomColorsPalette(
    surfaceXHigh = surfaceXHighLight,
    surfaceXLow = surfaceXLowLight,
    surfaceBrand = surfaceBrandLight,
    surfaceDanger = surfaceDangerLight,
    surfaceDangerVariant = surfaceDangerVariantLight,
    surfaceWarning = surfaceWarningLight,
    surfaceWarningVariant = surfaceWarningVariantLight,
    contentOnNeutralXXHigh = contentOnNeutralXXHighLight,
    contentOnNeutralMedium = contentOnNeutralMediumLight,
    contentOnNeutralLow = contentOnNeutralLowLight,
    contentOnNeutralDanger = contentOnNeutralDangerLight,
    contentOnNeutralWarning = contentOnNeutralWarningLight,
    stateDefaultHover = stateDefaultHoverLight,
    stateDefaultFocus = stateDefaultFocusLight
)


private val DarkMaterialColorScheme = darkColorScheme(
    primary = surfaceBrandDark
)

private val LightMaterialColorScheme = lightColorScheme(
    primary = surfaceBrandLight
)

@Composable
fun O2InputTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalSpacing provides Spacing(),
        LocalRadius provides Radius(),
        LocalTypography provides Typography()
    ) {
        MaterialTheme(
            content = content,
            colorScheme = if (darkTheme) DarkMaterialColorScheme else LightMaterialColorScheme
        )
    }
}