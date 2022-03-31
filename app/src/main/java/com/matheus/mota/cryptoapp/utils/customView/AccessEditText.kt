package com.matheus.mota.cryptoapp.utils.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.databinding.AccessEditTextBinding

class AccessEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0
): ConstraintLayout(context, attrs, defStyleAttrs) {
    private val binding = AccessEditTextBinding
        .inflate(LayoutInflater.from(context), this, true)
    init {
        setLayout(attrs)
    }
    private fun setLayout(attrs: AttributeSet?){
        attrs?.let { attrs ->
            val attribute = context.obtainStyledAttributes(
                attrs,
                R.styleable.AccessEditText
            )
            //binding attribute to my editText and bg
            setBackgroundResource(R.drawable.access_edit_text)
            this.binding.inputTypeInputLayout.isPasswordVisibilityToggleEnabled = attribute.getBoolean(R.styleable.AccessEditText_is_password, true)
            this.binding.accessHintEditText.hint = attribute.getString(R.styleable.AccessEditText_change_hint)
            this.binding.accessHintEditText.inputType = attribute.getType(R.styleable.AccessEditText_inputType)

            attribute.recycle()
        }
    }
}