package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get() {
        // 使用 Intl.DateTimeFormat 获取当前 Locale 的短时间格式
        val formatter = js("new Intl.DateTimeFormat(undefined, { hour: 'numeric', minute: 'numeric' })")
        val parts = formatter.formatToParts(js("new Date()"))

        // 检查格式化后的时间字符串中是否包含 AM/PM 标记
        val hasAmPm = parts.asDynamic().any { part: dynamic ->
            part.type == "dayPeriod"
        } as Boolean

        // 如果有 AM/PM 标记，则为 12 小时制；否则为 24 小时制
        return !hasAmPm
    }