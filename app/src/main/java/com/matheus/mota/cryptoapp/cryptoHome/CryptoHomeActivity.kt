package com.matheus.mota.cryptoapp.cryptoHome

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoinAdapter
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoHomeBinding
import com.matheus.mota.cryptoapp.utils.cryptoCoinsCollection


class CryptoHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoHomeBinding
    private lateinit var teste: CryptoCoinAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //implementations
        initRecyclerView()
        initOptionMenu()
        }
    private fun initRecyclerView() {
        //create cryptoCoins
        val cryptoList: MutableList<CryptoCoin> = mutableListOf()
        cryptoList.addAll(cryptoCoinsCollection)
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

}



