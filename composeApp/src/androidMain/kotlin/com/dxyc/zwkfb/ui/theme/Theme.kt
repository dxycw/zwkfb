package com.zwkfb.multiplatform.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* 其他可覆盖的默认颜色。
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AppTheme(
    深色主题: Boolean = isSystemInDarkTheme(),
    动态颜色: Boolean = true,  // 动态颜色功能在Android 12及以上版本可用。
    内容: @Composable () -> Unit
) {
    val 颜色方案 = when {
        动态颜色 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val 上下文 = LocalContext.current
            if (深色主题) dynamicDarkColorScheme(上下文) else dynamicLightColorScheme(上下文)
        }
        深色主题 -> DarkColorScheme
        else -> LightColorScheme
    }
    MaterialTheme(
        colorScheme = 颜色方案,
        typography = Typography,
        content = 内容
    )
}