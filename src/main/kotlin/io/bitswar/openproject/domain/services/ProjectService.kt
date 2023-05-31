package io.bitswar.openproject.domain.services

import com.intellij.openapi.components.service
import io.bitswar.openproject.domain.entities.Project
import io.bitswar.openproject.domain.repositories.IProjectRepository
import org.jetbrains.concurrency.Promise
import org.jetbrains.concurrency.runAsync

class ProjectService {
    private val repository: IProjectRepository = service()
    fun getProjects(): Promise<Array<Project>> {
        return runAsync {
            repository.getProjects();
        }
    }
}