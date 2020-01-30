package com.gitlab.volfor.rates.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gitlab.volfor.rates.BR
import com.gitlab.volfor.rates.R
import com.gitlab.volfor.rates.data.repositories.RatesRepository
import com.gitlab.volfor.rates.data.Result.*
import me.tatarka.bindingcollectionadapter2.ItemBinding
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val ratesRepository: RatesRepository
) : ViewModel() {

    val items = liveData {
        when (val rates = ratesRepository.fetchRates("EUR")) {
            is Success -> emit(rates.data.keys.toList())
            is Error -> Timber.d("Error :(")
        }
    }

    val itemBinding = ItemBinding.of<String>(BR.item, R.layout.item_currency)

}