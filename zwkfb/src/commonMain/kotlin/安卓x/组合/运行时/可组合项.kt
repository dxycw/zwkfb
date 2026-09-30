package 安卓x.组合.运行时

import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.Composer
import androidx.compose.runtime.CompositeKeyHashCode
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.ExplicitGroupsComposable
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.RecomposeScope
import androidx.compose.runtime.ReusableComposeNode
import androidx.compose.runtime.ReusableContent
import androidx.compose.runtime.ReusableContentHost
import androidx.compose.runtime.SkippableUpdater
import androidx.compose.runtime.TestOnly
import androidx.compose.runtime.Updater
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.currentCompositeKeyHashCode
import androidx.compose.runtime.currentCompositionContext
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext


/** 记住 [计算] 产生的值。[计算] 仅在组合期间进行求值。重组时始终返回组合期间产生的值。*/
@Composable
public inline fun <T> 记住(crossinline 计算: @DisallowComposableCalls () -> T) =
    remember(calculation = 计算)

/** 如果 [键1] 与上一组合中的值相等（`==`），则记住 [计算] 返回的值，否则通过调用 [计算] 生成并记住一个新值。*/
@Composable
public inline fun <T> 记住(
    键1: Any?,
    crossinline 计算: @DisallowComposableCalls () -> T,
): T = remember(key1 = 键1, calculation = 计算)


/** 如果 [键1] 和 [键2] 与上一组合中的值相等（`==`），则记住 [计算] 返回的值，否则通过调用 [计算] 生成并记住一个新值。*/
@Composable
public inline fun <T> 记住(
    键1: Any?,
    键2: Any?,
    crossinline 计算: @DisallowComposableCalls () -> T,
): T = remember(key1 = 键1, key2 = 键2, calculation = 计算)

/** 如果 [键1]、[键2] 和 [键3] 与上一组合中的值相等（`==`），则记住 [计算] 返回的值，否则通过调用 [计算] 生成并记住一个新值。*/
@Composable
public inline fun <T> 记住(
    键1: Any?,
    键2: Any?,
    键3: Any?,
    crossinline 计算: @DisallowComposableCalls () -> T,
): T = remember(key1 = 键1, key2 = 键2, key3 = 键3, calculation = 计算)

/** 如果 [键集] 中的所有值与上一组合中的值相等（`==`），则记住 [计算] 返回的值，否则通过调用 [计算] 生成并记住一个新值。*/
@Composable
public inline fun <T> 记住(
    vararg 键集: Any?,
    crossinline 计算: @DisallowComposableCalls () -> T,
): T = remember(keys = 键集, calculation = 计算)

/**
 * [键] 是一个实用型可组合项，用于在组合中对执行块进行"分组"或"键控"。这在控制流中有时是必要的，因为控制流可能导致某个
 * 可组合项调用在组合期间执行多次。
 *
 * 键的值不需要全局唯一，只需在组合中该位置的 [键] 调用之间保持唯一即可。
 *
 * @param 键集 用于创建复合键的值集合。这些值将使用 [equals] 和 [hashCode] 与之前的值进行比较。
 * @param 块 此组的可组合子项。
 */
@Composable
public inline fun <T> 键(
    @Suppress("UNUSED_PARAMETER") vararg 键集: Any?,
    块: @Composable () -> T,
): T = 块()

/**
 * 一个用于标记组合支持回收的实用函数。如果 [键] 发生变化，组合将被新组合替换（与 [键] 的行为相同），但由
 * [ReusableComposeNode] 发出的可复用节点将被复用。
 *
 * @param 键 用于触发回收的值。如果重组时传入不同的值，组合器会创建一个新的组合，但会尝试复用可复用节点。
 * @param 内容 可复用的可组合子项。
 */
@Suppress("ComposableNaming")
@Composable
public inline fun 可复用内容(键: Any?, 内容: @Composable () -> Unit) =
    ReusableContent(key = 键, content = 内容)

/**
 * 一个可选的实用函数，用于承载 [ReusableContent]。如果 [激活] 为 `false`，内容将被视为已删除，从组合中移除所有
 * 记住的对象，但为树生成的节点不会被移除。当组合稍后变为活跃状态时，这些节点可以在 [ReusableContent] 内容中被复用，
 * 而无需任意延长组合生命周期内的记住状态。
 *
 * @param 激活 当 [激活] 为 `true` 时，[内容] 正常组合。当 [激活] 为 `false` 时，内容将被停用，所有记住的状态将被视
 * 为内容已删除，但由组合的 [Applier] 管理的节点不受影响。当 [激活] 再次变为 `true` 时之前活跃组合中的任何可复用节点都可被复用。
 * @param 内容 由此可组合项管理的可组合内容。
 */
@Suppress("ComposableNaming")
@Composable
@ExplicitGroupsComposable
public inline fun 可复用内容主机(
    激活: Boolean,
    crossinline 内容: @Composable () -> Unit,
) = ReusableContentHost(active = 激活, content = 内容)

/**
 * Compose 内部函数。请勿直接调用。
 *
 * 返回当前用于执行组合的 [Composer] 实例。返回的 Composer 特定于读取此属性的位置。不保证在组合的其他位置会返回相同的
 * Composer 对象，也不保证在重组之间 Composer 实例相同。
 *
 * 此属性公开供运行时、编译器和工具使用。不建议公开使用。不支持在 Compose 编译器生成的调用之外修改组合器的状态。
 */
public val 当前组合器: Composer
    @ReadOnlyComposable
    @Composable
    get() = currentComposer

/**
 * 返回与当前组合器关联的 [CompositionContext]。
 *
 * 此 API 仅公开用于内部用途。不应在 Compose 运行时之外调用。
 */
@InternalComposeApi
public val 当前组合上下文: CompositionContext
    @ReadOnlyComposable
    @Composable
    get() = currentCompositionContext

/** 返回一个可用于在组合中的此位置使当前作用域失效的对象。此对象可用于手动触发重组。*/
public val 当前重组范围: RecomposeScope
    @ReadOnlyComposable
    @OptIn(InternalComposeApi::class)
    @Composable
    get() = currentRecomposeScope

/**
 * 返回当前的 [CompositionLocalContext]，其中包含当前组合中的所有 [CompositionLocal] 以及由 [CompositionLocalProvider]
 * 提供的值。此上下文可用于通过 [CompositionLocalProvider] 将局部值传递到另一个组合。如果另一个组合不是当前组合的子组合，
 * 则通常需要这样做。
 */
@OptIn(InternalComposeApi::class)
public val 当前组合局部上下文: CompositionLocalContext
    @Composable
    get() = currentCompositionLocalContext

/**
 * 这是一个哈希值，用于将外部存储的状态与组合进行协调。例如，saved instance state 使用它来在 Activity 生命周期边界之间保留状态。
 *
 * 该值可能是唯一的，但不能保证唯一。在某些已知情况下，例如没有 [key] 的 for 循环，运行时没有足够的信息来使复合键哈希值唯一。
 *
 * @see currentCompositeKeyHashCode
 */
@Deprecated(
    "Prefer the higher-precision currentCompositeKeyHashCode",
    ReplaceWith("currentCompositeKeyHashCode"),
)
@Suppress("DEPRECATION")
public val 当前复合键哈希: Int
    @Composable
    @ExplicitGroupsComposable
    @OptIn(InternalComposeApi::class)
    get() = currentCompositeKeyHash

/**
 * [currentCompositeKeyHash] 的高精度变体，用于将外部存储的状态映射到组合中。通过升级为 Long 类型，此键哈希变体发生
 * 碰撞的可能性呈指数级降低。
 *
 * 实际上，由于哈希分布并非完美，且在某些情况下运行时无法唯一标识某些重复内容，碰撞仍然可能发生。然而，这种更高的精度使我们更有
 * 信心认为，任意规模的组合层次结构中不会出现两个不相关的组具有相同键哈希的情况。
 */
public val 当前复合键哈希码: CompositeKeyHashCode
    @Composable
    @ExplicitGroupsComposable
    @OptIn(InternalComposeApi::class)
    get() = currentCompositeKeyHashCode

/**
 * 在组合中发出一个类型为 [T] 的节点。
 *
 * 如果 [E] 不是 [currentComposer] 的 applier 的子类型，此函数将抛出运行时异常。
 *
 * @param 工厂 一个将创建 [T] 新实例的函数。不保证该函数会被原地调用（即不保证该函数会在调用处直接执行）。
 * @param 更新 一个用于对节点执行更新的函数。每次执行 emit 时都会运行该函数。此函数为原地调用，且将被内联。
 * @see Updater
 * @see Applier
 * @see Composition
 */
// ComposeNode 是一种只读组合函数（readonly composable）的特殊情况，它会自行处理其分组的创建，因此可以放心使用。
@Suppress("NONREADONLY_CALL_IN_READONLY_COMPOSABLE", "UnnecessaryLambdaCreation",
    "ComposableNaming"
)
@Composable
public inline fun <T : Any, reified E : Applier<*>> 组合节点(
    noinline 工厂: () -> T,
    更新: @DisallowComposableCalls Updater<T>.() -> Unit,
) = ComposeNode<T, E>(factory = 工厂, update = 更新)

/**
 * 将一个可回收的 [T] 类型节点发射到组合中。
 *
 * 如果 [E] 不是 [currentComposer] 的 applier 的子类型，则此函数将抛出运行时异常。
 *
 * @param 工厂 一个将创建 [T] 新实例的函数。不保证该函数会被原地调用（即不保证该函数会在调用处直接执行）。
 * @param 更新 一个用于对节点执行更新的函数。每次执行 emit 时都会运行该函数。此函数为原地调用，且将被内联。
 * @see Updater
 * @see Applier
 * @see Composition
 */
// ComposeNode 是一种只读组合函数（readonly composable）的特殊情况，它会自行处理其分组的创建，因此可以放心使用。
@Suppress("NONREADONLY_CALL_IN_READONLY_COMPOSABLE", "UnnecessaryLambdaCreation",
    "ComposableNaming"
)
@Composable
public inline fun <T : Any, reified E : Applier<*>> 可复用组合节点(
    noinline 工厂: () -> T,
    更新: @DisallowComposableCalls Updater<T>.() -> Unit,
) = ReusableComposeNode<T, E>(factory = 工厂, update = 更新)

/**
 * 将一个 [T] 类型的节点发射到组合中。在 [内容] 内部发射的节点将成为该发射节点的子节点。
 *
 * 如果 [E] 不是 [currentComposer] 的 applier 的子类型，则此函数将抛出运行时异常。
 *
 * @param 工厂 一个将创建 [T] 新实例的函数。不保证该函数会被原地调用。
 * @param 更新 一个用于对节点执行更新的函数。每次执行 emit 时都会运行该函数。此函数为原地调用，且将被内联。
 * @param 内容 将发射此节点"子节点"的组合内容。
 * @see Updater
 * @see Applier
 * @see Composition
 */
// ComposeNode 是一种只读组合函数（readonly composable）的特殊情况，它会自行处理其分组的创建，因此可以放心使用。
@Suppress("NONREADONLY_CALL_IN_READONLY_COMPOSABLE", "ComposableNaming")
@Composable
public inline fun <T : Any?, reified E : Applier<*>> 组合节点(
    noinline 工厂: () -> T,
    更新: @DisallowComposableCalls Updater<T>.() -> Unit,
    内容: @Composable () -> Unit,
) = ComposeNode<T, E>(factory = 工厂, update = 更新, content = 内容)

/**
 * 将一个可回收的 [T] 类型节点发射到组合中。在 [内容] 内部发射的节点将成为该发射节点的子节点。
 *
 * 如果 [E] 不是 [currentComposer] 的 applier 的子类型，则此函数将抛出运行时异常。
 *
 * @param 工厂 一个将创建 [T] 新实例的函数。不保证该函数会被原地调用。
 * @param 更新 一个用于对节点执行更新的函数。每次执行 `emit` 时都会运行该函数。此函数为原地调用，且将被内联。
 * @param 内容 将发射此节点"子节点"的组合内容。
 * @see Updater
 * @see Applier
 * @see Composition
 */
// ComposeNode 是一种只读组合函数（readonly composable）的特殊情况，它会自行处理其分组的创建，因此可以放心使用。
@Suppress("NONREADONLY_CALL_IN_READONLY_COMPOSABLE", "ComposableNaming")
@Composable
public inline fun <T : Any?, reified E : Applier<*>> 可复用组合节点(
    noinline 工厂: () -> T,
    更新: @DisallowComposableCalls Updater<T>.() -> Unit,
    内容: @Composable () -> Unit,
) = ReusableComposeNode<T, E>(factory = 工厂, update = 更新, content = 内容)

/**
 * 将一个 [T] 类型的节点发射到组合中。在 [内容] 内部发射的节点将成为该发射节点的子节点。
 *
 * 如果 [E] 不是 [currentComposer] 的 applier 的子类型，则此函数将抛出运行时异常。
 *
 * @param 工厂 一个将创建 [T] 新实例的函数。不保证该函数会被原地调用。
 * @param 更新 一个用于对节点执行更新的函数。每次执行 `emit` 时都会运行该函数。此函数为原地调用，且将被内联。
 * @param 可跳过更新 一个用于对节点执行更新的函数。与 [更新] 不同，此函数是可组合（Composable）的，因此除非被其他机制标记为失效，
 * 否则将被跳过。这适用于执行开销较大的节点更新计算，且这些计算的输入随时间变化的可能性很小，从而可以跳过该函数的执行。
 * @param 内容 将发射此节点"子节点"的组合内容。
 * @see Updater
 * @see SkippableUpdater
 * @see Applier
 * @see Composition
 */
@Suppress("ComposableNaming")
@Composable
@ExplicitGroupsComposable
public inline fun <T, reified E : Applier<*>> 组合节点(
    noinline 工厂: () -> T,
    更新: @DisallowComposableCalls Updater<T>.() -> Unit,
    noinline 可跳过更新: @Composable SkippableUpdater<T>.() -> Unit,
    内容: @Composable () -> Unit,
) = ComposeNode<T, E>(factory = 工厂, update = 更新, skippableUpdate = 可跳过更新, content = 内容)

/**
 * 将一个可回收的 [T] 类型节点发射到组合中。在 [内容] 内部发射的节点将成为该发射节点的子节点。
 *
 * 如果 [E] 不是 [currentComposer] 的 applier 的子类型，则此函数将抛出运行时异常。
 *
 * @param 工厂 一个将创建 [T] 新实例的函数。不保证该函数会被原地调用。
 * @param 更新 一个用于对节点执行更新的函数。每次执行 emit 时都会运行该函数。此函数为原地调用，且将被内联。
 * @param 可跳过更新 一个用于对节点执行更新的函数。与 [更新] 不同，此函数是可组合（Composable）的，因此除非
 * 被其他机制标记为失效，否则将被跳过。这适用于执行开销较大的节点更新计算，且这些计算的输入随时间变化的可能性很小，
 * 从而可以跳过该函数的执行。
 * @param 内容 将发射此节点"子节点"的组合内容。
 * @see Updater
 * @see SkippableUpdater
 * @see Applier
 * @see Composition
 */
@Suppress("ComposableNaming")
@Composable
@ExplicitGroupsComposable
public inline fun <T, reified E : Applier<*>> 可复用组合节点(
    noinline 工厂: () -> T,
    更新: @DisallowComposableCalls Updater<T>.() -> Unit,
    noinline 可跳过更新: @Composable SkippableUpdater<T>.() -> Unit,
    内容: @Composable () -> Unit,
) = ReusableComposeNode<T, E>(factory = 工厂, update = 更新, skippableUpdate = 可跳过更新, content = 内容)


/**
 * 一个用于在当前组合点构建 [CompositionContext] 的 Effect。这可用于在当前组合的上下文中运行一个独立的组合，同时保留
 * [CompositionLocal] 并传播失效。当此调用离开组合时，该上下文将被标记为失效。
 */
@OptIn(InternalComposeApi::class)
@Composable
public fun 记住组合上下文(): CompositionContext = rememberCompositionContext()
