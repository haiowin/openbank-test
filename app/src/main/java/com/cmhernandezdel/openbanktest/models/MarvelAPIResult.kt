package com.cmhernandezdel.openbanktest.models

data class MarvelAPIResult(
    var id: Int,
    var name: String,
    var description: String,
    var modified: String,
    var thumbnail: MarvelAPIThumbnail,
    var resourceURI: String,
    var comics: MarvelAPICollection,
    var series: MarvelAPICollection,
    var stories: MarvelAPICollection,
    var events: MarvelAPICollection,
    var urls: List<MarvelAPIURL>
)