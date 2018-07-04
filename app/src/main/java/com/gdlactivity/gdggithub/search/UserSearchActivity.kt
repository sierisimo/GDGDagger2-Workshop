package com.gdlactivity.gdggithub.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.gdlactivity.gdggithub.R
import com.gdlactivity.gdggithub.app.GDGApp
import com.gdlactivity.gdggithub.repos.RepoListActivity
import com.gdlactivity.gdggithub.util.launchActivity
import com.gdlactivity.gdggithub.util.stringText
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UserSearchActivity : AppCompatActivity() {
    @Inject
    lateinit var userSearchPresenter: UserSearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as GDGApp).dependencyComponent.inject(this)

        initViews()
    }

    fun initViews() {
        btnHomeSearch.setOnClickListener {
            userSearchPresenter.searchUser(etHomeUser.stringText, ::hideViews) {
                val ghUser = it
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
                        putExtra("USER", ghUser)
                    }
                }
            }
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
