package com.example.disneyHeroes.characterlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyHeroes.model.CharacterInfo
import com.example.disneyHeroes.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository : CharactersRepository

): ViewModel(){

    val listChar = MutableLiveData<ArrayList<CharacterInfo>>()

    val listFavChar = MutableLiveData<ArrayList<CharacterInfo>>()


    fun getChars(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllCharacters()
            if (response.isSuccessful) {
                listChar.postValue(
                    (response.body()?.data ?: arrayListOf()) as ArrayList<CharacterInfo>?
                )
            } else {
                response.errorBody()
            }
        }
    }

    fun getFavouriteChar() {
        viewModelScope.launch {
            listFavChar.postValue(repository.getFavouriteCharacter())
        }
    }
}