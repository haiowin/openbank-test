package com.cmhernandezdel.openbanktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cmhernandezdel.openbanktest.fragments.ListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity_fragment_container, ListFragment()).commit()
    }
}