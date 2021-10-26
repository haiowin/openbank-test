package com.cmhernandezdel.openbanktest.providers

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiProvider @Inject constructor() {
    private val publicKey = "74e8c439741d365a54776dfdf65fb485"

    suspend fun getCharacters() {
        val (request, response, result) = Fuel.get("https://gateway.marvel.com:443/v1/public/characters?apikey=$publicKey")
            .awaitStringResponseResult()

        result.fold(
            { data -> println(data) },
            { error -> println(error) }
        )
    }
}