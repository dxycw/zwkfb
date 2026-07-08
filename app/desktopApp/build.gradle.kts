import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

dependencies {
    implementation(projects.app.shared)

    implementation(compose.desktop.currentOs)
    implementation(libs.kotlinx.coroutinesSwing)

    implementation(libs.compose.uiToolingPreview)
}

compose.desktop {
    application {
        mainClass = "com.dxyc.zwkfb.MainKt"

        nativeDistributions {
            targetFormats(
                TargetFormat.Dmg,      // macOS
                TargetFormat.Msi,      // Windows
                TargetFormat.Exe,      // Windows 可执行文件
                TargetFormat.Deb,      // Linux Debian
                TargetFormat.Rpm       // Linux RedHat
            )
            packageName = "中文开发包"
            packageVersion = "0.0.1"

            macOS{
                packageVersion = "1.0.0"
            }
        }
    }
}