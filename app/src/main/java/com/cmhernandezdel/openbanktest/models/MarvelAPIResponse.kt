package com.cmhernandezdel.openbanktest.models

data class MarvelAPIResponse(
    var code: Int,
    var status: String,
    var copyright: String,
    var attributionText: String,
    var attributionHTML: String,
    var etag: String,
    var data: MarvelAPIData
)