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
class SharedViewModel @Inject constructor() : ViewModel() {
    private val _currentCharacter = MutableLiveData<MarvelAPIResult?>()
    val currentCharacter: LiveData<MarvelAPIResult?> by this::_currentCharacter

    fun setCurrentCharacter(character: MarvelAPIResult) = viewModelScope.launch {
        _currentCharacter.postValue(character)
    }

    fun unsetCurrentCharacter() = viewModelScope.launch {
        _currentCharacter.postValue(null)
    }
}