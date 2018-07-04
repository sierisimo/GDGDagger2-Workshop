package com.gdlactivity.gdggithub.app

import android.app.Application
import com.gdlactivity.gdggithub.di.DaggerDependencyComponent
import com.gdlactivity.gdggithub.di.DependencyComponent

class GDGApp : Application() {
    lateinit var dependencyComponent: DependencyComponent

    override fun onCreate() {
        super.onCreate()

        dependencyComponent = DaggerDependencyComponent
            .builder()
            .build()
    }
}