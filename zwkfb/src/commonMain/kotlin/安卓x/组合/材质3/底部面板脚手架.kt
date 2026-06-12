package 安卓x.组合.材质3

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SheetValue.Expanded
import androidx.compose.material3.SheetValue.PartiallyExpanded
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design standard bottom sheet scaffold](https://m3.material.io/components/bottom-sheets/overview)
 *
 * 标准底部面板与屏幕的主 UI 区域共存，允许同时查看和与两个区域交互。当主 UI 区域的内容频繁滚动或平移时，
 * 通常使用它们来保持某个功能或次要内容在屏幕上可见。
 *
 * ![Bottom sheet image](https://developer.android.com/images/reference/androidx/compose/material3/bottom_sheet.png)
 *
 * 该组件提供 API，用于将多个 Material 组件组合在一起构建屏幕，通过确保它们的正确布局策略并收集必要的数据，使这些组件能够协同工作。
 *
 * @param 面板内容 底部面板的内容
 * @param 修饰符 应用于支架根节点的 [Modifier]。
 * @param 脚手架状态 底部面板支架的状态
 * @param 面板预览高度 底部面板折叠时的高度
 * @param 面板最大宽度 定义面板最大宽度的 [Dp]。传入 [Dp.Unspecified] 可使面板横跨整个屏幕宽度。
 * @param 面板形状 底部面板的形状
 * @param 面板容器颜色 底部面板的背景色
 * @param 面板内容颜色 底部面板提供给其子项的首选内容颜色。默认为 [面板容器颜色] 对应的匹配内容颜色；
 * 如果该颜色不是主题中的颜色，则将保留底部面板上方设置的内容颜色。
 * @param 面板色调阴影 当 [面板容器颜色] 为 [ColorScheme.surface] 时，
 * 会在容器上方应用半透明的主题色叠加层。较高的色调海拔值在浅色主题下会产生更深的颜色，在深色主题下则会产生更浅的颜色。另请参阅：[表面]。
 * @param 面板视觉阴影 底部面板的阴影海拔
 * @param 面板拖拽手柄 用于拉取支架底部面板的可选视觉标记
 * @param 面板滑动已启用 底部面板滑动是否启用，以及是否应对用户输入作出响应
 * @param 顶部栏 屏幕的顶部应用栏，通常为 [androidx.compose.material3.TopAppBar]
 * @param 提示条主机 用于承载通过 [SnackbarHostState.showSnackbar] 推送显示的 [提示条] 的组件，通常为 [SnackbarHost]
 * @param 容器颜色 此支架背景使用的颜色。使用 [Color.Transparent] 可设为透明。
 * @param 内容颜色 此支架内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容颜色；如果 [容器颜色]
 * 不是主题中的颜色，则默认为当前的 [LocalContentColor]。
 * @param 内容 屏幕内容。该 lambda 接收一个 [PaddingValues]，应通过 [androidx.compose.foundation.layout.padding]
 * 和 [androidx.compose.foundation.layout.consumeWindowInsets] 将其应用于内容根节点，以正确偏移顶部和底部栏。
 * 如果使用 [androidx.compose.foundation.verticalScroll]，请将此修饰符应用于滚动组件的子项，而非滚动组件本身。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3Api
fun 底部面板脚手架(
    面板内容: @Composable ColumnScope.() -> Unit,
    修饰符: Modifier = Modifier,
    脚手架状态: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
    面板预览高度: Dp = BottomSheetDefaults.SheetPeekHeight,
    面板最大宽度: Dp = BottomSheetDefaults.SheetMaxWidth,
    面板形状: Shape = BottomSheetDefaults.ExpandedShape,
    面板容器颜色: Color = BottomSheetDefaults.ContainerColor,
    面板内容颜色: Color = contentColorFor(面板容器颜色),
    面板色调阴影: Dp = 0.dp,
    面板视觉阴影: Dp = BottomSheetDefaults.Elevation,
    面板拖拽手柄: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    面板滑动已启用: Boolean = true,
    顶部栏: @Composable (() -> Unit)? = null,
    提示条主机: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    容器颜色: Color = MaterialTheme.colorScheme.surface,
    内容颜色: Color = contentColorFor(容器颜色),
    内容: @Composable (PaddingValues) -> Unit,
) {
    BottomSheetScaffold(
        sheetContent = 面板内容,
        modifier = 修饰符,
        scaffoldState = 脚手架状态,
        sheetPeekHeight = 面板预览高度,
        sheetMaxWidth = 面板最大宽度,
        sheetShape = 面板形状,
        sheetContainerColor = 面板容器颜色,
        sheetContentColor = 面板内容颜色,
        sheetTonalElevation = 面板色调阴影,
        sheetShadowElevation = 面板视觉阴影,
        sheetDragHandle = 面板拖拽手柄,
        sheetSwipeEnabled = 面板滑动已启用,
        topBar = 顶部栏,
        snackbarHost = 提示条主机,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        content = 内容,
    )
}

/**
 * [底部面板脚手架] 可组合项的状态
 *
 * @param 底部面板状态 持久性底部面板的状态。
 * @param 提示条主机状态 用于在支架内部显示 Snackbar 的 [SnackbarHostState]。
 */
@ExperimentalMaterial3Api
@Stable
fun 底部面板脚手架状态( // BottomSheetScaffoldState
    底部面板状态: SheetState,
    提示条主机状态: SnackbarHostState,
) =
    BottomSheetScaffoldState(
        bottomSheetState = 底部面板状态,
        snackbarHostState = 提示条主机状态,
    )


/**
 * 创建并[remember]一个 [底部面板脚手架状态]。
 *
 * @param 底部面板状态 标准底部面板的状态。请参阅 [记住标准底部面板状态]。
 * @param 提示条主机状态 用于在支架内部显示 Snackbar 的 [SnackbarHostState]。
 */
@Composable
@ExperimentalMaterial3Api
fun 记住底部面板脚手架状态(
    底部面板状态: SheetState = rememberStandardBottomSheetState(),
    提示条主机状态: SnackbarHostState = remember { SnackbarHostState() },
): BottomSheetScaffoldState =
    rememberBottomSheetScaffoldState(
        bottomSheetState = 底部面板状态,
        snackbarHostState = 提示条主机状态,
    )



/**
 * 为 [底部面板脚手架] 创建并[remember]一个 [SheetState]。
 *
 * @param 初始值 状态的初始值。如果 [跳过隐藏状态] 为 true，则应为 [PartiallyExpanded] 或 [Expanded]。
 * @param 确定值改变 可选回调，用于确认或否决待处理的状态变更。
 * @param 跳过隐藏状态 [底部面板脚手架] 是否跳过 Hidden 状态。
 */
@Composable
@ExperimentalMaterial3Api
fun 记住标准底部面板状态(
    初始值: SheetValue = PartiallyExpanded,
    确定值改变: (SheetValue) -> Boolean = { true },
    跳过隐藏状态: Boolean = true,
) =
    rememberStandardBottomSheetState(
        initialValue = 初始值,
        confirmValueChange = 确定值改变,
        skipHiddenState = 跳过隐藏状态,
    )

