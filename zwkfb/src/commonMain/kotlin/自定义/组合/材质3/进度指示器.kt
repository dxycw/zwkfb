package 自定义.组合.材质3

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.progressBarRangeInfo
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import 安卓x.组合.基础.画布
import 安卓x.组合.材质3.进度指示器默认值
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.min


@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 线性进度指示器(
    进度: () -> Float = { 0.7f },
    修饰符: Modifier = Modifier,
    颜色: Color = ProgressIndicatorDefaults.linearColor,
    轨道颜色: Color = ProgressIndicatorDefaults.linearTrackColor,
    线条宽度: Dp = 240.dp,
    线条高度: Dp = 4.dp,
    描边端点: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
    间隔大小: Dp = ProgressIndicatorDefaults.LinearIndicatorTrackGapSize,
    绘制停止指示器: DrawScope.() -> Unit = {
        进度指示器默认值.绘制停止指示器(
            绘制范围 = this,
            停止大小 = ProgressIndicatorDefaults.LinearTrackStopIndicatorSize,
            颜色 = 颜色,
            描边端点 = 描边端点
        )
    }
) {
    val 限制进度 = { 进度().coerceIn(0f, 1f) }
    画布(
        修饰符.then(
            Modifier
                .layout { measurable, constraints ->
                    val paddingPx = 10.dp.roundToPx()
                    val newConstraint = constraints.offset(0, paddingPx * 2)
                    val placeable = measurable.measure(newConstraint)
                    val height = placeable.height - paddingPx * 2
                    val width = placeable.width
                    layout(width, height) { placeable.place(0, -paddingPx) }
                }
                .semantics(mergeDescendants = true) {}
                .padding(vertical = 10.dp)
            )
            .semantics(mergeDescendants = true) {
                progressBarRangeInfo = ProgressBarRangeInfo(限制进度(), 0f..1f)
            }
            .size(线条宽度, 线条高度)
    ) {
        val 线条宽度 = size.height
        val 适配间隙大小 = if (描边端点 == StrokeCap.Butt || size.height > size.width) { 间隔大小 }
        else { 间隔大小 + 线条宽度.toDp() }
        val 间隙大小比例 = 适配间隙大小 / size.width.toDp()
        val 当前限制进度 = 限制进度()
        val 轨道起始比例 = 当前限制进度 + min(当前限制进度, 间隙大小比例)// 轨道
        if (轨道起始比例 <= 1f) { 绘制线性指示器(轨道起始比例, 1f, 轨道颜色, 线条宽度, 描边端点) }
        绘制线性指示器(0f, 当前限制进度, 颜色, 线条宽度, 描边端点)// 进度条
        绘制停止指示器(this) // 末端
    }
}

private fun DrawScope.绘制线性指示器(
    开始值: Float, 结束值: Float, 颜色: Color, 线条宽度: Float, 描边端点: StrokeCap
) {
    val 宽度 = size.width
    val 高度 = size.height
    // 从笔画的垂直中心开始绘制
    val Y偏移量 = 高度 / 2
    val 是左到右  = layoutDirection == LayoutDirection.Ltr
    val 进度开始 = (if (是左到右) 开始值 else 1f - 结束值) * 宽度
    val 进度结束 = (if (是左到右) 结束值 else 1f - 开始值) * 宽度
    // 如果没有足够空间绘制线条端点，则回退到 StrokeCap.Butt
    if (描边端点 == StrokeCap.Butt || 高度 > 宽度) {
        drawLine(颜色,Offset(进度开始,Y偏移量),Offset(进度结束,Y偏移量),线条宽度)
    } else {
        // 需要为线条端点调整条形起始点和结束点
        val 线条端点偏移量 = 线条宽度 / 2
        val 限制范围 = 线条端点偏移量..(宽度 - 线条端点偏移量)
        val 适配条形开始位置 = 进度开始.coerceIn(限制范围)
        val 适配条形结束位置 = 进度结束.coerceIn(限制范围)
        if (abs(结束值 - 开始值) > 0) {
            drawLine(颜色,Offset(适配条形开始位置, Y偏移量),
                Offset(适配条形结束位置, Y偏移量), 线条宽度, 描边端点
            )
        }
    }
}


//=====================================================================================


@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 圆形进度指示器(
    进度: () -> Float = { 0.7f },
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
    修饰符: Modifier = Modifier,
    颜色: Color = ProgressIndicatorDefaults.circularColor,
    线条宽度: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    轨道颜色: Color = ProgressIndicatorDefaults.circularDeterminateTrackColor,
    线条端点: StrokeCap = ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
    间隔大小: Dp = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize,
) {

    val coercedProgress = { 进度().coerceIn(值范围) }
    val stroke = with(LocalDensity.current) { Stroke(width = 线条宽度.toPx(), cap = 线条端点) }
    Canvas(
        修饰符
            .semantics(mergeDescendants = true) {
                // Check for NaN, as the ProgressBarRangeInfo will throw an exception.
                progressBarRangeInfo =
                    ProgressBarRangeInfo(coercedProgress().takeUnless { it.isNaN() } ?: 0f, 值范围)
            }
            .size(40.0.dp)
    ) {
        // 从12点位置开始
        val startAngle = 270f
        val sweep = coercedProgress() * 360f
        val adjustedGapSize =
            if (线条端点 == StrokeCap.Butt || size.height > size.width) {
                间隔大小
            } else {
                间隔大小 + 线条宽度
            }
        val gapSizeSweep = (adjustedGapSize.value / (PI * size.width.toDp().value).toFloat()) * 360f

        绘制圆形指示器(
            startAngle + sweep + min(sweep, gapSizeSweep),
            360f - sweep - min(sweep, gapSizeSweep) * 2,
            轨道颜色, stroke,
        )
        绘制圆形指示器(startAngle, sweep, 颜色, stroke)
    }
}

private fun DrawScope.绘制圆形指示器(
    开始角度: Float, 扫描: Float, 颜色: Color, 线条: Stroke
) {
    // 要绘制这个圆，我们需要一个矩形，其边缘与笔画的中点对齐。为此，我们需要从总直径的两侧各减去笔画宽度的一半。
    val 直径偏移量 = 线条.width / 2
    val 弧形尺寸 = size.width - 2 * 直径偏移量

    drawArc(
        颜色,开始角度,扫描,false,
        Offset(直径偏移量, 直径偏移量),
        Size(弧形尺寸, 弧形尺寸), style = 线条
    )
}