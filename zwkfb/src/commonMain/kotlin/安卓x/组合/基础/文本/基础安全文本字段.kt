package 安卓x.组合.基础.文本

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Density
import 安卓x.组合.基础.文本.输入.默认

/**
 * 基础安全文本字段 专为密码输入框而设计，是 [基础文本字段] 的预配置替代方案。它仅支持单行内容，
 * 并带有适用于输入安全内容的 [KeyboardOptions]、[InputTransformation] 和 [CodepointTransformation] 默认设置。
 * 此外，为了提高安全性，还禁用了剪切、复制和拖拽等部分上下文菜单操作。
 *
 * @param 状态 保存 [基础安全文本字段] 内部状态的 [TextFieldState] 对象。
 * @param 修饰符 此文本字段的可选 [Modifier]。
 * @param 已启用 控制 [基础安全文本字段] 的启用状态。当为 false 时，文本字段既不可编辑也不可聚焦，
 * 且文本字段中的内容不可被选中。
 * @param 只读 控制 [基础安全文本字段] 的可编辑状态。当为 true 时，文本字段不可修改，但用户仍可获取焦点。
 * 只读文本字段通常用于显示用户无法编辑的预填充表单。
 * @param 输入转换 可选的 [InputTransformation]，用于转换用户对 [TextFieldState] 所做的更改。
 * 该转换将应用于硬件和软件键盘事件、粘贴或拖拽文本、无障碍服务以及测试操作所产生的更改。当通过代码以编程方式更改 [状态]，
 * 或转换本身发生变更时，该转换不会被应用。如果在现有文本字段上更改转换，它将应用于下一次用户编辑，而不会立即影响当前的 [状态]。
 * @param 文本样式 编辑器中显示的文本内容的样式配置。
 * @param 键盘选项 包含 [KeyboardType] 和 [ImeAction] 等配置的软件键盘选项。
 * 此可组合项默认会为安全文本字段配置 [KeyboardOptions]，即禁用自动更正并将 [KeyboardType] 设置为 [KeyboardType.Password]。
 * @param 键盘操作回调 当用户按下输入法编辑器（IME）中的操作按钮，或按下硬件键盘上的回车键时调用。默认情况下此参数为 null，
 * 将执行接收到 IME 操作的默认行为，例如 [ImeAction.Done] 会关闭键盘，[ImeAction.Next] 会将焦点切换至屏幕上的下一个可聚焦项。
 * @param 文本布局回调 当文本布局变为可查询状态时执行的回调。该回调接收一个函数，此函数在布局可计算时返回 [TextLayoutResult]，
 * 不可计算时返回 null。该函数从快照状态对象中读取布局结果，并在布局结果变更时使其调用方失效。[TextLayoutResult]
 * 对象包含段落信息、文本尺寸、基线及其他详细信息。该回调可用于为文本添加额外的装饰或功能，例如在文本周围绘制光标或选区。
 * [Density] 作用域为创建给定文本布局时所使用的那个。
 * @param 交互源 表示此 TextField 的 [Interaction] 流的 [MutableInteractionSource]。如果你想观察 [Interaction]
 * 并根据不同的 [Interaction] 自定义此 TextField 的外观或行为，可以创建并传入你自己 remember 的 [MutableInteractionSource]。
 * @param 光标画笔 用于绘制光标的 [Brush]。如果提供的是 [Color.Unspecified] 的 [SolidColor]，则不会绘制光标。
 * @param 装饰器 允许在文本字段周围添加装饰，如图标、占位符、辅助提示信息等，并自动扩大文本字段的点击目标区域。
 * @param 文本混淆模式 确定隐藏输入文本的方法。
 * @param 文本混淆字符 隐藏文本时使用的字符。当 [文本混淆模式] 设置为 [TextObfuscationMode.Visible] 时，此设置无效。
 * @param 滚动状态 文本字段的滚动状态。由于 [基础安全文本字段] 始终为单行，此滚动状态始终控制水平滚动。
 */
// 这接收一个可组合 lambda，但它主要不是一个容器。
@Suppress("ComposableLambdaParameterPosition", "ComposableNaming")
@Composable
fun 基础安全文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    输入转换: InputTransformation? = null,
    文本样式: TextStyle = TextStyle.Default,
    键盘选项: KeyboardOptions = 安卓x.组合.基础.文本.键盘选项.安全文本字段,
    键盘操作回调: KeyboardActionHandler? = null,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    交互源: MutableInteractionSource? = null,
    光标画笔: Brush = SolidColor(Color.Black),
    装饰器: TextFieldDecorator? = null,
    // 最后一个参数不能是函数类型，除非它被设计为常用作尾随 lambda。
    文本混淆模式: TextObfuscationMode = TextObfuscationMode.默认,
    文本混淆字符: Char = 默认隐藏字符,
    滚动状态: ScrollState = rememberScrollState(),
) {
    BasicSecureTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        inputTransformation = 输入转换,
        textStyle = 文本样式,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        onTextLayout = 文本布局回调,
        interactionSource = 交互源,
        cursorBrush = 光标画笔,
        decorator = 装饰器,
        // 最后一个参数不能是函数类型，除非它被设计为常用作尾随 lambda。
        textObfuscationMode = 文本混淆模式,
        textObfuscationCharacter = 文本混淆字符,
        scrollState = 滚动状态,
    )
}

private const val 默认隐藏字符: Char = '\u2022'

