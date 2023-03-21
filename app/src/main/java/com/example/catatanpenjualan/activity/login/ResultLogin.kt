package com.example.catatanpenjualan.activity.login

import com.example.catatanpenjualan.model.User
import com.google.gson.annotations.SerializedName

data class ResultLogin(

	@field:SerializedName("pesan")
	val massage: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: String? = null
)