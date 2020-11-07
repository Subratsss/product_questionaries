package com.subratsss.product_questionary_app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.subratsss.product_questionary_app.R
import com.subratsss.product_questionary_app.adapter.QuestionInfoAdapter
import com.subratsss.product_questionary_app.model.QuestionInfo
import com.subratsss.product_questionary_app.model.ValueInfo
import com.subratsss.product_questionary_app.model.api_res_model.QuestionsRes
import com.subratsss.product_questionary_app.repository.QuestionaryRepo


class QuestionInfoViewModel : ViewModel() {

    private lateinit var questionInfoRepository: QuestionaryRepo
    private var questionLiveData = MutableLiveData<QuestionsRes>()
    private var questionInfoList: ArrayList<QuestionInfo> = arrayListOf()
    private lateinit var adapter: QuestionInfoAdapter

    fun init() {

        questionInfoRepository = QuestionaryRepo()
        questionLiveData = questionInfoRepository.getQuestionary()
        adapter = QuestionInfoAdapter(R.layout.row_text_view, questionInfoList, this)

    }

    fun getProductRepository(): MutableLiveData<QuestionsRes> {
        return questionLiveData
    }

    //Set List Of Products In Adapter
    fun setQuestionListInAdapter(productList: ArrayList<QuestionInfo>) {
        questionInfoList.addAll(productList)
        this.adapter.notifyDataSetChanged()
    }

    fun setAdapter(): QuestionInfoAdapter {
        return adapter
    }

    fun setQuestion(position: Int): String {
        return questionInfoList[position].question
    }

    fun setType(position: Int):String{
        return questionInfoList[position].type
    }

    fun setValuesList(position: Int):ArrayList<ValueInfo>{
        return questionInfoList[position].values
    }

    fun setLogoImage(position: Int): String {
        return questionInfoList[position].url
    }





}