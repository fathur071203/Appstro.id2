package com.example.neurecare.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neurecare.R

@Composable
fun ButtonPrimary(onClick: () -> Unit, text: String){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(59.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Blue_4B)),
        shape = RoundedCornerShape(20.dp),) {
        Text(text = text, fontSize = 16.sp, color = Color.White)

    }

}