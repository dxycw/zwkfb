import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    jvm()
    
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
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(projects.zwkfb)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}

android {

    // 签名配置
    signingConfigs {
        create("release") {
            storeFile = file("../key.jks")
            storePassword = "12345678"
            keyAlias = "key"
            keyPassword = "12345678"
        }
    }

    namespace = "com.dxyc.zwkfb"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.dxyc.zwkfb"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    // ABI分割
    splits {
        abi {
            isEnable = true // 是否开启ABI分割
            reset()  // 清空默认的abi配置
            include("armeabi-v7a", "arm64-v8a", "x86", "x86_64") // 指定要支持的ABI
            isUniversalApk = false     // 是否生成通用apk
        }
    }

    // 修改输出文件名
    applicationVariants.all {
        outputs.all {
            val output = this as BaseVariantOutputImpl
            // 获取当前 APK 对应的 ABI（架构）
            val abi = output.filters.find { it.filterType == "ABI" }?.identifier ?: "universal"

            // 构建时间
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmm", Locale.getDefault()).format(Date())

            output.outputFileName = "中文开发包-${versionName}-${abi}-${timeStamp}.apk" // -${buildType.name}
        }
    }

    // 混淆配置
    buildTypes {
        getByName("release") {
//            isMinifyEnabled = false

            isMinifyEnabled = true // 是否混淆
            isShrinkResources = true // 是否压缩资源
            signingConfig = signingConfigs.getByName("release")
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "com.dxyc.zwkfb.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "中文开发包"
            packageVersion = "1.0.0"
        }
    }
}
