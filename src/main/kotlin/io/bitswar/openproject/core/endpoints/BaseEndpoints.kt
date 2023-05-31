package io.bitswar.openproject.core.endpoints

import com.intellij.openapi.components.Service

@Service(Service.Level.APP)
open class BaseEndpoints {
    val baseUrl: String
        get() = "10.244.90.137:30523"
    val apiVersion: String
        get() = "api/v3"

    val scheme: String
        get() = "http://"
}