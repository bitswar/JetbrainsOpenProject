package io.bitswar.openproject.core

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.features.auth.AuthenticationCredentials
import org.apache.xerces.impl.dv.util.Base64
import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublisher
import java.net.http.HttpRequest.BodyPublishers

@Service(Service.Level.APP)
class RequestBuilder {
    private val credentials: AuthenticationCredentials = service()
    private fun authorizeRequest(): String {
        return credentials.getScheme() + "apikey:" + credentials.getAccessToken() + "@" + credentials.getBaseUrl()
    }

    private fun getBasicAuthHeader(): Pair<String, String>{
        return "Authorization" to ("Basic " + Base64.encode(("apikey:${credentials.getAccessToken()}").toByteArray()))
    }
    fun getRequest(path: String): HttpRequest {
        val uri = URI.create(authorizeRequest() + path)
        val (authHeaderName, authHeaderVal) = getBasicAuthHeader()
        return HttpRequest
                .newBuilder()
                .GET()
                .header(authHeaderName, authHeaderVal)
                .uri(uri)
                .build()
    }

    fun postRequest(path: String, body: BodyPublisher?): HttpRequest {
        val uri = URI.create(authorizeRequest() + path)
        val (authHeaderName, authHeaderVal) = getBasicAuthHeader()
        val sendBody = body ?: BodyPublishers.noBody()
        return HttpRequest
                .newBuilder()
                .POST(sendBody)
                .uri(uri)
                .header(authHeaderName, authHeaderVal)
                .build()
    }

}