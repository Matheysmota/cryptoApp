package com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter

import java.io.Serializable

data class CryptoChips(
    val firstCryptoChips: String,
    val secondCryptoChips: String,
    val thirdCryptoChips: String,
    val fourthCryptoChips: String,
    val fifthCryptoChips: String?
): Serializable {
}