package com.matheus.mota.cryptoapp.model.coinInfo

import android.graphics.drawable.Drawable

data class Team(
    val id: String,
    val name: String,
    val position: String,
    val line: Drawable?
)