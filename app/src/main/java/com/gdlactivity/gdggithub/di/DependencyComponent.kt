package com.gdlactivity.gdggithub.di

import dagger.Component
import javax.inject.Singleton


@Component(modules = [ParserModule::class, ServiceModule::class])
@Singleton
interface DependencyComponent {
    fun inject(dependencyProvider: DependencyProvider)
}