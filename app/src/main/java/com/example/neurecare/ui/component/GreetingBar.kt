package com.example.neurecare.ui.component

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neurecare.R



@Composable
fun GreetingBar() {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(20, 20, 40, 40))
        .background(colorResource(id = R.color.Purple))
        .width(350.dp)
        .height(144.dp))
    {
        Row(modifier = Modifier) {
            Text("Selamat Datang, James!",
                modifier = Modifier
                    .padding(15.dp)
                    .wrapContentSize()
                    .weight(1f)
                    .padding(start = 10.dp),
                color = colorResource(id = R.color.white),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp



            )
            Icon(painter = painterResource(id = R.drawable.vector), contentDescription = null, modifier = Modifier
                .alpha(0.3f)
                .size(200.dp))

        }

    }

}


@Preview
@Composable
fun GreetingPreview(){
    GreetingBar()
}