package com.example.neurecare.ui.navigation

sealed class Routes(val route:String) {
    object Home : Routes("home")
    object Calendar : Routes("calendar")
    object Message : Routes("message")
    object AccessProgram : Routes("access_program")
    object Profile : Routes("profile")
    object Login : Routes("login")
    object Register : Routes("register")
    object OnBoard : Routes("on_board")
    object Dashboard : Routes("dashboard")
    object SplashScreen : Routes("splash_screen")
    object DetailProgram : Routes("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}