package com.matheus.mota.cryptoapp.CryptoCoins.hidenData

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoTeamsAdapter.CryptoTeams
import com.matheus.mota.cryptoapp.R

open class CryptoCoinInfoList: AppCompatActivity() {

    //create cryptoCoins
    val cryptoChipsCollection: Collection<CryptoChips> = (
            listOf(
                CryptoChips("tag1", "tag2", "tag3", "tag4", "tag5")
            )
            )
    val cryptoTeamsCollection: Collection<CryptoTeams> = (
            listOf(
                CryptoTeams("Satoshi Nakamoto", "Founder", null),
                CryptoTeams("Satoshi Nakamoto", "Founder", null),
                CryptoTeams("Satoshi Nakamoto", "Founder", null),
                CryptoTeams("Satoshi Nakamoto", "Founder", null),
                CryptoTeams("Satoshi Nakamoto", "Founder", null),
                CryptoTeams("Satoshi Nakamoto", "Founder", null)
            )
            )

}