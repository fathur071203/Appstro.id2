package com.example.neurecare.response

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
