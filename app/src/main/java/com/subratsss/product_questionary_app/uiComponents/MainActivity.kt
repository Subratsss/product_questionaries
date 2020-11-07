package com.subratsss.product_questionary_app.uiComponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.subratsss.product_questionary_app.R
import com.subratsss.product_questionary_app.databinding.ActivityMainBinding
import com.subratsss.product_questionary_app.listener.OnErrorResponse
import com.subratsss.product_questionary_app.model.api_res_model.QuestionsRes
import com.subratsss.product_questionary_app.viewModel.QuestionInfoViewModel

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: QuestionInfoViewModel
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Data Binding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //ViewModel
        viewModel = ViewModelProvider(this).get(QuestionInfoViewModel::class.java)
        viewModel.init()
        fetchData()
        activityMainBinding.viewModel = viewModel

        setupRecyclerView()

        //Listeners
        activityMainBinding.swipeRefreshLayout.setOnRefreshListener(this)

        activityMainBinding.retryButton.setOnClickListener {
            activityMainBinding.progressBar.visibility = View.VISIBLE
            viewModel.onRefreshView()
        }
    }

    /**
     * Setup RecyclerView
     */
    private fun setupRecyclerView() {
        recyclerView = activityMainBinding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = true
    }
    override fun onRefresh() {
        if (activityMainBinding.swipeRefreshLayout.isRefreshing) {
            activityMainBinding.swipeRefreshLayout.isRefreshing = false
        }
        viewModel.onRefreshView()
    }

    private fun fetchData(){

        viewModel.getProductRepository().observe(this,
            Observer {
                if (it is QuestionsRes) {
                    viewModel.setQuestionListInAdapter(it.questions)
                    activityMainBinding.progressBar.visibility = View.GONE
                } else if (it is OnErrorResponse) {
                    if (it.errorId == 0){
                        Toast.makeText(this,it.error,Toast.LENGTH_LONG).show()
                    }else{
                        activityMainBinding.retryButton.visibility = View.VISIBLE
                        Toast.makeText(this,it.error,Toast.LENGTH_LONG).show()
                    }

                }
            })
    }
}