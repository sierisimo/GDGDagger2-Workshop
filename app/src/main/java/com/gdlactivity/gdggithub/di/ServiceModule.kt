package com.gdlactivity.gdggithub.di

import com.gdlactivity.gdggithub.api.GithubService
import retrofit2.Retrofit

class ServiceModule {

    //This method always return a new object!
    fun getRestClient(parserModule: ParserModule): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(
                //How could I know that I needed a call from the same object to build dependency?
                //Also this is wrong… the object should know by itself that it has a restClient…
                parserModule.provideMoshiParserFactory(
                    parserModule.provideMoshiParser()
                )
            )
            .build()
    }

    //Always a new Object!!
    fun getGithubService(restClient: Retrofit): GithubService {
        return restClient.create(GithubService::class.java)
    }
}