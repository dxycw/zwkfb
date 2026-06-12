package 安卓x.组合.界面

import androidx.compose.ui.Modifier

/**
 * 伴生对象 修饰符 是一个空的、默认的或起始的 [修饰符]，不包含任何 [元素][Element]。使用它来通过修饰符扩展工厂函数创建新的 [修饰符]：
 */
// 伴生对象实现了 `修饰符` 接口，以便可以作为修饰符扩展工厂表达式的起点来使用。
object 修饰符 : Modifier{

    override fun <R> foldIn(initial: R, operation: (R, Modifier.Element) -> R): R = initial

    override fun <R> foldOut(initial: R, operation: (Modifier.Element, R) -> R): R = initial

    override fun any(predicate: (Modifier.Element) -> Boolean): Boolean = false

    override fun all(predicate: (Modifier.Element) -> Boolean): Boolean = true

    override infix fun then(other: Modifier): Modifier = other

    override fun toString() = "修饰符"

}


/**
 * [修饰符] 链中的一个节点。组合修饰符 总是至少包含两个元素：一个包裹在外层的 Modifier [外部]，以及一个被包裹在内的 Modifier [内部]。
 */
class 组合修饰符(internal val 外部: Modifier, internal val 内部: Modifier) : Modifier {
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
        "[" +
            foldIn("") { acc, element ->
                if (acc.isEmpty()) element.toString() else "$acc, $element"
            } +
        "]"

}
