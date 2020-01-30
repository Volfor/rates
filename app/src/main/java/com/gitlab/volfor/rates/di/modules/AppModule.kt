package com.gitlab.volfor.rates.di.modules

import com.gitlab.volfor.rates.utils.CoroutineContextProviders
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideCoroutineContextProviders() = CoroutineContextProviders()

}