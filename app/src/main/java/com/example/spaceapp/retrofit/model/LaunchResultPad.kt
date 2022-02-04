package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchResultPad (
    var id : Int,
    var url : String,
    var agency_id : Int,
    var name : String,
    var info_url : String,
    var wiki_url : String,
    var map_url : String,
    var latitude : String,
    var longitude : String,
    var location : LaunchResultPadLocation,
    var map_image : String,
    var total_launch_count : Int
)
