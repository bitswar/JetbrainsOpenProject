package io.bitswar.openproject.application.ui

import com.intellij.ui.JBColor
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.dsl.builder.panel
import com.intellij.ui.dsl.gridLayout.HorizontalAlign
import com.intellij.uiDesigner.core.Spacer
import io.bitswar.openproject.domain.entities.Project
import java.awt.Color
import javax.swing.JComponent
import javax.swing.JToolBar.Separator

fun workPackagesTree(projects: Array<Project>): JComponent {
    return JBScrollPane(
        panel {
            projects.map { project ->
                collapsibleGroup(project.name) {
                    project.workPackages.map { wp ->
                        row {
                            label("#${wp.id}")
                            Separator()
                            label(wp.title)
                            Spacer()
                            label("(${wp.status})")
                        }
                        row {
                            label(wp.description)
                        }
                        separator(background = JBColor.WHITE)
                    }
                }
            }
        }
    )
}