package 安卓x.组合.基础.文本.选择

import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


/**
 * 为其直接或间接子项启用文本选择功能。
 *
 * 在**选择容器**中使用延迟布局（如 [LazyRow][androidx.compose.foundation.lazy.LazyRow] 或 [LazyColumn][androidx.compose.foundation.lazy.LazyColumn]）时，
 * 对于未进行组合（compose）的文本项，其行为是未定义的。例如，未组合的文本不会被纳入复制操作，且"全选"不会扩展选区以包含这些文本。
 *
 * @param 修饰符 要应用于容器的修饰符。
 * @param 内容 要在容器中显示的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 选择容器(
    修饰符: Modifier = Modifier,
    内容: @Composable () -> Unit
) {
    SelectionContainer(
        modifier = 修饰符,
        content = 内容,
    )
}

/**
 *  为其直接或间接子项禁用文本选择功能。使用时，只需将其包裹一个或多个文本可组合项即可。
 *
 * @param 内容 要在容器中显示的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 禁用选择(内容: @Composable () -> Unit) {
    DisableSelection(content = 内容)
}

