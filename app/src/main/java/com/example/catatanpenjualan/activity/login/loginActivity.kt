package com.example.catatanpenjualan.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.catatanpenjualan.MainActivity
import com.example.catatanpenjualan.R
import com.example.catatanpenjualan.base.BaseActivity
import com.example.catatanpenjualan.model.User

class loginActivity : AppCompatActivity(), LoginView {
    lateinit var etUsername : EditText
    lateinit var etPassword : EditText
    lateinit var btLogin : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById<EditText> (R.id.etLoginUsername)
        etPassword = findViewById<EditText> (R.id.etLoginPassword)
        btLogin = findViewById<Button>(R.id.btnLogin)

        initActionButton()
    }
private fun initActionButton() {
    btLogin.setOnClickListener {
        val user = User()
        user.username = etUsername.text.toString().trim()
        user.password = etPassword.text.toString().trim()


        LoginPresenter ( this).login(user)

    }

}

    override fun onSuccessLogin(user: User?) {
        Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(BaseActivity.TAGS.USER, user)
        }
        finish()
        startActivity(intent)
    }

    override fun onErrorLogin(msg: String?) {
        //on andika
        if(msg.isNullOrEmpty()){
            Toast.makeText(this, "asdas", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}


