package com.example.catatanpenjualan

import com.google.gson.annotations.SerializedName

data class ResultSimple(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)