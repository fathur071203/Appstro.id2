package com.example.neurecare.ui.screen


import android.content.Context
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.neurecare.R
import com.example.neurecare.ui.component.JProgram
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util



@Composable
fun detailScreenVideo(
    navController: NavController

    ) {

    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()){
            IconButton(onClick = {
                navController.previousBackStackEntry?.savedStateHandle
                navController.popBackStack()
            },
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp, bottom = 15.dp)
                    .clip(CircleShape)
                    .size(60.dp)
                    .testTag("pause_button")
                    .background(colorResource(id = R.color.teal_700))

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription =null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.Center, // Mengatur penataan vertikal menjadi tengah
            horizontalAlignment = Alignment.CenterHorizontally, // Mengatur penataan horizontal menjadi tengah
            modifier = Modifier
                .fillMaxWidth()
//                .padding(15.dp)
                .width(300.dp)
                .height(175.dp)) {

            playVideo(context = navController.context)

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier
            .padding(25.dp)
        ) {
            Row() {
                Icon(painter = painterResource(id = R.drawable.accessibility), contentDescription = null, tint = colorResource(
                    id = R.color.orange ), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(13.dp))
                JProgram(text = "Nama Gerakan", description = "Pokoknya bisa")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Icon(painter = painterResource(id = R.drawable.description), contentDescription = null, tint = colorResource(
                    id = R.color.orange ), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(13.dp))
                JProgram(text = "Gerakan", description = "Semangatt")
            }
        }
    }
}

@Composable
fun playVideo(context: Context) {

    val videoUrl =
        "https://storage.googleapis.com/video-assets-appstro/VID_20230907_211719.mp4"

    val exoPlayer = remember(context) {
        SimpleExoPlayer.Builder(context).build().apply {
            val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
                context,
                Util.getUserAgent(context, context.packageName)
            )

            val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(videoUrl))

            this.prepare(source)
        }
    }

    AndroidView(factory = { context ->
        PlayerView(context).apply {
            player = exoPlayer
        }
    })
}











