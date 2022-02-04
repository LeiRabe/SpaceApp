package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchResult (
    var id : String,
    var url: String,
    var slug: String,
    var name: String,
    var status: List<LaunchStatus>? = null,
        )