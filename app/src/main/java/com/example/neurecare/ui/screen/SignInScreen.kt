package com.example.neurecare.ui.screen

import androidx.compose.material.Button
import androidx.compose.material.Text
import com.example.neurecare.ui.navigation.Routes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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


@Composable
fun SignInScreen(navController:NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.Blue_4B))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = null,
            tint = colorResource(id = R.color.teal_700)
                .copy(alpha = 0.3f),
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 220.dp)
                .width(390.dp)
                .height(631.dp)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            LogInTitle()
            Spacer(modifier = Modifier.height(30.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                TextContent(title = stringResource(id = R.string.Username))
                Spacer(modifier = Modifier.height(4.dp))
                PrimaryTextField(placeholder = "Username")
                Spacer(modifier = Modifier.height(25.dp))
                TextContent(title = stringResource(id = R.string.password))
                Spacer(modifier = Modifier.height(4.dp))
                PasswordTextField(placeholder = stringResource(id = R.string.password))
                Spacer(modifier = Modifier.height(20.dp))
                ButtonPrimary(
                    text = "Log In",
                    onClick = {
                        navController.navigate(Routes.Dashboard.route) {
                            popUpTo(Routes.Login.route){
                                inclusive = true
                            }
                        }


                    }
                )

            }
            Spacer(modifier = Modifier.height(70.dp))
            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Anda tidak memiliki akun?", textAlign = TextAlign.Center)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Silahkan")
                    TextButton(onClick = {
                        navController.navigate(Routes.Register.route) {
                            popUpTo(Routes.Login.route){
                                inclusive = true
                            }
                        }

                    }) {
                        Text(text = "Sign Up", textDecoration = TextDecoration.Underline, color = colorResource(
                            id = R.color.brown))
                    }

                }
            }

        }
    }
//    fun handleLogin() {
//        // Dapatkan username dan password dari input pengguna
//        val username = "Username" // Ganti dengan nilai yang benar dari TextField
//        val password = "Password" // Ganti dengan nilai yang benar dari PasswordTextField
//
//        // Ganti URL API dengan URL yang sesuai
//        val apiUrl = "http://35.239.178.213:5000/api/v1/user"
//
//        // Lakukan panggilan API untuk mendapatkan data pengguna
//        val userData = getUserDataFromApi(apiUrl)
//
//        // Periksa apakah username dan password sesuai dengan data pengguna
//        if (userData != null && username == userData.username && password == userData.password) {
//            // Jika sesuai, navigasi ke dashboard
//            navController.navigate(Routes.Dashboard.route) {
//                popUpTo(Routes.Login.route) {
//                    inclusive = true
//                }
//            }
//        } else {
//            // Jika tidak sesuai, tampilkan pesan kesalahan atau notifikasi kesalahan
//            // Misalnya: showError("Username atau password salah")
//        }
//    }

}

@Composable
fun LogInTitle(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Log In", fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally), fontWeight = FontWeight.SemiBold,
            color = colorResource(
                id = R.color.brown
            ))
    }
}



@Preview(showBackground = true)
@Composable
fun LoginScreePreview(){
    SignInScreen(navController = rememberNavController())
}