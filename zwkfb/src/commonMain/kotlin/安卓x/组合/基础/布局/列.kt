package 安卓x.组合.基础.布局

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Measured
import androidx.compose.ui.layout.VerticalAlignmentLine

/**
 * 这是一个垂直布局组件，它会将子元素按垂直方向依次排列。如果需要将子元素按水平方向排列，请参见 [行]。请注意，
 * 默认情况下子元素不会滚动；如需添加滚动行为，请使用 `Modifier.verticalScroll`。
 * 如果需要一个仅组合并布局当前可见项的垂直可滚动列表，请参见 `LazyColumn`。
 *
 * [列] 布局能够根据子元素通过 [ColumnScope.weight] 修饰符提供的权重来分配子元素的高度。如果某个子元素没有提供权重，
 * 则会先询问其首选高度，然后再根据剩余可用空间，按照子元素的权重比例计算具有权重的子元素的尺寸。请注意，
 * 如果 [列] 本身可垂直滚动，或是某个垂直可滚动容器的一部分，则任何提供的权重都将被忽略，因为此时剩余可用空间将是无限的。
 *
 * 当所有子元素都没有权重时，[列] 会尽可能缩小自身高度，使其刚好能够容纳上下堆叠的子元素。若要改变 [列] 的高度，
 * 请使用 [Modifier.height] 等修饰符；例如，若要使其填满可用高度，可以使用 [Modifier.fillMaxHeight]。
 * 如果 [列] 中至少有一个子元素具有 [weight][ColumnScope.weight]，则 [列] 会自动填满可用高度，
 * 因此无需再使用 [Modifier.fillMaxHeight]。不过，如果需要限制 [列] 的尺寸，则应当应用 [Modifier.height]
 * 或 [Modifier.size] 等布局修饰符。
 *
 * 当 [列] 的尺寸大于其子元素尺寸之和时，可以指定 [垂直排列] 来定义子元素在 [列] 内部的位置。
 * 有关可用的定位行为，请参见 [Arrangement]；也可以使用 [Arrangement] 的构造函数自定义排列方式。以下是不同垂直排列方式的示意图：
 *
 * ![列 排列方式](https://developer.android.com/images/reference/androidx/compose/foundation/layout/column_arrangement_visualization.gif)
 *
 * @param 修饰符 要应用到 `列` 上的修饰符。
 * @param 垂直排列 布局子元素的垂直排列方式。
 * @param 水平对齐 布局子元素的水平对齐方式。
 * @param 内容 `列` 的内容
 * @see 行
 * @see [androidx.compose.foundation.lazy.LazyColumn]
 */
@Suppress("ComposableNaming")
@Composable
inline fun 列(
    修饰符: Modifier = Modifier,
    垂直排列: Arrangement.Vertical = Arrangement.Top,
    水平对齐: Alignment.Horizontal = Alignment.Start,
    内容: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = 修饰符,
        verticalArrangement = 垂直排列,
        horizontalAlignment = 水平对齐,
        content = 内容,
    )
}


/** [列] 子元素的作用域。 */
@LayoutScopeMarker
@Immutable
interface 列范围 {

    /**
     * 根据该元素相对于 [列] 中其他具有权重兄弟元素的 [权重] 比例来设置其高度。父布局会在测量完无权重子元素后，
     * 将剩余的垂直空间按照此权重进行分配。当 [填充] 为 `true` 时，该元素将被强制占据分配给它的全部高度；否则，
     * 该元素允许小于分配的高度——这将导致 [列] 整体变小，因为未使用的已分配高度不会被重新分配给其他兄弟元素。
     *
     * 在 [FlowColumn] 中，当某个子项应用了权重时，该子项会根据其所在列中包含的加权子项数量进行缩放。
     *
     * @param 权重 赋予该元素的高度比例，相对于所有具有权重的兄弟元素的总权重而言。必须为正值。
     * @param 填充 当为 `true` 时，该元素将占据所分配的全部高度。
     */
    @Stable
    fun Modifier.权重(
        @FloatRange(from = 0.0, fromInclusive = false) 权重: Float,
        填充: Boolean = true,
    ): Modifier

    /** 在 [列] 内水平对齐该元素。此对齐方式将优先于 [列] 的 `水平对齐` 参数。*/
    @Stable
    fun Modifier.对齐(对齐: Alignment.Horizontal): Modifier

    /**
     * 水平定位该元素，使其 [对齐线] 与同样配置了 [对齐方式] 的兄弟元素对齐。[对齐方式] 是 [对齐] 的一种形式，
     * 因此如果为同一布局同时指定了这两种修饰符，它们将无法同时生效。在 [列] 中，所有使用了 [对齐方式] 的组件将使用
     * 指定的 [VerticalAlignmentLine] 或通过其他 [对齐方式] 重载方法提供的值进行水平对齐，形成一个兄弟元素组。
     * 该兄弟元素组中至少有一个元素会按照在 [列] 中设置了 [Alignment.Start] 对齐的方式来放置，其他兄弟元素的对齐方式将据此确定，
     * 以使对齐线重合。请注意，如果 [列] 中只有一个元素指定了 [对齐方式] 修饰符，则该元素将被定位为其设置了
     * [Alignment.Start] 对齐时的位置。
     */
    @Stable
    fun Modifier.对齐方式(对齐线: VerticalAlignmentLine): Modifier

    /**
     * 水平定位该元素，使其由 [对齐线块] 确定的内容对齐线与同样配置了 [对齐方式] 的兄弟元素对齐。[对齐方式] 是 [对齐] 的一种形式，
     * 因此如果为同一布局同时指定了这两种修饰符，它们将无法同时生效。在 [列] 中，所有使用了 [对齐方式]的组件将使用指定的
     * [VerticalAlignmentLine] 或从 [对齐线块] 获取的值进行水平对齐，形成一个兄弟元素组。该兄弟元素组中至少有一个元素会按照在
     * [列] 中设置了 [Alignment.Start] 对齐的方式来放置，其他兄弟元素的对齐方式将据此确定，以使对齐线重合。请注意，
     * 如果 [列] 中只有一个元素指定了 [对齐方式] 修饰符，则该元素将被定位为其设置了 [Alignment.Start] 对齐时的位置。
     */
    @Stable
    fun Modifier.对齐方式(对齐线块: (Measured) -> Int): Modifier

}


