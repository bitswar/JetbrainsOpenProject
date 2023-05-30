package io.bitswar.openproject.data.repository

import com.intellij.openapi.components.service
import io.bitswar.openproject.data.datasources.IProjectDatasource
import io.bitswar.openproject.data.datasources.IWorkPackageDatasource
import io.bitswar.openproject.domain.entities.WorkPackage
import io.bitswar.openproject.domain.repositories.IWorkPackageRepository

class WorkPackageRepository: IWorkPackageRepository {
    private val datasource: IWorkPackageDatasource = service()
    override fun getAllWorkpackages(): List<WorkPackage> {
        TODO("Not yet implemented")
    }

    override fun getProjectWorkpackages(projectID: String): List<WorkPackage> {
        TODO("Not yet implemented")
    }
}