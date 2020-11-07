package com.subratsss.product_questionary_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.subratsss.product_questionary_app.BR
import com.subratsss.product_questionary_app.R
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_DROPDOWN
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_DROPDOWN_VIEW_ID
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_EMAILTEXT
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_EMAILTEXT_VIEW_ID
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_IMAGEVIEW
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_IMAGEVIEW_VIEW_ID
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_MULTISELECT
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_MULTISELECT_VIEW_ID
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_RADIO
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_RADIO_VIEW_ID
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_TEXT
import com.subratsss.product_questionary_app.constants.ViewConstants.VIEW_TYPE_TEXT_VIEW_ID
import com.subratsss.product_questionary_app.databinding.RowQuestionDetailsBinding
import com.subratsss.product_questionary_app.model.QuestionInfo
import com.subratsss.product_questionary_app.viewModel.QuestionInfoViewModel


class QuestionInfoAdapter(
    private val questionDetailsList: ArrayList<QuestionInfo>,
    var viewModel: QuestionInfoViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return (when (viewType) {
            VIEW_TYPE_TEXT_VIEW_ID -> {
                TextViewHolder(binding as RowQuestionDetailsBinding)
            }
            VIEW_TYPE_EMAILTEXT_VIEW_ID -> {
                EmailTextViewHolder(binding as RowQuestionDetailsBinding)
            }
            VIEW_TYPE_RADIO_VIEW_ID -> {
                RadioViewHolder(binding as RowQuestionDetailsBinding)
            }
            VIEW_TYPE_MULTISELECT_VIEW_ID -> {
                MultiSelectViewHolder(binding as RowQuestionDetailsBinding)
            }
            VIEW_TYPE_DROPDOWN_VIEW_ID -> {
                DropDownViewHolder(binding as RowQuestionDetailsBinding)
            }
            VIEW_TYPE_IMAGEVIEW_VIEW_ID -> {
                ImageViewViewHolder(binding as RowQuestionDetailsBinding)
            }
            else -> {}
        }) as RecyclerView.ViewHolder
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when {
            questionDetailsList[position].type === VIEW_TYPE_TEXT -> {
                (holder as TextViewHolder).bindData(viewModel, position)
            }
            questionDetailsList[position].type === VIEW_TYPE_EMAILTEXT -> {
                (holder as EmailTextViewHolder).bindData(viewModel, position)
            }
            questionDetailsList[position].type === VIEW_TYPE_RADIO -> {
                (holder as RadioViewHolder).bindData(viewModel, position)
            }
            questionDetailsList[position].type === VIEW_TYPE_MULTISELECT -> {
                (holder as MultiSelectViewHolder).bindData(viewModel, position)
            }
            questionDetailsList[position].type === VIEW_TYPE_DROPDOWN -> {
                (holder as DropDownViewHolder).bindData(viewModel, position)
            }
            questionDetailsList[position].type === VIEW_TYPE_IMAGEVIEW -> {
                (holder as ImageViewViewHolder).bindData(viewModel, position)
            }
            else -> {
            }
        }
    }

    override fun getItemCount(): Int {
        return questionDetailsList.size
    }

    override fun getItemViewType(position: Int): Int {
        return (when {
            questionDetailsList[position].type === VIEW_TYPE_TEXT -> {
                VIEW_TYPE_TEXT_VIEW_ID
            }
            questionDetailsList[position].type === VIEW_TYPE_EMAILTEXT -> {
                VIEW_TYPE_EMAILTEXT_VIEW_ID
            }
            questionDetailsList[position].type === VIEW_TYPE_RADIO -> {
                VIEW_TYPE_RADIO_VIEW_ID
            }
            questionDetailsList[position].type === VIEW_TYPE_MULTISELECT -> {
                VIEW_TYPE_MULTISELECT_VIEW_ID
            }
            questionDetailsList[position].type === VIEW_TYPE_DROPDOWN -> {
                VIEW_TYPE_DROPDOWN_VIEW_ID
            }
            questionDetailsList[position].type === VIEW_TYPE_IMAGEVIEW -> {
                VIEW_TYPE_IMAGEVIEW_VIEW_ID
            }
            else -> {
            }
        }) as Int
    }

    inner class TextViewHolder(private val binding: RowQuestionDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(productInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, productInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class EmailTextViewHolder(private val binding: RowQuestionDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(productInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, productInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class RadioViewHolder(private val binding: RowQuestionDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(productInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, productInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class MultiSelectViewHolder(private val binding: RowQuestionDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(productInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, productInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class DropDownViewHolder(private val binding: RowQuestionDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(productInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, productInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class ImageViewViewHolder(private val binding: RowQuestionDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(productInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, productInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }
}