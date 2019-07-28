package com.revolut.android.data.network

import com.revolut.android.data.model.LatestCurrencies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The interface which provides methods to get result of webservices
 * Created by Vlad Sabau on 2019-07-28.
 */
interface LatestCurrenciesApi {

    @GET("latest")
    fun getLatestCurrencies(
        @Query("base") base: String
    ): Observable<LatestCurrencies>
}