package com.matddev.anotaapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.matddev.file_manager.screens.create_files.CrateFileScreen

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = "createFile",
    ) {
        composable("createFile"){ CrateFileScreen() }
    }
}