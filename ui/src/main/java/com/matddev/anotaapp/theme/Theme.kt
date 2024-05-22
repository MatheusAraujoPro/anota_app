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
    primary = Color(0xFFE67E22),
    text = Color(0xFF000000),
    background = Color(0xFFF5F5F5),
    success = Color(0xFF2ECC71),
    error = Color(0xFFE74C3C),
    isLight = true,
)

fun darkColors() = ThemeColors(
    primary = Color(0xFFDF6900),
    text = Color(0xFFFFFFFF),
    background = Color(0xFF353B48),
    success = Color(0xFF44BD32),
    error = Color(0xFFC23616),
    isLight = false,
)