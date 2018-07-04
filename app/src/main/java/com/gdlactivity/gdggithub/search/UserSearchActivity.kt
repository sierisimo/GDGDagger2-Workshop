package com.gdlactivity.gdggithub.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.gdlactivity.gdggithub.R
import com.gdlactivity.gdggithub.api.GithubService
import com.gdlactivity.gdggithub.app.GDGApp
import com.gdlactivity.gdggithub.data.github.user.GithubUser
import com.gdlactivity.gdggithub.repos.RepoListActivity
import com.gdlactivity.gdggithub.util.launchActivity
import com.gdlactivity.gdggithub.util.stringText
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserSearchActivity : AppCompatActivity() {
    lateinit var githubService: GithubService// = DependencyProvider.githubService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        githubService = (application as GDGApp).dependencyProvider.githubService!!

        initViews()
    }

    fun initViews() {
        btnHomeSearch.setOnClickListener {
            githubService.getUserInfo(etHomeUser.stringText)
                .enqueue(object : Callback<GithubUser> {
                    override fun onFailure(call: Call<GithubUser>?, t: Throwable?) {
                        Log.e("UserSearch:OnFailure", "Error calling for user", t)
                        hideViews()
                    }

                    override fun onResponse(call: Call<GithubUser>?, response: Response<GithubUser>) {
                        Log.i("UserSearch:OnResponse", "Body: ${response.body()}")

                        if (response.isSuccessful) {
                            val githubUser = response.body()

                            githubUser?.let {
                                tvHomeNotFound.visibility = View.GONE

                                tvHomeUsername.visibility = View.VISIBLE
                                tvHomeUsername.text = it.login

                                tvHomeName.visibility = View.VISIBLE
                                tvHomeName.text = it.name

                                tvHomePublicRepo_label.visibility = View.VISIBLE

                                tvHomePublicRepo.visibility = View.VISIBLE
                                tvHomePublicRepo.text = "${it.public_repos}"

                                btnHomePublicRepo.visibility = View.VISIBLE
                                btnHomePublicRepo.setOnClickListener {
                                    Log.i("OnResponse", "Click public repos")
                                    launchActivity<RepoListActivity> {
                                        putExtra("USER", githubUser)
                                    }
                                }
                            }
                        } else {
                            hideViews()
                        }
                    }
                })
        }
    }

    fun hideViews() {
        tvHomeName.visibility = View.GONE
        tvHomeUsername.visibility = View.GONE
        tvHomePublicRepo_label.visibility = View.GONE
        tvHomePublicRepo.visibility = View.GONE
        btnHomePublicRepo.visibility = View.GONE

        tvHomeNotFound.visibility = View.VISIBLE
        tvHomeNotFound.text = getString(R.string.formatted_notfound, etHomeUser.stringText)
    }
}
