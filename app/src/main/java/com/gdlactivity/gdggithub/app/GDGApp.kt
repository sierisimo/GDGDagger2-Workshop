package com.gdlactivity.gdggithub.app

import android.app.Application
import com.gdlactivity.gdggithub.api.GithubService
import com.gdlactivity.gdggithub.di.ParserModule
import com.gdlactivity.gdggithub.di.ServiceModule

class GDGApp : Application() {
    val parserModule = ParserModule()

    val serviceModule = ServiceModule()

    val githubService: GithubService =
        serviceModule.getGithubService(
            //How could I know that I needed a call to a getter from the same service to build it?
            //Also this is wrong… the object should know by itself that it has a restClient…
            serviceModule.getRestClient(parserModule)
        )

    override fun onCreate() {
        super.onCreate()
    }
}