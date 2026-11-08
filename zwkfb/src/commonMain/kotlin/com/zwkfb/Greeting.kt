package com.zwkfb

class Greeting {
    private val platform = getPlatform()

    fun greet(): String = sayHello(platform.name)

    fun platform(): String = platform.platform

}

fun sayHello(to: String): String =
    "Hello, $to!"