package com.example.neurecare.ui.screen


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.BottomNav
//import com.example.neurecare.ui.component.BottomBar
import com.example.neurecare.ui.navigation.Routes
import com.example.neurecare.ui.navigation.Screen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardScreen(navController: NavHostController = rememberNavController()){

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

 Scaffold(
     bottomBar = {
//         if (currentDestination != Routes.AccessProgram.route){
//             BottomNav(navController = navController)
         BottomAppBar(
             modifier = Modifier
                 .height(65.dp)
                 .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
             cutoutShape = CircleShape,

             backgroundColor = colorResource(id = R.color.teal_700),

             ) {
             BottomNav(navController = navController)
         }


     },
     floatingActionButtonPosition = FabPosition.Center,
     isFloatingActionButtonDocked = true,
     floatingActionButton = {
         FloatingActionButton(
             shape = CircleShape,
             onClick = {
                 // Navigate to PoseDetectionScreen
                 Routes.PoseDetection.route.let {
                     navController.navigate(it) {
                         popUpTo(navController.graph.findStartDestination().id) {
                             saveState = true
                         }
                         launchSingleTop = true
                         restoreState = true
                     }
                 }
             },
             backgroundColor = colorResource(id = R.color.gray)
         ) {
             Icon(
                 painter = painterResource(id = R.drawable.accessibility),
                 contentDescription = "",)

         }


     },
 ) {
     NavHost(navController = navController, startDestination = Routes.Home.route ){
         composable(Routes.Home.route){
             HomeScreen(navController = navController)
         }
         composable(Routes.Calendar.route){
             ScheduleScreen(navController = navController)
         }
         composable(Routes.Message.route){
             MessageScreen(navController = navController)
         }
         composable(Routes.AccessProgram.route){
             ProgramScreen(navController = navController)
         }
         composable(Routes.DetailProgram.route){
             DetailScreen(navController = navController)
         }
//
         composable(Routes.Profile.route){
             ProfileScreen(navController = navController)
         }
         composable(Routes.PoseDetection.route) {
             PoseDetectionScreen()
         }

     }

 }

}


@Preview
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}