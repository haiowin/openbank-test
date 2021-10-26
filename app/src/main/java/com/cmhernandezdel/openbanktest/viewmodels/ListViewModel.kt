package com.cmhernandezdel.openbanktest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmhernandezdel.openbanktest.providers.ApiProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val apiProvider: ApiProvider) : ViewModel() {
    fun getCharacters() = viewModelScope.launch {
        apiProvider.getCharacters()
    }
}