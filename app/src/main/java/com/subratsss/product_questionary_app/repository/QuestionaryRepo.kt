package com.subratsss.product_questionary_app.repository

import androidx.lifecycle.MutableLiveData
import com.subratsss.product_questionary_app.listener.OnErrorResponse
import com.subratsss.product_questionary_app.listener.OnResultListener
import com.subratsss.product_questionary_app.model.api_res_model.QuestionsRes
import com.subratsss.product_questionary_app.service.AppServiceConnector
import com.subratsss.product_questionary_app.service.WebService
import com.subratsss.product_questionary_app.utils.NetworkException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionaryRepo {
    private  var webService: WebService = AppServiceConnector.serviceConnector!!
            .create(WebService::class.java)

    /**
     * Fetch Questionary list
     */
    fun getQuestionary(listener:OnResultListener) {

        webService.getQuestionInfo()
                .enqueue(object : Callback<QuestionsRes> {
                    override fun onResponse(call: Call<QuestionsRes>, response: Response<QuestionsRes>) {
                        response.body()?.let { listener.onSuccess(it) }
                    }
                    override fun onFailure(call: Call<QuestionsRes>, t: Throwable) {

                        if (t is NetworkException){
                            t.message?.let { listener.onError(OnErrorResponse(it,0)) }
                        }else{
                            t.message?.let { listener.onError(OnErrorResponse(it,1)) }
                        }


                    }

                })
    }
}
