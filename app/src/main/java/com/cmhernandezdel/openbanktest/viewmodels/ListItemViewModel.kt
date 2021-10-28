package com.cmhernandezdel.openbanktest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListItemViewModel(private val characterName: String): ViewModel() {
    private val _name = MutableLiveData(characterName)
    val name: LiveData<String> by this::_name
}