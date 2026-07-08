package 安卓x.组合.基础

import androidx.annotation.FloatRange
import androidx.compose.foundation.background
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

/**
 * 在内容后面绘制一个带实心[颜色]的[形状]。
 *
 * @param 颜色 用于绘制背景的颜色
 * @param 形状 背景的目标形状
 */
@Stable
fun Modifier.背景(颜色: Color, 形状: Shape = RectangleShape): Modifier =
    this.background(color = 颜色, shape = 形状,)



/**
 * 在内容后方以 [画刷] 绘制 [形状]。
 *
 * @param 画刷 用于绘制背景的 画刷
 * @param 形状 背景的目标形状
 * @param 透明度 要应用于 [画刷] 的不透明度，0 表示完全透明，1 表示完全不透明。该值必须在 0 和 1 之间。
 */
@Stable
fun Modifier.背景(
    画刷: Brush,
    形状: Shape = RectangleShape,
    @FloatRange(from = 0.0, to = 1.0) 透明度: Float = 1.0f,
) = this.background(brush = 画刷, shape = 形状, alpha = 透明度)


