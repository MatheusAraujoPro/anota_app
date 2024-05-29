package com.matddev.anotaapp.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

object Theme {
    val colors: ThemeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: ThemeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val spaces: ThemeSpaces
        @Composable
        @ReadOnlyComposable
        get() = LocalSpaces.current
}

fun lightColors() = ThemeColors(
    primary = Color(0xFF8DECB4),
    text = Color(0xFF000000),
    background = Color(0xFFF5F5F5),
    backgroundComponent = Color(0xFFFFEEA9),
    success = Color(0xFF2ECC71),
    error = Color(0xFFE74C3C),
    isLight = true,
)

fun darkColors() = ThemeColors(
    primary = Color(0xFF141E46),
    text = Color(0xFFFFFFFF),
    background = Color(0xFF151515),
    backgroundComponent = Color(0xFFFFEEA9),
    success = Color(0xFF41B06E),
    error = Color(0xFFC73659),
    isLight = false,
)