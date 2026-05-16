package multiplatform.zwkfb

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun platform(): String {
        return platform.platform
    }

}