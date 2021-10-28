package com.cmhernandezdel.openbanktest.models

data class MarvelAPICollection(
    var available: Int,
    var collectionURI: String,
    var items: List<MarvelAPICollectionItem>,
    var returned: Int
)