package com.zwkfb

class DesktopPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val platform: String = "Desktop"
}

actual fun getPlatform(): Platform = DesktopPlatform()