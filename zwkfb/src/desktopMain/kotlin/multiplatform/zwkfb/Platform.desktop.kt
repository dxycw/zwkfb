package multiplatform.zwkfb

class DESKTOPPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
    override val platform: String = "desktop"
}

actual fun getPlatform(): Platform = DESKTOPPlatform()
