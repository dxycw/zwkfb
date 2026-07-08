package 安卓x.组合.基础.懒加载.网格

import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyGridScopeMarker
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 一个懒加载的垂直网格布局。它只会渲染可见的网格行。
 *
 * @param 列集 描述网格的列数和大小，更多信息请参阅 [GridCells] 文档。
 * @param 修饰符 应用于该布局的修饰符。
 * @param 状态 用于控制或观察列表状态的状态对象。
 * @param 内容内边距 指定整个内容周围的内边距。
 * @param 反向布局 反转滚动和布局的方向。当为 `true` 时，项将以相反的顺序进行布局，且
 * [LazyGridState.firstVisibleItemIndex] == 0 表示网格已滚动到底部。注意，[反向布局] 不会改变
 * [垂直排列] 的行为，例如，使用 [Arrangement.Top] 时，(顶部) 123### (底部) 将变为 (顶部) 321### (底部)。
 * @param 垂直排列 布局子项的垂直排列方式。
 * @param 水平排列 布局子项的水平排列方式。
 * @param 抛掷行为 描述快速滑动（fling）行为的逻辑。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。即使禁用了该功能，你仍然可以使用状态以编程方式进行滚动。
 * @param 过度滚动效果 用于为该布局渲染过滚动效果的 [OverscrollEffect]。注意，[OverscrollEffect.node]
 * 也将在内部被应用——你无需单独使用 `Modifier.overscroll`。
 * @param 内容 描述内容的 [LazyGridScope]。
 */
@Suppress("ComposableNaming")
@Composable
fun 懒加载垂直网格(
    列集: GridCells,
    修饰符: Modifier = Modifier,
    状态: LazyGridState = rememberLazyGridState(),
    内容内边距: PaddingValues = PaddingValues(0.dp),
    反向布局: Boolean = false,
    垂直排列: Arrangement.Vertical = if (!反向布局) Arrangement.Top else Arrangement.Bottom,
    水平排列: Arrangement.Horizontal = Arrangement.Start,
    抛掷行为: FlingBehavior = ScrollableDefaults.flingBehavior(),
    用户滚动已启用: Boolean = true,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    内容: LazyGridScope.() -> Unit,
) =
    LazyVerticalGrid(
        columns = 列集,
        modifier = 修饰符,
        state = 状态,
        contentPadding = 内容内边距,
        reverseLayout = 反向布局,
        verticalArrangement = 垂直排列,
        horizontalArrangement = 水平排列,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        overscrollEffect = 过度滚动效果,
        content = 内容,
    )


/**
 * 一个懒加载的横向网格布局。它只组合网格中可见的列。
 *
 * @param 行集 描述单元格如何组成行的类，更多信息请参阅 [GridCells] 文档。
 * @param 修饰符 应用于该布局的修饰符。
 * @param 状态 用于控制或观察列表状态的状态对象。
 * @param 内容内边距 指定整个内容周围的内边距。
 * @param 反向布局 反转滚动和布局的方向。当为 `true` 时，项将以相反的顺序进行布局，且
 * [LazyGridState.firstVisibleItemIndex] == 0 表示网格已滚动到末尾。注意，[反向布局] 不会改变
 * [水平排列] 的行为，例如，使用 [Arrangement.Start] 时，[123###] 将变为 [321###]。
 * @param 垂直排列 布局子项的垂直排列方式。
 * @param 水平排列 布局子项的水平排列方式。
 * @param 抛掷行为 描述快速滑动（fling）行为的逻辑。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。即使禁用了该功能，你仍然可以使用状态以编程方式进行滚动。
 * @param 过度滚动效果 用于为该布局渲染过滚动效果的 [OverscrollEffect]。注意，[OverscrollEffect.node]
 * 也将在内部被应用——你无需单独使用 `Modifier.overscroll`。
 * @param 内容 描述内容的 [LazyGridScope]。
 */
@Suppress("ComposableNaming")
@Composable
fun 懒加载水平网格(
    行集: GridCells,
    修饰符: Modifier = Modifier,
    状态: LazyGridState = rememberLazyGridState(),
    内容内边距: PaddingValues = PaddingValues(0.dp),
    反向布局: Boolean = false,
    水平排列: Arrangement.Horizontal = if (!反向布局) Arrangement.Start else Arrangement.End,
    垂直排列: Arrangement.Vertical = Arrangement.Top,
    抛掷行为: FlingBehavior = ScrollableDefaults.flingBehavior(),
    用户滚动已启用: Boolean = true,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    内容: LazyGridScope.() -> Unit,
) =
    LazyHorizontalGrid(
        rows = 行集,
        modifier = 修饰符,
        state = 状态,
        contentPadding = 内容内边距,
        reverseLayout = 反向布局,
        horizontalArrangement = 水平排列,
        verticalArrangement = 垂直排列,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        overscrollEffect = 过度滚动效果,
        content = 内容,
    )


/** 这个类描述了垂直网格中列的数量和大小，或者水平网格中行的数量和大小。*/
@Stable
interface 网格单元 { // GridCells

    /**
     * 根据 [可用大小] 和 [间距] 计算单元格数量及其交叉轴尺寸。
     *
     * 例如，在垂直网格中，[间距] 来自网格的 [Arrangement.Horizontal]。如果网格的宽度大于计算出的各列宽度之和，
     * [Arrangement.Horizontal] 还将用于在行内排列项。
     *
     * 注意，计算出的交叉轴尺寸将以支持 RTL（从右到左）的方式处理——如果网格是垂直的且布局方向为 RTL，则返回列表中的第一个宽度将对应最右侧的列。
     *
     * @param 可用大小 交叉轴上的可用尺寸，例如 [LazyVerticalGrid] 的宽度。
     * @param 间距 交叉轴间距，例如 [LazyVerticalGrid] 的水平间距。该间距来自懒加载网格对应的 [Arrangement] 参数。
     */
    fun Density.计算交叉轴单元大小(可用大小: Int, 间距: Int): List<Int>

    /**
     * 定义一个具有固定行数或列数的网格。
     *
     * 例如，对于垂直的 [LazyVerticalGrid]，`Fixed(3)` 表示有 3 列，每列占父容器宽度的 1/3。
     */
    class 固定(private val 数量: Int) : GridCells {
        init {
            GridCells.Fixed(数量)
        }

        override fun Density.calculateCrossAxisCellSizes(
            availableSize: Int,
            spacing: Int,
        ): List<Int> {
            return calculateCellsCrossAxisSizeImpl(availableSize, 数量, spacing)
        }

        override fun hashCode(): Int {
            return -数量 // Different sign from Adaptive.
        }

        override fun equals(other: Any?): Boolean {
            return other is 固定 && 数量 == other.数量
        }
    }

    /**
     * 定义一个网格，使其在确保每个单元格至少有 [最小大小] 空间的前提下，尽可能多地容纳行或列，并将所有额外空间均匀分配。
     *
     * 例如，对于垂直的 [LazyVerticalGrid]，`Adaptive(20.dp)` 表示将尽可能多地容纳列，且每列宽度至少为 20.dp，
     * 所有列的宽度相等。如果屏幕宽度为 88.dp，则会有 4 列，每列 22.dp。
     */
    class 自适应(private val 最小大小: Dp) : GridCells {
        init {
            GridCells.Adaptive(最小大小)
        }

        override fun Density.calculateCrossAxisCellSizes(
            availableSize: Int,
            spacing: Int,
        ): List<Int> {
            val count = maxOf((availableSize + spacing) / (最小大小.roundToPx() + spacing), 1)
            return calculateCellsCrossAxisSizeImpl(availableSize, count, spacing)
        }

        override fun hashCode(): Int {
            return 最小大小.hashCode()
        }

        override fun equals(other: Any?): Boolean {
            return other is 自适应 && 最小大小 == other.最小大小
        }
    }

    /**
     * 定义一个网格，使每个单元格恰好占用 [大小] 空间的前提下，尽可能多地容纳行或列。剩余空间将通过 [LazyGrid] 在对应
     * 轴上的排列方式来分配。如果 [大小] 大于容器尺寸，则单元格将被调整为与容器匹配。
     *
     * 例如，对于垂直的 [LazyGrid]，`FixedSize(20.dp)` 表示将尽可能多地容纳列，且每列宽度恰好为 20.dp。
     * 如果屏幕宽度为 88.dp，则会有 4 列，每列 20.dp，剩余的 8.dp 将通过 [Arrangement.Horizontal] 进行分配。
     */
    class 固定大小(private val 大小: Dp) : GridCells {

        init {
            GridCells.FixedSize(大小)
        }

        override fun Density.calculateCrossAxisCellSizes(
            availableSize: Int,
            spacing: Int,
        ): List<Int> {
            val cellSize = 大小.roundToPx()
            return if (cellSize + spacing < availableSize + spacing) {
                val cellCount = (availableSize + spacing) / (cellSize + spacing)
                List(cellCount) { cellSize }
            } else {
                List(1) { availableSize }
            }
        }

        override fun hashCode(): Int {
            return 大小.hashCode()
        }

        override fun equals(other: Any?): Boolean {
            return other is 固定大小 && 大小 == other.大小
        }

    }

}

private fun calculateCellsCrossAxisSizeImpl(
    gridSize: Int,
    slotCount: Int,
    spacing: Int,
): List<Int> {
    val gridSizeWithoutSpacing = gridSize - spacing * (slotCount - 1)
    val slotSize = gridSizeWithoutSpacing / slotCount
    val remainingPixels = gridSizeWithoutSpacing % slotCount
    return List(slotCount) { slotSize + if (it < remainingPixels) 1 else 0 }
}


/** [LazyVerticalGrid] 使用的接收者范围。 */
@LazyGridScopeMarker
sealed interface 懒加载网格范围 { // LazyGridScope

    /**
     * 向范围中添加单个条目。
     *
     * @param 键 一个代表条目的稳定且唯一的键。在网格中对多个条目使用相同的键是不允许的。键的类型应能通过 Android 上的
     * Bundle 进行保存。如果传入 null，则网格中的位置将作为键。当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你
     * 在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。此行为可通过调用 [LazyGridState.requestScrollToItem] 来覆盖。
     * @param 跨度 条目的跨度。默认值为 1x1。当这与预期行为一致时，建议将其留为 null，因为提供自定义实现会影响性能。
     * @param 内容类型 此条目的内容类型。相同类型的条目组合实例可以被更高效地复用。注意，null 是有效的类型，
     * 且该类型的条目将被视为兼容。
     * @param 内容 条目的内容
     */
    fun 项(
        键: Any? = null,
        跨度: (LazyGridItemSpanScope.() -> GridItemSpan)? = null,
        内容类型: Any? = null,
        内容: @Composable LazyGridItemScope.() -> Unit,
    )

    /**
     * 添加 [数量] 个条目。
     *
     * @param 数量 条目数量
     * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。在网格中对多个条目使用相同的键是不允许的。键的类型应能通过 Android
     * 上的 Bundle 进行保存。如果传入 null，则网格中的位置将作为键。当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你
     * 在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。此行为可通过调用 [LazyGridState.requestScrollToItem] 来覆盖。
     * @param 跨度 为条目定义自定义跨度。默认值为 1x1。当这与预期行为一致时，建议将其留为 null，因为提供自定义实现会影响性能。
     * @param 内容类型 单个条目的内容类型的工厂。相同类型的条目组合实例可以被更高效地复用。注意，null 是有效的类型，
     * 且该类型的条目将被视为兼容。
     * @param 项内容 单个条目所显示的内容
     */
    fun 项集(
        数量: Int,
        键: ((index: Int) -> Any)? = null,
        跨度: (LazyGridItemSpanScope.(index: Int) -> GridItemSpan)? = null,
        内容类型: (index: Int) -> Any? = { null },
        项内容: @Composable LazyGridItemScope.(index: Int) -> Unit,
    )

    /**
     * 添加一个粘性页眉条目，即使滚动经过它之后，该页眉仍将保持固定。页眉将保持固定，直到下一个页眉取代其位置。粘性页眉是
     * 跨满全行的条目，即它们将占据 [LazyGridItemSpanScope.maxLineSpan]。
     *
     * @param 键 一个代表条目的稳定且唯一的键。在列表中对多个条目使用相同的键是不允许的。键的类型应能通过 Android 上的
     * Bundle 进行保存。如果传入 null，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你
     * 在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。此行为可通过在 `LazyGridState`
     * 上调用 `requestScrollToItem` 来覆盖。
     * @param 内容类型 此条目的内容类型。相同类型的条目组合实例可以被更高效地复用。注意，null 是有效的类型，
     * 且该类型的条目将被视为兼容。
     * @param 内容 页眉的内容。提供页眉的索引，即该页眉在此懒加载列表全部条目中的位置（全局索引）。
     */
    fun 粘性标题(
        键: Any? = null,
        内容类型: Any? = null,
        内容: @Composable LazyGridItemScope.(Int) -> Unit,
    )

}


//====================================================================================

/**
 * 向作用域中添加单个条目。
 *
 * @param 键 一个代表条目的稳定且唯一的键。在网格中对多个条目使用相同的键是不允许的。键的类型应能通过 Android 上的
 * Bundle 进行保存。如果传入 null，则网格中的位置将作为键。当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你
 * 在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。此行为可通过调用 [LazyGridState.requestScrollToItem] 来覆盖。
 * @param 跨度 条目的跨度。默认值为 1x1。当这与预期行为一致时，建议将其留为 null，因为提供自定义实现会影响性能。
 * @param 内容类型 此条目的内容类型。相同类型的条目组合实例可以被更高效地复用。注意，null 是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 内容 条目的内容
 */
fun LazyGridScope.项(
    键: Any? = null,
    跨度: (LazyGridItemSpanScope.() -> GridItemSpan)? = null,
    内容类型: Any? = null,
    内容: @Composable LazyGridItemScope.() -> Unit,
) =
    this.item(
        key = 键,
        span = 跨度,
        contentType = 内容类型,
        content = 内容,
    )

/**
 * 添加 [数量] 个条目。
 *
 * @param 数量 条目数量
 * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。在网格中对多个条目使用相同的键是不允许的。键的类型应能通过 Android
 * 上的 Bundle 进行保存。如果传入 null，则网格中的位置将作为键。当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你
 * 在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。此行为可通过调用 [LazyGridState.requestScrollToItem] 来覆盖。
 * @param 跨度 为条目定义自定义跨度。默认值为 1x1。当这与预期行为一致时，建议将其留为 null，因为提供自定义实现会影响性能。
 * @param 内容类型 单个条目的内容类型的工厂。相同类型的条目组合实例可以被更高效地复用。注意，null 是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 项内容 单个条目所显示的内容
 */
fun LazyGridScope.项集(
    数量: Int,
    键: ((index: Int) -> Any)? = null,
    跨度: (LazyGridItemSpanScope.(index: Int) -> GridItemSpan)? = null,
    内容类型: (index: Int) -> Any? = { null },
    项内容: @Composable LazyGridItemScope.(index: Int) -> Unit,
) =
    this.items(
        count = 数量,
        key = 键,
        span = 跨度,
        contentType = 内容类型,
        itemContent = 项内容,
    )

/**
 * 添加一个粘性页眉条目，即使滚动经过它之后，该页眉仍将保持固定。页眉将保持固定，直到下一个页眉取代其位置。粘性页眉是
 * 跨满全行的条目，即它们将占据 [LazyGridItemSpanScope.maxLineSpan]。
 *
 * @param 键 一个代表条目的稳定且唯一的键。在列表中对多个条目使用相同的键是不允许的。键的类型应能通过 Android 上的
 * Bundle 进行保存。如果传入 null，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你
 * 在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。此行为可通过在 `LazyGridState`
 * 上调用 `requestScrollToItem` 来覆盖。
 * @param 内容类型 此条目的内容类型。相同类型的条目组合实例可以被更高效地复用。注意，null 是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 内容 页眉的内容。提供页眉的索引，即该页眉在此懒加载列表全部条目中的位置（全局索引）。
 */
fun LazyGridScope.粘性标题(
    键: Any? = null,
    内容类型: Any? = null,
    内容: @Composable LazyGridItemScope.(Int) -> Unit,
) =
    this.stickyHeader(
        key = 键,
        contentType = 内容类型,
        content = 内容,
    )

//====================================================================================

/**
 * 添加一个条目列表。
 *
 * @param 项集 数据列表
 * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。在网格中对多个条目使用相同的键是不允许的。键的类型应能通过 Android
 * 上的 Bundle 进行保存。如果传入 null，则网格中的位置将作为键。当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在
 * 当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。此行为可通过调用 [LazyGridState.requestScrollToItem] 来覆盖。
 * @param 跨度 为条目定义自定义跨度。默认值为 1x1。当这与预期行为一致时，建议将其留为 null，因为提供自定义实现会影响性能。
 * @param 内容类型 单个条目的内容类型的工厂。相同类型的条目组合实例可以被更高效地复用。注意，null 是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 项内容 单个条目所显示的内容
 */
inline fun <T> LazyGridScope.项集(
    项集: List<T>,
    noinline 键: ((item: T) -> Any)? = null,
    noinline 跨度: (LazyGridItemSpanScope.(item: T) -> GridItemSpan)? = null,
    noinline 内容类型: (item: T) -> Any? = { null },
    crossinline 项内容: @Composable LazyGridItemScope.(item: T) -> Unit,
) =
    this.items(
        items = 项集,
        key = 键,
        span = 跨度,
        contentType = 内容类型,
        itemContent = 项内容
    )

/**
 * 添加一个条目列表，其中每个条目的内容都能感知其索引。
 *
 * @param 项集 数据列表
 * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。在网格中对多个条目使用相同的键是不允许的。键的类型应能通过 Android
 * 上的 Bundle 进行保存。如果传入 null，则网格中的位置将作为键。当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你
 * 在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。此行为可通过调用 [LazyGridState.requestScrollToItem] 来覆盖。
 * @param 跨度 为条目定义自定义跨度。默认值为 1x1。当这与预期行为一致时，建议将其留为 null，因为提供自定义实现会影响性能。
 * @param 内容类型 单个条目的内容类型的工厂。相同类型的条目组合实例可以被更高效地复用。注意，null 是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 项内容 单个条目所显示的内容
 */
inline fun <T> LazyGridScope.项集索引(
    项集: List<T>,
    noinline 键: ((index: Int, item: T) -> Any)? = null,
    noinline 跨度: (LazyGridItemSpanScope.(index: Int, item: T) -> GridItemSpan)? = null,
    crossinline 内容类型: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline 项内容: @Composable LazyGridItemScope.(index: Int, item: T) -> Unit,
) =
    this.itemsIndexed(
        items = 项集,
        key = 键,
        span = 跨度,
        contentType = 内容类型,
        itemContent = 项内容
    )

/**
 * 添加一个数组项集合。
 *
 * @param 项集 数据数组
 * @param 键 表示该网格项的稳定且唯一的键。在网格中对多个项使用相同的键是不允许的。键的类型必须能够通过 Android 上的
 * Bundle 进行保存。如果传入 `null`，则网格中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，这意味着如果你在可
 * 见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过调用 [LazyGridState.requestScrollToItem] 来覆盖。
 * @param 跨度 为列表项定义自定义跨度。默认值为 1x1。当默认行为符合预期时，建议将其保留为 `null`，因为提供自定义实现会影响性能。
 * @param 内容类型 用于生成列表项内容类型的工厂函数。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
 * 具有该类型的项将被视为兼容的。
 * @param 项内容 由单个列表项显示的内容。
 */
inline fun <T> LazyGridScope.项集(
    项集: Array<T>,
    noinline 键: ((item: T) -> Any)? = null,
    noinline 跨度: (LazyGridItemSpanScope.(item: T) -> GridItemSpan)? = null,
    noinline 内容类型: (item: T) -> Any? = { null },
    crossinline 项内容: @Composable LazyGridItemScope.(item: T) -> Unit,
) =
    this.items(
        items = 项集,
        key = 键,
        span = 跨度,
        contentType = 内容类型,
        itemContent = 项内容
    )

/**
 * 添加一个数组项集合，其中每个数组项的内容能够感知到自身的索引。
 *
 * @param 项集 数据数组
 * @param 键 表示该网格项的稳定且唯一的键。在网格中对多个项使用相同的键是不允许的。键的类型必须能够通过 Android 上的
 * Bundle 进行保存。如果传入 `null`，则网格中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，这意味着如果你在可
 * 见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过调用 [LazyGridState.requestScrollToItem] 来覆盖。
 * @param 跨度 为列表项定义自定义跨度。默认值为 1x1。当默认行为符合预期时，建议将其保留为 `null`，因为提供自定义实现会影响性能。
 * @param 内容类型 用于生成列表项内容类型的工厂函数。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
 * 具有该类型的项将被视为兼容的。
 * @param 项内容 由单个列表项显示的内容。
 */
inline fun <T> LazyGridScope.项集索引(
    项集: Array<T>,
    noinline 键: ((index: Int, item: T) -> Any)? = null,
    noinline 跨度: (LazyGridItemSpanScope.(index: Int, item: T) -> GridItemSpan)? = null,
    crossinline 内容类型: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline 项内容: @Composable LazyGridItemScope.(index: Int, item: T) -> Unit,
) =
    this.itemsIndexed(
        items = 项集,
        key = 键,
        span = 跨度,
        contentType = 内容类型,
        itemContent = 项内容
    )
