package com.matddev.file_manager.screens.create_files

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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
        modifier = Modifier.fillMaxSize()
    ) {
        if(viewState.value.result)
            Text(text = "Deu certo")
        Button(onClick = {
           action(CreateFileAction.CreateFile(
               lines = listOf("primeira linha", "segunda linha"),
               context = context
           ))
        }) {
            Text(text = "Gravar arquiivo")
        }
    }
}

@Preview
@Composable
private fun CrateFileScreenPreview() {
    CrateFileScreen()
}