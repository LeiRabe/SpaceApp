package com.example.spaceapp.DTO

import java.util.*


/**
 * @description Represent a structure of fetched upcoming events
 * */
data class UpcomingEvents(
    //should contain an event type
    val id : Int,
    val description : String,
    val location : String?,
    val videoUrl : String?,
    val date: Date,
    val image : String,
    val eventType : EventType
)


/**
 * @description represent a data struct of an event type
 * @param id {Int} represents the unique id of the event type
 * @param name {String} represents the name of the event type
 */
data class EventType(
    val id : Int,
    val name : String
)

