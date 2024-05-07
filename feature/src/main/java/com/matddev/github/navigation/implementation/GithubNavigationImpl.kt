package com.matddev.github.navigation.implementation

import com.matddev.github.navigation.definition.GithubNavigation
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