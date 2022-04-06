package com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter

import android.graphics.drawable.Drawable
import java.io.Serializable

data class CryptoTeams(
    val tittle: String,
    val subTittle: String,
    val line: Drawable?
): Serializable {
}