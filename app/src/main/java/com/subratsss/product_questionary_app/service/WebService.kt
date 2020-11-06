package com.subratsss.product_questionary_app.service

import com.subratsss.product_questionary_app.model.api_res_model.QuestionsRes
import retrofit2.Call
import retrofit2.http.GET

interface WebService {

    @GET(ApiUrl.FETCH_QUESTIONARY)
    fun getQuestionInfo(): Call<QuestionsRes>
}