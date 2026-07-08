package multiplatform.zwkfb

interface Platform {
    val name: String
    val platform: String
}

expect fun getPlatform(): Platform