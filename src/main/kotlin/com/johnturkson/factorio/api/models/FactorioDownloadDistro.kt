package com.johnturkson.factorio.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO remove
@Serializable
enum class FactorioDownloadDistro {
    @SerialName("win64")
    Win64,
    
    @SerialName("win64-manual")
    Win64Manual,
    
    @SerialName("win32")
    Win32,
    
    @SerialName("win32-manual")
    Win32Manual,
    
    @SerialName("osx")
    Osx,
    
    @SerialName("linux64")
    Linux64,
    
    @SerialName("linux32")
    Linux32,
}
