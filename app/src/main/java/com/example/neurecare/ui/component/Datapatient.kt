package com.example.neurecare.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.navigation.Routes


@Composable
fun Datapatient(navController: NavController) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(350.dp)
            .height(254.dp)
            .background(colorResource(id = R.color.white))
            .border(width = 2.dp, colorResource(id = R.color.white))
    ) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier.padding(15.dp)) {

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(colorResource(id = R.color.yellow))
                        .width(350.dp)
                        .height(245.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(vertical = 10.dp)
                    ) {
                        Text("Nama Lengkap", fontSize = 20.sp, color = colorResource(id = R.color.Purple))
                        Text("Budi Santoso", fontSize = 16.sp, color = colorResource(id = R.color.Black))
                        Spacer(modifier = Modifier.height(45.dp)) // Add some spacing between columns
                        Text("Tanggal Lahir", fontSize = 20.sp, color = colorResource(id = R.color.Purple))
                        Text("8 Juli 1989", fontSize = 16.sp, color = colorResource(id = R.color.Black))
                    }

                    Spacer(modifier = Modifier.width(16.dp)) // Add some spacing between columns

                    Column(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                    ) {
                        Text("Jenis Kelamin", fontSize = 20.sp, color = colorResource(id = R.color.Purple))
                        Text("Laki-laki", fontSize = 16.sp, color = colorResource(id = R.color.Black))
                        Spacer(modifier = Modifier.height(45.dp)) // Add some spacing between columns
                        Text("Alamat", fontSize = 20.sp, color = colorResource(id = R.color.Purple))
                        Text("Jalan Contoh No. 123", fontSize = 16.sp, color = colorResource(id = R.color.Black))
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DatapartientPreview()
{
    Datapatient(navController = rememberNavController())
}
