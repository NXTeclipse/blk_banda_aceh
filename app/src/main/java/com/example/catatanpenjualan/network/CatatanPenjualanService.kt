package com.example.catatanpenjualan.network

import com.example.catatanpenjualan.ResultSimple
import com.example.catatanpenjualan.activity.barang.ResultDataBarang
import com.example.catatanpenjualan.activity.login.ResultLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CatatanPenjualanService {
    @FormUrlEncoded
    @POST ("user/select_user.php")
    fun loginUser (@Field("username") username:String?,
                    @Field("password") password:String?)
                    : Call<ResultLogin>

    @FormUrlEncoded
    @POST ("barang/select_barang.php")
    fun getDataBarang (@Field("id_user") id_user: String?): Call<ResultDataBarang>

    @FormUrlEncoded
    @POST ("barang/insert_barang.php")
    fun addbarang (@Field("id_user")id_user: Int?,
        @Field("barcode") barcode: String?,
        @Field("nama_barang") nama_barang : String?,
        @Field("kategori") kategori: String?,
        @Field("harga_beli") harga_beli: Double?,
        @Field("harga_jual") harga_jual: Double?) : Call<ResultSimple>

    @FormUrlEncoded
    @POST ("barang/update_barang.php")
    fun updateBarang (
        @Field("id_user") id_user: Int?,
        @Field("id_barang") id_barang: String?,
        @Field("barcode") barcode: String?,
        @Field("nama_barang") nama_barang: String?,
        @Field("kategori") kategori: String?,
        @Field("harga_beli") harga_beli: Double?,
        @Field("harga_jual") harga_jual: Double?
    ) : Call<ResultSimple>

    @FormUrlEncoded
    @POST ("barang/delete_barang.php")
    fun deleteBarang (
        @Field("id_barang") id_barang: String?,
        nama_barang1: Int,
        @Field("nama_barang") nama_barang: String?,

        ):Call<ResultSimple>




}
