package com.example.catatanpenjualan.activity.barang

import com.example.catatanpenjualan.ResultSimple
import com.example.catatanpenjualan.model.User
import com.example.catatanpenjualan.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataBarangPresenter(val dataBarangView: BarangActivity) {
    fun getDataBarang(user: User?){
        NetworkConfig.service()
            .getDataBarang(user?.id_user)
            .enqueue(object: Callback<ResultDataBarang>{
                override fun onResponse(call: Call<ResultDataBarang>, response: Response<ResultDataBarang>) {
                    val body = response.body()
                    dataBarangView.onSuccessDataBarang(body?.barang)
                }

                override fun onFailure(call: Call<ResultDataBarang>, t: Throwable) {
                    dataBarangView.onErrorDataBarang(t.localizedMessage)
                }

                })
        }
    fun deleteBarang (user: User?, barang: Barang?) {
        NetworkConfig.service().deleteBarang(user?.id_user,Integer.parseInt(barang?.idBarang.toString()),
                barang?.namaBarang)
            .enqueue(object : Callback<ResultSimple>{
                override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                    dataBarangView.onErrorDeleteBarang(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultSimple>,
                    response: Response<ResultSimple>
                ) {
                    val body = response.body()
                    if (body?.status=="200") {
                        dataBarangView.onSuccessDeleteBarang(body.pesan)
                    }else {
                        dataBarangView.onErrorDeleteBarang(body?.pesan)
                    }
                }
            })
    }
}