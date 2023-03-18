package com.example.disneyHeroes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "FavouriteHeroes")
data class CharacterInfo(
    @PrimaryKey (autoGenerate = true)
    val _id: Int?,
    @ColumnInfo(name = "Allies")
    val allies: List<String>?,
    @ColumnInfo(name = "Enemies")
    val enemies: List<String>?,
    @ColumnInfo(name = "Films")
    val films: List<String>?,
    @ColumnInfo(name = "ImageUrl")
    val imageUrl: String?,
    @ColumnInfo(name = "Name")
    val name: String?,
    @ColumnInfo(name = "ParkAttractions")
    val parkAttractions: List<String>?,
    @ColumnInfo(name = "ShortFilms")
    val shortFilms: List<String>?,
    @ColumnInfo(name = "TvShows")
    val tvShows: List<String>?,
    @ColumnInfo(name = "Url")
    val url: String?,
    @ColumnInfo(name = "VideoGames")
    val videoGames: List<String>?
)