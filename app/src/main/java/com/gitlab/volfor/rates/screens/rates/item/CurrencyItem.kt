package com.gitlab.volfor.rates.screens.rates.item

import androidx.lifecycle.LiveData
import androidx.lifecycle.map

data class CurrencyItem(
    val currency: String,
    val rate: Double,
    val multiplier: LiveData<String>
) {
    val totalAmount = multiplier.map {
        it.takeIf { it.isNotBlank() }
            ?.toDoubleOrNull()
            ?.let { multiplier ->
                String.format("%.2f", rate * multiplier)
            }
    }
}