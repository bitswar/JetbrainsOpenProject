package io.bitswar.openproject.core.endpoints

import com.intellij.openapi.components.Service
import io.bitswar.openproject.core.Endpoints

@Service(Service.Level.APP)
class ProjectEndpoints: Endpoints() {
    val projects: String
        get() = buildEndpoint("projects")

}