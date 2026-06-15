package 安卓x.组合.材质3

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BasicAlertDialogOverride
import androidx.compose.material3.BasicAlertDialogOverrideScope
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DefaultBasicAlertDialogOverride.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ComponentOverrideApi
import androidx.compose.material3.LocalBasicAlertDialogOverride
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties

/**
 * [Material Design basic dialog](https://m3.material.io/components/dialogs/overview)
 *
 * 对话框在用户流程中提供重要的提示信息。它们可以要求执行操作、传递信息，或帮助用户完成任务。
 *
 * ![Basic dialog image](https://developer.android.com/images/reference/androidx/compose/material3/basic-dialog.png)
 *
 * 对话框会根据可用空间来定位其按钮（通常是 [文本按钮]）。默认情况下，它会尝试将按钮水平并排放置，如果空间不足，则会回退到垂直排列。
 *
 * @param 关闭请求回调 当用户尝试通过点击对话框外部或按下返回按钮来关闭对话框时调用。当点击关闭按钮时不会调用此方法。
 * @param 确认按钮 用于确认提议的操作的按钮，从而解决触发对话框的问题。对话框不会为此按钮设置任何事件，因此需要由调用者来设置。
 * @param 修饰符 要应用于此对话框的 [Modifier]。
 * @param 关闭按钮 用于关闭对话框的按钮。对话框不会为此按钮设置任何事件，因此需要由调用方来设置。
 * @param 图标 可选图标，将显示在 [标题] 上方；如果未提供标题，则显示在 [文本] 上方。
 * @param 标题 标题，用于说明对话框的用途。标题不是必需的，因为 [文本] 中可能已包含足够的信息。
 * @param 文本 文本，用于呈现与对话框用途相关的详细信息。
 * @param 形状 定义此对话框容器的形状
 * @param 容器颜色 此对话框背景所使用的颜色。使用 [Color.Transparent] 表示无颜色（透明）。
 * @param 图标内容颜色 图标使用的内容颜色。
 * @param 标题内容颜色 标题使用的内容颜色。
 * @param 文本内容颜色 文本使用的内容颜色。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 色调海拔值越高，在浅色主题下颜色越深，在深色主题下颜色越浅。另请参阅：[表面]。
 * @param 属性 通常用于进一步配置对话框的平台特定属性。
 * @see 基础警告对话框
 */
@Suppress("ComposableNaming")
@Composable
fun 警告对话框(
    关闭请求回调: () -> Unit,
    确认按钮: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    关闭按钮: @Composable (() -> Unit)? = null,
    图标: @Composable (() -> Unit)? = null,
    标题: @Composable (() -> Unit)? = null,
    文本: @Composable (() -> Unit)? = null,
    形状: Shape = AlertDialogDefaults.shape,
    容器颜色: Color = AlertDialogDefaults.containerColor,
    图标内容颜色: Color = AlertDialogDefaults.iconContentColor,
    标题内容颜色: Color = AlertDialogDefaults.titleContentColor,
    文本内容颜色: Color = AlertDialogDefaults.textContentColor,
    色调阴影: Dp = AlertDialogDefaults.TonalElevation,
    属性: DialogProperties = DialogProperties(),
){
    AlertDialog(
        onDismissRequest = 关闭请求回调,
        confirmButton = 确认按钮,
        modifier = 修饰符,
        dismissButton = 关闭按钮,
        icon = 图标,
        title = 标题,
        text = 文本,
        shape = 形状,
        containerColor = 容器颜色,
        iconContentColor = 	图标内容颜色,
        titleContentColor = 标题内容颜色,
        textContentColor = 文本内容颜色,
        tonalElevation = 色调阴影,
        properties = 属性,
    )
}

/**
 * [Basic alert dialog dialog](https://m3.material.io/components/dialogs/overview)
 *
 * 对话框在用户流程中提供重要的提示。它们可以要求用户执行操作、传达信息，或帮助用户完成任务。
 *
 * ![Basic dialog image](https://developer.android.com/images/reference/androidx/compose/material3/basic-dialog.png)
 *
 * 此基础警告对话框接受由调用方定义的任意内容。请注意，您的内容需要自行定义样式。
 *
 * 默认情况下，显示的对话框具有 Material Design 规范所定义的最小高度和宽度。如有需要，可通过提供 `width` 或 `height` [Modifier] 来覆盖这些约束。
 *
 * @param 关闭请求回调 当用户尝试通过点击对话框外部或按返回键关闭对话框时调用。点击关闭按钮时不会触发此回调。
 * @param 修饰符 要应用于此对话框内容的 [Modifier]。
 * @param 属性 通常用于进一步配置对话框的平台特定属性。
 * @param 内容 对话框的内容。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ComponentOverrideApi::class)
@ExperimentalMaterial3Api
@Composable
fun 基础警告对话框(
    关闭请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    属性: DialogProperties = DialogProperties(),
    内容: @Composable () -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = 关闭请求回调,
        modifier = 修饰符,
        properties = 属性,
        content = 内容,
    )
}

/**
 * 此重写提供了 [BasicAlertDialog] 组件的默认行为。
 *
 * 未指定重写时使用的 [BasicAlertDialogOverride]。
 */
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalMaterial3ComponentOverrideApi
object 默认基础警告对话框覆盖 : 基础警告对话框覆盖 { // DefaultBasicAlertDialogOverride

    @Composable
    override fun BasicAlertDialogOverrideScope.基础警告对话框() { // BasicAlertDialog
        this.BasicAlertDialog()
    }

}

/**
 * [Basic alert dialog dialog](https://m3.material.io/components/dialogs/overview)
 *
 * 对话框在用户流程中提供重要的提示。它们可以要求用户执行操作、传达信息，或帮助用户完成任务。
 *
 * ![Basic dialog image](https://developer.android.com/images/reference/androidx/compose/material3/basic-dialog.png)
 *
 * 此基础警告对话框接受由调用方定义的任意内容。请注意，您的内容需要自行定义样式。
 *
 * 默认情况下，显示的对话框具有 Material Design 规范所定义的最小高度和宽度。如有需要，可通过提供 `width` 或 `height` [Modifier] 来覆盖这些约束。
 *
 * @param 关闭请求回调 当用户尝试通过点击对话框外部或按返回键关闭对话框时调用。点击关闭按钮时不会触发此回调。
 * @param 修饰符 要应用于此对话框内容的 [Modifier]。
 * @param 属性 通常用于进一步配置对话框的平台特定属性。
 * @param 内容 对话框的内容。
 */
@Suppress("ComposableNaming")
@Deprecated(
    "Use BasicAlertDialog instead",
    replaceWith = ReplaceWith("BasicAlertDialog(onDismissRequest, modifier, properties, content)"),
)
@ExperimentalMaterial3Api
@Composable
fun 警告对话框(
    关闭请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    属性: DialogProperties = DialogProperties(),
    内容: @Composable () -> Unit,
) = AlertDialog(
    onDismissRequest = 关闭请求回调,
    modifier = 修饰符,
    properties = 属性,
    content = 内容,
)

/** 包含 [警告对话框] 和 [基础警告对话框] 使用的默认值。 */
object 警告对话框默认值 { // AlertDialogDefaults

    /** 警告对话框的默认形状。 */
    val 形状: Shape
        @Composable get() = AlertDialogDefaults.shape

    /** 警告对话框的默认图标大小。 */
    val 图标大小: Dp = AlertDialogDefaults.IconSize

    /** 警告对话框的默认容器颜色。 */
    val 容器颜色: Color
        @Composable get() = AlertDialogDefaults.containerColor

    /** 警告对话框的默认图标颜色。 */
    val 图标内容颜色: Color
        @Composable get() = AlertDialogDefaults.iconContentColor

    /** 警告对话框的默认标题颜色。 */
    val 标题内容颜色: Color
        @Composable get() = AlertDialogDefaults.titleContentColor

    /** 警告对话框的默认文本颜色。 */
    val 文本内容颜色: Color
        @Composable get() = AlertDialogDefaults.textContentColor

    /** 警告对话框的默认色调海拔。 */
    val 色调阴影: Dp = AlertDialogDefaults.TonalElevation

}


/**
 * 允许库重写 [基础警告对话框] 组件行为的接口。
 *
 * 要重写此组件，请实现该接口的成员函数，然后在 Compose 层级结构中将实现提供给 [LocalBasicAlertDialogOverride]。
 */
@ExperimentalMaterial3ComponentOverrideApi
interface 基础警告对话框覆盖 { // BasicAlertDialogOverride

    /** 由 [基础警告对话框] 组件调用的行为函数。 */
    @Suppress("ComposableNaming")
    @Composable
    fun BasicAlertDialogOverrideScope.基础警告对话框()

}

/**
 * [基础警告对话框] 可用的参数。
 *
 * @param 关闭请求回调 当用户尝试通过点击对话框外部或按返回键关闭对话框时调用。点击关闭按钮时不会触发此回调。
 * @param 修饰符 要应用于此对话框内容的 [Modifier]。
 * @param 属性 通常用于进一步配置对话框的平台特定属性。
 * @param 内容 对话框的内容。
 */
@ExperimentalMaterial3ComponentOverrideApi
class 基础警告对话框覆盖范围 // BasicAlertDialogOverrideScope
internal constructor(
    val 关闭请求回调: () -> Unit,
    val 修饰符: Modifier = Modifier,
    val 属性: DialogProperties = DialogProperties(),
    val 内容: @Composable () -> Unit,
)

/** 包含当前选中的 [BasicAlertDialogOverride] 的 CompositionLocal。 */
@ExperimentalMaterial3ComponentOverrideApi
val 本地基础警告对话框覆盖: ProvidableCompositionLocal<BasicAlertDialogOverride> =
    LocalBasicAlertDialogOverride
