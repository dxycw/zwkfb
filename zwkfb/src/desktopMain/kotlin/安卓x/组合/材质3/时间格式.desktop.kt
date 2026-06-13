package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import java.text.DateFormat
import java.util.Locale

internal actual val is24HourFormat
    @Composable
    @ReadOnlyComposable
    get(): Boolean {
        val format = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault())
        val pattern = (format as? java.text.SimpleDateFormat)?.toPattern() ?: ""
        return !pattern.contains("a", ignoreCase = true)
    }
