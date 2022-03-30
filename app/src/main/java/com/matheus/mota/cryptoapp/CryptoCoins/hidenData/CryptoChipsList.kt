package com.matheus.mota.cryptoapp.CryptoCoins.hidenData

import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoChips
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoCoinsAdapter.CryptoCoin

open class CryptoChipsList: AppCompatActivity() {

    //create cryptoCoins
    val cryptoChipsCollection: Collection<CryptoChips> = (
            listOf(
                CryptoChips("confiável", "transacionável")
            )
            )

}