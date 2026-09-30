package 安卓x.组合.材质3

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberBottomSheetState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomSheet
import androidx.compose.material3.SheetValue.Hidden
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * [Material Design bottom sheet](https://m3.material.io/components/bottom-sheets/overview)
 *
 * 模态底部面板用作移动设备上内联菜单或简单对话框的替代方案，尤其适用于提供一长串操作项，或当各项需要更长的描述和图标时。
 *
 * 该组件为底部面板提供视觉表面和手势行为。关键的是，它直接在组合层级（主 UI 树）中渲染，不像 [模态底部面板]
 * 那样启动一个单独的 [androidx.compose.ui.window.Dialog] 窗口。
 *
 * 由于该组件存在于主 UI 树中：
 * - 它按照在布局中的位置（例如在 [Box] 内部）所确定的 Z 轴索引进行绘制。
 * - 它不会自动提供遮罩层（scrim），也不会阻止与屏幕其余部分的交互。
 * - 它与父级可组合项共享相同的生命周期和输入处理。
 *
 * 当构建自定义面板体验且不希望使用 [androidx.compose.ui.window.Dialog] 窗口，或需要自定义的
 * [androidx.compose.ui.window.Dialog] 时，请使用此组件。
 *
 * 如需一个自动处理 Dialog 窗口、遮罩层和焦点管理的模态底部面板，请使用 [模态底部面板]。
 *
 * 如需一个结构上集成到屏幕布局中的常驻底部面板，请使用 [底部面板脚手架]。
 *
 * 以下示例展示了该组件如何与您的 UI 配合使用。
 *
 * @param 修饰符 应用于底部面板的修饰符。
 * @param 状态 管理面板状态值和偏移量的状态对象。
 * @param 关闭请求回调 当面板被滑动至 [SheetValue.Hidden] 状态时调用的可选回调。
 * @param 最大宽度 [Dp] 值，定义面板将占用的最大宽度。传入 [Dp.Unspecified] 可使面板横跨整个屏幕宽度。
 * @param 手势已启用 是否启用手势。
 * @param 返回处理已启用 是否启用通过返回键关闭和预测性返回行为。
 * @param 拖拽手柄 可选的视觉标记，用于指示面板可拖拽。
 * @param 内容窗口插入 要应用于内容的窗口边衬区。
 * @param 形状 底部面板的形状。
 * @param 容器颜色 底部面板的背景颜色。
 * @param 内容颜色 首选的内容颜色。
 * @param 色调阴影 底部面板的色调高度。
 * @param 视觉阴影 底部面板的阴影高度。
 * @param 内容 面板的内容。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3Api
fun 底部面板(
    修饰符: Modifier = Modifier,
    状态: SheetState = rememberBottomSheetState(initialValue = Hidden),
    关闭请求回调: () -> Unit = {},
    最大宽度: Dp = BottomSheetDefaults.SheetMaxWidth,
    手势已启用: Boolean = true,
    返回处理已启用: Boolean = true,
    拖拽手柄: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    内容窗口插入: @Composable () -> WindowInsets = {
        BottomSheetDefaults.standardWindowInsets
    },
    形状: Shape = BottomSheetDefaults.ExpandedShape,
    容器颜色: Color = BottomSheetDefaults.ContainerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    色调阴影: Dp = BottomSheetDefaults.Elevation,
    视觉阴影: Dp = 0.dp,
    内容: @Composable ColumnScope.() -> Unit,
) =
    BottomSheet(
        modifier = 修饰符,
        state = 状态,
        onDismissRequest = 关闭请求回调,
        maxWidth = 最大宽度,
        gesturesEnabled = 手势已启用,
        backHandlerEnabled = 返回处理已启用,
        dragHandle = 拖拽手柄,
        contentWindowInsets = 内容窗口插入,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        content = 内容,
    )


