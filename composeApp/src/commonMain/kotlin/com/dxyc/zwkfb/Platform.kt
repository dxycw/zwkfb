package com.dxyc.zwkfb

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform