<div align="center">

<h1>
  Multiplatform-Zwkfb
</h1>

**一款强大的Kotlin多平台“zwkfb”中文开发包，适用于使用Compose Multiplatform的Kotlin多平台项目。**

[![GitHub](https://jitpack.io/v/dxycw/zwkfb.svg)](https://jitpack.io/#dxycw/multiplatform-zwkfb)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.3.20-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.11.0--beta03-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-59B6EC.svg?style=flat)

</div>

> [!NOTE]
>
> 如果你使用的是Android平台的xml布局项目，请使用[zwkfb-view](https://github.com/dxycw/zwkfb-view)项目。
>
> 如果你使用的是Jetpack Compose项目，请使用[zwkfb-compose](https://github.com/dxycw/zwkfb-compose)（注意：此项目已经停更了目前还可以使用，也可以使用Compose Multiplatform项目）。

# 使用方法

**1、在项目的 settings.gradle 文件中添加 JitPack 仓库：**

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven("https://jitpack.io")  // 添加 JitPack 仓库
    }
}
```

**2、在项目的 build.gradle 文件中添加依赖项：**

```kotlin
dependencies {
    
    // 如果使用多平台Jetpack Compose Multiplatform，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb:0.1.1")
    
    // 如果使用 Android Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-android:0.1.1")
    
    // 如果使用 Windows Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-desktop:0.1.1")
    
    // 以下平台可以用，但目前不推荐使用
    
    // 如果使用 IOS Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-iosarm64:0.1.1")
    implementation("com.github.dxycw.zwkfb:zwkfb-iossimulatorarm64:0.1.1")
    
    // 如果使用 Web Jetpack Compose，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-js:0.1.1")
    implementation("com.github.dxycw.zwkfb:zwkfb-wasm-js:0.1.1")
    
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
>* 项目>=0.0.4版本：
>    从本版本开始 Android平台 和 Desktop平台 的 jvmTarget 修改为 JVM_11；
>
>* 项目>=0.0.3版本：
>    从本版本开始修复 Web(js\wasm-js)平台运行报错的Bug（请升级到0.0.3版本以上，否则Web平台无法运行）；
>
>    注意：请修改项目 `gradle` 文件夹里面的 `libs.versions.toml` 文件中 `composeMultiplatform` 的版本为 `1.11.0-beta03` 否则Web平台无法运行。
>    ```toml
>    [versions]
>    # ...
>    composeMultiplatform = "1.11.0-beta03"  # 把它改成 1.11.0-beta03
>    # ...
>    ```
>   
>* 项目>=0.0.2版本：
>   因为 org.jetbrains.compose 的 [1.11.0-alpha02](https://github.com/JetBrains/compose-multiplatform/releases/tag/v1.11.0-alpha02) 版本以后去掉了ios的“x86_64”平台，所以本项目也去掉 了ios的“x86_64”平台的依赖项，所以在项目中使用时去掉ios的“x86_64”平台的依赖；
>
>   ```kotlin
>   listOf(
>   //    iosX64(),   // 去掉“x86_64”平台的依赖项，所以在项目中使用时去掉“x86_64”平台的依赖；
>       iosArm64(),
>       iosSimulatorArm64()
>   ).forEach { iosTarget ->
>       // 略
>   }
>   ```
>   
>* 项目==0.0.1版本：
>   本版本不能用；

# 更新内容

## 0.1.1

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 两个“提示条()”、“安全文本字段()”、“轮廓安全文本字段()”、“基础安全文本字段()”、“下拉刷新盒子()” 函数组件；
* 添加 Multiplatform平台的 “提示条默认值”、“文本混淆模式”、“下拉刷新默认值” 对象类；
* 添加 Multiplatform平台的 “键盘选项” 函数类；
* 添加 Multiplatform平台的 “下拉刷新状态” 接口类；
* 添加 Multiplatform平台的 “记住下拉刷新状态()”、“下拉刷新状态()” 函数；
* 添加 Multiplatform平台的 Modifier “下拉刷新()” 函数；

## 0.1.0

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 更新 gradle 版本为 9.4.1；
* 更新 Multiplatform平台的 org.jetbrains.compose.runtime:runtime 依赖库版本为 1.11.0；
* 更新 Multiplatform平台的 org.jetbrains.compose.foundation:foundation 依赖库版本为 1.11.0；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui 依赖库版本为 1.11.0；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui-tooling-preview 依赖库版本为 1.11.0；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui-graphics 依赖库版本为 1.11.0；
* 更新 Multiplatform平台的 org.jetbrains.compose.components:components-resources 依赖库版本为 1.11.0；
* 更新 Multiplatform平台的 org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose 依赖库版本为 2.11.0-beta01；
* 更新 Multiplatform平台的 org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose 依赖库版本为 2.11.0-beta01；

# 老版本更新内容

* [0.0.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.0.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)