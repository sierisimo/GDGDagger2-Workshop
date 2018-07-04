package com.gdlactivity.gdggithub.di

import com.gdlactivity.gdggithub.api.GithubService
import retrofit2.Retrofit

class ServiceModule {

    fun getRestClient(parserModule: ParserModule): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(
                parserModule.provideMoshiParserFactory(
                    parserModule.provideMoshiParser()
                )
            )
            .build()
    }

    fun getGithubService(restClient: Retrofit): GithubService {
        return restClient.create(GithubService::class.java)
    }
}