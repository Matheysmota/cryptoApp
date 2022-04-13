package com.matheus.mota.cryptoapp.webClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoHomeRetrofit {
    companion object {
        fun getCryptoRetrofit(baseUrl: String): Retrofit {
            return Retrofit.Builder().
            baseUrl(baseUrl).
            addConverterFactory(GsonConverterFactory.create()).
            build()
        }
    }
}