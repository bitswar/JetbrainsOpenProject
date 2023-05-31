package io.bitswar.openproject.domain.entities

data class Project(
    val id: Int,
    val name: String,
    var workPackages: MutableList<WorkPackage>
)