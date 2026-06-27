
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
            implementation("com.github.dxycw.zwkfb:zwkfb-android:0.2.7")
        }
        // 只添加 多平台，其他的可以不用添加
        commonMain.dependencies {
            // 如果使用多平台 Jetpack Compose Multiplatform 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb:0.2.7")
        }
        // 只添加 Desktop 平台，其他的可以不用添加
        jvmMain.dependencies {
            // 如果使用 Desktop平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-desktop:0.2.7")
        }

        // 以下平台可以用，但目前不推荐使用
        // 只添加 iOS 平台，其他的可以不用添加
        iosMain.dependencies {
            // 如果使用 IOS平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-iosarm64:0.2.7")
            implementation("com.github.dxycw.zwkfb:zwkfb-iossimulatorarm64:0.2.7")
        }
        // 只添加 web的js 平台，其他的可以不用添加
        jsMain.dependencies {
            // 如果使用 Web的js平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-js:0.2.7")
        }
        // 只添加 web的wasmJs 平台，其他的可以不用添加
        wasmJsMain.dependencies {
            // 如果使用 Web的wasmjs平台 Jetpack Compose 项目，请添加以下依赖项
            implementation("com.github.dxycw.zwkfb:zwkfb-wasm-js:0.2.7")
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
>* 项目>=0.1.9版本：
>   
>   从本版本发布开始请使用 Kotlin 的 `2.4.0` 版本。
> 
>* 项目>=0.1.4版本：
>
>   从本版本发布开始请使用 Jetpack Compose Multiplatform 的新项目模板。

# 更新内容

## 0.2.7

* 添加 Multiplatform平台的 “切换按钮()”、“凸起切换按钮()”、“色调切换按钮()”、“轮廓切换按钮()”、“侧边导航栏()”、“侧边导航栏项()” 函数组件；
* 添加 Multiplatform平台的 “切换按钮颜色集()”、“切换按钮形状集()”、“组合本地的()”、“静态组合本地的()”、“组合本地带已计算默认值的()”、“组合本地带主机默认值的()”、三个“组合本地提供器()”、“带组合本地()”、“带组合本地集()”、“侧边导航栏项颜色集()”、五个“颜色()”、“线性插值()” 函数；
* 添加 Multiplatform平台的 “组合本地访问器范围” 接口类；
* 添加 Multiplatform平台的 “颜色提供器” 函数接口类；
* 添加 Multiplatform平台的 “切换按钮默认值”、“侧边导航栏默认值”、“侧边导航栏项默认值”、“颜色” 对象类；
* 添加 Multiplatform平台的 “本地侧边导航栏覆盖” 属性函数；
* 添加 Multiplatform平台的 ToggleButtonColors “复制()” 函数；
* 添加 Multiplatform平台的 ToggleButtonShapes “形状”、“按压形状”、“已选中形状” 属性函数；
* 添加 Multiplatform平台的 ToggleButtonShapes “复制()” 函数；
* 添加 Multiplatform平台的 CompositionLocal “当前” 属性函数；
* 添加 Multiplatform平台的 ProvidableCompositionLocal “提供集()”、“提供集默认值()”、“提供集已计算()” 函数；
* 添加 Multiplatform平台的 NavigationRailItemColors “复制()” 函数；
* 添加 Multiplatform平台的 Color “值”、“颜色间隔”、“红”、“绿”、“蓝”、“透明度”、“是否已指定”、“是否未指定” 属性函数；
* 添加 Multiplatform平台的 Color “转换()”、“组件1()”、“组件2()”、“组件3()”、“组件4()”、“组件5()”、“复制()”、“合成覆盖()”、“亮度()”、“转为Argb()”、“取或否则()” 函数；

## 0.2.6

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “工具提示框()”、“水平多浏览轮播()”、“水平无约束轮播()”、“水平居中焦点轮播()” 函数组件；
* 添加 Multiplatform平台的 “富工具提示颜色集()”、“记住工具提示状态()”、“工具提示状态()”、“默认工具提示箭头形状()”、五个“记住()”、“键()”、“可复用内容()”、“可复用内容主机()”、三个“组合节点()”、三个“可复用组合节点()”、“记住组合上下文()”、“轮播状态()”、“记住轮播状态()” 函数；
* 添加 Multiplatform平台的 “当前组合器”、“当前组合上下文”、“当前重组范围”、“当前组合局部上下文”、“当前复合键哈希”、“当前复合键哈希码” 属性函数；
* 添加 Multiplatform平台的 “工具提示范围”、“工具提示状态”、“轮播项绘制信息” 接口类；
* 添加 Multiplatform平台的 “工具提示默认值”、“工具提示锚点位置”、“轮播默认值”、“轮播状态” 对象类；
* 添加 Multiplatform平台的 TooltipScope “取定位提供器()”、“普通工具提示()”、“富工具提示()” 函数；
* 添加 Multiplatform平台的 RichTooltipColors “复制()” 函数；
* 添加 Multiplatform平台的 TooltipState “过渡”、“是否可见”、“是否持久” 属性函数；
* 添加 Multiplatform平台的 TooltipState “显示()”、“关闭()”、“销毁回调()” 函数；
* 添加 Multiplatform平台的 DefaultTooltipCaretShape “箭头大小” 属性函数；
* 添加 Multiplatform平台的 DefaultTooltipCaretShape “创建轮廓()” 函数；
* 添加 Multiplatform平台的 CarouselState “是否正在滚动”、“当前项” 属性函数；
* 添加 Multiplatform平台的 CarouselState “分发原始增量()”、“滚动()”、“滚动到项()”、“动画滚动到项()” 函数；
* 添加 Multiplatform平台的 CarouselItemDrawInfo “大小”、“最小大小”、“最大大小”、“遮罩矩形” 属性函数；

## 0.2.5

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “悬浮操作按钮()”、“小型悬浮操作按钮()”、“中等悬浮操作按钮()”、“大型悬浮操作按钮()”、两个“小型扩展悬浮操作按钮()”、两个“中等扩展悬浮操作按钮()”、两个“大型扩展悬浮操作按钮()”、两个“扩展悬浮操作按钮()”、“开关()” 函数组件；
* 添加 Multiplatform平台的 两个“形状集()”、三个“排版()”、“开关颜色集()” 函数；
* 添加 Multiplatform平台的 “悬浮操作按钮默认值”、“形状默认值”、“排版”、“开关默认值” 对象类；
* 添加 Multiplatform平台的 DrawScope 两个“绘制圆弧()”、两个“绘制路径()”、两个“绘制点集()” 函数；
* 添加 Multiplatform平台的 Modifier “动画悬浮操作按钮()” 函数；
* 添加 Multiplatform平台的 Shapes “大增加”、“超大增加”、“超超大” 属性函数；
* 添加 Multiplatform平台的 Shapes 两个“复制()” 函数；
* 添加 Multiplatform平台的 Typography “显示大型强调”、“显示中等强调”、“显示小型强调”、“大标题大型强调”、“大标题中等强调”、“大标题小型强调”、“标题大型强调”、“标题中等强调”、“标题小型强调”、“正文大型强调”、“正文中等强调”、“正文小型强调”、“标签大型强调”、“标签中等强调”、“标签小型强调” 属性函数；
* 添加 Multiplatform平台的 Typography 两个“复制()” 函数；
* 添加 Multiplatform平台的 SwitchColors “复制()” 函数；

## 0.2.4

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 “单选按钮()”、两个“复选框()”、两个“三态复选框()”、“导航栏()” 函数组件；
* 添加 Multiplatform平台的 “本地导航栏覆盖” 属性函数；
* 添加 Multiplatform平台的 “单选按钮颜色集()”、两个“复选框颜色集()”、“导航栏项颜色集()” 函数；
* 添加 Multiplatform平台的 “单选按钮默认值”、“复选框默认值”、“导航栏默认值”、“导航栏项默认值” 对象类；
* 添加 Multiplatform平台的 RadioButtonColors “复制()” 函数；
* 添加 Multiplatform平台的 CheckboxColors “复制()” 函数；
* 添加 Multiplatform平台的 RowScope “导航栏项()” 函数；
* 添加 Multiplatform平台的 NavigationBarItemColors “复制()” 函数；
* 添加 Desktop平台的 com.formdev:flatlaf-extras 依赖库版本为 3.7.1；
* 添加 Desktop平台的 com.formdev:flatlaf-intellij-themes 依赖库版本为 3.7.1；
* 添加 Desktop平台的 net.java.dev.jna:jna 依赖库版本为 5.19.1；
* 添加 Desktop平台的 net.java.dev.jna:jna-platform 依赖库版本为 5.19.1；
* 更新 Web的js平台的 org.jetbrains.kotlin-wrappers:kotlin-browser 依赖库版本为 2026.6.5；

## 0.2.3

* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 Multiplatform平台的 三个“下拉逐渐缩小隐藏动画()”、“记住导航控制器()”、三个“组件变灰()” 函数；
* 添加 Multiplatform平台的 NavController “当前返回栈条目状态()” 函数；
* 添加 Multiplatform平台的 NavGraphBuilder 三个“可组合()”、五个“导航()”、三个“对话框()” 函数；
* 添加 Multiplatform平台的 DrawScope 两个“绘制圆角矩形()”、两个“绘制圆形()”、两个“绘制椭圆形()” 函数；
* 添加 Multiplatform平台的 Modifier “旋转动画()”、“滑动回弹()” 函数；
* 添加 Android平台的 三个“下拉逐渐缩小隐藏动画并启动活动()”、“修复网页打开编辑框键盘显示的Bug()” 函数；
* 添加 Desktop平台的 com.formdev:flatlaf 依赖库版本为 3.7.1；
* 删除老库[zwkfb-compose](https://github.com/dxycw/zwkfb-compose)；

## 0.2.2

* 添加 Multiplatform平台的 “主标签页行()”、“次标签页行()”、“主可滚动标签页行()”、“次可滚动标签页行()”、“标签页行()”、“可滚动标签页行()”、四个“导航主机()” 函数组件；
* 添加 Multiplatform平台的 “文本字段颜色集()” 函数；
* 添加 Multiplatform平台的 “标签页行默认值” 对象类；
* 添加 Multiplatform平台的 “标签页指示器范围”、“绘制范围” 接口类；
* 添加 Multiplatform平台的 TextFieldColors “复制()”、“前导图标颜色()”、“尾随图标颜色()”、“指示器颜色()”、“容器颜色()”、“占位符颜色()”、“标签颜色()”、“文本颜色()”、“辅助文本颜色()”、“前缀颜色()”、“后缀颜色()”、“光标颜色()” 函数；
* 添加 Multiplatform平台的 文本字段标签位置 “始终最小化”、“最小化对齐方式”、“展开对齐方式”、“对齐” 属性函数；
* 添加 Multiplatform平台的 TextFieldLabelScope “标签最小化进度” 属性函数；
* 添加 Multiplatform平台的 TabPosition “左”、“宽度”、“内容宽度”、“右” 属性函数；
* 添加 Multiplatform平台的 DrawScope “绘制上下文”、“中心”、“大小”、“布局方向” 属性函数；
* 添加 Multiplatform平台的 DrawScope 两个“绘制线条()”、两个“绘制矩形()”、两个“绘制图像()” 函数；
* 添加 Multiplatform平台的 Modifier 两个“背景()”、两个“可单击()”、两个“组合可单击()”、“可单击没有波纹()”、“可单击变灰()” 函数；

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