package 安卓x.组合.材质3


import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Locale

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get() {
        val df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault()) as? SimpleDateFormat
        return df?.toPattern()?.contains("H") == true // 24小时制用大写 H，12小时制用小写 h
    }