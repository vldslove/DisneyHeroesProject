package com.example.disneyHeroes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.disneyHeroes.typeConverter.AlliesConverter
import com.example.disneyHeroes.model.CharacterInfo

@Database(entities = [CharacterInfo::class], version = 1)
@TypeConverters(AlliesConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun charDAO(): CharDAO
}