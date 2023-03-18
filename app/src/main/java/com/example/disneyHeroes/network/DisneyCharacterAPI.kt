package com.example.disneyHeroes.network

import com.example.disneyHeroes.model.AllCharacters
import retrofit2.Response
import retrofit2.http.GET

interface DisneyCharacterAPI {

    @GET("characters")
    suspend fun getOneCharacter(): Response<AllCharacters>
}