package com.cmhernandezdel.openbanktest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmhernandezdel.openbanktest.models.MarvelAPIResult
import com.cmhernandezdel.openbanktest.providers.ApiProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(val apiProvider: ApiProvider) : ViewModel() {
    private val _characters = MutableLiveData<ArrayList<ListItemViewModel>>()
    private val _selectedCharacter = MutableLiveData<MarvelAPIResult?>()
    val characters: LiveData<ArrayList<ListItemViewModel>> by this::_characters
    val selectedCharacter: LiveData<MarvelAPIResult?> by this::_selectedCharacter

    init {
        retrieveCharacters()
    }

    private fun onItemClicked(character: MarvelAPIResult) {
        _selectedCharacter.postValue(character)
    }

    fun retrieveCharacters() = viewModelScope.launch {
        val response = apiProvider.getCharacters(_characters.value?.size ?: 0)
        response?.let {
            val characterList = _characters.value ?: ArrayList()
            for (character in it.data.results) {
                val viewModel = ListItemViewModel(character, ::onItemClicked)
                characterList.add(viewModel)
            }
            _characters.postValue(characterList)
        }
    }

    fun unsetCurrentCharacter() = viewModelScope.launch {
        _selectedCharacter.postValue(null)
    }
}