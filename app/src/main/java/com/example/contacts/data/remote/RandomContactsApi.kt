package com.example.contacts.data.remote

import com.example.contacts.data.remote.dto.RandomContactsResponse
import retrofit2.http.GET
import retrofit2.http.Query


const val DEFAULT_PAGE_SIZE = 20

interface RandomContactsApi {

    @GET("api/")
    suspend fun getRandomUsers(
        @Query("results") results: Int = DEFAULT_PAGE_SIZE
    ): RandomContactsResponse
}