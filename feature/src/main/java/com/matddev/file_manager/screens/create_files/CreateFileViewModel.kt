package com.matddev.file_manager.screens.create_files

import android.content.Context
import androidx.lifecycle.ViewModel
import com.matddev.use_case.WriteFileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateFileViewModel : ViewModel(), KoinComponent {
    private val writeFileUseCase: WriteFileUseCase by inject()
    var viewState = MutableStateFlow(CreateFileViewState())

    fun dispatcher(action: CreateFileAction) {
        when (action) {
            is CreateFileAction.CreateFile -> createFile(
                lines = action.lines,
                context = action.context
            )

            CreateFileAction.OpenHideBottomSheet -> openHideBottomSheet()
            CreateFileAction.OpenHideDialog -> openHideBottomSheet()
        }
    }

    private fun createFile(lines: List<String>, context: Context) {
        val result = writeFileUseCase(
            lines = lines,
            context = context
        )
        viewState.value = viewState.value.copy(
            result = result
        )
    }

    private fun openHideBottomSheet() {
        if (viewState.value.shouldShowDialog)
            viewState.value = viewState.value.copy(
                shouldShowDialog = false
            )
        else
            viewState.value = viewState.value.copy(
                shouldShowDialog = true
            )
    }
}