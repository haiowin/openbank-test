package com.cmhernandezdel.openbanktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.cmhernandezdel.openbanktest.fragments.DetailsFragment
import com.cmhernandezdel.openbanktest.fragments.ListFragment
import com.cmhernandezdel.openbanktest.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mViewModel: SharedViewModel by viewModels()
    private val mListFragment = ListFragment()
    private val mDetailsFragment = DetailsFragment()
    private var isDetailsFragmentShowing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startListFragment()

        mViewModel.selectedCharacter.observe(this, {
            if (it != null) startDetailsFragment()
            else startListFragment()
        })
    }

    override fun onBackPressed() {
        if (isDetailsFragmentShowing) {
            mViewModel.unsetCurrentCharacter()
        }
    }

    private fun startDetailsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_fragment_container, mDetailsFragment).commit()
        isDetailsFragmentShowing = true
    }

    private fun startListFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_fragment_container, mListFragment).commit()
        isDetailsFragmentShowing = false
    }
}