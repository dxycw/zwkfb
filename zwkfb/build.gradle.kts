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
        namespace = "multiplatform.zwkfb"
        compileSdk {
            version = release(36) {
                minorApiLevel = 1
            }
        }
        minSdk = 24

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }

        withHostTestBuilder {}

        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
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

                api("org.jetbrains.compose.runtime:runtime:1.11.1")
                api("org.jetbrains.compose.foundation:foundation:1.11.1")
                //     api("org.jetbrains.compose.material:material:1.11.1")
                api("org.jetbrains.compose.material3:material3:1.11.0-alpha07")
                api("org.jetbrains.compose.ui:ui:1.11.1")
                api("org.jetbrains.compose.ui:ui-tooling-preview:1.11.1")
                api("org.jetbrains.compose.ui:ui-graphics:1.11.1")
                api("org.jetbrains.compose.components:components-resources:1.11.1")

                api("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0-beta01")
                api("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.11.0-beta01")
                // 图标库，包含 org.jetbrains.compose.material:material-icons-core 里面的图标
                api("org.jetbrains.compose.material:material-icons-extended:1.7.3")
                api("org.jetbrains.androidx.navigation:navigation-compose:2.9.2")

                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")

                // Composables UI 是一套现代化、完全可访问的 Jetpack Compose 和 Compose 多平台组件集合。
                // https://composables.com/ui/docs/overview
//                api("com.composables:ui:0.1.0")

            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                api("androidx.activity:activity-compose:1.13.0")

                api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.11.0")
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.core)
                implementation(libs.androidx.runner)
                implementation(libs.androidx.testExt.junit)
            }
        }

        val desktopMain by getting{
            dependencies {
                implementation(compose.desktop.currentOs)

                api("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.11.0")
//                api("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.11.0")

                // JNA 核心库
                api("net.java.dev.jna:jna:5.19.0")
                // JNA Platform（包含 Windows API、POSIX 等封装）
                api("net.java.dev.jna:jna-platform:5.19.0")


                api("com.formdev:flatlaf:3.7.1")
//                api("com.formdev:flatlaf-extras:3.7.1")
//                api("com.formdev:flatlaf-intellij-themes:3.7.1")
//                api("com.formdev:flatlaf-jide-oss:3.7.1")
//                api("com.formdev:flatlaf-swingx:3.7.1")
//                api("com.formdev:flatlaf-fonts-inter:4.1")
//                api("com.formdev:flatlaf-fonts-jetbrains-mono:2.304")
//                api("com.formdev:flatlaf-fonts-roboto:2.137")
//                api("com.formdev:flatlaf-fonts-roboto-mono:3.000")


//                val platform = when {
//                    org.gradle.internal.os.OperatingSystem.current().isWindows -> "win"
//                    org.gradle.internal.os.OperatingSystem.current().isMacOsX ->
//                        if (System.getProperty("os.arch") == "aarch64") "mac-aarch64" else "mac"
//                    org.gradle.internal.os.OperatingSystem.current().isLinux ->
//                        if (System.getProperty("os.arch") == "aarch64") "linux-aarch64" else "linux"
//                    else -> throw GradleException("Unsupported platform")
//                }
//
//                // 所有 JavaFX 模块，带平台分类器
//                listOf(
//                    "javafx-base","javafx-graphics", "javafx-controls", "javafx-fxml",
//                    "javafx-web", "javafx-media", "javafx-swing"
//                ).forEach { module ->
//                    api("org.openjfx:$module:21:$platform")
//                }

            }
        }

        iosMain {
            dependencies {}
        }

        jsMain {
            dependencies {
                api("org.jetbrains.kotlin-wrappers:kotlin-browser:2026.6.3")
            }
        }

        wasmJsMain {
            dependencies {}
        }

    }

}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}