package com.matddev.anotaapp.components.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.matddev.anotaapp.theme.Theme
import com.matddev.anotaapp.theme.Theme.colors

@Composable
fun DefaultTextField(
    onChange: (String) -> Unit,
    type: KeyboardType,
    modifier: Modifier,
    textValue: String,
    textAlign: TextAlign
) {
    TextField(
        value = textValue,
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colors.backgroundComponent,
            unfocusedContainerColor = colors.backgroundComponent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = type
        ),
        textStyle = Theme.typography.body.copy(
            textAlign = textAlign
        ),
        onValueChange = { value ->
            onChange.invoke(value)
        }
    )
}