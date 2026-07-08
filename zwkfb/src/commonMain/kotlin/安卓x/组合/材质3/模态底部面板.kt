package 安卓x.组合.材质3

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.*
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.SheetValue.Expanded
import androidx.compose.material3.SheetValue.Hidden
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberBottomSheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * [Material Design modal bottom sheet](https://m3.material.io/components/bottom-sheets/overview)
 *
 * 模态底部面板用作移动设备上内联菜单或简单对话框的替代方案，尤其适用于提供一长串操作项，或各项需要较长描述和图标的情况。
 * 与对话框类似，模态底部面板出现在应用内容前方，出现时禁用所有其他应用功能，并一直保留在屏幕上，直到确认、关闭或完成所需操作。
 *
 * ![Bottom sheet image](https://developer.android.com/images/reference/androidx/compose/material3/bottom_sheet.png)
 *
 * @param 关闭请求回调 当用户点击底部面板外部时执行，在面板动画过渡到 [Hidden] 状态之后触发。
 * @param 修饰符 底部面板的可选 [Modifier]。
 * @param 面板状态 底部面板的状态。
 * @param 面板最大宽度 定义面板最大宽度的 [Dp]。传入 [Dp.Unspecified] 可使面板横跨整个屏幕宽度。
 * @param 面板手势已启用 底部面板是否可以通过手势进行交互。
 * @param 形状 底部面板的形状。
 * @param 容器颜色 此底部面板背景使用的颜色
 * @param 内容颜色 此底部面板内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容颜色；
 * 如果 [容器颜色] 不是主题中的颜色，则默认为当前的 [LocalContentColor]。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方应用半透明的主题色叠加层。
 * 较高的色调海拔值在浅色主题下会产生更深的颜色，在深色主题下则会产生更浅的颜色。另请参阅：[表面]。
 * @param 遮罩颜色 底部面板打开时用于遮挡内容的遮罩颜色。
 * @param 拖拽手柄 用于滑动底部面板的可选视觉标记。
 * @param 内容窗口插入 提供窗口边衬区（insets）的回调，用于通过 [androidx.compose.foundation.layout.windowInsetsPadding]
 * 传递给底部面板内容。[模态底部面板] 会根据当前偏移量预先消费顶部边衬区，确保内容在任何位置都处于预期的窗口边衬区之外。
 * @param 属性集 用于进一步自定义此模态底部面板窗口行为的 [ModalBottomSheetProperties]。
 * @param 内容 要在底部面板内部显示的内容。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3Api
fun 模态底部面板(
    关闭请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    面板状态: SheetState = rememberBottomSheetState(initialValue = Hidden),
    面板最大宽度: Dp = BottomSheetDefaults.SheetMaxWidth,
    面板手势已启用: Boolean = true,
    形状: Shape = BottomSheetDefaults.ExpandedShape,
    容器颜色: Color = BottomSheetDefaults.ContainerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    色调阴影: Dp = 0.dp,
    遮罩颜色: Color = BottomSheetDefaults.ScrimColor,
    拖拽手柄: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    内容窗口插入: @Composable () -> WindowInsets = { BottomSheetDefaults.modalWindowInsets },
    属性集: ModalBottomSheetProperties = ModalBottomSheetProperties(),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ModalBottomSheet(
        onDismissRequest = 关闭请求回调,
        modifier = 修饰符,
        sheetState = 面板状态,
        sheetMaxWidth = 面板最大宽度,
        sheetGesturesEnabled = 面板手势已启用,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        scrimColor = 遮罩颜色,
        dragHandle = 拖拽手柄,
        contentWindowInsets = 内容窗口插入,
        properties = 属性集,
        content = 内容,
    )

/**
 * 用于自定义 [模态底部面板] 行为的属性。
 *
 * @param 是否应关闭按返回键回调 模态底部面板是否可以通过按返回键关闭。如果为 true，按返回键将调用 onDismissRequest。
 * @param 是否应关闭单击外部回调 模态底部面板是否可以通过点击遮罩来关闭。
 */
@ExperimentalMaterial3Api
fun 模态底部面板属性集( // ModalBottomSheetProperties
    是否应关闭按返回键回调: Boolean = true,
    是否应关闭单击外部回调: Boolean = true,
) =
    ModalBottomSheetProperties(
        shouldDismissOnBackPress = 是否应关闭按返回键回调,
        shouldDismissOnClickOutside = 是否应关闭单击外部回调,
    )

@ExperimentalMaterial3Api
val ModalBottomSheetProperties.是否应关闭按返回键回调: Boolean
    get() = this.shouldDismissOnBackPress

@ExperimentalMaterial3Api
val ModalBottomSheetProperties.是否应关闭单击外部回调: Boolean
    get()= this.shouldDismissOnClickOutside


/** [模态底部面板] 的默认值 */
@Immutable
@ExperimentalMaterial3Api
expect object 模态底部面板默认值 { // ModalBottomSheetDefaults

    /**  用于自定义 [模态底部面板] 行为的属性。 */
    val 属性集: ModalBottomSheetProperties

}

/**
 *  为 [模态底部面板] 创建并[remember]一个 [SheetState]。
 *
 * @param 跳过部分展开  当面板足够高时，是否跳过部分展开状态。如果为 true，面板将始终展开至 [Expanded] 状态，
 * 并在隐藏面板时（无论是通过编程方式还是用户交互）直接过渡到 [Hidden] 状态。
 * @param 确定值改变 Optional callback invoked to confirm or veto a pending state change.
 */
@Deprecated(
    message = "Use rememberBottomSheetState with Hidden initial value",
    replaceWith =
        ReplaceWith(
            "rememberBottomSheetState(initialValue = SheetValue.Hidden, " +
                    "enabledValues = if (skipPartiallyExpanded) setOf(SheetValue.Hidden, SheetValue.Expanded) " +
                    "else setOf(SheetValue.Hidden, SheetValue.PartiallyExpanded, SheetValue.Expanded), " +
                    "confirmValueChange = confirmValueChange)",
            "androidx.compose.material3.SheetValue",
        ),
)
@Composable
@ExperimentalMaterial3Api
fun 记住模态底部面板状态(
    跳过部分展开: Boolean = false,
    确定值改变: (SheetValue) -> Boolean = { true },
) =
    rememberModalBottomSheetState(
        skipPartiallyExpanded = 跳过部分展开,
        confirmValueChange = 确定值改变,
    )


