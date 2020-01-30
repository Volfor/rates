package com.gitlab.volfor.rates.screens

import androidx.lifecycle.ViewModel
import com.gitlab.volfor.rates.BR
import com.gitlab.volfor.rates.R
import com.gitlab.volfor.rates.repositories.RatesRepository
import me.tatarka.bindingcollectionadapter2.ItemBinding
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val ratesRepository: RatesRepository
) : ViewModel() {

    val items = listOf("EUR", "USD", "RUB")
    val itemBinding = ItemBinding.of<String>(BR.item, R.layout.item_currency)

}