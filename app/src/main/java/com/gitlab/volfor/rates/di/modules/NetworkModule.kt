package com.gitlab.volfor.rates.di.modules

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.gitlab.volfor.rates.BuildConfig
import com.gitlab.volfor.rates.api.RatesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(context: Context): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(context))
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideRatesService(retrofit: Retrofit): RatesService =
        retrofit.create(RatesService::class.java)
}