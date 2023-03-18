package com.example.disneyHeroes.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.disneyHeroes.model.CharacterInfo

@Dao
interface CharDAO {

    @Insert
    suspend fun putFavouriteChar(hero: CharacterInfo)

    @Query("SELECT * FROM FavouriteHeroes")
    suspend fun getFavouriteChar():List<CharacterInfo>

    @Query(/* value = */ "SELECT * FROM FavouriteHeroes WHERE _id LIKE:id")
    suspend fun checkItemInDB(id:Int): CharacterInfo?

    @Delete
    suspend fun deleteFavoriteHero(hero: CharacterInfo)

    @Delete
    suspend fun deleteAllHero(list:List<CharacterInfo>)
}