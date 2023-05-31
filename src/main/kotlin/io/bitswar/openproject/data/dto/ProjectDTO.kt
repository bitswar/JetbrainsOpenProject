package io.bitswar.openproject.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectDTO(
    @SerialName("id") val id: Int,
    @SerialName("identifier") val identifier: String,
    @SerialName("name") val name: String
)