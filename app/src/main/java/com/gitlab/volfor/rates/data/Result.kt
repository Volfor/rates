package com.gitlab.volfor.rates.data

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    object Error : Result<Nothing>()
}