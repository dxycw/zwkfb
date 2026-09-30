package 安卓x.组合.材质3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirst
import androidx.compose.ui.util.fastFirstOrNull
import kotlin.math.max
import kotlin.math.min

/**
 * [Material Design snackbar](https://m3.material.io/components/snackbar/overview)
 *
 * Snackbars 在屏幕底部提供有关应用进程的简短消息。
 *
 * ![Snackbar image](https://developer.android.com/images/reference/androidx/compose/material3/snackbar.png)
 *
 * Snackbars 用于告知用户应用已经执行或将要执行的某个操作。它们会临时出现在屏幕底部，不应干扰用户体验，也不需要用户输入即可自动消失。
 *
 * 提示条 可以包含一个单独的操作。"关闭" 或 "取消" 操作是可选的。
 *
 * 包含操作的 提示条 在用户执行其他操作之前不应超时或自动消失。此处，将键盘焦点指示器移动到页面中可交互元素之间进行导航，
 * 不被视为一次操作。
 *
 * @param 修饰符 应用于此 提示条 的 [Modifier]。
 * @param 操作 作为 提示条 操作添加的操作/按钮组件。如果没有预定义的颜色，建议使用 [ColorScheme.inversePrimary]
 * 作为该操作的颜色。
 * @param 关闭操作 作为额外关闭辅助操作的操作/按钮组件，用于 提示条 无法自行消失时。如果没有预定义的颜色，
 * 建议使用 [ColorScheme.inverseOnSurface] 作为该操作的颜色。
 * @param 操作换行 操作是否应该放在单独的一行。对于操作文本较长的情况，建议使用此方式。
 * @param 形状 定义此 提示条 容器的形状。
 * @param 容器颜色 用于此 提示条 背景的颜色。使用 [Color.Transparent] 可设置为无颜色。
 * @param 内容颜色 此 提示条 内部内容的首选颜色。
 * @param 操作内容颜色 此 提示条 中可选 [操作] 的首选内容颜色。
 * @param 关闭操作内容颜色 此 提示条 中可选 [关闭操作] 的首选内容颜色。
 * @param 内容 用于显示应用已经执行或将要执行的操作的相关信息的内容。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 提示条(
    修饰符: Modifier = Modifier,
    操作: @Composable (() -> Unit)? = null,
    关闭操作: @Composable (() -> Unit)? = null,
    操作换行: Boolean = false,
    形状: Shape = SnackbarDefaults.shape,
    容器颜色: Color = SnackbarDefaults.color,
    内容颜色: Color = SnackbarDefaults.contentColor,
    操作内容颜色: Color = SnackbarDefaults.actionContentColor,
    关闭操作内容颜色: Color = SnackbarDefaults.dismissActionContentColor,
    内容: @Composable () -> Unit,
) =
    Snackbar(
        modifier = 修饰符,
        action = 操作,
        dismissAction = 关闭操作,
        actionOnNewLine = 操作换行,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        actionContentColor = 操作内容颜色,
        dismissActionContentColor = 关闭操作内容颜色,
        content = 内容,
    )


/**
 * [Material Design snackbar](https://m3.material.io/components/snackbar/overview)
 *
 * Snackbars 在屏幕底部提供有关应用进程的简短消息。
 *
 * ![Snackbar image](https://developer.android.com/images/reference/androidx/compose/material3/snackbar.png)
 *
 * Snackbars 用于告知用户应用已经执行或将要执行的某个操作。它们会临时出现在屏幕底部，不应干扰用户体验，也不需要用户输入即可自动消失。
 *
 * 提示条 可以包含一个单独的操作。"关闭" 或 "取消" 操作是可选的。
 *
 * 包含操作的 提示条 在用户执行其他操作之前不应超时或自动消失。此处，将键盘焦点指示器移动到页面中可交互元素之间进行导航，
 * 不被视为一次操作。
 *
 * 此版本的 提示条 设计用于与 [提示条主机] 提供的 [SnackbarData] 配合使用，通常用在 [脚手架] 内部。
 *
 * @param 提示条数据 通过 [SnackbarHostState] 显示的当前 提示条 的数据。
 * @param 修饰符 应用于此 提示条 的 [Modifier]。
 * @param 操作换行 操作是否应该放在单独的一行。对于操作文本较长的情况，建议使用此方式。
 * @param 形状 定义此 提示条 容器的形状。
 * @param 容器颜色 用于此 提示条 背景的颜色。使用 [Color.Transparent] 可设置为无颜色。
 * @param 内容颜色 此 提示条 内部内容的首选颜色。
 * @param 操作颜色 提示条 操作的颜色。
 * @param 操作内容颜色 此 提示条 中可选操作的首选内容颜色。参见 [SnackbarVisuals.actionLabel]。
 * @param 关闭操作内容颜色 此 提示条 中可选关闭操作的首选内容颜色。参见 [SnackbarVisuals.withDismissAction]。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 提示条(
    提示条数据: SnackbarData,
    修饰符: Modifier = Modifier,
    操作换行: Boolean = false,
    形状: Shape = SnackbarDefaults.shape,
    容器颜色: Color = SnackbarDefaults.color,
    内容颜色: Color = SnackbarDefaults.contentColor,
    操作颜色: Color = SnackbarDefaults.actionColor,
    操作内容颜色: Color = SnackbarDefaults.actionContentColor,
    关闭操作内容颜色: Color = SnackbarDefaults.dismissActionContentColor,
) =
    Snackbar(
        snackbarData = 提示条数据,
        modifier = 修饰符,
        actionOnNewLine = 操作换行,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        actionColor = 操作颜色,
        actionContentColor = 操作内容颜色,
        dismissActionContentColor = 关闭操作内容颜色,
    )


/** 包含 [提示条] 使用的默认值。 */
object 提示条默认值 { // SnackbarDefaults

    /** 提示条 的默认形状。 */
    val 形状: Shape
        @Composable get() = SnackbarDefaults.shape

    /** 提示条 的默认颜色。 */
    val 颜色: Color
        @Composable get() = SnackbarDefaults.color

    /** 提示条 的默认内容颜色。 */
    val 内容颜色: Color
        @Composable get() = SnackbarDefaults.contentColor

    /** 提示条 的默认操作颜色。 */
    val 操作颜色: Color
        @Composable get() = SnackbarDefaults.actionColor

    /** 提示条 的默认操作内容颜色。 */
    val 操作内容颜色: Color
        @Composable get() = SnackbarDefaults.actionContentColor

    /** 提示条 的默认关闭操作内容颜色。 */
    val 关闭操作内容颜色: Color
        @Composable get() = SnackbarDefaults.dismissActionContentColor

}

