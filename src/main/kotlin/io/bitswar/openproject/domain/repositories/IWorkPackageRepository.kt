package io.bitswar.openproject.domain.repositories

import io.bitswar.openproject.domain.entities.WorkPackage

interface IWorkPackageRepository {
    fun getAllWorkpackages(): List<WorkPackage>
    fun getProjectWorkpackages(projectID: String): List<WorkPackage>
}