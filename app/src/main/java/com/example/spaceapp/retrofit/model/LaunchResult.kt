package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchResult (
    var id : String,
    var url: String,
    var slug: String,
    var name: String,
    var status: List<LaunchStatus>? = null,
    var last_updated: String,
    var net: String,
    var window_end: String,
    var window_start: String,
    var probability: String,
    var holdreason: String,
    var failreason: String,
    var hashtag: String? = null,
    var launch_service_provider: LaunchServiceProvider,
    var rocket: Rocket,
    var mission : String,
    var pad : LaunchResultPad,
    var webcast_live : String,
    var image : String,
    var infographic : String,
    var program : List<Any>? = null
        )