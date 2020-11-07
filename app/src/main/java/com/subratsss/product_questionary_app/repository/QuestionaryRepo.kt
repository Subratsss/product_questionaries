package com.subratsss.product_questionary_app.repository

import android.util.Log
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
                        Log.v("SSS","SSS check1 "+ response.body()!!.questions)
                        if (response.body()!!.status){
                            questonInfo.value = response.body()
                        }
                    }

                    override fun onFailure(call: Call<QuestionsRes>, t: Throwable) {
                        Log.v("SSS","SSS check2 "+t.message)
                        questonInfo.value = null
                    }

                })

        return questonInfo
    }
}
