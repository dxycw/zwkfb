package 安卓x.活动.组合

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.platform.ComposeView

/**
 * 将给定的可组合组件合成到给定的 Activity 中。[内容] 将成为该 Activity 的根视图。
 *
 * 这大致相当于使用 [ComposeView] 调用 [ComponentActivity.setContentView]，即：
 * ```
 * setContentView(
 *   ComposeView(this).apply {
 *     置内容 {
 *       MyComposableContent()
 *     }
 *   }
 * )
 * ```
 *
 * @param 父级 父组合引用，用于协调组合更新的调度。
 * @param 内容 一个声明 UI 内容的 @Composable 函数。
 */
fun ComponentActivity.置内容(
    父级: CompositionContext? = null,
    内容: @Composable () -> Unit,
) {
    setContent(parent = 父级, content = 内容)
}

