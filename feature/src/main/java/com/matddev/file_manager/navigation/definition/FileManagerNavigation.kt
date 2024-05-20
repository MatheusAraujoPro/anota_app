package com.matddev.file_manager.navigation.definition

interface FileManagerNavigation {
    fun navigate(route: String)
    fun getCurrentDestination(): String
}