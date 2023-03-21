package com.example.catatanpenjualan.activity.login

import com.example.catatanpenjualan.model.User
import com.example.catatanpenjualan.network.NetworkConfig

import retrofit2.Call

import retrofit2.Response

class LoginPresenter  (val loginView : LoginView) {
    fun login (user: User) {
    NetworkConfig.service().loginUser(user.username,user.password)
        .enqueue(object : retrofit2.Callback<ResultLogin>{
            override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                val body = response.body()

                if (body?.status == "200") {
                    loginView.onSuccessLogin(body.user)
                } else {
                    loginView.onErrorLogin(body?.massage)
                }
            }

            override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                loginView.onErrorLogin(t.localizedMessage)
            }

        })



    }
}
