package com.example.neurecare.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PasswordTextField(placeholder: String) {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var passwordVisible by rememberSaveable {
        mutableStateOf(false)

    }

    OutlinedTextField(value = text, onValueChange = {
        text = it
    },
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        maxLines = 1,
        singleLine = true,
        shape = RoundedCornerShape(20.dp),
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible) {
                Icons.Outlined.Visibility
            } else {
                Icons.Outlined.VisibilityOff

            }
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, contentDescription = null)
            }


        })

}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    Column(modifier = Modifier.padding(10.dp)) {
        PasswordTextField(placeholder = "Password")
    }
}

