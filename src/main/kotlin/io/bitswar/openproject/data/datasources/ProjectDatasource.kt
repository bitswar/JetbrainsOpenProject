package io.bitswar.openproject.data.datasources

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.core.RequestBuilder
import io.bitswar.openproject.core.endpoints.ProjectEndpoints
import io.bitswar.openproject.data.dto.ProjectDTO
import io.bitswar.openproject.data.dto.ProjectResponseDTO
import java.net.http.HttpClient
import java.net.http.HttpResponse
import kotlinx.serialization.json.Json

@Service(Service.Level.APP)
class ProjectDatasource: IProjectDatasource {
    private val builder: RequestBuilder = service()
    private val client: HttpClient = HttpClient.newBuilder().build()
    private val json = Json { ignoreUnknownKeys = true }
    private val endpoints: ProjectEndpoints = service()

    override fun getProjects(): MutableList<ProjectDTO> {
        val response = client.send(builder.getRequest(endpoints.projects), HttpResponse.BodyHandlers.ofString())
        val responseDTO: ProjectResponseDTO = json.decodeFromString(ProjectResponseDTO.serializer(), response.body())
        return responseDTO.embedded.elements
    }
}