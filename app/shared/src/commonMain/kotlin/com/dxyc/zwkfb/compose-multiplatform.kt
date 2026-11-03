package com.dxyc.zwkfb

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.painterResource
import zwkfbcs.app.shared.generated.resources.Res
import zwkfbcs.app.shared.generated.resources.compose_multiplatform

val compose_multiplatform: Painter
    @Composable
    get() = painterResource(Res.drawable.compose_multiplatform)