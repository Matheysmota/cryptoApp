package com.matheus.mota.cryptoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoSignUpBinding
import com.matheus.mota.cryptoapp.cryptoHome.CryptoHomeActivity

class CryptoSignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private fun startHomeActivity(){
        binding.run{
            createAccountAccessButton.setOnClickListener{
                val intent = Intent(this@CryptoSignUpActivity, CryptoHomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}