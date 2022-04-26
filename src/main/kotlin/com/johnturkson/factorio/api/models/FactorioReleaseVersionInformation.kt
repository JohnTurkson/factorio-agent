package com.johnturkson.factorio.api.models

import kotlinx.serialization.Serializable

@Serializable
data class FactorioReleaseVersionInformation(
    val alpha: String,
    val demo: String,
    val headless: String,
)
