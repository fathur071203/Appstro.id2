package com.example.neurecare.ui.screen

import android.os.Bundle
import kotlinx.coroutines.*
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun LineChartView(entries: List<Entry>, modifier: Modifier) {
    val density = LocalDensity.current.density

    AndroidView(
        factory = { context ->
            LineChart(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    (300.dp * density).toInt()
                )

                val xAxis = xAxis
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.setDrawGridLines(false)

                axisRight.isEnabled = false
                axisLeft.granularity = 1f

                val dataSet = LineDataSet(entries, "Data Label")
                dataSet.color = ColorTemplate.getHoloBlue()
                dataSet.valueTextSize = 10f

                val lineData = LineData(dataSet)
                data = lineData
            }
        },
        modifier = modifier
    )
}
private fun Dp.toInt(): Int {
    return value.toInt()
}


@Composable
fun PoseDetectionScreen(navController: NavController) {
    Surface(color = MaterialTheme.colorScheme.background) {
        val entriesBahuKanan = remember { mutableStateListOf<Entry>() }
        val entriesBahuKiri = remember { mutableStateListOf<Entry>() }
        val entriesLututKanan = remember { mutableStateListOf<Entry>() }
        val entriesLututKiri = remember { mutableStateListOf<Entry>() }
        val entriesPinggulKanan = remember { mutableStateListOf<Entry>() }
        val entriesPinggulKiri = remember { mutableStateListOf<Entry>() }
        val entriesTanganKanan = remember { mutableStateListOf<Entry>() }
        val entriesTanganKiri = remember { mutableStateListOf<Entry>() }

        val databaseReference = Firebase.database.reference.child("pose_detection_results")
        LaunchedEffect(Unit) {
            val dataListener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    entriesBahuKanan.clear()
                    entriesBahuKiri.clear()
                    entriesTanganKanan.clear()
                    entriesTanganKiri.clear()
                    entriesLututKanan.clear()
                    entriesLututKiri.clear()
                    entriesPinggulKanan.clear()
                    entriesPinggulKiri.clear()


                    if (snapshot.hasChildren()) {
                        val childrenSnapshots = snapshot.children
                        childrenSnapshots.forEach { childSnapshot ->
                            val xValue = childSnapshot.key?.toFloatOrNull() ?: 0.0f

                            // Sudut Bahu Kanan
                            val yValueBahuKanan = childSnapshot.child("Sudut Bahu Kanan").getValue(Double::class.java)?.toFloat() ?: 0.0f
                            entriesBahuKanan.add(Entry(xValue, yValueBahuKanan))

                            // Sudut Bahu Kiri
                            val yValueBahuKiri = childSnapshot.child("Sudut Bahu Kiri").getValue(Double::class.java)?.toFloat() ?: 0.0f
                            entriesBahuKiri.add(Entry(xValue, yValueBahuKiri))

                            // Sudut Lutut Kiri
                            val yValueLututKiri = childSnapshot.child("Sudut Lutut Kiri").getValue(Double::class.java)?.toFloat() ?: 0.0f
                            entriesLututKiri.add(Entry(xValue, yValueLututKiri))

                            // Sudut Lutut Kanan
                            val yValueLututKanan = childSnapshot.child("Sudut Lutut Kanan").getValue(Double::class.java)?.toFloat() ?: 0.0f
                            entriesLututKanan.add(Entry(xValue, yValueLututKanan))

                            // Sudut Pinggul Kiri
                            val yValuePinggulKiri = childSnapshot.child("Sudut Pinggul Kiri").getValue(Double::class.java)?.toFloat() ?: 0.0f
                            entriesPinggulKiri.add(Entry(xValue, yValuePinggulKiri))

                            // Sudut Pinggul Kanan
                            val yValuePinggulKanan = childSnapshot.child("Sudut Pinggul Kanan").getValue(Double::class.java)?.toFloat() ?: 0.0f
                            entriesPinggulKanan.add(Entry(xValue, yValuePinggulKanan))

                            // Sudut Tangan Kanan
                            val yValueTanganKanan = childSnapshot.child("Sudut Tangan Kanan").getValue(Double::class.java)?.toFloat() ?: 0.0f
                            entriesTanganKanan.add(Entry(xValue, yValueTanganKanan))

                            // Sudut Tangan Kiri
                            val yValueTanganKiri = childSnapshot.child("Sudut Tangan Kiri").getValue(Double::class.java)?.toFloat() ?: 0.0f
                            entriesTanganKiri.add(Entry(xValue, yValueTanganKiri))
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle if there's an error retrieving data from the database
                }
            }
            databaseReference.addValueEventListener(dataListener)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                // Sudut Bahu Kanan
                if (entriesBahuKanan.isNotEmpty()) {
                    Text(
                        text = "Sudut Bahu Kanan",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    LineChartView(
                        entries = entriesBahuKanan,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(
                        text = "Tidak ada data ditemukan",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                // Sudut Bahu Kiri
                if (entriesBahuKiri.isNotEmpty()) {
                    Text(
                        text = "Sudut Bahu Kiri",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    LineChartView(
                        entries = entriesBahuKiri,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(
                        text = "Tidak ada data ditemukan",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                // Sudut Lutut Kanan
                if (entriesLututKanan.isNotEmpty()) {
                    Text(
                        text = "Sudut Lutut Kanan",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    LineChartView(
                        entries = entriesLututKanan,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(
                        text = "Tidak ada data ditemukan",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                // Sudut Lutut Kiri
                if (entriesLututKiri.isNotEmpty()) {
                    Text(
                        text = "Sudut Lutut Kiri",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    LineChartView(
                        entries = entriesLututKiri,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(
                        text = "Tidak ada data ditemukan",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                // Sudut Pinggul Kanan
                if (entriesPinggulKanan.isNotEmpty()) {
                    Text(
                        text = "Sudut Pinggul Kanan",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    LineChartView(
                        entries = entriesPinggulKanan,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(
                        text = "Tidak ada data ditemukan",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                // Sudut Pinggul Kiri
                if (entriesPinggulKiri.isNotEmpty()) {
                    Text(
                        text = "Sudut Pinggul Kiri",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    LineChartView(
                        entries = entriesPinggulKiri,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(
                        text = "Tidak ada data ditemukan",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                // Sudut Tangan Kanan
                if (entriesTanganKanan.isNotEmpty()) {
                    Text(
                        text = "Sudut Tangan Kanan",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    LineChartView(
                        entries = entriesTanganKanan,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(
                        text = "Tidak ada data ditemukan",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                // Sudut Tangan Kiri
                if (entriesTanganKiri.isNotEmpty()) {
                    Text(
                        text = "Sudut Tangan Kiri",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    LineChartView(
                        entries = entriesTanganKiri,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                } else {
                    Text(
                        text = "Tidak ada data ditemukan",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PoseDetectionScreen(navController = rememberNavController())
}
