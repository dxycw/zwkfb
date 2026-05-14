package 安卓x.组合.界面.布局

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MultiContentMeasurePolicy
import androidx.compose.ui.layout.MultiMeasureLayout

/**
 * [布局] 是布局的核心组件。它可用于测量和定位零个或多个布局子项。
 *
 * 此布局的测量、布局和固有测量行为将由 [测量策略] 实例定义。详见 [MeasurePolicy]。
 *
 * 如需一个能够根据传入约束条件来定义其内容的可组合项，请参阅 [androidx.compose.foundation.layout.BoxWithConstraints]。
 *
 * @param 内容 待布局的子可组合项。
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 测量策略 定义布局测量与定位的策略。
 * @see 布局
 * @see MeasurePolicy
 * @see androidx.compose.foundation.layout.BoxWithConstraints
 */
@Suppress("ComposableLambdaParameterPosition", "ComposableNaming")
@UiComposable
@Composable
inline fun 布局(
    内容: @Composable @UiComposable () -> Unit,
    修饰符: Modifier = Modifier,
    测量策略: MeasurePolicy,
) {
    Layout(
        content = 内容,
        modifier = 修饰符,
        measurePolicy = 测量策略,
    )
}

/**
 * [布局] 是"叶"节点布局的核心组件。它可用于测量和定位零个子项
 *
 * 此布局的测量、布局以及固有测量行为将由 [测量策略] 实例定义。详见 [MeasurePolicy]。
 *
 * 如需一个能够根据传入的约束条件来定义其内容的可组合项，请参阅 [androidx.compose.foundation.layout.BoxWithConstraints]。
 *
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 测量策略 定义布局测量与定位的策略。
 * @see 布局
 * @see MeasurePolicy
 * @see androidx.compose.foundation.layout.BoxWithConstraints
 */
@Suppress("NOTHING_TO_INLINE", "ComposableNaming")
@Composable
@UiComposable
inline fun 布局(修饰符: Modifier = Modifier, 测量策略: MeasurePolicy) {
    Layout(modifier = 修饰符, measurePolicy = 测量策略)
}

/**
 * [布局] 是布局的核心组件。它可用于测量和定位零个或多个布局子项。
 *
 * 此重载接受多个可组合内容 lambda 的列表，从而允许对放入不同内容 lambda 中的可测量项进行差异化处理——测量策略将提供一个可测量项列表的列表，
 * 而非单个列表。该列表的大小与传入 [布局] 的内容列表相同，并按相同顺序包含各对应内容 lambda 的可测量项列表。
 *
 *  请注意，作为所有 [内容集] lambda 的一部分发出的布局都将作为此 [布局] 的直接子项添加。这意味着，
 *  如果您在某些子项上设置了自定义 z 索引，绘制顺序将按它们全部作为同一个 lambda 的一部分提供来计算。
 *
 * @param 内容集 待布局的子可组合内容列表。
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 测量策略 定义布局测量与定位的策略。
 * @see 布局 适用于只有一个内容 lambda 的更简单的用例。
 */
@Suppress("ComposableLambdaParameterPosition", "NOTHING_TO_INLINE", "ComposableNaming")
@UiComposable
@Composable
inline fun 布局(
    内容集: List<@Composable @UiComposable () -> Unit>,
    修饰符: Modifier = Modifier,
    测量策略: MultiContentMeasurePolicy,
) {
    Layout(
        contents = 内容集,
        modifier = 修饰符,
        measurePolicy = 测量策略,
    )
}

@Suppress("ComposableLambdaParameterPosition", "ComposableNaming")
@Composable
@UiComposable
@Deprecated("This API is unsafe for UI performance at scale - using it incorrectly will lead " +
            "to exponential performance issues. This API should be avoided whenever possible."
)
fun 多重测量布局(
    修饰符: Modifier = Modifier,
    内容: @Composable @UiComposable () -> Unit,
    测量策略: MeasurePolicy,
) {
    MultiMeasureLayout(
        modifier = 修饰符,
        content = 内容,
        measurePolicy = 测量策略,
    )
}


