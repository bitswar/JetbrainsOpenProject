package io.bitswar.openproject.domain.services

import com.intellij.openapi.components.service
import io.bitswar.openproject.data.repository.WorkPackageRepository
import io.bitswar.openproject.domain.entities.Project
import io.bitswar.openproject.domain.repositories.IProjectRepository
import org.jetbrains.concurrency.Promise
import org.jetbrains.concurrency.runAsync

class ProjectService {
    private val repository: IProjectRepository = service()
    private val wpService: WorkPackageService = service()
    fun getProjects(): Array<Project> {
            val projects = repository.getProjects()
            projects.map { e ->
                e.workPackagesArray = wpService.getProjectWorkpackages(e.id)
            }
            return projects
    }
}