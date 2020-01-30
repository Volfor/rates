package com.gitlab.volfor.rates.screens

import androidx.lifecycle.ViewModel
import com.gitlab.volfor.rates.repositories.RatesRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val ratesRepository: RatesRepository
) : ViewModel() {


}