package com.example.spaceapp.repository

import com.example.spaceapp.apiFetch.ApiClient
import com.example.spaceapp.apiFetch.DTO.UpcomingEvents
import retrofit2.Response

class Repository {
 //for now this will handle the retrieval of the data in dataStruct but we'll figure out how to
    //retrieve all type of data
    suspend fun getEvents(): Response<UpcomingEvents> {
        return ApiClient.apiService.getUpcomingEvent()
    }
}