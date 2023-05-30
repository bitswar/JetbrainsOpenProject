package io.bitswar.openproject.data.datasources

import io.bitswar.openproject.data.dto.WorkPackageDTO

interface IWorkPackageDatasource {
    fun getAllWorkPackages(): List<WorkPackageDTO>
    fun getProjectWorkPackages(): List<WorkPackageDTO>
}