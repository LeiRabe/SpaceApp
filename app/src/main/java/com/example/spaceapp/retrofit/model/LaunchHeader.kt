package com.example.spaceapp.retrofit.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LaunchHeader(
    val count: Int,
    val new: String?=null,
    val previous: String? = null,
    val results: List<LaunchResult>? = null
)