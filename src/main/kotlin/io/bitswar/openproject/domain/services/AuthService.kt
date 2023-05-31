package io.bitswar.openproject.domain.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.domain.entities.Profile
import io.bitswar.openproject.domain.repositories.IAuthRepository

@Service(Service.Level.APP)
class AuthService {
    private val repository: IAuthRepository = service()
    fun getProfile(): Profile {
        return repository.getProfile()
    }
}