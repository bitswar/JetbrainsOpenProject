package io.bitswar.openproject.domain.entities

data class WorkPackage(
    val id: Int,
    val title: String,
    val description: String,
    val status: String
)