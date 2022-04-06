package com.matheus.mota.cryptoapp.cryptoHome

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.cryptoHome.cryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.cryptoHome.cryptoCoinsAdapter.CryptoCoinAdapter
import com.matheus.mota.cryptoapp.cryptoHome.cryptoCoinsAdapter.CryptoCoinAdapterInterface
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoCoinInfoActivity
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoHomeBinding

//set reclycler view
fun Activity.setUpRecyclerView(binding: ActivityCryptoHomeBinding, cryptoList: MutableList<CryptoCoin>){
    val reclyclerCryptoCoins = binding.buttonRecyclerView
    val cryptoAdapter = CryptoCoinAdapter(this, cryptoList)

    cryptoAdapter.notifyMyActivity = object: CryptoCoinAdapterInterface {
        override fun notifyActivity(coin: CryptoCoin) {
            startCoinInfo(this@setUpRecyclerView, coin)
        }

    }
    reclyclerCryptoCoins.adapter = cryptoAdapter
}
fun startCoinInfo(context: Context, coin: CryptoCoin) {
    val intent = Intent(context, CryptoCoinInfoActivity::class.java)
    intent.putExtra("coin", coin)
    context.startActivity(intent)
}



