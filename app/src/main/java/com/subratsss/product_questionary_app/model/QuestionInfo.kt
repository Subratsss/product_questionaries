package com.subratsss.product_questionary_app.model

import com.google.gson.annotations.SerializedName

class QuestionInfo(
    @SerializedName("error_message")var error_message:String,
    @SerializedName("mandatory")var mandatory:Int,
    @SerializedName("url")var url:String,
    @SerializedName("placeholder")var placeholder:String,
    @SerializedName("multi_option_flag")var multi_option_flag:Int,
    @SerializedName("question")var question:String,
    @SerializedName("answers")var answers:String,
    @SerializedName("image_flag")var image_flag:Int,
    @SerializedName("values")var values:ArrayList<ValueInfo>,
    @SerializedName("multi_select_flag")var multi_select_flag:String,
    @SerializedName("images")var images:String,
    @SerializedName("type")var type:String,
    @SerializedName("question_id")var question_id:Int
) {
    override fun toString(): String {
        return "QuestionInfo(error_message='$error_message', mandatory=$mandatory, url='$url', placeholder='$placeholder', multi_option_flag=$multi_option_flag, question='$question', answers='$answers', image_flag=$image_flag, values=$values, multi_select_flag='$multi_select_flag', images='$images', type='$type', question_id=$question_id)"
    }
}

