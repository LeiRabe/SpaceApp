package com.example.spaceapp.apiFetch.api

import com.example.spaceapp.apiFetch.DTO.UpcomingEvents
import retrofit2.http.GET

import retrofit2.Response

/**
 * @description Interface that contains all the endpoints for data querying
 */
interface ApiService {
    @GET("launch/upcoming")
    suspend fun getUpcomingEvent(): Response<UpcomingEvents>

}
