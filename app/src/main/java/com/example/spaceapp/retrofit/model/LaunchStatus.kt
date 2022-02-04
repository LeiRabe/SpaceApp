package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchStatus (
    var id: Int,
    var name: String,
    var abbrev: String,
    var description : String
        )