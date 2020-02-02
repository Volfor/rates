package com.gitlab.volfor.rates.screens.rates.item

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import java.util.*

data class RateItem(
    val currency: Currency,
    val rate: Double,
    val amount: MutableLiveData<String>,
    val isBase: Boolean = false
) {
    interface Listener {
        fun onRateClick(item: RateItem)
    }

    val currencyName: String
        get() = currency.getDisplayName(Locale.ENGLISH)

    val totalAmount = amount.map {
        it?.takeIf { it.isNotBlank() }
            ?.toDoubleOrNull()
            ?.let { amount ->
                String.format(Locale.ENGLISH, "%.2f", amount * rate)
            }
    }
}