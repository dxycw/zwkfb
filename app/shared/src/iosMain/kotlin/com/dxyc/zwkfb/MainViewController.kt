package com.dxyc.zwkfb

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { App() }

//fun MainViewController() = ComposeUIViewController {
//    val libraries by produceLibraries {
//        Res.readBytes("files/aboutlibraries.json").decodeToString()
//    }
//    App(libraries = libraries)
//}
