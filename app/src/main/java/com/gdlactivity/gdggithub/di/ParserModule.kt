package com.gdlactivity.gdggithub.di

import com.squareup.moshi.Moshi
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

class ParserModule {
    @Singleton
    fun provideMoshiParserFactory(moshi: Moshi): Converter.Factory =
        MoshiConverterFactory.create(moshi)

    @Singleton
    fun provideMoshiParser(): Moshi =
        Moshi.Builder().build()
}