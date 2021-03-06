package com.cmhernandezdel.openbanktest.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cmhernandezdel.openbanktest.R
import com.cmhernandezdel.openbanktest.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.cmhernandezdel.openbanktest.databinding.FragmentDetailsBinding

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val mSharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailsBinding.bind(view)
        binding.apply {
            viewModel = mSharedViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }
}