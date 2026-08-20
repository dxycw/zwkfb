package 自定义.组合.动画

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.DeferredAnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.MutableTransform
import androidx.compose.animation.core.DeferredTransition
import androidx.compose.animation.core.ExperimentalDeferredTransitionApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Transition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import 安卓x.组合.动画.动画可见性范围


@Suppress("ComposableNaming")
@Composable
fun 动画可见性(
    可见: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    标签: String = "动画可见性",
    内容: @Composable() 动画可见性范围.() -> Unit,
) = AnimatedVisibility(visible = 可见, modifier = 修饰符, enter = 进入, exit = 退出, label = 标签,
    content = {
        内容(object : 动画可见性范围 {
            override val 过渡: Transition<EnterExitState>
                get() = this@AnimatedVisibility.transition

            override fun Modifier.动画进入退出(
                进入: EnterTransition,
                退出: ExitTransition,
                标签: String,
            ): Modifier = this.animateEnterExit(enter = 进入, exit = 退出, label = 标签)

        })
    })


@Suppress("ComposableNaming")
@Composable
fun RowScope.动画可见性(
    可见: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandHorizontally(),
    退出: ExitTransition = fadeOut() + shrinkHorizontally(),
    标签: String = "动画可见性",
    内容: @Composable 动画可见性范围.() -> Unit,
) = AnimatedVisibility(visible = 可见, modifier = 修饰符, enter = 进入, exit = 退出, label = 标签,
    content = {
        内容(object : 动画可见性范围 {
            override val 过渡: Transition<EnterExitState>
                get() = this@AnimatedVisibility.transition

            override fun Modifier.动画进入退出(
                进入: EnterTransition,
                退出: ExitTransition,
                标签: String,
            ): Modifier = this.animateEnterExit(enter = 进入, exit = 退出, label = 标签)

        })
    })


@Suppress("ComposableNaming")
@Composable
fun ColumnScope.动画可见性(
    可见: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandVertically(),
    退出: ExitTransition = fadeOut() + shrinkVertically(),
    标签: String = "动画可见性",
    内容: @Composable 动画可见性范围.() -> Unit,
) = AnimatedVisibility(visible = 可见, modifier = 修饰符, enter = 进入, exit = 退出, label = 标签,
    content = {
        内容(object : 动画可见性范围 {
            override val 过渡: Transition<EnterExitState>
                get() = this@AnimatedVisibility.transition

            override fun Modifier.动画进入退出(
                进入: EnterTransition,
                退出: ExitTransition,
                标签: String,
            ): Modifier = this.animateEnterExit(enter = 进入, exit = 退出, label = 标签)

        })
    })

//========================================================================================

@Suppress("ComposableNaming")
@Composable
fun 动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    标签: String = "动画可见性",
    内容: @Composable() 动画可见性范围.() -> Unit,
) = AnimatedVisibility(visibleState = 可见状态, modifier = 修饰符, enter = 进入, exit = 退出, label = 标签,
    content = {
        内容(object : 动画可见性范围 {
            override val 过渡: Transition<EnterExitState>
                get() = this@AnimatedVisibility.transition

            override fun Modifier.动画进入退出(
                进入: EnterTransition,
                退出: ExitTransition,
                标签: String,
            ): Modifier = this.animateEnterExit(enter = 进入, exit = 退出, label = 标签)

        })
    })


@Suppress("ComposableNaming")
@Composable
fun RowScope.动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    标签: String = "动画可见性",
    内容: @Composable() 动画可见性范围.() -> Unit,
) = AnimatedVisibility(visibleState = 可见状态, modifier = 修饰符, enter = 进入, exit = 退出, label = 标签,
    content = {
        内容(object : 动画可见性范围 {
            override val 过渡: Transition<EnterExitState>
                get() = this@AnimatedVisibility.transition

            override fun Modifier.动画进入退出(
                进入: EnterTransition,
                退出: ExitTransition,
                标签: String,
            ): Modifier = this.animateEnterExit(enter = 进入, exit = 退出, label = 标签)

        })
    })


@Suppress("ComposableNaming")
@Composable
fun ColumnScope.动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    标签: String = "动画可见性",
    内容: @Composable() 动画可见性范围.() -> Unit,
) = AnimatedVisibility(visibleState = 可见状态, modifier = 修饰符, enter = 进入, exit = 退出, label = 标签,
    content = {
        内容(object : 动画可见性范围 {
            override val 过渡: Transition<EnterExitState>
                get() = this@AnimatedVisibility.transition

            override fun Modifier.动画进入退出(
                进入: EnterTransition,
                退出: ExitTransition,
                标签: String,
            ): Modifier = this.animateEnterExit(enter = 进入, exit = 退出, label = 标签)

        })
    })

//========================================================================================


@Suppress("ComposableNaming")
@Composable
fun <T> Transition<T>.动画可见性(
    可见: (T) -> Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    内容: @Composable() 动画可见性范围.() -> Unit,
) = AnimatedVisibility(visible = 可见, modifier = 修饰符, enter = 进入, exit = 退出,
    content = {
        内容(object : 动画可见性范围 {
            override val 过渡: Transition<EnterExitState>
                get() = this@AnimatedVisibility.transition

            override fun Modifier.动画进入退出(
                进入: EnterTransition,
                退出: ExitTransition,
                标签: String,
            ): Modifier = this.animateEnterExit(enter = 进入, exit = 退出, label = 标签)

        })
    })

@Suppress("ComposableNaming")
@ExperimentalDeferredTransitionApi
@Composable
fun <T> DeferredTransition<T>.延迟动画可见性(
    可见: (T) -> Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    可变转换: MutableTransform? = null,
    内容: @Composable() 动画可见性范围.() -> Unit,
) =
    this.DeferredAnimatedVisibility(
        visible = 可见,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        mutableTransform = 可变转换,
        content = {
            内容(object : 动画可见性范围 {
                override val 过渡: Transition<EnterExitState>
                    get() = this@DeferredAnimatedVisibility.transition

                override fun Modifier.动画进入退出(
                    进入: EnterTransition,
                    退出: ExitTransition,
                    标签: String,
                ): Modifier = this.animateEnterExit(enter = 进入, exit = 退出, label = 标签)

            })
        })


//========================================================================================

