package io.bitswar.openproject.domain.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.domain.entities.WorkPackage
import io.bitswar.openproject.domain.repositories.IWorkPackageRepository
import org.jetbrains.concurrency.Promise
import org.jetbrains.concurrency.runAsync

@Service
class WorkPackageService {
    private val repository: IWorkPackageRepository = service()
    fun getAllWorkpackages(): Promise<Array<WorkPackage>> {
        return runAsync {
            repository.getAllWorkpackages()
        }
    }

    fun getProjectWorkpackages(projectId: String): Promise<Array<WorkPackage>> {
        return runAsync {
            repository.getProjectWorkpackages(projectId)
        }
    }
}