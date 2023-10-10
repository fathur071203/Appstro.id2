//package com.example.neurecare.ui.component
//
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.testTag
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.example.neurecare.R
//import com.example.neurecare.ui.navigation.Routes
//
//@Composable
//fun SumReport(navController: NavController) {
//    Box(
//        modifier = Modifier
//            .clip(RoundedCornerShape(20.dp))
//            .width(340.dp)
//            .height(270.dp) // Menambahkan tinggi untuk bar chart
//            .background(colorResource(id = R.color.white))
//            .border(width = 2.dp, colorResource(id = R.color.white))
//    ) {
//        Column(modifier = Modifier) {
//            Row(modifier = Modifier.padding(15.dp)) {
//
//                Row(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(20.dp))
//                        .background(colorResource(id = R.color.Abu))
//                        .width(300.dp)
//                        .height(160.dp)
//                ) {
//
//                    Column(modifier = Modifier
//                        .padding(start = 10.dp)
//                        .padding(vertical = 10.dp)
//                        .fillMaxWidth()
//                    ) {
//                        Text("Mengangkat Bahu", fontSize = 15.sp, fontWeight = FontWeight.Bold)
//                        Spacer(modifier = Modifier.weight(0.5f))
//
//                        Button(
//                            onClick = {
//                                // Anda dapat membuka pemilih file di sini untuk membiarkan pengguna memilih file video
//                                // dan mengatur URI video yang dipilih ke variabel videoUri.
//                                // Contoh, Anda dapat menggunakan FilePicker API jika -verisoersedia.
//                                // Kemudian, Anda dapat menangani URI video yang dipilih sesuai kebutuhan.
//                            },
//                            shape = RoundedCornerShape(20.dp),
//                            modifier = Modifier.fillMaxWidth()
//                                .padding(start = 1.dp, top = 15.dp, bottom = 15.dp, end = 2.dp)
//                                .height(60.dp)
//                                .width(100.dp)
//                                .testTag("upload_button")
//                                .background(colorResource(id = R.color.Abu))
//                                .border(1.dp, colorResource(id = R.color.Purple), shape = RoundedCornerShape(20.dp)),
//                            colors = ButtonDefaults.buttonColors(
//                                backgroundColor = Color.White,
//                                contentColor = colorResource(id = R.color.Purple) // Warna teks ungu (purple)
//                            )
//                        ) {
//                            Text("Unggah Video")
//                        }
//
//                        // Bar chart horizontal
//                        Canvas(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(40.dp) // Tinggi bar chart
//                        ) {
//                            val totalWidth = size.width
//                            val maxValue = 100 // Gantilah ini dengan nilai maksimum yang sesuai
//                            val successPercentage = 70 // Gantilah ini dengan persentase keberhasilan
//                            val notPerfectPercentage = 20 // Gantilah ini dengan persentase tidak sempurna
//                            val notSuccessfulPercentage = 10 // Gantilah ini dengan persentase tidak berhasil
//
//                            val successWidth = (totalWidth * successPercentage / 100).toFloat()
//                            val notPerfectWidth = (totalWidth * notPerfectPercentage / 100).toFloat()
//                            val notSuccessfulWidth = (totalWidth * notSuccessfulPercentage / 100).toFloat()
//
//                            // Menggambar bar chart
//                            drawRect(
//                                color = colorResource(id = R.color.yellow), // Warna untuk kategori berhasil
//                                topLeft = Offset(0f, 0f),
//                                size = Size(successWidth, size.height)
//                            )
//                            drawRect(
//                                color = colorResource(id = R.color.Black), // Warna untuk kategori tidak sempurna
//                                topLeft = Offset(successWidth, 0f),
//                                size = Size(notPerfectWidth, size.height)
//                            )
//                            drawRect(
//                                color = colorResource(id = R.color.orange), // Warna untuk kategori tidak berhasil
//                                topLeft = Offset(successWidth + notPerfectWidth, 0f),
//                                size = Size(notSuccessfulWidth, size.height)
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun SumReportPreview()
//{
//    SumReport(navController = rememberNavController())
//}
