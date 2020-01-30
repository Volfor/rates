package com.gitlab.volfor.rates.screens.rates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gitlab.volfor.rates.BR
import com.gitlab.volfor.rates.R
import com.gitlab.volfor.rates.repositories.RatesRepository
import com.gitlab.volfor.rates.screens.rates.item.BaseCurrencyItem
import com.gitlab.volfor.rates.screens.rates.item.CurrencyItem
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import me.tatarka.bindingcollectionadapter2.map
import javax.inject.Inject

class RatesViewModel @Inject constructor(
    private val ratesRepository: RatesRepository
) : ViewModel() {

    val amount = MutableLiveData<String>("1")

    val items = liveData {
        val baseCurrency = BaseCurrencyItem("EUR", amount)

        val list = mutableListOf<Any>(baseCurrency)
        ratesRepository.fetchRates("EUR")?.map {
            CurrencyItem(it.key, it.value, amount)
        }?.let { list.addAll(it) }

        emit(list)
    }

    val itemBinding = OnItemBindClass<Any>().apply {
        map<BaseCurrencyItem> { itemBinding, _, _ ->
            itemBinding.set(BR.item, R.layout.item_base_currency)
        }
        map<CurrencyItem> { itemBinding, _, _ ->
            itemBinding.set(BR.item, R.layout.item_currency)
        }
    }
}