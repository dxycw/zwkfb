package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@OptIn(ExperimentalWasmJsInterop::class)
@JsFun("() => { const opts = { hour: 'numeric' }; return new Intl.DateTimeFormat(undefined, opts).resolvedOptions().hour12 === false; }")
external fun is24HourFormatJs(): Boolean

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get() = is24HourFormatJs()
