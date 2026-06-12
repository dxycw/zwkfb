package 安卓x.组合.界面.窗口

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

/**
 * 用于自定义 [对话框] 行为的属性。
 *
 * @property 关闭返回键回调 指定在 Android 上按下返回键，或在桌面端按下 Esc 键时，是否可以关闭该弹窗。
 * 如果为 true，按下返回键将触发 onDismissRequest 回调。
 * @property 关闭单击外部回调 指定点击对话框外部区域时，是否可以关闭该对话框。如果为 `true`，
 * 点击对话框外部将触发 `onDismissRequest` 回调。
 * @property 使用平台默认宽度 指定对话框内容的宽度是否应限制为平台默认值（该值小于屏幕宽度）。
 * **可能仅用作命名参数**。
 */
@Immutable
class 对话框属性( // DialogProperties
    关闭返回键回调: Boolean = true,
    关闭单击外部回调: Boolean = true,
    使用平台默认宽度: Boolean = true,
) {
    private val _属性 = DialogProperties(
        dismissOnBackPress = 关闭返回键回调,
        dismissOnClickOutside = 关闭单击外部回调,
        usePlatformDefaultWidth = 使用平台默认宽度
    )

    val 关闭返回键回调: Boolean = _属性.dismissOnBackPress
    val 关闭单击外部回调: Boolean = _属性.dismissOnClickOutside
    val 使用平台默认宽度: Boolean = _属性.usePlatformDefaultWidth
}

/**
 * 打开一个包含指定内容的对话框。
 *
 * 对话框是一种小型窗口，用于提示用户做出决策或输入额外信息。对话框不会占满整个屏幕，通常用于模态事件，
 * 需要用户先执行某个操作后才能继续。
 *
 * 只要对话框仍处于组合（composition）层级结构中，它就会保持可见。为了让用户能够关闭对话框，`[关闭请求回调]`
 * 的实现中应包含将该对话框从组合层级中移除的逻辑。
 *
 * @param 关闭请求回调 当用户尝试关闭对话框时执行。
 * @param 属性 用于进一步自定义此对话框行为的 [对话框属性]。
 * @param 内容 要在对话框内部显示的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 对话框( // Dialog
    关闭请求回调: () -> Unit,
    属性: DialogProperties = DialogProperties(),
    内容: @Composable () -> Unit,
){
    Dialog(
        onDismissRequest = 关闭请求回调,
        properties = 属性,
        content = 内容
    )
}
