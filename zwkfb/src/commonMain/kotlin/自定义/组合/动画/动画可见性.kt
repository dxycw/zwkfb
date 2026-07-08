package 自定义.组合.动画

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Transition
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
//import 安卓x.组合.动画.动画可见性范围

//@Suppress("ComposableNaming")
//@Composable
//fun 动画可见性(
//    可见: Boolean,
//    修饰符: Modifier = Modifier,
//    进入: EnterTransition = fadeIn() + expandIn(),
//    退出: ExitTransition = shrinkOut() + fadeOut(),
//    标签: String = "AnimatedVisibility",
//    内容: @Composable 动画可见性范围.() -> Unit,
//) {
//    AnimatedVisibility(
//        visible = 可见,
//        modifier = 修饰符,
//        enter = 进入,
//        exit = 退出,
//        label = 标签,
//        content = {
//            内容(
//                object : 动画可见性范围 {
//                    override val 过渡: Transition<EnterExitState>
//                        get() = transition
//
//                    override fun Modifier.动画进入退出(
//                        进入: EnterTransition,
//                        退出: ExitTransition,
//                        标签: String
//                    ): Modifier = this.animateEnterExit(
//                        enter = 进入,
//                        exit = 退出,
//                        label = 标签
//                    )
//                }
//            )
//        },
//    )
//}
