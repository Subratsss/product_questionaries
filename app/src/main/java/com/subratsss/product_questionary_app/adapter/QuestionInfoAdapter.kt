package com.subratsss.product_questionary_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView.*
import com.subratsss.product_questionary_app.BR
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
import com.subratsss.product_questionary_app.databinding.*
import com.subratsss.product_questionary_app.model.QuestionInfo
import com.subratsss.product_questionary_app.viewModel.QuestionInfoViewModel


class QuestionInfoAdapter(
    private val questionDetailsList: ArrayList<QuestionInfo>,
    var viewModel: QuestionInfoViewModel
) : Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         return (when (viewType) {
             VIEW_TYPE_TEXT_VIEW_ID -> {
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = DataBindingUtil.inflate<ViewDataBinding>(
                     layoutInflater,
                     viewType,
                     parent,
                     false
                 )
                 TextViewHolder(binding as RowTextViewBinding)
             }
             VIEW_TYPE_EMAILTEXT_VIEW_ID -> {
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = DataBindingUtil.inflate<ViewDataBinding>(
                     layoutInflater,
                     viewType,
                     parent,
                     false
                 )
                 EmailTextViewHolder(binding as RowEmailTextViewBinding)
             }
             VIEW_TYPE_RADIO_VIEW_ID -> {
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = DataBindingUtil.inflate<ViewDataBinding>(
                     layoutInflater,
                     viewType,
                     parent,
                     false
                 )
                 RadioViewHolder(binding as RowRadioButtonViewBinding)
             }
             VIEW_TYPE_MULTISELECT_VIEW_ID -> {
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = DataBindingUtil.inflate<ViewDataBinding>(
                     layoutInflater,
                     viewType,
                     parent,
                     false
                 )
                 MultiSelectViewHolder(binding as RowMultiSelectionViewBinding)
             }
             VIEW_TYPE_DROPDOWN_VIEW_ID -> {
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = DataBindingUtil.inflate<ViewDataBinding>(
                     layoutInflater,
                     viewType,
                     parent,
                     false
                 )
                 DropDownViewHolder(binding as RowDropDownViewBinding)
             }
             else -> {
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = DataBindingUtil.inflate<ViewDataBinding>(
                     layoutInflater,
                     viewType,
                     parent,
                     false
                 )
                 ImageViewViewHolder(binding as RowImageViewBinding)
             }
         })
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when(holder.itemViewType) {
            VIEW_TYPE_TEXT_VIEW_ID -> {
                (holder as TextViewHolder).bindData(viewModel, position)
            }
            VIEW_TYPE_EMAILTEXT_VIEW_ID -> {
                (holder as EmailTextViewHolder).bindData(viewModel, position)
            }
            VIEW_TYPE_RADIO_VIEW_ID -> {
                (holder as RadioViewHolder).bindData(viewModel, position)
            }
            VIEW_TYPE_MULTISELECT_VIEW_ID -> {
                (holder as MultiSelectViewHolder).bindData(viewModel, position)
            }
            VIEW_TYPE_DROPDOWN_VIEW_ID -> {
                (holder as DropDownViewHolder).bindData(viewModel, position)
            }
            else -> {
                (holder as ImageViewViewHolder).bindData(viewModel, position)
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
            else -> { VIEW_TYPE_IMAGEVIEW_VIEW_ID}
        })
    }

    inner class TextViewHolder(private val binding: RowTextViewBinding) :
        ViewHolder(binding.root) {

        fun bindData(questionInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, questionInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class EmailTextViewHolder(private val binding: RowEmailTextViewBinding) :
        ViewHolder(binding.root) {

        fun bindData(questionInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, questionInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class RadioViewHolder(private val binding: RowRadioButtonViewBinding) :
        ViewHolder(binding.root) {

        fun bindData(questionInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, questionInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class MultiSelectViewHolder(private val binding: RowMultiSelectionViewBinding) :
        ViewHolder(binding.root) {

        fun bindData(questionInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, questionInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class DropDownViewHolder(private val binding: RowDropDownViewBinding) :
        ViewHolder(binding.root) {

        fun bindData(questionInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, questionInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }

    inner class ImageViewViewHolder(private val binding: RowImageViewBinding) :
        ViewHolder(binding.root) {

        fun bindData(questionInfoViewModel: QuestionInfoViewModel, position: Int) {
            binding.setVariable(BR.viewModel, questionInfoViewModel)
            binding.setVariable(BR.position, position)
        }
    }
}