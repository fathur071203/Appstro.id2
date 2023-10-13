package com.example.neurecare.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neurecare.R
import com.example.neurecare.ui.navigation.Routes

@Composable
fun SumReport(navController: NavController) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(340.dp)
            .height(200.dp)
            .background(colorResource(id = R.color.white))
            .border(width = 2.dp, colorResource(id = R.color.white))
    ) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier.padding(15.dp)) {

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(colorResource(id = R.color.Abu))
                        .width(300.dp)
                        .height(160.dp)
                ) {

                    Column(modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(vertical = 10.dp)
                        .fillMaxWidth()
                    ) {
                        Text("Mengangkat Bahu", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.weight(2f))
                        //  Memanggil komponen bar chart horizontal
                        HorizontalBarChart()

                        Button(
                            onClick = {
                               navController.navigate(Routes.PoseDetectionScreen.route)
                            },
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier.fillMaxWidth()
                                .padding(start = 1.dp, top = 15.dp, bottom = 15.dp, end = 2.dp)
                                .height(40.dp)
                                .width(70.dp)
                                .testTag("report_button")
                                .background(colorResource(id = R.color.Abu)),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.White,
                                contentColor = colorResource(id = R.color.Purple)
                            )
                        ) {
                            Text("Lihat Laporan")
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun HorizontalBarChart() {
    val data = listOf(
        BarChartData("Berhasil", 0.3f, Color.Green),
        BarChartData("Tidak Sempurna", 0.4f, Color.Yellow),
        BarChartData("Tidak Berhasil", 0.3f, Color.Red)
    )

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .width(10.dp)
    ) {
        var startX = 0f
        data.forEach { barData ->
            val barWidth = size.width * barData.percentage
            drawRect(
                color = barData.color,
                topLeft = Offset(startX, 1f),
                size = Size(barWidth, size.height)
            )

            val text = "${(barData.percentage * 100).toInt()}%" // Menghitung persentase
            val textWidth = size.width * 0.2f // Lebar teks
            val textX = startX + (barWidth - textWidth) / 2
            val textY = size.height + 10f // Margin bawah teks dari batang

            drawIntoCanvas { canvas ->
                val paint = android.graphics.Paint().apply {
                    color = Color.Black.toArgb()
                    textSize = 12.sp.toPx()
                }
                canvas.nativeCanvas.drawText(text, textX, textY, paint)
            }


            startX += barWidth
        }
    }
}

data class BarChartData(val label: String, val percentage: Float, val color: Color)


@Preview(showBackground = true)
@Composable
fun SumReportPreview()
{
    SumReport(navController = rememberNavController())
}
