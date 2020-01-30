package com.gitlab.volfor.rates

import android.app.Application
import com.gitlab.volfor.rates.di.AppComponent
import com.gitlab.volfor.rates.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}