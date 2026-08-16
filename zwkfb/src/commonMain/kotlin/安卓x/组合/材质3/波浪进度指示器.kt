package 安卓x.组合.材质3

import androidx.compose.material3.Material3ExpressiveApi
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.annotation.FloatRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.WavyProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp


// TODO 更新文档图片，改用表现力更强的（波浪形）进度指示器版本。
/**
 * [Material Design determinate wavy linear progress
 * indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示不确定的等待时间，或显示某个过程的持续时间。
 *
 * ![Linear wavy progress indicator
 * image](https://developer.android.com/images/reference/androidx/compose/material3/linear-wavy-progress-indicator.png)
 *
 * 此版本的线性进度指示器接受 [振幅]、[波长] 和 [波速] 等参数，以将进度渲染为波形。
 *
 * 默认情况下，[进度] 值之间没有动画。在动画化进度时，你可以使用
 * [WavyProgressIndicatorDefaults.ProgressAnimationSpec] 作为默认推荐的 [AnimationSpec]。
 *
 * @param 进度 该进度指示器的进度值，0.0 表示无进度，1.0 表示进度已满。超出此范围的值将被强制约束到该范围内。
 * @param 修饰符 要应用于此进度指示器的 [Modifier]。
 * @param 颜色 进度指示器的颜色。
 * @param 轨道颜色 指示器的轨道颜色，当进度尚未到达整个指示器的对应区域时可见。
 * @param 描边 用于绘制此指示器的 [Stroke]。
 * @param 轨道描边 用于绘制指示器轨道的 [Stroke]。
 * @param 间隙大小 指示器的轨道与进度部分之间的间隙。
 * @param 停止大小 轨道末端停止指示器的尺寸。请注意，若轨道与其容器或容器后方表面的对比度低于 3:1，则必须使用该停止指示器。
 * @param 振幅 一个 lambda，用于根据指示器的进度提供波浪路径的振幅。0.0 表示无振幅，1.0 表示振幅将占据进度指示器
 * 的完整高度。超出此范围的值将被强制约束到该范围内。
 * @param 波长 波浪的长度。当路径的 [振幅] 大于零且表示为波浪时生效。
 * @param 波速 当 [振幅] 大于零时，波浪移动的速度。该值以每秒 DP 为单位，默认与 [波长] 相匹配，
 * 以渲染出波浪每秒移动一个波长的动画。
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 线性波浪进度指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    颜色: Color = WavyProgressIndicatorDefaults.indicatorColor,
    轨道颜色: Color = WavyProgressIndicatorDefaults.trackColor,
    描边: Stroke = WavyProgressIndicatorDefaults.linearIndicatorStroke,
    轨道描边: Stroke = WavyProgressIndicatorDefaults.linearTrackStroke,
    间隙大小: Dp = WavyProgressIndicatorDefaults.LinearIndicatorTrackGapSize,
    停止大小: Dp = WavyProgressIndicatorDefaults.LinearTrackStopIndicatorSize,
    振幅: (progress: Float) -> Float = WavyProgressIndicatorDefaults.indicatorAmplitude,
    波长: Dp = WavyProgressIndicatorDefaults.LinearDeterminateWavelength,
    波速: Dp = 波长, // 匹配为每秒 1 个波长
) =
    LinearWavyProgressIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨道颜色,
        stroke = 描边,
        trackStroke = 轨道描边,
        gapSize = 间隙大小,
        stopSize = 停止大小,
        amplitude = 振幅,
        wavelength = 波长,
        waveSpeed = 波速,
    )


// TODO 更新文档图片，改用表现力更强的（波浪形）进度指示器版本。
/**
 * [Material Design indeterminate linear wavy progress
 * indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示不确定的等待时间，或显示某个过程的持续时间。
 *
 * ![Indeterminate linear wavy progress indicator
 * image](https://developer.android.com/images/reference/androidx/compose/material3/indeterminate-linear-wavy-progress-indicator.png)
 *
 * @param 修饰符 要应用于此进度指示器的 [Modifier]。
 * @param 颜色 进度指示器的颜色。
 * @param 轨道颜色 指示器的轨道颜色，当进度尚未到达整个指示器的对应区域时可见。
 * @param 描边 用于绘制此指示器的 [Stroke]。
 * @param 轨道描边 用于绘制指示器轨道的 [Stroke]。
 * @param 间隙大小 指示器的轨道与进度部分之间的间隙。
 * @param 振幅 波浪的振幅。0.0 表示无振幅，1.0 表示振幅将占据进度指示器的完整高度。超出此范围的值将被强制约束到该范围内。
 * @param 波长 波浪的长度（即波长）
 * @param 波速 当 [振幅] 大于零时，波浪移动的速度。该值以每秒 DP 为单位，默认与 [波长] 相匹配，
 * 以渲染出波浪每秒移动一个波长的动画。
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 线性波浪进度指示器(
    修饰符: Modifier = Modifier,
    颜色: Color = WavyProgressIndicatorDefaults.indicatorColor,
    轨道颜色: Color = WavyProgressIndicatorDefaults.trackColor,
    描边: Stroke = WavyProgressIndicatorDefaults.linearIndicatorStroke,
    轨道描边: Stroke = WavyProgressIndicatorDefaults.linearTrackStroke,
    间隙大小: Dp = WavyProgressIndicatorDefaults.LinearIndicatorTrackGapSize,
    @FloatRange(from = 0.0, to = 1.0) 振幅: Float = 1f,
    波长: Dp = WavyProgressIndicatorDefaults.LinearIndeterminateWavelength,
    波速: Dp = 波长, // 匹配为每秒 1 个波长
) =
    LinearWavyProgressIndicator(
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨道颜色,
        stroke = 描边,
        trackStroke = 轨道描边,
        gapSize = 间隙大小,
        amplitude = 振幅,
        wavelength = 波长,
        waveSpeed = 波速,
    )


// TODO 更新文档图片，改用表现力更强的（波浪形）进度指示器版本。
/**
 * [Material Design determinate circular progress
 * indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示不确定的等待时间，或显示某个过程的持续时间。
 *
 * ![Circular wavy progress indicator
 * image](https://developer.android.com/images/reference/androidx/compose/material3/circular-wavy-progress-indicator.png)
 *
 * 默认情况下，[进度] 值之间没有动画。在动画化进度时，你可以使用
 * [ProgressIndicatorDefaults.ProgressAnimationSpec] 作为默认推荐的 [AnimationSpec]。
 *
 * @param 进度 该进度指示器的进度值，0.0 表示无进度，1.0 表示进度已满。超出此范围的值将被强制约束到该范围内。
 * @param 修饰符 要应用于此进度指示器的 [Modifier]。
 * @param 颜色 进度指示器的颜色。
 * @param 轨道颜色 指示器的轨道颜色，当进度尚未到达整个指示器的对应区域时可见。
 * @param 描边 用于绘制此指示器的 [Stroke]。
 * @param 轨道描边 用于绘制指示器轨道的 [Stroke]。
 * @param 间隙大小 指示器的轨道与进度部分之间的间隙。
 * @param 振幅 一个 lambda，用于根据指示器的进度为波浪路径提供振幅。0.0 表示无振幅，1.0 表示最大振幅。
 * 超出此范围的值将被强制约束到该范围内。
 * @param 波长 波浪的长度（即波长）  在此环形指示器中。请注意，为保证波浪形状的连续性，实际波长可能会有所不同。
 * @param 波速 当 [振幅] 大于零时，波浪移动的速度。该值以每秒 DP 为单位，默认与 [波长] 相匹配，
 * 以渲染出波浪每秒移动一个波长的动画。请注意，实际速度可能略有差异，因为 [波长] 可能会进行调整，以确保波浪形状的连续性。
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 圆形波浪进度指示器(
    进度: () -> Float,
    修饰符: Modifier = Modifier,
    颜色: Color = WavyProgressIndicatorDefaults.indicatorColor,
    轨道颜色: Color = WavyProgressIndicatorDefaults.trackColor,
    描边: Stroke = WavyProgressIndicatorDefaults.circularIndicatorStroke,
    轨道描边: Stroke = WavyProgressIndicatorDefaults.circularTrackStroke,
    间隙大小: Dp = WavyProgressIndicatorDefaults.CircularIndicatorTrackGapSize,
    振幅: (progress: Float) -> Float = WavyProgressIndicatorDefaults.indicatorAmplitude,
    波长: Dp = WavyProgressIndicatorDefaults.CircularWavelength,
    波速: Dp = 波长, // 匹配为每秒 1 个波长
) =
    CircularWavyProgressIndicator(
        progress = 进度,
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨道颜色,
        stroke = 描边,
        trackStroke = 轨道描边,
        gapSize = 间隙大小,
        amplitude = 振幅,
        wavelength = 波长,
        waveSpeed = 波速,
    )


// TODO 更新文档图片，改用表现力更强的（波浪形）进度指示器版本。
/**
 * [Material Design indeterminate circular progress
 * indicator](https://m3.material.io/components/progress-indicators/overview)
 *
 * 进度指示器用于表示不确定的等待时间，或显示某个过程的持续时间。
 *
 * ![Indeterminate circular wavy progress indicator
 * image](https://developer.android.com/images/reference/androidx/compose/material3/indeterminate-circular-wavy-progress-indicator.png)
 *
 * @param 修饰符 要应用于此进度指示器的 [Modifier]。
 * @param 颜色 进度指示器的颜色。
 * @param 轨道颜色 指示器的轨道颜色，当进度尚未到达整个指示器的对应区域时可见。
 * @param 描边 用于绘制此指示器的 [Stroke]。
 * @param 轨道描边 用于绘制指示器轨道的 [Stroke]。
 * @param 间隙大小 指示器的轨道与进度部分之间的间隙。
 * @param 振幅 波浪的振幅。0.0 表示无振幅，1.0 表示振幅将占据进度指示器的完整高度。超出此范围的值将被强制约束到该范围内。
 * @param 波长 波浪的长度（即波长）  在此环形指示器中。请注意，为保证波浪形状的连续性，实际波长可能会有所不同。
 * @param 波速 当 [振幅] 大于零时，波浪移动的速度。该值以每秒 DP 为单位，默认与 [波长] 相匹配，
 * 以渲染出波浪每秒移动一个波长的动画。请注意，实际速度可能略有差异，因为 [波长] 可能会进行调整，以确保波浪形状的连续性。
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 圆形波浪进度指示器(
    修饰符: Modifier = Modifier,
    颜色: Color = WavyProgressIndicatorDefaults.indicatorColor,
    轨道颜色: Color = WavyProgressIndicatorDefaults.trackColor,
    描边: Stroke = WavyProgressIndicatorDefaults.circularIndicatorStroke,
    轨道描边: Stroke = WavyProgressIndicatorDefaults.circularTrackStroke,
    间隙大小: Dp = WavyProgressIndicatorDefaults.CircularIndicatorTrackGapSize,
    @FloatRange(from = 0.0, to = 1.0) 振幅: Float = 1f,
    波长: Dp = WavyProgressIndicatorDefaults.CircularWavelength,
    波速: Dp = 波长, // 匹配为每秒 1 个波长
) =
    CircularWavyProgressIndicator(
        modifier = 修饰符,
        color = 颜色,
        trackColor = 轨道颜色,
        stroke = 描边,
        trackStroke = 轨道描边,
        gapSize = 间隙大小,
        amplitude = 振幅,
        wavelength = 波长,
        waveSpeed = 波速,
    )


/** 包含用于波浪形进度指示器的默认值。 */
@Material3ExpressiveApi
object 波浪进度指示器默认值 { // WavyProgressIndicatorDefaults

    /** 确定性进度指示器在进度值之间进行动画时应使用的默认 [AnimationSpec]。*/
    val 进度动画规格: AnimationSpec<Float> =
        WavyProgressIndicatorDefaults.ProgressAnimationSpec

    /** 默认的活动指示器 [Color]。 */
    val 指示器颜色: Color
        @Composable get() = WavyProgressIndicatorDefaults.indicatorColor

    /** 默认的轨道 [Color]。 */
    val 轨道颜色: Color
        @Composable get() = WavyProgressIndicatorDefaults.trackColor

    /** 默认的线性进度指示器活动指示器 [Stroke]。 */
    val 线性指示器描边: Stroke
        @Composable
        get() = WavyProgressIndicatorDefaults.linearIndicatorStroke

    /** 默认的环形进度指示器活动指示器 [Stroke]。 */
    val 圆形指示器描边: Stroke
        @Composable
        get() = WavyProgressIndicatorDefaults.circularIndicatorStroke

    /** 默认的线性进度指示器轨道 [Stroke]。 */
    val 线性轨道描边: Stroke
        @Composable
        get() = WavyProgressIndicatorDefaults.linearTrackStroke

    /** 默认的环形进度指示器轨道 [Stroke]。 */
    val 圆形轨道描边: Stroke
        @Composable
        get() = WavyProgressIndicatorDefaults.circularTrackStroke

    /** 确定性线性进度指示器处于波浪形态时的默认波长。 */
    val 线性确定性波长: Dp = WavyProgressIndicatorDefaults.LinearDeterminateWavelength

    /** 线性进度指示器处于波浪形态时的默认波长。 */
    val 线性不确定波长: Dp =
        WavyProgressIndicatorDefaults.LinearIndeterminateWavelength

    /** 默认的线性进度指示器容器高度。 */
    val 线性容器高度: Dp = WavyProgressIndicatorDefaults.LinearContainerHeight

    /** 默认的线性进度指示器容器宽度。 */
    val 线性容器宽度: Dp = WavyProgressIndicatorDefaults.LinearContainerWidth

    /** 默认的线性停止指示器大小。 */
    val 线性轨道停止指示器大小: Dp = WavyProgressIndicatorDefaults.LinearTrackStopIndicatorSize

    /** 默认的环形进度指示器容器大小。 */
    val 圆形容器大小: Dp = WavyProgressIndicatorDefaults.CircularContainerSize

    /** 环形进度指示器处于波浪形态时的默认波长。 */
    val 圆形波长: Dp = WavyProgressIndicatorDefaults.CircularWavelength

    /** 线性进度指示器中活动指示器与轨道之间的默认间隙大小。*/
    val 线性指示器轨道间隙大小: Dp = WavyProgressIndicatorDefaults.LinearIndicatorTrackGapSize

    /** 环形进度指示器中活动指示器与轨道之间的默认间隙大小。*/
    val 圆形指示器轨道间隙大小: Dp = WavyProgressIndicatorDefaults.CircularIndicatorTrackGapSize

    /** 一个根据给定进度返回确定性指示器振幅的函数。 */
    val 指示器幅度: (进度: Float) -> Float =
        WavyProgressIndicatorDefaults.indicatorAmplitude

}

