package com.johnturkson.factorio.agent

suspend fun main() {
    val csrfTokenRequester = FactorioCsrfTokenRequester()
    val csrfToken = csrfTokenRequester.getCsrfToken()
    println(csrfToken)
}
