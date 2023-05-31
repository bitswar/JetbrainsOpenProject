package io.bitswar.openproject.application

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import io.bitswar.openproject.domain.services.AuthService
import io.bitswar.openproject.notify
import io.bitswar.openproject.notifyError

class AuthAction: AnAction() {
    private val authService: AuthService = service()
    override fun actionPerformed(e: AnActionEvent) {
        authService.getProfile()
            .onSuccess {
                notify("Profile fetched", it.toString())
            }
            .onError {
                notifyError("Profile fetching error", it.toString())
            }
    }
}