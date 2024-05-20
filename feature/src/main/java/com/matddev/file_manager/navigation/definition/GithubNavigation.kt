package com.matddev.file_manager.navigation.definition

interface GithubNavigation {
    fun navigate(route: String)
    fun getCurrentDestination(): String
}