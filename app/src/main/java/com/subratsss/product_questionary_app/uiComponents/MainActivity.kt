package com.subratsss.product_questionary_app.uiComponents

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.subratsss.product_questionary_app.R
import com.subratsss.product_questionary_app.databinding.ActivityMainBinding
import com.subratsss.product_questionary_app.viewModel.QuestionInfoViewModel

class MainActivity : AppCompatActivity() {
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
        viewModel.getProductRepository().observe(this,
            Observer {
                viewModel.setQuestionListInAdapter(it.questions)
                activityMainBinding.progressBar.visibility = View.GONE
            })
        activityMainBinding.viewModel = viewModel

        setupRecyclerView()
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


}