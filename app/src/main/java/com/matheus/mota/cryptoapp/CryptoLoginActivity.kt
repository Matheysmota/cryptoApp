package com.matheus.mota.cryptoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoLoginBinding

class CryptoLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCryptoLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        startNextActivity()
    }

    private fun startNextActivity(){
        binding.run{
            loginAccessButton.setOnClickListener{
                val intent = Intent(this@CryptoLoginActivity, CryptoHomeActivity::class.java)
                startActivity(intent)
                }
            signUpButton.setOnClickListener{
                val intent = Intent(this@CryptoLoginActivity, SignUpActivity::class.java)
                startActivity(intent)
                }
            }
        }
}