package com.gdlactivity.gdggithub.splash

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.gdlactivity.gdggithub.R
import com.gdlactivity.gdggithub.search.UserSearchActivity
import com.gdlactivity.gdggithub.util.launchActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        nextActivity()
    }

    private fun nextActivity() {
        Handler().postDelayed({
            launchActivity<UserSearchActivity> {}

            finish()
        }, 1500)
    }
}
