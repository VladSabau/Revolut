package com.revolut.android.data.repository

import com.revolut.android.data.model.LatestCurrencies
import io.reactivex.Observable

/**
 * Created by Vlad Sabau on 2019-07-28.
 */
interface RemoteData {
    fun fetchLatestCurrencies(
        base: String
    ): Observable<LatestCurrencies>
}
