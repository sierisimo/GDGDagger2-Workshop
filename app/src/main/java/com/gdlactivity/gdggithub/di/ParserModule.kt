package com.gdlactivity.gdggithub.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ParserModule {
    @Provides
    @Singleton
    fun provideMoshiParserFactory(moshi: Moshi): Converter.Factory =
        MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun provideMoshiParser(): Moshi =
        Moshi.Builder().build()
}