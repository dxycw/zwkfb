package 安卓x.组合.基础.布局

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.FlexAlignContent
import androidx.compose.foundation.layout.FlexAlignItems
import androidx.compose.foundation.layout.FlexAlignSelf
import androidx.compose.foundation.layout.FlexBasis
import androidx.compose.foundation.layout.FlexBox
import androidx.compose.foundation.layout.FlexBoxConfig
import androidx.compose.foundation.layout.FlexBoxConfigScope
import androidx.compose.foundation.layout.FlexBoxScope
import androidx.compose.foundation.layout.FlexConfig
import androidx.compose.foundation.layout.FlexConfigScope
import androidx.compose.foundation.layout.FlexDirection
import androidx.compose.foundation.layout.FlexJustifyContent
import androidx.compose.foundation.layout.FlexWrap
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.Measured
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

/**
 * 一种将子项沿单一方向（主轴）对齐排列，并允许其换行至多行的布局。[FlexBox] 提供了一个高度可配置的布局系统，
 * 作为 [行]、[列]、[流式行] 和 [流式列] 的灵活超集。
 *
 * 容器的布局行为由 [内容] 参数控制，该参数决定了弹性方向、换行行为、对齐方式和间距。各个子项还可以使用
 * [FlexBoxScope.flex] 修饰符进一步控制自身的弹性（增长、收缩和基础大小）以及对齐方式。
 *
 * 理解 FlexBox 需要熟悉其轴线：
 *
 * - **主轴（Main Axis）**：子项沿其排列的主要方向，由 [FlexBoxConfigScope.direction] 决定。子项从
 * `main-start`（主轴起点）边缘开始放置，流向 `main-end`（主轴终点）边缘。默认为 [FlexDirection.Row]。
 * - 对于 **[FlexDirection.Row]**：`main-start` 是布局的起始边缘（LTR 中为左侧，RTL 中为右侧），
 * `main-end` 是结束边缘（LTR 中为右侧，RTL 中为左侧）。
 * - 对于 **[FlexDirection.RowReverse]**：`main-start` 是布局的结束边缘（LTR 中为右侧，RTL 中为左侧），
 * `main-end` 是起始边缘（LTR 中为左侧，RTL 中为右侧）。
 * - 对于 **[FlexDirection.Column]**：`main-start` 是上边缘，`main-end` 是下边缘。
 * - 对于 **[FlexDirection.ColumnReverse]**：`main-start` 是下边缘，`main-end` 是上边缘。
 *
 * - **交叉轴（Cross Axis）**：与主轴垂直的轴线。换行时新增行，子项在其所在行内对齐，从 `cross-start`
 * （交叉轴起点）边缘开始，流向 `cross-end`（交叉轴终点）边缘。
 * - 对于水平方向（[FlexDirection.Row] 和 [FlexDirection.RowReverse]）：`cross-start` 是上边缘，
 * `cross-end` 是下边缘。
 * - 对于垂直方向（[FlexDirection.Column] 和 [FlexDirection.ColumnReverse]）：`cross-start`
 * 是布局的起始边缘，`cross-end` 是结束边缘。
 *
 * 子项可以使用 [FlexBoxScope.flex] 修饰符来决定如何分配可用空间：
 *
 * - **[FlexConfigScope.grow]**：定义该项相对于其兄弟项应消耗多少剩余的正向空闲空间。默认为 `0f`（不增长）。
 * - **[FlexConfigScope.shrink]**：定义当所有子项的总大小超过容器的主轴尺寸时，该项应收缩多少。默认为 `1f`。
 * - **[FlexConfigScope.basis]**：在计算任何空闲空间分配（增长或收缩）之前，设置该项的初始主轴大小。默认为 [FlexBasis.Auto]。
 *
 * [FlexBox] 提供了对子项和行（线）放置的精细控制：
 *
 * - **[FlexBoxConfigScope.wrap]**：控制当子项超出可用空间时，是强制它们排成单行，还是允许换行到多行。
 * 默认为 [FlexWrap.NoWrap]。
 * - **[FlexBoxConfigScope.justifyContent]**：沿主轴分布子项（例如，使它们均匀分布）。
 * 默认为 [FlexJustifyContent.Start]。
 * - **[FlexBoxConfigScope.alignItems]**：沿交叉轴在特定行内对齐子项（例如，在 Row 中垂直居中）。
 * 默认为 [FlexAlignItems.Start]。
 * - **[FlexConfigScope.alignSelf]**：允许单个子项覆盖容器的 [FlexBoxConfigScope.alignItems] 设置。
 * 默认为 [FlexAlignSelf.Auto]。
 * - **[FlexBoxConfigScope.alignContent]**：沿交叉轴分布多条换行后的行。仅在启用换行时生效。
 * 默认为 [FlexAlignContent.Start]。
 *
 * 默认情况下，子项以水平行的方式排列，不进行换行。 如果禁用了换行（[FlexWrap.NoWrap]），当子项的收缩因子大于 0 时，
 * 它们会收缩以适应容器。如果子项由于其最小固有尺寸而无法充分收缩，它们将沿主轴方向在视觉上溢出容器的边界。
 * 如果你希望隐藏溢出的内容，可以在 FlexBox 上显式应用 [Modifier.clipToBounds][androidx.compose.ui.draw.clipToBounds]。
 *
 * @param 修饰符 要应用于此 FlexBox 容器的修饰符。
 * @param 配置 一个用于配置容器布局属性的 [FlexBoxConfig]。默认配置为：水平行布局、不换行，
 * 子项在两条轴上均对齐到起始位置，且子项之间无间距。
 * @param 内容 FlexBox 的内容，定义在 [FlexBoxScope] 作用域内。
 * @see FlexBoxConfig
 * @see FlexBoxScope
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalFlexBoxApi
inline fun 弹性盒子(
    修饰符: Modifier = Modifier,
    配置: FlexBoxConfig = FlexBoxConfig,
    内容: @Composable FlexBoxScope.() -> Unit,
) =
    FlexBox(
        modifier = 修饰符,
        config = 配置,
        content = 内容,
    )

//=====================================================================================

/**
 * [FlexBox] 内容的作用域。提供 [弹性] 修饰符，用于配置各个弹性子项的属性。
 *
 * @see FlexBox
 * @see FlexConfig
 */
@LayoutScopeMarker
@Immutable
@ExperimentalFlexBoxApi
interface 弹性盒子范围 {

    /**
     * 使用所提供的[FlexConfig]，配置此元素在[FlexBox]中的弹性属性。
     *
     * @param 弹性配置 要应用的弹性配置。
     * @see FlexConfig
     */
    @Stable fun Modifier.弹性(弹性配置: FlexConfig): Modifier

    /**
     * 使用配置 lambda 来配置此元素在 [FlexBox] 中的弹性属性。
     *
     * 此修饰符允许你指定单个子项应如何分配可用空间（增长、收缩、基础大小），以及它如何沿交叉轴进行自身对齐（alignSelf）。
     *
     * @param 弹性配置 一个在 [FlexConfigScope] 中配置弹性属性的 lambda。
     * @see FlexConfigScope
     */
    @Stable
    fun Modifier.弹性(弹性配置: FlexConfigScope.() -> Unit): Modifier =
        弹性(FlexConfig(弹性配置))

}

//=====================================================================================

/**
 * 定义 [FlexBox] 容器中主轴的方向。
 *
 * 主轴决定了子项排列的主要方向。它确立了容器的 `main-start`（主轴起点）和 `main-end`（主轴终点）边缘。交叉轴始终与主轴垂直。
 *
 * @see FlexBoxConfigScope.direction
 */
@ExperimentalFlexBoxApi
object 弹性方向 {

    /**
     * 主轴为水平方向。子项从 `main-start`（主轴起点）边缘开始放置，流向 `main-end`（主轴终点）边缘。
     *
     * 在从左到右（LTR）的布局方向中，`main-start` 对应于容器的起始（左）边缘。在从右到左（RTL）的布局方向中，
     * `main-start` 对应于容器的结束（右）边缘。
     */
    inline val 行
        get() = FlexDirection.Row

    /** 主轴为垂直方向。子项从 `main-start`（主轴起点，即容器的顶部）边缘开始放置，流向 `main-end`（主轴终点，即容器的底部）边缘。*/
    inline val 列
        get() = FlexDirection.Column

    /**
     * 主轴为水平方向，但排列方向相反。`main-start`（主轴起点）和 `main-end`（主轴终点）边缘互换。
     *
     * 在从左到右（LTR）的布局方向中，`main-start` 变为容器的右边缘，子项向左流动。在从右到左（RTL）的布局方向中，
     * `main-start` 变为容器的左边缘。
     */
    inline val 行反向
        get() = FlexDirection.RowReverse

    /** 主轴为垂直方向，但排列方向相反。`main-start`（主轴起点）边缘变为容器的底部，子项流向位于顶部的 `main-end`（主轴终点）边缘。*/
    inline val 列反向
        get() = FlexDirection.ColumnReverse

}

/**
 * 定义弹性子项是被强制排成单行，还是可以换行到多行。
 *
 * @see FlexBoxConfigScope.wrap
 */
@ExperimentalFlexBoxApi
object 弹性换行 {

    /**
     * 子项排成单行排列。如果子项的 [FlexConfigScope.shrink] 收缩因子允许，它们会收缩以适应容器。
     * 如果它们无法充分收缩以适应主轴（例如，由于其最小固有尺寸），它们将在容器的主轴方向上视觉上溢出。
     */
    inline val 不换行
        get() = FlexWrap.NoWrap

    /**
     * 如果子项超出主轴尺寸，它们会换行到多行。新行沿交叉轴方向添加，从 `cross-start`（交叉轴起点）边缘开始，
     * 流向 `cross-end`（交叉轴终点）边缘。（例如，在 **[FlexDirection.Row]** 中是从上到下）。
     */
    inline val 换行
        get() = FlexWrap.Wrap

    /**
     * 如果子项超出主轴尺寸，它们会换行到多行。新行沿交叉轴的反方向添加，从 `cross-end`（交叉轴终点）边缘开始，
     * 流向 `cross-start`（交叉轴起点）边缘。（例如，在 [FlexDirection.Row] 中是从下到上）。
     */
    inline val 换行反向
        get() = FlexWrap.WrapReverse

}

/**
 * 定义子项在其所在行内沿交叉轴的默认对齐方式。它控制子项相对于主轴的垂直定位。单个子项可通过 [FlexConfigScope.alignSelf] 覆盖此设置。
 *
 * @see FlexBoxConfigScope.alignItems
 * @see FlexAlignSelf
 */
@ExperimentalFlexBoxApi
object 弹性对齐项集 {

    /** 子项对齐到其所在行的交叉轴起点边缘。 */
    inline val 起始
        get() = FlexAlignItems.Start

    /** 子项对齐到其所在行的交叉轴终点边缘。*/
    inline val 结束
        get() = FlexAlignItems.End

    /** 子项在其所在行内沿交叉轴居中对齐。 */
    inline val 居中
        get() = FlexAlignItems.Center

    /** 子项被拉伸，以填满其所在行的交叉轴尺寸。 */
    inline val 拉伸
        get() = FlexAlignItems.Stretch

    /** 子项沿交叉轴对齐，使其基线保持一致。没有基线的子项回退到 [起始] 对齐方式。*/
    inline val 基线
        get() = FlexAlignItems.Baseline

}

/**
 * 定义单个子项在交叉轴上的对齐方式，覆盖容器的 [FlexAlignItems] 设置。
 *
 * 这控制单个子项在其所在行内，相对于主轴的垂直定位方式。
 *
 * @see FlexConfigScope.alignSelf
 * @see FlexAlignItems
 */
@ExperimentalFlexBoxApi
object 弹性对齐自身 {

    /** 继承容器的 [FlexBoxConfigScope.alignItems] 对齐方式。这是默认值。*/
    inline val 自动
        get() = FlexAlignSelf.Auto

    /** 子项对齐到其所在行的 `cross-start`（交叉轴起点）边缘。 */
    inline val 起始
        get() = FlexAlignSelf.Start

    /** 子项对齐到其所在行的交叉轴终点边缘。 */
    inline val 结束
        get() = FlexAlignSelf.End

    /** 子项在其所在行内沿交叉轴居中对齐。 */
    inline val 居中
        get() = FlexAlignSelf.Center

    /** 子项被拉伸，以填满其所在行的交叉轴尺寸。 */
    inline val 拉伸
        get() = FlexAlignSelf.Stretch

    /** 子项对齐时，使其基线与该行中其他基线对齐的子项的基线保持一致。没有基线的子项回退到 [起始] 对齐方式。*/
    inline val 基线
        get() = FlexAlignSelf.Baseline

}

/**
 * 定义多行沿交叉轴的分布方式。这仅在启用换行（[FlexWrap.Wrap] 或 [FlexWrap.WrapReverse]）、
 * 容器具有额外的交叉轴空间，且存在多行子项时生效。
 *
 * @see FlexBoxConfigScope.alignContent
 */
@ExperimentalFlexBoxApi
object 弹性对齐内容 {

    /** 将各行尽可能靠近容器的 `cross-start`（交叉轴起点）边缘放置。*/
    inline val 起始
        get() = FlexAlignContent.Start

    /** 将各行尽可能靠近容器的 `cross-end`（交叉轴终点）边缘放置。*/
    inline val 结束
        get() = FlexAlignContent.End

    /** 将各行尽可能靠近容器交叉轴的中部放置。*/
    inline val 居中
        get() = FlexAlignContent.Center

    /** 在所有行之间均匀分配剩余的空闲空间，增加它们的交叉轴尺寸以填满可用空间。*/
    inline val 拉伸
        get() = FlexAlignContent.Stretch

    /** 将各行沿交叉轴均匀分布，首行之前与末行之后不留空闲空间。*/
    inline val 两端分布
        get() = FlexAlignContent.SpaceBetween

    /** 将各行沿交叉轴均匀分布，首行之前与末行之后均包含空闲空间，但这些位置的空闲空间量为相邻两行之间空闲空间量的一半。*/
    inline val 均匀环绕
        get() = FlexAlignContent.SpaceAround

}

/**
 * 定义子项在其所在行内沿主轴的排列方式。这控制子项的主轴尺寸确定后，空闲空间如何在子项之间及周围分配。
 *
 * @see FlexBoxConfigScope.justifyContent
 */
@ExperimentalFlexBoxApi
object 弹性主轴内容 {

    /** 将子项放置到尽可能靠近其所在行的 `main-start`（主轴起点）边缘的位置。*/
    inline val 起始
        get() = FlexJustifyContent.Start

    /** 将子项放置到尽可能靠近其所在行的 `main-end`（主轴终点）边缘的位置。*/
    inline val 结束
        get() = FlexJustifyContent.End

    /** 将子项尽可能靠近其所在行的主轴中部放置。*/
    inline val 居中
        get() = FlexJustifyContent.Center

    /** 将子项沿主轴均匀分布，首项之前与末项之后不留空闲空间。*/
    inline val 两端分布
        get() = FlexJustifyContent.SpaceBetween

    /** 将子项沿主轴均匀分布，首项之前与末项之后均包含空闲空间，但这些位置的空闲空间量为相邻两项之间空闲空间量的一半。*/
    inline val 均匀环绕
        get() = FlexJustifyContent.SpaceAround

    /** 将子项沿主轴均匀分布，首项之前与末项之后均包含空闲空间。*/
    inline val 均匀分布
        get() = FlexJustifyContent.SpaceEvenly

}

/**
 * 定义弹性子项在空闲空间分配之前的初始主轴大小。
 *
 * - **[自动]**：使用子项显式设置的大小，若未设置则回退到其自然内容大小。
 * - **[Dp]**：使用 [androidx.compose.ui.unit.Dp] 中的固定精确大小。
 * - **[百分比]**：使用容器主轴大小的一部分（比例）。
 *
 * @see FlexConfigScope.basis
 */
@ExperimentalFlexBoxApi
object 弹性基础 {

    /**
     * 使用子项的最大固有尺寸作为基准。
     *
     * 如果子项沿主轴方向设置了显式的大小修饰符（例如，在[FlexDirection.Row]中的 `Modifier.width`），
     * 则该精确大小将被用作基准。否则，将回退到在无约束条件下测量子项的首选自然内容大小。
     *
     * 这是默认值。
     */
    val 自动 = FlexBasis.Auto

    /**
     * 使用 [androidx.compose.ui.unit.Dp] 中的固定大小作为基准。
     *
     * @param 值 以 Dp 为单位的基准大小。
     */
    fun Dp(值: Dp): FlexBasis = FlexBasis.Dp(value = 值)

    /**
     * 使用容器主轴大小的一部分（比例）作为基准。
     *
     * @param 值 一个介于 0.0 和 1.0 之间的值，代表百分比。
     */
    fun 百分比(@FloatRange(0.0, 1.0) 值: Float): FlexBasis =
        FlexBasis.Percent(value = 值)

}


//=====================================================================================

/**
 * 表示 [FlexBox] 容器的配置。
 *
 * 此配置通过一个作用于 [FlexBoxConfigScope] 的 lambda 来定义。由于此配置代码块在布局阶段而非组合阶段执行，
 * 在块内读取状态变量将仅触发一次布局传递，从而完全避免开销较大的重组。
 *
 * 配置属性按顺序应用。如果某个属性在代码块中被多次配置，则以最后一次调用为准。
 *
 * 此外，由于 [FlexBoxConfigScope] 提供对传入的 [Constraints][androidx.compose.ui.unit.Constraints] 的直接访问，
 * 你可以轻松创建响应式配置，根据可用的屏幕空间动态调整其方向、换行方式或间距：
 *
 * @see FlexBoxConfigScope
 * @see FlexBox
 */
@Stable
@ExperimentalFlexBoxApi
fun interface 弹性盒子配置 {

    /** 将配置应用到给定的 [FlexBoxConfigScope]。此方法由布局系统在测量阶段调用，而非组合阶段。*/
    fun FlexBoxConfigScope.配置()

    /**
     * 将此配置与另一个配置合并。位于"右侧"的配置将按属性逐一覆盖其左侧的配置。
     *
     * @param 其他 要合并到接收者（此对象）中的配置。
     */
    infix fun 则(其他: 弹性盒子配置): 弹性盒子配置 =
        when {
            (其他 === Companion) -> this
            其他 is CombinedFlexBoxConfig -> CombinedFlexBoxConfig(this, *其他.configs)
            else -> CombinedFlexBoxConfig(this, 其他)
        }

    companion object : 弹性盒子配置 {

        /** 默认配置为水平行布局、不换行，子项在两条轴上均对齐到起始位置，且子项之间无间距。*/
        override fun FlexBoxConfigScope.配置() {}

        /** 恒等省略：将恒等配置与任何配置合并，结果即为该配置本身。*/
        override fun 则(其他: 弹性盒子配置): 弹性盒子配置 = 其他
    }
}

@ExperimentalFlexBoxApi
internal class CombinedFlexBoxConfig(vararg val configs: 弹性盒子配置) : 弹性盒子配置 {
    override fun FlexBoxConfigScope.配置() {
        configs.forEach { config -> with(config) { 配置() } }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CombinedFlexBoxConfig) return false
        return configs.contentEquals(other.configs)
    }

    override fun hashCode(): Int = configs.contentHashCode()
}

//=====================================================================================

/**
 * 用于配置 [FlexBox] 容器属性的接收者作用域。
 *
 * 此作用域由 [FlexBoxConfig] 提供。所有配置函数均在布局/测量阶段调用，而非组合阶段。
 * 对此作用域内读取的状态支持值的更改将触发重新布局，完全跳过重组。
 *
 * @see FlexBoxConfig
 */
@ExperimentalFlexBoxApi
sealed interface 弹性盒子配置范围 : Density { // FlexBoxConfigScope

    /**
     * 从父组件传递给此 [FlexBox] 的布局约束。
     *
     * 用于创建响应式布局，根据可用的传入空间动态调整其属性（如方向、换行方式或间距）。
     *
     * @see Constraints
     */
    val 约束: Constraints // constraints

    /**
     * 设置子项沿其排列的主轴方向。
     *
     * 主轴决定了子项放置的主要方向：
     *
     * - **[FlexDirection.Row]**：子项水平放置，从 `main-start`（主轴起点）到 `main-end`（主轴终点）（RTL 中从终点到起点）。
     * - **[FlexDirection.RowReverse]**：子项水平放置，从终点到起点（RTL 中从起点到终点）。
     * - **[FlexDirection.Column]**：子项垂直放置，从上到下。
     * - **[FlexDirection.ColumnReverse]**：子项垂直放置，从下到上。
     *
     * @param 值 弹性方向。默认值为 [FlexDirection.Row]。
     * @see FlexDirection
     */
    fun 方向(值: FlexDirection) // direction

    /**
     * 设置子项是被强制排成单行，还是可以换行到多行。
     *
     * - **[FlexWrap.NoWrap]**：所有子项保持在单行上。如果它们无法充分收缩，可能会在主轴方向上视觉上溢出。
     * - **[FlexWrap.Wrap]**：子项向 `cross-end`（交叉轴终点）边缘换行到新行。
     * - **[FlexWrap.WrapReverse]**：子项向 `cross-start`（交叉轴起点）边缘换行到新行。
     *
     * @param 值 换行行为。默认值为 [FlexWrap.NoWrap]。
     * @see FlexWrap
     */
    fun 换行(值: FlexWrap) // wrap

    /**
     * 设置子项沿主轴的分布方式。
     *
     * 这控制子项主轴尺寸确定后，在其所在行内的间距和定位。
     *
     * - **[FlexJustifyContent.Start]**：子项紧凑排列在 `main-start`（主轴起点）边缘。
     * - **[FlexJustifyContent.End]**：子项紧凑排列在 `main-end`（主轴终点）边缘。
     * - **[FlexJustifyContent.Center]**：子项沿主轴居中对齐。
     * - **[FlexJustifyContent.SpaceBetween]**：子项均匀分布；首项在起点，末项在终点。
     * - **[FlexJustifyContent.SpaceAround]**：子项均匀分布，两端各分配一半大小的空间。
     * - **[FlexJustifyContent.SpaceEvenly]**：子项均匀分布，所有位置的空间完全相等。
     *
     * @param 值 主轴内容对齐方式的值。默认值为 [FlexJustifyContent.Start]。
     * @see FlexJustifyContent
     */
    fun 主轴内容(值: FlexJustifyContent) // justifyContent

    /**
     * 设置子项在其所在行内沿交叉轴的默认对齐方式。
     *
     * 这控制子项相对于主轴的垂直定位方式。单个子项可使用 [FlexConfigScope.alignSelf] 覆盖此默认对齐方式。
     *
     * - **[FlexAlignItems.Start]**：子项在其所在行内对齐到 `cross-start`（交叉轴起点）边缘。
     * - **[FlexAlignItems.End]**：子项在其所在行内对齐到 `cross-end`（交叉轴终点）边缘。
     * - **[FlexAlignItems.Center]**：子项在其所在行内沿交叉轴居中对齐。
     * - **[FlexAlignItems.Stretch]**：子项被拉伸，以填满其所在行的交叉轴尺寸。
     * - **[FlexAlignItems.Baseline]**：子项在其所在行内按基线对齐。
     *
     * @param 值 子项对齐方式的值。默认值为 [FlexAlignItems.Start]。
     * @see FlexAlignItems
     * @see FlexConfigScope.alignSelf
     */
    fun 对齐项集(值: FlexAlignItems) // alignItems

    /**
     * 将所有子项对齐到特定的基线。
     *
     * 这等价于调用 `alignItems(FlexAlignItems.Baseline)`，但允许精确指定要使用哪条对齐线
     * （例如，[FirstBaseline] 或 [LastBaseline]）。
     *
     * @param 对齐线 要使用的对齐线。
     * @see AlignmentLine
     */
    fun 对齐项集(对齐线: AlignmentLine) // alignItems

    /**
     * 将所有子项对齐到从每个已测量子项计算得出的自定义基线。
     *
     * 当你需要自定义基线计算逻辑时使用。其功能类似于 [androidx.compose.foundation.layout.RowScope.alignBy]
     * 和 [androidx.compose.foundation.layout.ColumnScope.alignBy]。
     *
     * @param 对齐线块 一个从 [Measured] 子项计算基线位置的函数。
     * @see Measured
     */
    fun 对齐项集(对齐线块: (Measured) -> Int) // alignItems

    /**
     * 设置多行沿交叉轴的分布方式。
     *
     * 这仅在 [FlexBoxConfigScope.wrap] 为 [FlexWrap.Wrap] 或 [FlexWrap.WrapReverse] 且存在多行子项时生效。
     *
     * - [FlexAlignContent.Start]：行紧凑排列在 `cross-start`（交叉轴起点）边缘。
     * - [FlexAlignContent.End]：行紧凑排列在 `cross-end`（交叉轴终点）边缘。
     * - [FlexAlignContent.Center]：行沿交叉轴居中对齐。
     * - [FlexAlignContent.Stretch]：行拉伸以填满可用的交叉轴空间。
     * - [FlexAlignContent.SpaceBetween]：行均匀分布；首行在起点，末行在终点。
     * - [FlexAlignContent.SpaceAround]：行均匀分布，
     *
     * @param 值 内容对齐方式的值。默认值为 [FlexAlignContent.Start]。
     * @see FlexAlignContent
     * @see FlexBoxConfigScope.wrap
     */
    fun 对齐内容(值: FlexAlignContent) // alignContent

    /**
     * 设置子项或行之间的垂直间距。
     *
     * 无论弹性 [FlexBoxConfigScope.direction] 如何，此属性始终沿垂直轴（Y轴）应用间距。在启用换行的水平布局中，这表示换行后的行之间的间距。
     * 在垂直布局中，这表示子项本身之间的间距。
     *
     * @param 值 垂直间隙大小。默认值为 `0.dp`。
     * @see FlexBoxConfigScope.columnGap
     * @see FlexBoxConfigScope.gap
     */
    fun 行间隙(值: Dp) // rowGap

    /**
     * 设置子项或列之间的水平间距。
     *
     * 无论弹性 [FlexBoxConfigScope.direction] 如何，此属性始终沿水平轴（X轴）应用间距。在水平布局中，这表示子项本身之间的间距。
     * 在启用换行的垂直布局中，这表示换行后的列之间的间距。
     *
     * @param 值 水平间隙大小。默认值为 `0.dp`。
     * @see FlexBoxConfigScope.rowGap
     * @see FlexBoxConfigScope.gap
     */
    fun 列间隙(值: Dp) // columnGap

    /**
     * 将 [FlexBoxConfigScope.rowGap] 和 [FlexBoxConfigScope.columnGap] 设置为相同的值。
     *
     * 这是一个便捷函数，用于在两个轴上设置统一的间距。
     *
     * @param 全 要同时应用于行间距和列间距的间隙大小。
     * @see FlexBoxConfigScope.rowGap
     * @see FlexBoxConfigScope.columnGap
     */
    fun 间隙(全: Dp) // gap

    /**
     * 将 [FlexBoxConfigScope.rowGap] 和 [FlexBoxConfigScope.columnGap] 设置为不同的值。
     *
     * @param 行 垂直间距（Y轴）。
     * @param 列 水平间距（X轴）。
     * @see FlexBoxConfigScope.rowGap
     * @see FlexBoxConfigScope.columnGap
     */
    fun 间隙(行: Dp, 列: Dp) // gap

}


/**
 * 从父组件传递给此 [FlexBox] 的布局约束。
 *
 * 用于创建响应式布局，根据可用的传入空间动态调整其属性（如方向、换行方式或间距）。
 *
 * @see Constraints
 */
@ExperimentalFlexBoxApi
val FlexBoxConfigScope.约束: Constraints
    get() = this.constraints

/**
 * 设置子项沿其排列的主轴方向。
 *
 * 主轴决定了子项放置的主要方向：
 *
 * - **[FlexDirection.Row]**：子项水平放置，从 `main-start`（主轴起点）到 `main-end`（主轴终点）（RTL 中从终点到起点）。
 * - **[FlexDirection.RowReverse]**：子项水平放置，从终点到起点（RTL 中从起点到终点）。
 * - **[FlexDirection.Column]**：子项垂直放置，从上到下。
 * - **[FlexDirection.ColumnReverse]**：子项垂直放置，从下到上。
 *
 * @param 值 弹性方向。默认值为 [FlexDirection.Row]。
 * @see FlexDirection
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.方向(值: FlexDirection) = this.direction(value = 值)

/**
 * 设置子项是被强制排成单行，还是可以换行到多行。
 *
 * - **[FlexWrap.NoWrap]**：所有子项保持在单行上。如果它们无法充分收缩，可能会在主轴方向上视觉上溢出。
 * - **[FlexWrap.Wrap]**：子项向 `cross-end`（交叉轴终点）边缘换行到新行。
 * - **[FlexWrap.WrapReverse]**：子项向 `cross-start`（交叉轴起点）边缘换行到新行。
 *
 * @param 值 换行行为。默认值为 [FlexWrap.NoWrap]。
 * @see FlexWrap
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.换行(值: FlexWrap) = this.wrap(value = 值)

/**
 * 设置子项沿主轴的分布方式。
 *
 * 这控制子项主轴尺寸确定后，在其所在行内的间距和定位。
 *
 * - **[FlexJustifyContent.Start]**：子项紧凑排列在 `main-start`（主轴起点）边缘。
 * - **[FlexJustifyContent.End]**：子项紧凑排列在 `main-end`（主轴终点）边缘。
 * - **[FlexJustifyContent.Center]**：子项沿主轴居中对齐。
 * - **[FlexJustifyContent.SpaceBetween]**：子项均匀分布；首项在起点，末项在终点。
 * - **[FlexJustifyContent.SpaceAround]**：子项均匀分布，两端各分配一半大小的空间。
 * - **[FlexJustifyContent.SpaceEvenly]**：子项均匀分布，所有位置的空间完全相等。
 *
 * @param 值 主轴内容对齐方式的值。默认值为 [FlexJustifyContent.Start]。
 * @see FlexJustifyContent
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.主轴内容(值: FlexJustifyContent) = this.justifyContent(value = 值)

/**
 * 设置子项在其所在行内沿交叉轴的默认对齐方式。
 *
 * 这控制子项相对于主轴的垂直定位方式。单个子项可使用 [FlexConfigScope.alignSelf] 覆盖此默认对齐方式。
 *
 * - **[FlexAlignItems.Start]**：子项在其所在行内对齐到 `cross-start`（交叉轴起点）边缘。
 * - **[FlexAlignItems.End]**：子项在其所在行内对齐到 `cross-end`（交叉轴终点）边缘。
 * - **[FlexAlignItems.Center]**：子项在其所在行内沿交叉轴居中对齐。
 * - **[FlexAlignItems.Stretch]**：子项被拉伸，以填满其所在行的交叉轴尺寸。
 * - **[FlexAlignItems.Baseline]**：子项在其所在行内按基线对齐。
 *
 * @param 值 子项对齐方式的值。默认值为 [FlexAlignItems.Start]。
 * @see FlexAlignItems
 * @see FlexConfigScope.alignSelf
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.对齐项集(值: FlexAlignItems) = this.alignItems(value = 值)

/**
 * 将所有子项对齐到特定的基线。
 *
 * 这等价于调用 `alignItems(FlexAlignItems.Baseline)`，但允许精确指定要使用哪条对齐线
 * （例如，[FirstBaseline] 或 [LastBaseline]）。
 *
 * @param 对齐线 要使用的对齐线。
 * @see AlignmentLine
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.对齐项集(对齐线: AlignmentLine) = this.alignItems(alignmentLine = 对齐线)

/**
 * 将所有子项对齐到从每个已测量子项计算得出的自定义基线。
 *
 * 当你需要自定义基线计算逻辑时使用。其功能类似于 [androidx.compose.foundation.layout.RowScope.alignBy]
 * 和 [androidx.compose.foundation.layout.ColumnScope.alignBy]。
 *
 * @param 对齐线块 一个从 [Measured] 子项计算基线位置的函数。
 * @see Measured
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.对齐项集(对齐线块: (Measured) -> Int) = this.alignItems(alignmentLineBlock = 对齐线块)

/**
 * 设置多行沿交叉轴的分布方式。
 *
 * 这仅在 [FlexBoxConfigScope.wrap] 为 [FlexWrap.Wrap] 或 [FlexWrap.WrapReverse] 且存在多行子项时生效。
 *
 * - [FlexAlignContent.Start]：行紧凑排列在 `cross-start`（交叉轴起点）边缘。
 * - [FlexAlignContent.End]：行紧凑排列在 `cross-end`（交叉轴终点）边缘。
 * - [FlexAlignContent.Center]：行沿交叉轴居中对齐。
 * - [FlexAlignContent.Stretch]：行拉伸以填满可用的交叉轴空间。
 * - [FlexAlignContent.SpaceBetween]：行均匀分布；首行在起点，末行在终点。
 * - [FlexAlignContent.SpaceAround]：行均匀分布，
 *
 * @param 值 内容对齐方式的值。默认值为 [FlexAlignContent.Start]。
 * @see FlexAlignContent
 * @see FlexBoxConfigScope.wrap
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.对齐内容(值: FlexAlignContent) = this.alignContent(value = 值)

/**
 * 设置子项或行之间的垂直间距。
 *
 * 无论弹性 [FlexBoxConfigScope.direction] 如何，此属性始终沿垂直轴（Y轴）应用间距。在启用换行的水平布局中，这表示换行后的行之间的间距。
 * 在垂直布局中，这表示子项本身之间的间距。
 *
 * @param 值 垂直间隙大小。默认值为 `0.dp`。
 * @see FlexBoxConfigScope.columnGap
 * @see FlexBoxConfigScope.gap
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.行间隙(值: Dp) = this.rowGap(value = 值)

/**
 * 设置子项或列之间的水平间距。
 *
 * 无论弹性 [FlexBoxConfigScope.direction] 如何，此属性始终沿水平轴（X轴）应用间距。在水平布局中，这表示子项本身之间的间距。
 * 在启用换行的垂直布局中，这表示换行后的列之间的间距。
 *
 * @param 值 水平间隙大小。默认值为 `0.dp`。
 * @see FlexBoxConfigScope.rowGap
 * @see FlexBoxConfigScope.gap
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.列间隙(值: Dp) = this.columnGap(value = 值)

/**
 * 将 [FlexBoxConfigScope.rowGap] 和 [FlexBoxConfigScope.columnGap] 设置为相同的值。
 *
 * 这是一个便捷函数，用于在两个轴上设置统一的间距。
 *
 * @param 全 要同时应用于行间距和列间距的间隙大小。
 * @see FlexBoxConfigScope.rowGap
 * @see FlexBoxConfigScope.columnGap
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.间隙(全: Dp) = this.gap(all = 全)

/**
 * 将 [FlexBoxConfigScope.rowGap] 和 [FlexBoxConfigScope.columnGap] 设置为不同的值。
 *
 * @param 行 垂直间距（Y轴）。
 * @param 列 水平间距（X轴）。
 * @see FlexBoxConfigScope.rowGap
 * @see FlexBoxConfigScope.columnGap
 */
@ExperimentalFlexBoxApi
fun FlexBoxConfigScope.间隙(行: Dp, 列: Dp) = this.gap(row = 行, column = 列)

//=====================================================================================

/**
 * 表示 [FlexBox] 中弹性子项的配置。
 *
 * 此配置通过一个作用于 [FlexConfigScope] 的 lambda 来定义。由于此配置代码块在布局阶段而非组合阶段执行，
 * 在块内读取状态变量将仅触发一次布局传递，从而完全避免开销较大的重组。
 *
 * 配置属性按顺序应用。如果某个属性（如 [grow][FlexConfigScope.grow] 或 [shrink][FlexConfigScope.shrink]）
 * 在配置代码块中被多次赋值，则以最后一次调用为准。
 *
 * @see FlexConfigScope
 * @see FlexBoxScope.flex
 */
@Stable
@ExperimentalFlexBoxApi
fun interface 弹性配置 {

    /** 将配置应用到给定的 [FlexConfigScope]。此方法由布局系统在测量阶段调用，而非组合阶段。*/
    fun FlexConfigScope.配置()

    /**
     * 将此配置与另一个配置合并。位于"右侧"的配置将按属性逐一覆盖其左侧的配置。
     *
     * @param 其他 要合并到接收者（此对象）中的配置。
     */
    infix fun 则(其他: 弹性配置): 弹性配置 =
        when {
            (其他 === Companion) -> this
            其他 is CombinedFlexConfig -> CombinedFlexConfig(this, *其他.configs)
            else -> CombinedFlexConfig(this, 其他)
        }

    companion object : 弹性配置 {
        override fun FlexConfigScope.配置() {}

        /** 将恒等配置与任何配置合并，结果即为该配置本身。 */
        override fun 则(其他: 弹性配置): 弹性配置 = 其他
    }

}

@OptIn(ExperimentalFlexBoxApi::class)
internal class CombinedFlexConfig(vararg val configs: 弹性配置) : 弹性配置 {
    override fun FlexConfigScope.配置() {
        configs.forEach { config -> with(config) { 配置() } }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CombinedFlexConfig) return false
        return configs.contentEquals(other.configs)
    }

    override fun hashCode(): Int = configs.contentHashCode()
}

//=====================================================================================

/**
 * 用于在 [FlexBox] 中配置弹性子项属性的作用域。
 *
 * 所有配置函数均在布局/测量阶段调用，而非组合阶段。
 *
 * @see FlexConfig
 */
@ExperimentalFlexBoxApi
sealed interface 弹性配置范围 : Density {

    /**
     * FlexBox 容器沿主轴的最大尺寸。对于 [FlexDirection.Row] / [FlexDirection.RowReverse]
     * 对应于 [Constraints.maxWidth]，对于 [FlexDirection.Column] / [FlexDirection.ColumnReverse]
     * 对应于 [Constraints.maxHeight]。可用于基于容器可用空间实现响应式子项尺寸。
     */
    val 弹性盒子主轴最大: Int // flexBoxMainAxisMax

    /**
     * FlexBox 容器沿主轴的最小尺寸。 对于 [FlexDirection.Row] / [FlexDirection.RowReverse] 对应于
     * [Constraints.minWidth]，对于 [FlexDirection.Column] / [FlexDirection.ColumnReverse]
     * 对应于 [Constraints.minHeight]。
     */
    val 弹性盒子主轴最小: Int // flexBoxMainAxisMin

    /**
     * FlexBox 容器沿交叉轴的最大尺寸。 对于 [FlexDirection.Row] / [FlexDirection.RowReverse] 对应于
     * [Constraints.maxHeight]，对于 [FlexDirection.Column] / [FlexDirection.ColumnReverse]
     * 对应于 [Constraints.maxWidth]。
     */
    val 弹性盒子交叉轴最大: Int // flexBoxCrossAxisMax

    /**
     * FlexBox 容器沿交叉轴的最小尺寸。对于 [FlexDirection.Row] / [FlexDirection.RowReverse]
     * 对应于 [Constraints.minHeight]，对于 [FlexDirection.Column] / [FlexDirection.ColumnReverse]
     * 对应于 [Constraints.minWidth]。
     */
    val 弹性盒子交叉轴最小: Int // flexBoxCrossAxisMin

    /**
     * 为此特定子项覆盖容器的 [FlexBoxConfigScope.alignItems] 设置。
     *
     *  这控制单个子项在其所在行内相对于主轴的垂直定位方式。
     *
     * - **[FlexAlignSelf.Auto]**：继承容器的对齐方式（默认）。
     * - **[FlexAlignSelf.Start]**：对齐到其所在行的 `cross-start`（交叉轴起点）边缘。
     * - **[FlexAlignSelf.End]**：对齐到其所在行的 `cross-end`（交叉轴终点）边缘。
     * - **[FlexAlignSelf.Center]**：在其所在行内沿交叉轴居中对齐。
     * - **[FlexAlignSelf.Stretch]**：拉伸以填满其所在行的交叉轴尺寸。
     * - **[FlexAlignSelf.Baseline]**：在其所在行内按基线对齐。
     *
     * @param 值 此子项的对齐方式。默认值为 [FlexAlignSelf.Auto]。
     * @see FlexAlignSelf
     * @see FlexBoxConfigScope.alignItems
     */
    fun 对齐自身(值: FlexAlignSelf) // alignSelf

    /**
     * 将此子项与其所在行内的特定基线对齐，覆盖容器的对齐设置。
     *
     * @param 对齐线 要使用的对齐线（例如，[FirstBaseline]（首基线）、[LastBaseline]（末基线））。
     * @see AlignmentLine
     */
    fun 对齐自身(对齐线: AlignmentLine) // alignSelf

    /**
     * 将此子项与其所在行内已测量子项计算出的自定义基线对齐，覆盖容器的对齐设置。
     *
     * @param 对齐线块 一个从 [Measured] 子项计算基线的函数。
     */
    fun 对齐自身(对齐线块: (Measured) -> Int) // alignSelf

    /**
     * 设置此子项相对于其兄弟项的视觉顺序。
     *
     * 子项在布局前按其顺序值升序排列。较小的值优先放置，从容器的主轴起点边缘开始。注意，在反向方向
     * （如 [FlexDirection.RowReverse]）中，主轴起点边缘在视觉上会被翻转（例如，翻转到容器的右侧）。
     *
     * 排序是稳定的；具有相同顺序值的子项保持它们在组合中发出的确切顺序。默认情况下，所有子项的顺序值为 0。
     * 你可以使用负值将子项移到默认顺序子项之前，或使用正值将其移到其后。
     *
     * @param 值 顺序值。默认值为 0。
     */
    fun 顺序(值: Int) // order

    /**
     * 设置弹性增长因子，决定此子项相对于其兄弟项应消耗多少剩余的正向空闲空间。
     *
     * 当所有子项基准大小的总和小于容器的主轴尺寸时，剩余空间将按增长因子比例分配给各子项。
     * 增长因子为 `0f`（默认值）的子项不会增长到超过其基准大小。
     *
     * @param 值 增长因子。必须为非负数。默认值为 `0f`。
     * @throws IllegalArgumentException 如果 [值] 为负数。
     * @see FlexConfigScope.shrink
     * @see FlexConfigScope.basis
     */
    fun 增长(@FloatRange(from = 0.0) 值: Float) // grow

    /**
     * 设置弹性收缩因子，决定当空间不足时，此子项相对于其兄弟项应收缩多少。
     *
     * 当所有子项基准大小的总和超过容器的主轴尺寸时，子项将根据其收缩因子乘以基准大小的结果按比例收缩。收缩因子为 `0f` 的子项不会收缩。
     *
     * **注意：** 子项永远不会收缩到低于其最小固有尺寸。如果所有子项的最小尺寸总和超过容器的尺寸，子项将在主轴方向上视觉上溢出。
     * 如果你需要隐藏溢出的内容，请在容器上应用 [Modifier.clipToBounds][androidx.compose.ui.draw.clipToBounds]。
     *
     * @param 值 收缩因子。必须为非负数。默认值为 `1f`。
     * @throws IllegalArgumentException 如果 [值] 为负数。
     * @see FlexConfigScope.grow
     * @see FlexConfigScope.basis
     */
    fun 收缩(@FloatRange(from = 0.0) 值: Float) // shrink

    /**
     * 设置此子项在计算任何空闲空间分配（增长或收缩）之前的初始主轴大小。
     *
     * 基准大小决定了在应用 [增长] 和 [收缩] 之前的起始大小：
     *
     * - **[FlexBasis.Auto]**：使用子项显式设置的大小，若未设置则回退到其自然内容大小。
     * - **[FlexBasis.Dp]**：使用以 dp 为单位的固定精确大小。
     * - **[FlexBasis.Percent]**：使用容器主轴大小的一个比例分数。
     *
     * @param 值 基准大小值。默认值为 [FlexBasis.Auto]
     * @see FlexBasis
     */
    fun 基础(值: FlexBasis) // basis

    /**
     * 将基准大小设置为固定的 Dp 值。这是一个便捷函数，等价于 `basis(FlexBasis.Dp(value))`。
     *
     * @param 值 以 Dp 为单位的基准大小。
     * @see FlexBasis.Dp
     */
    fun 基础(值: Dp) // basis

    /**
     * 将基准大小设置为容器主轴大小的一个比例分数。这是一个便捷函数，等价于 `basis(FlexBasis.Percent(value))`。
     *
     * @param 值 一个介于 0.0 和 1.0 之间的值，代表容器大小的比例分数。
     * @see FlexBasis.Percent
     */
    fun 基础(@FloatRange(from = 0.0, to = 1.0) 值: Float) // basis

}


/**
 * FlexBox 容器沿主轴的最大尺寸。对于 [FlexDirection.Row] / [FlexDirection.RowReverse]
 * 对应于 [Constraints.maxWidth]，对于 [FlexDirection.Column] / [FlexDirection.ColumnReverse]
 * 对应于 [Constraints.maxHeight]。可用于基于容器可用空间实现响应式子项尺寸。
 */
@ExperimentalFlexBoxApi
val FlexConfigScope.弹性盒子主轴最大: Int
    get() = this.flexBoxMainAxisMax

/**
 * FlexBox 容器沿主轴的最小尺寸。 对于 [FlexDirection.Row] / [FlexDirection.RowReverse] 对应于
 * [Constraints.minWidth]，对于 [FlexDirection.Column] / [FlexDirection.ColumnReverse]
 * 对应于 [Constraints.minHeight]。
 */
@ExperimentalFlexBoxApi
val FlexConfigScope.弹性盒子主轴最小: Int
    get() = this.flexBoxMainAxisMin

/**
 * FlexBox 容器沿交叉轴的最大尺寸。 对于 [FlexDirection.Row] / [FlexDirection.RowReverse] 对应于
 * [Constraints.maxHeight]，对于 [FlexDirection.Column] / [FlexDirection.ColumnReverse]
 * 对应于 [Constraints.maxWidth]。
 */
@ExperimentalFlexBoxApi
val FlexConfigScope.弹性盒子交叉轴最大: Int
    get() = this.flexBoxCrossAxisMax

/**
 * FlexBox 容器沿交叉轴的最小尺寸。对于 [FlexDirection.Row] / [FlexDirection.RowReverse]
 * 对应于 [Constraints.minHeight]，对于 [FlexDirection.Column] / [FlexDirection.ColumnReverse]
 * 对应于 [Constraints.minWidth]。
 */
@ExperimentalFlexBoxApi
val FlexConfigScope.弹性盒子交叉轴最小: Int
    get() = this.flexBoxCrossAxisMin

/**
 * 为此特定子项覆盖容器的 [FlexBoxConfigScope.alignItems] 设置。
 *
 *  这控制单个子项在其所在行内相对于主轴的垂直定位方式。
 *
 * - **[FlexAlignSelf.Auto]**：继承容器的对齐方式（默认）。
 * - **[FlexAlignSelf.Start]**：对齐到其所在行的 `cross-start`（交叉轴起点）边缘。
 * - **[FlexAlignSelf.End]**：对齐到其所在行的 `cross-end`（交叉轴终点）边缘。
 * - **[FlexAlignSelf.Center]**：在其所在行内沿交叉轴居中对齐。
 * - **[FlexAlignSelf.Stretch]**：拉伸以填满其所在行的交叉轴尺寸。
 * - **[FlexAlignSelf.Baseline]**：在其所在行内按基线对齐。
 *
 * @param 值 此子项的对齐方式。默认值为 [FlexAlignSelf.Auto]。
 * @see FlexAlignSelf
 * @see FlexBoxConfigScope.alignItems
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.对齐自身(值: FlexAlignSelf)
     = this.alignSelf(value = 值)

/**
 * 将此子项与其所在行内的特定基线对齐，覆盖容器的对齐设置。
 *
 * @param 对齐线 要使用的对齐线（例如，[FirstBaseline]（首基线）、[LastBaseline]（末基线））。
 * @see AlignmentLine
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.对齐自身(对齐线: AlignmentLine)
     = this.alignSelf(alignmentLine = 对齐线)

/**
 * 将此子项与其所在行内已测量子项计算出的自定义基线对齐，覆盖容器的对齐设置。
 *
 * @param 对齐线块 一个从 [Measured] 子项计算基线的函数。
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.对齐自身(对齐线块: (Measured) -> Int)
    = this.alignSelf(alignmentLineBlock = 对齐线块)

/**
 * 设置此子项相对于其兄弟项的视觉顺序。
 *
 * 子项在布局前按其顺序值升序排列。较小的值优先放置，从容器的主轴起点边缘开始。注意，在反向方向
 * （如 [FlexDirection.RowReverse]）中，主轴起点边缘在视觉上会被翻转（例如，翻转到容器的右侧）。
 *
 * 排序是稳定的；具有相同顺序值的子项保持它们在组合中发出的确切顺序。默认情况下，所有子项的顺序值为 0。
 * 你可以使用负值将子项移到默认顺序子项之前，或使用正值将其移到其后。
 *
 * @param 值 顺序值。默认值为 0。
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.顺序(值: Int)
    = this.order(value = 值)

/**
 * 设置弹性增长因子，决定此子项相对于其兄弟项应消耗多少剩余的正向空闲空间。
 *
 * 当所有子项基准大小的总和小于容器的主轴尺寸时，剩余空间将按增长因子比例分配给各子项。
 * 增长因子为 `0f`（默认值）的子项不会增长到超过其基准大小。
 *
 * @param 值 增长因子。必须为非负数。默认值为 `0f`。
 * @throws IllegalArgumentException 如果 [值] 为负数。
 * @see FlexConfigScope.shrink
 * @see FlexConfigScope.basis
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.增长(@FloatRange(from = 0.0) 值: Float)
    = this.grow(value = 值)

/**
 * 设置弹性收缩因子，决定当空间不足时，此子项相对于其兄弟项应收缩多少。
 *
 * 当所有子项基准大小的总和超过容器的主轴尺寸时，子项将根据其收缩因子乘以基准大小的结果按比例收缩。收缩因子为 `0f` 的子项不会收缩。
 *
 * **注意：** 子项永远不会收缩到低于其最小固有尺寸。如果所有子项的最小尺寸总和超过容器的尺寸，子项将在主轴方向上视觉上溢出。
 * 如果你需要隐藏溢出的内容，请在容器上应用 [Modifier.clipToBounds][androidx.compose.ui.draw.clipToBounds]。
 *
 * @param 值 收缩因子。必须为非负数。默认值为 `1f`。
 * @throws IllegalArgumentException 如果 [值] 为负数。
 * @see FlexConfigScope.grow
 * @see FlexConfigScope.basis
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.收缩(@FloatRange(from = 0.0) 值: Float)
    = this.shrink(value = 值)

/**
 * 设置此子项在计算任何空闲空间分配（增长或收缩）之前的初始主轴大小。
 *
 * 基准大小决定了在应用 [增长] 和 [收缩] 之前的起始大小：
 *
 * - **[FlexBasis.Auto]**：使用子项显式设置的大小，若未设置则回退到其自然内容大小。
 * - **[FlexBasis.Dp]**：使用以 dp 为单位的固定精确大小。
 * - **[FlexBasis.Percent]**：使用容器主轴大小的一个比例分数。
 *
 * @param 值 基准大小值。默认值为 [FlexBasis.Auto]
 * @see FlexBasis
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.基础(值: FlexBasis)
    = this.basis(value = 值)

/**
 * 将基准大小设置为固定的 Dp 值。这是一个便捷函数，等价于 `basis(FlexBasis.Dp(value))`。
 *
 * @param 值 以 Dp 为单位的基准大小。
 * @see FlexBasis.Dp
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.基础(值: Dp)
    = this.basis(value = 值)

/**
 * 将基准大小设置为容器主轴大小的一个比例分数。这是一个便捷函数，等价于 `basis(FlexBasis.Percent(value))`。
 *
 * @param 值 一个介于 0.0 和 1.0 之间的值，代表容器大小的比例分数。
 * @see FlexBasis.Percent
 */
@ExperimentalFlexBoxApi
fun FlexConfigScope.基础(@FloatRange(from = 0.0, to = 1.0) 值: Float)
     = this.basis(value = 值)


//============================================================================================


/** 将两个 [FlexBoxConfig] 对象合并在一起。位于"右侧"的配置将按属性逐一覆盖其左侧的配置。*/
@ExperimentalFlexBoxApi
fun 弹性盒子配置(第一: FlexBoxConfig, 第二: FlexBoxConfig): FlexBoxConfig =
    FlexBoxConfig(first = 第一, second = 第二)


/** 将三个 [FlexBoxConfig] 对象合并在一起。位于"右侧"的配置将按属性逐一覆盖其左侧的配置。*/
@ExperimentalFlexBoxApi
fun 弹性盒子配置(第一: FlexBoxConfig, 第二: FlexBoxConfig, 第三: FlexBoxConfig): FlexBoxConfig =
    FlexBoxConfig(first = 第一, second = 第二, third = 第三)


/** 将多个 [FlexBoxConfig] 对象合并在一起。位于"右侧"的配置将按属性逐一覆盖其左侧的配置。*/
@ExperimentalFlexBoxApi
fun 弹性盒子配置(vararg 配置集: FlexBoxConfig): FlexBoxConfig =
    FlexBoxConfig(configs = 配置集)


//============================================================================================


/** 将两个 [FlexConfig] 对象合并在一起。位于"右侧"的配置将按属性逐一覆盖其左侧的配置。*/
@ExperimentalFlexBoxApi
fun 弹性配置(第一: FlexConfig, 第二: FlexConfig): FlexConfig =
    FlexConfig(first = 第一, second = 第二)


/** 将三个 [FlexConfig] 对象合并在一起。位于"右侧"的配置将按属性逐一覆盖其左侧的配置。*/
@ExperimentalFlexBoxApi
fun 弹性配置(第一: FlexConfig, 第二: FlexConfig, 第三: FlexConfig): FlexConfig =
    FlexConfig(first = 第一, second = 第二, third = 第三)


/** 将多个 [FlexConfig] 对象合并在一起。位于"右侧"的配置将按属性逐一覆盖其左侧的配置。*/
@ExperimentalFlexBoxApi
fun 弹性配置(vararg 配置集: FlexConfig): FlexConfig =
    FlexConfig(configs = 配置集)

//============================================================================================


