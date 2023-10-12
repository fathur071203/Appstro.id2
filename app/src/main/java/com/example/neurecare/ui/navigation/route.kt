package com.example.neurecare.ui.navigation

sealed class Routes(val route:String) {
    object Home : Routes("home")
    object Calendar : Routes("calendar")
    object Message : Routes("message")
    object PoseDetection : Routes("pose_detection_screen")
    object AccessProgram : Routes("access_program")
    object Profile : Routes("profile")
    object Login : Routes("login")
    object Register : Routes("register")
    object OnBoard : Routes("on_board")
    object Dashboard : Routes("dashboard")
    object SplashScreen : Routes("splash_screen")
    object PoseReport : Routes("report_pose")
    object AddActivity : Routes("add_activity")
    object Patient : Routes("patient")




    object VideoScreen : Routes("video_screen")
    object DetailProgram : Routes("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
    object SkipNext : Routes("skip_next")
    object SkipPrevious : Routes("skip_previous")
}