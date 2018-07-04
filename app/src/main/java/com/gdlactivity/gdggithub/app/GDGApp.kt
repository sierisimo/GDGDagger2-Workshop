package com.gdlactivity.gdggithub.app

import android.app.Application
import com.gdlactivity.gdggithub.api.GithubService
import com.gdlactivity.gdggithub.di.ParserModule
import retrofit2.Retrofit

class GDGApp : Application() {
    val parserModule = ParserModule()

    val restClient: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(
            parserModule.provideMoshiParserFactory(
                parserModule.provideMoshiParser()
            )
        )
        .build()

    val githubService: GithubService = restClient.create(GithubService::class.java)

    override fun onCreate() {
        super.onCreate()
    }
}