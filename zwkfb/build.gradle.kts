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

                // 这个库属于 Compose Multiplatform 生态，为 Compose 提供与 ViewModel 的集成支持。
                api(libs.androidx.lifecycle.viewmodelCompose)
                // 这个库属于 Compose Multiplatform 生态，为 Compose 提供与 Runtime 的集成支持。
                api(libs.androidx.lifecycle.runtimeCompose)
                // 这个库属于 Compose Multiplatform 生态，为 Navigation3 提供与 ViewModel 的集成支持。
                api(libs.androidx.lifecycle.viewmodelNavigation3)

                // 图标库，包含 org.jetbrains.compose.material:material-icons-core 里面的图标
                api(libs.compose.material.iconsExtended)

                // 这是一个 Compose Multiplatform 的navigation导航库
                api(libs.androidx.navigation.compose)
                // 这是一个 Compose Multiplatform 的navigation3导航库
                api(libs.androidx.navigation3.ui)

                // 是 Kotlin 协程（Coroutines）的核心库
                api(libs.kotlinx.coroutinesCore)

                // 是 Kotlin 官方的多平台 JSON 序列化库
                api(libs.kotlinx.serialization)

                // 是 Kotlin Multiplatform 版本的 CommonMark Markdown 解析与渲染库
                api(libs.feiyin0719.commonmark)

                // 是 JetBrains 官方用 Kotlin 编写的 Markdown 解析库
                api(libs.jetbrains.markdown)

                // 是 Kotlin Multiplatform 语法高亮引擎
                api(libs.snipme.highlights)

                // 是一套现代化、完全可访问的 Jetpack Compose 和 Compose 多平台组件集合。
//                api("com.composables:ui:0.2.0")


                // markdown项目
                implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.5.1")
                implementation("io.coil-kt.coil3:coil-compose:3.5.0")

                // Compose Markdown Multiplatform
                implementation("io.github.feiyin0719:commonmark-ext-gfm-tables:0.0.2")
                implementation("io.github.feiyin0719:commonmark-ext-autolink:0.0.2")
                implementation("io.github.feiyin0719:commonmark-ext-task-list-items:0.0.2")
                implementation("io.github.feiyin0719:commonmark-ext-html-converter:0.0.2")
                implementation("io.coil-kt.coil3:coil-network-ktor3:3.5.0")


                implementation("io.ktor:ktor-client-core:3.5.2")

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


                // markdown项目
                // Compose Markdown Multiplatform
                implementation("androidx.core:core-ktx:1.19.0")
                implementation("io.ktor:ktor-client-okhttp:3.5.2")

                // multiplatform-markdown-renderer
                implementation("io.coil-kt:coil-compose:2.7.0")



                implementation("io.coil-kt.coil3:coil-network-okhttp:3.5.0")
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

                api(libs.kotlinx.coroutinesSwing)
//                api("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.11.0")

                // JNA 核心库
                api(libs.dev.jna)
                // JNA Platform（包含 Windows API、POSIX 等封装）
                api(libs.dev.jnaPlatform)

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


                // markdown项目
                // Compose Markdown Multiplatform
                implementation("io.ktor:ktor-client-okhttp:3.5.2")

                implementation("io.ktor:ktor-client-cio:3.5.2")

                implementation("io.coil-kt.coil3:coil-network-okhttp:3.5.0")
            }

        }

        iosMain {
            dependencies {
                // markdown项目
                // Compose Markdown Multiplatform
                implementation("io.ktor:ktor-client-darwin:3.5.1")
            }
        }

        jsMain {
            dependencies {
                api(libs.wrappers.browser)

                // markdown项目
                // Compose Markdown Multiplatform
                implementation("io.ktor:ktor-client-js:3.5.1")
            }
        }

        wasmJsMain {
            dependencies {
                // markdown项目
                // Compose Markdown Multiplatform
                implementation("io.ktor:ktor-client-js:3.5.1")
            }
        }

    }

}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}
