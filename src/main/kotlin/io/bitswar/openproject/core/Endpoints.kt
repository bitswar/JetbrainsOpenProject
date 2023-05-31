package io.bitswar.openproject.core

import com.intellij.openapi.components.service
import io.bitswar.openproject.core.endpoints.BaseEndpoints
import org.apache.xerces.impl.dv.util.Base64

abstract class Endpoints(
    private val baseEndpoints: BaseEndpoints = service()
) {
    private val baseUrl: String = baseEndpoints.baseUrl
    private val apiVersion: String = baseEndpoints.apiVersion
    private val scheme: String = baseEndpoints.scheme
    fun buildEndpoint(endpoint: String): String {
        return compose(arrayOf(scheme, baseUrl, apiVersion, endpoint))
    }

    fun authorizeUrl(url: String, username: String, password: String): String {
        return url.replaceFirst("://", "://$username:$password@")
    }
    fun basicAuthHeader(username: String, password: String): Pair<String, String> {
        return "Authorization" to ("Basic " + Base64.encode(("$username:$password").toByteArray()))
    }
    private fun sanitizeEndpoint(endpoints: String): String {
        return endpoints.trim { char -> char == '/' }
    }

    private fun compose(array: Array<String>): String {
        return array.map { e -> sanitizeEndpoint(e) }
            .joinToString(separator = "/") { e -> e.replace(Regex("(?<!:)//"), "/") }
    }
}