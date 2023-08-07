//package com.example.neurecare.ui.screen
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.GenericTypeIndicator
//import com.google.firebase.database.ValueEventListener
//import com.google.firebase.database.ktx.database
//import com.google.firebase.ktx.Firebase
//
//
//class PoseDetectionActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PoseDetectionScreen()
//        }
//    }
//}
//
//@Composable
//fun PoseDetectionScreen() {
//    Surface(color = MaterialTheme.colorScheme.background) {
//        var shoulderRightAngle by remember { mutableStateOf(0.0) }
//        var shoulderLeftAngle by remember { mutableStateOf(0.0) }
//
//        val databaseReference = Firebase.database.reference.child("pose_detection_results")
//        LaunchedEffect(Unit) {
//            val dataListener = object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    val dataType = object : GenericTypeIndicator<Map<String, Double>>() {}
//                    val data = snapshot.getValue(dataType)
//                    if (data != null) {
//                        shoulderRightAngle = data["Sudut Bahu Kanan"] ?: 0.0
//                        shoulderLeftAngle = data["Sudut Bahu Kiri"] ?: 0.0
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    // Handle jika ada error dalam mengambil data dari database
//                }
//            }
//            databaseReference.addValueEventListener(dataListener)
//
////            onDispose {
////                databaseReference.removeEventListener(dataListener)
////            }
//        }
//
//        Column(
//            modifier = Modifier.fillMaxSize().padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Hasil Deteksi Pose",
//                style = MaterialTheme.typography.titleLarge,
//                modifier = Modifier.padding(8.dp)
//            )
//
//            Text(
//                text = "Derajat Bahu Kanan: $shoulderRightAngle",
//                style = MaterialTheme.typography.titleLarge,
//                modifier = Modifier.padding(8.dp)
//            )
//
//            Text(
//                text = "Derajat Bahu Kiri: $shoulderLeftAngle",
//                style = MaterialTheme.typography.titleLarge,
//                modifier = Modifier.padding(8.dp)
//            )
//
//
//
//            // ...
//
//
//            Button(
//                onClick = { /* Handle laporan hasil deteksi di sini */ },
//                modifier = Modifier.padding(top = 16.dp)
//            ) {
//                Text(text = "Laporkan")
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    PoseDetectionScreen()
//}
