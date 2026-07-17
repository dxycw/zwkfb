@file:Suppress("NOTHING_TO_INLINE", "KotlinRedundantDiagnosticSuppress")

package 安卓x.组合.界面.单位

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.constrain
import androidx.compose.ui.unit.constrainHeight
import androidx.compose.ui.unit.constrainWidth
import androidx.compose.ui.unit.isSatisfiedBy
import androidx.compose.ui.unit.offset


/**
 * 用于测量布局的不可变约束，由[布局][androidx.compose.ui.layout.Layout]或
 * [布局修饰符][androidx.compose.ui.layout.LayoutModifier]使用，以测量其子布局。父布局选择定义一个范围
 * （以像素为单位）的[Constraints]，被测量的布局应在此范围内选择尺寸：
 * - `minWidth` <= `chosenWidth` <= `maxWidth`
 * - `minHeight` <= `chosenHeight` <= `maxHeight`
 *
 * 如需了解有关布局测量工作原理的更多详细信息，请参阅 [androidx.compose.ui.layout.MeasurePolicy] 或
 * [androidx.compose.ui.layout.LayoutModifier.measure]。
 *
 * 一组 [Constraints] 可以拥有无限的 maxWidth 和/或 maxHeight。这是父布局经常用来询问子布局其首选尺寸的一种技巧：
 * 无界约束会强制那些默认行为是填充可用空间（始终按 maxWidth/maxHeight 确定尺寸）的子布局表达其首选尺寸。最常见的情况是，
 * 当使用无界 [Constraints] 进行测量时，这些子布局会回退到按内容包裹自身尺寸，而不是扩展以填充可用空间（这并非总是如此，
 * 因为取决于子布局模型，但对于核心布局组件而言是一种常见行为）。
 *
 * [Constraints] 使用一个 [Long] 来表示四个值：[最小宽度]、[最小高度]、[最大宽度] 和 [最大高度]。
 * 这些值的范围经过调整，以允许单个维度最大为 256K。共有四种可能的最大范围，即 13 位/18 位和 15 位/16 位，
 * 分别用于宽度或高度，具体取决于需求。例如，宽度最大可达 18 位，高度最大可达 13 位；或者宽度最大可达 16 位，
 * 高度最大可达 15 位。高度和宽度的要求可以互换，即高度最大可达 18 位、宽度最大可达 13 位，或高度最大可达 16 位、
 * 宽度最大可达 15 位。任何超出此范围的约束都将失败。
 */
object 约束{

    /**
     * 当约束应被视为无限时，[最大宽度] 或 [最大高度] 将被设置为此值。当 [最大宽度] 或 [最大高度] 为
     * [Infinity] 时，[有边界宽度] 或 [有边界高度] 将分别为 `false`。
     */
    const val 无限 = Constraints.Infinity

    /** 创建两个维度均为固定尺寸的约束。 */
    @Stable
    fun 固定(宽度: Int, 高度: Int): Constraints = Constraints.fixed(width = 宽度, height = 高度)

    /** 创建固定宽度、高度未指定的约束。 */
    @Stable
    fun 固定宽度(宽度: Int): Constraints = Constraints.fixedWidth(width = 宽度)

    /** 创建固定高度、宽度未指定的约束。*/
    @Stable
    fun 固定高度(高度: Int): Constraints = Constraints.fixedHeight(height = 高度)

    // 这应该在下一个版本发布前移除。
    @Deprecated(
        "Replace with fitPrioritizingWidth",
        replaceWith =
            ReplaceWith(
                "Constraints.fitPrioritizingWidth(minWidth, maxWidth, minHeight, maxHeight)"
            ),
    )
    @Stable
    fun 限制约束(
        最小宽度: Int,
        最大宽度: Int,
        最小高度: Int,
        最大高度: Int,
        优先宽度: Boolean = true,
    ): Constraints =
        Constraints.restrictConstraints(
            minWidth = 最小宽度,
            maxWidth = 最大宽度,
            minHeight = 最小高度,
            maxHeight = 最大高度,
            prioritizeWidth = 优先宽度,
        )

    /**
     * 返回尽可能接近传入值的 [Constraints]。如果尺寸超出了可表示的范围，约束将被限制在可表示的范围内。
     *
     * [Constraints] 是一个基于 [Long] 的 `value class`，4 个整数必须限制在其大小范围内。较大的维度最多有 18 位
     * （262,143），较小的维度最少有 13 位（8,191）。宽度会获得所需的空间，或将大小上限限制为 18 位。高度则获得剩余的空间。
     *
     * 这在布局约束可能非常大，但并非所有内容都能在设备上显示时非常有用。例如，一个文本布局中整本书的章节都在一个 Layout
     * 中测量，而无法将内容拆分显示在 `LazyColumn` 中。
     */
    @Stable
    fun 优先适配宽度(
        最小宽度: Int,
        最大宽度: Int,
        最小高度: Int,
        最大高度: Int,
    ): Constraints =
        Constraints.fitPrioritizingWidth(
            minWidth = 最小宽度,
            maxWidth = 最大宽度,
            minHeight = 最小高度,
            maxHeight = 最大高度,
        )

    /**
     * 返回与传入值尽可能匹配的 [Constraints]。如果尺寸超出了可表示的范围，则约束会被限制在可表示的范围内。
     *
     * [Constraints] 是一个基于 [Long] 的 value class，4 个整数必须被限制以适配其大小。较大的维度最多有 18 位
     * （262,143），较小的维度最少有 13 位（8,191）。高度会获得其所需的尽可能多的空间，或将大小上限限制为 18 位。
     * 宽度则使用剩余的空间。
     *
     * 这在布局约束可能极大，但并非所有内容都能在设备上显示时非常有用。例如，一个文本布局中，整本书的一个章节都在一个 Layout
     * 中进行测量，且无法将内容拆分以在 LazyColumn 中显示。
     */
    @Stable
    fun 优先适配高度(
        最小宽度: Int,
        最大宽度: Int,
        最小高度: Int,
        最大高度: Int,
    ): Constraints =
        Constraints.fitPrioritizingHeight(
            minWidth = 最小宽度,
            maxWidth = 最大宽度,
            minHeight = 最小高度,
            maxHeight = 最大高度,
        )

}


//=================================================================================

/** 测量可采用的最小宽度，以像素为单位。 */
val Constraints.最小宽度: Int
    get() = this.minWidth


/** 测量可采用的最大宽度，以像素为单位。该值将是一个大于或等于 [最小宽度] 的正数，或 [Constraints.Infinity]。*/
val Constraints.最大宽度: Int
    get() = this.maxWidth


/** 测量可采用的最小高度，以像素为单位。 */
val Constraints.最小高度: Int
    get() = this.minHeight


/** 测量可采用的最大高度，以像素为单位。该值将是一个大于或等于 [最小高度] 的正数，或 [Constraints.Infinity]。*/
val Constraints.最大高度: Int
    get() = this.maxHeight


/**
 * 当 [最大宽度] 为 [Infinity] 时返回 `false`，当 [最大宽度] 为非 [Infinity] 值时返回 `true`。
 *
 * @see 有边界高度
 */
val Constraints.有边界宽度: Boolean
    get() = this.hasBoundedWidth


/**
 * 当 [最大高度] 为 [Infinity] 时返回 `false`，当 [最大高度] 为非 [Infinity] 值时返回 `true`。
 *
 * @see 有边界宽度
 */
val Constraints.有边界高度: Boolean
    get() = this.hasBoundedHeight


/** 是否存在唯一一个满足约束条件的宽度值。 */
@Stable
val Constraints.有固定宽度: Boolean
    get() = this.hasFixedWidth

/** 是否存在唯一一个满足约束条件的高度值。 */
@Stable
val Constraints.有固定高度: Boolean
    get() = this.hasFixedHeight


/** 满足这些约束条件的组件面积是否必定为 0。当 最大宽度 和 最大高度 中至少有一个为 0 时，此值为 true。*/
@Stable
val Constraints.是否零: Boolean
    get() = this.isZero

/**
 * 复制现有的 [Constraints]，根据需要替换 [最小宽度]、[最小高度]、[最大宽度] 或 [最大高度] 中的某些值。
 * [最小宽度] 和 [最小高度] 必须为正数；[最大宽度] 和 [最大高度] 必须分别大于或等于 [最小宽度] 和
 * [最小高度]，或为 [Infinity]。"
 */
fun Constraints.复制(
    最小宽度: Int = this.minWidth,
    最大宽度: Int = this.maxWidth,
    最小高度: Int = this.minHeight,
    最大高度: Int = this.maxHeight,
): Constraints =
    this.copy(minWidth = 最小宽度, maxWidth = 最大宽度, minHeight = 最小高度, maxHeight = 最大高度)


/** 复制现有的 [Constraints]，将 [最小宽度] 和 [最小高度] 设为 0，同时保持 [最大宽度] 和 [最大高度] 不变。*/
inline fun Constraints.复制最大尺寸() = this.copyMaxDimensions()

//=================================================================================

// 重新定义 Constraints.Infinity 以绕过 Companion Object
private const val Infinity = Int.MAX_VALUE


/**
 * 创建 [Constraints]。[最小宽度] 和 [最小高度] 必须为正数，且 [最大宽度] 和 [最大高度] 必须分别大于或等于
 * [最小宽度] 和 [最小高度]，或者为 [Infinity][Constraints.Infinity]。
 */
@Stable
fun 约束(
    最小宽度: Int = 0,
    最大宽度: Int = Infinity,
    最小高度: Int = 0,
    最大高度: Int = Infinity,
): Constraints =
    Constraints(
        minWidth = 最小宽度,
        maxWidth = 最大宽度,
        minHeight = 最小高度,
        maxHeight = 最大高度
    )


/**
 * 取 [其他约束] 并返回在当前约束下对其进行强制约束后的结果。请注意，这意味着任何满足结果约束的尺寸都将满足当前约束，
 * 但当两组约束互不相交时，它们可能不满足 [其他约束]。示例如下（仅展示宽度，高度同理）：
 * (minWidth=2, maxWidth=10).constrain(minWidth=7, maxWidth=12) → (minWidth=7, maxWidth=10)
 * (minWidth=2, maxWidth=10).constrain(minWidth=11, maxWidth=12) → (minWidth=10, maxWidth=10)
 * (minWidth=2, maxWidth=10).constrain(minWidth=5, maxWidth=7) → (minWidth=5, maxWidth=7)
 */
fun Constraints.约束(其他约束: Constraints): Constraints =
    this.constrain(otherConstraints = 其他约束)


/** 取一个尺寸，并返回满足约束条件的最接近该尺寸的尺寸。 */
@Stable
fun Constraints.约束(大小: IntSize) = this.constrain(size = 大小)


/** 取一个宽度，并返回满足约束条件的最接近该宽度的尺寸。 */
@Stable
fun Constraints.约束宽度(宽度: Int) = this.constrainWidth(width = 宽度)


/** 取一个高度，并返回满足约束条件的最接近该高度的尺寸。 */
@Stable
fun Constraints.约束高度(高度: Int) = this.constrainHeight(height = 高度)


/** 取一个尺寸，并返回它是否满足当前约束。 */
@Stable
fun Constraints.是否满足(大小: IntSize): Boolean = this.isSatisfiedBy(size = 大小)


/** 返回通过给定值对当前实例进行偏移后得到的约束条件。 */
@Stable
fun Constraints.偏移量(水平: Int = 0, 垂直: Int = 0) = this.offset(horizontal = 水平, vertical = 垂直)

