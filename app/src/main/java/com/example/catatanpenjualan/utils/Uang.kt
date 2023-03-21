package com.example.catatanpenjualan.utils

import java.text.NumberFormat
import java.util.Locale
import kotlin.contracts.Returns

class Uang {
    fun indonesia (uang:Double):String{
        val localeId = Locale("in", "ID")
        val KursId:NumberFormat =  NumberFormat.getCurrencyInstance(localeId)

        return KursId.format(uang)
    }
}