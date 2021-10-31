package com.cmhernandezdel.openbanktest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cmhernandezdel.openbanktest.models.MarvelAPIResult

class ListItemViewModel(private val character: MarvelAPIResult, private val onItemClicked: (character: MarvelAPIResult) -> Unit):
    ViewModel() {
    private val _name = MutableLiveData(character.name)
    val name: LiveData<String> by this::_name

    fun onClick() {
        this.onItemClicked(this.character)
    }
}