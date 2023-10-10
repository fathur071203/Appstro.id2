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
    object SkipNext : Screen(Routes.SkipNext.route, title = "Skip Next", Icons.Outlined.SkipNext)
    object SkipPrevious : Screen(Routes.SkipPrevious.route, title = "Skip Previous", Icons.Outlined.SkipPrevious)
    object Activity : Screen(Routes.AddActivity.route, title = "Add Activity", Icons.Outlined.Home)



}