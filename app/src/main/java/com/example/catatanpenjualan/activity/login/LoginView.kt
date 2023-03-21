package com.example.catatanpenjualan.activity.login

import com.example.catatanpenjualan.model.User

interface LoginView {
    fun onSuccessLogin (user: User?)
    fun onErrorLogin (msg: String?)
}