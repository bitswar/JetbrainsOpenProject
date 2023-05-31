package io.bitswar.openproject.data.datasources

import com.intellij.openapi.options.Configurable
import io.bitswar.openproject.application.ui.AppSettingsComponent
import org.jetbrains.annotations.Nls
import javax.swing.JComponent


class AppSettingsConfigurable: Configurable {
    private var mySettingsComponent: AppSettingsComponent? = null

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP
    override fun getDisplayName(): @Nls(capitalization = Nls.Capitalization.Title) String? {
        return "SDK: Application Settings Example"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return mySettingsComponent!!.getPreferredFocusedComponent()
    }

    override fun createComponent(): JComponent? {
        mySettingsComponent = AppSettingsComponent()
        return mySettingsComponent!!.getPanel()
    }

    override fun isModified(): Boolean {
        val settings: AppSettingsState = AppSettingsState.getInstance()
        var modified = mySettingsComponent!!.baseUrlData != settings.baseUrl
        modified = modified or (mySettingsComponent!!.schemeData != settings.scheme)
        modified = modified or (mySettingsComponent!!.accessTokenData != settings.accessToken)
        return modified
    }

    override fun apply() {
        val settings: AppSettingsState = AppSettingsState.getInstance()
        settings.scheme = mySettingsComponent!!.schemeData
        settings.baseUrl = mySettingsComponent!!.baseUrlData
        settings.accessToken = mySettingsComponent!!.accessTokenData
    }

    override fun reset() {
        val settings: AppSettingsState = AppSettingsState.getInstance()
        mySettingsComponent!!.schemeData = settings.scheme
        mySettingsComponent!!.baseUrlData = settings.baseUrl
        mySettingsComponent!!.accessTokenData = settings.accessToken
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }

}