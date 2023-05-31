package io.bitswar.openproject.domain.repositories

import io.bitswar.openproject.domain.entities.Project

interface IProjectRepository {
    fun getProjects(): MutableList<Project>
}