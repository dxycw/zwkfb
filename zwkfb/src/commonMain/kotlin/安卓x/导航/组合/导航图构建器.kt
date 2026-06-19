package 安卓x.导航.组合

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.navigation
import kotlin.jvm.JvmSuppressWildcards
import kotlin.reflect.KClass
import kotlin.reflect.KType


/**
 * 将 [可组合] 添加到 [NavGraphBuilder] 中
 *
 * @param 路由 目的地的路由
 * @param 参数集 与目的地关联的参数列表
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 进入过渡 确定目的地进入转场的回调
 * @param 退出过渡 确定目的地退出转场的回调
 * @param 弹出进入过渡 确定目的地弹出进入转场的回调
 * @param 弹出退出过渡 确定目的地弹出退出转场的回调
 * @param 大小转换 确定目的地尺寸变换的回调
 * @param 内容 目的地的可组合函数
 */
public fun NavGraphBuilder.可组合(
    路由: String,
    参数集: List<NamedNavArgument> = emptyList(),
    深度链接集: List<NavDeepLink> = emptyList(),
    进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? =
        null,
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? =
        null,
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? =
        进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? =
        退出过渡,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        null,
    内容: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    this.composable(
        route = 路由,
        arguments = 参数集,
        deepLinks = 深度链接集,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        content = 内容
    )
}

/**
 * 将 [可组合] 添加到 [NavGraphBuilder] 中
 *
 * @param T 基于 [KClass] 的目的地路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其相应自定义 [NavType] 的映射。如果 [T] 不使用自定义 NavType，则可以为空。
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 进入过渡 确定目的地进入转场的回调
 * @param 退出过渡 确定目的地退出转场的回调
 * @param 弹出进入过渡 确定目的地弹出进入转场的回调
 * @param 弹出退出过渡 确定目的地弹出退出转场的回调
 * @param 大小转换 确定目的地尺寸变换的回调
 * @param 内容 目的地的可组合函数
 */
public inline fun <reified T : Any> NavGraphBuilder.可组合(
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接集: List<NavDeepLink> = emptyList(),
    noinline 进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        null,
    noinline 退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        null,
    noinline 弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        进入过渡,
    noinline 弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        退出过渡,
    noinline 大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards SizeTransform?)? =
        null,
    noinline 内容: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    this.composable<T>(
        typeMap = 类型映射,
        deepLinks = 深度链接集,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        content = 内容
    )
}

/**
 * 将 [可组合] 添加到 [NavGraphBuilder] 中
 *
 * @param 路由 基于 [KClass] 的目的地路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其相应自定义 [NavType] 的映射。如果 [route] 不使用自定义 NavType，则可以为空。
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 进入过渡 确定目的地进入转场的回调
 * @param 退出过渡 确定目的地退出转场的回调
 * @param 弹出进入过渡 确定目的地弹出进入转场的回调
 * @param 弹出退出过渡 确定目的地弹出退出转场的回调
 * @param 大小转换 确定目的地尺寸变换的回调
 * @param 内容 目的地的可组合函数
 */
public fun <T : Any> NavGraphBuilder.可组合(
    路由: KClass<T>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接集: List<NavDeepLink> = emptyList(),
    进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        null,
    退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        null,
    弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        进入过渡,
    弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        退出过渡,
    大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards SizeTransform?)? =
        null,
    内容: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    this.composable(
        route = 路由,
        typeMap = 类型映射,
        deepLinks = 深度链接集,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        content = 内容
    )
}


/**
 * 构建一个嵌套的 [NavGraph]
 *
 * @param 起始目的地 此导航图的起始目的地路由
 * @param 路由 目的地的唯一路由
 * @param 参数集 与目的地关联的参数列表
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 进入过渡 定义此导航图中目的地进入转场的回调
 * @param 退出过渡 定义此导航图中目的地退出转场的回调
 * @param 弹出进入过渡 定义此导航图中目的地弹出进入转场的回调
 * @param 弹出退出过渡 定义此导航图中目的地弹出退出转场的回调
 * @param 大小转换 定义此导航图中目的地尺寸变换的回调
 * @param 构建器 用于构建导航图的构建器
 * @return 新构建的嵌套导航图
 */
public fun NavGraphBuilder.导航(
    起始目的地: String,
    路由: String,
    参数集: List<NamedNavArgument> = emptyList(),
    深度链接集: List<NavDeepLink> = emptyList(),
    进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? =
        null,
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? =
        null,
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? =
        进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? =
        退出过渡,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        null,
    构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation(
        startDestination = 起始目的地,
        route = 路由,
        arguments = 参数集,
        deepLinks = 深度链接集,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 构建一个嵌套的 [NavGraph]
 *
 * @param T 基于 KClass 的目的地唯一路由
 * @param 起始目的地 此导航图基于 [KClass] 的起始目的地路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其相应自定义 [NavType] 的映射。如果 [T] 不使用自定义 NavType，则可以为空。
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 进入过渡 定义此导航图中目的地进入转场的回调
 * @param 退出过渡 定义此导航图中目的地退出转场的回调
 * @param 弹出进入过渡 定义此导航图中目的地弹出进入转场的回调
 * @param 弹出退出过渡 定义此导航图中目的地弹出退出转场的回调
 * @param 大小转换 定义此导航图中目的地尺寸变换的回调
 * @param 构建器 用于构建导航图的构建器
 * @return 新构建的嵌套导航图
 */
public inline fun <reified T : Any> NavGraphBuilder.导航(
    起始目的地: KClass<*>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接集: List<NavDeepLink> = emptyList(),
    noinline 进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        null,
    noinline 退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        null,
    noinline 弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        进入过渡,
    noinline 弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        退出过渡,
    noinline 大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards SizeTransform?)? =
        null,
    noinline 构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation<T>(
        startDestination = 起始目的地,
        typeMap = 类型映射,
        deepLinks = 深度链接集,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 构建一个嵌套的 [NavGraph]
 *
 * @param 路由 基于 KClass 的目的地唯一路由
 * @param 起始目的地 此导航图基于 [KClass] 的起始目的地路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其相应自定义 [NavType] 的映射。如果 [route] 不使用自定义 NavType，则可以为空。
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 进入过渡 定义此导航图中目的地进入转场的回调
 * @param 退出过渡 定义此导航图中目的地退出转场的回调
 * @param 弹出进入过渡 定义此导航图中目的地弹出进入转场的回调
 * @param 弹出退出过渡 定义此导航图中目的地弹出退出转场的回调
 * @param 大小转换 定义此导航图中目的地尺寸变换的回调
 * @param 构建器 用于构建导航图的构建器
 * @return 新构建的嵌套导航图
 */
public fun <T : Any> NavGraphBuilder.导航(
    起始目的地: KClass<*>,
    路由: KClass<T>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接集: List<NavDeepLink> = emptyList(),
    进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        null,
    退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        null,
    弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        进入过渡,
    弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        退出过渡,
    大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards SizeTransform?)? =
        null,
    构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation(
        startDestination = 起始目的地,
        route = 路由,
        typeMap = 类型映射,
        deepLinks = 深度链接集,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 构建一个嵌套的 [NavGraph]
 *
 * @param T 基于 KClass 的目的地唯一路由
 * @param 起始目的地 此导航图基于 Object 的起始目的地路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其相应自定义 [NavType] 的映射。如果 [T] 不使用自定义 NavType，则可以为空。
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 进入过渡 定义此导航图中目的地进入转场的回调
 * @param 退出过渡 定义此导航图中目的地退出转场的回调
 * @param 弹出进入过渡 定义此导航图中目的地弹出进入转场的回调
 * @param 弹出退出过渡 定义此导航图中目的地弹出退出转场的回调
 * @param 大小转换 定义此导航图中目的地尺寸变换的回调
 * @param 构建器 用于构建导航图的构建器
 * @return 新构建的嵌套导航图
 */
public inline fun <reified T : Any> NavGraphBuilder.导航(
    起始目的地: Any,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接集: List<NavDeepLink> = emptyList(),
    noinline 进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        null,
    noinline 退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        null,
    noinline 弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        进入过渡,
    noinline 弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        退出过渡,
    noinline 大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards SizeTransform?)? =
        null,
    noinline 构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation<T>(
        startDestination = 起始目的地,
        typeMap = 类型映射,
        deepLinks = 深度链接集,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 构建一个嵌套的 [NavGraph]
 *
 * @param 路由 基于 KClass 的目的地唯一路由
 * @param 起始目的地 此导航图基于 Object 的起始目的地路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其相应自定义 [NavType] 的映射。如果 [route] 不使用自定义 NavType，则可以为空。
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 进入过渡 定义此导航图中目的地进入转场的回调
 * @param 退出过渡 定义此导航图中目的地退出转场的回调
 * @param 弹出进入过渡 定义此导航图中目的地弹出进入转场的回调
 * @param 弹出退出过渡 定义此导航图中目的地弹出退出转场的回调
 * @param 大小转换 定义此导航图中目的地尺寸变换的回调
 * @param 构建器 用于构建导航图的构建器
 * @return 新构建的嵌套导航图
 */
public fun <T : Any> NavGraphBuilder.导航(
    起始目的地: Any,
    路由: KClass<T>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接集: List<NavDeepLink> = emptyList(),
    进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        null,
    退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        null,
    弹出进入过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards EnterTransition?)? =
        进入过渡,
    弹出退出过渡: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards ExitTransition?)? =
        退出过渡,
    大小转换: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards SizeTransform?)? =
        null,
    构建器: NavGraphBuilder.() -> Unit
) {
    this.navigation(
        startDestination = 起始目的地,
        route = 路由,
        typeMap = 类型映射,
        deepLinks = 深度链接集,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 将 [Composable] 添加到 [NavGraphBuilder] 中，该可组合函数将在 [androidx.compose.ui.window.Dialog] 中承载。
 * 这仅适用于该对话框代表应用中一个独立屏幕的场景，它需要自己的生命周期和保存状态，独立于导航图中的任何其他目的地。对于
 * `AlertDialog` 等用例，应直接在需要显示该对话框的 [composable] 目的地中使用这些 API。
 *
 * @param 路由 目的地的路由
 * @param 参数集 与目的地关联的参数列表
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 对话框属性集 应传递给 [androidx.compose.ui.window.Dialog] 的属性
 * @param 内容 将在 Dialog 中承载的目的地可组合内容
 */
public fun NavGraphBuilder.对话框(
    路由: String,
    参数集: List<NamedNavArgument> = emptyList(),
    深度链接集: List<NavDeepLink> = emptyList(),
    对话框属性集: DialogProperties = DialogProperties(),
    内容: @Composable (NavBackStackEntry) -> Unit
) {
    this.dialog(
        route = 路由,
        arguments = 参数集,
        deepLinks = 深度链接集,
        dialogProperties = 对话框属性集,
        content = 内容
    )
}

/**
 * 将 [Composable] 添加到 [NavGraphBuilder] 中，该可组合函数将在 [androidx.compose.ui.window.Dialog] 中承载。
 * 这仅适用于该对话框代表应用中一个独立屏幕的场景，它需要自己的生命周期和保存状态，独立于导航图中的任何其他目的地。对于
 * `AlertDialog` 等用例，应直接在需要显示该对话框的 [composable] 目的地中使用这些 API。
 *
 * @param T 基于 KClass 的目的地路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其相应自定义 [NavType] 的映射。如果 [T] 不使用自定义 NavType，则可以为空。
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 对话框属性集 应传递给 [androidx.compose.ui.window.Dialog] 的属性
 * @param 内容 将在 Dialog 中承载的目的地可组合内容
 */
public inline fun <reified T : Any> NavGraphBuilder.对话框(
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接集: List<NavDeepLink> = emptyList(),
    对话框属性集: DialogProperties = DialogProperties(),
    noinline 内容: @Composable (NavBackStackEntry) -> Unit
) {
    this.dialog<T>(
        typeMap = 类型映射,
        deepLinks = 深度链接集,
        dialogProperties = 对话框属性集,
        content = 内容
    )
}

/**
 * 将 [Composable] 添加到 [NavGraphBuilder] 中，该可组合函数将在 [androidx.compose.ui.window.Dialog] 中承载。
 * 这仅适用于该对话框代表应用中一个独立屏幕的场景，它需要自己的生命周期和保存状态，独立于导航图中的任何其他目的地。对于
 * `AlertDialog` 等用例，应直接在需要显示该对话框的 [composable] 目的地中使用这些 API。
 *
 * @param 路由 基于 [T] 的 [KClass] 的目的地路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其相应自定义 [NavType] 的映射。如果 [route] 不使用自定义 NavType，则可以为空。
 * @param 深度链接集 与目的地关联的深层链接列表
 * @param 对话框属性集 应传递给 [androidx.compose.ui.window.Dialog] 的属性
 * @param 内容 将在 Dialog 中承载的目的地可组合内容
 */
public fun <T : Any> NavGraphBuilder.对话框(
    路由: KClass<T>,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    深度链接集: List<NavDeepLink> = emptyList(),
    对话框属性集: DialogProperties = DialogProperties(),
    内容: @Composable (NavBackStackEntry) -> Unit
) {
    this.dialog(
        route = 路由,
        typeMap = 类型映射,
        deepLinks = 深度链接集,
        dialogProperties = 对话框属性集,
        content = 内容
    )
}
