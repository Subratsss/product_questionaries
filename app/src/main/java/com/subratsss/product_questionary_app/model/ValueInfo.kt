package com.subratsss.product_questionary_app.model

import com.google.gson.annotations.SerializedName

class ValueInfo(
    @SerializedName("selected")var selected:Int,
    @SerializedName("image_url")var image_url:String?,
    @SerializedName("id")var id:Int,
    @SerializedName("value")var value:String) {

    override fun toString(): String {
        return "ValueInfo(selected=$selected, image_url=$image_url, id=$id, value='$value')"
    }
}