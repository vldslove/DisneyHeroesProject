package com.example.disneyHeroes.typeConverter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.util.stream.Collectors

class AlliesConverter {

    @RequiresApi(Build.VERSION_CODES.N)
    @TypeConverter
    fun fromAllies(allies: List<String?>): String {
        return allies.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toAllies(allies: String): List<String> {
        return listOf(listOf(allies.split(",").toTypedArray()).toString())
    }
}