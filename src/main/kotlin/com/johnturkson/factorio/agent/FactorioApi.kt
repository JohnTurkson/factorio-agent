package com.johnturkson.factorio.agent

import FactorioReleaseVersion
import com.johnturkson.factorio.agent.Constants.FactorioDownloadEndpoint
import com.johnturkson.factorio.agent.Constants.FactorioLoginEndpoint
import com.johnturkson.factorio.api.requests.FactorioDownloadRequest
import com.johnturkson.factorio.api.responses.FactorioDownloadResponse
import com.johnturkson.factorio.api.responses.FactorioDownloadResponse.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.onDownload
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

class FactorioApi(
    private val client: HttpClient = SharedResources.client,
    private val serializer: Json = SharedResources.serializer,
) {
    suspend fun getFactorioCsrfToken(): String? {
        TODO()
    }
    
    suspend fun getLatestFactorioReleaseVersion(): FactorioReleaseVersion {
        TODO()
    }
    
    // TODO expose progress?
    suspend fun downloadFactorio(request: FactorioDownloadRequest): FactorioDownloadResponse {
        // TODO auth for non-headless downloads
        val (version, build, distro) = request
        val endpoint = "$FactorioDownloadEndpoint/$version/$build/$distro"
        val response = client.get(endpoint)
        val redirect = response.status.value in 300..399
        
        if (!redirect) return DownloadNotFound
        val redirectLocation = response.headers["Location"] ?: return DownloadNotFound
        if (redirectLocation.startsWith(FactorioLoginEndpoint)) return DownloadAuthenticationRequired
        
        // TODO
        val download = client.get(redirectLocation) {
            onDownload { bytesSentTotal, contentLength ->
                println("progress: $bytesSentTotal/$contentLength")
            }
        }
        return DownloadSuccess(download.body())
    }
}
