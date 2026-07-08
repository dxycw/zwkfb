package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@ExperimentalWasmJsInterop
@JsFun("() => { return new Intl.DateTimeFormat(undefined, { hour: 'numeric', minute: 'numeric' }).formatToParts(new Date()); }")
external fun getTimeFormatParts(): JsArray<JsAny>

@ExperimentalWasmJsInterop
@JsFun("() => { return new Intl.DateTimeFormat(undefined, { hour: 'numeric' }).resolvedOptions().hourCycle; }")
external fun getHourCycle(): JsString?

@OptIn(ExperimentalWasmJsInterop::class)
internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get() {
        // 方式1：通过 hourCycle 判断
        val hourCycle = getHourCycle()?.toString()
        if (hourCycle != null) {
            return when (hourCycle) {
                "h23", "h24" -> true
                "h11", "h12" -> false
                else -> {
                    // 回退到 formatToParts 检查
                    checkByFormatParts()
                }
            }
        }
        return checkByFormatParts()
    }

@OptIn(ExperimentalWasmJsInterop::class)
private fun checkByFormatParts(): Boolean {
    val parts = getTimeFormatParts()
    // 检查是否包含 dayPeriod（AM/PM）
    for (i in 0 until parts.length) {
        val part = parts[i]
        val type = jsGetProperty(part!!, "type")?.toString()
        if (type == "dayPeriod") {
            return false // 有 AM/PM，说明是 12 小时制
        }
    }
    return true // 没有 AM/PM，说明是 24 小时制
}

@OptIn(ExperimentalWasmJsInterop::class)
@JsFun("(obj, prop) => obj[prop]")
external fun jsGetProperty(obj: JsAny, prop: String): JsAny?