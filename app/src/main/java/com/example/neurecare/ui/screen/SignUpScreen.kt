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
fun SignUpScreen(navController: NavController){
    Column(modifier = Modifier.padding(16.dp
    )) {
        SignUpTitle()

        Spacer(modifier = Modifier.height(20.dp))
        TextContent(title = "Username")
        Spacer(modifier = Modifier.height(3.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.username))
        Spacer(
            modifier = Modifier.height(15.dp)
        )
        TextContent(title = "Nama Lengkap")
        Spacer(modifier = Modifier.height(3.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Nama_lengkap))
        Spacer(
            modifier = Modifier.height(15.dp)
        )
        TextContent(title = "Email")
        Spacer(modifier = Modifier.height(3.dp))
        PrimaryTextField(placeholder = stringResource(id =  R.string.Email))
        Spacer(
            modifier = Modifier.height(15.dp)
        )
        TextContent(title = "Password")
        Spacer(modifier = Modifier.height(3.dp))
        PasswordTextField(placeholder = stringResource(id = R.string.password))
        Spacer(
            modifier = Modifier.height(15.dp)
        )
        TextContent(title = "Confirm Password")
        Spacer(modifier = Modifier.height(3.dp))
        PasswordTextField(placeholder = stringResource(id = R.string.password))
        Spacer(modifier = Modifier.height(20.dp))

        ButtonPrimary(onClick = { /*TODO*/ }, text = "Sign Up")
        Spacer(modifier = Modifier.height(15.dp))
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Already have an account?", textAlign = TextAlign.Center)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Silahkan")
                TextButton(onClick = {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Register.route){
                            inclusive = true
                        }
                    }

                }) {
                    Text(text = "Login", textDecoration = TextDecoration.Underline, color = colorResource(
                        id = R.color.brown))
                }

            }
        }

    }


}



@Composable
fun SignUpTitle(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Sign Up", fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally), fontWeight = FontWeight.SemiBold,
            color = colorResource(
                id = R.color.brown
            ))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpTitlePreview(){
    SignUpScreen(navController = rememberNavController())

}