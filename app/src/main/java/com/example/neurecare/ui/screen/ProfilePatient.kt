package com.example.neurecare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.neurecare.R
import com.example.neurecare.data.datadummy.DataItemProfile
import com.example.neurecare.ui.component.ButtonMenuPatient
import com.example.neurecare.ui.component.Datapatient
import com.example.neurecare.ui.component.TextContent
import com.example.neurecare.ui.component.TitleContent


@Composable
fun ProfilePatientScreen(navController: NavController) {
    BackDetail()
    Box(
        modifier = Modifier.padding(25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            horizontalAlignment = Alignment.End
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp, bottom = 15.dp)
                    .clip(CircleShape)
                    .size(60.dp)
                    .testTag("logout")
                    .background(colorResource(id = R.color.Purple))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = null,
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfilePatientImage()
            Spacer(modifier = Modifier.height(20.dp))
            Datapatient(navController = navController)
            Spacer(modifier = Modifier.height(20.dp))
            // Tambahkan komponen ButtonMenuPatient di sini
            ButtonMenuPatient(navController)

        }
    }
}


@Composable
fun ProfilePatientImage() {
    Column() {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(
                "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
            ).crossfade(true).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .border(1.dp, color = colorResource(id = R.color.Purple), CircleShape)
                .clip(CircleShape)

        )
    }

}


@Composable
fun DetailProfilePatient(title: String, icon: Int){
    val context = LocalContext.current

    Row (
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row() {
            Box(modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.yellow))) {
                Icon(painter = painterResource(id = icon), contentDescription =null,
                    tint = colorResource(id = R.color.teal_700),
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.Center))
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = title,
                color = colorResource(id = R.color.brown),
                fontSize = 16.sp,
                modifier = Modifier.padding(top =9.dp)

            )
        }
        IconButton(onClick = { /*TODO*/ }

        ) {
            Icon(painter = painterResource(id = R.drawable.chevron),
                contentDescription = null, tint = colorResource(R.color.teal_700),
                modifier = Modifier.size(24.dp))

        }
    }
}
@Composable
fun BackDetail() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            painterResource(id = R.drawable.back)
            
        }
        Text(
            "Detail Pasien",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.Blue_4B),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPatientPreview() {
    ProfilePatientScreen(navController = rememberNavController())
}