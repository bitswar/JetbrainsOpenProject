package io.bitswar.openproject.domain.entities

data class Project(
    val id: String,
    val name: String,
    val workPackages: List<WorkPackage>
)