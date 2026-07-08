package 安卓x.导航.组合

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.DefaultNavTransitions
import androidx.navigation.compose.NavHost
import kotlin.jvm.JvmSuppressWildcards
import kotlin.reflect.KClass
import kotlin.reflect.KType


/**
 * 在 Compose 层级结构中提供一个位置，供独立的导航操作发生。
 *
 * 调用此方法后，给定 [NavGraphBuilder] 中的任何 Composable 都可以通过提供的 [导航控制器] 进行导航。
 *
 * 传入此方法的构建器会被 [remember]。这意味着对于此 NavHost，构建器的内容无法更改。
 *
 * @param 导航控制器 此宿主（NavHost）的导航控制器。
 * @param 起始目的地 起始目的地的路由路径。
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 内容对齐 [AnimatedContent] 的对齐方式。
 * @param 路由 导航图的路由路径。
 * @param 进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的进入过渡动画。
 * @param 退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的退出过渡动画。
 * @param 弹出进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的弹出进入过渡动画。
 * @param 弹出退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的弹出退出过渡动画。
 * @param 预测性弹出进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的预测性弹出进入过渡动画。
 * @param 预测性弹出退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的预测性弹出退出过渡动画。
 * @param 大小转换 回调函数，用于定义此宿主（NavHost）中各个目的地之间的尺寸变换。
 * @param 构建器 用于构建导航图的构建器。
 */
@Suppress("ComposableNaming")
@Composable
public fun 导航主机(
    导航控制器: NavHostController,
    起始目的地: String,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    路由: String? = null,
    进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        DefaultNavTransitions.enterTransition,
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        DefaultNavTransitions.exitTransition,
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        DefaultNavTransitions.popEnterTransition(进入过渡),
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        DefaultNavTransitions.popExitTransition(退出过渡),
    预测性弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.(Int) -> EnterTransition) =
        DefaultNavTransitions.predictivePopEnterTransition,
    预测性弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.(Int) -> ExitTransition) =
        DefaultNavTransitions.predictivePopExitTransition,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        DefaultNavTransitions.sizeTransform,
    构建器: NavGraphBuilder.() -> Unit,
) =
    NavHost(
        navController = 导航控制器,
        startDestination = 起始目的地,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        route = 路由,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        predictivePopEnterTransition = 预测性弹出进入过渡,
        predictivePopExitTransition = 预测性弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )


/**
 * 在 Compose 层级结构中提供一个位置，供独立的导航操作发生。
 *
 * 调用此方法后，给定 [NavGraphBuilder] 中的任何可组合项都可以通过提供的 [导航控制器] 进行导航。
 *
 * 传入此方法的构建器会被 [remember] 记住。这意味着对于此 NavHost，构建器的内容无法更改。
 *
 * @param 导航控制器 此宿主（NavHost）的导航控制器。
 * @param 起始目的地 从 [KClass] 获取起始目的地的路由路径。
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 内容对齐 [AnimatedContent] 的对齐方式。
 * @param 路由 从 [KClass] 获取导航图的路由路径。
 * @param 类型映射 目标参数 Kotlin 类型 [KType] 到其对应自定义 [NavType] 的映射。如果 [路由] 未使用自定义 NavType，则可为空。
 * @param 进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的进入过渡动画。
 * @param 退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的退出过渡动画。
 * @param 弹出进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的弹出进入过渡动画。
 * @param 弹出退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的弹出退出过渡动画。
 * @param 预测性弹出进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的预测性弹出进入过渡动画。
 * @param 预测性弹出退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的预测性弹出退出过渡动画。
 * @param 大小转换 回调函数，用于定义此宿主（NavHost）中各个目的地之间的尺寸变换。
 * @param 构建器 用于构建导航图的构建器。
 */
@Suppress("ComposableNaming")
@Composable
public fun 导航主机(
    导航控制器: NavHostController,
    起始目的地: KClass<*>,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    路由: KClass<*>? = null,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        DefaultNavTransitions.enterTransition,
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        DefaultNavTransitions.exitTransition,
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        DefaultNavTransitions.popEnterTransition(进入过渡),
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        DefaultNavTransitions.popExitTransition(退出过渡),
    预测性弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.(Int) -> EnterTransition) =
        DefaultNavTransitions.predictivePopEnterTransition,
    预测性弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.(Int) -> ExitTransition) =
        DefaultNavTransitions.predictivePopExitTransition,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        DefaultNavTransitions.sizeTransform,
    构建器: NavGraphBuilder.() -> Unit,
) =
    NavHost(
        navController = 导航控制器,
        startDestination = 起始目的地,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        route = 路由,
        typeMap = 类型映射,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        predictivePopEnterTransition = 预测性弹出进入过渡,
        predictivePopExitTransition = 预测性弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )


/**
 * 在 Compose 层级结构中提供一个位置，供独立的导航操作发生。
 *
 * 调用此方法后，给定 [NavGraphBuilder] 中的任何可组合项都可以通过提供的 [导航控制器] 进行导航。
 *
 * 传入此方法的构建器会被 [remember] 记住。这意味着对于此 NavHost，构建器的内容无法更改。
 *
 * @param 导航控制器 此宿主（NavHost）的导航控制器。
 * @param 起始目的地 从对象获取起始目的地的路由路径。
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 内容对齐 [AnimatedContent] 的对齐方式。
 * @param 路由 从 [KClass] 获取导航图的路由路径。
 * @param 类型映射 目标参数 Kotlin 类型 [KType] 到其对应自定义 [NavType] 的映射。如果 [路由] 未使用自定义 NavType，则可为空。
 * @param 进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的进入过渡动画。
 * @param 退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的退出过渡动画。
 * @param 弹出进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的弹出进入过渡动画。
 * @param 弹出退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的弹出退出过渡动画。
 * @param 预测性弹出进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的预测性弹出进入过渡动画。
 * @param 预测性弹出退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的预测性弹出退出过渡动画。
 * @param 大小转换 回调函数，用于定义此宿主（NavHost）中各个目的地之间的尺寸变换。
 * @param 构建器 用于构建导航图的构建器。
 */
@Suppress("ComposableNaming")
@Composable
public fun 导航主机(
    导航控制器: NavHostController,
    起始目的地: Any,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    路由: KClass<*>? = null,
    类型映射: Map<KType, @JvmSuppressWildcards NavType<*>> = emptyMap(),
    进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        DefaultNavTransitions.enterTransition,
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        DefaultNavTransitions.exitTransition,
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        DefaultNavTransitions.popEnterTransition(进入过渡),
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        DefaultNavTransitions.popExitTransition(退出过渡),
    预测性弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.(Int) -> EnterTransition) =
        DefaultNavTransitions.predictivePopEnterTransition,
    预测性弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.(Int) -> ExitTransition) =
        DefaultNavTransitions.predictivePopExitTransition,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        DefaultNavTransitions.sizeTransform,
    构建器: NavGraphBuilder.() -> Unit,
) =
    NavHost(
        navController = 导航控制器,
        startDestination = 起始目的地,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        route = 路由,
        typeMap = 类型映射,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        predictivePopEnterTransition = 预测性弹出进入过渡,
        predictivePopExitTransition = 预测性弹出退出过渡,
        sizeTransform = 大小转换,
        builder = 构建器
    )



/**
 * 在 Compose 层级结构中提供一个位置，供独立的导航操作发生。
 *
 * 调用此方法后，给定 [NavGraphBuilder] 中的任何可组合项都可以通过提供的 [导航控制器] 进行导航。
 *
 * @param 导航控制器 此宿主（NavHost）的导航控制器。
 * @param 导航图 此宿主（NavHost）的导航图。
 * @param 修饰符 要应用于该布局的修饰符。
 * @param 内容对齐 [AnimatedContent] 的对齐方式。
 * @param 进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的进入过渡动画。
 * @param 退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的退出过渡动画。
 * @param 弹出进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的弹出进入过渡动画。
 * @param 弹出退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的弹出退出过渡动画。
 * @param 预测性弹出进入过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的预测性弹出进入过渡动画。
 * @param 预测性弹出退出过渡 回调函数，用于定义此宿主（NavHost）中各个目的地的预测性弹出退出过渡动画。
 * @param 大小转换 回调函数，用于定义此宿主（NavHost）中各个目的地之间的尺寸变换。
 */
@Suppress("ComposableNaming")
@Composable
public fun 导航主机(
    导航控制器: NavHostController,
    导航图: NavGraph,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        DefaultNavTransitions.enterTransition,
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        DefaultNavTransitions.exitTransition,
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        DefaultNavTransitions.popEnterTransition(进入过渡),
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        DefaultNavTransitions.popExitTransition(退出过渡),
    预测性弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.(Int) -> EnterTransition) =
        DefaultNavTransitions.predictivePopEnterTransition,
    预测性弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.(Int) -> ExitTransition) =
        DefaultNavTransitions.predictivePopExitTransition,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        DefaultNavTransitions.sizeTransform,
) =
    NavHost(
        navController = 导航控制器,
        graph = 导航图,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        predictivePopEnterTransition = 预测性弹出进入过渡,
        predictivePopExitTransition = 预测性弹出退出过渡,
        sizeTransform = 大小转换
    )

