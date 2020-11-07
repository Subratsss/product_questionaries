package com.subratsss.product_questionary_app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.subratsss.product_questionary_app.adapter.QuestionInfoAdapter
import com.subratsss.product_questionary_app.listener.OnErrorResponse
import com.subratsss.product_questionary_app.listener.OnResponse
import com.subratsss.product_questionary_app.listener.OnResultListener
import com.subratsss.product_questionary_app.model.QuestionInfo
import com.subratsss.product_questionary_app.model.ValueInfo
import com.subratsss.product_questionary_app.model.api_res_model.QuestionsRes
import com.subratsss.product_questionary_app.repository.QuestionaryRepo
import okhttp3.Response


class QuestionInfoViewModel : ViewModel(), OnResultListener {

    private lateinit var questionInfoRepository: QuestionaryRepo
    private var questionLiveData = MutableLiveData<OnResponse>()
     var questionInfoList: ArrayList<QuestionInfo> = arrayListOf()
    private lateinit var adapter: QuestionInfoAdapter
    private var isRefresed:Boolean = false


    fun init() {
        questionInfoRepository = QuestionaryRepo()
        adapter = QuestionInfoAdapter(questionInfoList, this)
    }

    fun onRefreshView() {
        isRefresed = true
        if (questionInfoList.size > 0){
            questionInfoList.clear()
        }
        getProductRepository()
    }

    fun getProductRepository(): MutableLiveData<OnResponse> {
        questionInfoRepository.getQuestionary(this)
        return questionLiveData
    }

    //Set List Of Questions In Adapter
    fun setQuestionListInAdapter(questionsList: ArrayList<QuestionInfo>) {
        questionInfoList.addAll(questionsList)
        this.adapter.notifyDataSetChanged()
    }

    fun setAdapter(): QuestionInfoAdapter {
        return adapter
    }

    fun setQuestion(position: Int): String {
        return questionInfoList[position].question
    }

    fun setValuesList(position: Int): ArrayList<ValueInfo> {
        if (isRefresed && questionInfoList[position].values.size > 0){
            questionInfoList[position].values.clear()
        }
        return questionInfoList[position].values
    }

    fun setLogoImage(position: Int): String {
        return questionInfoList[position].url
    }

    override fun onSuccess(questionRes: QuestionsRes) {
        questionLiveData.value = questionRes
    }

    override fun onError(error: OnErrorResponse) {
        questionLiveData.value = error
    }


}