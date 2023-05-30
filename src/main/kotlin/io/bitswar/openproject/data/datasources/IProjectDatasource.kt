package io.bitswar.openproject.data.datasources

import io.bitswar.openproject.data.dto.ProjectDTO

interface IProjectDatasource {
    fun getProjects(): List<ProjectDTO>
}