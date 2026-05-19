package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Density

/**
 * [Material Design filled text field for secure content](https://m3.material.io/components/text-fields/overview)
 *
 * 文本输入框允许用户在界面中输入文本。[安全文本字段] 专为密码输入框而设计。它仅支持单行内容，并带有适合输入安全内容的默认设置。
 * 此外，为了提高安全性，还禁用了剪切、复制和拖拽等部分上下文菜单操作。
 *
 * 填充式文本输入框比轮廓式文本输入框具有更强的视觉强调效果，使其在周围有其他内容和组件时更加突出。
 * 如需轮廓式版本，请参见 [轮廓安全文本字段]。
 *
 * @param 状态 [TextFieldState] 对象，用于保存文本输入框的内部编辑状态。
 * @param 修饰符 应用于此文本输入框的 [Modifier]。
 * @param 已启用 控制此文本输入框的启用状态。当为 `false` 时，该组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也呈禁用状态。
 * @param 文本样式 应用于输入文本的样式。默认为 [LocalTextStyle]。
 * @param 标签位置 标签的位置。参见 [TextFieldLabelPosition]。
 * @param 标签 与此文本输入框一起显示的可选标签。默认文本样式在收起时使用 [Typography.bodySmall]，
 * 在展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当输入文本为空时显示的可选占位符。默认文本样式使用 [Typography.bodyLarge]。
 * @param 前导图标 在文本输入框容器开头显示的可选前置图标。
 * @param 尾随图标 在文本输入框容器末尾显示的可选后置图标。
 * @param 前缀 在文本输入框中，显示在输入文本之前的可选前缀。
 * @param 后缀 在文本输入框中，显示在输入文本之后的可选后缀。
 * @param 辅助文本 显示在文本输入框下方的可选辅助文本。
 * @param 是否错误 指示文本输入框的当前值是否处于错误状态。当为 `true` 时，文本输入框的各个组件将以错误颜色显示，
 * 并向无障碍服务播报错误信息。
 * @param 输入转换 可选的 [InputTransformation]，用于转换用户对 [TextFieldState] 所做的更改。
 * 该转换将应用于硬件和软件键盘事件、粘贴或拖放文本、无障碍服务以及测试所做的更改。在以编程方式更改 [状态] 或更改转换本身时，
 * 不会应用该转换。如果在现有文本输入框上更改转换，它将应用于下一次用户编辑，而不会立即影响当前的 [状态]。
 * @param 文本混淆模式 用于隐藏输入文本的方法。
 * @param 文本混淆字符 隐藏文本时使用的字符。当 [文本混淆模式] 设置为 [TextObfuscationMode.Visible] 时，该设置无效。
 * @param 键盘选项 包含键盘类型（[KeyboardType]）和输入法操作（[ImeAction]）等配置的软键盘选项。
 * 此组件默认会为安全文本输入框配置 [KeyboardOptions]，即禁用自动更正并将 [KeyboardType] 设置为 [KeyboardType.Password]。
 * @param 键盘操作回调 当用户按下输入法编辑器（IME）中的操作按钮，或在硬件键盘上按下回车键时调用。默认情况下，
 * 此参数为 null，将执行接收到的 IME 操作的默认行为，例如 [ImeAction.Done] 会关闭键盘，[ImeAction.Next]
 * 会将焦点切换到屏幕上下一个可聚焦的项。
 * @param 文本布局回调 当文本布局变为可查询状态时执行的回调。该回调接收一个函数，如果布局可以计算，则返回 [TextLayoutResult]；
 * 如果无法计算，则返回 null。该函数从快照状态对象中读取布局结果，并在布局结果变化时使其调用方失效。[TextLayoutResult]
 * 对象包含段落信息、文本尺寸、基线和其他详细信息。[Density] 作用域是创建给定文本布局时所使用的那个。
 * @param 形状 定义此文本输入框容器的形状。
 * @param 颜色集 用于解析此文本输入框在不同状态下所用颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
 * @param 内容内边距 应用于内部文本输入框的内边距，用于将其与文本输入框周围的其他元素分隔开。请注意，
 * 如果内边距值与文本输入框的尺寸约束或布局不兼容，则可能不会被采纳。参见 [TextFieldDefaults.contentPaddingWithLabel]
 * 和 [TextFieldDefaults.contentPaddingWithoutLabel]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发送此文本输入框的 [Interaction]。
 * 你可以用它来改变文本输入框的外观或预览不同状态下的文本输入框。请注意，如果传入 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 安全文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    文本样式: TextStyle = LocalTextStyle.current,
    标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Attached(),
    标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    输入转换: InputTransformation? = null,
    文本混淆模式: TextObfuscationMode = TextObfuscationMode.RevealLastTyped,
    文本混淆字符: Char = 默认混淆字符,
    键盘选项: KeyboardOptions = 安全文本字段键盘选项,
    键盘操作回调: KeyboardActionHandler? = null,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    形状: Shape = TextFieldDefaults.shape,
    颜色集: TextFieldColors = TextFieldDefaults.colors(),
    内容内边距: PaddingValues =
        if (标签 == null || 标签位置 is TextFieldLabelPosition.Above) {
            TextFieldDefaults.contentPaddingWithoutLabel()
        } else {
            TextFieldDefaults.contentPaddingWithLabel()
        },
    交互源: MutableInteractionSource? = null,
) {
    SecureTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        textStyle = 文本样式,
        labelPosition = 标签位置,
        label = 标签,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        prefix = 前缀,
        suffix = 后缀,
        supportingText = 辅助文本,
        isError = 是否错误,
        inputTransformation = 输入转换,
        textObfuscationMode = 文本混淆模式,
        textObfuscationCharacter = 文本混淆字符,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        onTextLayout = 文本布局回调,
        shape = 形状,
        colors = 颜色集,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

/**
 * [Material Design outlined text field for secure content](https://m3.material.io/components/text-fields/overview)
 *
 * 文本输入框允许用户在界面中输入文本。[轮廓安全文本字段] 专为密码输入框而设计。它仅支持单行内容，
 * 并带有适合输入安全内容的默认设置。此外，为了提高安全性，还禁用了剪切、复制和拖拽等部分上下文菜单操作。
 *
 * 轮廓式文本输入框比填充式文本输入框的视觉强调效果更弱。当它们出现在表单等许多文本输入框集中放置的地方时，
 * 其较低的强调效果有助于简化布局。如需填充式版本，请参见 [安全文本字段]。
 *
 * @param 状态 [TextFieldState] 对象，用于保存文本输入框的内部编辑状态。
 * @param 修饰符 应用于此文本输入框的 [Modifier]。
 * @param 已启用 控制此文本输入框的启用状态。当为 `false` 时，该组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也呈禁用状态。
 * @param 文本样式 应用于输入文本的样式。默认为 [LocalTextStyle]。
 * @param 标签位置 标签的位置。参见 [TextFieldLabelPosition]。
 * @param 标签 与此文本输入框一起显示的可选标签。默认文本样式在收起时使用 [Typography.bodySmall]，
 * 在展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当输入文本为空时显示的可选占位符。默认文本样式使用 [Typography.bodyLarge]。
 * @param 前导图标 在文本输入框容器开头显示的可选前置图标。
 * @param 尾随图标 在文本输入框容器末尾显示的可选后置图标。
 * @param 前缀 在文本输入框中，显示在输入文本之前的可选前缀。
 * @param 后缀 在文本输入框中，显示在输入文本之后的可选后缀。
 * @param 辅助文本 显示在文本输入框下方的可选辅助文本。
 * @param 是否错误 指示文本输入框的当前值是否处于错误状态。当为 `true` 时，文本输入框的各个组件将以错误颜色显示，
 * 并向无障碍服务播报错误信息。
 * @param 输入转换 可选的 [InputTransformation]，用于转换用户对 [TextFieldState] 所做的更改。
 * 该转换将应用于硬件和软件键盘事件、粘贴或拖放文本、无障碍服务以及测试所做的更改。在以编程方式更改 [状态] 或更改转换本身时，
 * 不会应用该转换。如果在现有文本输入框上更改转换，它将应用于下一次用户编辑，而不会立即影响当前的 [状态]。
 * @param 文本混淆模式 用于隐藏输入文本的方法。
 * @param 文本混淆字符 隐藏文本时使用的字符。当 [文本混淆模式] 设置为 [TextObfuscationMode.Visible] 时，该设置无效。
 * @param 键盘选项 包含键盘类型（[KeyboardType]）和输入法操作（[ImeAction]）等配置的软键盘选项。
 * 此组件默认会为安全文本输入框配置 [KeyboardOptions]，即禁用自动更正并将 [KeyboardType] 设置为 [KeyboardType.Password]。
 * @param 键盘操作回调 当用户按下输入法编辑器（IME）中的操作按钮，或在硬件键盘上按下回车键时调用。默认情况下，
 * 此参数为 null，将执行接收到的 IME 操作的默认行为，例如 [ImeAction.Done] 会关闭键盘，[ImeAction.Next]
 * 会将焦点切换到屏幕上下一个可聚焦的项。
 * @param 文本布局回调 当文本布局变为可查询状态时执行的回调。该回调接收一个函数，如果布局可以计算，则返回 [TextLayoutResult]；
 * 如果无法计算，则返回 null。该函数从快照状态对象中读取布局结果，并在布局结果变化时使其调用方失效。[TextLayoutResult]
 * 对象包含段落信息、文本尺寸、基线和其他详细信息。[Density] 作用域是创建给定文本布局时所使用的那个。
 * @param 形状 定义此文本输入框容器的形状。
 * @param 颜色集 用于解析此文本输入框在不同状态下所用颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
 * @param 内容内边距 应用于内部文本输入框的内边距，用于将其与文本输入框周围的其他元素分隔开。请注意，
 * 如果内边距值与文本输入框的尺寸约束或布局不兼容，则可能不会被采纳。参见 [TextFieldDefaults.contentPaddingWithLabel]
 * 和 [TextFieldDefaults.contentPaddingWithoutLabel]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发送此文本输入框的 [Interaction]。
 * 你可以用它来改变文本输入框的外观或预览不同状态下的文本输入框。请注意，如果传入 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 轮廓安全文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    文本样式: TextStyle = LocalTextStyle.current,
    标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Attached(),
    标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    输入转换: InputTransformation? = null,
    文本混淆模式: TextObfuscationMode = TextObfuscationMode.RevealLastTyped,
    文本混淆字符: Char = 默认混淆字符,
    键盘选项: KeyboardOptions = 安全文本字段键盘选项,
    键盘操作回调: KeyboardActionHandler? = null,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    形状: Shape = OutlinedTextFieldDefaults.shape,
    颜色集: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    内容内边距: PaddingValues = OutlinedTextFieldDefaults.contentPadding(),
    交互源: MutableInteractionSource? = null,
) {
    OutlinedSecureTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        textStyle = 文本样式,
        labelPosition = 标签位置,
        label = 标签,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        prefix = 前缀,
        suffix = 后缀,
        supportingText = 辅助文本,
        isError = 是否错误,
        inputTransformation = 输入转换,
        textObfuscationMode = 文本混淆模式,
        textObfuscationCharacter = 文本混淆字符,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        onTextLayout = 文本布局回调,
        shape = 形状,
        colors = 颜色集,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

private val 安全文本字段键盘选项 =
    KeyboardOptions(autoCorrectEnabled = false, keyboardType = KeyboardType.Password)

private const val 默认混淆字符: Char = '\u2022'
