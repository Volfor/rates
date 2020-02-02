package com.gitlab.volfor.rates.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gitlab.volfor.rates.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {

    private val _event = SingleLiveEvent<ViewEvent>()
    val event: LiveData<ViewEvent>
        get() = _event

    fun sendEvent(event: ViewEvent) {
        _event.value = event
    }

}