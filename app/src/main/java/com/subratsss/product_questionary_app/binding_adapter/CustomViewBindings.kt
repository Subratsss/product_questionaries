package com.subratsss.product_questionary_app.binding_adapter

import android.R
import android.app.Activity
import android.view.View
import android.widget.*
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.subratsss.product_questionary_app.model.ValueInfo


/**
 * Custom Binding Adapter for Glide
 */
@BindingAdapter("imageUrl")
fun setImageUrl(imgView: ImageView, imgUrl: String?){

    if (!imgUrl.isNullOrEmpty()) {
        imgUrl.let {
            val imgUri = it.toUri().buildUpon().scheme("https").build()
            GlideToVectorYou.justLoadImage(imgView.context as Activity?, imgUri, imgView)
        }
    }


}
@BindingAdapter("radioButtons")
    fun setRadioButton(radioGroup: RadioGroup, values: List<ValueInfo>?){

        if (!values.isNullOrEmpty()) {
            for (i in 1..values.size) {
                val rbn = RadioButton(radioGroup.context)
                rbn.id = View.generateViewId()
                rbn.text = values[i - 1].value
                radioGroup.addView(rbn)
            }
        }
    }

@BindingAdapter("multipleSelection")
fun setMultipleSelection(linearLayout: LinearLayout, values: List<ValueInfo>?){

    if (!values.isNullOrEmpty()) {
        for (i in 1..values.size) {
            val chkTeamName = CheckBox(linearLayout.context)
            chkTeamName.text = values[i - 1].value
            linearLayout.addView(chkTeamName)
        }
    }
}

@BindingAdapter("spinner")
fun setSpinner(spinner: Spinner, values: List<ValueInfo>?){
    val spinnerArray = ArrayList<String>()
    if (!values.isNullOrEmpty()) {
        for (i in 1..values.size) {
            spinnerArray.add(values[i - 1].value)
        }
            val spinnerArrayAdapter =
                ArrayAdapter(spinner.context, R.layout.simple_spinner_dropdown_item, spinnerArray)
            spinner.adapter = spinnerArrayAdapter

        }
    }


