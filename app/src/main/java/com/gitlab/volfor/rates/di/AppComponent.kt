package com.gitlab.volfor.rates.di

import android.content.Context
import com.gitlab.volfor.rates.di.modules.NetworkModule
import com.gitlab.volfor.rates.di.modules.ViewModelsModule
import com.gitlab.volfor.rates.screens.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelsModule::class, NetworkModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)

}