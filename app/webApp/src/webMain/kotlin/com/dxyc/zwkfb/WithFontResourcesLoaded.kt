package com.dxyc.zwkfb

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalFontFamilyResolver
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.preloadFont
import zwkfbcs.app.webapp.generated.resources.NotoSansSC
import zwkfbcs.app.webapp.generated.resources.Res

@Composable
internal inline fun WithFontResourcesLoaded(
    content: @Composable () -> Unit
) {
    val font by preloadFont(Res.font.NotoSansSC)

    var fontFallbackInitialized by remember { mutableStateOf(false) }
    val fontFamilyResolver = LocalFontFamilyResolver.current

    LaunchedEffect(fontFamilyResolver, font) {
        font?.let { font ->
            fontFamilyResolver.preload(FontFamily(font))
            fontFallbackInitialized = true
        }
    }

    if (fontFallbackInitialized) {
        content()
    }
}