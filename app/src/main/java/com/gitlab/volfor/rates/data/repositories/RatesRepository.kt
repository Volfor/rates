package com.gitlab.volfor.rates.data.repositories

import com.gitlab.volfor.rates.data.api.RatesService
import com.gitlab.volfor.rates.data.Result.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class RatesRepository @Inject constructor(
    private val ratesService: RatesService
) {
    suspend fun fetchRates(baseCurrency: String) = withContext(Dispatchers.IO) {
        try {
            val response = ratesService.getRates(baseCurrency)
            Success(response.rates)
        } catch (e: Exception) {
            Timber.d(e)
            Error
        }
    }
}