package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSDateFormatterStyle
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get() {
        val locale = NSLocale.currentLocale
        // 获取系统当前 Locale 的短时间格式模板
        val format = NSDateFormatter.dateFormatFromTemplate(
            tmplate = "j:mm",  // 'j' 是小时占位符，会自动适配 12/24 小时制
            options = 0u,
            locale = locale,
        ) ?: return false

        // 如果格式中包含 'H' 或 'k'（24小时制），不包含 'h'（12小时制）
        return format.contains("H") || format.contains("k")
    }