package com.example.disneyHeroes.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn (SingletonComponent::class)
object CharDB {

    @Provides
    fun provideDB(@ApplicationContext context: Context) : AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"
        ).build()
    }

    @Provides
    fun provideCharDAO(appDataBase: AppDataBase) : CharDAO {
        return appDataBase.charDAO()
    }
}