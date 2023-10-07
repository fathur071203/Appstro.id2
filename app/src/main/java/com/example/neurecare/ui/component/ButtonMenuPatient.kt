package com.example.neurecare.ui.component

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.navigation.Routes


@Composable
fun ButtonMenuPatient(navController: NavController) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(350.dp)
            .height(160.dp)
            .background(colorResource(id = R.color.white))
            .border(width = 2.dp, colorResource(id = R.color.white))
    ) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier.padding(0.dp)) {

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(colorResource(id = R.color.white))
                        .width(350.dp)
                        .height(254.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(vertical = 10.dp)
                    ) {
                        Button(
                            onClick = {
                                // Tambahkan aksi yang sesuai di sini untuk tombol "Program"
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .height(60.dp)
                                .width(155.dp)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.Purple),
                                contentColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                // Tambahkan gambar XML di sini
                                Image(
                                    painter = painterResource(id = R.drawable.program), // Ganti dengan res ID gambar XML Anda
                                    contentDescription = null, // Isi dengan deskripsi gambar jika diperlukan
                                    modifier = Modifier.size(40.dp) // Sesuaikan ukuran gambar sesuai kebutuhan Anda
                                )

                                Text("Program", fontSize = 15.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp)) // Add some spacing between buttons

                        Button(
                            onClick = {
                                // Tambahkan aksi yang sesuai di sini untuk tombol "Tanggal Lahir"
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .height(60.dp)
                                .width(155.dp)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.Purple),
                                contentColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Text("Riwayat", fontSize = 15.sp)
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp)) // Add some spacing between columns

                    Column(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                    ) {
                        Button(
                            onClick = {
                                // Tambahkan aksi yang sesuai di sini untuk tombol "Jenis Kelamin"
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .height(60.dp)
                                .width(155.dp)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.Purple),
                                contentColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.jadwal), // Ganti dengan res ID gambar XML Anda
                                contentDescription = null, // Isi dengan deskripsi gambar jika diperlukan
                                modifier = Modifier.size(40.dp) // Sesuaikan ukuran gambar sesuai kebutuhan Anda
                            )

                            Text("Jadwal", fontSize = 15.sp)
                        }

                        Spacer(modifier = Modifier.height(10.dp)) // Add some spacing between buttons

                        Button(
                            onClick = {
                                // Tambahkan aksi yang sesuai di sini untuk tombol "Alamat"
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .height(60.dp)
                                .width(155.dp)
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = colorResource(id = R.color.Purple),
                                contentColor = colorResource(id = R.color.white)
                            )
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.laporan), // Ganti dengan res ID gambar XML Anda
                                contentDescription = null, // Isi dengan deskripsi gambar jika diperlukan
                                modifier = Modifier.size(40.dp) // Sesuaikan ukuran gambar sesuai kebutuhan Anda
                            )

                            Text("Laporan", fontSize = 15.sp)
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ButtonMenuPatientPreview()
{
    ButtonMenuPatient(navController = rememberNavController())
}
