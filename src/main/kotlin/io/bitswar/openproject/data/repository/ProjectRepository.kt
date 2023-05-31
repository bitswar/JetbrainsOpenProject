package io.bitswar.openproject.data.repository

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.util.containers.toArray
import io.bitswar.openproject.data.datasources.IProjectDatasource
import io.bitswar.openproject.data.dto.ProjectDTO
import io.bitswar.openproject.domain.entities.Project
import io.bitswar.openproject.domain.repositories.IProjectRepository

@Service(Service.Level.APP)
class ProjectRepository: IProjectRepository {
    private val datasource: IProjectDatasource = service()


    override fun getProjects(): MutableList<Project> {
        val dtoArray = datasource.getProjects()
        val entities = dtoArray.map<ProjectDTO, Project> { e ->
            Project(
                e.id,
                e.name,
                mutableListOf()
            )
        }
        return entities.toMutableList()
    }
}