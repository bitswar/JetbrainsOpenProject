package io.bitswar.openproject.data.datasources

import com.intellij.openapi.components.service
import io.bitswar.openproject.core.RequestBuilder
import io.bitswar.openproject.core.endpoints.WorkPackageEndpoints
import io.bitswar.openproject.data.dto.WorkPackageDTO
import io.bitswar.openproject.data.dto.WorkPackageResponseDTO
import kotlinx.serialization.json.Json
import java.net.http.HttpClient
import java.net.http.HttpResponse

class WorkPackageDatasource: IWorkPackageDatasource {
    private val endpoints: WorkPackageEndpoints = service()
    private val builder: RequestBuilder = service()
    private val client: HttpClient = HttpClient.newBuilder().build()
    private val json = Json { ignoreUnknownKeys = true }
    override fun getAllWorkPackages(): MutableList<WorkPackageDTO> {
        TODO("Not yet implemented")
    }

    override fun getProjectWorkPackages(projectId: String): MutableList<WorkPackageDTO> {
        val response = client.send(
            builder.getRequest(endpoints.getWorkPackagesByProject(projectId)),
            HttpResponse.BodyHandlers.ofString()
        )
        val responseDTO: WorkPackageResponseDTO = json.decodeFromString(WorkPackageResponseDTO.serializer(), response.body())
        return responseDTO.embedded.elements
    }
}