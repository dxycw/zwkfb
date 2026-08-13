
> [!CAUTION]
>
> **注意：本库是本作者个人私库（不公开分享本库，不建议他人使用），如果想使用本库可以在项目中使用依赖库或克隆分支（可以自己新建一个分支修改本库，不可提交到本库），请不要上传提交，请勿私自外传本项目。**


<div align="center">

<h1>
  Compose Multiplatform Zwkfb
</h1>

**一款强大的Kotlin多平台“zwkfb”中文开发包，适用于 Compose Multiplatform 的 Kotlin 多平台项目。**

[![GitHub](https://jitpack.io/v/dxycw/zwkfb.svg)](https://jitpack.io/#dxycw/zwkfb)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.4.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.12.0--beta03-blue)](https://github.com/JetBrains/compose-multiplatform)

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
            implementation("com.github.dxycw.zwkfb:zwkfb:0.3.7")
        }
    }
}

```

**2、目前可以使用的平台：**

| 平台                                | 是否可用 |
|-----------------------------------|------|
| Android                           | ✅️   |
| Desktop (Windows, MacOS, Linux)   | ✅️   |
| IOS (iosArm64, iosSimulatorArm64) | ❌️   |
| Web (WasmJS, JS)                  | ❌️   |

**3、使用的依赖库：**

* 本项目所有平台[使用的依赖库](%E6%96%87%E6%A1%A3/%E4%BD%BF%E7%94%A8%E7%9A%84%E4%BE%9D%E8%B5%96%E5%BA%93.md)；

**4、打包体积压缩：**

* 本项目所有平台[打包体积压缩](%E6%96%87%E6%A1%A3/%E6%89%93%E5%8C%85%E4%BD%93%E7%A7%AF%E5%8E%8B%E7%BC%A9.md)；

**5、示例代码：**

* 本项目所有平台[示例代码](https://gitee.com/dxycw/zwkfb-jiaocheng)；

> [!CAUTION]
>
> * 项目>=0.3.6版本：
> 
>   如果使用 org.jetbrains.kotlinx:kotlinx-serialization-json 依赖库[官方教程](https://github.com/Kotlin/kotlinx.serialization)，请在项目中添加以下插件项：
> 
>   ```kotlin
>   plugins {
>       kotlin("plugin.serialization") version "${和项目kotlin的版本一样}"
>   }
>   ```
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

## 0.3.7

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “弹性盒子()”、“网格()” 函数组件；
* 添加 Multiplatform平台的 三个“弹性盒子配置()”、三个“弹性配置()” 函数；
* 添加 Multiplatform平台的 “弹性方向”、“弹性换行”、“弹性对齐项集”、“弹性对齐自身”、“弹性对齐内容”、“弹性主轴内容”、“弹性基础”、“网格流式”、“网格轨道大小” 对象类；
* 添加 Multiplatform平台的 “弹性盒子范围”、“弹性盒子配置”、“弹性盒子配置范围”、“弹性配置”、“弹性配置范围”、“网格范围”、“网格配置范围” 接口类；
* 添加 Multiplatform平台的 FlexBoxConfigScope “约束”、“方向()”、“换行()”、“主轴内容()”、三个“对齐项集()”、“对齐内容()”、“行间隙()”、“列间隙()”、两个“间隙()” 属性函数；
* 添加 Multiplatform平台的 FlexConfigScope “弹性盒子主轴最大”、“弹性盒子主轴最小”、“弹性盒子交叉轴最大”、“弹性盒子交叉轴最小”、三个“对齐自身()”、“顺序()”、“增长()”、“收缩()”、三个“基础()” 属性函数；
* 添加 Multiplatform平台的 GridConfigurationScope “约束”、“流式”、四个“列()”、四个“行()”、两个“区域()”、两个“间隙()”、“列间隙()”、“行间隙()”、“最小最大()”、“列数()”、“行数()” 属性函数；
* 添加 Multiplatform平台的 自定义的 “流式列表多芯片()”、“列表多芯片()” 函数组件；

## 0.3.6

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 自定义的 “底部面板默认值”的“拖动手柄()”、“线性进度指示器()”、“取下载网址文件名()”、“圆形进度指示器()”、两个“图标()”、“顶部应用栏()”、“底部导航栏()”、“信息底部面板()” 函数组件；
* 添加 Desktop平台和Android平台的 自定义的 两个“图标()” 函数组件；
* 添加 Android平台的 自定义的 “是否竖屏()”、“是否横屏()”、“强制横屏()”、“强制竖屏()”、“取屏幕宽度()”、“取屏幕高度()”、“取屏幕宽度像素()”、“取屏幕高度像素()” 函数组件；
* 添加 Android平台的 自定义的 “是否竖屏”、“是否横屏”、“屏幕宽度”、“屏幕高度”、“屏幕宽度像素”、“屏幕高度像素” 函数属性；
* 添加 Multiplatform平台的 org.jetbrains.kotlinx:kotlinx-serialization-json 依赖库版本为 1.1.0；
* 更新 Multiplatform平台的 composeMultiplatform 依赖库版本为 1.12.0-beta03；
* 更新 Web的js平台的 org.jetbrains.kotlin-wrappers:kotlin-browser 依赖库版本为 2026.8.0；
* 删除 不需要的插件；

## 0.3.5

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 取消 本项目的 `markdown` 库发布，并删除 `markdown` 库；
* 添加 把 `markdown`项目导入到 `zwkfb`项目中；
* 添加 Multiplatform平台的 io.github.feiyin0719:commonmark 依赖库版本为 0.0.2；
* 添加 Multiplatform平台的 org.jetbrains:markdown 依赖库版本为 0.7.8；
* 添加 Multiplatform平台的 dev.snipme:highlights 依赖库版本为 1.1.0；

## 0.3.4

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “辅助芯片()”、“凸起辅助芯片()”、“建议芯片()”、“凸起建议芯片()” 函数组件,可以长按；
* 添加 Multiplatform平台的 图标集.填充 “菜单”、“设置” 属性函数；
* 添加 Multiplatform平台的 “材质图标()” 函数；
* 添加 Multiplatform平台的 “图标集” 对象类；
* 添加 Multiplatform平台的 ImageVector.Builder “材质路径()” 函数；
* 添加 Android平台的 两个“注册返回键回调事件()”、“按两次返回桌面()”、两个“注册返回键两次回调事件()” 函数；
* 删除 “server” 和 “core” 两个模块；
* 删除 “logback”、“ktor-serverCore”、“ktor-serverNetty”、“ktor-serverTestHost”和“kotlin-testJunit” 依赖库；
* 新建 `markdown` 库，把 "io.github.feiyin0719:markdown-multiplatform:0.3.0" 和 "com.mikepenz:multiplatform-markdown-renderer:0.43.0" 依赖库导入到 `markdown` 项目中；
* 添加 把 `markdown` 项目导入到本项目中，如果不用可以注释掉，在[打包体积压缩](%E6%96%87%E6%A1%A3/%E6%89%93%E5%8C%85%E4%BD%93%E7%A7%AF%E5%8E%8B%E7%BC%A9.md)查看；

## 0.3.3

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 修改 项目包名，从 multiplatform.zwkfb 改为 com.zwkfb；
* 修改 Multiplatform平台的 "组件变灰()" 函数组件为 “组件变灰提示盒子()”、“组件变灰提示行()”、“组件变灰提示列()” 函数组件代码;
* 添加 Android平台的 “浏览器()”组件函数（注意：浏览器目前是测试阶段有Bug不建议使用）；
* 添加 Multiplatform平台的 org.jetbrains.compose.material:material 依赖库版本为 1.12.0-beta02；
* 因为 com.github.dxycw.markdown:markdown 依赖库导入到项目打包失败，所以把 com.github.dxycw.markdown:markdown 依赖库导入到本项目中；
* 更新 logback 依赖库版本为 1.5.38；

## 0.3.2

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 优化依赖库导入方式；
* 修改 Multiplatform平台的 “组件变灰()” 函数组件，改为“组件变灰盒子()”、“组件变灰行()”、“组件变灰列()” 函数组件
* 更新 Multiplatform平台的 org.jetbrains.compose.runtime:runtime 依赖库版本为 1.12.0-beta02；
* 更新 Multiplatform平台的 org.jetbrains.compose.foundation:foundation 依赖库版本为 1.12.0-beta02；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui 依赖库版本为 1.12.0-beta02；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui-tooling-preview 依赖库版本为 1.12.0-beta02；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui-graphics 依赖库版本为 1.12.0-beta02；
* 更新 Multiplatform平台的 org.jetbrains.compose.components:components-resources 依赖库版本为 1.12.0-beta02；
* 更新 Multiplatform平台的 org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose 依赖库版本为 2.11.0；
* 更新 Multiplatform平台的 org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose 依赖库版本为 2.11.0；
* 添加 Multiplatform平台的 org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-navigation3 依赖库版本为 2.11.0；
* 更新 Web的js平台的 org.jetbrains.kotlin-wrappers:kotlin-browser 依赖库版本为 2026.7.4；
* 更新 AGP 版本为 9.3.1；

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
