package com.gitlab.volfor.rates.data.api

data class RatesResponse(
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)