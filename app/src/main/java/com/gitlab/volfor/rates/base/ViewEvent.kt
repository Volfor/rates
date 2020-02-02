package com.gitlab.volfor.rates.base

import androidx.annotation.IdRes

sealed class ViewEvent {

    data class RequestFocus(@IdRes val viewId: Int) : ViewEvent()

}