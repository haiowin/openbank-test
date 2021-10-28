package com.cmhernandezdel.openbanktest.models

data class MarvelAPIData(
    var offset: Int,
    var limit: Int,
    var total: Int,
    var count: Int,
    var results: List<MarvelAPIResult>
)