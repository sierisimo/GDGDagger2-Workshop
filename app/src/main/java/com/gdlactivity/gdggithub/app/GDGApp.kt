package com.gdlactivity.gdggithub.app

import android.app.Application
import com.gdlactivity.gdggithub.di.DaggerDependencyComponent
import com.gdlactivity.gdggithub.di.DependencyProvider

class GDGApp : Application() {
    lateinit var dependencyProvider: DependencyProvider

    override fun onCreate() {
        super.onCreate()

        dependencyProvider = DependencyProvider()
        DaggerDependencyComponent.builder()
            .build().inject(dependencyProvider)
    }
}