package com.cmhernandezdel.openbanktest.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cmhernandezdel.openbanktest.adapters.BindableRecyclerViewAdapter
import com.cmhernandezdel.openbanktest.viewmodels.ListItemViewModel

object ListItemViewModelToRecyclerViewDataBindingAdapter {
    @BindingAdapter("itemViewModels")
    @JvmStatic
    fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: List<ListItemViewModel>?) {
        val adapter = getOrCreateAdapter(recyclerView)
        adapter.updateItems(itemViewModels)
    }

    private fun getOrCreateAdapter(recyclerView: RecyclerView): BindableRecyclerViewAdapter {
        return if (recyclerView.adapter != null && recyclerView.adapter is BindableRecyclerViewAdapter) {
            recyclerView.adapter as BindableRecyclerViewAdapter
        } else {
            val bindableRecyclerViewAdapter = BindableRecyclerViewAdapter()
            recyclerView.adapter = bindableRecyclerViewAdapter
            bindableRecyclerViewAdapter
        }
    }
}