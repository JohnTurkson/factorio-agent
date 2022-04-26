package com.johnturkson.factorio.agent

import FactorioReleaseVersion
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json

class FactorioApi(
    private val client: HttpClient = SharedResources.client,
    private val serializer: Json = SharedResources.serializer,
) {
    suspend fun getCsrfToken(): String? {
        TODO()
    }
    
    suspend fun getLatestReleaseVersion(): FactorioReleaseVersion {
        TODO()
    }
}
