package com.gitlab.volfor.rates.screens.rates

import androidx.lifecycle.*
import androidx.recyclerview.widget.DiffUtil
import com.gitlab.volfor.rates.BR
import com.gitlab.volfor.rates.R
import com.gitlab.volfor.rates.base.BaseViewModel
import com.gitlab.volfor.rates.base.ViewEvent
import com.gitlab.volfor.rates.repositories.RatesRepository
import com.gitlab.volfor.rates.screens.rates.item.RateItem
import me.tatarka.bindingcollectionadapter2.ItemBinding
import java.util.*
import javax.inject.Inject

class RatesViewModel @Inject constructor(
    private val ratesRepository: RatesRepository
) : BaseViewModel(), RateItem.Listener {

    private val baseCurrency = MutableLiveData<String>("EUR")
    private val amount = MutableLiveData<String>("100")

    private val rates = baseCurrency.distinctUntilChanged().switchMap {
        ratesRepository.fetchRates(it).asLiveData()
    }

    val items = MediatorLiveData<List<RateItem>>().apply {
        addSource(rates) { rates ->
            value = getRatesItems(value, rates)
        }
    }

    val itemBinding = ItemBinding.of<RateItem>(BR.item, R.layout.item_rate)
        .bindExtra(BR.listener, this)

    val diff: DiffUtil.ItemCallback<RateItem> = object : DiffUtil.ItemCallback<RateItem>() {
        override fun areItemsTheSame(old: RateItem, new: RateItem): Boolean {
            return old.currency == new.currency
        }

        override fun areContentsTheSame(old: RateItem, new: RateItem): Boolean {
            return old == new
        }
    }

    override fun onRateClick(item: RateItem) {
        baseCurrency.value = item.currency.currencyCode
        amount.value = item.totalAmount.value

        val newList = mutableListOf(RateItem(item.currency, 1.0, amount, true))

        items.value?.forEach {
            if (it.currency != item.currency) {
                val newItem = it.copy(isBase = false)
                newList.add(newItem)
            }
        }

        items.value = newList

        sendEvent(ViewEvent.RequestFocus(R.id.fAmount))
    }

    private fun getRatesItems(
        oldList: List<RateItem>?,
        rates: Map<String, Double>
    ): List<RateItem> {
        val newList = mutableListOf<RateItem>()

        if (oldList == null) {
            newList.apply {
                add(RateItem(Currency.getInstance(baseCurrency.value!!), 1.0, amount, true))
                addAll(rates.map { RateItem(Currency.getInstance(it.key), it.value, amount) })
            }
        } else {
            oldList.forEach {
                rates[it.currency.currencyCode]?.let { newRate ->
                    newList.add(it.copy(rate = newRate))
                } ?: run {
                    newList.add(it.copy())
                }
            }
        }

        return newList
    }
}