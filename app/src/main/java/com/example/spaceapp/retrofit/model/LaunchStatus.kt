package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchStatus (
    var id: Int,
    var name: String?=null,
    var abbrev: String?=null,
    var description : String?=null
        )