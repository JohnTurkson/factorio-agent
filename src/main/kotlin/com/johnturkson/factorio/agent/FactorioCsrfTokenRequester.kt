package com.johnturkson.factorio.agent

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class FactorioCsrfTokenRequester(
    private val client: HttpClient = HttpClient(CIO),
    private val endpoint: String = Constants.FactorioLoginEndpoint,
    private val csrfTokenRegex: Regex = Constants.FactorioCsrfTokenPattern.toRegex(),
) {
    suspend fun getCsrfToken(): String? {
        val content = getLoginWebpageContent()
        return extractCsrfToken(content)
    }
    
    private suspend fun getLoginWebpageContent(): String {
        val response = client.get(endpoint)
        return response.bodyAsText()
    }
    
    private fun extractCsrfToken(body: String): String? {
        val match = csrfTokenRegex.find(body)
        val (csrfToken) = match?.destructured ?: return null
        return csrfToken
    }
}
