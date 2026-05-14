package 安卓x.组合.基础.布局

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.Measured

/**
 * 这是一个将子元素按水平方向依次排列的布局组件。如果需要将子元素按垂直方向排列，请参见 [列]。请注意，默认情况下子元素不会滚动；
 * 如需添加滚动行为，请使用 `Modifier.horizontalScroll`。 如果需要一个仅组合并布局当前可见项的水平可滚动列表，请参见 `LazyRow`。
 *
 * [行] 布局能够根据子元素通过 [RowScope.weight] 修饰符提供的权重来分配子元素的宽度。 如果某个子元素没有提供权重，
 * 则会先询问其首选宽度，然后再根据剩余可用空间，按照子元素的权重比例计算具有权重的子元素的尺寸。 请注意，如果 [行] 本身可水平滚动，
 * 或是某个水平可滚动容器的一部分，则任何提供的权重都将被忽略，因为此时剩余可用空间将是无限的。
 *
 * 当所有子元素都没有权重时，[行] 会尽可能缩小自身宽度，使其刚好能够容纳并排排列的子元素。若要改变 [行] 的宽度，
 * 请使用 [Modifier.width] 等修饰符；例如，若要使其填满可用宽度，可以使用 [Modifier.fillMaxWidth]。 如果 [行]
 * 中至少有一个子元素具有 [weight][RowScope.weight]，则 [行] 会自动填满可用宽度， 因此无需再使用 [Modifier.fillMaxWidth]。
 * 不过，如果需要限制 [行] 的尺寸，则应当应用 [Modifier.width] 或 [Modifier.size] 等布局修饰符。
 *
 * 当 [行] 的尺寸大于其子元素尺寸之和时，可以指定 [水平排列] 来定义子元素在 [行] 内部的位置。有关可用的定位行为，
 * 请参见 [Arrangement]；也可以使用 [Arrangement] 的构造函数自定义排列方式。以下是不同水平排列方式的示意图：
 *
 * ![ 行排列方式](https://developer.android.com/images/reference/androidx/compose/foundation/layout/row_arrangement_visualization.gif)
 *
 * 请注意，如果将两个或更多 Text 组件放置在 [行] 中，通常需要按照它们的首基线对齐。[行] 作为通用容器不会自动执行此操作，
 * 因此开发者需要手动处理。这可以通过为每个此类 Text 组件添加 [RowScope.alignByBaseline] 修饰符来实现。 默认情况下，
 * 该修饰符按 [FirstBaseline] 对齐。但是，如果例如需要按 [LastBaseline] 对齐文本，则应使用更通用的 [RowScope.alignBy] 修饰符。
 *
 * @param 修饰符 要应用到 `行` 上的修饰符。
 * @param 水平排列 子元素在 `行` 内部的水平排列方式。
 * @param 垂直对齐 子元素在 `行` 内部的垂直对齐方式。
 * @param 内容 `行` 的内容。
 * @see 列
 * @see [androidx.compose.foundation.lazy.LazyRow]
 */
@Suppress("ComposableNaming")
@Composable
inline fun 行(
    修饰符: Modifier = Modifier,
    水平排列: Arrangement.Horizontal = Arrangement.Start,
    垂直对齐: Alignment.Vertical = Alignment.Top,
    内容: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = 修饰符,
        horizontalArrangement = 水平排列,
        verticalAlignment = 垂直对齐,
        content = 内容,
    )
}


/** [行] 子元素的作用域。 */
@LayoutScopeMarker
@Immutable
interface 行范围 {

    @Stable
    fun Modifier.权重(
        @FloatRange(from = 0.0, fromInclusive = false) 权重: Float,
        填充: Boolean = true,
    ): Modifier

    /** 在 [行] 内垂直对齐该元素。此对齐方式将优先于 [行] 的 `垂直对齐` 参数。*/
    @Stable
    fun Modifier.对齐(对齐: Alignment.Vertical): Modifier

    /**
     * 垂直定位该元素，使其 [对齐线] 与同样配置了 `对齐方式` 的兄弟元素对齐。`对齐方式` 是 [对齐] 的一种形式，
     * 因此如果为同一布局同时指定了这两种修饰符，它们将无法同时生效。`对齐方式` 可用于在 [行] 内通过`对齐方式(FirstBaseline)`
     * 按基线对齐两个布局。在 [行] 中，所有使用了 `对齐方式` 的组件将使用指定的[HorizontalAlignmentLine] 或通过其他
     * `对齐方式` 重载方法提供的值进行垂直对齐，形成一个兄弟元素组。该兄弟元素组中至少有一个元素会按照在 [行] 中设置了
     * [Alignment.Top] 对齐的方式来放置，其他兄弟元素的对齐方式将据此确定，以使对齐线重合。请注意，如果 [行]
     * 中只有一个元素指定了 `对齐方式` 修饰符，则该元素将被定位为其设置了 [Alignment.Top] 对齐时的位置。
     *
     * @see 按基线对齐
     */
    @Stable
    fun Modifier.对齐方式(对齐线: HorizontalAlignmentLine): Modifier

    /**
     * 垂直定位该元素，使其首基线与同样配置了 `按基线对齐` 或 `对齐方式` 的兄弟元素对齐。此修饰符是 [对齐] 的一种形式，
     * 因此如果为同一布局同时指定了这两种修饰符，它们将无法同时生效。`按基线对齐` 是 `对齐方式` 的一种特例。更多详情请参见 `对齐方式`。
     *
     * @see 对齐方式
     */
    @Stable
    fun Modifier.按基线对齐(): Modifier

    /**
     * 垂直定位该元素，使其由 [对齐线块] 确定的内容对齐线与同样配置了 `对齐方式` 的兄弟元素对齐。`对齐方式`
     * 是 [对齐] 的一种形式，因此如果为同一布局同时指定了这两种修饰符，它们将无法同时生效。在 [行] 中，所有使用了 `对齐方式`
     * 的组件将使用指定的 [HorizontalAlignmentLine] 或从 [对齐线块] 获取的值进行垂直对齐，形成一个兄弟元素组。
     * 该兄弟元素组中至少有一个元素会按照在 [行] 中设置了 [Alignment.Top] 对齐的方式来放置，其他兄弟元素的对齐方式将据此确定，
     * 以使对齐线重合。请注意，如果 [行] 中只有一个元素指定了 `对齐方式` 修饰符，则该元素将被定位为其设置了 [Alignment.Top] 对齐时的位置。
     */
    @Stable
    fun Modifier.对齐方式(对齐线块: (Measured) -> Int): Modifier

}

