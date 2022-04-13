package com.matheus.mota.cryptoapp.webClient.service


import com.matheus.mota.cryptoapp.model.coinInfo.CryptoCoinInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoInfoService {
    @GET("v1/coins/{id}")
    fun getCryptoCoinInfo(@Path(value = "id", encoded = true) id: String): Call<CryptoCoinInfo>
}