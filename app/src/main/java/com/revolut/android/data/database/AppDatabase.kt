package com.revolut.android.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.revolut.android.data.model.LatestCurrencies

/**
 * Created by Vlad Sabau on 2019-07-28.
 */
@Database(entities = [(LatestCurrencies::class)], version = 1)
@TypeConverters(RatesConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun latestCurrenciesDao(): LatestCurrenciesDao
}