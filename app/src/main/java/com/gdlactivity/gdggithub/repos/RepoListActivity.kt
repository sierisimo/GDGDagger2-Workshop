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
import com.gdlactivity.gdggithub.di.DependencyProvider
import kotlinx.android.synthetic.main.activity_repo_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoListActivity : AppCompatActivity() {
    //val githubService: GithubService = DependencyProvider.githubService
    val githubService: GithubService = DependencyProvider.hypoteticGithubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)

        tvRepoMessage.text = getString(R.string.label_public_repos)
        rvRepo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val user: GithubUser = intent.extras?.getParcelable("USER") as GithubUser

        fetchRepos(user)
    }

    fun fetchRepos(user: GithubUser) {
        githubService.getUserRepos(user.login)
            .enqueue(object : Callback<List<GithubRepository>> {
                override fun onFailure(call: Call<List<GithubRepository>>?, t: Throwable?) {
                    Log.e("RepoList:OnFailure", "Error calling for user", t)
                    tvRepoMessage.text = getString(R.string.error_no_repos)
                }

                override fun onResponse(call: Call<List<GithubRepository>>?, response: Response<List<GithubRepository>>) {
                    Log.i("RepoList:OnResponse", "Body: ${response.body()}")

                    if (response.isSuccessful) {
                        val repositoryList = response.body()
                        Log.i("RepoList:OnResponse", "List fetched: $repositoryList")

                        repositoryList?.let {
                            rvRepo.adapter = RepoAdapter(it)
                        }
                    } else {
                        Log.i("RepoList:OnResponse", "No success")
                        tvRepoMessage.text = getString(R.string.error_no_repos)
                    }
                }
            })
    }
}
