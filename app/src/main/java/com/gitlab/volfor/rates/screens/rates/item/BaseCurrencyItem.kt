package com.gitlab.volfor.rates.screens.rates.item

import androidx.lifecycle.MutableLiveData

data class BaseCurrencyItem(
    val currency: String,
    val amount: MutableLiveData<String>
)