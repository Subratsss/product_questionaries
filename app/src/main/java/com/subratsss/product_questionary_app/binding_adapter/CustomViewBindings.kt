package com.subratsss.product_questionary_app.binding_adapter

import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.subratsss.product_questionary_app.model.ValueInfo


/**
 * Custom Binding Adapter
 */
/**
 * Custom Binding Adapter for Glide
 */
@BindingAdapter("imageUrl")
fun setImageUrl(imgView: ImageView, imgUrl: String?){

    if (!imgUrl.isNullOrEmpty()) {
        imgUrl.let {
            val imgUri = it.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .into(imgView)
        }
    }


}
@BindingAdapter("radioButtons")
    fun setRadioButton(radioGroup: RadioGroup, values: List<ValueInfo>?){

        if (!values.isNullOrEmpty()) {
            for (i in 1..values.size) {
                val rbn = RadioButton(radioGroup.context)
                rbn.id = View.generateViewId()
                rbn.text = values[i].value
                radioGroup.addView(rbn)
            }
        }
    }
