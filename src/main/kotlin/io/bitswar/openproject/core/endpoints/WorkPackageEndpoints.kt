package io.bitswar.openproject.core.endpoints

import com.intellij.openapi.components.Service
import io.bitswar.openproject.core.Endpoints

@Service(Service.Level.APP)
class WorkPackageEndpoints: Endpoints() {
    fun getWorkPackagesByProject(id: String): String {
        return buildEndpoint("projects", id, "work_packages")
    }
}