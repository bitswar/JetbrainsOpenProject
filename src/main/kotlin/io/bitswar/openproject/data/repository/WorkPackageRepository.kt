package io.bitswar.openproject.data.repository

import io.bitswar.openproject.domain.entities.WorkPackage
import io.bitswar.openproject.domain.repositories.IWorkPackageRepository

class WorkPackageRepository: IWorkPackageRepository {
//    private val datasource: IWorkPackageDatasource = service()
    override fun getAllWorkpackages(): Array<WorkPackage> {
        return arrayOf(
            WorkPackage(
                id = "String",
                title = "String",
                description = "String",
                status = "String"
            )
        )
    }

    override fun getProjectWorkpackages(projectID: String): Array<WorkPackage> {
        return arrayOf(
            WorkPackage(
                id = "String",
                title = "String",
                description = "String",
                status = "String"
            )
        )
    }
}