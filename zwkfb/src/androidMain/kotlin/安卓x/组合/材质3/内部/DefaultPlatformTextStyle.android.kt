package 安卓x.组合.材质3.内部

import androidx.compose.ui.text.PlatformTextStyle

private const val DefaultIncludeFontPadding = false

@Suppress("DEPRECATION")
private val DefaultPlatformTextStyle =
    PlatformTextStyle(includeFontPadding = DefaultIncludeFontPadding)

internal actual fun defaultPlatformTextStyle(): PlatformTextStyle? = DefaultPlatformTextStyle