package com.revolut.android.data.repository

import com.revolut.android.data.model.LatestCurrencies
import com.revolut.android.data.network.LatestCurrenciesApi
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 2019-07-28.
 */
class RemoteDataImpl @Inject constructor(private val latestCurrenciesApi: LatestCurrenciesApi) :
    RemoteData {
    override fun fetchLatestCurrencies(
        base: String
    ): Observable<LatestCurrencies> {
        return latestCurrenciesApi.getLatestCurrencies(base)
            .concatMap { latestCurrencies ->
                Observable.just(latestCurrencies)
            }
    }
}