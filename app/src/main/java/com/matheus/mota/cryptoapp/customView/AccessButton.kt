package com.matheus.mota.cryptoapp.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.databinding.AccessButtonBinding

//Access button componetization class
class  AccessButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0
): ConstraintLayout(context, attrs, defStyleAttrs) {
    //Button properties to programmatically set
    private val binding = AccessButtonBinding
        .inflate(LayoutInflater.from(context), this, true)
    init {
        setLayout(attrs)
    }
    private fun setLayout(attrs: AttributeSet?){
        attrs?.let { attrs ->
            val attribute = context.obtainStyledAttributes(
                attrs,
                R.styleable.AccessButton
            )
            //binding attribute to my button
            this.binding.AccessButton.text = attribute.getString(R.styleable.AccessButton_button_text)

            attribute.recycle()
        }
    }
}