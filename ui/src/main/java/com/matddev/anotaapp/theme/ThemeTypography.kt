package com.matddev.anotaapp.theme


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class ThemeTypography(
   val title: TextStyle = TextStyle(
       fontFamily = FontFamily.SansSerif,
       fontWeight = FontWeight.Bold,
       fontSize = 24.sp
   ),
   val body: TextStyle = TextStyle(
       fontFamily = FontFamily.SansSerif,
       fontWeight = FontWeight.Light,
       fontSize = 16.sp
   )
)


