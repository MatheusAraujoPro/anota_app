package com.matddev.file_manager.screens.create_files

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matddev.anotaapp.components.textfield.DefaultTextField
import com.matddev.anotaapp.theme.Theme
import com.matddev.anotaapp.theme.Theme.colors
import org.koin.androidx.compose.getViewModel


@Composable
fun CrateFileScreen(
    viewModel: CreateFileViewModel = getViewModel(),
) {
    val context = LocalContext.current
    val action = viewModel::dispatcher
    val viewState = viewModel.viewState.collectAsState()

    var descriptionText by remember { mutableStateOf("") }
    var valueText by remember { mutableStateOf("") }
    var totalValueText by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = colors.background)
            .padding(start = 6.dp)
            .fillMaxSize()
    ) {
        Header()
        SequenceOfTrianglesShape(
            color = colors.backgroundComponent,
            modifier = Modifier
                .height(50.dp)
                .width(100.dp)
                .align(Alignment.Start)

        )
        ExtractInformation(
            descriptionText = descriptionText,
            valueText = valueText,
            onChangeDescription = {
                descriptionText = it
            },
            onChangeValue = {
                valueText = it
            }
        )
        HorizontalDivider(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 8.dp),
            thickness = 2.dp,
            color = colors.text
        )
        Summary(
            descriptionText = "Total Gasto",
            valueText = "$25,00"
        )
        Spacer(modifier = Modifier.weight(1f))
        FloatingActionButton(
            modifier = Modifier.padding(bottom = 16.dp),
            shape = RoundedCornerShape(50),
            onClick = { /*TODO*/ },
            containerColor = colors.text
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = null,
                tint = colors.background
            )
        }
    }
}

@Composable
private fun ExtractInformation(
    descriptionText: String,
    valueText: String,
    onChangeDescription: (String) -> Unit,
    onChangeValue: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 24.dp)
            .background(
                color = colors.backgroundComponent,
                shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
            )
            .fillMaxHeight(0.7f)
            .fillMaxWidth(),
    ) {
        DefaultTextField(
            textValue = descriptionText,
            type = KeyboardType.Text,
            modifier = Modifier.weight(3f),
            textAlign = TextAlign.Start,
            onChange = {
                onChangeDescription.invoke(it)
            }
        )
        DefaultTextField(
            textValue = valueText,
            type = KeyboardType.Number,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End,
            onChange = {
                onChangeValue.invoke(it)
            }
        )
    }
}

@Composable
private fun Summary(
    descriptionText: String,
    valueText: String,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = descriptionText,
            style = Theme.typography.body,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = valueText,
            style = Theme.typography.body,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
private fun Header() {
    Text(
        text = "Contas do mês",
        style = Theme.typography.title,
        modifier = Modifier.padding(top = 16.dp)
    )
    Text(
        text = "Março",
        style = Theme.typography.subTitle,
        modifier = Modifier.padding(bottom = 24.dp)
    )
}

@Composable
private fun SequenceOfTrianglesShape(
    color: Color,
    modifier: Modifier
) {
    Canvas(
        modifier = modifier
    ) {
        val trianglePath = Path().let {
            val width = this.size.width
//            First line
            it.moveTo(width * .20f, this.size.height * .70f)
            it.lineTo(width * .30f, this.size.height * 0.50f)
            it.lineTo(width * .40f, this.size.height * 0.70f)
//            Second line
            it.lineTo(width * .50f, this.size.height * 0.50f)
            it.lineTo(width * .60f, this.size.height * 0.70f)
//            Third Line
            it.lineTo(width * .70f, this.size.height * .50f)
            it.lineTo(width * .80f, this.size.height * 0.70f)
//            Fourth Line
            it.lineTo(width * .90f, this.size.height * .50f)
            it.lineTo(width, this.size.height * 0.70f)

            it.lineTo(width + width * .10f, this.size.height * .50f)
            it.lineTo(width + width * .20f, this.size.height * 0.70f)

            it.lineTo(width + width * .30f, this.size.height * .50f)
            it.lineTo(width + width * .40f, this.size.height * 0.70f)

            it.lineTo(width + width * .50f, this.size.height * .50f)
            it.lineTo(width + width * .60f, this.size.height * 0.70f)

            it.lineTo(width + width * .70f, this.size.height * .50f)
            it.lineTo(width + width * .80f, this.size.height * 0.70f)

            it.lineTo(width + width * .90f, this.size.height * .50f)
            it.lineTo(width + width, this.size.height * 0.70f)

            it.lineTo(width + width + width * .10f, this.size.height * .50f)
            it.lineTo(width + width + width * .20f, this.size.height * 0.70f)

            it.lineTo(width + width + width * .30f, this.size.height * .50f)
            it.lineTo(width + width + width * .40f, this.size.height * 0.70f)

            it.lineTo(width + width + width * .50f, this.size.height * .50f)
            it.lineTo(width + width + width * .60f, this.size.height * 0.70f)

            it.lineTo(width + width + width * .70f, this.size.height * .50f)
            it.lineTo(width + width + width * .80f, this.size.height * 0.70f)

            it.lineTo(width + width + width * .90f, this.size.height * .50f)
            it.lineTo(width + width + width, this.size.height * 0.70f)

            it.lineTo(width + width + width + width * .10f, this.size.height * .50f)
            it.lineTo(width + width + width + width * .20f, this.size.height * 0.70f)

            it.lineTo(width + width + width + width * .30f, this.size.height * .50f)
            it.lineTo(width + width + width + width * .40f, this.size.height * 0.70f)

            it.lineTo(width + width + width + width * .50f, this.size.height * .50f)
            it.lineTo(width + width + width + width * .60f, this.size.height * 0.70f)

            it.lineTo(width + width + width + width * .70f, this.size.height * .50f)
            it.lineTo(width + width + width + width * .80f, this.size.height * 0.70f)
            it.lineTo(
                width + width + width + width * .80f,
                this.size.height + this.size.height + this.size.height
            )

            it.lineTo(width * .20f, this.size.height + this.size.height + this.size.height)

            it.close()
            it
        }
        drawPath(
            path = trianglePath,
            color = color
        )
    }

}

@Preview(
    device = Devices.PIXEL_XL,
    name = "PIXEL"
)
@Composable
private fun CrateFileScreenPreview() {
    CrateFileScreen(
        viewModel = CreateFileViewModel()
    )
}