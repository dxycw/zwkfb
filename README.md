
> [!CAUTION]
>
> **注意：本库是本作者个人私库（不公开分享本库，不建议他人使用），如果想使用本库可以在项目中使用依赖库或克隆分支（可以自己新建一个分支修改本库，不可提交到本库），请不要上传提交，请勿私自外传本项目。**


<div align="center">

<h1>
  Compose Multiplatform Zwkfb
</h1>

**一款强大的Kotlin多平台“zwkfb”中文开发包，适用于 Compose Multiplatform 的 Kotlin 多平台项目。**

[![Maven Central](https://img.shields.io/maven-central/v/io.github.dxycw/zwkfb?label=Maven%20Central&color=orange)](https://central.sonatype.com/artifact/io.github.dxycw/zwkfb)
[![GitHub](https://jitpack.io/v/dxycw/zwkfb.svg)](https://jitpack.io/#dxycw/zwkfb)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.4.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.13.0--beta02-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-59B6EC.svg?style=flat)

</div>

> [!NOTE]
>
> 如果你使用的是 Android平台的xml布局项目，请使用[zwkfb-view](https://github.com/dxycw/zwkfb-view)项目。

# 使用方法

**1、在项目中添加依赖项的方法：**

- Maven Central 仓库：

```kotlin

// 在项目的 build.gradle.kts 文件中添加依赖项
kotlin {
    sourceSets {
        // 多平台，
        commonMain.dependencies {
            // 如果使用多平台 Jetpack Compose Multiplatform 项目，请添加以下依赖项
            implementation("io.github.dxycw:zwkfb:0.5.0")
        }
    }
}

```

- JitPack 仓库：

```kotlin

// 在项目的 settings.gradle.kts 文件中添加 JitPack 仓库
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // 添加 JitPack 仓库
    }
}

// 在项目的 build.gradle.kts 文件中添加依赖项
kotlin {
    sourceSets {
        // 多平台，
        commonMain.dependencies {
            // 如果使用多平台 Jetpack Compose Multiplatform 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb:0.4.9")
        }
    }
}

```

**2、目前可以使用的平台：**

| 平台                              | 是否可用 |
|-----------------------------------|----------|
| Android                           | ✅️       |
| Desktop (Windows, MacOS, Linux)   | ✅️       |
| IOS (iosArm64, iosSimulatorArm64) | ✅️       |
| Web (WasmJS, JS)                  | ✅️       |

**3、打开本项目所有平台的[使用的依赖库](%E6%96%87%E6%A1%A3/%E4%BD%BF%E7%94%A8%E7%9A%84%E4%BE%9D%E8%B5%96%E5%BA%93.md)；**

**4、打开本项目所有平台的[打包体积压缩](%E6%96%87%E6%A1%A3/%E6%89%93%E5%8C%85%E4%BD%93%E7%A7%AF%E5%8E%8B%E7%BC%A9.md)；**

**5、打开本项目所有平台[示例代码](https://gitee.com/dxycw/zwkfb-jiaocheng)；**


> [!CAUTION]
>
>* 项目>=0.5.0版本：
>
>   1、从本版本发布开始请使用 Jetpack Compose Multiplatform 的新项目模板；
>
>   2、发布到 Maven Central 仓库；
>   
>   3、从本版本开始不会发布到 JitPack 仓库(除非特殊需求)；
>
>   4、本版本没有内容只有库；
>
>   5、不推荐使用JitPack 仓库，因为JitPack 仓库的版本是不稳定的，可能会有错误。
>
>   6、composeMultiplatform 推荐和本项目相同， composeMultiplatform版本为 1.13.0-*， Desktop的Window函数的icon使用 painterResource("drawable/...")不能用报错，这是 composeMultiplatform 1.13.0 版本的一个 bug。
>
>   7、如果使用 org.jetbrains.kotlinx:kotlinx-serialization-json 依赖库[官方教程](https://github.com/Kotlin/kotlinx.serialization)，请在项目中添加以下插件项：
>
>    ```kotlin
>    plugins {
>       kotlin("plugin.serialization") version "${和项目kotlin的版本一样}"
>    }
>   ```


# 更新内容

## 0.5.0

* 发布到 Maven Central 仓库；
* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 本版本没有内容只有库；
* 从本版本开始不会发布到 JitPack 仓库(除非特殊需求)；
* composeMultiplatform 推荐和本项目相同；


# 老版本更新内容

* [0.0.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.0.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)
* [0.1.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.1.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)
* [0.2.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.2.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)
* [0.3.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.3.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)
* [0.4.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.4.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)