package com.matddev.file_manager.screens.create_files

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.matddev.anotaapp.components.scaffold.DefaultScaffold
import org.koin.androidx.compose.getViewModel

@Composable
fun CrateFileScreen(
    viewModel: CreateFileViewModel = getViewModel()
) {
    DefaultScaffold(
        totalAmount = "R$ 50,00",
        content = {

        },
        navigate = {

        }
    )
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