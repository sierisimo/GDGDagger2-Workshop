package com.gdlactivity.gdggithub.repos

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.gdlactivity.gdggithub.R
import com.gdlactivity.gdggithub.api.GithubService
import com.gdlactivity.gdggithub.app.GDGApp
import com.gdlactivity.gdggithub.data.github.repository.GithubRepository
import com.gdlactivity.gdggithub.data.github.user.GithubUser
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_repo_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RepoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)

        tvRepoMessage.text = getString(R.string.label_public_repos)
        rvRepo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val user: GithubUser = intent.extras?.getParcelable("USER") as GithubUser

        fetchRepos(user)
    }

    fun fetchRepos(user: GithubUser) {
        val moshi = Moshi.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val githubService = retrofit.create(GithubService::class.java)

        githubService.getUserRepos(user.login)
            .enqueue(object : Callback<List<GithubRepository>> {
                override fun onFailure(call: Call<List<GithubRepository>>?, t: Throwable?) {
                    Log.e("RepoList:OnFailure", "Error calling for user", t)

                }

                override fun onResponse(call: Call<List<GithubRepository>>?, response: Response<List<GithubRepository>>) {
                    Log.i("RepoList:OnResponse", "Body: ${response.body()}")

                    if (response.isSuccessful) {
                        val repositoryList = response.body()
                        Log.i("RepoList:OnResponse", "List fetched: $repositoryList")

                        repositoryList?.let {
                            rvRepo.adapter = RepoAdapter().apply {
                                this.repositoryList = it
                            }
                        }
                    } else {
                        Log.i("RepoList:OnResponse", "No success")

                    }
                }
            })
    }
}
