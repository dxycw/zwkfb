package multiplatform.zwkfb

class JsPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
    override val platform: String = "js"
}

actual fun getPlatform(): Platform = JsPlatform()