package com.example.neurecare.ui.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.GreetingBar
import com.example.neurecare.ui.component.Programs



@Composable
fun HomeScreen(
    navController: NavController
){


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TopAppBar(
            {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            },
            backgroundColor = Color.White,

            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Box {
                        Icon(
                            painter = painterResource(id = R.drawable.notifications),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )

                    }
                }
            }

        )
        Spacer(modifier = Modifier.height(15.dp))
        GreetingBar()
        Spacer(modifier = Modifier.height(15.dp))
        Programs(navController)
        Spacer(modifier = Modifier.height(15.dp))

    }


}



@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomePreview(){
    HomeScreen(navController = rememberNavController())
}