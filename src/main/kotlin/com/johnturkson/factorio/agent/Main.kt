package com.johnturkson.factorio.agent

import com.johnturkson.factorio.api.requests.FactorioDownloadRequest

suspend fun main() {
    val api = FactorioApi()
    val response = api.downloadFactorio(FactorioDownloadRequest("latest", "headless", "linux64"))
    println(response)
}
