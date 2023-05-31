package io.bitswar.openproject.data.repository

import io.bitswar.openproject.domain.entities.Project
import io.bitswar.openproject.domain.repositories.IProjectRepository

class ProjectRepository: IProjectRepository {
//    private val datasource: IProjectDatasource = service()

    override fun getProjects(): Array<Project> {
        return arrayOf(
            Project(
                id = "String",
                name = "String",
                workPackages = arrayOf()
            )
        )
    }
}