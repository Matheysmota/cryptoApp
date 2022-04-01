package com.matheus.mota.cryptoapp.cryptoHome

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoinAdapter
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoCoinInfoActivity
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoHomeBinding

//set reclycler view
fun Activity.setUpRecyclerView(binding: ActivityCryptoHomeBinding, cryptoList: MutableList<CryptoCoin>){
    val reclyclerCryptoCoins = binding.buttonRecyclerView
    val cryptoAdapter = CryptoCoinAdapter(this, cryptoList)
    reclyclerCryptoCoins.adapter = cryptoAdapter
}

fun startCoinInfo(context: Context, coin: CryptoCoin){
    var intent = Intent(context, CryptoCoinInfoActivity::class.java)
    intent.putExtra("coin", coin)
    context.startActivity(intent)
}


