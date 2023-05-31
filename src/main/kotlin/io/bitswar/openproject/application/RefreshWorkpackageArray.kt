package io.bitswar.openproject.application

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import io.bitswar.openproject.domain.services.WorkPackageService
import io.bitswar.openproject.notify
import io.bitswar.openproject.notifyError
import org.jetbrains.concurrency.runAsync

class RefreshWorkpackageArray: AnAction() {
    private val wpService: WorkPackageService = service()
    override fun actionPerformed(e: AnActionEvent) {
        runAsync {
            wpService.getAllWorkpackages()
        }
            .onSuccess {
                notify("Test message", it.toString())
            }
            .onError {
                notifyError("Test message", it.toString())
            }
    }
}