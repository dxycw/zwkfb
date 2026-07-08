package multiplatform.zwkfb

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return sayHello(platform.name)
    }

    fun platform(): String {
        return platform.platform
    }
}

fun sayHello(to: String): String =
    "Hello, $to!"