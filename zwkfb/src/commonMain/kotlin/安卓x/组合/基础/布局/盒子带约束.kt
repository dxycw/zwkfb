package 安卓x.组合.基础.布局

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

/**
 * 一个可根据可用空间（基于传入的约束条件或当前的 [LayoutDirection]）自定义其内容的可组合项。
 *
 * 该可组合项会组合给定的子元素，并将产生的布局元素放置在一个行为类似于 [盒子] 的父布局中。布局将根据传入的约束条件自适应内容尺寸。
 * 当子元素小于父布局时，默认情况下会根据 [内容对齐] 在布局内部定位。如需单独指定各子元素布局的对齐方式，
 * 请使用 [BoxScope.align] 修饰符。默认情况下，内容测量时不会携带 [盒子] 传入的最小约束，除非 [传播最小约束] 设为 `true`。
 * 例如，当 [盒子带约束] 包含无法直接对其应用修饰符的内容，且需要为其内容设置最小尺寸时，将 [传播最小约束]
 * 设为 `true` 会很有用。若 [传播最小约束] 设为 `true`，则设置在 [盒子带约束] 上的最小尺寸也会应用于其内容；否则，
 * 最小尺寸仅作用于 [盒子带约束] 自身。当内容包含多个布局子元素时，这些子元素将按照组合顺序**层层堆叠**（按上述方式定位）。
 *
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 内容对齐 [盒子带约束] 内部默认的对齐方式。
 * @param 传播最小约束 传入的最小约束是否应传递给内容。
 * @param 内容 [盒子带约束] 的内容。
 */
@Suppress("ComposableNaming")
@Composable
@UiComposable
fun 盒子带约束(
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    传播最小约束: Boolean = false,
    内容: @Composable @UiComposable BoxWithConstraintsScope.() -> Unit,
) =
    BoxWithConstraints(
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        propagateMinConstraints = 传播最小约束,
        content = 内容,
    )


/** [BoxWithConstraints] 的 children 参数所使用的接收者范围。 */
@Stable
interface 盒子带约束范围 : BoxScope { // BoxWithConstraintsScope

    /**
     * 父布局以像素为单位给出的约束条件。
     *
     * 如果你需要以 [Dp] 为单位的值，请使用 [最小宽度]、[最大宽度]、[最小高度] 或 [最大高度]。
     */
    val 约束: Constraints // constraints

    /**
     * [Dp] 单位下的最小宽度。
     *
     * @see 约束 以像素为单位的值。
     */
    val 最小宽度: Dp // minWidth

    /**
     * [Dp] 单位下的最大宽度。
     *
     * @see 约束 以像素为单位的值。
     */
    val 最大宽度: Dp // maxWidth

    /**
     * [Dp] 单位下的最小高度。
     *
     * @see 约束 以像素为单位的值。
     */
    val 最小高度: Dp // minHeight

    /**
     * [Dp] 单位下的最大高度。
     *
     * @see 约束 以像素为单位的值。
     */
    val 最大高度: Dp // maxHeight

}

//==============================================================================================

/**
 * 父布局以像素为单位给出的约束条件。
 *
 * 如果你需要以 [Dp] 为单位的值，请使用 [最小宽度]、[最大宽度]、[最小高度] 或 [最大高度]。
 */
val BoxWithConstraintsScope.约束: Constraints
    get() = this.constraints

/**
 * [Dp] 单位下的最小宽度。
 *
 * @see 约束 以像素为单位的值。
 */
val BoxWithConstraintsScope.最小宽度: Dp
    get() = this.minWidth

/**
 * [Dp] 单位下的最大宽度。
 *
 * @see 约束 以像素为单位的值。
 */
val BoxWithConstraintsScope.最大宽度: Dp
    get() = this.maxWidth

/**
 * [Dp] 单位下的最小高度。
 *
 * @see 约束 以像素为单位的值。
 */
val BoxWithConstraintsScope.最小高度: Dp
    get() = this.minHeight

/**
 * [Dp] 单位下的最大高度。
 *
 * @see 约束 以像素为单位的值。
 */
val BoxWithConstraintsScope.最大高度: Dp
    get() = this.maxHeight

//==============================================================================================

