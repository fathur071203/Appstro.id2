package com.example.neurecare.data.model

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neurecare.response.Response
import com.example.neurecare.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback

class MainViewModel : ViewModel() {

    val result = MutableLiveData<List<Response>>()
    val loading = MutableLiveData(View.GONE)
    val error = MutableLiveData<String>()


    fun searchResults(key: String){
        loading.postValue(View.VISIBLE)
        val client = ApiConfig.getApiService().getUser(key)
        client.enqueue(object : Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    companion object {
        private const val TAG = "MainViewModel"
    }

}