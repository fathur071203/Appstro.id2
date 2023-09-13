package com.example.neurecare.ui.screen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.navigation.Routes
import com.example.neurecare.ui.navigation.Screen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController){
    
    LaunchedEffect(key1 = true) {
        
        delay(4000L)
        navController.navigate(Routes.OnBoard.route)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.Blue_4B)),
//        contentAlignment = Alignment.BottomEnd,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
//            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.neurecare),
                contentDescription = null,
            )
//            Spacer(modifier = Modifier.height(40.dp))
//            Column(modifier = Modifier.padding(bottom = 30.dp)) {
//                Icon(
//                    painter = painterResource(id = R.drawable.vector),
//                    contentDescription = null,
//                    tint = colorResource(id = R.color.teal_700).copy(0.3f)
//                )
//            }

        }
    }

}

//@Composable
//fun Navigate(){
//    val navController = rememberNavController()
//    NavHost(navController = navController,
//        startDestination = Routes.SplashScreen.route) {
//        composable(Routes.SplashScreen.route) {
//            SplashScreen(navController = navController)
//        }
//        composable(Routes.OnBoard.route) {
//            OnBoardingScreen(navController = navController)
//        }
//        composable(Routes.Register.route) {
//            SignInScreen(navController = navController)
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun SplashScreenOnePreview() {
    SplashScreen(navController = rememberNavController())
}