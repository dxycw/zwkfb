package 安卓x.组合.基础

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

/**
 * 返回操作系统是否处于深色主题模式。
 *
 * 此函数应用于帮助构建跟随系统设置的响应式用户界面，以避免在应用程序之间切换时出现突兀的对比度变化。
 *
 * 建议在应用程序的顶层使用此函数，以创建主题对象（例如一组颜色），并通过层级结构向下传递。这样，各个屏幕和组件就无需感知系统主题设置，
 * 只需从主题对象中获取相应的属性即可。这种方式也使得支持用户自定义覆盖变得更加容易，例如无论系统设置如何，都强制使用浅色或深色主题。
 *
 * @return 如果系统被认为处于"深色主题"模式，则返回 `true`。
 */
@Composable
@ReadOnlyComposable
fun 是否系统深色主题() = isSystemInDarkTheme()

