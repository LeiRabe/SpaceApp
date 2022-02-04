package com.example.spaceapp.retrofit

import com.example.spaceapp.retrofit.model.LaunchResult
import retrofit2.Call
import retrofit2.http.GET

interface LaunchService {
    @GET("/upcoming")
    fun listUpcomingLaunches(): Call<List<LaunchResult>>
}