package io.bitswar.openproject.features.auth.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.core.RequestBuilder
import io.bitswar.openproject.notify
import java.net.http.HttpClient
import java.net.http.HttpResponse.BodyHandlers

@Service
class AuthenticationAction: AnAction() {
    private val reqBuilder: RequestBuilder = service()
    override fun actionPerformed(e: AnActionEvent) {
        val request = reqBuilder.getRequest("/api/v3/users/me")

        val client = HttpClient.newBuilder().build()
        val response = client.send(request, BodyHandlers.ofString())

        notify("Test message", response.body())
    }
}