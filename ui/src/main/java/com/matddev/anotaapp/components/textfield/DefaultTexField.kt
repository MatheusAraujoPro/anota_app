package com.matddev.anotaapp.components.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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

@Composable
fun DefaultTextField(
    onChange: (String) -> Unit,
    textValue: String,
    modifier: Modifier,
    hint: String
) {
    TextField(
        value = textValue,
        modifier = modifier
            .border(width = 1.dp, color = colors.text, shape = RoundedCornerShape(6.dp)),
        label = {
            Text(
                text = hint,
                style = Theme.typography.bodySm,
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        textStyle = Theme.typography.body.copy(
            textAlign = TextAlign.Start
        ),
        onValueChange = { value ->
            onChange.invoke(value)
        }
    )
}