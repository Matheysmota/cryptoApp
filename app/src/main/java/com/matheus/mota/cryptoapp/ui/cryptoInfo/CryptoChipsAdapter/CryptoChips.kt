package com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoChipsAdapter

import java.io.Serializable

data class CryptoChips(
    val firstCryptoChips: String,
    val secondCryptoChips: String,
    val thirdCryptoChips: String,
    val fourthCryptoChips: String,
    val fifthCryptoChips: String?
): Serializable {
}