package io.bitswar.openproject.data.repository

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import io.bitswar.openproject.data.datasources.IWorkPackageDatasource
import io.bitswar.openproject.domain.entities.WorkPackage
import io.bitswar.openproject.domain.repositories.IWorkPackageRepository

@Service(Service.Level.APP)
class WorkPackageRepository: IWorkPackageRepository {
    private val datasource: IWorkPackageDatasource = service()
    override fun getAllWorkpackages(): MutableList<WorkPackage> {
        return mutableListOf(
            WorkPackage(
                id = 1,
                title = "String",
                description = "String",
                status = "String"
            )
        )
    }

    override fun getProjectWorkpackages(projectID: Int): MutableList<WorkPackage> {
        val dtoList = datasource.getProjectWorkPackages(projectID.toString())
        val entities = dtoList.map { e ->
            WorkPackage(
                e.id,
                e.title,
                e.description.body,
                ""
            )
        }
        return entities.toMutableList()
    }
}