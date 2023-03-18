package com.example.disneyHeroes.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class Network {

    @Provides
    fun getCharactersApi(): DisneyCharactersAPI {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.disneyapi.dev/")
            .build()
        return retrofit.create(DisneyCharactersAPI::class.java)
    }

    @Provides
    fun getOneCharacter(): DisneyCharacterAPI {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.disneyapi.dev/")
            .build()
        return retrofit.create(DisneyCharacterAPI::class.java)
    }

}