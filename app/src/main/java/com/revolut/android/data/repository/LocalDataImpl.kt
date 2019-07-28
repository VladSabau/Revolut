package com.revolut.android.data.repository

import com.revolut.android.data.database.LatestCurrenciesDao
import com.revolut.android.data.model.LatestCurrencies
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Vlad Sabau on 2019-07-28.
 */
class LocalDataImpl @Inject constructor(private val latestCurrenciesDao: LatestCurrenciesDao) :
    LocalData {

    override fun getLatestCurrencies(): Observable<LatestCurrencies> {
        return Observable.fromCallable { latestCurrenciesDao.get }
    }

    override fun insertLatestCurrencies(latestCurrencies: LatestCurrencies) {
        latestCurrenciesDao.insert(latestCurrencies)
    }
}