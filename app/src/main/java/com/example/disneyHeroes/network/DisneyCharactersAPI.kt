package com.example.disneyHeroes.network

import com.example.disneyHeroes.model.AllCharacters
import retrofit2.Response
import retrofit2.http.GET

interface DisneyCharactersAPI {
    @GET("characters")
    suspend fun getAllCharacters(): Response<AllCharacters>

}