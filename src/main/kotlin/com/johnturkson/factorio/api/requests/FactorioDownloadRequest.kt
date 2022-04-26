package com.johnturkson.factorio.api.requests

import kotlinx.serialization.Serializable

@Serializable
data class FactorioDownloadRequest(
    val version: String,
    val build: String,
    val distro: String,
)
