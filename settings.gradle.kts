@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
//        maven { url = uri("https://jitpack.io") }  // 添加 JitPack 仓库
//        maven { url = uri("https://maven.mozilla.org/maven2") } // 使用org.mozilla.geckoview依赖库需要添加此仓库

//        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//        maven("https://packages.jetbrains.team/maven/p/kpm/public/")
//
//        maven("https://www.jetbrains.com/intellij-repository/releases")
//        maven("https://www.jetbrains.com/intellij-repository/snapshots")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "Zwkfbmultiplatform"

include(":app:androidApp")
include(":app:desktopApp")
include(":app:shared")
include(":app:webApp")

include(":zwkfb")