package io.bitswar.openproject.core.endpoints

import com.intellij.openapi.components.Service
import io.bitswar.openproject.data.datasources.AppSettingsState

@Service(Service.Level.APP)
open class BaseEndpoints {
    private val state = AppSettingsState.getInstance()
    val baseUrl: String
        get() = state.baseUrl
    val apiVersion: String
        get() = "api/v3"

    val scheme: String
        get() = "${state.scheme ?: "http"}://"
}