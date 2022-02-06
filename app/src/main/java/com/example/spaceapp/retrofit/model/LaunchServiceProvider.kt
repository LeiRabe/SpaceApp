package com.example.spaceapp.retrofit.model
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchServiceProvider (
    var id: Int,
    var url: String?=null,
    var name: String?=null,
    var type: String?=null,
)
