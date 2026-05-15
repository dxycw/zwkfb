package 安卓x.组合.基础

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale


/**
 * 一个用于布局并绘制给定 [ImageBitmap] 的可组合函数。它将尝试根据 [ImageBitmap] 给定的宽度和高度来确定自身的大小。不过，
 * 你可以提供一个可选的 [Modifier] 参数来调整大小或绘制额外的内容（例如背景）。对于任何未指定的尺寸，都会将 [ImageBitmap] 的大小作为最小约束值。
 *
 * 以下示例展示了如何使用 Image 可组合函数在屏幕上定位并绘制一个 [ImageBitmap]。
 *
 * @param 位图 要绘制的 [ImageBitmap]。
 * @param 内容描述 用于辅助功能服务（如屏幕阅读器）描述该图像含义的文本。除非该图像仅用于装饰目的且不代表任何用户可执行的有效操作，
 * 否则都应提供此属性。该文本应当本地化，例如可以通过 [androidx.compose.ui.res.stringResource] 或类似方式来实现。
 * @param 修饰符 用于调整布局算法或绘制装饰性内容（例如背景）的 Modifier。
 * @param 对齐 用于将 [ImageBitmap] 放置在由宽度和高度定义的给定边界内的可选对齐参数。
 * @param 内容缩放 用于确定在边界尺寸与 [ImageBitmap] 固有尺寸不同时，所使用的宽高比缩放方式的可选缩放参数。
 * @param 透明度 在 [ImageBitmap] 渲染到屏幕上时应用的可选不透明度。
 * @param 颜色滤镜 在 [ImageBitmap] 渲染到屏幕上时应用的可选颜色滤镜。
 * @param 滤镜质量 当 [位图] 被缩放并绘制到目标区域时应用的采样算法。默认值是 [FilterQuality.Low]，它使用双线性采样算法进行缩放。
 */
@Suppress("ComposableNaming")
@Composable
@NonRestartableComposable
fun 图像(
    位图: ImageBitmap,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    对齐: Alignment = Alignment.Center,
    内容缩放: ContentScale = ContentScale.Fit,
    透明度: Float = DefaultAlpha,
    颜色滤镜: ColorFilter? = null,
    滤镜质量: FilterQuality = DefaultFilterQuality,
) {
    Image(
        bitmap = 位图,
        contentDescription = 内容描述,
        modifier = 修饰符,
        alignment = 对齐,
        contentScale = 内容缩放,
        alpha = 透明度,
        colorFilter = 颜色滤镜,
        filterQuality = 滤镜质量,
    )
}

/**
 * 一个用于布局并绘制给定 [ImageVector] 的可组合函数。它将尝试根据 [ImageVector] 给定的宽度和高度来确定自身的大小。不过，
 * 你可以提供一个可选的 [Modifier] 参数来调整大小或绘制额外的内容（例如背景）。对于任何未指定的尺寸，都会将 [ImageVector] 的大小作为最小约束值。
 *
 * @param 图像矢量 要绘制的 [ImageVector]。
 * @param 内容描述 用于辅助功能服务（如屏幕阅读器）描述该图像含义的文本。除非该图像仅用于装饰目的且不代表任何用户可执行的有效操作，
 * 否则都应提供此属性。该文本应当本地化，例如可以通过 [androidx.compose.ui.res.stringResource] 或类似方式来实现。
 * @param 修饰符 用于调整布局算法或绘制装饰性内容（例如背景）的 Modifier。
 * @param 对齐 用于将 [ImageVector] 放置在由宽度和高度定义的给定边界内的可选对齐参数。
 * @param 内容缩放 用于确定在边界尺寸与 [ImageVector] 固有尺寸不同时，所使用的宽高比缩放方式的可选缩放参数。
 * @param 透明度 在 [ImageVector] 渲染到屏幕上时应用的可选不透明度。
 * @param 颜色滤镜 在 [ImageVector] 渲染到屏幕上时应用的可选颜色滤镜。
 */
@Suppress("ComposableNaming")
@Composable
@NonRestartableComposable
fun 图像(
    图像矢量: ImageVector,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    对齐: Alignment = Alignment.Center,
    内容缩放: ContentScale = ContentScale.Fit,
    透明度: Float = DefaultAlpha,
    颜色滤镜: ColorFilter? = null,
) =
    Image(
        imageVector = 图像矢量,
        contentDescription = 内容描述,
        modifier = 修饰符,
        alignment = 对齐,
        contentScale = 内容缩放,
        alpha = 透明度,
        colorFilter = 颜色滤镜,
    )

/**
 * 创建一个用于布局并绘制给定 [Painter] 的可组合函数。它将尝试根据 [Painter] 的固有尺寸来确定自身的大小。不过，你可以提供一个可选的 [Modifier]
 * 参数来调整大小或绘制额外的内容（例如背景）。
 *
 * 注意：某些 Painter 可能没有固有尺寸，因此如果在 Modifier 链中没有提供布局修饰符（LayoutModifier），[Image]
 * 可组合函数的宽度和高度可能会被设置为零，从而无法绘制任何内容。对于那些总是尝试填充边界的 Painter 实现（例如 [ColorPainter]），
 * 就可能会出现这种情况。
 *
 * @param 绘制器 要绘制的
 * @param 内容描述 用于辅助功能服务（如屏幕阅读器）描述该图像含义的文本。除非该图像仅用于装饰目的且不代表任何用户可执行的有效操作，
 * 否则都应提供此属性。该文本应当本地化，例如可以通过 [androidx.compose.ui.res.stringResource] 或类似方式来实现。
 * @param 修饰符 用于调整布局算法或绘制装饰性内容（例如背景）的 Modifier。
 * @param 对齐 用于将 [Painter] 放置在由宽度和高度定义的给定边界内的可选对齐参数。
 * @param 内容缩放 用于确定在边界尺寸与 [Painter] 固有尺寸不同时，所使用的宽高比缩放方式的可选缩放参数。
 * @param 透明度 在 [Painter] 渲染到屏幕上时应用的可选不透明度。默认值会将 [Painter] 渲染为完全不透明。
 * @param 颜色滤镜 在 [Painter] 渲染到屏幕上时应用的可选颜色滤镜。
 */
@Suppress("ComposableNaming")
@Composable
fun 图像(
    绘制器: Painter,
    内容描述: String?,
    修饰符: Modifier = Modifier,
    对齐: Alignment = Alignment.Center,
    内容缩放: ContentScale = ContentScale.Fit,
    透明度: Float = DefaultAlpha,
    颜色滤镜: ColorFilter? = null,
) {
    Image(
        painter = 绘制器,
        contentDescription = 内容描述,
        modifier = 修饰符,
        alignment = 对齐,
        contentScale = 内容缩放,
        alpha = 透明度,
        colorFilter = 颜色滤镜,
    )
}
