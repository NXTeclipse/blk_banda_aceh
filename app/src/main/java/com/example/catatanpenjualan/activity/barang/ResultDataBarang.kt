package com.example.catatanpenjualan.activity.barang

import com.google.gson.annotations.SerializedName

data class ResultDataBarang(

	@field:SerializedName("barang")
	val barang: List<Barang?>? = null
)