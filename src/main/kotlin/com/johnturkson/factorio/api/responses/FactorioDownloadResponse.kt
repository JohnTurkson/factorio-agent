package com.johnturkson.factorio.api.responses

sealed class FactorioDownloadResponse {
    object DownloadNotFound : FactorioDownloadResponse()
    object DownloadAuthenticationRequired : FactorioDownloadResponse()
    class DownloadSuccess(val file: ByteArray) : FactorioDownloadResponse()
}
