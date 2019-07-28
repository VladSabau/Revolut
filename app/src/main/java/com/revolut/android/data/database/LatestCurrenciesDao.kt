package com.revolut.android.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.revolut.android.data.model.LatestCurrencies

/**
 * Created by Vlad Sabau on 2019-07-28.
 */
@Dao
interface LatestCurrenciesDao {
    @get:Query("SELECT * FROM LatestCurrencies")
    val get: LatestCurrencies

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(latestCurrencies: LatestCurrencies)
}