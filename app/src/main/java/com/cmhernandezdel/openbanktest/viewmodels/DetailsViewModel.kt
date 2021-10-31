package com.cmhernandezdel.openbanktest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cmhernandezdel.openbanktest.models.MarvelAPIResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {
    private val _displayCharacter = MutableLiveData<MarvelAPIResult>()
    val displayCharacter : LiveData<MarvelAPIResult> by this::_displayCharacter
}