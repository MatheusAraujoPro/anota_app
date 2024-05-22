package com.matddev.anotaapp.theme

import androidx.compose.runtime.staticCompositionLocalOf

val LocalColors = staticCompositionLocalOf { lightColors() }
val LocalTypography = staticCompositionLocalOf { ThemeTypography() }
val LocalSpaces = staticCompositionLocalOf { ThemeSpaces() }