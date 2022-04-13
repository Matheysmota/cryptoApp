package com.matheus.mota.cryptoapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoSignUpBinding
import com.matheus.mota.cryptoapp.ui.cryptoHome.CryptoHomeActivity

class CryptoSignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoSignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    private fun setListener() {
        binding.run {
            createAccountAccessButton.setOnClickListener {
                if (signUpValidation()) {
                    val intent = setHomeScreen()
                    startActivity(intent)
                } else {
                    setToast()
                }
            }

        }
    }
    private fun setToast() {
        Toast.makeText(this@CryptoSignUpActivity,
            "Digite todos os campos.",
            Toast.LENGTH_SHORT)
            .show()
    }
    private fun setHomeScreen(): Intent {
        return Intent(this@CryptoSignUpActivity,
            CryptoHomeActivity::class.java)
    }
    private fun ActivityCryptoSignUpBinding.signUpValidation() =
        loginSignInEditText.isValid() && cpfSignInEditText.isValid() && passwordSignInEditText.isValid() && confirmPwdSignInEditText.isValid()
}