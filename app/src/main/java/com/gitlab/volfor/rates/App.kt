package com.gitlab.volfor.rates

import android.app.Application
import com.gitlab.volfor.rates.di.AppComponent
import com.gitlab.volfor.rates.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}