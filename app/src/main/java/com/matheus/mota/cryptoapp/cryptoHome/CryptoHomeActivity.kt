package com.matheus.mota.cryptoapp.cryptoHome

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.cryptoHome.cryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoHomeBinding
import com.matheus.mota.cryptoapp.utils.cryptoCoinsCollection


class CryptoHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoHomeBinding
    lateinit var myCrypto: CryptoCoin
    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //implementations
        initRecyclerView(myCryptoCoinsList())
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
        binding.exitMenu.setOnClickListener {
            alertDialog()
        }
    }

    private fun myCryptoCoinsList(): List<CryptoCoin> {
        return if (cryptoCoinsCollection.any { it.favorite }) {
            cryptoCoinsCollection.filter { it.favorite }
        } else {
            cryptoCoinsCollection
        }
    }

    private fun setFavoriteFilter() {
        binding.onlyFavoriteButton.setOnClickListener {
            myCryptoCoinsList().let { initRecyclerView(it) }
            Toast.makeText(this, "Suas cryptoMoedas favoritas", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAllFilter() {
        binding.allButton.setOnClickListener {
            initRecyclerView(cryptoCoinsCollection)
        }
    }


    private fun alertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeMyDialog)
        val view = layoutInflater.inflate(R.layout.alert_dialog, null)
        build.setView(view)

        val cancelButton = view.findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener{ dialog.dismiss() }

        val exitButton = view.findViewById<Button>(R.id.exitButton)
        exitButton.setOnClickListener {
            Toast.makeText(this, "Até logo!", Toast.LENGTH_SHORT).show()
            finish()
        }

        dialog = build.create()
        dialog.show()
    }



}



