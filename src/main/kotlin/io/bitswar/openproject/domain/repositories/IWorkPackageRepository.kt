package io.bitswar.openproject.domain.repositories

import io.bitswar.openproject.domain.entities.WorkPackage

interface IWorkPackageRepository {
    fun getAllWorkpackages(): Array<WorkPackage>
    fun getProjectWorkpackages(projectID: String): Array<WorkPackage>
}