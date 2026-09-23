package com.zwkfb.qrcode

import androidx.compose.runtime.Composable

@Composable
actual fun rememberCameraPermissionState(): CameraPermissionState {
    return object: CameraPermissionState {
        override val status: CameraPermissionStatus
            get() = CameraPermissionStatus.Denied

        override fun requestCameraPermission() {
            println("requestCameraPermission() 在 DESKTOP 上未实现。")
        }

        override fun goToSettings() {
            println("goToSettings() 在 DESKTOP 上未实现。")
        }

    }
}