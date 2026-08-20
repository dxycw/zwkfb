@file:JvmName("Android图像Kt")
package 自定义.组合.基础

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource



/**
 * 创建一个用于布局并绘制给定 [Painter] 的可组合函数。它将尝试根据 [Painter] 的固有尺寸来确定自身的大小。不过，你可以提供一个可选的 [Modifier]
 * 参数来调整大小或绘制额外的内容（例如背景）。
 *
 * 注意：某些 Painter 可能没有固有尺寸，因此如果在 Modifier 链中没有提供布局修饰符（LayoutModifier），[Image]
 * 可组合函数的宽度和高度可能会被设置为零，从而无法绘制任何内容。对于那些总是尝试填充边界的 Painter 实现（例如 [ColorPainter]），
 * 就可能会出现这种情况。
 *
 * @param 绘制id 要绘制的
 * @param 内容描述 用于辅助功能服务（如屏幕阅读器）描述该图像含义的文本。除非该图像仅用于装饰目的且不代表任何用户可执行的有效操作，
 * 否则都应提供此属性。该文本应当本地化，例如可以通过 [androidx.compose.ui.res.stringResource] 或类似方式来实现。
 * @param 修饰符 用于调整布局算法或绘制装饰性内容（例如背景）的 Modifier。
 * @param 对齐 用于将 [Painter] 放置在由宽度和高度定义的给定边界内的可选对齐参数。
 * @param 内容缩放 用于确定在边界尺寸与 [Painter] 固有尺寸不同时，所使用的宽高比缩放方式的可选缩放参数。
 * @param 透明度 在 [Painter] 渲染到屏幕上时应用的可选不透明度。默认值会将 [Painter] 渲染为完全不透明。
 * @param 颜色过滤器 在 [Painter] 渲染到屏幕上时应用的可选颜色滤镜。
 */
@Suppress("ComposableNaming","ModifierParameter")
@Composable
fun 图像(
    绘制id: Int,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    对齐: Alignment = Alignment.Center,
    内容缩放: ContentScale = ContentScale.Fit,
    透明度: Float = DefaultAlpha,
    颜色过滤器: ColorFilter? = null,
) =
    Image(
        painter = painterResource(绘制id),
        contentDescription = 内容描述,
        modifier = 修饰符,
        alignment = 对齐,
        contentScale = 内容缩放,
        alpha = 透明度,
        colorFilter = 颜色过滤器,
    )