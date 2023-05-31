package io.bitswar.openproject.core

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.core.endpoints.AuthEndpoints
import io.bitswar.openproject.domain.repositories.IAuthRepository
import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublisher
import java.net.http.HttpRequest.BodyPublishers

@Service(Service.Level.APP)
class RequestBuilder {
    private val authRepository: IAuthRepository = service()
    private val endpoints: AuthEndpoints = service()

    fun getRequest(path: String): HttpRequest {
        val uri = URI.create(
            endpoints.authorizeUrl(
                path,
                authRepository.getUsername(),
                authRepository.getAccessToken()
            )
        )

        val (authHeaderName, authHeaderVal) = endpoints.basicAuthHeader(
            authRepository.getUsername(),
            authRepository.getAccessToken(),
        )

        return HttpRequest
                .newBuilder()
                .GET()
                .header(authHeaderName, authHeaderVal)
                .uri(uri)
                .build()
    }

    fun postRequest(path: String, body: BodyPublisher?): HttpRequest {
        val uri = URI.create(
            endpoints.authorizeUrl(
                path,
                authRepository.getUsername(),
                authRepository.getAccessToken()
            )
        )

        val (authHeaderName, authHeaderVal) = endpoints.basicAuthHeader(
            authRepository.getUsername(),
            authRepository.getAccessToken(),
        )
        val sendBody = body ?: BodyPublishers.noBody()
        return HttpRequest
                .newBuilder()
                .POST(sendBody)
                .uri(uri)
                .header(authHeaderName, authHeaderVal)
                .build()
    }

}