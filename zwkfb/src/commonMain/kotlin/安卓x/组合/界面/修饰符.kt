package 安卓x.组合.界面

import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.Modifier

/**
 * 伴生对象 `修饰符` 是不包含任何[元素][Element]的空、默认或起始[修饰符]。
 * 使用它来通过修饰符扩展工厂函数创建新的[修饰符]：
 *
 * @sample androidx.compose.ui.samples.ModifierUsageSample
 *
 * 或作为[修饰符]参数的默认值：
 *
 * @sample androidx.compose.ui.samples.ModifierParameterSample
 */
// 伴生对象实现 `修饰符`，以便它可以作为修饰符扩展工厂表达式的起点。
object 修饰符 : Modifier {
    override fun <R> foldIn(initial: R, operation: (R, Modifier.Element) -> R): R = initial

    override fun <R> foldOut(initial: R, operation: (Modifier.Element, R) -> R): R = initial

    override fun any(predicate: (Modifier.Element) -> Boolean): Boolean = false

    override fun all(predicate: (Modifier.Element) -> Boolean): Boolean = true

    override infix fun then(other: Modifier): Modifier = other

    override fun toString() = "修饰符"
}

/**
 * [修饰符]链中的一个节点。CombinedModifier 始终包含至少两个元素；
 * 一个包裹[内部]修饰符的[外部]修饰符。
 */
class 组合修饰符(internal val 外部: Modifier, internal val 内部: Modifier) : Modifier {
    init {
        CombinedModifier(outer = 外部, inner = 内部)
    }
    override fun <R> foldIn(initial: R, operation: (R, Modifier.Element) -> R): R =
        内部.foldIn(外部.foldIn(initial, operation), operation)

    override fun <R> foldOut(initial: R, operation: (Modifier.Element, R) -> R): R =
        外部.foldOut(内部.foldOut(initial, operation), operation)

    override fun any(predicate: (Modifier.Element) -> Boolean): Boolean =
        外部.any(predicate) || 内部.any(predicate)

    override fun all(predicate: (Modifier.Element) -> Boolean): Boolean =
        外部.all(predicate) && 内部.all(predicate)

    override fun equals(other: Any?): Boolean =
        other is 组合修饰符 && 外部 == other.外部 && 内部 == other.内部

    override fun hashCode(): Int = 外部.hashCode() + 31 * 内部.hashCode()

    override fun toString() =
        foldIn(
            StringBuilder("["),
            { acc, element ->
                if (acc.length > 1) acc.append(", ")
                acc.append(element)
            },
        )
            .append("]")
            .toString()
}