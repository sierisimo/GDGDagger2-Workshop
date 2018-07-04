package com.gdlactivity.gdggithub.api

import com.gdlactivity.gdggithub.data.github.repository.GithubRepository
import com.gdlactivity.gdggithub.data.github.user.GithubUser
import retrofit2.Call

class HypoteticGithubService: GithubService{
    override fun getZen(): Call<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserInfo(userName: String): Call<GithubUser> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserRepos(userName: String): Call<List<GithubRepository>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}