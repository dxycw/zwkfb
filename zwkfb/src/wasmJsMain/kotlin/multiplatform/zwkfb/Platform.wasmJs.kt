package multiplatform.zwkfb


class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
    override val platform: String = "wasmJs"
}

actual fun getPlatform(): Platform = WasmPlatform()