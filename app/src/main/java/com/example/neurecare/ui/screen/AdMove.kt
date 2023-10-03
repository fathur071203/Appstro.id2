package com.example.neurecare.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.ButtonPrimary
import com.example.neurecare.ui.component.PasswordTextField
import com.example.neurecare.ui.component.PrimaryTextField
import com.example.neurecare.ui.component.TextContent
import com.example.neurecare.ui.navigation.Routes


@Composable
fun AddMove(navController: NavController){
    MoveAdd()
    Column(modifier = Modifier.padding(16.dp
    )) {

        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Nama Gerakan")
        Spacer(modifier = Modifier.height(3.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Nama_Gerakan))
        Spacer(
            modifier = Modifier.height(15.dp)
        )
        TextContent(title = "Deskripsi")
        Spacer(modifier = Modifier.height(3.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Deskripsi))
        Spacer(
            modifier = Modifier.height(15.dp)
        )
        TextContent(title = "Video Gerakan")
        Spacer(modifier = Modifier.height(3.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Email))
        Spacer(
            modifier = Modifier.height(175.dp)
        )


        ButtonPrimary(onClick = { /*TODO*/ }, text = "Tambah Gerakan")
        Spacer(modifier = Modifier.height(15.dp))

    }


}



@Composable
fun MoveAdd(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Tambah Gerakan", fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally), fontWeight = FontWeight.SemiBold,
            color = colorResource(
                id = R.color.Purple
            ))
    }
}

@Preview(showBackground = true)
@Composable
fun Move(){
    AddMove(navController = rememberNavController())

}