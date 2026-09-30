package com.zwkfb

class Greeting {
    private val platform = getPlatform()

    fun greet(): String = "Hello, ${platform.name}!"

    fun platform(): String = platform.platform

}