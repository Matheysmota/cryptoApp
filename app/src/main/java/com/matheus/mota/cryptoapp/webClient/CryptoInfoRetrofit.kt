package com.matheus.mota.cryptoapp.webClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoInfoRetrofit {
    companion object {
        fun getCryptoInfoRetrofit(baseUrl: String): Retrofit {
            return Retrofit.Builder().
            baseUrl(baseUrl).
            addConverterFactory(GsonConverterFactory.create()).
            build()
        }
    }
}