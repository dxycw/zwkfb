package 安卓x.组合.材质3

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.DatePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties

/**
 * [Material Design date picker dialog](https://m3.material.io/components/date-pickers/overview)
 *
 * 用于显示 [DatePicker] 的对话框。日期选择器允许用户选择一个日期。
 *
 * @param 关闭请求回调 当用户尝试通过点击对话框外部或按下返回键来关闭对话框时调用。点击取消按钮时不会调用此回调。
 * @param 确认按钮 用于确认所提议操作的按钮，从而解决触发对话框的问题。对话框不会为此按钮设置任何事件，
 * 也不会控制其启用状态，因此这些需要由调用者自行设置。
 * @param 修饰符 要应用于此对话框内容的 [Modifier]。
 * @param 关闭按钮 用于关闭对话框的按钮。对话框不会为此按钮设置任何事件，因此这些需要由调用者自行设置。
 * @param 形状 定义对话框表面的形状及其阴影。
 * @param 色调阴影 当 [DatePickerColors.containerColor] 为 [ColorScheme.surface] 时，较高的海拔高度
 * 在浅色主题下会产生更深的颜色，在深色主题下则会产生更浅的颜色。
 * @param 颜色集 用于解析此日期选择器在不同状态下所用颜色的 [DatePickerColors]。参见 [DatePickerDefaults.colors]。
 * @param 属性集 通常是平台特定的属性，用于进一步配置对话框。
 * @param 内容 对话框的内容（例如一个 [DatePicker]）。
 */
@Suppress("ComposableNaming")
@Composable
fun 日期选择器对话框(
    关闭请求回调: () -> Unit,
    确认按钮: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    关闭按钮: @Composable (() -> Unit)? = null,
    形状: Shape = DatePickerDefaults.shape,
    色调阴影: Dp = DatePickerDefaults.TonalElevation,
    颜色集: DatePickerColors = DatePickerDefaults.colors(),
    属性集: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
    内容: @Composable ColumnScope.() -> Unit,
) =
    DatePickerDialog(
        onDismissRequest = 关闭请求回调,
        confirmButton = 确认按钮,
        modifier = 修饰符,
        dismissButton = 关闭按钮,
        shape = 形状,
        tonalElevation = 色调阴影,
        colors = 颜色集,
        properties = 属性集,
        content = 内容,
    )
