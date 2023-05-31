package io.bitswar.openproject.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WorkPackageResponseDTO(
    @SerialName("count") val count: Int,
    @SerialName("_embedded") val embedded: WorkPackageEmbedded
)

@Serializable
data class WorkPackageEmbedded(
    @SerialName("elements") val elements: MutableList<WorkPackageDTO>
)

@Serializable
data class WorkPackageDTO(
    @SerialName("id") val id: Int,
    @SerialName("_type") val type: String,
    @SerialName("subject") val title: String,
    @SerialName("description") val description: WorkPackageDescription
)

@Serializable
data class WorkPackageDescription(
    val format: String,
    val raw: String,
    val html: String
) {
    val body: String
        get() {
            if (format == "markdown") {
                return raw
            }
            return html
        }
}