package com.matddev.file_manager.screens.create_files

data class CreateFileViewState(
    val shouldShowBottomSheet: Boolean = false,
    val result: Boolean = false,
    val descriptionText: String = "",
    val valueText: String = "",
    val shouldShowDialog: Boolean = false
)