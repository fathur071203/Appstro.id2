package com.example.neurecare.retrofit

import com.example.neurecare.response.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("user")
    fun getUser(
        @Query("login") id : String

    ) : Call<Response>

}