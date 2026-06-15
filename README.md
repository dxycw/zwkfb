
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
    implementation("com.github.dxycw.zwkfb:zwkfb:0.2.1")
    
    // 如果使用 Android Jetpack Compose 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-android:0.2.1")
    
    // 如果使用 Desktop Jetpack Compose 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-desktop:0.2.1")
    
    // 以下平台可以用，但目前不推荐使用
    
    // 如果使用 IOS Jetpack Compose 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-iosarm64:0.2.1")
    implementation("com.github.dxycw.zwkfb:zwkfb-iossimulatorarm64:0.2.1")
    
    // 如果使用 Web Jetpack Compose 项目，请添加以下依赖项
    implementation("com.github.dxycw.zwkfb:zwkfb-js:0.2.1")
    implementation("com.github.dxycw.zwkfb:zwkfb-wasm-js:0.2.1")
    
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

* 本项目所有平台[示例代码](https://gitee.com/dxycw/zwkfb-multiplatform#%E9%A1%B9%E7%9B%AE%E7%9B%AE%E5%BD%95)；

> [!CAUTION]
>
>* 项目>=0.1.9版本：
>   
>   从本版本发布开始请使用 Kotlin 的 `2.4.0` 版本。
> 
>* 项目>=0.1.4版本：
>
>   从本版本发布开始请使用 Jetpack Compose Multiplatform 的新项目模板。

# 更新内容

## 0.2.1

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息，添加了“打包体积压缩”；
* 添加 Multiplatform平台的 “日期范围选择器()”、“日期选择器对话框()”、“时间选择器对话框()”、两个“标签页()”、“前导图标标签页()” 函数组件；
* 添加 Multiplatform平台的 “记住日期范围选择器状态()”、“日期范围选择器状态()” 函数；
* 添加 Multiplatform平台的 “日期范围选择器默认值”、“时间选择器对话框默认值”、“时间选择器显示模式” 对象类；
* 添加 Multiplatform平台的 “日期范围选择器状态” 接口类；
* 添加 Multiplatform平台的 DateRangePickerState “已选择开始日期毫秒”、“已选择结束日期毫秒”、“显示月份毫秒”、“显示模式”、“年份范围”、“可选择日期”、“语言环境” 属性函数；
* 添加 Multiplatform平台的 DateRangePickerState “置选择()” 函数；
* 添加 Android平台的 三个“模态底部面板属性集()” 函数；
* 添加 Android平台的 模态底部面板默认值 “属性集()” 函数；

## 0.2.0

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “时间选择器()”、“时间输入()”、“日期选择器()” 函数组件；
* 添加 Multiplatform平台的 “时间选择器颜色集()”、“时间输入颜色集()”、“记住时间选择器状态()”、“时间选择器状态()”、“描边()”、“记住日期选择器状态()”、“日期选择器状态()”、“日期选择器颜色集()” 函数；
* 添加 Multiplatform平台的 “时间选择器默认值”、“时间选择器布局类型”、“时间选择器选择模式”、“描边”、“显示模式”、“日期选择器默认值” 对象类；
* 添加 Multiplatform平台的 “时间选择器状态”、“日期选择器状态”、“可选日期” 接口类；
* 添加 Multiplatform平台的 TimePickerColors “复制()” 函数；
* 添加 Multiplatform平台的 TimePickerState “分钟”、“小时”、“小时输入”、“分钟输入”、“是否24小时制”、“选择”、“是否下午”、“是否小时输入有效”、“是否分钟输入有效”、“是否输入有效” 属性函数；
* 添加 Multiplatform平台的 DatePickerState “已选择日期毫秒”、“已显示月份毫秒”、“显示模式”、“年份范围”、“可选日期”、“语言环境” 属性函数；
* 添加 Multiplatform平台的 SelectableDates “是否可选日期()”、“是否可选年份()” 函数；
* 添加 Multiplatform平台的 DatePickerFormatter “格式化月份年份()”、“格式化日期()” 函数；
* 添加 Multiplatform平台的 DatePickerColors “复制()” 函数；
* 添加 Multiplatform平台的 DrawScope 两个“缩放()”、“裁剪矩形()”、“裁剪路径()”、“绘制到画布()”、“带转换()”、“绘制()” 函数；
  
# 老版本更新内容

* [0.0.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.0.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)
* [0.1.x系列更新日志](%E6%96%87%E6%A1%A3/%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97/0.1.x%E7%B3%BB%E5%88%97%E6%9B%B4%E6%96%B0%E6%97%A5%E5%BF%97.md)