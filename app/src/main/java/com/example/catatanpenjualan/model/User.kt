package com.example.catatanpenjualan.model

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robhorse.robopojogenerator")
data class User (
    @field:SerializedName("password")
    var password: String?=null,

    @field:SerializedName("hp")
    var hp: String?=null,

    @field:SerializedName("id_user")
    var id_user: String?=null,

    @field:SerializedName("create_date")
    var create_date: String?=null,

    @field:SerializedName("email")
    var email: String?=null,

    @field:SerializedName("username")
    var username: String?=null

):java.io.Serializable