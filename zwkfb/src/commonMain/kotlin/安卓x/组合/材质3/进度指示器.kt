package 安卓x.组合.材质3

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp

/**
 * [Material Design determinate linear progress indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示一个未指定的等待时间，或显示某个过程的持续时间。
 *
 * ![Linear progress indicator image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flqdiyyvh-1P-progress-indicator-configurations.png?alt=media)
 *
 * 默认情况下，[进度] 值之间没有动画效果。在需要为进度添加动画时（如下例所示），您可以使用
 * [ProgressIndicatorDefaults.ProgressAnimationSpec] 作为推荐的默认 [androidx.compose.animation.core.AnimationSpec]
 *
 * @param 进度 该进度指示器的进度值，其中 0.0 表示无进度，1.0 表示完成进度。超出此范围的值会被强制约束到该范围内。
 * @param 修饰符 应用于此进度指示器的 [Modifier]。
 * @param 颜色 此进度指示器的颜色。
 * @param 轨道颜色 指示器后方轨道的颜色，在进度尚未到达整个指示器区域时可见。
 * @param 描边端点 用于此进度指示器末端的笔触端点样式。
 * @param 间隙大小 进度指示器与轨道之间间隙的大小。
 * @param 绘制停止指示器 用于绘制停止指示器的 lambda 表达式。请注意，自定义指示器实现也应处理从右到左（RTL）布局。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 线性进度指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    颜色: Color = ProgressIndicatorDefaults.linearColor,
    轨道颜色: Color = ProgressIndicatorDefaults.linearTrackColor,
    描边端点: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
    间隙大小: Dp = ProgressIndicatorDefaults.LinearIndicatorTrackGapSize,
    绘制停止指示器: DrawScope.() -> Unit = {
        ProgressIndicatorDefaults.drawStopIndicator(
            drawScope = this,
            stopSize = ProgressIndicatorDefaults.LinearTrackStopIndicatorSize,
            color = 颜色,
            strokeCap = 描边端点,
        )
    },
) {
    LinearProgressIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨道颜色,
        strokeCap = 描边端点,
        gapSize = 间隙大小,
        drawStopIndicator= 绘制停止指示器,
    )
}

/**
 * [Material Design indeterminate linear progress indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示一个未指定的等待时间，或显示某个过程的持续时间。
 *
 * ![Linear progress indicator image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flqdiyyvh-1P-progress-indicator-configurations.png?alt=media)
 *
 * @param 修饰符 应用于此进度指示器的 [Modifier]。
 * @param 颜色 此进度指示器的颜色。
 * @param 轨道颜色 指示器后方轨道的颜色，在进度尚未到达整个指示器区域时可见。
 * @param 描边端点 用于此进度指示器末端的笔触端点样式。
 * @param 间隙大小 进度指示器与轨道之间间隙的大小。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 线性进度指示器(
    修饰符: Modifier = Modifier,
    颜色: Color = ProgressIndicatorDefaults.linearColor,
    轨道颜色: Color = ProgressIndicatorDefaults.linearTrackColor,
    描边端点: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
    间隙大小: Dp = ProgressIndicatorDefaults.LinearIndicatorTrackGapSize,
) {
    LinearProgressIndicator(
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨道颜色,
        strokeCap = 描边端点,
        gapSize = 间隙大小,
    )
}

@Suppress("ComposableNaming")
@Deprecated(
    message = "Use the overload that takes `progress` as a lambda",
    replaceWith =
        ReplaceWith(
            "LinearProgressIndicator(\n" +
                    "progress = { progress },\n" +
                    "modifier = modifier,\n" +
                    "color = color,\n" +
                    "trackColor = trackColor,\n" +
                    "strokeCap = strokeCap,\n" +
                    ")"
        ),
)
@Composable
fun 线性进度指示器(
    进度: Float,
    修饰符: Modifier = Modifier,
    颜色: Color = ProgressIndicatorDefaults.linearColor,
    轨道颜色: Color = ProgressIndicatorDefaults.linearTrackColor,
    描边端点: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
) =
    LinearProgressIndicator(
        progress = 进度 ,
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨道颜色,
        strokeCap = 描边端点,
    )


/**
 * [Material Design determinate circular progress indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示一个未指定的等待时间，或显示某个过程的持续时间。
 *
 * ![Circular progress indicator image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flqdiyyvh-1P-progress-indicator-configurations.png?alt=media)
 *
 * 默认情况下，[进度] 值之间没有动画效果。在需要为进度添加动画时（如下例所示），您可以使用
 * [ProgressIndicatorDefaults.ProgressAnimationSpec] 作为推荐的默认 [androidx.compose.animation.core.AnimationSpec]
 *
 * @param 进度 该进度指示器的进度值，其中 0.0 表示无进度，1.0 表示完成进度。超出此范围的值会被强制约束到该范围内。
 * @param 修饰符 应用于此进度指示器的 [Modifier]。
 * @param 颜色 此进度指示器的颜色。
 * @param 描边宽度 此进度指示器的笔触宽度。
 * @param 轨道颜色 指示器后方轨道的颜色，在进度尚未到达整个指示器区域时可见。
 * @param 描边端点 用于此进度指示器末端的笔触端点样式。
 * @param 间隙大小 进度指示器与轨道之间间隙的大小。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 圆形进度指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    颜色: Color = ProgressIndicatorDefaults.circularColor,
    描边宽度: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    轨道颜色: Color = ProgressIndicatorDefaults.circularDeterminateTrackColor,
    描边端点: StrokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
    间隙大小: Dp = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize,
) {
    CircularProgressIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        strokeWidth = 描边宽度,
        trackColor = 轨道颜色,
        strokeCap = 描边端点,
        gapSize = 间隙大小,
    )
}


/**
 * [Material Design determinate circular progress indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示一个未指定的等待时间，或显示某个过程的持续时间。
 *
 * ![Circular progress indicator image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flqdiyyvh-1P-progress-indicator-configurations.png?alt=media)
 *
 * @param 修饰符 应用于此进度指示器的 [Modifier]。
 * @param 颜色 此进度指示器的颜色。
 * @param 描边宽度 此进度指示器的笔触宽度。
 * @param 轨道颜色 指示器后方轨道的颜色，在进度尚未到达整个指示器区域时可见。
 * @param 描边端点 用于此进度指示器末端的笔触端点样式。
 * @param 间隙大小 进度指示器与轨道之间间隙的大小。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 圆形进度指示器(
    修饰符: Modifier = Modifier,
    颜色: Color = ProgressIndicatorDefaults.circularColor,
    描边宽度: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    轨道颜色: Color = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
    描边端点: StrokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap,
    间隙大小: Dp = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize,
) {
    CircularProgressIndicator(
        modifier = 修饰符,
        color = 颜色,
        strokeWidth = 描边宽度,
        trackColor = 轨道颜色,
        strokeCap = 描边端点,
        gapSize = 间隙大小,
    )
}

@Suppress("DEPRECATION", "ComposableNaming")
@Deprecated(
    message = "Use the overload that takes `progress` as a lambda",
    replaceWith =
        ReplaceWith(
            "CircularProgressIndicator(\n" +
                    "progress = { progress },\n" +
                    "modifier = modifier,\n" +
                    "color = color,\n" +
                    "strokeWidth = strokeWidth,\n" +
                    "trackColor = trackColor,\n" +
                    "strokeCap = strokeCap,\n" +
                    ")"
        ),
)
@Composable
fun 圆形进度指示器(
    进度: Float,
    修饰符: Modifier = Modifier,
    颜色: Color = ProgressIndicatorDefaults.circularColor,
    描边宽度: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    轨道颜色: Color = ProgressIndicatorDefaults.circularTrackColor,
    描边端点: StrokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
) =
    CircularProgressIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        strokeWidth = 描边宽度,
        trackColor = 轨道颜色,
        strokeCap = 描边端点,
    )

/**
 * 包含 [线性进度指示器] 和 [圆形进度指示器] 使用的默认值。
 */
object 进度指示器默认值 { // ProgressIndicatorDefaults
    /** 线性进度指示器的默认颜色。 */
    val 线性颜色: Color
        @Composable get() = ProgressIndicatorDefaults.linearColor

    /** 圆形进度指示器的默认颜色。 */
    val 圆形颜色: Color
        @Composable get() = ProgressIndicatorDefaults.circularColor

    /** 线性进度指示器的默认轨道颜色。 */
    val 线性轨道颜色: Color
        @Composable get() = ProgressIndicatorDefaults.linearTrackColor

    /** 圆形进度指示器的默认轨道颜色。 */
    @Deprecated(
        "Renamed to circularDeterminateTrackColor or circularIndeterminateTrackColor",
        ReplaceWith("ProgressIndicatorDefaults.circularIndeterminateTrackColor"),
        DeprecationLevel.WARNING,
    )
    val 圆形轨道颜色: Color
        @Composable get() = ProgressIndicatorDefaults.circularTrackColor

    /** 圆形确定性进度指示器的默认轨道颜色。 */
    val 圆形确定性轨道颜色: Color
        @Composable get() = ProgressIndicatorDefaults.circularDeterminateTrackColor

    /** 圆形不确定性进度指示器的默认轨道颜色。 */
    val 圆形不确定性轨道颜色: Color
        @Composable get() = ProgressIndicatorDefaults.circularIndeterminateTrackColor

    /** 圆形进度指示器的默认笔触宽度。 */
    val 圆形描边宽度: Dp = ProgressIndicatorDefaults.CircularStrokeWidth

    /** 线性进度指示器的默认笔触端点样式。 */
    val 线性描边端点: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap

    /** 确定性圆形进度指示器的默认笔触端点样式。 */
    val 圆形确定性描边端点: StrokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap

    /** 不确定性圆形进度指示器的默认笔触端点样式。 */
    val 圆形不确定性描边端点: StrokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap

    /** 线性进度指示器的默认轨道停止指示器大小。 */
    @ExperimentalMaterial3Api
    val 线性轨道停止指示器大小: Dp = ProgressIndicatorDefaults.LinearTrackStopIndicatorSize

    /** 线性进度指示器的默认指示器轨道间隙大小。 */
    @ExperimentalMaterial3Api
    val 线性指示器轨道间隙大小: Dp = ProgressIndicatorDefaults.LinearIndicatorTrackGapSize

    /** 圆形进度指示器的默认指示器轨道间隙大小。 */
    @ExperimentalMaterial3Api
    val 圆形指示器轨道间隙大小: Dp = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize

    /** 在确定性进度指示器中为进度变化添加动画时，应使用的默认 [androidx.compose.animation.core.AnimationSpec]。*/
    val 进度动画规范 = ProgressIndicatorDefaults.ProgressAnimationSpec

    /**
     * 在轨道末端绘制停止指示器。
     *
     * @param 绘制范围 [DrawScope] 绘图作用域。
     * @param 停止大小 此停止指示器的大小，不能大于轨道的高度。
     * @param 颜色 此停止指示器的颜色。
     * @param 描边端点 用于此停止指示器末端的笔触端点样式。
     */
    fun 绘制停止指示器(绘制范围: DrawScope, 停止大小: Dp, 颜色: Color, 描边端点: StrokeCap) =
        ProgressIndicatorDefaults.drawStopIndicator(
            drawScope = 绘制范围, stopSize = 停止大小, color = 颜色, strokeCap = 描边端点)

}


