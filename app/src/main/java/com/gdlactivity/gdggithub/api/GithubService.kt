package com.gdlactivity.gdggithub.api

import com.gdlactivity.gdggithub.data.github.repository.GithubRepository
import com.gdlactivity.gdggithub.data.github.user.GithubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/zen")
    fun getZen(): Call<String>

    @GET("/users/{user}")
    fun getUserInfo(@Path(value = "user") userName: String): Call<GithubUser>

    @GET("/users/{user}/repos")
    fun getUserRepos(@Path(value = "user") userName: String): Call<List<GithubRepository>>
}