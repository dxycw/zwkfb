package com.zwkfb.qrcode

import androidx.compose.runtime.Composable

@Composable
actual fun rememberCameraUtils(): CameraUtils {
    return IosCameraUtils()
}