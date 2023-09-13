package com.example.neurecare.ui.screen

import android.os.Bundle
import kotlinx.coroutines.*
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.github.mikephil.charting.utils.ColorTemplate



@Composable
fun PoseDetectionScreen(navController: NavController) {
    Surface(color = MaterialTheme.colorScheme.background) {
        var shoulderRightAngle by remember { mutableStateOf(0.0) }
        var shoulderLeftAngle by remember { mutableStateOf(0.0) }
        var SikuRightAngle by remember { mutableStateOf(0.0) }
        var SikuLeftAngle by remember { mutableStateOf(0.0) }
        var PinggulRightAngle by remember { mutableStateOf(0.0) }
        var PinggulLeftAngle by remember { mutableStateOf(0.0) }
        var LututRightAngle by remember { mutableStateOf(0.0) }
        var LututLeftAngle by remember { mutableStateOf(0.0) }
        val entries = remember { mutableStateListOf<Entry>() } // Use mutableStateListOf to update the list
        val lineChartScope = rememberCoroutineScope()

        LaunchedEffect(shoulderRightAngle) {
            lineChartScope.launch {
                while (true) {
                    entries.add(Entry(entries.size.toFloat(), shoulderRightAngle.toFloat()))
                    // Limit the number of entries to, for example, show data for the last 10 seconds
                    if (entries.size > 10) {
                        entries.removeAt(0)
                    }

                    delay(1000) // Delay for 1 second
                }
            }
        }

        val databaseReference = Firebase.database.reference.child("pose_detection_results")
        LaunchedEffect(Unit) {
            val dataListener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val dataType = object : GenericTypeIndicator<Map<String, Double>>() {}
                    val data = snapshot.getValue(dataType)
                    if (data != null) {
                        shoulderRightAngle = data["Sudut Bahu Kanan"] ?: 0.0
                        shoulderLeftAngle = data["Sudut Bahu Kiri"] ?: 0.0
                        SikuRightAngle = data["Sudut Tangan Kanan"] ?: 0.0
                        SikuLeftAngle = data["Sudut Tangan Kiri"] ?: 0.0
                        PinggulRightAngle = data["Sudut Pinggul Kanan"] ?: 0.0
                        PinggulLeftAngle = data["Sudut Pinggul Kiri"] ?: 0.0
                        LututLeftAngle = data["Sudut Lutut Kiri"] ?: 0.0
                        LututRightAngle = data["Sudut Lutut Kiri"] ?: 0.0

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle jika ada error dalam mengambil data dari database
                }
            }
            databaseReference.addValueEventListener(dataListener)

//            onDispose {
//                databaseReference.removeEventListener(dataListener)
//            }
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hasil Deteksi Pose",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Derajat Bahu Kanan: $shoulderRightAngle",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Derajat Bahu Kiri: $shoulderLeftAngle",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )

            val density = LocalDensity.current
            val pxHeight = with(density) { 300.dp.toPx() }

            AndroidView(
                factory = { context ->
                    LineChart(context).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            pxHeight.toInt()
                        )

                        // Konfigurasi sumbu X
                        val xAxis = xAxis
                        xAxis.position = XAxis.XAxisPosition.BOTTOM
                        xAxis.setDrawGridLines(false)
                        // Lainnya konfigurasi sumbu X

                        // Konfigurasi sumbu Y
                        axisRight.isEnabled = false
                        axisLeft.granularity = 1f
                        // Lainnya konfigurasi sumbu Y

                        val entries = mutableListOf<Entry>()
                        // Anda perlu mengisi entries dengan data derajat dan waktu yang sesuai
                        entries.add(Entry(0f, shoulderRightAngle.toFloat())) // Contoh, waktu 0 detik
                        entries.add(Entry(1f, 360f)) // Contoh, waktu 1 detik

                        val dataSet = LineDataSet(entries, "Derajat Bahu Kanan")
                        dataSet.color = ColorTemplate.getHoloBlue()
                        dataSet.valueTextSize = 10f

                        val lineData = LineData(dataSet)
                        data = lineData
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )


            Button(
                onClick = { /* Handle laporan hasil deteksi di sini */ },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Laporkan")
            }
        }
    }
}


