package com.example.neurecare.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.CalenderBar
import com.example.neurecare.ui.component.itemRowAddCalender
import com.example.neurecare.ui.component.itemRowCalender


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScheduleScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Kalender Pasien")
                },
                backgroundColor = colorResource(id = R.color.white),
                navigationIcon = {
                    IconButton(onClick = { /* Handle back action here */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                items(3) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                    ) {
                        itemRowCalender()
                        Spacer(modifier = Modifier.width(12.dp))
                        itemRowAddCalender()
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                itemRowCalender()
                Spacer(modifier = Modifier.width(12.dp))
                CalenderBar()
            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun ScheduleScreenPreview() {
    ScheduleScreen(navController = rememberNavController())
}