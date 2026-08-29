package org.publicvalue.multiplatform.qrcode

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun Scanner(
    modifier: Modifier,
    onScanned: (String) -> Boolean,
    types: List<CodeType>,
    cameraPosition: CameraPosition,
    enableTorch: Boolean,
) {
    Text("Scanner 在 DESKTOP 上尚未实现。")
}