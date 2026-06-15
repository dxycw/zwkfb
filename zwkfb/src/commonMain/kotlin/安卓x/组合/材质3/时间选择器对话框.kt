package 安卓x.组合.材质3

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.TimePickerDialogDefaults
import androidx.compose.material3.TimePickerDisplayMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties
import kotlin.jvm.JvmInline

/**
 * [Material Design time picker dialog](https://m3.material.io/components/time-pickers/overview)
 *
 * 用于显示 [时间选择器] 的对话框。时间选择器允许用户选择一个时间。
 *
 * @param 关闭请求回调 当用户尝试通过点击对话框外部或按下返回键来关闭对话框时调用。点击取消按钮时不会调用此回调。
 * @param 确认按钮 用于确认所提议操作的按钮，从而解决触发对话框的问题。对话框不会为此按钮设置任何事件，
 * 也不会控制其启用状态，因此这些需要由调用者自行设置。
 * @param 标题 要在对话框顶部显示的标题。
 * @param 修饰符 要应用于此对话框内容的 [Modifier]。
 * @param 属性集 通常是平台特定的属性，用于进一步配置对话框。
 * @param 模式切换按钮 用于在时钟和文本输入模式之间切换的可选开关。
 * @param 关闭按钮 用于关闭对话框的按钮。对话框不会为此按钮设置任何事件，因此这些需要由调用者自行设置。
 * @param 形状 定义对话框表面的形状及其阴影。
 * @param 容器颜色 对话框容器的颜色。
 * @param 内容 对话框的内容（例如一个 [时间选择器]）。
 */
@Suppress("ComposableNaming")
@Composable
fun 时间选择器对话框(
    关闭请求回调: () -> Unit,
    确认按钮: @Composable () -> Unit,
    标题: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    属性集: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
    模式切换按钮: @Composable (() -> Unit)? = null,
    关闭按钮: @Composable (() -> Unit)? = null,
    形状: Shape = TimePickerDialogDefaults.shape,
    容器颜色: Color = TimePickerDialogDefaults.containerColor,
    内容: @Composable ColumnScope.() -> Unit,
) {
    TimePickerDialog(
        onDismissRequest = 关闭请求回调,
        confirmButton = 确认按钮,
        title = 标题,
        modifier = 修饰符,
        properties = 属性集,
        modeToggleButton = 模式切换按钮,
        dismissButton = 关闭按钮,
        shape = 形状,
        containerColor = 容器颜色,
        content = 内容,
    )
}


/** [TimePickerDialog] 的默认属性。 */
object 时间选择器对话框默认值 { // TimePickerDialogDefaults

    /** [TimePickerDialog] 的容器颜色。 */
    val 容器颜色
        @Composable get() = TimePickerDialogDefaults.containerColor

    /** [TimePickerDialog] 的形状颜色。 */
    val 形状
        @Composable get() = TimePickerDialogDefaults.shape

    /** 在 Picker 模式下显示 TimePicker 所需的最小屏幕高度。 */
    val 最小高度时间选择器: Dp = TimePickerDialogDefaults.MinHeightForTimePicker

    /**
     * 用于在时间选择器的 [TimePickerDisplayMode.Picker] 和 [TimePickerDisplayMode.Input] 两种显示模式之间切换的按钮。
     *
     * @param 显示模式改变回调 当按钮被点击时调用。
     * @param 显示模式 时间选择器的当前显示模式。
     * @param 修饰符 此按钮的 [Modifier]。
     */
    @Suppress("ComposableNaming")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun 显示模式切换(
        显示模式改变回调: () -> Unit,
        显示模式: TimePickerDisplayMode,
        修饰符: Modifier = Modifier,
    ) =
        TimePickerDialogDefaults.DisplayModeToggle(
            onDisplayModeChange = 显示模式改变回调,
            displayMode = 显示模式,
            modifier = 修饰符,
        )

    /**
     * 时间选择器对话框的标题。
     *
     * @param 修饰符 要应用于此标题的 [Modifier]。
     * @param 显示模式 时间选择器的当前显示模式。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 标题(显示模式: TimePickerDisplayMode, 修饰符: Modifier = Modifier) =
        TimePickerDialogDefaults.Title(displayMode = 显示模式, modifier = 修饰符)

}

/**
 * 表示 [TimePickerDialog] 内容的显示模式。
 *
 * 定义用户与时间选择器交互的不同方式，例如使用可视化的时钟式选择器或通过文本输入来输入时间。
 */
@Immutable
object 时间选择器显示模式{
    /** 时间选择器输入模式 */
    val 选择器 = TimePickerDisplayMode.Picker

    /** 时间文本输入模式 */
    val 输入 = TimePickerDisplayMode.Input
}