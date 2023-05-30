package io.bitswar.openproject

import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.openapi.application.ApplicationManager

const val GROUP_DISPLAY_ID = "Bitswar.Group"

/**
 * Generate a [Notification] in IDEA.
 * @param first title of the notification
 * @param second content of the notification
 */
fun notify(first: String, second: String) = com.intellij.notification
        .Notifications.Bus
        .notify(
                Notification(
                        GROUP_DISPLAY_ID,
                        first,
                        second,
                        NotificationType.INFORMATION,
                )
        )

fun isPluginInTestIDE(): Boolean = System.getProperty("idea.is.internal")?.toBoolean() ?: false

fun isPluginInUnitTestMode(): Boolean = ApplicationManager.getApplication().isUnitTestMode