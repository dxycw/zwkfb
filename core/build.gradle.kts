import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
}

kotlin {
    iosArm64()
    iosSimulatorArm64()
    
    jvm()
    
    js {
        browser()
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
    
    android {
       namespace = "com.dxyc.zwkfb.core"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()
    
       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
    }
    
    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            api(project(":zwkfb")){

                // ------------------Multiplatform平台：

//                // 是 Compose Multiplatform 的基础库，提供基础的 UI 组件和工具库，包含基础的布局、文本、按钮、文本输入框、下拉列表等组件。
//                exclude("org.jetbrains.compose.material", "material")
//                // 如果使用图标，请把material-icons-extended依赖库注释掉
//                exclude("org.jetbrains.compose.material", "material-icons-extended")

                // 这是一个 Compose Multiplatform 的导航库
                exclude("org.jetbrains.androidx.navigation3", "navigation3-ui")
                // 这个库属于 Compose Multiplatform 生态，为 Navigation3 提供与 ViewModel 的集成支持。
                exclude("org.jetbrains.androidx.lifecycle", "lifecycle-viewmodel-navigation3")

                // 是 Kotlin 协程（Coroutines）的核心库
                exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-core")
                // 是 Kotlin 官方的多平台 JSON 序列化库
                exclude("org.jetbrains.kotlinx", "kotlinx-serialization-json")

                // 是 Ktor HTTP 客户端的核心模块
                exclude("io.ktor", "ktor-client-core")
                // 是 Ktor HTTP 客户端的 CIO (Coroutine I/O) 引擎
                exclude("io.ktor", "ktor-client-cio")

                // 是 MultiWeb —— 一个面向 Kotlin Multiplatform (KMP) 的原生 WebView 组件库。
                exclude("io.github.generalio.multiweb", "webview-compose")

                // 是 Kotlin Multiplatform 版本的 CommonMark Markdown 解析与渲染库
                exclude("io.github.feiyin0719", "commonmark")

//                // 是 JetBrains 官方用 Kotlin 编写的 Markdown 解析库
//                exclude("org.jetbrains", "markdown")
                // 是 Kotlin Multiplatform 语法高亮引擎
                exclude("dev.snipme", "highlights")

//                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库
//                exclude("com.mikepenz", "multiplatform-markdown-renderer")
                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 M2 版本
                exclude("com.mikepenz", "multiplatform-markdown-renderer-m2")
//                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 M3 版本
//                exclude("com.mikepenz", "multiplatform-markdown-renderer-m3")
                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 Coil3 版本
                exclude("com.mikepenz", "multiplatform-markdown-renderer-coil3")
                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 Code 版本
                exclude("com.mikepenz", "multiplatform-markdown-renderer-code")

//                // 是一个为 Compose Multiplatform 设计的视频播放库，它能让开发者用一套代码在多平台现视频播放功能。
//                exclude("io.github.kdroidfilter", "composemediaplayer")
                // 是一个为 Compose Multiplatform 设计的音频播放库，它能让开发者用一套代码在多平台现音频播放功能。
                exclude("io.github.kdroidfilter", "composemediaplayer-audio")

                // Photo — 相机拍摄与图库图片选择
                exclude("io.github.ismoy", "imagepickerkmp")
                // Scanner — 实时条形码与二维码扫描
                exclude("io.github.ismoy", "imagepickerkmp-scanner")

                // 是一个为 Compose Multiplatform 设计的条形码扫描库，它能让开发者用一套代码在多平台现扫码功能。
                exclude("io.github.ismai117", "KScan")

                // ------------------Android平台：

                // Kotlin 协程（Coroutines）的 Android 特定支持库
                exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-android")

                // ------------------Desktop (Windows, MacOS, 和 Linux)平台：

                // Kotlin 协程（Coroutines）的 Swing 特定支持库
                exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-swing")

                // JNA 核心库
                exclude("net.java.dev.jna", "jna")
                // JNA Platform（包含 Windows API、POSIX 等封装）
                exclude("net.java.dev.jna", "jna-platform")

//                // 是 FlatLaf —— 一个现代化的 Java Swing 跨平台 Look and Feel（外观与感觉）库。它提供类似 IntelliJ IDEA 的扁平化、高 DPI 支持、深色/浅色主题，并支持自定义主题。
//                exclude("com.formdev", "flatlaf")
//                // 是 FlatLaf 官方提供的扩展组件包，包含 Swing 标准库中没有的额外 UI 组件和工具类，用于增强 FlatLaf 主题下的桌面应用体验。
//                exclude("com.formdev", "flatlaf-extras")
//                // 是 FlatLaf 官方提供的 IntelliJ IDEA 主题包，包含 JetBrains 系列 IDE 的多种经典配色方案（如 Darcula、One Dark、Material 等），用于 Swing/JavaFX 桌面应用。
//                exclude("com.formdev", "flatlaf-intellij-themes")

                // ------------------Android 和 Desktop 平台：

                // 是 Ktor HTTP 客户端的 Android 和 Desktop 引擎（Engine）
                exclude("io.ktor", "ktor-client-okhttp")

            }
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}