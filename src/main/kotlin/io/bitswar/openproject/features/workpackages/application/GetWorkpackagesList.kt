package io.bitswar.openproject.features.workpackages.application

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import io.bitswar.openproject.features.workpackages.WorkPackagesDatasource
import io.bitswar.openproject.notify
import org.jetbrains.concurrency.runAsync

class GetWorkpackagesList(): AnAction() {
    private val datasource: WorkPackagesDatasource = service()
    override fun actionPerformed(e: AnActionEvent) {
        datasource.getWorkpackagesList()
            .onSuccess {
                notify("Test message", it)
            }
            .onError {
                notify("Test message", it.toString())
            }
    }
}