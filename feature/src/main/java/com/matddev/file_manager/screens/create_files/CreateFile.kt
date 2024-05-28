package com.matddev.file_manager.screens.create_files

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = colors.background)
            .fillMaxSize()
    ) {
        Triangle(
            color = colors.success,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Start)
        )
    }
}


@Composable
private fun Triangle(
    color: Color,
    modifier: Modifier
) {
    Canvas(
        modifier = modifier

    ) {
        val trianglePath = Path().let {
//            First line
            it.moveTo(this.size.width * .20f, this.size.height * .70f)
            it.lineTo(this.size.width * .30f, this.size.height * 0.50f)
            it.lineTo(this.size.width * .40f, this.size.height * 0.70f)
//            Second line
            it.lineTo(this.size.width * .50f, this.size.height * 0.50f)
            it.lineTo(this.size.width * .60f, this.size.height * 0.70f)

            it.lineTo(this.size.width * .70f, this.size.height * .50f)
            it.lineTo(this.size.width * .80f, this.size.height * 0.70f)

            it.lineTo(this.size.width * .90f, this.size.height * .50f)
            it.lineTo(this.size.width, this.size.height * 0.70f)

            it.lineTo(this.size.width + this.size.width * .10f , this.size.height * .50f)
            it.lineTo(this.size.width + this.size.width * .20f, this.size.height * 0.70f)

            it.lineTo(this.size.width + this.size.width * .30f , this.size.height * .50f)
            it.lineTo(this.size.width + this.size.width * .40f, this.size.height * 0.70f)

            it.lineTo(this.size.width + this.size.width * .50f , this.size.height * .50f)
            it.lineTo(this.size.width + this.size.width * .60f, this.size.height * 0.70f)

            it.lineTo(this.size.width + this.size.width * .70f , this.size.height * .50f)
            it.lineTo(this.size.width + this.size.width * .80f, this.size.height * 0.70f)

            it.lineTo(this.size.width + this.size.width * .90f , this.size.height * .50f)
            it.lineTo(this.size.width + this.size.width , this.size.height * 0.70f)
            
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