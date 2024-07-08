package com.matddev.file_manager.screens.create_files.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.matddev.anotaapp.components.textfield.DefaultTextField
import com.matddev.anotaapp.theme.Theme
import com.matddev.anotaapp.theme.Theme.colors
import com.matddev.file_manager.screens.create_files.CreateFileAction

@Composable
fun ExtractDialog(
    action: (CreateFileAction) -> Unit,
    inputDescriptionText: String,
    inputValueText: String,
    descriptionTextOnChange: (String) -> Unit,
    valueTextOnChange: (String) -> Unit,
    onClick: (String, String) -> Unit
) {
    Dialog(onDismissRequest = {
        action(CreateFileAction.OpenHideBottomSheet)
    }) {
        Card {
            Column(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "Descrição",
                    style = Theme.typography.body,
                    modifier = Modifier.padding(top = 16.dp)
                )
                DefaultTextField(
                    textValue = inputDescriptionText,
                    modifier = Modifier.fillMaxWidth(),
                    hint = "Tia da sopa",
                    onChange = {
                        descriptionTextOnChange.invoke(it)
                    }
                )
                Text(
                    text = "Valor",
                    style = Theme.typography.body,
                    modifier = Modifier.padding(top = 16.dp)
                )
                DefaultTextField(
                    textValue = inputValueText,
                    modifier = Modifier.fillMaxWidth(),
                    hint = "R$ 0,00",
                    onChange = {
                        valueTextOnChange.invoke(it)
                    }
                )
                Button(
                    onClick = {
                        onClick.invoke(inputDescriptionText, inputValueText)
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.text
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "Adicionar",
                        style = Theme.typography.body,
                    )
                }
            }
        }
    }
}