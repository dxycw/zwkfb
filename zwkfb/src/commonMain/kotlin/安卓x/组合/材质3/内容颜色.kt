package 安卓x.组合.材质3

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.ui.graphics.Color

/**
 * 包含层次结构中给定位置的首选内容颜色的 CompositionLocal。这通常表示 [ColorScheme] 中某种颜色的 `on` 颜色。
 * 例如，如果背景色为 [ColorScheme.surface]，则此颜色通常设置为 [ColorScheme.onSurface]。
 *
 * 此颜色应用于任何文本排版/图标绘制，以确保这些元素的颜色随背景色变化而调整。例如，
 * 深色背景上的文本应为浅色，浅色背景上的文本应为深色。
 *
 * 如果未显式设置颜色，则默认为 [Color.Black]。
 */
val 本地内容颜色 = LocalContentColor
