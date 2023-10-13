package com.example.neurecare.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.example.neurecare.ui.component.addLocation
import com.example.neurecare.ui.navigation.Routes

@Composable
fun ActivityAdd(navController: NavController) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        onClickBack()

        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Nama Kegiatan")
        Spacer(modifier = Modifier.height(5.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Nama_Kegiatan))
        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Nama Terapis")
        Spacer(modifier = Modifier.height(5.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Nama_Terapis))
        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Lokasi")
        addLocation()
        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Waktu")
        PrimaryTextField(placeholder = stringResource(id =  R.string.Waktu))
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(175.dp))

        ButtonPrimary(onClick = { /*TODO*/ }, text = "Tambah Gerakan")
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun onClickBack(

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.back), contentDescription ="Back" )
            
        }
        Text(
            "Tambah Kegiatan",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.Blue_4B),
            modifier = Modifier
                .weight(1f) // Menggunakan weight untuk memberikan ruang yang sama pada gambar dan teks
                .padding(start = 5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Activity() {
    ActivityAdd(navController = rememberNavController())
}
