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
    object PoseReport : Routes("report_pose")
    object AddActivity : Routes("add_activity")
    object Patient : Routes("patient")
    object AddMovement : Routes("add_movement")

    object Schedule : Routes("schedule")

    object Review : Routes("review")
    object PoseDetectionScreen : Routes("pose_detection_screen")
    object ProfilePatient : Routes("profile_patient")
    object Choice : Routes("choice")


    object VideoScreen : Routes("video_screen")
    object DetailProgram : Routes("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
    object SkipNext : Routes("skip_next")
    object SkipPrevious : Routes("skip_previous")
}