package com.cmhernandezdel.openbanktest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmhernandezdel.openbanktest.models.MarvelAPIResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {
    private val _displayCharacter = MutableLiveData<MarvelAPIResult?>()
    val displayCharacter: LiveData<MarvelAPIResult?> by this::_displayCharacter

    fun setDisplayCharacter(character: MarvelAPIResult) = viewModelScope.launch {
        _displayCharacter.postValue(character)
    }

    fun unsetDisplayCharacter() = viewModelScope.launch {
        _displayCharacter.postValue(null)
    }
}