package com.example.spaceapp.retrofit.model
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchServiceProvider (
    var id: Int,
    var url: String,
    var name: String,
    var type: String,
)
