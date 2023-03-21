package com.example.catatanpenjualan.activity.barang

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.catatanpenjualan.R
import com.example.catatanpenjualan.activity.barang.addbarang.AddBarangActivity
import com.example.catatanpenjualan.base.BaseActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


@Suppress("DEPRECATION")
class BarangActivity : BaseActivity(), DataBarangView {

    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)

        refreshBarang()

        findViewById<FloatingActionButton>(R.id.btAddDataBarang).setOnClickListener {
            val intent = Intent (this, AddBarangActivity::class.java)
            intent.putExtra(TAGS.USER,user)

            startActivity(intent)
        }
    }
    private fun refreshBarang(){
        DataBarangPresenter(this).getDataBarang(user)
    }



    override fun onSuccessDataBarang(data: List<Barang?>?) {
        findViewById<RecyclerView>(R.id.rvDatabarang).adapter = DataBarangAdapter(data, object :
            DataBarangAdapter.OnMenuClicked{
            override fun click( menuItem: MenuItem, barang: Barang?) {
                when (menuItem.itemId){
                    R.id.editBarang -> editBarang(barang)
                    R.id.hapusBarang-> hapusBarang(barang)
                }
            }
        })
    }

    override fun onErrorDataBarang (msg:String?){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessDeleteBarang(msg: String?) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onErrorDeleteBarang(msg: String?) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    private fun editBarang(barang: Barang?){
        val intent = Intent(this, AddBarangActivity::class.java)
        intent.putExtra(TAGS.USER,user)
        intent.putExtra(TAGS.BARANG,barang)
        startActivity(intent)
    }
    private fun hapusBarang(barang: Barang?){
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Yakin ingin menghapus barang ${barang?.namaBarang} ")
        .setCancelable(false)
            .setPositiveButton("Hapus", DialogInterface.OnClickListener{
                    dialog, id -> DataBarangPresenter(this@BarangActivity).deleteBarang(user,barang)
            })
            .setNegativeButton("Batal", DialogInterface.OnClickListener{dialog, id -> dialog.cancel()
            })

        val alert =dialogBuilder.create()
        alert.setTitle("konfimasi")
        alert.show()
    }

    override fun onResume() {
        super. onResume()
        refreshBarang()
    }
}