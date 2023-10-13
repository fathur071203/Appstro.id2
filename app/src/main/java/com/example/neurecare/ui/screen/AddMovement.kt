package com.example.neurecare.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neurecare.R
import com.example.neurecare.ui.component.ButtonAddMovement
import com.example.neurecare.ui.component.ButtonPrimary
import com.example.neurecare.ui.component.PrimaryTextField
import com.example.neurecare.ui.component.TextContent
import com.example.neurecare.ui.component.addLocation


@Composable
fun AddMovement() {
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
        ButtonAddMovement(onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(25.dp))
        ButtonPrimary(onClick = { /*TODO*/ }, text = "Tambah Gerakan")
        Spacer(modifier = Modifier.height(15.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun AddMovementPreview() {
    AddMovement()
}