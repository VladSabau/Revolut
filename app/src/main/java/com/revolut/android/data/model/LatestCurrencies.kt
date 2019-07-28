package com.revolut.android.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Vlad Sabau on 2019-07-28.
 */
@Entity
data class LatestCurrencies(
    @SerializedName("base") var base: String = "",
    @SerializedName("date") @PrimaryKey var date: String = "",
    @SerializedName("rates") var rates: HashMap<String, String> = hashMapOf()
)