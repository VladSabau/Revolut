package com.revolut.android.data.database

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * Created by Vlad Sabau on 2019-07-28.
 */
class RatesConverter {

    private val gson = Gson()

    @TypeConverter
    fun stringToHashMap(data: String?): HashMap<String, String> {
        if (data == null) {
            return hashMapOf()
        }

        val listType = object : TypeToken<HashMap<String, String>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun hashMapToString(images: HashMap<String, String>): String {
        return gson.toJson(images)
    }
}