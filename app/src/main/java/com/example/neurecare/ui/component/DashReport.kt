package com.example.neurecare.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
fun DashReport(navController: NavController)
{
    Box(modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .width(340.dp)
        .height(190.dp)
        .background(colorResource(id = R.color.white))
        .border(width = 2.dp, colorResource(id = R.color.white))
    ) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier.padding(15.dp)) {

                Row(modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(colorResource(id = R.color.Abu))
                    .width(150.dp)
                    .height(160.dp)) {


                    Column(modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(vertical = 10.dp)
                        .fillMaxWidth() // Menyebarkan komponen ke seluruh lebar
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth() // Menyebarkan komponen ke seluruh lebar
                        ) {
                            Column(
                                horizontalAlignment = Alignment.Start, // Menyusun teks ke kiri
                                modifier = Modifier.weight(0.5f) // Menggunakan weight untuk memberikan ruang yang sama pada ikon dan teks
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.calendarbg),
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.End, // Menyusun teks ke kanan
                                modifier = Modifier.weight(0.8f) // Menggunakan weight untuk memberikan ruang yang sama pada ikon dan teks
                            ) {
                                // Menambahkan tulisan "Total Pasien Ditangani"
                                Text(
                                    "Keseluruhan Program",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.Blue_4B), // Sesuaikan dengan warna yang sesuai
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .align(Alignment.End) // Menyusun teks ke kanan
                                        .padding(end = 8.dp) // Jarakkan teks dari kanan
                                )

                            }
                        }
                        Spacer(modifier = Modifier.weight(0.5f))
                        Text(
                            "90%",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
                        )

                    }


                }
                Spacer(modifier = Modifier.weight(1f))
                Row(modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(colorResource(id = R.color.Abu))
                    .width(150.dp)
                    .height(160.dp)) {

                    Column(modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(vertical = 10.dp)
                        .fillMaxWidth() // Menyebarkan komponen ke seluruh lebar
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth() // Menyebarkan komponen ke seluruh lebar
                        ) {
                            Column(
                                horizontalAlignment = Alignment.Start, // Menyusun teks ke kiri
                                modifier = Modifier.weight(0.5f) // Menggunakan weight untuk memberikan ruang yang sama pada ikon dan teks
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.calendartoday),
                                    contentDescription = null,
                                    modifier = Modifier.size(40.dp)
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.End, // Menyusun teks ke kanan
                                modifier = Modifier.weight(0.8f) // Menggunakan weight untuk memberikan ruang yang sama pada ikon dan teks
                            ) {
                                // Menambahkan tulisan "Total Pasien Ditangani"
                                Text(
                                    "Program Hari Ini",
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.Blue_4B), // Sesuaikan dengan warna yang sesuai
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .align(Alignment.End) // Menyusun teks ke kanan
                                        .padding(end = 8.dp) // Jarakkan teks dari kanan
                                )

                            }
                        }
                        Spacer(modifier = Modifier.weight(0.5f))

                        // Menggunakan Modifier.fillMaxSize().wrapContentSize(Alignment.Center) untuk membuat teks "20" berada di tengah
                        Text(
                            "96%",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)
                        )
                    }
                }



            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DashReportPreview()
{
    DashReport(navController = rememberNavController())
}
