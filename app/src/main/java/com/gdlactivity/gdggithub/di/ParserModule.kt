package com.gdlactivity.gdggithub.di

import com.squareup.moshi.Moshi
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

class ParserModule {
    fun provideMoshiParserFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    //Always a new moshi!!!
    fun provideMoshiParser(): Moshi {
        return Moshi.Builder().build()
    }
}