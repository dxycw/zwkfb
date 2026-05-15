package 安卓x.组合.材质3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * [Material Design layout](https://m3.material.io/foundations/layout/understanding-layout/)
 *
 * 脚手架 实现了基本的 Material Design 视觉布局结构。
 *
 * 该组件提供了将多个 Material 组件组合在一起以构建屏幕的 API，通过确保它们拥有正确的布局策略，并收集必要的数据，使这些组件能够协同工作。
 *
 * @param 修饰符 要应用于此 脚手架 的 [Modifier]。
 * @param 顶部栏 屏幕的顶部应用栏，通常为 [TopAppBar]。
 * @param 底部栏 屏幕的底部栏，通常为 [NavigationBar]。
 * @param 提示条主机 用于托管通过 [SnackbarHostState.showSnackbar] 推送显示的 [Snackbar] 的组件，通常为 [SnackbarHost]。
 * @param 悬浮操作按钮 屏幕的主操作按钮，通常为 [FloatingActionButton]。
 * @param 悬浮操作按钮位置 屏幕上浮动操作按钮的位置。参见 [FabPosition]。
 * @param 容器颜色 用于此 脚手架 背景的颜色。使用 [Color.Transparent] 可设为无颜色。
 * @param 内容颜色 此 脚手架 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，如果 [容器颜色] 不是主题中的颜色，则使用当前的 [LocalContentColor]。
 * @param 内容窗口插入 通过 [PaddingValues] 参数传递给 [内容] 插槽的窗口边衬区。只有当 [顶部栏]/[底部栏] 不存在时，脚手架
 * 才会从顶部/底部考虑这些边衬区，因为 脚手架 期望由 [顶部栏]/[底部栏] 自行处理边衬区。 父布局上其他边衬区内边距修饰符或
 * [consumeWindowInsets] 已消费的任何边衬区，将从 [内容窗口插入] 中排除。
 * @param 内容 屏幕的内容区域。该 lambda 接收一个 [PaddingValues]，应通过 [androidx.compose.foundation.layout.padding]
 * 和 [androidx.compose.foundation.layout.consumeWindowInsets] 应用到内容根布局，以正确偏移顶部和底部栏。
 * 如果使用 [androidx.compose.foundation.verticalScroll]，请将此修饰符应用到滚动容器的子项上，而不是滚动容器本身。
 */
@Suppress("ComposableNaming")
@Composable
fun 脚手架(
    修饰符: Modifier = Modifier,
    顶部栏: @Composable () -> Unit = {},
    底部栏: @Composable () -> Unit = {},
    提示条主机: @Composable () -> Unit = {},
    悬浮操作按钮: @Composable () -> Unit = {},
    悬浮操作按钮位置: FabPosition = FabPosition.End,
    容器颜色: Color = MaterialTheme.colorScheme.background,
    内容颜色: Color = contentColorFor(容器颜色),
    内容窗口插入: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    内容: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = 修饰符,
        topBar = 顶部栏,
        bottomBar = 底部栏,
        snackbarHost = 提示条主机,
        floatingActionButton = 悬浮操作按钮,
        floatingActionButtonPosition = 悬浮操作按钮位置,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        contentWindowInsets = 内容窗口插入,
        content = 内容,
    )
}

/** [脚手架] 组件的默认值 Object，包含多种默认配置 */
object 脚手架默认值 { // ScaffoldDefaults

    /** 供脚手架内容插槽使用和消费的默认边衬区。 */
    val 内容窗口插入: WindowInsets
        @Composable get() = ScaffoldDefaults.contentWindowInsets

}

/**  附加到 [脚手架] 的 [FloatingActionButton] 的可能位置。 */
object 悬浮位置  {

    /** 将浮动操作按钮置于屏幕底部起始位置，位于 [NavigationBar] 上方（如果存在）。*/
    val 起始 = FabPosition.Start

    /** 将浮动操作按钮置于屏幕底部居中位置，位于 [NavigationBar] 上方（如果存在）。*/
    val 居中 = FabPosition.Center

    /** 将浮动操作按钮置于屏幕底部末尾位置，位于 [NavigationBar] 上方（如果存在）。*/
    val 末尾 = FabPosition.End

    /** 将浮动操作按钮置于屏幕底部末尾位置，叠加在 [NavigationBar] 上方（如果存在）。*/
    val 末尾覆盖 = FabPosition.EndOverlay

}

