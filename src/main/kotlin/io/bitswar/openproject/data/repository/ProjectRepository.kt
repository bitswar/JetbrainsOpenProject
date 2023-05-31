package io.bitswar.openproject.data.repository

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.data.datasources.IProjectDatasource
import io.bitswar.openproject.domain.entities.Project
import io.bitswar.openproject.domain.repositories.IProjectRepository

@Service(Service.Level.APP)
class ProjectRepository: IProjectRepository {
    private val datasource: IProjectDatasource = service()


    override fun getProjects(): Array<Project> {
        datasource.getProjects()
        return arrayOf(
            Project(
                id = "1",
                name = "Lithium",
                workPackagesArray = arrayOf()
            )
        )
    }
}