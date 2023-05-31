package io.bitswar.openproject.data.datasources

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil


@State(
    name = "org.intellij.sdk.settings.AppSettingsState",
    storages = [Storage("SdkSettingsPlugin.xml")]
)
class AppSettingsState: PersistentStateComponent<AppSettingsState> {

    var baseUrl = "board.dipal-local.ru"
    var scheme = "https"
    var accessToken = "accessToken"

    companion object {
        fun getInstance(): AppSettingsState {
            return ApplicationManager.getApplication().getService(AppSettingsState::class.java)
        }
    }

    override fun getState(): AppSettingsState? {
        return this
    }

    override fun loadState(state: AppSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}