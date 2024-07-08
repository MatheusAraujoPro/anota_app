package com.matddev.file_manager.screens.create_files

import android.content.Context

sealed class CreateFileAction {
    data class CreateFile(val lines: List<String>, val context: Context) : CreateFileAction()

    object OpenHideBottomSheet : CreateFileAction()
    object OpenHideDialog : CreateFileAction()
}