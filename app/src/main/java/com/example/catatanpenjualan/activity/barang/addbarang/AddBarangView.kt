package com.example.catatanpenjualan.activity.barang.addbarang

interface AddBarangView {
    fun onSuccessAddBarang(msg:String?)
    fun onErrorAddBarang (msg:String?)

    fun onSuccessDeleteBarang(msg: String?)
    fun onErrorDeleteBarang(msg: String?)
}