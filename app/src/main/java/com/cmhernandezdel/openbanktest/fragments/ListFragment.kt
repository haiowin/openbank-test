package com.cmhernandezdel.openbanktest.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmhernandezdel.openbanktest.R
import com.cmhernandezdel.openbanktest.databinding.ListFragmentBinding
import com.cmhernandezdel.openbanktest.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.list_fragment) {
    private val mSharedViewModel: SharedViewModel by activityViewModels()

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
        }
    }
}