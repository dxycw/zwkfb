
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
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.11.1-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-59B6EC.svg?style=flat)

</div>

> [!NOTE]
>
> 如果你使用的是 Android平台的xml布局项目，请使用[zwkfb-view](https://github.com/dxycw/zwkfb-view)项目。
>
> 如果你使用的是 Jetpack Compose 项目，请使用[zwkfb-compose](https://github.com/dxycw/zwkfb-compose)（注意：此项目已经停更了目前还可以使用，也可以使用 Jetpack Compose Multiplatform项目）。

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
    
    // 如果使用多平台 Jetpack Compose Multiplatform 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb:0.1.9")
    
    // 如果使用 Android Jetpack Compose 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-android:0.1.9")
    
    // 如果使用 Desktop Jetpack Compose 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-desktop:0.1.9")
    
    // 以下平台可以用，但目前不推荐使用
    
    // 如果使用 IOS Jetpack Compose 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-iosarm64:0.1.9")
    implementation("com.github.dxycw.zwkfb:zwkfb-iossimulatorarm64:0.1.9")
    
    // 如果使用 Web Jetpack Compose 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-js:0.1.9")
    implementation("com.github.dxycw.zwkfb:zwkfb-wasm-js:0.1.9")
    
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
>* 项目>=0.1.4版本：
>
>   从本版本发布开始请使用 Jetpack Compose Multiplatform 的新项目模板。

# 更新内容

## 0.1.9

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 重置项目，老版本库构建失败重新创建新库，继承老版本更新内容；
* 更新 gradle 版本为 9.5.0；
* 更新 agp 版本为 9.2.1；
* 更新 kotlin-wrappers 版本为 2026.6.3；
* 更新 composeMultiplatform 版本为 1.11.1；
* 更新 core 版本为 1.7.0；
* 更新 androidx-core 版本为 1.19.0；
* 更新 compileSdk 版本为 37；
* 更新 Multiplatform平台的 org.jetbrains.compose.runtime:runtime 依赖库版本为 1.11.1；
* 更新 Multiplatform平台的 org.jetbrains.compose.foundation:foundation 依赖库版本为 1.11.1；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui 依赖库版本为 1.11.1；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui-tooling-preview 依赖库版本为 1.11.1；
* 更新 Multiplatform平台的 org.jetbrains.compose.ui:ui-graphics 依赖库版本为 1.11.1；
* 更新 Multiplatform平台的 org.jetbrains.compose.components:components-resources 依赖库版本为 1.11.1；
* 更新 Web的js平台的 org.jetbrains.kotlin-wrappers:kotlin-browser 依赖库版本为 2026.6.3；
* 添加 Desktop平台的 net.java.dev.jna:jna 依赖库版本为 5.19.0；
* 添加 Desktop平台的 net.java.dev.jna:jna-platform 依赖库版本为 5.19.0；

## 0.1.8

* 添加 Multiplatform平台的 “水平分页器()”、“垂直分页器()”、三个“搜索栏()”、“顶部搜索栏()”、“应用栏带搜索()”、“已展开全屏容器搜索栏()”、“已展开全屏搜索栏()”、“已展开固定搜索栏带间隙()”、“已展开固定搜索栏()”、两个“固定搜索栏()” 函数组件；
* 添加 Multiplatform平台的 两个“搜索栏状态()”、“记住搜索栏状态()”、“记住容器搜索栏状态()”、“记住带间隙搜索栏状态()”、两个“搜索栏颜色集()”、两个“应用栏带搜索颜色集()” 函数；
* 添加 Multiplatform平台的 “分页器默认值”、“搜索栏值”、“搜索栏状态”、“搜索栏默认值” 对象类；
* 添加 Multiplatform平台的 “搜索栏滚动行为” 接口类；
* 添加 Multiplatform平台的 SearchBarState “折叠坐标”、“进度”、“是否正在动画”、“目标值”、“当前值” 属性函数；
* 添加 Multiplatform平台的 SearchBarState “动画到已展开()”、“动画到已折叠()”、“吸附到()” 函数；
* 添加 Multiplatform平台的 SearchBarColors “复制()” 函数；
* 添加 Multiplatform平台的 DrawScope 三个“嵌入()”、“平移()”、“旋转()”、“旋转弧度()” 函数；

## 0.1.7

* 添加 Multiplatform平台的 两个“顶部应用栏()”、“居中对齐顶部应用栏()”、“中等顶部应用栏()”、“中等折叠顶部应用栏()”、“大型顶部应用栏()”、“大型折叠顶部应用栏()”、“双行顶部应用栏()”、四个“底部应用栏()”、“折叠底部应用栏()” 函数组件；
* 添加 Multiplatform平台的 “本地单行顶部应用栏覆盖”、“本地双行顶部应用栏覆盖” 属性函数；
* 添加 Multiplatform平台的 “记住顶部应用栏状态()”、“顶部应用栏状态()”、两个“顶部应用栏颜色集()”、“记住底部应用栏状态()”、“底部应用栏状态()” 函数；
* 添加 Multiplatform平台的 “顶部应用栏默认值”、“顶部应用栏状态”、“底部应用栏默认值”、“菜单默认值” 对象类；
* 添加 Multiplatform平台的 TopAppBarState “高度偏移量限制”、“高度偏移量”、“内容偏移量”、“折叠比例”、“重叠比例” 属性函数；
* 添加 Multiplatform平台的 TopAppBarColors “复制()” 函数；
* 更新 kotlin 和 kotlinStdlib 版本为 2.4.0；
* 更新 kotlin-wrappers 版本为 2026.6.0；

## 0.1.6

* 添加 Multiplatform平台的 “底部面板脚手架()”、“底部面板()”、“下拉菜单()”、“下拉菜单弹窗()”、“下拉菜单组()”、四个“下拉菜单项()” 函数组件；
* 新增 Multiplatform平台的 “底部面板脚手架状态()”、“记住底部面板脚手架状态()”、“记住标准底部面板状态()”、“面板状态()”、两个“菜单项颜色集()”、“菜单项形状集()”、“菜单组形状集()” 函数；
* 添加 Multiplatform平台的 SheetState “当前值”、“目标值”、“是否可见”、“是否动画正在运行”、“是否有展开状态”、“是否有部分展开状态” 属性函数；
* 添加 Multiplatform平台的 SheetState “要求偏移量()”、“展开()”、“部分展开()”、“显示()”、“隐藏()” 函数；
* 添加 Multiplatform平台的 MenuItemColors “容器颜色”、“禁用容器颜色”、“已选择容器颜色”、“已选择文本颜色”、“已选择前导图标颜色”、“已选择尾随图标颜色” 属性函数；
* 添加 Multiplatform平台的 MenuItemColors 两个“复制()” 函数；
* 添加 Multiplatform平台的 MenuItemShapes “复制()” 函数；
* 添加 Multiplatform平台的 MenuGroupShapes “复制()” 函数；
* 添加 Multiplatform平台的 “面板状态”、“面板值”、“底部面板默认值” 对象类；

## 0.1.5

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 三个“线性进度指示器()”、三个“圆形进度指示器()”、两个“加载指示器()”、两个“容器加载指示器()”、两个“分段按钮()”、“单选分段按钮行()”、“多选分段按钮行()”、“模态底部面板()” 函数组件；
* 添加 Multiplatform平台的 “本地内容颜色” 属性函数；
* 添加 Multiplatform平台的 “分段按钮颜色集()”、“模态底部面板属性集()”、“记住模态底部面板状态()” 函数；
* 添加 Multiplatform平台的 SegmentedButtonColors的“复制()” 函数；
* 添加 Multiplatform平台的 “进度指示器默认值”、“加载指示器默认值”、“模态底部面板默认值” 对象类；
* 添加 Web的js平台的 org.jetbrains.kotlin-wrappers:kotlin-browser 依赖库版本为 2026.6.0；

## 0.1.4

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 重置项目，使用 Jetpack Compose Multiplatform 官方模板更新，修复了很多Bug，请使用新项目；

## 0.1.3

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “对话框()”、两个“警告对话框()”、“基本警告对话框()”、三个“滑块()”、“垂直滑块()”、三个“范围滑块()” 函数组件；
* 添加 Multiplatform平台的 “本地基础警告对话框覆盖” 属性函数；
* 添加 Multiplatform平台的 “滑块颜色集()”、“记住滑块状态()”、“记住范围滑块状态()” 函数；
* 添加 Multiplatform平台的 SliderColors “复制()” 函数；
* 添加 Multiplatform平台的 “对话框属性”、“基础警告对话框覆盖范围”、“滑块位置”、“滑块状态”、“范围滑块状态” 函数类；
* 添加 Multiplatform平台的 “默认基础警告对话框覆盖”、“警告对话框默认值”、“滑块默认值” 对象类；
* 添加 Multiplatform平台的 “基础警告对话框覆盖” 接口类；
* 更新 kotlin 版本为 2.3.21；
* 更新 composeMultiplatform 版本为 1.11.0；
* 更新 kotlinx-coroutines 版本为 1.11.0；

## 0.1.2

* 迁移到 Gradle 守护进程工具链；
* 添加 Multiplatform平台的 “本地色调阴影已启用” 属性函数；
* 添加 Multiplatform平台的 三个“颜色方案()”、“浅色颜色方案()”、“深色颜色方案()”、“内容颜色为()”、“表现性浅色颜色方案()” 函数；
* 添加 Multiplatform平台的 ColorScheme “复制()”、“内容颜色为()”、“表面颜色在阴影()” 函数；
* 添加 Multiplatform平台的 org.jetbrains.kotlinx:kotlinx-coroutines-core 依赖库版本为 1.11.0；
* 添加 Android平台的 org.jetbrains.kotlinx:kotlinx-coroutines-android 依赖库版本为 1.11.0；
* 添加 Desktop平台的 org.jetbrains.kotlinx:kotlinx-coroutines-swing 依赖库版本为 1.11.0；

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