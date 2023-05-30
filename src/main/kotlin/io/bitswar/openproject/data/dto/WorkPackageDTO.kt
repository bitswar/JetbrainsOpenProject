package io.bitswar.openproject.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WorkPackageDTO(
    @SerialName("id") val id: String,
    @SerialName("_type") val type: String,
    @SerialName("_hint") val hint: String,
)