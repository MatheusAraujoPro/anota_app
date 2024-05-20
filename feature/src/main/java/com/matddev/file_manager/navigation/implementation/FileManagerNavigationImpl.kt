package com.matddev.file_manager.navigation.implementation

import com.matddev.file_manager.navigation.definition.FileManagerNavigation
import com.matddev.utils.NavigationManager

class FileManagerNavigationImpl(
    private val navigationManager: NavigationManager
): FileManagerNavigation {
    override fun navigate(route: String) {
        navigationManager.navigate(
            route = route
        )
    }

    override fun getCurrentDestination(): String {
        return navigationManager.currentRoute.orEmpty()
    }
}