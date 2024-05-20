package com.matddev.file_manager.navigation.implementation

import com.matddev.file_manager.navigation.definition.GithubNavigation
import com.matddev.utils.NavigationManager

class GithubNavigationImpl(
    private val navigationManager: NavigationManager
): GithubNavigation {
    override fun navigate(route: String) {
        navigationManager.navigate(
            route = route
        )
    }

    override fun getCurrentDestination(): String {
        return navigationManager.currentRoute.orEmpty()
    }
}