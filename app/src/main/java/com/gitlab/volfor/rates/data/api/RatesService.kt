package com.gitlab.volfor.rates.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface RatesService {

    @GET("latest")
    suspend fun getRates(@Query("base") baseCurrency: String): RatesResponse

}