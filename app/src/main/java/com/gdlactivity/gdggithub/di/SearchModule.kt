package com.gdlactivity.gdggithub.di

import com.gdlactivity.gdggithub.api.GithubService
import com.gdlactivity.gdggithub.search.UserSearchPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SearchModule {
    @Provides
    @Singleton
    fun getSearchPresenter(githubService: GithubService): UserSearchPresenter {
        return UserSearchPresenter(githubService)
    }
}