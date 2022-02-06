package com.example.spaceapp.retrofit.model
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Rocket (
    var id: Int,
    var configuration: Configuration?=null
        )