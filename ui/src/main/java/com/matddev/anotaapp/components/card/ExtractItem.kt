package com.matddev.anotaapp.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Badge
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matddev.anotaapp.theme.Theme
import com.matddev.anotaapp.theme.Theme.colors


@Composable
fun ExtractItem(description: String, value: String) {
    Content(description, value)
}

@Composable
fun Description(text: String) {
    Text(
        text = text,
        style = Theme.typography.body.copy(
            color = colors.text
        )
    )
}

@Composable
fun Value(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = Theme.typography.body.copy(
                color = colors.text
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        ReliefSurface()
    }
}

@Composable
fun Content(
    description: String,
    value: String
) {
    Column(
        modifier = Modifier
            .background(color = colors.backgroundComponent)
            .fillMaxWidth()
            .padding(start = 14.dp, top = 14.dp, bottom = 14.dp, end = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Description(
                text = description,
            )
            Value(
                text = value
            )
        }
    }
}


@Composable
fun ReliefSurface() {
    Column(
        modifier = Modifier
            .background(color = colors.backgroundComponent),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(3) {
            Badge(
                containerColor = Color.Black.copy(alpha = 0.1f)
            )
        }
    }
}

@Composable
@Preview
fun CardPreview() {
    val list = mutableListOf(1, 2, 3)
    Surface {
        LazyColumn {
            items(list) {
                ExtractItem(
                    description = "Valmir Lanches",
                    value = "R$ 25,00"
                )
            }
        }
    }
}