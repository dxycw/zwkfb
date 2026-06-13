package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get(): Boolean {
        val formatter =
            js("new Intl.DateTimeFormat(undefined, { hour: 'numeric', minute: 'numeric' })")
        val parts = formatter.formatToParts(js("new Date()"))
        val hourPart = parts.unsafeCast<Array<dynamic>>().find { it.type == "dayPeriod" }
        return hourPart == undefined
    }