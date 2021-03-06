package com.matheus.mota.cryptoapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isNotEmpty
import com.matheus.mota.cryptoapp.ui.cryptoHome.CryptoHomeActivity
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoLoginBinding

class CryptoLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCryptoLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()

        startHomeActivity()
    }

    private fun startHomeActivity() {
        binding.run {
            loginAccessButton.setOnClickListener {
                val intent = Intent(this@CryptoLoginActivity, CryptoHomeActivity::class.java)
                if(accessLoginEditText.editText?.text?.isNotEmpty() == true && accessPasswordEditText.editText?.text?.isNotEmpty() == true ){
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@CryptoLoginActivity, "Digite os campos, por favor.", Toast.LENGTH_SHORT).show()
                }
            }
            signUpButton.setOnClickListener {
                val intent = Intent(this@CryptoLoginActivity, CryptoSignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

}