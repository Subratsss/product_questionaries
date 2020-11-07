package com.subratsss.product_questionary_app.model.api_res_model

import com.google.gson.annotations.SerializedName
import com.subratsss.product_questionary_app.listener.OnResponse
import com.subratsss.product_questionary_app.model.QuestionInfo

class QuestionsRes(
    @SerializedName("status")var status:Boolean?,
    @SerializedName("course_process_id")var course_process_id:Int,
    @SerializedName("questions")var questions:ArrayList<QuestionInfo>
) :OnResponse{
    override fun toString(): String {
        return "QuestionsRes(status=$status, course_process_id=$course_process_id, questions=$questions)"
    }
}
