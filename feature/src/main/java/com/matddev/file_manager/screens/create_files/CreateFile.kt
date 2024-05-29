package com.matddev.file_manager.screens.create_files

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matddev.anotaapp.theme.Theme.colors
import org.koin.androidx.compose.getViewModel


@Composable
fun CrateFileScreen(
    viewModel: CreateFileViewModel = getViewModel(),
) {
    val context = LocalContext.current
    val action = viewModel::dispatcher
    val viewState = viewModel.viewState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = colors.background)
            .fillMaxSize()
    ) {
        SequenceOfTrianglesShape(
            color = colors.backgroundComponent,
            modifier = Modifier
                .height(50.dp)
                .width(100.dp)
                .align(Alignment.Start)

        )
        TextField(
            value = "",
            modifier = Modifier
                .padding(start = 20.dp, end = 12.dp)
                .height(300.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colors.backgroundComponent,
                unfocusedContainerColor = colors.backgroundComponent
            ),
            onValueChange = {}
        )
    }
}

@Composable
private fun SequenceOfTrianglesShape(
    color: Color,
    modifier: Modifier,
    isRotate: Boolean = false
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

@Preview
@Composable
private fun CrateFileScreenPreview() {
    CrateFileScreen(
        viewModel = CreateFileViewModel()
    )
}