package com.gdlactivity.gdggithub.di

import com.gdlactivity.gdggithub.api.GithubService
import retrofit2.Retrofit
import javax.inject.Singleton


class ServiceModule {

    @Singleton
    fun getRestClient(parserModule: ParserModule): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(
                //How could I know that I needed a call from the same object to build dependency?
                //Also this is wrong… the object should know by itself that it has a restClient…
                parserModule.provideMoshiParserFactory(
                    parserModule.provideMoshiParser()
                )
            )
            .build()

    @Singleton
    fun getGithubService(restClient: Retrofit): GithubService =
        restClient.create(GithubService::class.java)

}