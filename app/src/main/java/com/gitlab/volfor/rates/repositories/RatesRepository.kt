package com.gitlab.volfor.rates.repositories

import com.gitlab.volfor.rates.api.RatesService
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
            ratesService.getRates(baseCurrency).rates
        } catch (e: Exception) {
            Timber.w(e)
            null
        }
    }
}