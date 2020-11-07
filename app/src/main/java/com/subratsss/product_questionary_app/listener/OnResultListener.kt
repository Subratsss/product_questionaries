package com.subratsss.product_questionary_app.listener

import com.subratsss.product_questionary_app.model.api_res_model.QuestionsRes

interface OnResultListener {
    fun onSuccess(questionRes: QuestionsRes)
    fun onError(error:OnErrorResponse)
}