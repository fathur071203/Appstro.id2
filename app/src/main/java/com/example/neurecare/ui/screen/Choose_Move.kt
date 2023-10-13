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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.neurecare.ui.component.PrimaryTextFieldSearch
import com.example.neurecare.ui.component.TextContent
import com.example.neurecare.ui.navigation.Routes

@Composable
fun ChooseM(navController: NavController) {
    var selectedImages by remember { mutableStateOf(emptyList<Photo>()) }
    val movements = remember { mutableStateOf(emptyList<Photo>()) }
    Column(modifier = Modifier.padding(16.dp)) {
        Choose()
        Spacer(modifier = Modifier.height(10.dp))
        PrimaryTextFieldSearch(placeholder = stringResource(id =  R.string.Cari_Gerakan))
        Spacer(modifier = Modifier.height(10.dp))
        PhotosGrid()
        Spacer(modifier = Modifier.height(15.dp))
        ButtonPrimary(onClick = {
            navController.navigate(Routes.AddMovement.route)
            movements.value = movements.value + selectedImages
            selectedImages = emptyList()
        }, text = "Tambah Gerakan")


    }
}

@Composable
fun Choose() {
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
            "Pilih Gerakan",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.Blue_4B),
            modifier = Modifier.weight(1f) // Menggunakan weight untuk memberikan ruang yang sama pada gambar dan teks
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChooseA() {
    ChooseM(navController = rememberNavController())
}
