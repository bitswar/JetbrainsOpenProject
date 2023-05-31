package io.bitswar.openproject.application.ui

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import io.bitswar.openproject.domain.services.ProjectService

class UIRoot: ToolWindowFactory {
    private val projectService: ProjectService = service()
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val projects = projectService.getProjects()
        val tree = workPackagesTree(projects)
        val content = ContentFactory.getInstance().createContent(tree, "", false)
        toolWindow.contentManager.addContent(content)
        toolWindow.show()
    }
}