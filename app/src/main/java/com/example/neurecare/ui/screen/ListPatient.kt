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
fun ListPatient(navController: NavController) {
    BackListPatient()

}

@Composable
fun BackListPatient() {
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
            "Daftar Pasien",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.Blue_4B),
            modifier = Modifier.weight(1f) // Menggunakan weight untuk memberikan ruang yang sama pada gambar dan teks
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListPatientPriview() {
    ListPatient(navController = rememberNavController())
}
