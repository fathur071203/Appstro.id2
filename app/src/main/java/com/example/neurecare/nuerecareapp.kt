package com.example.neurecare

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.ui.navigation.Routes
import com.example.neurecare.ui.screen.DashboardTerapisScreen
import com.example.neurecare.ui.screen.OnBoardingScreen
import com.example.neurecare.ui.screen.SignInScreen
import com.example.neurecare.ui.screen.SignUpScreen
import com.example.neurecare.ui.screen.SplashScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NeurecareApp(navController: NavHostController = rememberNavController()) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold() {
        val nav = it
        NavHost(navController = navController, startDestination = Routes.SplashScreen.route){
            composable(Routes.SplashScreen.route){
                SplashScreen(navController = navController)
            }
            composable(Routes.Register.route){
                SignUpScreen(navController = navController)
            }
            composable(Routes.Login.route){
                SignInScreen(navController = navController)
            }
            composable(Routes.Dashboard.route){
                DashboardTerapisScreen()
            }
        }
    }

}
