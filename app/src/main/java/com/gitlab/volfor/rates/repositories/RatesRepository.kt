package com.gitlab.volfor.rates.repositories

import com.gitlab.volfor.rates.api.RatesService
import com.gitlab.volfor.rates.utils.CoroutineContextProviders
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RatesRepository @Inject constructor(
    private val ratesService: RatesService,
    private val coroutineContextProviders: CoroutineContextProviders
) {
    fun fetchRates(baseCurrency: String) = flow {
        while (true) {
            emit(ratesService.getRates(baseCurrency).rates)
            delay(1000)
        }
    }.flowOn(coroutineContextProviders.IO)
}