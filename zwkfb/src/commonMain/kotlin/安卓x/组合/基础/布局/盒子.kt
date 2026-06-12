package 安卓x.组合.基础.布局

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * 一个带有 [内容] 的布局可组合函数。[盒子] 会根据传入的约束条件调整自身大小以适应内容。当子元素比父容器小时，
 * 默认情况下它们会根据 [内容对齐] 定位在 [盒子] 内部。若要为各个子布局单独指定对齐方式，请使用 [BoxScope.align] 修饰符。
 * 默认情况下，在测量内容时不会应用 [盒子] 传入的最小约束条件，除非 [传播最小约束] 设置为 `true`。例如，当 [盒子]
 * 的内容无法直接添加修饰符，而需要对 [盒子] 的内容设置最小尺寸时，将 [传播最小约束] 设置为 `true` 会很有用。
 * 如果 [传播最小约束] 设置为 `true`，在 [盒子] 上设置的最小尺寸也会应用于内容；否则，最小尺寸仅适用于 [盒子] 本身。
 * 当内容包含多个布局子元素时，这些子元素会按照组合顺序相互堆叠（按上述方式定位）。
 *
 * @param 修饰符 要应用于布局的修饰符。
 * @param 内容对齐 [盒子] 内部的默认对齐方式。
 * @param 传播最小约束 是否将传入的最小约束条件传递给内容。
 * @param 内容 [盒子] 的内容。
 */
@Suppress("ComposableNaming")
@Composable
inline fun 盒子(
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    传播最小约束: Boolean = false,
    内容: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        propagateMinConstraints = 传播最小约束,
        content = 内容,
    )
}


/**
 * 一个没有内容的盒子，可以通过应用于它的 [修饰符] 来参与布局、绘制和指针输入。
 *
 * @param 修饰符 要应用于布局的修饰符。
 */
@Suppress("ComposableNaming")
@Composable
fun 盒子(修饰符: Modifier) {
    Box(modifier = 修饰符)
}


/** 盒子范围 为 [盒子] 和 [BoxWithConstraints] 的子元素提供一个作用域。*/
@LayoutScopeMarker
@Immutable
interface 盒子范围 { // BoxScope

    /** 将内容元素对齐到 [盒子] 内的特定 [Alignment]。此对齐方式的优先级高于 [盒子] 的 `对齐` 参数。*/
    @Stable
    fun Modifier.对齐(对齐: Alignment): Modifier

    /**
     * 在所有其他内容元素测量完成后，将该元素的尺寸调整为与 [盒子] 的尺寸相匹配。
     *
     * 使用此修饰符的元素不会参与定义 [盒子] 的尺寸。相反，它会在所有其他子元素（未使用 匹配父大小() 修饰符）测量完成后，
     * 匹配 [盒子] 的最终尺寸。相比之下，通用的 [Modifier.fillMaxSize] 修饰符会让元素占据所有可用空间，并且会参与定义 [盒子]
     * 的尺寸。因此，在 [盒子] 内部的元素上使用 [Modifier.fillMaxSize] 会导致 [盒子] 本身始终填满可用空间。
     */
    @Stable
    fun Modifier.匹配父大小(): Modifier

}

