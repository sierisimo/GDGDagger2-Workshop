package com.gdlactivity.gdggithub.app

import android.app.Application
import com.gdlactivity.gdggithub.api.GithubService
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GDGApp : Application() {
    val jsonParser: Moshi = Moshi.Builder().build()

    val restClient: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(MoshiConverterFactory.create(jsonParser))
        .build()

    val githubService: GithubService = restClient.create(GithubService::class.java)

    override fun onCreate() {
        super.onCreate()
    }
}