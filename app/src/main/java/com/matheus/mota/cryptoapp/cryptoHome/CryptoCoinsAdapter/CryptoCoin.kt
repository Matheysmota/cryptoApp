package com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter

import java.io.Serializable


data class CryptoCoin(
    val cryptoName: String,
    val ranking: String,
    var favorite: Boolean
): Serializable {

}