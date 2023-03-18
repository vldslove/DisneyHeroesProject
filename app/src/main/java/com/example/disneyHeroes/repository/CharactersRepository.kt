package com.example.disneyHeroes.repository

import com.example.disneyHeroes.model.AllCharacters
import com.example.disneyHeroes.model.CharacterInfo
import com.example.disneyHeroes.network.Network
import com.example.disneyHeroes.db.CharDAO
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersRepository @Inject constructor(
    private val charDAO: CharDAO
){

    suspend fun getAllCharacters(): Response<AllCharacters> {
        return Network().getCharactersApi().getAllCharacters()
    }

    suspend fun getCharacter(): Response<AllCharacters> {
        return Network().getOneCharacter().getOneCharacter()
    }

    suspend fun getFavouriteCharacter(): ArrayList<CharacterInfo> {
       return charDAO.getFavouriteChar() as ArrayList<CharacterInfo>
    }

    suspend fun putFavouriteChar(char: CharacterInfo) {
        charDAO.putFavouriteChar(char)
    }

    suspend fun deleteFavouriteChar(char: CharacterInfo) {
        charDAO.deleteFavoriteHero(char)
    }

}