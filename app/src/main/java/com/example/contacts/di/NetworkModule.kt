package com.example.contacts.di

import com.example.contacts.data.remote.RandomContactsApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://randomuser.me/"

val networkModule = module {
    single {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(RandomContactsApi::class.java)
    }
}