package io.bitswar.openproject.data.repository

import com.intellij.openapi.components.service
import io.bitswar.openproject.core.endpoints.ProjectEndpoints
import io.bitswar.openproject.data.datasources.IProjectDatasource
import io.bitswar.openproject.domain.entities.Project
import io.bitswar.openproject.domain.repositories.IProjectRepository
import java.net.http.HttpClient

class ProjectRepository: IProjectRepository {
    private val datasource: IProjectDatasource = service()

    override fun getProjects(): List<Project> {
        TODO("Not yet implemented")
    }
}