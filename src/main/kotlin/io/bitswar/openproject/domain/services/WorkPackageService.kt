package io.bitswar.openproject.domain.services

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.domain.entities.WorkPackage
import io.bitswar.openproject.domain.repositories.IWorkPackageRepository

@Service
class WorkPackageService {
    private val repository: IWorkPackageRepository = service()
    fun getAllWorkpackages(): List<WorkPackage> {
        return repository.getAllWorkpackages()
    }

    fun getProjectWorkpackages(projectId: String): List<WorkPackage> {
        return repository.getProjectWorkpackages(projectId)
    }
}