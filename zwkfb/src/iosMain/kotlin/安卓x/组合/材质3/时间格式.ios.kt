package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get(): Boolean{
        val formatter = NSDateFormatter()
        formatter.locale = NSLocale.currentLocale
        return !formatter.dateFormat.contains("a") // 如果格式包含 "a"（AM/PM 标记），则为 12 小时制
    }