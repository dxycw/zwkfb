package 安卓x.组合.基础.懒加载.交错网格

import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 纵向交错网格布局，仅组合并排列当前屏幕上可见的条目。
 *
 * @param 列集 交错网格列的尺寸和数量描述。
 * @param 修饰符 应用于布局的修饰符。
 * @param 状态 可用于控制和观察交错网格状态的状态对象。
 * @param 内容内边距 内容周围的内边距。
 * @param 反向布局 反转滚动和布局的方向。当为 `true` 时，条目按相反顺序排列，且
 * [LazyStaggeredGridState.firstVisibleItemIndex] == 0 表示网格已滚动到底部。
 * @param 垂直项间距 条目之间的纵向间距。
 * @param 水平排列 指定条目之间横向间距的排列方式。条目的具体排列细节目前被忽略。
 * @param 抛掷行为 负责处理快速滑动（fling）的逻辑。
 * @param 用户滚动已启用 是否允许通过手势或无障碍操作进行滚动。当 [用户滚动已启用] 设置为 `false` 时，
 * 仍可通过状态以编程方式滚动。
 * @param 过度滚动效果 用于为此布局渲染 overscroll 效果的 [OverscrollEffect]。注意，[OverscrollEffect.node]
 * 也会在内部被应用——您无需单独使用 Modifier.overscroll。
 * @param 内容 描述交错网格内容的 lambda。在此代码块中，您可以使用 [LazyStaggeredGridScope.items] 来呈现条目列表，
 * 或使用 [LazyStaggeredGridScope.item] 来呈现单个条目。
 */
@Suppress("ComposableNaming")
@Composable
fun 懒加载垂直交错网格(
    列集: StaggeredGridCells,
    修饰符: Modifier = Modifier,
    状态: LazyStaggeredGridState = rememberLazyStaggeredGridState(),
    内容内边距: PaddingValues = PaddingValues(0.dp),
    反向布局: Boolean = false,
    垂直项间距: Dp = 0.dp,
    水平排列: Arrangement.Horizontal = Arrangement.spacedBy(0.dp),
    抛掷行为: FlingBehavior = ScrollableDefaults.flingBehavior(),
    用户滚动已启用: Boolean = true,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    内容: LazyStaggeredGridScope.() -> Unit,
) =
    LazyVerticalStaggeredGrid(
        columns = 列集,
        modifier = 修饰符,
        state = 状态,
        contentPadding = 内容内边距,
        reverseLayout = 反向布局,
        verticalItemSpacing = 垂直项间距,
        horizontalArrangement = 水平排列,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        overscrollEffect = 过度滚动效果,
        content = 内容,
    )


/**
 * 横向交错网格布局，仅组合并排列当前屏幕上可见的条目。
 *
 * @param 行集 交错网格列的尺寸和数量描述。
 * @param 修饰符 应用于布局的修饰符。
 * @param 状态 可用于控制和观察交错网格状态的状态对象。
 * @param 内容内边距 内容周围的内边距。
 * @param 反向布局 反转滚动和布局的方向。当为 `true` 时，条目按相反顺序排列，且
 * [LazyStaggeredGridState.firstVisibleItemIndex] == 0 表示网格已滚动到末尾。
 * @param 垂直排列 指定条目之间纵向间距的排列方式。条目的具体排列细节目前被忽略。
 * @param 水平项间距 条目之间的横向间距。
 * @param 抛掷行为 负责处理快速滑动（fling）的逻辑。
 * @param 用户滚动已启用 是否允许通过手势或无障碍操作进行滚动。当 [用户滚动已启用] 设置为 `false` 时，
 * 仍可通过状态以编程方式滚动。
 * @param 过度滚动效果 用于为此布局渲染 overscroll 效果的 [OverscrollEffect]。注意，[OverscrollEffect.node]
 * 也会在内部被应用——您无需单独使用 Modifier.overscroll。
 * @param 内容 描述交错网格内容的 lambda。在此代码块中，您可以使用 [LazyStaggeredGridScope.items] 来呈现条目列表，
 * 或使用 [LazyStaggeredGridScope.item] 来呈现单个条目。
 */
@Suppress("ComposableNaming")
@Composable
fun 懒加载水平交错网格(
    行集: StaggeredGridCells,
    修饰符: Modifier = Modifier,
    状态: LazyStaggeredGridState = rememberLazyStaggeredGridState(),
    内容内边距: PaddingValues = PaddingValues(0.dp),
    反向布局: Boolean = false,
    垂直排列: Arrangement.Vertical = Arrangement.spacedBy(0.dp),
    水平项间距: Dp = 0.dp,
    抛掷行为: FlingBehavior = ScrollableDefaults.flingBehavior(),
    用户滚动已启用: Boolean = true,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    内容: LazyStaggeredGridScope.() -> Unit,
) =
    LazyHorizontalStaggeredGrid(
        rows = 行集,
        modifier = 修饰符,
        state = 状态,
        contentPadding = 内容内边距,
        reverseLayout = 反向布局,
        verticalArrangement = 垂直排列,
        horizontalItemSpacing = 水平项间距,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        overscrollEffect = 过度滚动效果,
        content = 内容,
    )



/** 下方 [LazyStaggeredGridScope] 的 DSL 标记。 */
@DslMarker internal annotation class LazyStaggeredGridScopeMarker


/** [LazyVerticalStaggeredGrid] 和 [LazyHorizontalStaggeredGrid] 的接收者范围。 */
@LazyStaggeredGridScopeMarker
sealed interface 懒加载交错网格范围 { // LazyStaggeredGridScope

    /**
     * 向交错网格添加单个条目。
     *
     * @param 键 一个代表条目的稳定且唯一的键。该键必须能通过 Android 上的 Bundle 进行保存。如果设置为 null（默认值），
     * 则将使用条目的位置作为键。在交错网格中对多个条目使用相同的键是不允许的。此行为可通过调用
     * [LazyStaggeredGridState.requestScrollToItem] 来覆盖。
     *
     * 当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。
     *
     * @param 内容类型 代表条目的内容类型。相同类型条目的内容可以被更高效地复用。null 同样是有效的类型，
     * 且该类型的条目将被视为兼容。
     * @param 跨度 此条目的自定义跨度。跨度配置了该条目将占据由 [StaggeredGridCells] 定义的多少条通道。默认情况下，
     * 每个条目占据一条通道。
     * @param 内容 当前条目显示的 composable 内容。
     */
    fun 项(
        键: Any? = null,
        内容类型: Any? = null,
        跨度: StaggeredGridItemSpan? = null,
        内容: @Composable LazyStaggeredGridItemScope.() -> Unit,
    )

    /**
     * 向交错网格添加 [count] 个条目。
     *
     * @param 数量 要添加的条目数量。
     * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。该键必须能通过 Android 上的 Bundle 进行保存。如果设置为 null（默认值），
     * 则将使用条目的位置作为键。在交错网格中对多个条目使用相同的键是不允许的。此行为可通过调用 [LazyStaggeredGridState.requestScrollToItem] 来覆盖。
     *
     * 当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。
     *
     * @param 内容类型 一个代表条目内容类型的工厂。相同类型条目的内容可以被更高效地复用。null 同样是有效的类型，
     * 且该类型的条目将被视为兼容。
     * @param 跨度 一个用于生成此条目自定义跨度的工厂。跨度配置了该条目将占据由 [StaggeredGridCells] 定义的多少条通道。
     * 默认情况下，每个条目占据一条通道。
     * @param 项内容 由指定位置的条目显示的 composable 内容。
     */
    fun 项集(
        数量: Int,
        键: ((index: Int) -> Any)? = null,
        内容类型: (index: Int) -> Any? = { null },
        跨度: ((index: Int) -> StaggeredGridItemSpan)? = null,
        项内容: @Composable LazyStaggeredGridItemScope.(index: Int) -> Unit,
    )

}

//=================================================================================

/**
 * 向交错网格添加单个条目。
 *
 * @param 键 一个代表条目的稳定且唯一的键。该键必须能通过 Android 上的 Bundle 进行保存。如果设置为 null（默认值），
 * 则将使用条目的位置作为键。在交错网格中对多个条目使用相同的键是不允许的。此行为可通过调用
 * [LazyStaggeredGridState.requestScrollToItem] 来覆盖。
 *
 * 当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。
 *
 * @param 内容类型 代表条目的内容类型。相同类型条目的内容可以被更高效地复用。null 同样是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 跨度 此条目的自定义跨度。跨度配置了该条目将占据由 [StaggeredGridCells] 定义的多少条通道。默认情况下，
 * 每个条目占据一条通道。
 * @param 内容 当前条目显示的 composable 内容。
 */
fun LazyStaggeredGridScope.项(
    键: Any? = null,
    内容类型: Any? = null,
    跨度: StaggeredGridItemSpan? = null,
    内容: @Composable LazyStaggeredGridItemScope.() -> Unit,
) =
    this.item(
        key = 键,
        contentType = 内容类型,
        span = 跨度,
        content = 内容
    )

/**
 * 向交错网格添加 [count] 个条目。
 *
 * @param 数量 要添加的条目数量。
 * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。该键必须能通过 Android 上的 Bundle 进行保存。如果设置为 null（默认值），
 * 则将使用条目的位置作为键。在交错网格中对多个条目使用相同的键是不允许的。此行为可通过调用 [LazyStaggeredGridState.requestScrollToItem] 来覆盖。
 *
 * 当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。
 *
 * @param 内容类型 一个代表条目内容类型的工厂。相同类型条目的内容可以被更高效地复用。null 同样是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 跨度 一个用于生成此条目自定义跨度的工厂。跨度配置了该条目将占据由 [StaggeredGridCells] 定义的多少条通道。
 * 默认情况下，每个条目占据一条通道。
 * @param 项内容 由指定位置的条目显示的 composable 内容。
 */
fun LazyStaggeredGridScope.项集(
    数量: Int,
    键: ((index: Int) -> Any)? = null,
    内容类型: (index: Int) -> Any? = { null },
    跨度: ((index: Int) -> StaggeredGridItemSpan)? = null,
    项内容: @Composable LazyStaggeredGridItemScope.(index: Int) -> Unit,
) =
    this.items(
        count = 数量,
        key = 键,
        contentType = 内容类型,
        span = 跨度,
        itemContent = 项内容
    )

//=================================================================================

/**
 * 向交错网格添加一个条目列表。
 *
 * @param 项集 要展示的数据列表。
 * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。该键必须能通过 Android 上的 Bundle 进行保存。如果设置为 null（默认值），
 * 则将使用条目的位置作为键。在交错网格中对多个条目使用相同的键是不允许的。此行为可通过调用 [LazyStaggeredGridState.requestScrollToItem] 来覆盖。
 *
 * 当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。
 *
 * @param 内容类型 一个代表条目内容类型的工厂。相同类型条目的内容可以被更高效地复用。null 同样是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 跨度 一个用于生成此条目自定义跨度的工厂。跨度配置了该条目将占据由 [StaggeredGridCells] 定义的多少条通道。
 * 默认情况下，每个条目占据一条通道。
 * @param 项内容 由提供的条目显示的 composable 内容。
 */
inline fun <T> LazyStaggeredGridScope.项集(
    项集: List<T>,
    noinline 键: ((item: T) -> Any)? = null,
    crossinline 内容类型: (item: T) -> Any? = { null },
    noinline 跨度: ((item: T) -> StaggeredGridItemSpan)? = null,
    crossinline 项内容: @Composable LazyStaggeredGridItemScope.(item: T) -> Unit,
) =
    this.items(
        items = 项集,
        key = 键,
        contentType = 内容类型,
        span = 跨度,
        itemContent = 项内容,
    )


/**
 * 向交错网格添加一个内容可感知索引的条目列表。
 *
 * @param 项集 要展示的数据列表。
 * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。该键必须能通过 Android 上的 Bundle 进行保存。如果设置为 null（默认值），
 * 则将使用条目的位置作为键。在交错网格中对多个条目使用相同的键是不允许的。此行为可通过调用 [LazyStaggeredGridState.requestScrollToItem] 来覆盖。
 *
 * 当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。
 *
 * @param 内容类型 一个代表条目内容类型的工厂。相同类型条目的内容可以被更高效地复用。null 同样是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 跨度 一个用于生成此条目自定义跨度的工厂。跨度配置了该条目将占据由 [StaggeredGridCells] 定义的多少条通道。
 * 默认情况下，每个条目占据一条通道。
 * @param 项内容 给定条目和索引后显示的 composable 内容。
 */
inline fun <T> LazyStaggeredGridScope.项集索引(
    项集: List<T>,
    noinline 键: ((index: Int, item: T) -> Any)? = null,
    crossinline 内容类型: (index: Int, item: T) -> Any? = { _, _ -> null },
    noinline 跨度: ((index: Int, item: T) -> StaggeredGridItemSpan)? = null,
    crossinline 项内容: @Composable LazyStaggeredGridItemScope.(index: Int, item: T) -> Unit,
) =
    this.itemsIndexed(
        items = 项集,
        key = 键,
        contentType = 内容类型,
        span = 跨度,
        itemContent = 项内容,
    )

/**
 * 向交错网格添加一个条目数组。
 *
 * @param 项集 要展示的数据数组。
 * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。该键必须能通过 Android 上的 Bundle 进行保存。如果设置为 null（默认值），
 * 则将使用条目的位置作为键。在交错网格中对多个条目使用相同的键是不允许的。此行为可通过调用 [LazyStaggeredGridState.requestScrollToItem] 来覆盖。
 *
 * 当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。
 *
 * @param 内容类型 一个代表条目内容类型的工厂。相同类型条目的内容可以被更高效地复用。null 同样是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 跨度 一个用于生成此条目自定义跨度的工厂。跨度配置了该条目将占据由 [StaggeredGridCells] 定义的多少条通道。
 * 默认情况下，每个条目占据一条通道。
 * @param 项内容 由提供的条目显示的 composable 内容。
 */
inline fun <T> LazyStaggeredGridScope.项集(
    项集: Array<T>,
    noinline 键: ((item: T) -> Any)? = null,
    crossinline 内容类型: (item: T) -> Any? = { null },
    noinline 跨度: ((item: T) -> StaggeredGridItemSpan)? = null,
    crossinline 项内容: @Composable LazyStaggeredGridItemScope.(item: T) -> Unit,
) =
    this.items(
        items = 项集,
        key = 键,
        contentType = 内容类型,
        span = 跨度,
        itemContent = 项内容,
    )


/**
 * 向交错网格添加一个内容可感知索引的条目数组。
 *
 * @param 项集 要展示的数据数组。
 * @param 键 一个用于生成代表条目的稳定且唯一键的工厂。该键必须能通过 Android 上的 Bundle 进行保存。如果设置为 null（默认值），
 * 则将使用条目的位置作为键。在交错网格中对多个条目使用相同的键是不允许的。此行为可通过调用 [LazyStaggeredGridState.requestScrollToItem] 来覆盖。
 *
 * 当你指定了键时，滚动位置将根据该键进行维护，这意味着如果你在当前可见条目之前添加或移除条目，具有给定键的条目仍将被保留为第一个可见的条目。
 *
 * @param 内容类型 一个代表条目内容类型的工厂。相同类型条目的内容可以被更高效地复用。null 同样是有效的类型，
 * 且该类型的条目将被视为兼容。
 * @param 跨度 一个用于生成此条目自定义跨度的工厂。跨度配置了该条目将占据由 [StaggeredGridCells] 定义的多少条通道。
 * 默认情况下，每个条目占据一条通道。
 * @param 项内容 给定条目和索引后显示的 composable 内容。
 */
inline fun <T> LazyStaggeredGridScope.项集索引(
    项集: Array<T>,
    noinline 键: ((index: Int, item: T) -> Any)? = null,
    crossinline 内容类型: (index: Int, item: T) -> Any? = { _, _ -> null },
    noinline 跨度: ((index: Int, item: T) -> StaggeredGridItemSpan)? = null,
    crossinline 项内容: @Composable LazyStaggeredGridItemScope.(index: Int, item: T) -> Unit,
) =
    this.itemsIndexed(
        items = 项集,
        key = 键,
        contentType = 内容类型,
        span = 跨度,
        itemContent = 项内容,
    )

