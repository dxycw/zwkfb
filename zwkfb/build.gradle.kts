import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)

    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("maven-publish")
}

kotlin {

    androidLibrary {
        namespace = "multiplatform.zwkfb"
        compileSdk = 36
        minSdk = 24

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
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
//            isStatic = true
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

                api("org.jetbrains.compose.runtime:runtime:1.11.0")
                api("org.jetbrains.compose.foundation:foundation:1.11.0")
                //     api("org.jetbrains.compose.material:material:1.11.0-rc01")
                api("org.jetbrains.compose.material3:material3:1.11.0-alpha07")
                api("org.jetbrains.compose.ui:ui:1.11.0")
                api("org.jetbrains.compose.ui:ui-tooling-preview:1.11.0")
                api("org.jetbrains.compose.ui:ui-graphics:1.11.0")
                api("org.jetbrains.compose.components:components-resources:1.11.0")

                api("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0-beta01")
                api("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.11.0-beta01")
                // 图标库，包含 org.jetbrains.compose.material:material-icons-core 里面的图标
                api("org.jetbrains.compose.material:material-icons-extended:1.7.3")
                api("org.jetbrains.androidx.navigation:navigation-compose:2.9.2")

//                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")

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

                // 本库的预览界面依赖库，
//                implementation("org.jetbrains.compose.ui:ui-tooling:1.11.0-rc01")
//                implementation("androidx.customview:customview-poolingcontainer:1.0.0")
//                implementation("androidx.emoji2:emoji2:1.5.0")
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
            }
        }

        iosMain {
            dependencies {
                // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
                // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
                // part of KMP’s default source set hierarchy. Note that this source set depends
                // on common by default and will correctly pull the iOS artifacts of any
                // KMP dependencies declared in commonMain.
            }
        }

        jsMain {
            dependencies {}
        }

        wasmJsMain {
            dependencies {}
        }

    }

}