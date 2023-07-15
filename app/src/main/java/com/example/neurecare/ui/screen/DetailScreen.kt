package com.example.neurecare.ui.screen

import androidx.compose.foundation.background
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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.ButtonPrimary
import com.example.neurecare.ui.component.JProgram





@Composable
fun DetailScreen(
//    programsId: Int,
//    navigateBack: () -> Unit,
//    modifier: Modifier = Modifier,
    navController: NavController
){
DetailScreenPreview()

}

@Composable
fun JenisProgram(
    id: Int,
    descriptionProgram: String, //deskripsi
    detailProgram: String, //gerakan
    duration: String, //durasi
    navigateBack: () -> Unit,

    ) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()){
            IconButton(onClick = navigateBack,
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp, bottom = 15.dp)
                    .clip(CircleShape)
                    .size(60.dp)
                    .testTag("back_button")
                    .background(colorResource(id = R.color.teal_700))

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription =null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

            }
            Text("Detail",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 100.dp),
//                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier
            .padding(25.dp)
        ) {
            Row() {
                Icon(painter = painterResource(id = R.drawable.contract), contentDescription = null, tint = colorResource(
                    id = R.color.orange ), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(13.dp))
                JProgram(text = "Jenis Program", description = descriptionProgram)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Icon(painter = painterResource(id = R.drawable.format_list), contentDescription = null, tint = colorResource(
                    id = R.color.orange ), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(13.dp))
                JProgram(text = "Gerakan", description = detailProgram)
            }
            Spacer(modifier = Modifier.height(20.dp))

            Row() {
                Icon(painter = painterResource(id = R.drawable.timer),
                    contentDescription = null, tint = colorResource(
                        id = R.color.orange ), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(13.dp))
                JProgram(text = "Estimasi Waktu", description = duration)
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))

        Column(modifier = Modifier.padding(25.dp)) {
            ButtonPrimary(onClick = { /*TODO*/ }, text = "Mulai Program" )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    JenisProgram(id = 1, descriptionProgram = "Latihan Tubuh Bagian Atas", detailProgram = "Memutar pergelangan tangan", duration = "30 menit" ) {

    }

}