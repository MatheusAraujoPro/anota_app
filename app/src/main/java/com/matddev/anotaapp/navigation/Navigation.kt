package com.matddev.anotaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.matddev.file_manager.screens.list_screen.ListScreen
import com.matddev.file_manager.screens.bookmark_screen.Bookmark

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "list",
    ) {
        composable("list"){ ListScreen() }
        composable("bookmark"){ Bookmark() }
    }
}