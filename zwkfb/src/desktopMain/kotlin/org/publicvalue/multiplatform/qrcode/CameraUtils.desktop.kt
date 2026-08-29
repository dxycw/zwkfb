package org.publicvalue.multiplatform.qrcode

import androidx.compose.runtime.Composable

@Composable
actual fun rememberCameraUtils(): CameraUtils {
    return object : CameraUtils {
        override fun setTorchMode(
            cameraPosition: CameraPosition,
            value: Boolean
        ): Boolean {
            println("CameraUtils 在 DESKTOP 上未实现。")
            return false
        }
    }
}