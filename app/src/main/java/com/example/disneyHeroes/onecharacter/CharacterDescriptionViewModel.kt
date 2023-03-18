package com.example.disneyHeroes.onecharacter

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
class CharacterDescriptionViewModel @Inject constructor(
    private val repository: CharactersRepository
) : ViewModel() {



    val listChar = MutableLiveData<ArrayList<CharacterInfo>>()

    val listFavChar = MutableLiveData<ArrayList<CharacterInfo>>()

    var charAdded: (() -> Unit)? = null

    var charDeleted: (() -> Unit)? = null

    fun getCharacter(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCharacter()
            if (response.isSuccessful){
                listChar.postValue((response.body()?.data  as ArrayList<CharacterInfo>))
            } else {
                response.errorBody()
            }
        }
    }

    fun getFavouriteCharacter() {
        viewModelScope.launch {
            listFavChar.postValue(repository.getFavouriteCharacter())
        }
    }

    fun putFavouriteCharacter(char: CharacterInfo){
        viewModelScope.launch {
            repository.putFavouriteChar(char)
            charAdded?.invoke()
        }
    }

    fun deleteFavouriteCharacter(char: CharacterInfo) {
        viewModelScope.launch {
            repository.deleteFavouriteChar(char)
            charDeleted?.invoke()
        }
    }
}