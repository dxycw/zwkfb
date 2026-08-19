import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
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
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
    
    android {
        namespace = "com.dxyc.zwkfb.app.shared"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

//        aarMetadata {
//            minCompileSdk = 37  // 但这对上游依赖无效
//        }
    
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

        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
        }

        commonMain.dependencies {

            api(project(":zwkfb")){

                // 是 Compose Multiplatform 的基础库，提供基础的 UI 组件和工具库，包含基础的布局、文本、按钮、文本输入框、下拉列表等组件。
//                exclude("org.jetbrains.compose.material", "material")
                // 如果使用图标，请把material-icons-extended依赖库注释掉
//                exclude("org.jetbrains.compose.material", "material-icons-extended")

                // 这是一个 Compose Multiplatform 的导航库
                exclude("org.jetbrains.androidx.navigation3", "navigation3-ui")
                // 这个库属于 Compose Multiplatform 生态，为 Navigation3 提供与 ViewModel 的集成支持。
                exclude("org.jetbrains.androidx.lifecycle", "lifecycle-viewmodel-navigation3")

                // 是 Kotlin 协程（Coroutines）的核心库
                exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-core")

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

            }

            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            // required for coil
//            implementation("io.coil-kt.coil3:coil-network-ktor3:3.5.0")
//            implementation("io.coil-kt.coil3:coil-svg:3.5.0")

            // about libs
            api("com.mikepenz:aboutlibraries-compose-core:15.0.3")
            api("com.mikepenz:aboutlibraries-compose-m3:15.0.3")
            api("com.mikepenz:aboutlibraries-core:15.0.3")


            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.8.0")

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jsMain.dependencies {
            implementation(libs.wrappers.browser)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}