package com.johnturkson.factorio.agent

object Constants {
    const val FactorioLoginEndpoint = "https://www.factorio.com/login"
    const val FactorioDownloadEndpoint = "https://www.factorio.com/get-download"
    const val FactorioCsrfTokenPattern = """<input id="csrf_token" name="csrf_token" type="hidden" value="([^"]+)">"""
}
