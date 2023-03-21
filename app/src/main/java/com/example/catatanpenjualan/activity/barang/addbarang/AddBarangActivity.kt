package com.example.catatanpenjualan.activity.barang.addbarang

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import androidx.core.text.isDigitsOnly
import com.example.catatanpenjualan.R
import com.example.catatanpenjualan.activity.barang.addbarang.AddBarangView
import com.example.catatanpenjualan.activity.barang.Barang
import com.example.catatanpenjualan.base.BaseActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable
import java.util.*

@Suppress("DEPRECATION")
class AddBarangActivity : BaseActivity(), AddBarangView {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_barang)

        val intent = intent.getSerializableExtra(TAGS.BARANG)

            if (intent != null) {
                setActionEditButton(intent)
            }
            else {
                setActionTambahButton()
            }
        }

    private fun setActionTambahButton() {
        findViewById<Button>(R.id.btAddBarang).setOnClickListener {
            findViewById<Button>(R.id.btAddBarang).text = "tambah"
            val barcode = findViewById<EditText>(R.id.etAddBarangBarcode).text.toString()
            val nama_barang = findViewById<EditText>(R.id.etAddBarangNamaBarang).text.toString()
            val kategori = findViewById<EditText>(R.id.etBarangKategori).text.toString()
            val harga_beli = findViewById<EditText>(R.id.etAddBarangHargaBeli).text.toString()
            val harga_jual = findViewById<EditText>(R.id.etAddBarangHargaJual).text.toString()

            if (harga_beli.isNotBlank() && harga_jual.isNotBlank()) {
                val harga_beli = harga_beli.toDouble()
                val harga_jual = harga_jual.toDouble()

                // objek barang
                val barang = Barang()
                barang.idUser = user?.id_user.toString().toInt()
                barang.barcode = barcode
                barang.namaBarang = nama_barang.toUpperCase(Locale.ROOT)
                barang.kategori = kategori.toLowerCase(Locale.ROOT).capitalize(Locale.ROOT)
                barang.hargaJual = harga_jual
                barang.hargaBeli = harga_beli

                //simpan ke dalam database
                AddBarangPresenter(this@AddBarangActivity).addBarang(barang)
            } else {
                //jangan di input
                Snackbar.make(it, "harga tidak Boleh Kosong", Snackbar.LENGTH_SHORT)
            }
        }
    }
    private fun setActionEditButton(serializable: Serializable){
        findViewById<Button>(R.id.btAddBarang).text="Simpan"
        val barang = serializable as Barang
        findViewById<EditText>(R.id.etAddBarangBarcode).setText(barang.barcode)
        findViewById<EditText>(R.id.etAddBarangNamaBarang).setText(barang.namaBarang)
        findViewById<EditText>(R.id.etBarangKategori).setText(barang.kategori)
        findViewById<EditText>(R.id.etAddBarangHargaBeli).setText(barang.hargaBeli.toString())
        findViewById<EditText>(R.id.etAddBarangHargaJual).setText(barang.hargaJual.toString())

        findViewById<Button>(R.id.btAddBarang).setOnClickListener{
            val barcode = findViewById<EditText>(R.id.etAddBarangBarcode).text.toString()
            val nama_barang = findViewById<EditText>(R.id.etAddBarangNamaBarang).text.toString()
            val kategori = findViewById<EditText>(R.id.etBarangKategori).text.toString()
            val harga_beli =  findViewById<EditText>(R.id.etAddBarangHargaBeli).text.toString()
            val harga_jual = findViewById<EditText>(R.id.etAddBarangHargaJual).text.toString()

            if (harga_beli.isNotBlank()&& harga_jual.isNotBlank()) {
                val harga_beli = harga_beli.toDouble()
                val harga_jual = harga_jual.toDouble()

                barang.idUser = user?.id_user.toString().toInt()
                barang.barcode = barcode
                barang.namaBarang = nama_barang.toUpperCase()
                barang.kategori = kategori.toLowerCase().capitalize()
                barang.hargaBeli = harga_beli
                barang.hargaJual = harga_jual

                //simpan database
                AddBarangPresenter(this@AddBarangActivity).updateBarang(barang)
            }
            else    {
                Snackbar.make(it,"Harga tidak boleh kosong", Snackbar.LENGTH_SHORT).show()
            }
        }

    }


    override fun onSuccessAddBarang(msg: String?) {
        Toast.makeText(this, "success bos", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onErrorAddBarang(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()


    }

    override fun onSuccessDeleteBarang(msg: String?) {
        Toast.makeText(this,"sukses delete", Toast.LENGTH_SHORT).show()
    }

    override fun onErrorDeleteBarang(msg: String?) {
        Toast.makeText(this, "gagal delete", Toast.LENGTH_SHORT).show()
    }
}