package com.gdlactivity.gdggithub.di

import com.gdlactivity.gdggithub.api.GithubService
import com.gdlactivity.gdggithub.repos.RepoListActivity
import com.gdlactivity.gdggithub.search.UserSearchActivity
import com.squareup.moshi.Moshi
import dagger.Component
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [ParserModule::class, ServiceModule::class, SearchModule::class])
interface DependencyComponent {
    fun moshi(): Moshi
    fun factory(): Converter.Factory
    fun retrofit(): Retrofit
    fun gitHubService(): GithubService

    fun inject(repoListActivity: RepoListActivity)
    fun inject(userSearchActivity: UserSearchActivity)
}