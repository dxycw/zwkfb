package 科特林


/**
 * 抛出异常以表明方法体尚未实现。
 */
public open class 未实现错误(信息: String = "操作未实现。") : Error(信息)

/**
 * 始终抛出 [未实现错误]，表明该操作尚未实现。
 */
@科特林.内部.InlineOnly
public inline fun 待办(): Nothing = throw 未实现错误()

/**
 * 始终抛出 [未实现错误]，表明该操作尚未实现。
 *
 * @param 原因 一个字符串，用于解释为何缺少实现。
 */
@科特林.内部.InlineOnly
public inline fun 待办(原因: String): Nothing = throw 未实现错误(信息 = "操作未实现: $原因")



/**
 * 调用指定的函数 [块] 并返回其结果。
 *
 * 有关详细用法信息，请参阅 [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#run) 的文档。
 */
@科特林.内部.InlineOnly
@IgnorableReturnValue
public inline fun <R> 跑(块: () -> R): R = run(block = 块)


/**
 * 以 `this` 值作为接收者调用指定的函数 [块]，并返回其结果。
 *
 * 有关详细用法信息，请参阅 [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#run) 的文档。
 */
@科特林.内部.InlineOnly
@IgnorableReturnValue
public inline fun <T, R> T.跑(块: T.() -> R): R = run(block = 块)


/**
 * 以给定的 [接收器] 作为接收者调用指定的函数 [块]，并返回其结果。
 *
 * 有关详细用法，请参阅 [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#with) 文档。
 */
@科特林.内部.InlineOnly
@IgnorableReturnValue
public inline fun <T, R> 和(接收器: T, 块: T.() -> R): R =
    with(receiver = 接收器, block = 块)



/**
 * 以 `this` 值作为接收者调用指定的函数 [块]，并返回 `this` 值。
 *
 * 有关详细用法，请参阅 [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#apply) 文档。
 */
@科特林.内部.InlineOnly
@IgnorableReturnValue
inline fun <T> T.申请(块: T.() -> Unit): T = apply(block = 块)


/**
 * 以 `this` 值作为参数调用指定的函数 [块]，并返回 `this` 值。
 *
 * 有关详细用法，请参阅 [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#also) 文档。
 */
@科特林.内部.InlineOnly
@SinceKotlin("1.1")
@IgnorableReturnValue
public inline fun <T> T.也(块: (T) -> Unit): T = also(block = 块)

/**
 * 以 `this` 值作为参数调用指定的函数 [块]，并返回其结果。
 *
 * 有关详细用法，请参阅 [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#let) 文档。
 */
@科特林.内部.InlineOnly
@IgnorableReturnValue
public inline fun <T, R> T.让(块: (T) -> R): R = let(block = 块)


/**
 * 如果 `this` 值满足给定的 [条件]，则返回 `this` 值；如果不满足，则返回 `null`。
 *
 * 有关详细用法，请参阅 [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#takeif-and-takeunless) 文档。
 */
@科特林.内部.InlineOnly
@SinceKotlin("1.1")
public inline fun <T> T.如果(条件: (T) -> Boolean): T?  =
    takeIf(predicate = 条件)

/**
 * 如果 `this` 值不满足给定的 [条件]，则返回 `this` 值；如果满足，则返回 `null`。
 *
 * 有关详细用法，请参阅 [scope functions](https://kotlinlang.org/docs/reference/scope-functions.html#takeif-and-takeunless) 文档。
 */
@科特林.内部.InlineOnly
@SinceKotlin("1.1")
public inline fun <T> T.除非(条件: (T) -> Boolean): T? =
    takeUnless(predicate = 条件)

/**
 * 执行给定的函数 [行动] 指定的 [次数] 次。
 *
 * 当前迭代的从0开始的索引会作为参数传递给 [行动] 函数。
 *
 * 如果 [次数] 参数为负数或等于零，则不会调用 [行动] 函数。
 */
@科特林.内部.InlineOnly
public inline fun 重复(次数: Int, 行动: (Int) -> Unit) =
    repeat(times = 次数, action = 行动)
