package com.gitlab.volfor.rates.screens.rates

import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.gitlab.volfor.rates.App
import com.gitlab.volfor.rates.R
import com.gitlab.volfor.rates.databinding.ActivityRatesBinding
import kotlinx.android.synthetic.main.activity_rates.*
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

        (rvRates.itemAnimator as DefaultItemAnimator).supportsChangeAnimations = false

        vm.scrollEvent.observe(this, Observer {
            Handler().postDelayed({
                rvRates.scrollToPosition(0)
            }, 200)
        })
    }
}
