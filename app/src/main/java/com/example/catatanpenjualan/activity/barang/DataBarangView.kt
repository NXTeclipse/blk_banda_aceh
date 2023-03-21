package com.example.catatanpenjualan.activity.barang

interface DataBarangView {
    fun onSuccessDataBarang (data: List<Barang?>?)
    fun onErrorDataBarang(msg: String?)
    fun onSuccessDeleteBarang(msg: String?)
    fun onErrorDeleteBarang(msg: String?)
}