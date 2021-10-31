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
class ListViewModel @Inject constructor(private val apiProvider: ApiProvider) : ViewModel() {
    private val _characters = MutableLiveData<List<ListItemViewModel>>()
    private val _selectedCharacter = MutableLiveData<ListItemViewModel>()
    val characters: LiveData<List<ListItemViewModel>> by this::_characters
    val selectedCharacter: LiveData<ListItemViewModel> by this::_selectedCharacter

    init {
        retrieveCharacters()
    }

    private fun onItemClicked(character: MarvelAPIResult) {

    }

    private fun retrieveCharacters() = viewModelScope.launch {
        val response = apiProvider.getCharacters()
        response?.let {
            val characterList = ArrayList<ListItemViewModel>()
            for (character in it.data.results) {
                val viewModel = ListItemViewModel(character, ::onItemClicked)
                characterList.add(viewModel)
            }
            _characters.postValue(characterList)
        }
    }
}