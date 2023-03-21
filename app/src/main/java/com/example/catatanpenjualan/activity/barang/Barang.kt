package com.example.catatanpenjualan.activity.barang

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")

data class Barang(

	@field:SerializedName("id_barang")
	val idBarang: Int? = null,

	@field:SerializedName("harga_beli")
	var hargaBeli: Double? = null,

	@field:SerializedName("nama_barang")
	var namaBarang: String? = null,

	@field:SerializedName("kategori")
	var kategori: String? = null,

	@field:SerializedName("id_user")
	var idUser: Int? = null,

	@field:SerializedName("stok")
	val stok: Int? = null,

	@field:SerializedName("created_date")
	val createdDate: String? = null,

	@field:SerializedName("harga_jual")
	var hargaJual: Double? = null,

	@field:SerializedName("barcode")
	var barcode: String? = null

): Serializable