package com.example.spaceapp.apiFetch.DTO

import com.google.gson.annotations.SerializedName


/**
 * @description Represent a structure of fetched upcoming events
 * @param id {Int} represents the unique id of the upcoming event
 * @param description {String} description of the upcoming event
 * @param location {String} upcoming event's location (city)
 * */
data class UpcomingEvents(
    val count : Int
    //should contain an event type
    /*
    val id : Int,
    val name: String,
    //status:description
    val description : String,
    //location:name
    @SerializedName("name")
    val location : String?,
    val videoUrl : String?,
    val date: Date,
    val image : String,
    val eventType : EventType
    */
)

