package com.mikepenz.markdown.sample

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.ui.compose.produceLibraries
import zwkfbmultiplatform.app.shared.generated.resources.Res

@Suppress("ComposableNaming")
@Composable
fun aboutlibraries(): Libs? {
    val libraries by produceLibraries {
        Res.readBytes("files/aboutlibraries.json").decodeToString()
    }
    return libraries
}
