package com.gdlactivity.gdggithub.di

import com.gdlactivity.gdggithub.api.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun getRestClient(converterFactory: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    @Singleton
    fun getGithubService(restClient: Retrofit): GithubService =
        restClient.create(GithubService::class.java)
}