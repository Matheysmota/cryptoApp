package com.matheus.mota.cryptoapp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable


data class CryptoCoin(
    val name: String,
    val rank: String,
    val symbol: String,
    val id: String,
    var favorite: Boolean = false,

): Serializable {

}