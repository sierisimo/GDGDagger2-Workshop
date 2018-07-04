package com.gdlactivity.gdggithub.search

import com.gdlactivity.gdggithub.api.GithubService
import com.gdlactivity.gdggithub.data.github.user.GithubUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserSearchPresenter @Inject constructor(val githubService: GithubService) {
    fun searchUser(username: String, onFailure: () -> Unit, onSuccess: (GithubUser) -> Unit) {
        githubService.getUserInfo(username).enqueue(object : Callback<GithubUser> {
            override fun onFailure(call: Call<GithubUser>?, t: Throwable?) {
                onFailure()
            }

            override fun onResponse(call: Call<GithubUser>?, response: Response<GithubUser>?) {
                onSuccess(response?.body() as GithubUser)
            }
        })
    }
}