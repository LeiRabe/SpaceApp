package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchResultPadLocation (
    var id : Int,
    var url : String,
    var name : String,
    var country_code: String,
    var map_image : String,
    var total_launch_count : Int,
    var total_landing_count : Int
)