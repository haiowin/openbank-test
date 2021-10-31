package com.cmhernandezdel.openbanktest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmhernandezdel.openbanktest.providers.ApiProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val apiProvider: ApiProvider) : ViewModel() {
    private val _characters = MutableLiveData<List<ListItemViewModel>>()
    val characters: LiveData<List<ListItemViewModel>> by this::_characters

    init {
        retrieveCharacters()
    }

    private fun retrieveCharacters() = viewModelScope.launch {
        val response = apiProvider.getCharacters()
        response?.let {
            val characterList = ArrayList<ListItemViewModel>()
            for (character in it.data.results) {
                val viewModel = ListItemViewModel(character.name)
                characterList.add(viewModel)
            }
            println("Post list of ${characterList.size} characters")
            _characters.postValue(characterList)
        }
    }
}