package com.johnturkson.factorio.agent

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object SharedResources {
    val serializer = Json {
        ignoreUnknownKeys = true
    }
    val client = HttpClient(CIO) {
        followRedirects = false
        install(ContentNegotiation) {
            json(serializer)
        }
    }
}
