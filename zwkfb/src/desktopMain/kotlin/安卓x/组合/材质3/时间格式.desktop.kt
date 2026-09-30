package 安卓x.组合.材质3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import java.text.DateFormat
import java.text.SimpleDateFormat

internal actual val is24HourFormat: Boolean
    @Composable
    @ReadOnlyComposable
    get() {
        val dateFormat = DateFormat.getTimeInstance(DateFormat.LONG)
        if (dateFormat !is SimpleDateFormat) return false
        return 'H' in dateFormat.toPattern()
    }