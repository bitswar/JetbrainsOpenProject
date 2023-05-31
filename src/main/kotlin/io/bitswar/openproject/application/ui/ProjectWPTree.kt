package io.bitswar.openproject.application.ui

import com.intellij.ui.JBColor
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.dsl.builder.panel
import com.intellij.uiDesigner.core.Spacer
import io.bitswar.openproject.domain.entities.Project
import javax.swing.JComponent
import javax.swing.JToolBar.Separator

fun workPackagesTree(projects: MutableList<Project>): JComponent {
    return JBScrollPane(
        panel {
            projects.map { project ->
                collapsibleGroup(project.name) {
                    project.workPackages.map { wp ->
                        row {
                            label("#${wp.id}")
                            Separator()
                            label(wp.title)
                        }
                        if (wp.description.isNotEmpty()) {
                            collapsibleGroup("Description") {
                                row {
                                    label(wp.description)
                                }
                            }
                        }
                        separator(background = JBColor.WHITE)
                    }
                }
            }
        }
    )
}