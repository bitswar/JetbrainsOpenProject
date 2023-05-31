package io.bitswar.openproject.domain.repositories

import io.bitswar.openproject.domain.entities.WorkPackage

interface IWorkPackageRepository {
    fun getAllWorkpackages(): MutableList<WorkPackage>
    fun getProjectWorkpackages(projectID: Int): MutableList<WorkPackage>
}