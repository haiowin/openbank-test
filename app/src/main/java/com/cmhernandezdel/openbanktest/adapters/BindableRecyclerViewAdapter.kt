package com.cmhernandezdel.openbanktest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cmhernandezdel.openbanktest.R
import com.cmhernandezdel.openbanktest.viewmodels.ListItemViewModel

class BindableRecyclerViewAdapter : RecyclerView.Adapter<BindableViewHolder>() {
    var characterViewModels: List<ListItemViewModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item,
            parent, false
        )
        return BindableViewHolder(binding)
    }

    override fun getItemCount(): Int = characterViewModels.count()

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.bind(characterViewModels[position])
    }

    fun updateItems(items: List<ListItemViewModel>?) {
        characterViewModels = items ?: emptyList()
        notifyDataSetChanged()
    }
}