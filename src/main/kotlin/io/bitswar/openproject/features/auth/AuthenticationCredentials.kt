package io.bitswar.openproject.features.auth

import com.intellij.openapi.components.Service


@Service(Service.Level.APP)
class AuthenticationCredentials {
    fun getAccessToken(): String {
        return "8cedc206534ccacbb77b98559a9ae7a5a04381711e73e9f67e9c3550e179c69d"
    }

    fun getScheme(): String {
        return "http://"
    }
    fun getBaseUrl(): String {
        return "10.244.90.137:30523"
    }
}