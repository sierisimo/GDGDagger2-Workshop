package com.gdlactivity.gdggithub.splash

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import android.support.test.runner.lifecycle.Stage
import com.gdlactivity.gdggithub.search.UserSearchActivity
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@SmallTest
@RunWith(AndroidJUnit4::class)
class SplashActivityTest {
    @get:Rule
    val intentRule = IntentsTestRule(SplashActivity::class.java)

    @Before
    fun before(){
        sleep(4000)
    }

    @Test
    fun legacyTestActivityLaunchesNextOneAfterElapsedTime() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            val activities =
                ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED)

            assertNotNull(activities)
            assertNotNull(activities.first())

            assertThat(activities.first(), instanceOf(UserSearchActivity::class.java))
        }
    }

    @Test
    fun testSomeIntended() {
        intended(hasComponent(UserSearchActivity::class.java.name))
    }
}