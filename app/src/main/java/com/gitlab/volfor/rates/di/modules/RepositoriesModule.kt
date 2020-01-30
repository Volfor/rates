package com.gitlab.volfor.rates.di.modules

import com.gitlab.volfor.rates.data.api.RatesService
import com.gitlab.volfor.rates.data.repositories.RatesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideRatesRepository(service: RatesService) = RatesRepository(service)

}