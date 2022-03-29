package com.matheus.mota.cryptoapp

import android.os.Bundle
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoCoinsAdapter.CryptoCoinAdapter
import com.matheus.mota.cryptoapp.CryptoCoins.hidenData.CryptoCoinsList
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoHomeBinding

class CryptoHomeActivity : CryptoCoinsList() {
    lateinit var binding: ActivityCryptoHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //implementations
        initRecyclerView()
    }

    private fun initRecyclerView(){

        val reclyclerCryptoCoins = binding.buttonRecyclerView
        val cryptoList: MutableList<CryptoCoin> = mutableListOf()

        //create cryptoCoins

        cryptoList.addAll(cryptoCoinsCollection)

        val cryptoAdapter = CryptoCoinAdapter(this, cryptoList)
        reclyclerCryptoCoins.adapter = cryptoAdapter
    }
}
