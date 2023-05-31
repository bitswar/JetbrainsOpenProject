package io.bitswar.openproject.data.datasources

import com.intellij.openapi.components.service
import io.bitswar.openproject.core.endpoints.WorkPackageEndpoints
import io.bitswar.openproject.data.dto.WorkPackageDTO

class WorkPackageDatasource: IWorkPackageDatasource {
    private val endpoints: WorkPackageEndpoints = service()
    override fun getAllWorkPackages(): List<WorkPackageDTO> {
        TODO("Not yet implemented")
    }

    override fun getProjectWorkPackages(): List<WorkPackageDTO> {
        TODO("Not yet implemented")
    }
}