
<div align="center">

<h1>
  Multiplatform-Zwkfb
</h1>

**一款强大的Kotlin多平台“zwkfb”中文开发包，适用于使用Compose Multiplatform的Kotlin多平台项目。**

[![GitHub](https://jitpack.io/v/dxycw/zwkfb.svg)](https://jitpack.io/#dxycw/multiplatform-zwkfb)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.3.20-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.10.3-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-59B6EC.svg?style=flat)

</div>


> [!NOTE]
>
> 如果你使用的是Android平台的xml布局项目，请使用[zwkfb_view](https://github.com/dxycw/zwkfb_view)项目。


# 使用方法

**1、在项目的 settings.gradle 文件中添加 JitPack 仓库：**

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // 添加 JitPack 仓库
    }
}
```

**2、在项目的 build.gradle 文件中添加依赖项：**

```kotlin
dependencies {
    
    // 如果使用多平台Jetpack Compose Multiplatform，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb:0.0.1")
    
    // 如果使用 Android Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-android:0.0.1")
    
    // 如果使用 Windows Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-desktop:0.0.1")
    
    // 以下平台可以用，但目前不推荐使用
    
    // 如果使用 IOS Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-iosarm64:0.0.1")
    implementation("com.github.dxycw.zwkfb:zwkfb-iossimulatorarm64:0.0.1")
    
    // 如果使用 Web Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-js:0.0.1")
    implementation("com.github.dxycw.zwkfb:zwkfb-wasm-js:0.0.1")
    
}
```

**3、目前可以使用的平台：**

| 平台            | 是否可用 |
|---------------|------|
| Multiplatform | ✅️   |
| Android       | ✅️   |
| Desktop       | ✅️   |
| IOS           | ❌️   |
| Web           | ❌️   |

**4、使用的依赖库：**

* 本项目所有平台[使用的依赖库](%E6%96%87%E6%A1%A3/%E4%BD%BF%E7%94%A8%E7%9A%84%E4%BE%9D%E8%B5%96%E5%BA%93.md)；

**5、示例代码：**

* 本项目所有平台[示例代码](https://gitee.com/dxycw/zwkfb-multiplatform#%E9%A1%B9%E7%9B%AE%E7%9B%AE%E5%BD%95)；

> [!CAUTION]
>
>  * 项目>=0.0.1版本：
     >     因为 org.jetbrains.compose 的 [1.11.0-alpha02](https://github.com/JetBrains/compose-multiplatform/releases/tag/v1.11.0-alpha02) 版本以后去掉了ios的“x86_64”平台，所以本项目也去掉 了ios的“x86_64”平台的依赖项，所以在项目中使用时去掉ios的“x86_64”平台的依赖；
     >
     >     ```kotlin
>     listOf(
>     //    iosX64(),   // 去掉“x86_64”平台的依赖项，所以在项目中使用时去掉“x86_64”平台的依赖；
>         iosArm64(),
>         iosSimulatorArm64()
>     ).forEach { iosTarget ->
>         // 略
>     }



# 更新内容

## 0.0.1

* 创建项目，发布第一个版本；
* 完善项目文档，添加使用方法、平台支持、依赖库等信息；
