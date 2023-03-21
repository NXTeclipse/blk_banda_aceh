package com.example.catatanpenjualan.activity.barang.addbarang

import android.util.Log
import com.example.catatanpenjualan.ResultSimple
import com.example.catatanpenjualan.activity.barang.Barang
import com.example.catatanpenjualan.model.User
import com.example.catatanpenjualan.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddBarangPresenter(val addBarangView: AddBarangView) {
    fun addBarang(dataBarang: Barang) {
        NetworkConfig.service()
            .addbarang(
                dataBarang.idUser,
                dataBarang.barcode,
                dataBarang.namaBarang,
                dataBarang.kategori,
                dataBarang.hargaBeli,
                dataBarang.hargaJual
            )
            .enqueue(object : Callback<ResultSimple>{
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    Log.d("barcode",t.toString())
                    addBarangView.onErrorAddBarang(t.message.toString())
                }

                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    Log.d("barcode",body.toString())
                    if (body?.status == "200"){
                    addBarangView.onSuccessAddBarang(body?.pesan)
                    }else {
                        addBarangView.onErrorAddBarang(body?.pesan)
                    }
                }
            }

            )
    }
    fun updateBarang (dataBarang: Barang) {
        NetworkConfig.service()
            .updateBarang(
                id_barang = dataBarang.idBarang.toString(),
                id_user = dataBarang.idUser,
                barcode = dataBarang.barcode,
                nama_barang = dataBarang.namaBarang,
                kategori = dataBarang.kategori,
                harga_beli = dataBarang.hargaBeli,
                harga_jual = dataBarang.hargaJual
            )
            .enqueue(object : Callback<ResultSimple> {
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    Log.d("barcode", t.toString())
                    addBarangView.onErrorAddBarang(t.message.toString())
                }


                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    Log.d("barcode", body.toString())
                    if (body?.status == "200") {
                        addBarangView.onSuccessAddBarang(body?.pesan)
                    } else {
                        addBarangView.onErrorAddBarang(body?.pesan)
                    }
                }

            })
    }

}