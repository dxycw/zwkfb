import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.androidLint)

    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("maven-publish")
}

kotlin {

    android {
        namespace = "com.zwkfb"
        compileSdk {
            version = release(libs.versions.android.compileSdk.get().toInt()) {
                minorApiLevel = 1
            }
        }
        minSdk = 24

        // 从 Android Gradle 插件版本 8.8.0 开始
        // 必须显式开启，否则 androidMain/res 被忽略
        androidResources {
            enable = true
        }

        aarMetadata {
            minCompileSdk = 37  // 但这对上游依赖无效
        }

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }

        withHostTestBuilder {}

        withDeviceTestBuilder { sourceSetTreeName = "test" }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "zwkfbKit"
            isStatic = true
        }
    }

    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    js {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {

        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // Add KMP dependencies here

                api(libs.compose.runtime)
                api(libs.compose.foundation)
                api(libs.compose.material)
                api(libs.compose.material3)
                api(libs.compose.ui)
                api(libs.compose.uiToolingPreview)
                api(libs.compose.uiGraphics)
                api(libs.compose.components.resources)
                // 图标库，包含 org.jetbrains.compose.material:material-icons-core 里面的图标
                api(libs.compose.material.iconsExtended)

                //===================================================================

                // 这个库属于 Compose Multiplatform 生态，为 Compose 提供与 ViewModel 的集成支持。
                api(libs.androidx.lifecycle.viewmodelCompose)
                // 这个库属于 Compose Multiplatform 生态，为 Compose 提供与 Runtime 的集成支持。
                api(libs.androidx.lifecycle.runtimeCompose)
                // 这个库属于 Compose Multiplatform 生态，为 Navigation3 提供与 ViewModel 的集成支持。
                api(libs.androidx.lifecycle.viewmodelNavigation3)

                //===================================================================

                // 这是一个 Compose Multiplatform 的navigation导航库
                api(libs.androidx.navigation.compose)
                // 这是一个 Compose Multiplatform 的navigation3导航库
                api(libs.androidx.navigation3.ui)

                //===================================================================

                // 是 Kotlin 协程（Coroutines）的核心库
                api(libs.kotlinx.coroutines.core)
                // 是 Kotlin 官方的多平台 JSON 序列化库
                api(libs.kotlinx.serialization.json)

                //===================================================================

                // 是 Kotlin Multiplatform 版本的 CommonMark Markdown 解析与渲染库
                api(libs.feiyin0719.commonmark)
                // 是 JetBrains 官方用 Kotlin 编写的 Markdown 解析库
                api(libs.jetbrains.markdown)
                // 是 Kotlin Multiplatform 语法高亮引擎
                api(libs.snipme.highlights)

                //===================================================================

                // 是 Ktor HTTP 客户端的核心模块
                api(libs.ktor.client.core)
                // 是 Ktor HTTP 客户端的 CIO (Coroutine I/O) 引擎
                api(libs.ktor.client.cio)

                // 是 MultiWeb —— 一个面向 Kotlin Multiplatform (KMP) 的原生 WebView 组件库。
                api("io.github.generalio.multiweb:webview-compose:0.2.9")

                //===================================================================

                // 是一套现代化、完全可访问的 Compose 多平台组件集合。
                api(libs.composables.ui)

                //===================================================================

                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库
                api(libs.mikepenz.multiplatform.markdown.renderer)
                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 M2 版本
                api(libs.mikepenz.multiplatform.markdown.renderer.m2)
                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 M3 版本
                api(libs.mikepenz.multiplatform.markdown.renderer.m3)
                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 Coil2 版本
//                implementation("com.mikepenz:multiplatform-markdown-renderer-coil2:0.45.0")
                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 Coil3 版本
                api(libs.mikepenz.multiplatform.markdown.renderer.coil3)
                // 是由 Mike Penz 开发的一个 Kotlin Multiplatform（KMP）Markdown 渲染库的 Code 版本
                api(libs.mikepenz.multiplatform.markdown.renderer.code)

                //===================================================================

                // Photo — 相机拍摄与图库图片选择
                api("io.github.ismoy:imagepickerkmp:1.1.7")
//                // Video — 视频录制与图库视频选择
//                api("io.github.ismoy:imagepickerkmp-video:1.1.0") // SOON
//                // Audio — 音频录制
//                api("io.github.ismoy:imagepickerkmp-audio:1.1.3") // SOON
//                // Audio Player — 语音消息与音频文件播放
//                api("io.github.ismoy:imagepickerkmp-audioplayer:1.1.3") // SOON
                // Scanner — 实时条形码与二维码扫描
                api("io.github.ismoy:imagepickerkmp-scanner:1.0.0")
//                // Video Player — 全功能视频播放
//                api("io.github.ismoy:imagepickerkmp-videoplayer:1.1.3") // SOON

                //===================================================================

                // markdown项目
                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.5.1")
                implementation("io.coil-kt.coil3:coil-compose:3.5.0")
//                implementation("io.coil-kt.coil3:coil-network-okhttp:3.5.0")

                // Compose Markdown Multiplatform
                implementation("io.github.feiyin0719:commonmark-ext-gfm-tables:0.0.2")
                implementation("io.github.feiyin0719:commonmark-ext-autolink:0.0.2")
                implementation("io.github.feiyin0719:commonmark-ext-task-list-items:0.0.2")
                implementation("io.github.feiyin0719:commonmark-ext-html-converter:0.0.2")
                implementation("io.coil-kt.coil3:coil-network-ktor3:3.5.0")

//                // 是一个高度可定制的 Compose Multiplatform 日历库
//                // https://github.com/kizitonwose/Calendar
//                api("com.kizitonwose.calendar:compose-multiplatform:2.10.1")

            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {

                // 是 Android Activity 组件的 Compose 版本，用于在 Compose 中创建 Android 活动
                api(libs.androidx.activity.compose)
                // 是 Kotlin 协程（Coroutines）的核心库
                api(libs.kotlinx.coroutinesAndroid)

                //===================================================================

                // 是 Ktor HTTP 客户端的 Android 引擎（Engine）
                api(libs.ktor.client.okhttp)

                //===================================================================

                // CameraX
//                implementation("androidx.camera:camera-core:1.6.1")
                compileOnly("androidx.camera:camera-camera2:1.6.1")
                compileOnly("androidx.camera:camera-lifecycle:1.6.1")
                compileOnly("androidx.camera:camera-view:1.6.1")
//                implementation("androidx.camera:camera-extensions:1.6.1")
                // 是 CameraX 官方提供的 ML Kit 视觉组件库
//                implementation("androidx.camera:camera-mlkit-vision:1.6.1") // MlKitAnalyzer
                // ML Kit
                compileOnly("com.google.mlkit:barcode-scanning:17.3.0")
                // 权限
                compileOnly("com.google.accompanist:accompanist-permissions:0.37.3")

                //===================================================================

                // markdown项目
                // multiplatform-markdown-renderer
                compileOnly("io.coil-kt:coil-compose:2.7.0")

                // 是 AndroidX Startup 库的核心模块，用于统一管理应用启动时的第三方库初始化。
                compileOnly("androidx.startup:startup-runtime:1.2.0")

            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.core)
                implementation(libs.androidx.runner)
                implementation(libs.androidx.testExt.junit)
            }
        }

        getByName("desktopMain")  {
            dependencies {
                implementation(compose.desktop.currentOs)

                //===================================================================

                api(libs.kotlinx.coroutinesSwing)
//                api("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.11.0")

                //===================================================================

                // JNA 核心库
                api(libs.dev.jna)
                // JNA Platform（包含 Windows API、POSIX 等封装）
                api(libs.dev.jnaPlatform)

                //===================================================================

                // 是 FlatLaf —— 一个现代化的 Java Swing 跨平台 Look and Feel（外观与感觉）库。它提供类似 IntelliJ IDEA 的扁平化、高 DPI 支持、深色/浅色主题，并支持自定义主题。
                api(libs.formdev.flatlaf)
                // 是 FlatLaf 官方提供的扩展组件包，包含 Swing 标准库中没有的额外 UI 组件和工具类，用于增强 FlatLaf 主题下的桌面应用体验。
                api(libs.formdev.flatlafExtras)
                // 是 FlatLaf 官方提供的 IntelliJ IDEA 主题包，包含 JetBrains 系列 IDE 的多种经典配色方案（如 Darcula、One Dark、Material 等），用于 Swing/JavaFX 桌面应用。
                api(libs.formdev.flatlafIntellijThemes)
//                api("com.formdev:flatlaf-jide-oss:3.7.1")
//                api("com.formdev:flatlaf-swingx:3.7.1")
//                api("com.formdev:flatlaf-fonts-inter:4.1")
//                api("com.formdev:flatlaf-fonts-jetbrains-mono:2.304")
//                api("com.formdev:flatlaf-fonts-roboto:2.137")
//                api("com.formdev:flatlaf-fonts-roboto-mono:3.000")

                //===================================================================

//                // 根据当前构建平台选择 classifier
//                val javafxPlatform = when {
//                    org.gradle.internal.os.OperatingSystem.current().isMacOsX -> {
//                        if (System.getProperty("os.arch") == "aarch64") "mac-aarch64" else "mac"
//                    }
//                    org.gradle.internal.os.OperatingSystem.current().isWindows -> "win"
//                    org.gradle.internal.os.OperatingSystem.current().isLinux -> "linux"
//                    else -> throw GradleException("Unsupported OS")
//                }
//                api("org.openjfx:javafx-base:21:$javafxPlatform") // 基础
//                api("org.openjfx:javafx-controls:21:$javafxPlatform") // UI 控件
//                api("org.openjfx:javafx-graphics:21:$javafxPlatform") // 图形
//                api("org.openjfx:javafx-fxml:21:$javafxPlatform") // XML 布局
//                api("org.openjfx:javafx-swing:21:$javafxPlatform") // Swing 互操作
//                api("org.openjfx:javafx-web:21:$javafxPlatform") // WebView（如需要）
//                api("org.openjfx:javafx-media:21:$javafxPlatform") // 音视频（如需要）

                //===================================================================

//                // 是 Jewel UI 库的基础核心模块
//                api("org.jetbrains.jewel:jewel-foundation:0.39.1-262.9437.29")
//                // 是 Jewel UI 库的通用组件模块
//                api("org.jetbrains.jewel:jewel-ui:0.39.1-262.9437.29")
//                // 是 Jewel UI 库的 Markdown 渲染核心模块
//                api("org.jetbrains.jewel:jewel-markdown-core:0.39.1-262.9437.29")
//                // 是 Jewel UI 库的 IntelliJ 风格独立桌面应用主题模块 , 用于在 Java 中使用 IntelliJ 样式的桌面应用
//                api("org.jetbrains.jewel:jewel-int-ui-standalone:0.39.1-262.9437.29")
//                // 是 Jewel Markdown 的 GitHub Flavored Markdown (GFM) 表格扩展模块
////            implementation("org.jetbrains.jewel:jewel-markdown-extensions-gfm-tables:0.34.0-253.32098.37")
//                // 是 Jewel Markdown 的 GitHub Flavored Markdown (GFM) Alert 扩展模块
////            implementation("org.jetbrains.jewel:jewel-markdown-extensions-gfm-alerts:0.34.0-253.32098.37")
//                // 是 Jewel UI 库的自定义装饰窗口模块
//                api("org.jetbrains.jewel:jewel-decorated-window:0.39.1-262.9437.29")
//                // ✅ 关键：自定义窗口装饰模块, 是 Jewel UI 库的 IntelliJ 风格装饰窗口模块
//                api("org.jetbrains.jewel:jewel-int-ui-decorated-window:0.39.1-262.9437.29")
//                // 是 Jewel Markdown 的自动链接扩展模块
////            implementation("org.jetbrains.jewel:jewel-markdown-extensions-autolink:0.34.0-253.32098.37")
//                // 是 Jewel Markdown 的 GitHub Flavored Markdown (GFM) 删除线扩展模块
////            implementation("org.jetbrains.jewel:jewel-markdown-extensions-gfm-strikethrough:0.34.0-253.32098.37")
//                //  是 Jewel UI 库的 IntelliJ 平台 Look and Feel (LaF) 桥接模块
////                api("org.jetbrains.jewel:jewel-ide-laf-bridge:0.13.2-ij-233")
//                // 是 Jewel Markdown 的图片加载扩展模块
////            implementation("org.jetbrains.jewel:jewel-markdown-extensions-images:0.34.0-253.32098.37")
//                // 是 Jewel Markdown 的 IntelliJ 平台 IDE LaF 桥接样式模块
////            implementation("org.jetbrains.jewel:jewel-markdown-ide-laf-bridge-styling:0.28.0-243.27100")
//                // 是 Jewel Markdown 的 IntelliJ 风格独立桌面应用样式模块
////            implementation("org.jetbrains.jewel:jewel-markdown-int-ui-standalone-styling:0.34.0-253.32098.37")
//                // 是 IntelliJ 平台的图标资源库
//                api("com.jetbrains.intellij.platform:icons:261.22158.291")

                //===================================================================

                // 是 Ktor HTTP 客户端的 Desktop 引擎（Engine）
                api(libs.ktor.client.okhttp)

                //===================================================================

                compileOnly("org.jetbrains.compose.desktop:desktop:1.11.1")
                compileOnly("org.bytedeco:javacv:1.5.14")
                compileOnly("org.bytedeco:opencv-platform:4.14.0-1.5.14")
                compileOnly("com.google.zxing:core:3.5.4")
                compileOnly("com.google.zxing:javase:3.5.4")

                //===================================================================

                // markdown项目
                // Compose Markdown Multiplatform
                compileOnly("io.coil-kt.coil3:coil-network-okhttp:3.5.0")

            }
        }

        iosMain {
            dependencies {
                // markdown项目
                // Compose Markdown Multiplatform
                implementation("io.ktor:ktor-client-darwin:3.5.2")
            }
        }

        jsMain {
            dependencies {
                api(libs.wrappers.browser)

                // markdown项目
                // Compose Markdown Multiplatform
                implementation("io.ktor:ktor-client-js-js:3.5.2")
            }
        }

        wasmJsMain {
            dependencies {
                // markdown项目
                // Compose Markdown Multiplatform
                implementation("io.ktor:ktor-client-js-wasm-js:3.5.2")
            }
        }

    }

}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}
