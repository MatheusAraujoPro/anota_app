package com.matddev.file_manager.screens.create_files

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matddev.anotaapp.theme.Theme
import com.matddev.anotaapp.theme.Theme.colors
import com.matddev.file_manager.screens.create_files.dialogs.ExtractDialog
import com.matddev.model.Extract
import org.koin.androidx.compose.getViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrateFileScreen(
    viewModel: CreateFileViewModel = getViewModel()
) {
    val context = LocalContext.current
    val action = viewModel::dispatcher
    val viewState by viewModel.viewState.collectAsState()

    var inputDescriptionText by remember { mutableStateOf("") }
    var inputValueText by remember { mutableStateOf("") }

    var listOfExtract by remember {
        mutableStateOf(mutableListOf<Extract>())
    }
    val sheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Expanded,
        skipHiddenState = false
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = colors.background)
            .fillMaxSize()
    ) {
        Header(
            colors = colors, modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .align(Alignment.Start)
        )

        Content(itemsList = listOfExtract)

        Footer(
            color = colors,
            action = action,
            modifier = Modifier.weight(1f)
        )

        if (viewState.shouldShowBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    action(CreateFileAction.OpenHideBottomSheet)
                },
                sheetState = sheetState,

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .padding(bottom = 48.dp)
                ) {
                    Text(text = "Hello")
                }
            }
        }
        if (viewState.shouldShowDialog) {
            ExtractDialog(
                action = action,
                inputDescriptionText = inputDescriptionText,
                inputValueText = inputValueText,
                descriptionTextOnChange = {
                    inputDescriptionText = it
                },
                valueTextOnChange = {
                    inputValueText = it
                },
                onClick = { descriptionText, value ->
                    listOfExtract.add(Extract(description = descriptionText, value = value))
                }
            )
        }
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