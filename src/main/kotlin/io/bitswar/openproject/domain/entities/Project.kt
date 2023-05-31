package io.bitswar.openproject.domain.entities

data class Project(
    val id: String,
    val name: String,
    var workPackagesArray: Array<WorkPackage>
) {
    val workPackages: Array<WorkPackage>
        get() = workPackagesArray
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Project

        if (id != other.id) return false
        if (name != other.name) return false
        return workPackages.contentEquals(other.workPackages)
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + workPackages.contentHashCode()
        return result
    }
}