package com.gdlactivity.gdggithub.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gdlactivity.gdggithub.R
import com.gdlactivity.gdggithub.home.HomeActivity
import com.gdlactivity.gdggithub.util.launchActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        nextActivity("")
    }

    private fun nextActivity(title: String) {
        launchActivity<HomeActivity> {
            putExtra("title", title)
        }
        finish()
    }
}
