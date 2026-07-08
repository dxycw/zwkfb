@file:Suppress("DEPRECATION")

package 安卓x.组合.基础.布局

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * [FlowRow] 是一种布局，在 LTR（从左到右）布局中按从左到右的顺序填充条目，在 RTL（从右到左）布局中按从右到左的顺序填充条目；
 * 当空间不足时，移动到下方定位的下一"行"或"行"，然后继续填充条目直至条目用尽。
 *
 * 当提供 Modifier [RowScope.weight] 时，它会根据该条目所在行中的条目数量来缩放该条目。
 *
 * 请注意，如果将两个或多个 Text 组件放置在 [Row] 中，通常它们应按首基线对齐。[FlowRow] 作为通用容器不会自动执行此操作，
 * 因此开发者需要手动处理。这可以通过为每个这样的 Text 组件添加 [RowScope.alignByBaseline] 修饰符来实现。默认情况下，
 * 此修饰符按 [androidx.compose.ui.layout.FirstBaseline] 对齐。但是，如果您需要按 [androidx.compose.ui.layout.LastBaseline]
 * 对齐文本，请使用更通用的 [RowScope.alignBy] 修饰符。
 *
 * @param 修饰符 要应用于 Row 的修饰符。
 * @param 水平排列 布局子项的横向排列方式。
 * @param 垂直排列 布局虚拟行的纵向排列方式。
 * @param 项垂直对齐 列中条目的交叉轴/纵向对齐方式。
 * @param 每行最大项目数 每行的最大条目数。
 * @param 最大行数 最大行数。
 * @param 溢出 处理溢出条目的策略。
 * @param 内容 以 [RowScope] 形式的内容。
 * @see FlowColumn
 * @see [androidx.compose.foundation.layout.Row]
 */
@Suppress("ComposableNaming")
@Deprecated("The overflow parameter has been deprecated")
@Composable
@ExperimentalLayoutApi
fun 流式行(
    修饰符: Modifier = Modifier,
    水平排列: Arrangement.Horizontal = Arrangement.Start,
    垂直排列: Arrangement.Vertical = Arrangement.Top,
    项垂直对齐: Alignment.Vertical = Alignment.Top,
    每行最大项目数: Int = Int.MAX_VALUE,
    最大行数: Int = Int.MAX_VALUE,
    溢出: FlowRowOverflow = FlowRowOverflow.Clip,
    内容: @Composable FlowRowScope.() -> Unit,
) =
    FlowRow(
        modifier = 修饰符,
        horizontalArrangement = 水平排列,
        verticalArrangement = 垂直排列,
        itemVerticalAlignment = 项垂直对齐,
        maxItemsInEachRow = 每行最大项目数,
        maxLines = 最大行数,
        overflow = 溢出,
        content = 内容,
    )

/**
 * [FlowRow] 是一种布局，在 LTR（从左到右）布局中按从左到右的顺序填充条目，在 RTL（从右到左）布局中按从右到左的顺序填充条目；
 * 当空间不足时，移动到下方定位的下一"行"或"行"，然后继续填充条目直至条目用尽。
 *
 * 当提供 Modifier [RowScope.weight] 时，它会根据该条目所在行中的条目数量来缩放该条目。
 *
 * 请注意，如果将两个或多个 Text 组件放置在 [Row] 中，通常它们应按首基线对齐。[FlowRow] 作为通用容器不会自动执行此操作，
 * 因此开发者需要手动处理。这可以通过为每个这样的 Text 组件添加 [RowScope.alignByBaseline] 修饰符来实现。默认情况下，
 * 此修饰符按 [androidx.compose.ui.layout.FirstBaseline] 对齐。但是，如果您需要按 [androidx.compose.ui.layout.LastBaseline]
 * 对齐文本，请使用更通用的 [RowScope.alignBy] 修饰符。
 *
 * @param 修饰符 要应用于 Row 的修饰符。
 * @param 水平排列 布局子项的横向排列方式。
 * @param 垂直排列 布局虚拟行的纵向排列方式。
 * @param 项垂直对齐 列中条目的交叉轴/纵向对齐方式。
 * @param 每行最大项目数 每行的最大条目数。
 * @param 最大行数 最大行数。
 * @param 内容 以 [RowScope] 形式的内容。
 * @see FlowColumn
 * @see [androidx.compose.foundation.layout.Row]
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun 流式行(
    修饰符: Modifier = Modifier,
    水平排列: Arrangement.Horizontal = Arrangement.Start,
    垂直排列: Arrangement.Vertical = Arrangement.Top,
    项垂直对齐: Alignment.Vertical = Alignment.Top,
    每行最大项目数: Int = Int.MAX_VALUE,
    最大行数: Int = Int.MAX_VALUE,
    内容: @Composable FlowRowScope.() -> Unit,
) =
    FlowRow(
        modifier = 修饰符,
        horizontalArrangement = 水平排列,
        verticalArrangement = 垂直排列,
        itemVerticalAlignment = 项垂直对齐,
        maxItemsInEachRow = 每行最大项目数,
        maxLines = 最大行数,
        content = 内容,
    )


/**
 * [FlowColumn] 是一种布局，按从上到下的顺序填充条目，当底部空间不足时，根据 LTR 或 RTL 布局移动到右侧或左侧的下一"列"或"行"，
 * 然后继续从上到下填充条目。
 *
 * 在 LTR 布局中，它支持从左到右的方向，将第一列放置在左侧，然后向右移动。在 RTL 布局中，它支持从右到左的方向，将第一列放置在右侧，然后向左移动。
 *
 * 当提供 Modifier [ColumnScope.weight] 时，它会根据该条目所在列中的条目数量来缩放该条目。
 *
 * @param 修饰符 要应用于 Column 的修饰符。
 * @param 垂直排列 布局子项的纵向排列方式。
 * @param 水平排列 布局虚拟列的横向排列方式。
 * @param 项水平对齐 列中条目的交叉轴/横向对齐方式。
 * @param 每列最大项数 每列的最大条目数。
 * @param 最大行数 最大行数。
 * @param 溢出 处理溢出条目的策略。
 * @param 内容 以 [ColumnScope] 形式的内容。
 * @see FlowRow
 * @see ContextualFlowColumn
 * @see [androidx.compose.foundation.layout.Column]
 */
@Suppress("ComposableNaming")
@Deprecated("The overflow parameter has been deprecated")
@Composable
@ExperimentalLayoutApi
fun 流式列(
    修饰符: Modifier = Modifier,
    垂直排列: Arrangement.Vertical = Arrangement.Top,
    水平排列: Arrangement.Horizontal = Arrangement.Start,
    项水平对齐: Alignment.Horizontal = Alignment.Start,
    每列最大项数: Int = Int.MAX_VALUE,
    最大行数: Int = Int.MAX_VALUE,
    溢出: FlowColumnOverflow = FlowColumnOverflow.Clip,
    内容: @Composable FlowColumnScope.() -> Unit,
) =
    FlowColumn(
        modifier = 修饰符,
        verticalArrangement = 垂直排列,
        horizontalArrangement = 水平排列,
        itemHorizontalAlignment = 项水平对齐,
        maxItemsInEachColumn = 每列最大项数,
        maxLines = 最大行数,
        overflow = 溢出,
        content = 内容,
    )


/**
 * [FlowColumn] 是一种布局，按从上到下的顺序填充条目，当底部空间不足时，根据 LTR 或 RTL 布局移动到右侧或左侧的下一"列"或"行"，
 * 然后继续从上到下填充条目。
 *
 * 在 LTR 布局中，它支持从左到右的方向，将第一列放置在左侧，然后向右移动。在 RTL 布局中，它支持从右到左的方向，将第一列放置在右侧，然后向左移动。
 *
 * 当提供 Modifier [ColumnScope.weight] 时，它会根据该条目所在列中的条目数量来缩放该条目。
 *
 * @param 修饰符 要应用于 Column 的修饰符。
 * @param 垂直排列 布局子项的纵向排列方式。
 * @param 水平排列 布局虚拟列的横向排列方式。
 * @param 项水平对齐 列中条目的交叉轴/横向对齐方式。
 * @param 每列最大项数 每列的最大条目数。
 * @param 最大行数 最大行数。
 * @param 内容 以 [ColumnScope] 形式的内容。
 * @see FlowRow
 * @see [androidx.compose.foundation.layout.Column]
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun 流式列(
    修饰符: Modifier = Modifier,
    垂直排列: Arrangement.Vertical = Arrangement.Top,
    水平排列: Arrangement.Horizontal = Arrangement.Start,
    项水平对齐: Alignment.Horizontal = Alignment.Start,
    每列最大项数: Int = Int.MAX_VALUE,
    最大行数: Int = Int.MAX_VALUE,
    内容: @Composable FlowColumnScope.() -> Unit,
) =
    FlowColumn(
        modifier = 修饰符,
        verticalArrangement = 垂直排列,
        horizontalArrangement = 水平排列,
        itemHorizontalAlignment = 项水平对齐,
        maxItemsInEachColumn = 每列最大项数,
        maxLines = 最大行数,
        content = 内容,
    )


/** [FlowRow] 子项的作用域。 */
@LayoutScopeMarker
@Stable
interface 流式行范围 : RowScope { // FlowRowScope

    /**
     * 使该条目填充（可能仅部分填充）其所在行中最高条目的最大高度，在 [FlowRow] 内。
     *
     * @param 比例 最高条目最大高度的比例，取值范围为 `0` 到 `1`（含边界值）。
     */
    @ExperimentalLayoutApi
    fun Modifier.填充最大行高度(@FloatRange(from = 0.0, to = 1.0) 比例: Float = 1f): Modifier

}

/** 溢出 [FlowRow] 的作用域。*/
@LayoutScopeMarker
@Stable
@ExperimentalLayoutApi
interface 流式行溢出范围 : FlowRowScope { // FlowRowOverflowScope
    /**
     * [FlowRow] 中可供显示的总条目数。这包括可能未被显示的条目。
     *
     * 在 [ContextualFlowRow] 中，这与 [ContextualFlowRow] 的 `itemCount` 参数一致。
     */
    @ExperimentalLayoutApi val 总共项数量: Int // totalItemCount

    /** [FlowRow] 中已显示的条目总数*/
    @ExperimentalLayoutApi val 显示项数量: Int // shownItemCount
}

//====================================================================================

/**
 * [FlowRow] 中可供显示的总条目数。这包括可能未被显示的条目。
 *
 * 在 [ContextualFlowRow] 中，这与 [ContextualFlowRow] 的 `itemCount` 参数一致。
 */
@ExperimentalLayoutApi val FlowRowOverflowScope.总共项数量: Int get() = this.totalItemCount

/** [FlowRow] 中已显示的条目总数*/
@ExperimentalLayoutApi val FlowRowOverflowScope.显示项数量: Int get() = this.shownItemCount

//====================================================================================

/** [FlowColumn] 子项的作用域。 */
@LayoutScopeMarker
@Stable
interface 流式列范围 : ColumnScope {

    /**
     * 使该条目填充（可能仅部分填充）其所在列中最宽条目的最大宽度，在 [FlowColumn] 内。
     *
     * @param 比例 最高条目最大宽度的比例，取值范围为 `0` 到 `1`（含边界值）。
     */
    @ExperimentalLayoutApi
    fun Modifier.填充最大列宽度(
        @FloatRange(from = 0.0, to = 1.0) 比例: Float = 1f
    ): Modifier

}

/** 溢出 [FlowColumn] 的作用域。 */
@LayoutScopeMarker
@Stable
@ExperimentalLayoutApi
interface 流式列溢出范围 : FlowColumnScope { // FlowColumnOverflowScope

    /**
     * [FlowColumn] 中可供显示的总条目数。这包括可能未被显示的条目。
     *
     * 在 [ContextualFlowColumn] 中，这与 [ContextualFlowColumn] 的 `itemCount` 参数一致。
     */
    @ExperimentalLayoutApi val 总共项数量: Int // totalItemCount

    /** [FlowColumn] 中已显示的条目总数 */
    @ExperimentalLayoutApi val 显示项数量: Int // shownItemCount

}

//====================================================================================

/**
 * [FlowColumn] 中可供显示的总条目数。这包括可能未被显示的条目。
 *
 * 在 [ContextualFlowColumn] 中，这与 [ContextualFlowColumn] 的 `itemCount` 参数一致。
 */
@ExperimentalLayoutApi val FlowColumnOverflowScope.总共项数量: Int get() = this.totalItemCount

/** [FlowColumn] 中已显示的条目总数*/
@ExperimentalLayoutApi val FlowColumnOverflowScope.显示项数量: Int get() = this.shownItemCount

//====================================================================================
