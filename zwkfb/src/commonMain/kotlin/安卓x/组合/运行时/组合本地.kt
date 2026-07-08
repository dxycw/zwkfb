package 安卓x.组合.运行时

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalAccessorScope
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.HostDefaultKey
import androidx.compose.runtime.InternalComposeApi
import androidx.compose.runtime.NonSkippableComposable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.compositionLocalWithComputedDefaultOf
import androidx.compose.runtime.compositionLocalWithHostDefaultOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.runtime.withCompositionLocal
import androidx.compose.runtime.withCompositionLocals


/** 返回由最近的 [CompositionLocalProvider] 组件提供的值，该组件直接或间接调用了使用此属性的可组合函数。*/
@OptIn(InternalComposeApi::class)
public inline val <T> CompositionLocal<T>.当前: T
    @ReadOnlyComposable
    @Composable
    get() = this.current

//======================================================================

/**
 * 在调用 [CompositionLocalProvider] 时，将一个 [CompositionLocal] 键关联到一个值。
 *
 * @see CompositionLocal
 * @see ProvidableCompositionLocal
 */
public infix fun <T> ProvidableCompositionLocal<T>.提供集(值: T): ProvidedValue<T> =
    this.provides(value = 值)

/**
 * 在调用 [CompositionLocalProvider] 时，如果该键尚未有关联的值，则将此 [CompositionLocal] 键关联到一个值。
 *
 * @see CompositionLocal
 * @see ProvidableCompositionLocal
 */
public infix fun <T> ProvidableCompositionLocal<T>.提供集默认值(值: T): ProvidedValue<T> =
    this.providesDefault(value = 值)

/**
 * 在调用 [CompositionLocalProvider] 时，将一个 [CompositionLocal] 键关联到一个 lambda 表达式 [计算]。
 * 每当检索该键时，都会调用此 [计算] lambda。该 lambda 在 [CompositionLocalContext] 的上下文中执行，此上下文
 * 允许通过调用 [CompositionLocalAccessorScope.currentValue] 来获取其他组合局部变量的当前值，这是该上下文为
 * [CompositionLocal] 键提供的一个扩展函数。
 *
 * 传递给 [providesComputed] 的 lambda 每次在求值该组合局部变量的 [CompositionLocal.current] 时都会被调用，
 * 并基于 lambda 中引用的其他局部变量在 [CompositionLocal.current] 被求值时的当前值来计算其值。这使得可以提供能够
 * 从其他局部变量派生而来的值。例如，如果强调色可以从单一基色计算得出，那么强调色可以作为计算型组合局部变量来提供。
 * 当提供一个新的基色时，所有强调色都会自动更新。
 *
 * @see CompositionLocal
 * @see CompositionLocalContext
 * @see ProvidableCompositionLocal
 */
public infix fun <T> ProvidableCompositionLocal<T>.提供集已计算(
    计算: CompositionLocalAccessorScope.() -> T
): ProvidedValue<T> = this.providesComputed(compute = 计算)


//======================================================================

/**
 * 创建一个可以使用 [CompositionLocalProvider] 提供的 [CompositionLocal] 键。在重组期间更改所提供的值，将会使通过
 * [CompositionLocal.current] 读取该值的 [CompositionLocalProvider] 的内容失效。
 *
 * `compositionLocalOf` 创建一个 [ProvidableCompositionLocal]，可以在调用 [CompositionLocalProvider] 时使用。
 * 类似于 [MutableList] 与 [List] 的关系，如果将该键作为 [CompositionLocal]（而非 [ProvidableCompositionLocal]）
 * 公开，则可以使用 [CompositionLocal.current] 读取它，但不能重新提供（re-provide）它。
 *
 * @param 	策略 用于确定 [CompositionLocal] 何时被视为已更改的策略。有关详细信息，请参阅 [SnapshotMutationPolicy]。
 * @param 默认工厂 一个值工厂，用于在没有提供值时提供默认值。当通过使用 [CompositionLocal.current] 的组件的
 * 调用方的 [CompositionLocalProvider] 未提供任何值时，将调用此工厂。如果无法提供合理的默认值，请考虑抛出异常。
 * @see CompositionLocal
 * @see staticCompositionLocalOf
 * @see mutableStateOf
 */
public fun <T> 组合本地的(
    策略: SnapshotMutationPolicy<T> = structuralEqualityPolicy(),
    默认工厂: () -> T,
): ProvidableCompositionLocal<T> =
    compositionLocalOf(policy = 策略, defaultFactory = 默认工厂)

/**
 * 创建一个可通过 [CompositionLocalProvider] 提供的 [CompositionLocal] 键。
 *
 * 与 [compositionLocalOf] 不同，[staticCompositionLocalOf] 的读取不会被组合器跟踪，更改 [CompositionLocalProvider]
 * 调用中提供的值将导致整个内容重组，而不仅仅是组合中使用了该局部值的位置。然而，正是由于缺乏这种跟踪，当所提供的值极不可能或永远不会改变时，
 * [staticCompositionLocalOf] 的效率更高。例如，Android 上下文、字体加载器或类似的共享值，对于 [CompositionLocalProvider]
 * 内容中的组件而言不太可能改变，应考虑使用 [staticCompositionLocalOf]。而颜色或其他主题类的值可能会改变，甚至被动画化，
 * 因此应使用 [compositionLocalOf]。
 *
 * [staticCompositionLocalOf] 创建一个 [ProvidableCompositionLocal]，可在调用 [CompositionLocalProvider]
 * 时使用。类似于 [MutableList] 与 [List] 的关系，如果将该键作为 [CompositionLocal]（而非 [ProvidableCompositionLocal]）
 * 公开，则可以使用 [CompositionLocal.current] 读取它，但无法重新提供（re-provide）它。
 *
 * @param 默认工厂 一个值工厂，用于在未提供值时供应默认值。当使用 [CompositionLocal.current] 的组件的调用方
 * 未通过 [CompositionLocalProvider] 提供值时，将调用此工厂。如果无法提供合理的默认值，则考虑抛出异常。
 * @see CompositionLocal
 * @see compositionLocalOf
 */
public fun <T> 静态组合本地的(默认工厂: () -> T): ProvidableCompositionLocal<T> =
    staticCompositionLocalOf(defaultFactory = 默认工厂)

/**
 * 创建一个默认行为类似于使用 [ProvidableCompositionLocal.providesComputed] 提供的 [CompositionLocal]。
 * 如果使用 [ProvidableCompositionLocal.provides] 提供值，则其行为等同于调用 [compositionLocalOf] 创建的 [CompositionLocal]。
 *
 * 换句话说，通过此方法生成的 [CompositionLocal] 与通过 [compositionLocalOf] 创建的 [CompositionLocal] 在提供
 * 值的方式上完全相同，唯一的区别在于未提供值时的行为。对于 [compositionLocalOf]，会直接返回默认值。而对于此方法创建的
 * [CompositionLocal]，如果没有提供值，则会调用默认计算逻辑来获取值。
 *
 * 传递给 [compositionLocalWithComputedDefaultOf] 的 lambda 将在每次为组合局部求值 [CompositionLocal.current]
 * 时被调用，并根据 lambda 中引用的其他局部值在求值时的当前值来计算其值。这允许提供可从其他局部值派生出的值。例如，如果强调色
 * 可以从单个基础色计算得出，则可将强调色作为计算型组合局部提供。提供新的基础色将自动更新所有强调色。
 *
 * @param 默认计算 当此 [CompositionLocal] 未提供时使用的默认计算（函数）。
 * @see CompositionLocal
 * @see ProvidableCompositionLocal
 */
public fun <T> 组合本地带已计算默认值的(
    默认计算: CompositionLocalAccessorScope.() -> T
): ProvidableCompositionLocal<T> =
    compositionLocalWithComputedDefaultOf(defaultComputation = 默认计算)


/**
 * 创建一个 [ProvidableCompositionLocal]，其默认值通过使用给定的 [键] 查询 [LocalHostDefaultProvider] 来解析。
 *
 * 如果使用 [ProvidableCompositionLocal.provides] 提供值，则其行为与使用 [compositionLocalOf] 创建的
 * [CompositionLocal] 完全相同。
 *
 * 当未提供值时，默认值通过查询当前组合中存在的 [LocalHostDefaultProvider] 来解析。此机制允许默认值由宿主环境
 * （如 Android View）动态确定，而无需硬编码或在组合根节点处显式提供。
 *
 * 这实际上起到了桥梁的作用，将 [CompositionLocal] 的定义与解析其默认值所需的平台特定逻辑解耦。例如，`LocalViewModelStoreOwner`
 * 可以使用此机制向宿主请求获取所有者，而无需直接依赖 Android View 系统。
 *
 * @param 键 一个用于在宿主上下文中标识所请求值的不透明键。该键的类型和含义由 [HostDefaultProvider] 的实现定义
 * （例如，在 Android 上，通常是一个资源 ID）。
 * @throws NullPointerException 如果宿主无法找到 [键] 对应的值，则返回 `null`。如果 [T] 是非空类型（例如
 * `compositionLocalWithHostDefaultOf<String>`），则在访问该值时会因键缺失而导致 [NullPointerException]。
 */
public fun <T> 组合本地带主机默认值的(
    键: HostDefaultKey<T>
): ProvidableCompositionLocal<T> = compositionLocalWithHostDefaultOf(key = 键)



public interface 组合本地访问器范围 { // CompositionLocalAccessorScope

    /**
     * 一个扩展属性，允许在此作用域的上下文中访问组合局部的当前值。此作用域是计算型组合中 `this` 参数的类型。计算型组合局部
     * 可通过使用 [compositionLocalWithComputedDefaultOf] 或 [ProvidableCompositionLocal.providesComputed] 中缀运算符来提供。
     *
     * @see ProvidableCompositionLocal
     * @see ProvidableCompositionLocal.providesComputed
     * @see ProvidableCompositionLocal.provides
     * @see CompositionLocalProvider
     */
    public val <T> CompositionLocal<T>.当前值: T

}

/**
 * [CompositionLocalProvider] 将值绑定到 [ProvidableCompositionLocal] 键。在 [内容] lambda 中直接或间接
 * 调用的所有可组合函数中，使用 [CompositionLocal.current] 读取 [CompositionLocal] 时，将返回 [CompositionLocalProvider]
 * 的 [值集] 参数中提供的值。
 *
 * @see CompositionLocal
 * @see compositionLocalOf
 * @see staticCompositionLocalOf
 */
@Suppress("ComposableNaming")
@Composable
@OptIn(InternalComposeApi::class)
@NonSkippableComposable
public fun 组合本地提供器(
    vararg 值集: ProvidedValue<*>,
    内容: @Composable () -> Unit,
) = CompositionLocalProvider(values = 值集, content = 内容)

/**
 * [CompositionLocalProvider] 将值绑定到 [ProvidableCompositionLocal] 键。在 [内容] lambda 中直接或间接
 * 调用的所有可组合函数中，使用 [CompositionLocal.current] 读取 [CompositionLocal] 时，将返回 [CompositionLocalProvider]
 * 的 [值] 参数中提供的值。
 *
 * [CompositionLocalProvider] 的 [值] 参数，适用于在 [内容] lambda 中直接或间接调用的所有可组合函数。
 *
 * @see CompositionLocal
 * @see compositionLocalOf
 * @see staticCompositionLocalOf
 */
@Suppress("ComposableNaming")
@Composable
@OptIn(InternalComposeApi::class)
@NonSkippableComposable
public fun 组合本地提供器(值: ProvidedValue<*>, 内容: @Composable () -> Unit) =
    CompositionLocalProvider(value = 值, content = 内容)

/**
 * [CompositionLocalProvider] 将值绑定到由 [上下文] 提供的 [CompositionLocal]。在 [内容] lambda 中直接
 * 或间接调用的所有可组合函数中，使用 [CompositionLocal.current] 读取 [CompositionLocal] 时，将返回 [上下文] 内部存储的值。
 *
 * @see CompositionLocal
 * @see compositionLocalOf
 * @see staticCompositionLocalOf
 */
@Suppress("ComposableNaming")
@Composable
public fun 组合本地提供器(
    上下文: CompositionLocalContext,
    内容: @Composable () -> Unit,
) = CompositionLocalProvider(context = 上下文, content = 内容)


/**
 * [withCompositionLocal] 将值绑定到 [ProvidableCompositionLocal] 键，并返回 [内容] lambda 产生的结果。
 * 适用于返回非 Unit 的 [内容] lambda，否则请使用 [CompositionLocalProvider]。在 [内容] lambda 中直接
 * 或间接调用的所有可组合函数中，使用 [CompositionLocal.current] 读取 [CompositionLocal] 时，将返回
 * [CompositionLocalProvider] 的 [值] 参数中提供的值。
 *
 * @see CompositionLocalProvider
 * @see CompositionLocal
 * @see compositionLocalOf
 * @see staticCompositionLocalOf
 */
@Suppress("BanInlineOptIn") // b/430604046 - 这些 API 是稳定的，因此可以内联。
@OptIn(InternalComposeApi::class)
@Composable
public inline fun <T> 带组合本地(
    值: ProvidedValue<*>,
    内容: @Composable () -> T,
): T = withCompositionLocal(value = 值, content = 内容)

/**
 * [withCompositionLocals] 将值绑定到 [ProvidableCompositionLocal] 键，并返回 [内容] lambda 产生的结果。
 * 适用于返回非 Unit 的 [内容] lambda，否则请使用 [CompositionLocalProvider]。在 [内容] lambda 中直接
 * 或间接调用的所有可组合函数中，使用 [CompositionLocal.current] 读取 [CompositionLocal] 时，将返回
 * [CompositionLocalProvider] 的 [值集] 参数中提供的值。
 *
 * @see CompositionLocalProvider
 * @see CompositionLocal
 * @see compositionLocalOf
 * @see staticCompositionLocalOf
 */
@Suppress("BanInlineOptIn") // b/430604046 - 这些 API 是稳定的，因此可以内联。
@OptIn(InternalComposeApi::class)
@Composable
public inline fun <T> 带组合本地集(
    vararg 值集: ProvidedValue<*>,
    内容: @Composable () -> T,
): T = withCompositionLocals(values = 值集, content = 内容)
