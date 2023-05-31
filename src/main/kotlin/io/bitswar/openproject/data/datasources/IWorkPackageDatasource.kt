package io.bitswar.openproject.data.datasources

import io.bitswar.openproject.data.dto.WorkPackageDTO

interface IWorkPackageDatasource {
    fun getAllWorkPackages(): MutableList<WorkPackageDTO>
    fun getProjectWorkPackages(projectId: String): MutableList<WorkPackageDTO>
}