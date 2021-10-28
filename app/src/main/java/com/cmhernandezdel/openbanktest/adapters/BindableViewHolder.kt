package com.cmhernandezdel.openbanktest.adapters

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cmhernandezdel.openbanktest.BR
import com.cmhernandezdel.openbanktest.viewmodels.ListItemViewModel

class BindableViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(itemViewModel: ListItemViewModel) {
        binding.setVariable(BR.viewModel, itemViewModel)
    }
}