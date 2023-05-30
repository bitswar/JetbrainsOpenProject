package io.bitswar.openproject.core.endpoints

import com.intellij.openapi.components.Service

@Service(Service.Level.APP)
class ProjectEndpoints {

    private fun getApiVersion(): String {
        return "/api/v3"
    }
    fun getProjects(): String {
        return getApiVersion() + "/projects"
    }
}