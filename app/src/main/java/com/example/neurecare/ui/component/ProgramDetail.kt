package com.example.neurecare.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.neurecare.R


@Composable
fun JProgram(text: String, description: String){
    Column() {
        Text(text, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = colorResource(id = R.color.brown))
        Text(description, fontSize = 14.sp, color = colorResource(id = R.color.brown))
    }

}
