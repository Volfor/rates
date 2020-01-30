package com.gitlab.volfor.rates.di

import android.content.Context
import com.gitlab.volfor.rates.di.modules.AppModule
import com.gitlab.volfor.rates.di.modules.NetworkModule
import com.gitlab.volfor.rates.di.modules.RepositoriesModule
import com.gitlab.volfor.rates.di.modules.ViewModelsModule
import com.gitlab.volfor.rates.screens.rates.RatesActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelsModule::class, NetworkModule::class, RepositoriesModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: RatesActivity)

}