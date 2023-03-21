package com.example.catatanpenjualan.base


import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.catatanpenjualan.model.User

@Suppress("DEPRECATION")
@SuppressLint ("Registered")
        open class BaseActivity : AppCompatActivity(){
            object TAGS {
                val BARANG = "barang"
                val USER = "user"

            }
            var user : User?=null

            fun cekSesi (activity: Activity) {
                val intent = activity.intent.getSerializableExtra("user")

                if (intent==null)
                {
                    Toast.makeText(activity, "anda belum login", Toast.LENGTH_SHORT).show()
                    activity.finish()
                }
                else
                {
                    user = intent as User
                }
            }

        }