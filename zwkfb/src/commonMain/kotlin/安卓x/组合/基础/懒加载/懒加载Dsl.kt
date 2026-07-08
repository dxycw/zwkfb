package 安卓x.组合.基础.懒加载

import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyScopeMarker
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** [LazyColumn] 和 [LazyRow] 使用的接收器范围。 */
@LazyScopeMarker
interface 懒加载列表范围 { // LazyListScope

    /**
     * 添加一件物品。
     *
     * @param 键 一个稳定且唯一的键来表示该项目。列表中不允许为多个项目使用相同的键。键的类型应该可以通过 Android 的 Bundle 保存。
     * 如果传入 null，列表中的位置将表示键。当你指定键时，滚动位置将基于该键保持不变，这意味着如果在当前可见项目之前添加或删除项目，
     * 给定键的项目将保持为第一个可见项目。你可以通过在 'LazyListState' 上调用 'requestScrollToItem' 来覆盖这一点。
     * @param 内容类型 该项内容的类型。相同类型的项可以更高效地重复使用。请注意，null 是一个有效类型，属于此类型的项将被视为兼容。
     * @param 内容 项的内容
     */
    fun 项(
        键: Any? = null,
        内容类型: Any? = null,
        内容: @Composable LazyItemScope.() -> Unit,
    ) {
        error("The method is not implemented")
    }

    /**
     * 添加 [count] 个物品。
     *
     * @param 数量 物品数量
     * @param 键 用于生成表示列表项的稳定且唯一键的工厂函数。在列表中对多个项使用相同的键是不允许的。键的类型必须能够通过
     * Android 上的 Bundle 进行保存。如果传入 `null`，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，
     * 这意味着如果你在可见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过在 `LazyListState` 上调
     * 用 `requestScrollToItem` 来覆盖。
     * @param 内容类型 用于生成列表项内容类型的工厂函数。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
     * 具有该类型的项将被视为兼容的。
     * @param 项内容 由单个列表项显示的内容。
     */
    fun 项集(
        数量: Int,
        键: ((index: Int) -> Any)? = null,
        内容类型: (index: Int) -> Any? = { null },
        项内容: @Composable LazyItemScope.(index: Int) -> Unit,
    ) {
        error("The method is not implemented")
    }

    /**
     * 添加一个粘性标题项，即使在其后滚动时，该标题也会保持固定。该标题将保持固定，直到下一个标题取代它的位置。
     *
     * @param 键 表示该列表项的稳定且唯一的键。在列表中对多个项使用相同的键是不允许的。键的类型必须能够通过 Android
     * 上的 Bundle 进行保存。如果传入 `null`，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，
     * 这意味着如果你在可见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过在 `LazyListState` 上
     * 调用 `requestScrollToItem` 来覆盖。
     * @param 内容类型 该列表项内容的类型。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
     * 具有该类型的项将被视为兼容的。
     * @param 内容 标题的内容，同时提供标题的索引，即该标题在此懒加载列表中所有项的位置（全局索引）。
     */
    fun 粘性标题(
        键: Any? = null,
        内容类型: Any? = null,
        内容: @Composable LazyItemScope.(Int) -> Unit,
    ) {
        项(键, 内容类型) { 内容.invoke(this, 0) }
    }

}

//==========================================================================================

/**
 * 添加一件物品。
 *
 * @param 键 一个稳定且唯一的键来表示该项目。列表中不允许为多个项目使用相同的键。键的类型应该可以通过 Android 的 Bundle 保存。
 * 如果传入 null，列表中的位置将表示键。当你指定键时，滚动位置将基于该键保持不变，这意味着如果在当前可见项目之前添加或删除项目，
 * 给定键的项目将保持为第一个可见项目。你可以通过在 'LazyListState' 上调用 'requestScrollToItem' 来覆盖这一点。
 * @param 内容类型 该项内容的类型。相同类型的项可以更高效地重复使用。请注意，null 是一个有效类型，属于此类型的项将被视为兼容。
 * @param 内容 项的内容
 */
fun LazyListScope.项(
    键: Any? = null,
    内容类型: Any? = null,
    内容: @Composable LazyItemScope.() -> Unit,
) =
    this.item(
        key = 键,
        contentType = 内容类型,
        content = 内容,
    )

/**
 * 添加 [count] 个物品。
 *
 * @param 数量 物品数量
 * @param 键 用于生成表示列表项的稳定且唯一键的工厂函数。在列表中对多个项使用相同的键是不允许的。键的类型必须能够通过
 * Android 上的 Bundle 进行保存。如果传入 `null`，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，
 * 这意味着如果你在可见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过在 `LazyListState` 上调
 * 用 `requestScrollToItem` 来覆盖。
 * @param 内容类型 用于生成列表项内容类型的工厂函数。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
 * 具有该类型的项将被视为兼容的。
 * @param 项内容 由单个列表项显示的内容。
 */
fun LazyListScope.项集(
    数量: Int,
    键: ((index: Int) -> Any)? = null,
    内容类型: (index: Int) -> Any? = { null },
    项内容: @Composable LazyItemScope.(index: Int) -> Unit,
) =
    this.items(
        count = 数量,
        key = 键,
        contentType = 内容类型,
        itemContent = 项内容,
    )

/**
 * 添加一个粘性标题项，即使在其后滚动时，该标题也会保持固定。该标题将保持固定，直到下一个标题取代它的位置。
 *
 * @param 键 表示该列表项的稳定且唯一的键。在列表中对多个项使用相同的键是不允许的。键的类型必须能够通过 Android
 * 上的 Bundle 进行保存。如果传入 `null`，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，
 * 这意味着如果你在可见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过在 `LazyListState` 上
 * 调用 `requestScrollToItem` 来覆盖。
 * @param 内容类型 该列表项内容的类型。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
 * 具有该类型的项将被视为兼容的。
 * @param 内容 标题的内容，同时提供标题的索引，即该标题在此懒加载列表中所有项的位置（全局索引）。
 */
fun LazyListScope.粘性标题(
    键: Any? = null,
    内容类型: Any? = null,
    内容: @Composable LazyItemScope.(Int) -> Unit,
) =
    this.stickyHeader(
        key = 键,
        contentType = 内容类型,
        content = 内容,
    )

//==========================================================================================

/**
 * 添加一个列表项集合。
 *
 * @param 项集 数据列表
 * @param 键 表示该列表项的稳定且唯一的键。在列表中对多个项使用相同的键是不允许的。键的类型必须能够通过 Android 上的
 * Bundle 进行保存。如果传入 `null`，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，这意味着如果你在可
 * 见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过在 `LazyListState` 上调用 `requestScrollToItem` 来覆盖。
 * @param 内容类型 用于生成列表项内容类型的工厂函数。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
 * 具有该类型的项将被视为兼容的。
 * @param 项内容 由单个列表项显示的内容。
 */
inline fun <T> LazyListScope.项集(
    项集: List<T>,
    noinline 键: ((item: T) -> Any)? = null,
    noinline 内容类型: (item: T) -> Any? = { null },
    crossinline 项内容: @Composable LazyItemScope.(item: T) -> Unit,
) =
    this.items(
        items = 项集,
        key = 键,
        contentType = 内容类型,
        itemContent = 项内容,
    )


/**
 * 添加一个列表项集合，其中每个列表项的内容能够感知到自身的索引。
 *
 * @param 项集 数据列表
 * @param 键 表示该列表项的稳定且唯一的键。在列表中对多个项使用相同的键是不允许的。键的类型必须能够通过 Android 上的
 * Bundle 进行保存。如果传入 `null`，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，这意味着如果你在
 * 可见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过在 `LazyListState` 上调用 `requestScrollToItem` 来覆盖。
 * @param 内容类型 用于生成列表项内容类型的工厂函数。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
 * 具有该类型的项将被视为兼容的。
 * @param 项内容 由单个列表项显示的内容。
 */
inline fun <T> LazyListScope.项集索引(
    项集: List<T>,
    noinline 键: ((index: Int, item: T) -> Any)? = null,
    crossinline 内容类型: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline 项内容: @Composable LazyItemScope.(index: Int, item: T) -> Unit,
) =
    this.itemsIndexed(
        items = 项集,
        key = 键,
        contentType = 内容类型,
        itemContent = 项内容,
    )


/**
 * 添加一个数组项集合。
 *
 * @param 项集 数据数组
 * @param 键 表示该列表项的稳定且唯一的键。在列表中对多个项使用相同的键是不允许的。键的类型必须能够通过 Android 上的
 * Bundle 进行保存。如果传入 `null`，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，这意味着如果你在可
 * 见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过在 `LazyListState` 上调用 `requestScrollToItem` 来覆盖。
 * @param 内容类型 用于生成列表项内容类型的工厂函数。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，
 * 具有该类型的项将被视为兼容的。
 * @param 项内容 由单个列表项显示的内容。
 */
inline fun <T> LazyListScope.项集(
    项集: Array<T>,
    noinline 键: ((item: T) -> Any)? = null,
    noinline 内容类型: (item: T) -> Any? = { null },
    crossinline 项内容: @Composable LazyItemScope.(item: T) -> Unit,
) =
    this.items(
        items = 项集,
        key = 键,
        contentType = 内容类型,
        itemContent = 项内容
    )


/**
 * 添加一个数组项集合，其中每个数组项的内容能够感知到自身的索引。
 *
 * @param 项集 数据数组
 * @param 键 表示该列表项的稳定且唯一的键。在列表中对多个项使用相同的键是不允许的。键的类型必须能够通过 Android 上的
 * Bundle 进行保存。如果传入 `null`，则列表中的位置将作为键。当你指定了键时，滚动位置将根据该键来维护，这意味着如果你在可
 * 见项之前添加或删除项，具有给定键的项将保持为第一个可见项。此行为可以通过在 `LazyListState` 上调用 `requestScrollToItem` 来覆盖。
 * @param 内容类型 用于生成列表项内容类型的工厂函数。相同类型的项组合可以被更高效地复用。注意，`null` 是一个有效的类型，具有该类型的项将被视为兼容的。
 * @param 项内容 由单个列表项显示的内容。
 */
inline fun <T> LazyListScope.项集索引(
    项集: Array<T>,
    noinline 键: ((index: Int, item: T) -> Any)? = null,
    crossinline 内容类型: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline 项内容: @Composable LazyItemScope.(index: Int, item: T) -> Unit,
) =
    this.itemsIndexed(
        items = 项集,
        key = 键,
        contentType = 内容类型,
        itemContent = 项内容
    )



/**
 * 一个水平滚动的列表，仅组合和布局当前可见的项。[内容] 块定义了一个 DSL，允许你发射不同类型的项。例如，你可以使用
 * [LazyListScope.item] 添加单个项，使用 [LazyListScope.items] 添加一组项。
 *
 * @param 修饰符 应用于该布局的修饰符。
 * @param 状态 用于控制或观察列表状态的状态对象。
 * @param 内容内边距 整个内容周围的内边距。这将在内容被裁剪后添加内边距，这是通过 [修饰符] 参数无法实现的。
 * 你可以用它来在第一个项之前或最后一个项之后添加内边距。如果你想在每个项之间添加间距，请使用 [水平排列]。
 * @param 反向布局 反转滚动和布局的方向。当为 `true` 时，项将以相反的顺序进行布局，且
 * [LazyListState.firstVisibleItemIndex] == 0 表示该行已滚动到底部。注意，[反向布局] 不会改变
 * [水平排列] 的行为，例如，使用 [Arrangement.Start] 时，[123###] 将变为 [321###]。
 * @param 水平排列 布局子项的水平排列方式。这允许你在项之间添加间距，并指定当项的数量不足以填满整个最小尺寸时，项的排列方式。
 * @param 垂直对齐 应用于列表项的垂直对齐方式。
 * @param 抛掷行为 描述快速滑动（fling）行为的逻辑。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。即使禁用了该功能，你仍然可以使用状态以编程方式进行滚动。
 * @param 过度滚动效果 用于为该布局渲染过滚动效果的 [OverscrollEffect]。注意，[OverscrollEffect.node]
 * 也将在内部被应用——你无需单独使用 `Modifier.overscroll`。
 * @param 内容 描述内容的代码块。在此块中，你可以使用 [LazyListScope.item] 方法添加单个项，或使用 [LazyListScope.items] 方法添加一组项。
 */
@Suppress("ComposableNaming")
@Composable
fun 懒加载行(
    修饰符: Modifier = Modifier,
    状态: LazyListState = rememberLazyListState(),
    内容内边距: PaddingValues = PaddingValues(0.dp),
    反向布局: Boolean = false,
    水平排列: Arrangement.Horizontal = if (!反向布局) Arrangement.Start else Arrangement.End,
    垂直对齐: Alignment.Vertical = Alignment.Top,
    抛掷行为: FlingBehavior = ScrollableDefaults.flingBehavior(),
    用户滚动已启用: Boolean = true,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    内容: LazyListScope.() -> Unit,
) =
    LazyRow(
        modifier = 修饰符,
        state = 状态,
        contentPadding = 内容内边距,
        reverseLayout = 反向布局,
        horizontalArrangement = 水平排列,
        verticalAlignment = 垂直对齐,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        overscrollEffect = 过度滚动效果,
        content = 内容,
    )


/**
 * 一个垂直滚动的列表，仅组合和布局当前可见的项。[内容] 块定义了一个 DSL，允许你发射不同类型的项。例如，你可以使用
 * [LazyListScope.item] 添加单个项，使用 [LazyListScope.items] 添加一组项。
 *
 * @param 修饰符 应用于该布局的修饰符。
 * @param 状态 用于控制或观察列表状态的状态对象。
 * @param 内容内边距 整个内容周围的内边距。这将在内容被裁剪后添加内边距，这是通过 [修饰符] 参数无法实现的。
 * 你可以用它来在第一个项之前或最后一个项之后添加内边距。如果你想在每个项之间添加间距，请使用 [垂直排列]。
 * @param 反向布局 反转滚动和布局的方向。当为 `true` 时，项将以相反的顺序进行布局，且
 * [LazyListState.firstVisibleItemIndex] == 0 表示该列已滚动到底部。注意，[反向布局] 不会改变
 * [垂直排列] 的行为，例如，使用 [Arrangement.Top] 时，(顶部) 123### (底部) 将变为 (顶部) 321### (底部)。
 * @param 垂直排列 布局子项的垂直排列方式。这允许你在项之间添加间距，并指定当项的数量不足以填满整个最小尺寸时，项的排列方式。
 * @param 水平对齐 应用于列表项的水平对齐方式。
 * @param 抛掷行为 描述快速滑动（fling）行为的逻辑。
 * @param 用户滚动已启用 是否允许通过用户手势或无障碍操作进行滚动。即使禁用了该功能，你仍然可以使用状态以编程方式进行滚动。
 * @param 过度滚动效果 用于为该布局渲染过滚动效果的 [OverscrollEffect]。注意，[OverscrollEffect.node]
 * 也将在内部被应用——你无需单独使用 `Modifier.overscroll`。
 * @param 内容 描述内容的代码块。在此块中，你可以使用 [LazyListScope.item] 方法添加单个项，或使用 [LazyListScope.items] 方法添加一组项。
 */
@Suppress("ComposableNaming")
@Composable
fun 懒加载列(
    修饰符: Modifier = Modifier,
    状态: LazyListState = rememberLazyListState(),
    内容内边距: PaddingValues = PaddingValues(0.dp),
    反向布局: Boolean = false,
    垂直排列: Arrangement.Vertical = if (!反向布局) Arrangement.Top else Arrangement.Bottom,
    水平对齐: Alignment.Horizontal = Alignment.Start,
    抛掷行为: FlingBehavior = ScrollableDefaults.flingBehavior(),
    用户滚动已启用: Boolean = true,
    过度滚动效果: OverscrollEffect? = rememberOverscrollEffect(),
    内容: LazyListScope.() -> Unit,
) =
    LazyColumn(
        modifier = 修饰符,
        state = 状态,
        contentPadding = 内容内边距,
        reverseLayout = 反向布局,
        verticalArrangement = 垂直排列,
        horizontalAlignment = 水平对齐,
        flingBehavior = 抛掷行为,
        userScrollEnabled = 用户滚动已启用,
        overscrollEffect = 过度滚动效果,
        content = 内容,
    )


