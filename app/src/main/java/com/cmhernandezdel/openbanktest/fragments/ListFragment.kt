package com.cmhernandezdel.openbanktest.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmhernandezdel.openbanktest.R
import com.cmhernandezdel.openbanktest.databinding.ListFragmentBinding
import com.cmhernandezdel.openbanktest.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.list_fragment) {
    private val mSharedViewModel: SharedViewModel by activityViewModels()

    private var previousTotal = 0
    private var loading = true
    private val visibleThreshold = 10
    private var firstVisibleItem = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = ListFragmentBinding.bind(view)
        binding.apply {
            viewModel = mSharedViewModel
            lifecycleOwner = viewLifecycleOwner

            listViewCharacters.apply {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }

            // See: https://stackoverflow.com/a/26643292/8966471
            listViewCharacters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) {
                        listViewCharacters.layoutManager?.let {
                            val layoutManager = it as LinearLayoutManager

                            visibleItemCount = layoutManager.childCount
                            totalItemCount = layoutManager.itemCount
                            firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

                            if (loading && totalItemCount > previousTotal) {
                                loading = false
                                previousTotal = totalItemCount
                            }

                            if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                                mSharedViewModel.retrieveCharacters()
                                loading = true
                            }
                        }
                    }
                }
            })
        }
    }
}