package com.zwkfb

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val platform: String = "WasmJs"
}

actual fun getPlatform(): Platform = WasmPlatform()