package com.matheus.mota.cryptoapp.webClient.service


import com.matheus.mota.cryptoapp.model.coinInfo.CryptoCoinInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoInfoService {
    @GET("v1/coins/{id}")
    suspend fun getCryptoCoinInfo(@Path(value = "id", encoded = true) id: String): Response<CryptoCoinInfo>
}