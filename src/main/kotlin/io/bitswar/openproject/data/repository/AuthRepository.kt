package io.bitswar.openproject.data.repository

import com.intellij.openapi.components.Service
import io.bitswar.openproject.domain.entities.Profile
import io.bitswar.openproject.domain.repositories.IAuthRepository

@Service(Service.Level.APP)
class AuthRepository: IAuthRepository {
    override fun getProfile(): Profile {
        return Profile(
            id = "String",
            name = "String"
        )
    }

    override fun getAccessToken(): String {
            return "8cedc206534ccacbb77b98559a9ae7a5a04381711e73e9f67e9c3550e179c69d"
    }

    override fun getUsername(): String {
        return "apikey"
    }
}