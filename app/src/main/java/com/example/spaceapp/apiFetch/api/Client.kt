package com.example.spaceapp.apiFetch

import com.example.spaceapp.apiFetch.api.ApiService
import com.example.spaceapp.apiFetch.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @description Contains instances of Retrofit
 */
object ApiClient {

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService : ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}