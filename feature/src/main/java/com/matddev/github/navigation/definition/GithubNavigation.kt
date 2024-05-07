package com.matddev.github.navigation.definition

interface GithubNavigation {
    fun navigate(route: String)
    fun getCurrentDestination(): String
}