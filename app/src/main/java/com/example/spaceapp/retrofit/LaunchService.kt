package com.example.spaceapp.retrofit

import com.example.spaceapp.retrofit.model.LaunchHeader
import com.example.spaceapp.retrofit.model.LaunchResult
import retrofit2.Call
import retrofit2.http.GET

interface LaunchService {
    @GET("/2.2.0/launch/upcoming/")
    fun listUpcomingLaunches(): Call<LaunchHeader>
}