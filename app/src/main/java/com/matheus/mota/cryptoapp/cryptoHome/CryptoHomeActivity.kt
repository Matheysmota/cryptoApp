package com.matheus.mota.cryptoapp.cryptoHome

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoHomeBinding
import com.matheus.mota.cryptoapp.utils.cryptoCoinsCollection


class CryptoHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoHomeBinding
    lateinit var myCrypto: CryptoCoin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //implementations
        myCryptoCoinsList()?.let { initRecyclerView(it) }
        initOptionMenu()
        setFavoriteFilter()
        setAllFilter()
        }
    private fun initRecyclerView(list: Collection<CryptoCoin>) {
        //create cryptoCoins
        val cryptoList: MutableList<CryptoCoin> = mutableListOf()
        cryptoList.addAll(list)
        setUpRecyclerView(binding, cryptoList)
    }

    private fun initOptionMenu() {
        with(binding.tollBar) {
            inflateMenu(R.menu.crypto_menu)
            menu.findItem(R.id.action_exit).setOnMenuItemClickListener {
                Toast.makeText(this@CryptoHomeActivity, "testeeeeee", Toast.LENGTH_SHORT).show()
                true
            }
        }
    }

    private fun myCryptoCoinsList(): Collection<CryptoCoin>? {
        if (cryptoCoinsCollection.any { it.favorite }){
            return cryptoCoinsCollection.filter { it.favorite}
        } else {
            return cryptoCoinsCollection
        }
    }
    private fun setFavoriteFilter(){
        binding.onlyFavoriteButton.setOnClickListener{
            myCryptoCoinsList()?.let { initRecyclerView(it) }
            Toast.makeText(this, "Suas cryptoMoedas favoritas", Toast.LENGTH_SHORT).show()
        }
    }
    private fun setAllFilter(){
        binding.allButton.setOnClickListener{
         initRecyclerView(cryptoCoinsCollection)
        }
    }
}



