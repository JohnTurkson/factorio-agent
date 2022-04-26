package com.johnturkson.factorio.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO remove
@Serializable
enum class FactorioDownloadBuild {
    @SerialName("alpha")
    Alpha,
    
    @SerialName("demo")
    Demo,
    
    @SerialName("headless")
    Headless
}
