package io.bitswar.openproject.application.ui

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel


class AppSettingsComponent {
    private var settingsPanel: JPanel? = null
    private val scheme = JBTextField()
    private val baseUrl = JBTextField()
    private val accessToken = JBTextField()
    init {
        settingsPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Enter scheme: "), scheme, 1, false)
            .addLabeledComponent(JBLabel("Enter base url: "), baseUrl, 1, false)
            .addLabeledComponent(JBLabel("Enter access token: "), accessToken, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }
    fun getPanel(): JPanel? {
        return settingsPanel
    }
    fun getPreferredFocusedComponent(): JComponent {
        return baseUrl
    }
    var schemeData: String
        get() = scheme.text
        set(value) {
            scheme.text = value
        }
    var baseUrlData: String
        get() = baseUrl.text
        set(value) {
            baseUrl.text = value
        }
    var accessTokenData: String
        get() = this.accessToken.text
        set(value) {
            accessToken.text = value
        }
}