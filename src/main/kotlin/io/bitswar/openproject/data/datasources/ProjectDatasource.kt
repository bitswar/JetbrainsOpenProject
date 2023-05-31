package io.bitswar.openproject.data.datasources

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.core.endpoints.ProjectEndpoints
import io.bitswar.openproject.data.dto.ProjectDTO

@Service(Service.Level.APP)
class ProjectDatasource: IProjectDatasource {
    private val endpoints: ProjectEndpoints = service()
    override fun getProjects(): List<ProjectDTO> {
        TODO("Not yet implemented")
    }
}