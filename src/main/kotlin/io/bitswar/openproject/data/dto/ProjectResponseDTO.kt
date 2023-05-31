package io.bitswar.openproject.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectResponseDTO(
    @SerialName("count") val count: Int,
    @SerialName("_embedded") val embedded: Embedded
)

@Serializable
data class Embedded(
    @SerialName("elements") val elements: MutableList<ProjectDTO>
)