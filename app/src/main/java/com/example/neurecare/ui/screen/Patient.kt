package com.example.neurecare.ui.screen


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.neurecare.R
import com.example.neurecare.ui.navigation.Routes


@Composable
fun Patient() {

    }




@Composable
fun RowItemPatient(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Daftar Pasien", modifier = Modifier.padding( 16.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.filter_list),
                    contentDescription = "Add"
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(
                        "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
                    ).crossfade(true).build(),
                    contentDescription = "ImagePatient",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(8.dp)
                        .border(1.dp, color = colorResource(id = R.color.Purple), CircleShape)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(text = "Fathur")
            }
            Button(
                onClick = {
                    navController.navigate(Routes.ProfilePatient.route)

                },
                Modifier
                    .height(33.dp)
                    .padding(end = 10.dp)
            ) {
                Text(text = "Perlu review")

            }
        }

    }

}



@Composable
@Preview(showBackground = true)
fun ShowPatient() {
    RowItemPatient(navController = rememberNavController())
}