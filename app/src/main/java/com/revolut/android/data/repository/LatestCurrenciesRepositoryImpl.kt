package com.revolut.android.data.repository

import com.revolut.android.data.model.LatestCurrencies
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 2019-07-28.
 */
class LatestCurrenciesRepositoryImpl @Inject constructor(
    private val localData: LocalData,
    private val remoteData: RemoteData
) : LatestCurrenciesRepository {
    override fun loadLatestCurrencies(base: String): Observable<LatestCurrencies>? {
        return streamLatestCurrencies(base)
    }

    private fun streamLatestCurrencies(base: String): Observable<LatestCurrencies>? {
        return fetchLatestCurrencies(base)
            .onErrorResumeNext(localData.getLatestCurrencies())
    }

    private fun fetchLatestCurrencies(
        base: String
    ): Observable<LatestCurrencies> {
        return remoteData.fetchLatestCurrencies(base)
            .concatMap { currencies ->
                localData.insertLatestCurrencies(currencies)
                Observable.just(currencies)
            }
    }
}