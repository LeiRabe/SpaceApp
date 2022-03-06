package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchResultPad (
    var id : Int,
    var url : String?=null,
    var agency_id : Int?=null,
    var name : String?=null,
    var info_url : String?=null,
    var wiki_url : String?=null,
    var map_url : String?=null,
    var latitude : String?=null,
    var longitude : String?=null,
    var location : LaunchResultPadLocation?=null,
    var map_image : String?=null,
    var total_launch_count : Int?=null
)
