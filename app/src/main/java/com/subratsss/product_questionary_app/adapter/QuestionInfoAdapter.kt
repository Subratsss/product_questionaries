package com.subratsss.product_questionary_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.subratsss.product_questionary_app.BR
import com.subratsss.product_questionary_app.databinding.RowQuestionDetailsBinding
import com.subratsss.product_questionary_app.model.QuestionInfo
import com.subratsss.product_questionary_app.viewModel.QuestionInfoViewModel


class QuestionInfoAdapter(
    @LayoutRes var layoutId: Int,
    private val imageDetailsList: ArrayList<QuestionInfo>,
    var viewModel: QuestionInfoViewModel
) : RecyclerView.Adapter<QuestionInfoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return ViewHolder(binding as RowQuestionDetailsBinding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(viewModel, position)
    }

    override fun getItemCount(): Int {
        return imageDetailsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return layoutId
    }

    inner class ViewHolder(private val binding: RowQuestionDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(productInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, productInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }
}