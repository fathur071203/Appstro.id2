package com.example.neurecare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.ButtonPrimary
import com.example.neurecare.ui.component.PrimaryTextField
import com.example.neurecare.ui.component.TextContent
import com.example.neurecare.ui.navigation.Routes

@Composable
fun AddMove(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        MoveAdd()

        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Nama Gerakan")
        Spacer(modifier = Modifier.height(5.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Nama_Gerakan))
        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Deskripsi")
        Spacer(modifier = Modifier.height(5.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Deskripsi))
        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Derajat Gerakan")
        Spacer(modifier = Modifier.height(5.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Batas_Derajat_Gerakan))
// Button for uploading video
        TextContent(title = "Video Gerakan")
        Button(
            onClick = {
                // Anda dapat membuka pemilih file di sini untuk membiarkan pengguna memilih file video
                // dan mengatur URI video yang dipilih ke variabel videoUri.
                // Contoh, Anda dapat menggunakan FilePicker API jika  -verisoersedia.
                // Kemudian, Anda dapat menangani URI video yang dipilih sesuai kebutuhan.
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, top = 15.dp, bottom = 15.dp)
                .size(60.dp)
                .testTag("upload_button")
                .background(colorResource(id = R.color.white))
                .border(1.dp, colorResource(id = R.color.Purple), shape = RoundedCornerShape(20.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = colorResource(id = R.color.Purple) // Warna teks ungu (purple)
            )
        ) {
            Text("Unggah Video")
        }

        Spacer(modifier = Modifier.height(175.dp))

        ButtonPrimary(onClick = { /*TODO*/ }, text = "Tambah Gerakan")
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun MoveAdd() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.back), // Ganti dengan ID sumber daya gambar yang sesuai
            contentDescription = "Back",
            modifier = Modifier.size(30.dp)
        )
        Text(
            "Tambah Gerakan",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.Blue_4B),
            modifier = Modifier.weight(1f) // Menggunakan weight untuk memberikan ruang yang sama pada gambar dan teks
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Move() {
    AddMove(navController = rememberNavController())
}
