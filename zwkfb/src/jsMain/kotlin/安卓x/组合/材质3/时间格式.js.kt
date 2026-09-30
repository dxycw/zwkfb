package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get() {
        return js("new Intl.DateTimeFormat(undefined, { hour: 'numeric' }).resolvedOptions().hour12 === false") as Boolean
    }
