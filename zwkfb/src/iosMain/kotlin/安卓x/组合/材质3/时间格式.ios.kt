package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get() {
        val locale = NSLocale.currentLocale
        val dateFormat = NSDateFormatter.dateFormatFromTemplate("j", options = 0u, locale = locale)
        return dateFormat?.contains('a') == false
    }
