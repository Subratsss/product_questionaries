package com.subratsss.product_questionary_app.repository

import androidx.lifecycle.MutableLiveData
import com.subratsss.product_questionary_app.model.api_res_model.QuestionsRes
import com.subratsss.product_questionary_app.service.AppServiceConnector
import com.subratsss.product_questionary_app.service.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionaryRepo {
    private  var webService: WebService = AppServiceConnector.serviceConnector!!
            .create(WebService::class.java)

    /**
     * Fetch Questionary list
     */
    fun getQuestionary(): MutableLiveData<QuestionsRes> {

        val questonInfo = MutableLiveData<QuestionsRes>()

        webService.getQuestionInfo()
                .enqueue(object : Callback<QuestionsRes> {
                    override fun onResponse(call: Call<QuestionsRes>, response: Response<QuestionsRes>) {
                        questonInfo.value = response.body()
                    }

                    override fun onFailure(call: Call<QuestionsRes>, t: Throwable) {
                        questonInfo.value = null
                    }

                })

        return questonInfo
    }
}
