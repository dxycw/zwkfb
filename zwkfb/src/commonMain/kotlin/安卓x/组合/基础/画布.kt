package 安卓x.组合.基础

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * 允许您在屏幕上指定一个区域并在该区域执行画布绘制操作的组件。您**必须**通过修饰符指定大小，可以使用 [androidx.compose.foundation.layout.size]
 * 修饰符指定精确尺寸，或使用 [androidx.compose.foundation.layout.fillMaxSize]、[ColumnScope.weight] 等方式相对于父容器指定。
 * 如果父容器包裹此子项，则只能指定精确尺寸。
 *
 * @param 修饰符 用于指定此可组合组件尺寸策略的必需修饰符。
 * @param 绘制回调 用于执行绘图的 lambda 表达式。请注意，此 lambda 表达式会在绘制阶段（draw stage）被调用，此时你无法访问组合作用域
 * （composition scope），这意味着在其中调用 [Composable] 函数将导致运行时异常。
 */
@Suppress("ComposableNaming")
@Composable
fun 画布(修饰符: Modifier, 绘制回调: DrawScope.() -> Unit) = Canvas(modifier = 修饰符, onDraw = 绘制回调)

/**
 * 允许您在屏幕上指定一个区域并在该区域执行画布绘制操作的组件。您**必须**通过修饰符指定大小，可以使用 [androidx.compose.foundation.layout.size]
 * 修饰符指定精确尺寸，或使用 [androidx.compose.foundation.layout.fillMaxSize]、[ColumnScope.weight] 等方式相对于父容器指定。
 * 如果父容器包裹此子项，则只能指定精确尺寸。
 *
 * @param 修饰符 用于指定此可组合组件尺寸策略的必需修饰符。
 * @param 内容描述 供辅助功能服务（如屏幕阅读器）用来描述此画布内容的文本。除非该画布仅用于装饰目的，
 * 或者其所属的更大实体已通过其他方式进行了描述，否则都应提供此文本。此文本应当是本地化的，例如通过使用 [androidx.compose.ui.res.stringResource] 来获取。
 * @param 绘制回调 用于执行绘图的 lambda 表达式。请注意，此 lambda 表达式会在绘制阶段（draw stage）被调用，此时你无法访问组合作用域
 * （composition scope），这意味着在其中调用 [Composable] 函数将导致运行时异常。
 */
@Suppress("ComposableNaming")
@Composable
fun 画布(修饰符: Modifier, 内容描述: String, 绘制回调: DrawScope.() -> Unit) =
    Canvas(modifier = 修饰符, contentDescription = 内容描述, onDraw = 绘制回调)
