package com.matheus.mota.cryptoapp.webClient.service

import com.matheus.mota.cryptoapp.model.CryptoCoin
import retrofit2.Call
import retrofit2.http.GET

interface CryptoHomeService {

    @GET("v1/coins")
    fun getCryptoCoin(): Call<List<CryptoCoin>>

}