package com.gitlab.volfor.rates.screens.rates

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gitlab.volfor.rates.App
import com.gitlab.volfor.rates.R
import com.gitlab.volfor.rates.databinding.ActivityRatesBinding
import javax.inject.Inject

class RatesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val vm by viewModels<RatesViewModel> { viewModelFactory }
    private lateinit var binding: ActivityRatesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_rates)

        binding.vm = vm
        binding.lifecycleOwner = this
    }
}
