package com.dxyc.zwkfb

import androidx.compose.ui.window.ComposeViewport

fun main() {
    ComposeViewport {
        WithFontResourcesLoaded {
            App()
        }
    }
}