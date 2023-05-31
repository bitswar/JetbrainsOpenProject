package io.bitswar.openproject.domain.repositories

import io.bitswar.openproject.domain.entities.Profile

interface IAuthRepository {
    fun getProfile(): Profile
    fun getAccessToken(): String
    fun getUsername(): String
}