@file:JvmName("导航主机Kt")
@file:JvmMultifileClass

package 安卓x.导航.组合

import androidx.navigation.compose.NavHost
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.jvm.JvmSuppressWildcards
import kotlin.reflect.KClass
import kotlin.reflect.KType

/**
 * 在 Compose 层级结构中提供一个位置，用于发生独立的导航。
 *
 * 调用此方法后，给定 [NavGraphBuilder] 中的任何 Composable 都可以通过提供的 [导航控制器] 进行导航。
 *
 * 传入此方法的构建器会被 [remember]。这意味着对于此 NavHost，构建器的内容无法更改。
 *
 * @param 导航控制器 此宿主（NavHost）的 navController
 * @param 起始目的地 起始目的地的路由
 * @param 修饰符 要应用于该布局的修饰符
 * @param 内容对齐 [AnimatedContent] 的 [Alignment]
 * @param 路由 该导航图的路由
 * @param 进入过渡 用于定义此宿主（NavHost）中目的地进入过渡效果的回调
 * @param 退出过渡 用于定义此宿主（NavHost）中目的地退出过渡效果的回调
 * @param 弹出进入过渡 用于定义此 NavHost 中目的地的返回进入过渡动画的回调
 * @param 弹出退出过渡 用于定义此 NavHost 中目的地的返回退出过渡动画的回调
 * @param 大小转换 用于定义此 NavHost 中目的地的尺寸变换的回调
 * @param 构建器 用于构建该导航图的构建器
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
        { fadeIn(animationSpec = tween(700)) },
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        退出过渡,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        null,
    构建器: NavGraphBuilder.() -> Unit
) {
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
        sizeTransform = 大小转换,
        builder = 构建器
    )
}


/**
 * 在 Compose 层级中为独立导航提供容器。
 *
 * 调用此方法后，即可通过提供的 [导航控制器] 导航到给定 [NavGraphBuilder] 中的任何 Composable。
 *
 * 传入此方法的构建器会被 [remember]。这意味着对于此 NavHost，构建器的内容无法更改。
 *
 * @param 导航控制器 此宿主（NavHost）的 导航控制器
 * @param 起始目的地 起始目的地的 [KClass] 路由
 * @param 修饰符 应用于该布局的修饰符
 * @param 内容对齐 [AnimatedContent] 的 [Alignment]
 * @param 路由 该导航图的 [KClass] 路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其对应自定义 [NavType] 的映射。如果 [路由] 未使用自定义 NavType，可为空。
 * @param 进入过渡 用于定义此宿主中目的地进入过渡动画的回调
 * @param 退出过渡 用于定义此宿主中目的地退出过渡动画的回调
 * @param 弹出进入过渡 用于定义此宿主中目的地返回进入过渡动画的回调
 * @param 弹出退出过渡 用于定义此宿主中目的地返回退出过渡动画的回调
 * @param 大小转换 用于定义此宿主中目的地的尺寸变换的回调
 * @param 构建器 用于构建该导航图的构建器
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
        { fadeIn(animationSpec = tween(700)) },
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        退出过渡,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        null,
    构建器: NavGraphBuilder.() -> Unit
) {
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
        sizeTransform = 大小转换,
        builder = 构建器
    )
}

/**
 * 在 Compose 层级中为独立导航提供容器。
 *
 * 调用此方法后，即可通过提供的 [导航控制器] 导航到给定 [NavGraphBuilder] 中的任何 Composable。
 *
 * 传入此方法的构建器会被 [remember]。这意味着对于此 NavHost，构建器的内容无法更改。
 *
 * @param 导航控制器 此宿主（NavHost）的 导航控制器
 * @param 起始目的地 起始目的地的 Object 路由
 * @param 修饰符 应用于该布局的修饰符
 * @param 内容对齐 [AnimatedContent] 的 [Alignment]
 * @param 路由 该导航图的 [KClass] 路由
 * @param 类型映射 目的地参数的 Kotlin 类型 [KType] 到其对应自定义 [NavType] 的映射。如果 [路由] 未使用自定义 NavType，可为空。
 * @param 进入过渡 用于定义此宿主中目的地进入过渡动画的回调
 * @param 退出过渡 用于定义此宿主中目的地退出过渡动画的回调
 * @param 弹出进入过渡 用于定义此宿主中目的地返回进入过渡动画的回调
 * @param 弹出退出过渡 用于定义此宿主中目的地返回退出过渡动画的回调
 * @param 大小转换 用于定义此宿主中目的地的尺寸变换的回调
 * @param 构建器 用于构建该导航图的构建器
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
        { fadeIn(animationSpec = tween(700)) },
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        退出过渡,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        null,
    构建器: NavGraphBuilder.() -> Unit
) {
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
        sizeTransform = 大小转换,
        builder = 构建器
    )
}



/**
 * 在 Compose 层级中为独立导航提供容器。
 *
 * 调用此方法后，即可通过提供的 [导航控制器] 导航到给定 [NavGraphBuilder] 中的任何 Composable。
 *
 * @param 导航控制器 此宿主（NavHost）的 navController
 * @param 导航图 此宿主（NavHost）的导航图
 * @param 修饰符 应用于该布局的修饰符
 * @param 内容对齐 [AnimatedContent] 的 [Alignment]
 * @param 进入过渡 用于定义此宿主中目的地进入过渡动画的回调
 * @param 退出过渡 用于定义此宿主中目的地退出过渡动画的回调
 * @param 弹出进入过渡 用于定义此宿主中目的地返回进入过渡动画的回调
 * @param 弹出退出过渡 用于定义此宿主中目的地返回退出过渡动画的回调
 * @param 大小转换 用于定义此宿主中目的地的尺寸变换的回调
 */
@Suppress("ComposableNaming")
@Composable
public fun 导航主机(
    导航控制器: NavHostController,
    导航图: NavGraph,
    修饰符: Modifier = Modifier,
    内容对齐: Alignment = Alignment.TopStart,
    进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        { fadeIn(animationSpec = tween(700)) },
    退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        { fadeOut(animationSpec = tween(700)) },
    弹出进入过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
        进入过渡,
    弹出退出过渡: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
        退出过渡,
    大小转换: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? =
        null
) {
    NavHost(
        navController = 导航控制器,
        graph = 导航图,
        modifier = 修饰符,
        contentAlignment = 内容对齐,
        enterTransition = 进入过渡,
        exitTransition = 退出过渡,
        popEnterTransition = 弹出进入过渡,
        popExitTransition = 弹出退出过渡,
        sizeTransform = 大小转换
    )
}


