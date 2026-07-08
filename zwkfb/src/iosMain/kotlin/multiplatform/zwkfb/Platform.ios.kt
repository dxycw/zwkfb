package multiplatform.zwkfb

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val platform: String = "iOS"
}

actual fun getPlatform(): Platform = IOSPlatform()