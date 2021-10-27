package com.cmhernandezdel.openbanktest.providers

import android.util.Log
import com.cmhernandezdel.openbanktest.models.MarvelAPIResponse
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.HttpException
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.coroutines.*
import com.github.kittinunf.fuel.gson.gsonDeserializer
import com.github.kittinunf.fuel.gson.responseObject
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiProvider @Inject constructor() {
    private val publicKey = "74e8c439741d365a54776dfdf65fb485"
    private val privateKey = "0a59868db844e5e923d31ba3dbab8161ceed1402"
    private val classTag = "ApiProvider.kt"

    suspend fun getCharacters(): MarvelAPIResponse {
        val timeStamp = System.currentTimeMillis()
        val hash = md5("$timeStamp$privateKey$publicKey")

        try {
            val apiResponse = Fuel.get("https://gateway.marvel.com:443/v1/public/characters?apikey=$publicKey&ts=$timeStamp&hash=$hash")
                .awaitObject<MarvelAPIResponse>(gsonDeserializer())
            return apiResponse
        } catch (exception: Exception) {
            when (exception) {
                is HttpException -> Log.w(classTag, "Error while executing HTTP request: ${exception.message}")
                else -> Log.w(classTag, "Error while deserializing: ${exception.message}")
            }
        }
    }

    // See: https://stackoverflow.com/a/64171625/8966471
    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}