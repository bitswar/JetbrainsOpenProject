package io.bitswar.openproject.features.workpackages

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.core.Endpoints
import io.bitswar.openproject.core.RequestBuilder
import org.jetbrains.concurrency.Promise
import org.jetbrains.concurrency.rejectedPromise
import org.jetbrains.concurrency.resolvedPromise
import org.jetbrains.concurrency.runAsync
import java.net.http.HttpClient
import java.net.http.HttpConnectTimeoutException
import java.net.http.HttpResponse
import java.time.Duration

@Service(Service.Level.APP)
class WorkPackagesDatasource {
    private val requestBuilder: RequestBuilder = service()
    private val endpoints: Endpoints = service()
    private val client: HttpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()
    fun getWorkpackagesList(): Promise<String> {
        return runAsync {
            val response = client.send(
                requestBuilder.getRequest(endpoints.getWorkpackagesList()),
                HttpResponse.BodyHandlers.ofString()
            )
            if (response.statusCode() == 200) {
                response.body()
            } else {
                throw Error("")
            }
        }
    }
}