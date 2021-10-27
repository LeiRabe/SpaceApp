package com.example.spaceapp.apiFetch

import com.example.spaceapp.DTO.UpcomingEvents
import retrofit2.http.GET

import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("description")
    suspend fun getUpcomingEvent(): Response<UpcomingEvents>

    @GET("posts/{num}")
    suspend fun getPostById(@Path("num") num : Int): Response<String>

    @GET("comments")
    suspend fun getCommentsByPost(@Query("postId") postId : Int): Response<String>

    @POST("posts")
    suspend fun createPost(@Body post: String): String
}
