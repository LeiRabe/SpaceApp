package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchResultPadLocation (
    var id : Int,
    var url : String?=null,
    var name : String?=null,
    var country_code: String?=null,
    var map_image : String?=null,
    var total_launch_count : Int?=null,
    var total_landing_count : Int?=null
)