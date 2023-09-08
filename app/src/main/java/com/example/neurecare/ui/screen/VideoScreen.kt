package com.example.neurecare.ui.screen

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.BottomNav
import com.example.neurecare.ui.component.ButtonPrimary
import com.example.neurecare.ui.component.JProgram
import com.example.neurecare.ui.navigation.Routes


@Composable
fun ProgramScreen(
navController: NavController
){

}

@Composable
fun detailScreenVideo(
    id: Int,
    descriptionProgram: String, //deskripsi
    detailProgram: String, //gerakan

    ) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()){
            IconButton(onClick = {

            },
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp, bottom = 15.dp)
                    .clip(CircleShape)
                    .size(60.dp)
                    .testTag("pause_button")
                    .background(colorResource(id = R.color.teal_700))

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.pause),
                    contentDescription =null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.Center, // Mengatur penataan vertikal menjadi tengah
            horizontalAlignment = Alignment.CenterHorizontally, // Mengatur penataan horizontal menjadi tengah
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .width(300.dp)
                .height(175.dp)
                .border(15.dp, Color.Black, CircleShape)
                .background(color = Color.Black)) {

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier
            .padding(25.dp)
        ) {
            Row() {
                Icon(painter = painterResource(id = R.drawable.accessibility), contentDescription = null, tint = colorResource(
                    id = R.color.orange ), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(13.dp))
                JProgram(text = "Nama Gerakan", description = descriptionProgram)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Icon(painter = painterResource(id = R.drawable.description), contentDescription = null, tint = colorResource(
                    id = R.color.orange ), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(13.dp))
                JProgram(text = "Gerakan", description = detailProgram)
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun bottomNav(navController: NavHostController = rememberNavController()){
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
                    painter = painterResource(id = R.drawable.videocam),
                    contentDescription = "",)

            }


        },
    ) {
        NavHost(navController = navController, startDestination = Routes.Home.route){

        }
    }


}

@Preview(showBackground = true)
@Composable
fun bottomNavPreview(){
    bottomNav()
}

@Preview(showBackground = true)
@Composable
fun ProgramScreenPreview(){
   detailScreenVideo(id = 1, descriptionProgram = "Latihan tubuh bagian atas", detailProgram ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum ultrices ut nulla vehicula semper. Vestibulum lacinia enim nec volutpat dictum." )
}




