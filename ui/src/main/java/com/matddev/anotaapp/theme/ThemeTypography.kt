package com.matddev.anotaapp.theme


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.matddev.anotaapp.ui.R

val fonts = FontFamily(
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_regular, weight = FontWeight.Normal)
)

data class ThemeTypography(
    val title: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp
    )
)


