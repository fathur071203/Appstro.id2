package com.example.neurecare.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neurecare.R


@Composable
fun ButtonAddMovement(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.Blue_4B),
                shape = RoundedCornerShape(10.dp)
            )
            .height(50.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),
        shape = RoundedCornerShape(10.dp),


        ) {
        Text(text = "+ Tambah Gerakan", color = colorResource(id = R.color.Blue_4B))
    }
}

@Composable
@Preview(showBackground = true)
fun ButtonAddMovementPreview() {
    ButtonAddMovement(onClick = {})
}