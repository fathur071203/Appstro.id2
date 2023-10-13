package com.example.neurecare.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.ButtonAddMovement
import com.example.neurecare.ui.component.ButtonPrimary
import com.example.neurecare.ui.component.PrimaryTextField
import com.example.neurecare.ui.component.TextContent
import com.example.neurecare.ui.component.addLocation
import com.example.neurecare.ui.navigation.Routes


@Composable
fun AddMovement(navController : NavController) {

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxHeight()) {
        onClickBack()

        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Nama Program")
        Spacer(modifier = Modifier.height(5.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Nama_Kegiatan))
        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Nama Terapis")
        Spacer(modifier = Modifier.height(5.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Nama_Terapis))
        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Daftar Gerakan")
        PrimaryTextField(placeholder = stringResource(id = R.string.Gerakan))
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.Blue_4B),
                    shape = RoundedCornerShape(10.dp)
                )
                .height(50.dp),
            onClick = {
                navController.navigate(Routes.Choice.route)

            },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
            shape = RoundedCornerShape(10.dp),


            ) {
            Text(text = "+ Pilih Gerakan", color = colorResource(id = R.color.Blue_4B))
        }
        Spacer(modifier = Modifier.height(25.dp))
        ButtonPrimary(onClick = { /*TODO*/ }, text = "Simpan Program")
        Spacer(modifier = Modifier.height(15.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun AddMovementPreview() {
    AddMovement(navController = rememberNavController())
}