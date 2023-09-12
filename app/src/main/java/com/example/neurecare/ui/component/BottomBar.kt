package com.example.neurecare.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
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
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.neurecare.R
import com.example.neurecare.ui.navigation.Screen
import androidx.navigation.compose.*

//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun BottomBar(navController: NavController) {
//    Scaffold(
//        bottomBar = {
//            BottomAppBar(
//                modifier = Modifier
//                    .height(65.dp)
//                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
//                cutoutShape = CircleShape,
//
//                backgroundColor = colorResource(id = R.color.teal_700),
//
//                ) {
//               BottomNav(navController = rememberNavController())
//
//
//            }
//        },
//        floatingActionButtonPosition = FabPosition.Center,
//        isFloatingActionButtonDocked = true,
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    navController.navigate(Screen.AccessProgram.route){
//                        popUpTo(Screen.Home.route){
//                            inclusive = true
//                        }
//                    }
//                },
//                backgroundColor = colorResource(id = R.color.gray),
//
//                ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.accessibility),
//                    contentDescription = "",
//                    tint = Color.White,
//
//                    )
//
//            }
//        },
//        backgroundColor = Color.Black
//    ) {
//
//    }
//}

@Composable
fun BottomNav(navController:NavController = rememberNavController()){

        val navigationItems = listOf(
        Screen.Home,
        Screen.Calendar,
        Screen.Message,
        Screen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier
//            .padding(8.dp, 0.dp, 12.dp, 0.dp)

            .fillMaxWidth()
            .height(100.dp),
        backgroundColor = colorResource(id = R.color.teal_700),
        //backgroundColor = Color.White,
        elevation = 0.dp
    ) {

        navigationItems.forEach {
            BottomNavigationItem(
                icon = {
                    it.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                        )
                    }
                },
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { destination -> destination.route == it.route } == true,


//                selectedContentColor = Color.Gray,
                unselectedContentColor = Color.White,
                onClick = {
                    navController.navigate(it.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                }
            )
        }

    }
}



@Preview
@Composable
fun PreviewBottomBar() {

}