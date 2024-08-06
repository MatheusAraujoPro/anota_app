package com.matddev.anotaapp.components.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material.icons.twotone.Info
import androidx.compose.material.icons.twotone.Menu
import androidx.compose.material.icons.twotone.Refresh
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(
    val route: String,
    val title: String,
    val icon: ImageVector? = null
) {
    object Home : BottomBarScreens(
        route = Screens.HOME.name,
        title = Screens.HOME.title,
        icon = Icons.TwoTone.Home
    )

    object Bills : BottomBarScreens(
        route =  Screens.BILLS.name,
        title = Screens.BILLS.title,
        icon = Icons.TwoTone.Menu
    )

    object Summary : BottomBarScreens(
        route = Screens.SUMMARY.name,
        title = Screens.SUMMARY.title,
        icon = Icons.TwoTone.Info
    )
}

data class Destination(
    val name: String,
    val title: String
)

object Screens {
    val HOME = Destination(
        name = "Home",
        title = "Início"
    )
    val BILLS = Destination(
        name = "Bills",
        title = "Contas"
    )
    val SUMMARY = Destination(
        name = "Summary",
        title = "Resumo"
    )
}