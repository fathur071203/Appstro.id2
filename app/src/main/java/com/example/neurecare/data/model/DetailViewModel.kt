package com.example.neurecare.data.model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neurecare.data.datadummy.DataDetailProgram
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DetailViewModel : ViewModel(){

    val state = mutableStateOf(DataDetailProgram())


    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getDataDetailProgram()
        }
    }
}

suspend fun getDataDetailProgram(): DataDetailProgram{
    val db = FirebaseFirestore.getInstance()
    var dataDetailProgram = DataDetailProgram()

    try {
         db.collection("data_program").get().await().map {
            val result = it.toObject(DataDetailProgram::class.java)
            dataDetailProgram = result
        }

    }
    catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataDetailProgram(): $e")
    }

    return dataDetailProgram

}