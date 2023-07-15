package com.example.neurecare.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neurecare.R


@Composable
fun PrimaryTextField(placeholder: String){

    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }


    OutlinedTextField(value = text , onValueChange = {
        text = it
    },
        maxLines = 1,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        singleLine = true,
        placeholder = {
            Text(text = placeholder)

        }
    )

}

@Composable
fun TextContent(title: String){
    Text(text = title, fontSize = 14.sp, color = colorResource(id = R.color.brown))

}

@Composable
fun TitleContent(title: String){
    Text(text = title, fontSize = 12.sp, color = colorResource(id = R.color.teal_700), fontWeight = FontWeight.Medium)
}


@Preview(showBackground = true)
@Composable
fun PrimaryTextFiledPreview() {
    TextContent("Primary")
}