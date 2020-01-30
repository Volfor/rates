package com.gitlab.volfor.rates.data.repositories

import com.gitlab.volfor.rates.data.Result.Error
import com.gitlab.volfor.rates.data.Result.Success
import com.gitlab.volfor.rates.data.api.RatesService
import com.gitlab.volfor.rates.utils.CoroutineContextProviders
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class RatesRepository @Inject constructor(
    private val ratesService: RatesService,
    private val coroutineContextProviders: CoroutineContextProviders
) {
    suspend fun fetchRates(baseCurrency: String) = withContext(coroutineContextProviders.IO) {
        try {
            val response = ratesService.getRates(baseCurrency)
            Success(response.rates)
        } catch (e: Exception) {
            Timber.d(e)
            Error
        }
    }
}