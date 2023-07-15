package com.example.neurecare.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String?, val icon: ImageVector?) {
    object Home : Screen(Routes.Home.route, title = "Home", Icons.Outlined.Home)

    object Calendar : Screen(Routes.Calendar.route, title = "Calendar", Icons.Outlined.DateRange)
    object Message : Screen(Routes.Message.route, title = "Message", Icons.Outlined.Message)
    object AccessProgram : Screen(Routes.AccessProgram.route, title = "", null)
    object Profile : Screen(Routes.Profile.route, title = "Profile", Icons.Outlined.Person)


}