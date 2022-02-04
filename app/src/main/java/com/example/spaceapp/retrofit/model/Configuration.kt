package com.example.spaceapp.retrofit.model

import java.net.ProtocolFamily
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Configuration (
    var id: Int,
    var url: String,
    var name: String,
    var family: String,
    var full_name: String,
    var variant: String,
        )
