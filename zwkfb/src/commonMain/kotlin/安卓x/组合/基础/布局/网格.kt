package 安卓x.组合.基础.布局

import androidx.compose.foundation.layout.ExperimentalGridApi
import androidx.annotation.FloatRange
import androidx.annotation.IntRange as AndroidXIntRange
import androidx.compose.foundation.layout.Fr
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.GridConfigurationScope
import androidx.compose.foundation.layout.GridFlow
import androidx.compose.foundation.layout.GridScope
import androidx.compose.foundation.layout.GridTrackSize
import androidx.compose.foundation.layout.GridTrackSpec
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.foundation.layout.columns
import androidx.compose.foundation.layout.rows
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp


/**
 * 一种二维布局可组合项，将子项排列成由行和列组成的网格。
 *
 * [Grid] 允许定义显式轨道（列和行），并支持多种尺寸设置能力，包括固定大小（`dp`）、弹性比例（`fr`）、百分比，
 * 以及基于内容的大小（`Auto`）。
 *
 * **主要特性：**
 *
 *  **显式与隐式：** 你通过 `[配置]` 定义网格的主体结构（显式轨道）。如果子项被放置在这些已定义范围之外，
 * 或者自动布局生成了新的行/列，网格会使用隐式尺寸（默认为 `Auto`）自动扩展。
 *
 *  **弹性尺寸：** 使用 `[Fr]` 单位（例如 `1.fr`、`2.fr`）按比例在轨道之间分配可用空间。
 *
 *  **自动布局：** 没有指定 `[GridScope.gridItem]` 修饰符的子项，会根据配置的 `[GridFlow]`
 * 自动流入下一个可用的单元格。
 *
 * @param 配置 一个用于定义网格的列、行和间隙的代码块。此代码块在测量阶段执行，从而能够基于状态进行高效更新。
 * @param 修饰符 要应用于此布局的修饰符。
 * @param 内容 网格的内容。直接子项可以使用 `[GridScope.gridItem]` 来配置其位置和跨越范围。
 * @see GridScope.gridItem
 * @see GridConfigurationScope
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalGridApi
inline fun 网格(
    noinline 配置: GridConfigurationScope.() -> Unit,
    修饰符: Modifier = Modifier,
    内容: @Composable GridScope.() -> Unit,
) =
    Grid(
        config = 配置,
        modifier = 修饰符,
        content = 内容,
    )


/** 用于 [Grid] 子项的作用域。 */
@LayoutScopeMarker
@Immutable
@ExperimentalGridApi
interface 网格范围 {

    /**
     * 配置元素在 [Grid] 布局中的位置、跨度和对齐方式。
     *
     * 将此修饰符应用于 [Grid] 可组合项的直接子项。
     *
     * **默认行为：** 如果未对子项应用此修饰符，则该子项将根据配置的 [GridFlow] 自动放置到下一个可用单元格中（占 1 行 1 列）。
     *
     * **索引：** Grid 的行和列索引是从 1 开始的。
     * * **正数**值从起始位置开始计数（1 表示第一行/列）。
     * * **负数**值从末尾位置开始计数（-1 表示最后一个显式定义的行/列）。
     *
     * **自动放置：** 如果 [行] 或 [列] 保留为默认值（[GridScope.GridIndexUnspecified]），
     * [Grid] 布局将根据配置的 [GridFlow] 自动放置该项。
     *
     * @param 行 要放置该项的具体行索引，从 1 开始计数。正值从开头算起（1 为第一行），负值从末尾算起（-1 为最后一行）。
     * 取值必须在 `[-[GridScope.MaxGridIndex], [GridScope.MaxGridIndex]]` 范围内。
     * 默认为 `[GridScope.GridIndexUnspecified]`，由布局自动放置。
     * @param 列 要放置该项的具体列索引，从 1 开始计数。正值从开头算起（1 为第一列），负值从末尾算起（-1 为最后一列）。
     * 取值必须在 `[-[GridScope.MaxGridIndex], [GridScope.MaxGridIndex]]` 范围内。
     * 默认为 `[GridScope.GridIndexUnspecified]`，由布局自动放置。
     * @param 行跨度 此子项应占用的行数。必须大于 0。默认为 1。
     * @param 列跨度 此子项应占用的列数。必须大于 0。默认为 1。
     * @param 对齐 指定内容在其所占用的网格单元格内的对齐方式。默认为 [Alignment.TopStart]。
     * @throws IllegalArgumentException 如果 [行] 或 [列]（当指定时）超出了有效范围，或者 [行跨度] 或 [列跨度] 小于 1。
     * @see GridScope.GridIndexUnspecified
     * @see GridScope.MaxGridIndex
     */
    @Stable
    fun Modifier.网格项( // gridItem
        @AndroidXIntRange(from = -GridScope.MaxGridIndex.toLong(), to = GridScope.MaxGridIndex.toLong())
        行: Int = GridScope.GridIndexUnspecified,
        @AndroidXIntRange(from = -GridScope.MaxGridIndex.toLong(), to = GridScope.MaxGridIndex.toLong())
        列: Int = GridScope.GridIndexUnspecified,
        @AndroidXIntRange(from = 1) 行跨度: Int = 1,
        @AndroidXIntRange(from = 1) 列跨度: Int = 1,
        对齐: Alignment = Alignment.TopStart,
    ): Modifier

    /**
     * 使用范围配置元素在 [Grid] 布局中的位置、跨度和对齐方式。
     *
     * 此便捷重载将 [IntRange] 输入转换为行/列索引和跨度。
     *
     * **等价关系：**
     *  - `rows = 4..5` 对应 `row = 4`，`rowSpan = 2`。
     *  - `columns = 1..1` 对应 `column = 1`，`columnSpan = 1`。
     *
     * 示例：`Modifier.gridItem(rows = 2..3, columns = 1..2)` 在功能上等价于
     * `Modifier.gridItem(row = 2, rowSpan = 2, column = 1, columnSpan = 2)`。
     *
     * @param 行数 要占用的行范围（例如 `1..2`）。起始值决定行索引，范围的大小决定跨度。
     * @param 列数 要占用的列范围（例如 `1..3`）。起始值决定列索引，范围的大小决定跨度。
     * @param 对齐 指定内容在网格单元格内的对齐方式。默认为 [Alignment.TopStart]。
     * @see Modifier.网格项
     */
    @Stable
    fun Modifier.网格项( // gridItem
        行数: IntRange,
        列数: IntRange,
        对齐: Alignment = Alignment.TopStart,
    ): Modifier

    /**
     * 通过引用命名区域，配置元素在 [Grid] 布局中的位置和对齐方式。
     *
     * 将此修饰符应用于 [Grid] 可组合项的直接子项。[区域Id] 必须与在 [Grid] 的 config
     * 代码块中使用 [GridConfigurationScope.area] 定义的标识符相对应。
     *
     * **多项目与重叠：**
     * - **二维区域：** 如果多个项目被分配到同一个完全指定的二维区域（行和列均已固定），它们将在该边界内彼此堆叠。
     * Z轴顺序由组合顺序决定（后声明的项目绘制在上层，与 `Box` 的行为一致）。
     * - **一维区域与流式布局：** 如果引用的区域是一维的（例如，仅定义了行但列未指定），将多个项目放入其中会触发自动流式布局。
     * 这些项目将自动流入该特定轨道中的下一个可用单元格。
     *
     * **未知区域的回退行为：** 如果提供的 [区域Id] 标识符未在 Grid 配置中注册，则该项将静默回退至自动放置，以避免运行时崩溃。
     *
     * @param 区域Id 对应于 Grid 配置中所定义区域的、由用户定义的标识符。该标识符**必须**具有稳定的 `equals()`和
     * `hashCode()` 实现（例如 `enum`、`String`、`data class` 或单例 `object`），以便正确匹配配置中注册的区域。
     * @param 对齐 指定内容在所占网格单元格内的对齐方式。默认为 [Alignment.TopStart]。
     */
    @Stable
    @ExperimentalGridApi
    fun Modifier.网格项(区域Id: Any, 对齐: Alignment = Alignment.TopStart): Modifier // gridItem

    companion object {
        /**
         * 行或列允许使用的最大索引值（包含边界值）。
         *
         * 此硬性上限可防止因意外的循环溢出，或定义了过大且过于稀疏的网格，而导致的性能下降、布局超时或内存问题。
         *
         * **注意：** 此值不得超过 `Short.MAX_VALUE`（32767）。命名区域的边界以位压缩方式打包到16位段中，
         * 更大的值将被静默截断。
         */
        @ExperimentalGridApi
        const val 最大网格索引: Int = GridScope.MaxGridIndex

        /** 哨兵值，表示网格位置（行或列）未手动指定，应由布局流自动确定。*/
        @ExperimentalGridApi
        const val 网格索引未指定: Int = GridScope.GridIndexUnspecified
    }

}

//====================================================================================

/**
 * 用于配置 [Grid] 结构的作用域。
 *
 * 此接口由 [Grid] 中的配置代码块实现。它允许定义列、行和间距。
 *
 * 在 `config` 代码块中，`[GridConfigurationScope.column]` 和 `[GridConfigurationScope.row]`
 * 函数的**调用顺序很重要**。轨道会根据这些调用按顺序添加到网格定义中。例如，调用两次 `column(100.dp)` 会定义两列。
 *
 * 间距配置调用（[GridConfigurationScope.gap]、[GridConfigurationScope.rowGap]、
 * [GridConfigurationScope.columnGap]）在各自对应的轴上遵循"最后调用生效"策略。
 */
@LayoutScopeMarker
@ExperimentalGridApi
interface 网格配置范围 : Density { // GridConfigurationScope

    /**
     * 从父项传递给此 [Grid] 的布局约束。
     *
     * 这些约束表示父项对此 Grid 施加的最小和最大尺寸限制。这对于创建能基于可用空间自适应的响应式布局非常有用。
     *
     * @see Constraints
     */
    val 约束: Constraints // constraints

    /** 未指定位置的子项的放置方向。默认为 [GridFlow.Row]。*/
    var 流式: GridFlow // flow

    /** 定义一个固定宽度的列。对应于 [GridTrackSize.Fixed]。 */
    fun 列(大小: Dp) // column

    /** 定义一个弹性列。对应于 [GridTrackSize.Flex]。 */
    fun 列(权重: Fr) // column

    /**
     * 定义一个基于百分比的列。对应于 [GridTrackSize.Percentage]。
     *
     * @param 百分比 可用空间的百分比（0.0 到 1.0）。
     */
    fun 列(@FloatRange(from = 0.0, to = 1.0) 百分比: Float) // column

    /** 使用指定的 [大小] 定义一个新的列轨道。 */
    fun 列(大小: GridTrackSize) // column

    /** 定义一个固定宽度的行。对应于 [GridTrackSize.Fixed]。 */
    fun 行(大小: Dp) // row

    /** 定义一个弹性行。对应于 [GridTrackSize.Flex]。 */
    fun 行(权重: Fr) // row

    /**
     * 定义一个基于百分比的行。对应于 [GridTrackSize.Percentage]。
     *
     * @param 百分比 可用空间的百分比（0.0 到 1.0）。
     */
    fun 行(@FloatRange(from = 0.0, to = 1.0) 百分比: Float) // row

    /** 使用指定的 [大小] 定义一个新的行轨道。 */
    fun 行(大小: GridTrackSize) // row

    /**
     * 通过将标识符映射到实际的起始坐标和跨度，在网格中定义一个命名区域或一维轨道。
     *
     * 定义完成后，子可组合项可以使用 `Modifier.gridItem(areaId)` 引用此标识符，将它们放置到该特定区域。
     * 这会将组件的语义意图与其精确的布局坐标解耦。
     *
     * **一维区域与流式布局：** 要创建一维轨道，请对你希望自动流式布局的维度显式传入 [GridScope.GridIndexUnspecified]。
     * 例如，`area("Header", row = 1, column = GridIndexUnspecified)` 将该区域限制在第一行，
     * 允许多个放入其中的子项自动并排流入可用列中。
     *
     * @param 区域Id 表示此区域的用户定义标识符（例如 `Enum`、`String` 或对象标记）。该标识符必须具有稳定的
     * `equals()` 和 `hashCode()` 实现。
     * @param 行 区域的起始行索引，从 1 开始。默认为 [GridScope.GridIndexUnspecified]，
     * 以创建基于列的一维区域，子项在其中纵向流动。
     * @param 列 区域的起始列索引，从 1 开始。默认为 [GridScope.GridIndexUnspecified]，
     * 以创建基于行的一维区域，子项在其中横向流动。
     * @param 行跨度 该区域应占用的行数。必须大于 0。默认为 1。
     * @param 列跨度 该区域应占用的列数。必须大于 0。默认为 1。
     * @throws IllegalArgumentException 如果 [行] 和 [列] 均为 [GridScope.GridIndexUnspecified]。
     */
    fun 区域(
        区域Id: Any,
        行: Int = GridScope.GridIndexUnspecified,
        列: Int = GridScope.GridIndexUnspecified,
        行跨度: Int = 1,
        列跨度: Int = 1,
    ) // area


    /**
     * 使用显式坐标范围在网格内定义一个命名区域。
     *
     * 这是一个便捷的重载方法，根据提供的 [IntRange] 边界计算起始坐标和跨度。
     *
     * 示例：`area(AppArea.Footer, rows = 2..3, columns = 1..2)` 在功能上等价于
     *  `area(AppArea.Footer, row = 2, column = 1, rowSpan = 2, columnSpan = 2)`。
     *
     * @param 区域Id 一个用户定义的标识符（例如枚举、字符串或对象标记），用于表示此区域。
     * @param 行数 要占据的行范围（例如 `1..2`）。起始值决定了从 1 开始的行索引，范围的大小决定了跨越的行数。
     * @param 列数 要占据的列范围（例如 `1..3`）。起始值决定了从 1 开始的列索引，范围的大小决定了跨越的列数。
     */
    fun 区域(区域Id: Any, 行数: IntRange, 列数: IntRange) {
        require(!行数.isEmpty()) { "Row range ($行数) cannot be empty" }
        require(!列数.isEmpty()) { "Column range ($列数) cannot be empty" }
        区域(
            区域Id = 区域Id,
            行 = 行数.first,
            列 = 列数.first,
            行跨度 = 行数.last - 行数.first + 1,
            列跨度 = 列数.last - 列数.first + 1,
        )
    } // area

    /**
     * 将行间隙和列间隙（gutter）均设置为 [全]。
     *
     * **优先级：** 如果此方法被多次调用，或与 [GridConfigurationScope.columnGap] 或
     * [GridConfigurationScope.rowGap] 混合使用，**最后一次调用**生效。
     *
     * @throws IllegalArgumentException 如果 [全] 为负数。
     */
    fun 间隙(全: Dp) // gap

    /**
     * 分别为行和列设置间隙（gutter）。
     *
     * **优先级：** 如果此方法被多次调用，或与 [GridConfigurationScope.columnGap] 或
     * [GridConfigurationScope.rowGap] 混合使用，**最后一次调用**生效。
     *
     * @throws IllegalArgumentException 如果 [行] 或 [列] 为负数。
     */
    fun 间隙(行: Dp, 列: Dp) // gap

    /**
     * 设置列之间的间隙（gutter）大小。
     *
     * **优先级：** 如果此方法被多次调用，**最后一次调用**生效。本次调用将覆盖之前任何 [间隙] 调用中的列（column）部分。
     *
     * @throws IllegalArgumentException 如果 [间隙] 为负数。
     */
    fun 列间隙(间隙: Dp) // columnGap

    /**
     * 设置行之间的间隙（gutter）大小。
     *
     * **优先级：** 如果此方法被多次调用，**最后一次调用**生效。本次调用将覆盖之前任何 [间隙] 调用中的行（row）部分。
     *
     * @throws IllegalArgumentException 如果 [间隙] 为负数。
     */
    fun 行间隙(间隙: Dp) // rowGap

    /**
     * 一条具有显式定义的最小基础尺寸和弹性最大尺寸的轨道。从概念上讲，它的行为与 CSS Grid 的 minmax(min, max) 函数完全相同。
     *
     * **与 Lazy 列表搭配使用：** 由于 `minmax` 依赖一个预定义的 [min] 尺寸（例如 `0.dp`），它完全绕过了固有测量
     * （intrinsic measurement）阶段。因此，当将基于 `SubcomposeLayout` 的组件（如 `LazyColumn` 或 `LazyRow`）
     * 放置在弹性网格轨道内时，它是必需的选择。
     *
     * @param 最小 显式的最小固定基础尺寸（例如 `0.dp`）。
     * @param 最大 最大弹性分配权重（例如 `1.fr`）。
     */
    @Stable
    fun 最小最大(最小: Dp, 最大: Fr): GridTrackSize = GridTrackSize.MinMax(最小, 最大) // minmax

    /** 根据一个 [Int] 值创建一个 [Fr] 单位。 */
    @Stable
    @ExperimentalGridApi
    val Int.fr: Fr
        get() = Fr(this.toFloat())

    /** 根据一个 [Float] 值创建一个 [Fr] 单位。 */
    @Stable
    @ExperimentalGridApi
    val Float.fr: Fr
        get() = Fr(this)

    /** 根据一个 [Double] 值创建一个 [Fr] 单位。 */
    @Stable
    @ExperimentalGridApi
    val Double.fr: Fr
        get() = Fr(this.toFloat())

}


/**
 * 从父项传递给此 [Grid] 的布局约束。
 *
 * 这些约束表示父项对此 Grid 施加的最小和最大尺寸限制。这对于创建能基于可用空间自适应的响应式布局非常有用。
 *
 * @see Constraints
 */
@ExperimentalGridApi
val GridConfigurationScope.约束: Constraints
    get() = this.constraints

/** 未指定位置的子项的放置方向。默认为 [GridFlow.Row]。*/
@ExperimentalGridApi
var GridConfigurationScope.流式: GridFlow
    get() = this.flow
    set(value) {
        this.flow = value
    }

/** 定义一个固定宽度的列。对应于 [GridTrackSize.Fixed]。 */
@ExperimentalGridApi
fun GridConfigurationScope.列(大小: Dp) = this.column(size = 大小)

/** 定义一个弹性列。对应于 [GridTrackSize.Flex]。 */
@ExperimentalGridApi
fun GridConfigurationScope.列(权重: Fr) = this.column(weight = 权重)

/**
 * 定义一个基于百分比的列。对应于 [GridTrackSize.Percentage]。
 *
 * @param 百分比 可用空间的百分比（0.0 到 1.0）。
 */
@ExperimentalGridApi
fun GridConfigurationScope.列(@FloatRange(from = 0.0, to = 1.0) 百分比: Float) =
    this.column(percentage = 百分比)

/** 使用指定的 [大小] 定义一个新的列轨道。 */
@ExperimentalGridApi
fun GridConfigurationScope.列(大小: GridTrackSize) = this.column(size = 大小)

/** 定义一个固定宽度的行。对应于 [GridTrackSize.Fixed]。 */
@ExperimentalGridApi
fun GridConfigurationScope.行(大小: Dp) = this.row(size = 大小)

/** 定义一个弹性行。对应于 [GridTrackSize.Flex]。 */
@ExperimentalGridApi
fun GridConfigurationScope.行(权重: Fr) = this.row(weight = 权重)

/**
 * 定义一个基于百分比的行。对应于 [GridTrackSize.Percentage]。
 *
 * @param 百分比 可用空间的百分比（0.0 到 1.0）。
 */
@ExperimentalGridApi
fun GridConfigurationScope.行(@FloatRange(from = 0.0, to = 1.0) 百分比: Float) =
    this.row(percentage = 百分比)

/** 使用指定的 [大小] 定义一个新的行轨道。 */
@ExperimentalGridApi
fun GridConfigurationScope.行(大小: GridTrackSize) = this.row(size = 大小)

/**
 * 通过将标识符映射到实际的起始坐标和跨度，在网格中定义一个命名区域或一维轨道。
 *
 * 定义完成后，子可组合项可以使用 `Modifier.gridItem(areaId)` 引用此标识符，将它们放置到该特定区域。
 * 这会将组件的语义意图与其精确的布局坐标解耦。
 *
 * **一维区域与流式布局：** 要创建一维轨道，请对你希望自动流式布局的维度显式传入 [GridScope.GridIndexUnspecified]。
 * 例如，`area("Header", row = 1, column = GridIndexUnspecified)` 将该区域限制在第一行，
 * 允许多个放入其中的子项自动并排流入可用列中。
 *
 * @param 区域Id 表示此区域的用户定义标识符（例如 `Enum`、`String` 或对象标记）。该标识符必须具有稳定的
 * `equals()` 和 `hashCode()` 实现。
 * @param 行 区域的起始行索引，从 1 开始。默认为 [GridScope.GridIndexUnspecified]，
 * 以创建基于列的一维区域，子项在其中纵向流动。
 * @param 列 区域的起始列索引，从 1 开始。默认为 [GridScope.GridIndexUnspecified]，
 * 以创建基于行的一维区域，子项在其中横向流动。
 * @param 行跨度 该区域应占用的行数。必须大于 0。默认为 1。
 * @param 列跨度 该区域应占用的列数。必须大于 0。默认为 1。
 * @throws IllegalArgumentException 如果 [行] 和 [列] 均为 [GridScope.GridIndexUnspecified]。
 */
@ExperimentalGridApi
fun GridConfigurationScope.区域(
    区域Id: Any,
    行: Int = GridScope.GridIndexUnspecified,
    列: Int = GridScope.GridIndexUnspecified,
    行跨度: Int = 1,
    列跨度: Int = 1,
) = this.area(areaId = 区域Id, row = 行, column = 列, rowSpan = 行跨度, columnSpan = 列跨度)


/**
 * 使用显式坐标范围在网格内定义一个命名区域。
 *
 * 这是一个便捷的重载方法，根据提供的 [IntRange] 边界计算起始坐标和跨度。
 *
 * 示例：`area(AppArea.Footer, rows = 2..3, columns = 1..2)` 在功能上等价于
 *  `area(AppArea.Footer, row = 2, column = 1, rowSpan = 2, columnSpan = 2)`。
 *
 * @param 区域Id 一个用户定义的标识符（例如枚举、字符串或对象标记），用于表示此区域。
 * @param 行数 要占据的行范围（例如 `1..2`）。起始值决定了从 1 开始的行索引，范围的大小决定了跨越的行数。
 * @param 列数 要占据的列范围（例如 `1..3`）。起始值决定了从 1 开始的列索引，范围的大小决定了跨越的列数。
 */
@ExperimentalGridApi
fun GridConfigurationScope.区域(区域Id: Any, 行数: IntRange, 列数: IntRange) =
    this.area(areaId = 区域Id, rows = 行数, columns = 列数)

/**
 * 将行间隙和列间隙（gutter）均设置为 [全]。
 *
 * **优先级：** 如果此方法被多次调用，或与 [GridConfigurationScope.columnGap] 或
 * [GridConfigurationScope.rowGap] 混合使用，**最后一次调用**生效。
 *
 * @throws IllegalArgumentException 如果 [全] 为负数。
 */
@ExperimentalGridApi
fun GridConfigurationScope.间隙(全: Dp) = this.gap(all = 全)

/**
 * 分别为行和列设置间隙（gutter）。
 *
 * **优先级：** 如果此方法被多次调用，或与 [GridConfigurationScope.columnGap] 或
 * [GridConfigurationScope.rowGap] 混合使用，**最后一次调用**生效。
 *
 * @throws IllegalArgumentException 如果 [行] 或 [列] 为负数。
 */
@ExperimentalGridApi
fun GridConfigurationScope.间隙(行: Dp, 列: Dp) = this.gap(row = 行, column = 列)

/**
 * 设置列之间的间隙（gutter）大小。
 *
 * **优先级：** 如果此方法被多次调用，**最后一次调用**生效。本次调用将覆盖之前任何 [间隙] 调用中的列（column）部分。
 *
 * @throws IllegalArgumentException 如果 [间隙] 为负数。
 */
@ExperimentalGridApi
fun GridConfigurationScope.列间隙(间隙: Dp) = this.columnGap(gap = 间隙)

/**
 * 设置行之间的间隙（gutter）大小。
 *
 * **优先级：** 如果此方法被多次调用，**最后一次调用**生效。本次调用将覆盖之前任何 [间隙] 调用中的行（row）部分。
 *
 * @throws IllegalArgumentException 如果 [间隙] 为负数。
 */
@ExperimentalGridApi
fun GridConfigurationScope.行间隙(间隙: Dp) = this.rowGap(gap = 间隙)

/**
 * 一条具有显式定义的最小基础尺寸和弹性最大尺寸的轨道。从概念上讲，它的行为与 CSS Grid 的 minmax(min, max) 函数完全相同。
 *
 * **与 Lazy 列表搭配使用：** 由于 `minmax` 依赖一个预定义的 [min] 尺寸（例如 `0.dp`），它完全绕过了固有测量
 * （intrinsic measurement）阶段。因此，当将基于 `SubcomposeLayout` 的组件（如 `LazyColumn` 或 `LazyRow`）
 * 放置在弹性网格轨道内时，它是必需的选择。
 *
 * @param 最小 显式的最小固定基础尺寸（例如 `0.dp`）。
 * @param 最大 最大弹性分配权重（例如 `1.fr`）。
 */
@ExperimentalGridApi
@Stable
fun GridConfigurationScope.最小最大(最小: Dp, 最大: Fr): GridTrackSize =
    this.minmax(min = 最小, max = 最大)

//====================================================================================

/** 使用指定的 [规格] 添加多列。 */
@ExperimentalGridApi
fun GridConfigurationScope.列数(vararg 规格: GridTrackSpec) =
    this.columns(specs = 规格)


/** 使用指定的 [规格] 添加多行。 */
@ExperimentalGridApi
fun GridConfigurationScope.行数(vararg 规格: GridTrackSpec) =
    this.rows(specs = 规格)

//====================================================================================

/** 定义自动放置的子项在网格内的流动方向。 */
@ExperimentalGridApi
object 网格流式 {

    /** 子项按行依次填充，先填满第一行，再移至下一行。 */
    @ExperimentalGridApi
    inline val 行
        get() = GridFlow.Row

    /** 子项按列依次填充，先填满第一列，再移至下一列。*/
    @ExperimentalGridApi
    inline val 列
        get() = GridFlow.Column

}

//====================================================================================

/**
 * 定义 [Grid] 中轨道（一行或一列）的大小。
 *
 * 使用伴生函数（例如 [GridTrackSize.Fixed]、[GridTrackSize.Flex]）来创建实例。
 */
@Immutable
@ExperimentalGridApi
object 网格轨道大小 {

    /**
     * 一个大小固定的轨道，尺寸以 [Dp] 为单位。
     *
     * @param size 轨道的大小。
     * @throws IllegalArgumentException 如果 [size] 为负数或 [Dp.Unspecified]。
     */
    @Stable
    fun 固定(size: Dp): GridTrackSize = GridTrackSize.Fixed(size = size)

    /**
     * 一个按网格容器**总**可用大小的百分比来确定大小的轨道。
     *
     * **注意：** 在此实现中，百分比是基于扣除间距后的**剩余可用空间**计算的。这与 W3C CSS Grid 规范不同，
     * 后者中的百分比是基于容器大小计算的，不考虑间距。此行为可防止在混用间距和百分比时出现意外的溢出（例如，
     * `50%` + `50%` + `间距` 在此处将完美适配，但在 CSS 中则会溢出）。
     *
     * @param value 容器大小的百分比。
     * @throws IllegalArgumentException 如果 [value] 为负数。
     */
    @Stable
    fun 百分比(@FloatRange(from = 0.0) value: Float): GridTrackSize =
        GridTrackSize.Percentage(value = value)

    /**
     *  一个弹性轨道，在非弹性轨道（如 [GridTrackSize.Fixed] 和 [GridTrackSize.Percentage]）分配完毕后，占据网格中**剩余**空间的一部分。
     *
     * **固有尺寸：** 默认情况下，[GridTrackSize.Flex] 轨道的行为类似于 CSS 中的 `1fr`（即 `minmax(min-content, <weight>fr)`）。
     * 在分配剩余空间之前，它会查询其子项的最小固有尺寸（`min-content`）以确定基准大小，确保内容不会被压缩。
     *
     * Jetpack Compose 严格禁止查询 `SubcomposeLayout`（如 [LazyColumn][androidx.compose.foundation.lazy.LazyColumn]
     * 或 [LazyRow][androidx.compose.foundation.lazy.LazyRow]）的固有尺寸。将惰性列表直接放置在标准 [GridTrackSize.Flex]
     * 轨道内会导致 `IllegalStateException` 崩溃。若要在弹性轨道中安全地放置惰性列表，请改用 [GridTrackSize.MinMax]。
     *
     * @param weight 弹性权重。剩余空间按此权重占所有弹性权重之和的比例进行分配。必须为非负数。
     * @throws IllegalArgumentException 如果 [weight] 为负数。
     * @see GridTrackSize.MinMax
     */
    @Stable
    fun 弹性(@FloatRange(from = 0.0) weight: Fr): GridTrackSize =
        GridTrackSize.Flex(weight = weight)

    /**
     *   一个具有显式定义的最小基准大小和弹性最大大小的轨道。从概念上讲，其行为与 CSS Grid 的 `minmax(min, max)` 函数完全相同。
     *
     * **与 [GridTrackSize.Flex] 的区别：** 标准 [GridTrackSize.Flex] 轨道会固有地查询其子项的 `min-content` 固有尺寸以确定其最小基准大小，
     * 而 [最小最大] 严格使用所提供的 [min] 大小。
     *
     * **与惰性列表配合使用：** 由于 [最小最大] 依赖于预定义的 [min] 大小（例如 `0.dp`），它完全绕过了固有测量过程。
     * 这使其成为在弹性网格轨道内放置由 `SubcomposeLayout` 支持的组件（如 `LazyColumn` 或 `LazyRow`）时的必需选择，
     * 因为如果查询这些组件的固有尺寸，它们将会崩溃。
     *
     * @param min 显式定义的最小固定基准大小（例如 `0.dp`）。
     * @param max 最大弹性分配权重（例如 `1.fr`）。
     * @throws IllegalArgumentException 如果 [min] 或 [max] 为负数。
     * @see GridTrackSize.Flex
     */
    @Stable
    fun 最小最大(min: Dp, @FloatRange(from = 0.0) max: Fr): GridTrackSize =
        GridTrackSize.MinMax(min = min, max = max)

    /** 一个自动调整大小以适配其内容最小固有尺寸的轨道。 */
    val 最小内容 = GridTrackSize.MinContent

    /** 一个自动调整大小以适配其内容最大固有尺寸的轨道。 */
    val 最大内容 = GridTrackSize.MaxContent

    /** 一个行为等同于 `minmax(min-content, max-content)` 的轨道。它至少占据其最小内容尺寸，并在空间可用时扩展以适配其最大内容尺寸。*/
    val 自动 = GridTrackSize.Auto

}

