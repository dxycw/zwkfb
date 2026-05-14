package 安卓x.组合.基础.布局

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier


/**
 * 表示空空间布局的组件，其大小可以使用 [Modifier.width]、[Modifier.height] 和 [Modifier.size] 修饰符来定义。
 *
 * @param 修饰符 要设置给此 间隔器 的修饰符
 */
@Suppress("ComposableNaming")
@Composable
@NonRestartableComposable
fun 间隔器(修饰符: Modifier) {
    Spacer(modifier = 修饰符)
}

