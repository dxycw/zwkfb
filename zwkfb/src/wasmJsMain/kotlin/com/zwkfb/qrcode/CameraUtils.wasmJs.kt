package com.zwkfb.qrcode

import androidx.compose.runtime.Composable
import com.zwkfb.qrcode.CameraPosition
import com.zwkfb.qrcode.CameraUtils

@Composable
actual fun rememberCameraUtils(): CameraUtils {
    return object : CameraUtils {
        override fun setTorchMode(
            cameraPosition: CameraPosition,
            value: Boolean
        ): Boolean {
            println("CameraUtils 在 WASMJS 上未实现。")
            return false
        }
    }
}