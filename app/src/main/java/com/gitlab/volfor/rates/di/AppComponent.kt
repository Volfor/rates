package com.gitlab.volfor.rates.di

import com.gitlab.volfor.rates.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

}