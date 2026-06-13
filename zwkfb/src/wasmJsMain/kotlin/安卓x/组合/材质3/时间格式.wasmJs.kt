package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@OptIn(ExperimentalWasmJsInterop::class)
@JsFun("() => new Intl.DateTimeFormat().resolvedOptions().hour12")
private external fun nativeHour12(): Boolean

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get(): Boolean = !nativeHour12()
