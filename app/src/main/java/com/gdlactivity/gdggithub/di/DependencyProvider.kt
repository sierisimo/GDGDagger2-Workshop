package com.gdlactivity.gdggithub.di

import com.gdlactivity.gdggithub.api.GithubService
import javax.inject.Inject

class DependencyProvider @Inject constructor(var githubService: GithubService?){
    constructor(): this(null)
}