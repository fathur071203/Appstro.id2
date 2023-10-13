package com.example.neurecare.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neurecare.R


@Composable
fun CalenderBar() {
    Row {
        ButtonAddCalender(onClick = {}, text = "Button")
    }
}

@Composable
fun itemRowCalender(onClick: () -> Unit = {}) {
    Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "8")
            Text(text = "Fri")
        }
        Spacer(modifier = Modifier.width(20.dp))


}

@Composable
fun itemRowAddCalender() {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(color = colorResource(id = R.color.pink))
                .padding(15.dp)
        ) {
            Text(
                text = "Latihan Fisik",
                color = colorResource(id = R.color.Blue_4B),
                fontSize = 16.sp,

                )
            Row(
                modifier = Modifier
                    .padding(top = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.location_on),
                    contentDescription = "Location",
                    tint = colorResource(id = R.color.Blue_4B),)
                Text(text = "Online",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.Blue_4B))
            }
            Row(
                modifier = Modifier
                    .padding(top = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.schedule),
                    contentDescription = "Schedule",
                    tint = colorResource(id = R.color.Blue_4B),
                )


                Text(text = "13.00 PM",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.Blue_4B))
            }
        }

    }


@Preview()
@Composable
fun CalenderBarPreview() {
    itemRowAddCalender()
}