
> [!CAUTION]
>
> **注意：本库是本作者个人私库（不公开分享本库，不建议他人使用），如果想使用本库可以在项目中使用依赖库或克隆分支（可以自己新建一个分支修改本库，不可提交到本库），请不要上传提交，请勿私自外传本项目。**


<div align="center">

<h1>
  Compose Multiplatform Zwkfb
</h1>

**一款强大的Kotlin多平台“zwkfb”中文开发包，适用于 Compose Multiplatform 的 Kotlin 多平台项目。**

[![GitHub](https://jitpack.io/v/dxycw/zwkfb.svg)](https://jitpack.io/#dxycw/multiplatform-zwkfb)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.4.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.12.0--beta01-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-59B6EC.svg?style=flat)

</div>

> [!NOTE]
>
> 如果你使用的是 Android平台的xml布局项目，请使用[zwkfb-view](https://github.com/dxycw/zwkfb-view)项目。

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

**2、在项目的 build.gradle 文件中添加依赖项（注意：添加任意一个平台即可）：**

```kotlin

kotlin {
    //...
    sourceSets {
        // 只添加 Android 平台，其他的可以不用添加
        androidMain.dependencies {
            // 如果使用 Android平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-android:0.3.1")
        }
        // 只添加 多平台，其他的可以不用添加
        commonMain.dependencies {
            // 如果使用多平台 Jetpack Compose Multiplatform 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb:0.3.1")
        }
        // 只添加 Desktop 平台，其他的可以不用添加
        jvmMain.dependencies {
            // 如果使用 Desktop平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-desktop:0.3.1")
        }

        // 以下平台可以用，但目前不推荐使用
        // 只添加 iOS 平台，其他的可以不用添加
        iosMain.dependencies {
            // 如果使用 IOS平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-iosarm64:0.3.1")
            implementation("com.github.dxycw.zwkfb:zwkfb-iossimulatorarm64:0.3.1")
        }
        // 只添加 web的js 平台，其他的可以不用添加
        jsMain.dependencies {
            // 如果使用 Web的js平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-js:0.3.1")
        }
        // 只添加 web的wasmJs 平台，其他的可以不用添加
        wasmJsMain.dependencies {
            // 如果使用 Web的wasmjs平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-wasm-js:0.3.1")
        }
        
    }
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

**5、打包体积压缩：**

* 本项目所有平台[打包体积压缩](%E6%96%87%E6%A1%A3/%E6%89%93%E5%8C%85%E4%BD%93%E7%A7%AF%E5%8E%8B%E7%BC%A9.md)；

**6、示例代码：**

* 本项目所有平台[示例代码](https://gitee.com/dxycw/zwkfb-jiaocheng)；

> [!CAUTION]
>
> * 项目>=0.3.0版本：
>
>   1、从本版本发布开始请使用 Jetpack Compose Multiplatform 的新项目模板。
>
>   2、从本版本发布开始请更新 compileSdk 为 37 版本以上否则报错。
>
>   ```kotlin
>   android {
>       compileSdk = 37
>   }
>   ```
>   
>   3、更新 项目的 “libs.versions.toml” 文件 的 “composeMultiplatform” 版本为 1.12.0-beta01 以上否则可能报错。
> 
>   ```kotlin
>   [versions]
>   composeMultiplatform = "1.12.0-beta01"
>   ```


# 更新内容

## 0.3.1

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “盒子带约束()” 函数组件；
* 添加 Multiplatform平台的 五个“记住可保存()”、“约束()” 函数；
* 添加 Multiplatform平台的 “盒子带约束范围” 接口类；
* 添加 Multiplatform平台的 “约束” 对象类；
* 移动 Multiplatform平台的 “间隔器”组件移动到“安卓x.组合.基础.布局”下；
* 添加 Multiplatform平台的 BoxWithConstraintsScope "约束"、“最小宽度”、“最大宽度”、"最小高度"、“最大高度” 属性函数；
* 添加 Multiplatform平台的 Constraints "最小宽度"、“最大宽度”、“最小高度”、"最大高度"、“有边界宽度”、“有边界高度”、“有固定宽度”、“有固定高度”、“是否零”、“复制()”、“复制最大尺寸()”、两个“约束()”、“约束宽度()”、“约束高度()”、“是否满足()”、“偏移量()” 属性函数；
* 添加 Multiplatform平台的 org.jetbrains.androidx.navigation3:navigation3-ui 依赖库版本为 1.2.0-alpha02；
* 添加 Multiplatform平台的 org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-navigation3 依赖库版本为 2.11.0-rc01；
* 更新 Desktop平台的 com.formdev:flatlaf 依赖库版本为 3.7.2；
* 更新 Desktop平台的 com.formdev:flatlaf-extras 依赖库版本为 3.7.2；
* 更新 Desktop平台的 com.formdev:flatlaf-intellij-themes 依赖库版本为 3.7.2；
* 更新 Web的js平台的 org.jetbrains.kotlin-wrappers:kotlin-browser 依赖库版本为 2026.7.1；

## 0.3.0

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 重新项目，之前的项目编译失败重新创建项目。
* 添加 Multiplatform平台的 “导航主机()”、两个“选择容器()” 函数组件；
* 添加 Multiplatform平台的 “按钮颜色集()”、“按钮形状集()”、“对话框属性()”、“图标按钮颜色集()”、“图标切换按钮颜色集()”、“图标按钮形状集()”、“图标切换按钮形状集()”、“提示条主机状态()”、“记住底部面板状态()” 函数；
* 添加 Multiplatform平台的 “材质主题” 对象类；
* 添加 Multiplatform平台的 “顶部应用栏滚动行为”、“提示条视觉效果”、“提示条数据” 接口类；
* 添加 Multiplatform平台的 ButtonColors “容器颜色”、“内容颜色”、“禁用容器颜色”、“禁用内容颜色”、“复制()” 属性函数；
* 添加 Multiplatform平台的 ButtonShapes “形状”、“按压形状”、“复制()” 属性函数；
* 添加 Multiplatform平台的 DeferredTransition “延迟动画可见性()” 函数；
* 添加 Multiplatform平台的 AnimatedVisibilityScope "过渡" 属性函数；
* 添加 Multiplatform平台的 DialogProperties "关闭返回键回调"、“关闭单击外部回调”、“使用平台默认宽度” 属性函数；
* 添加 Multiplatform平台的 PullToRefreshState "距离比例"、“是否正在动画”、"动画到阈值()"、“动画到隐藏()”、“吸附到()” 属性函数；
* 添加 Multiplatform平台的 SwitchColors "已选中滑块颜色"、“已选中轨道颜色”、“已选中边框颜色”、“已选中图标颜色”、“未已选中滑块颜色”、“未已选中轨道颜色”、“未已选中边框颜色”、“未已选中图标颜色”、“禁用已选中滑块颜色”、“禁用已选中轨道颜色”、“禁用已选中边框颜色”、“禁用已选中图标颜色”、“禁用未已选中滑块颜色”、“禁用未已选中轨道颜色”、“禁用未已选中边框颜色”、“禁用未已选中图标颜色” 属性函数；
* 添加 Multiplatform平台的 IconButtonColors "容器颜色"、“内容颜色”、“禁用容器颜色”、“禁用内容颜色”、"复制()" 属性函数；
* 添加 Multiplatform平台的 IconToggleButtonColors "容器颜色"、“内容颜色”、“禁用容器颜色”、“禁用内容颜色”、“已选中容器颜色”、“已选中内容颜色”、"复制()" 属性函数；
* 添加 Multiplatform平台的 IconButtonShapes "形状"、“按压形状”、"复制()" 属性函数；
* 添加 Multiplatform平台的 IconToggleButtonShapes "形状"、“按压形状”、“已选中形状”、"复制()" 属性函数；
* 更新 Gradle 版本为 9.6.1；

# 老版本更新内容

* [0.0.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.0.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)
* [0.1.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.1.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)
* [0.2.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.2.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)
