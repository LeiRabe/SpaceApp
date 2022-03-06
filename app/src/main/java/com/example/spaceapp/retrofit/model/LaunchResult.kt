package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchResult (
    var id: String,
    var url: String? = null,
    var slug: String? = null,
    var name: String? = null,
    var status: LaunchStatus? = null,
    var last_updated: String? = null,
    var net: String? = null,
    var window_end: String? = null,
    var window_start: String? = null,
    var probability: String? = null,
    var holdreason: String? = null,
    var failreason: String? = null,
    var hashtag: String? = null,
    var launch_service_provider: LaunchServiceProvider? = null,
    var rocket: Rocket? = null,
    var mission: Any? = null,
    var pad: LaunchResultPad? = null,
    var webcast_live: Boolean? = null,
    var image: String? = null,
    var infographic: String? = null,
    var program: List<Any>? = null
    )