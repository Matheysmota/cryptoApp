package com.matheus.mota.cryptoapp.cryptoHome

import android.app.Activity
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoinAdapter
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoHomeBinding

//set reclycler view
fun Activity.setUpRecyclerView(binding: ActivityCryptoHomeBinding, cryptoList: MutableList<CryptoCoin>){
    val reclyclerCryptoCoins = binding.buttonRecyclerView
    val cryptoAdapter = CryptoCoinAdapter(this, cryptoList)
    reclyclerCryptoCoins.adapter = cryptoAdapter
}