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
fun Programs(navController: NavController)
{
    Box(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .width(350.dp)
        .height(284.dp)
        .background(colorResource(id = R.color.yellow_CD1))
        .border(width = 2.dp, colorResource(id = R.color.yellow))
    ) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier.padding(15.dp)) {

                Row(modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(colorResource(id = R.color.white))
                    .width(150.dp)
                    .height(160.dp)) {


                    Column(modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(vertical = 10.dp)) {
                        Icon(painter = painterResource(id = R.drawable.accessibility),
                            contentDescription =null, modifier = Modifier.size(32.dp),
                        tint = colorResource(id = R.color.orange))
                        Spacer(modifier = Modifier.weight(0.5f))
                        Text("8", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                        Text("Gerakan", fontSize = 16.sp, color = colorResource(id = R.color.teal_700))

                    }

                }
                Spacer(modifier = Modifier.weight(1f))
                Row(modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(colorResource(id = R.color.white))
                    .width(150.dp)
                    .height(160.dp)) {
                    Column(modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(vertical = 10.dp)) {
                        Icon(painter = painterResource(id = R.drawable.timer),
                            contentDescription =null, modifier = Modifier.size(32.dp),
                            tint = colorResource(id = R.color.orange))
                        Spacer(modifier = Modifier.weight(0.5f))
                        Text("20", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                        Text("Menit", fontSize = 16.sp, color = colorResource(id = R.color.teal_700))

                    }


                }


            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(310.dp)
                    .height(64.dp)
                    .align(Alignment.CenterHorizontally)
                ,
                onClick = {
                          navController.navigate(Routes.DetailProgram.route)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.teal_700)
                )
            ) {
                Row() {
                    Text(text = "Lanjutkan Program", color = colorResource(id = R.color.white), fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    Icon(painter = painterResource(id = R.drawable.resume), contentDescription =null, modifier = Modifier
                        .size(24.dp))
                }
            }
//            Column(
//
//                modifier = Modifier
//                    .clip(RoundedCornerShape(20.dp))
////                    .fillMaxWidth()
//                    .background(colorResource(id = R.color.teal_700))
//                    .width(310.dp)
//                    .height(64.dp),
//                    ) {
//
//
//            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProgramsPreview()
{
    Programs(navController = rememberNavController())
}
