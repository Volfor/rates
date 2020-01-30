package com.gitlab.volfor.rates.repositories

import com.gitlab.volfor.rates.api.RatesService
import javax.inject.Inject

class RatesRepository @Inject constructor(
    private val ratesService: RatesService
) {

}