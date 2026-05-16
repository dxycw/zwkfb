package 安卓x.组合.基础.文本

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.*
import androidx.compose.foundation.text.input.TextFieldLineLimits.MultiLine
import androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density

private object 基本文本字段默认值 {
    val 光标画笔 = SolidColor(Color.Black)
}

/**
 * 基础的文本可组合项，提供一个可交互的文本输入框，可通过软件或硬件键盘接收文本输入，但不提供任何装饰（如提示或占位符）。
 *
 * 此可组合项的所有编辑状态都通过 [状态] 进行提升。每当该可组合项的内容通过用户输入或语义操作发生变化时，[TextFieldState.text] 都会得到更新。
 * 同样，所有对 [状态] 的编程式更新也会反映到此可组合项上。
 *
 * 如果你想为文本字段添加装饰（如图标等），并增大点击目标区域，请使用装饰器（decorator）。
 *
 * 如需过滤（例如仅允许数字、限制字符数量）或更改（例如将所有字符转换为大写）用户输入的内容，请使用 [InputTransformation]。
 *
 * 可以通过使用 [TextFieldLineLimits] 来限制 [基础文本字段] 的高度（以行数为单位）并选择滚动方向。
 *
 * 可组合项的滚动状态同样被提升，以便开发者观察和操控滚动行为，例如通过滚动到某个位置（无需聚焦）将搜索到的关键词带入视图，或更改选区。
 *
 * 也可以在内部包装一个现有的 TextFieldState，并通过一个更轻量的状态提升机制来暴露它：使用一个值来控制 TextField 的内容，
 * 以及一个 onValueChange 回调来将该值的变化通知出去。
 *
 * @param 状态 保存 [基础文本字段] 内部编辑状态的 [TextFieldState] 对象。
 * @param 修饰符 此文本字段的可选 [Modifier]。
 * @param 已启用 控制 [基础文本字段] 的启用状态。当设置为 `false` 时，文本字段将不可编辑且不可聚焦，其输入内容也无法被选中。
 * @param 只读 控制 [基础文本字段] 的可编辑状态。当设置为 `true` 时，文本字段无法被修改，但用户仍可以聚焦该字段并从中复制文本。
 * 只读文本字段通常用于显示用户无法编辑的预填充表单。
 * @param 输入转换 可选的 [InputTransformation]，用于转换用户对 [TextFieldState] 所做的更改。
 * 该转换将应用于硬件和软件键盘事件、粘贴或拖放文本、无障碍服务以及测试所产生的更改。不会在通过代码以编程方式更改 [状态] 时应用，
 * 也不会在转换本身发生变更时应用。如果在现有文本字段上更改转换规则，它将应用于下一次用户编辑，而不会立即影响当前的 [状态]。
 * @param 文本样式 编辑器中显示的文本内容的排版和图形样式配置。
 * @param 键盘选项 包含键盘类型（[KeyboardType]）和输入法操作（[ImeAction]）等配置的软件键盘选项。
 * @param 键盘操作回调 当用户按下输入法编辑器（IME）中的操作按钮，或在硬件键盘上按下回车键（前提是 [行限制] 配置
 * 为 [TextFieldLineLimits.SingleLine]）时调用。默认情况下此参数为 null，将执行接收到的 IME 操作的默认行为，
 * 例如：[ImeAction.Done] 会关闭键盘，[ImeAction.Next] 会将焦点切换到屏幕上下一个可聚焦的项。
 * @param 行限制 文本字段应为 [SingleLine]（单行，水平滚动并忽略换行符），还是 [MultiLine]（多行，垂直增长和滚动）。
 * 如果传入 [SingleLine]，文本中的所有换行符（'\n'）将被替换为普通空格（' '），以确保文本字段的内容以单行形式呈现。
 * @param 文本布局回调 当文本布局变为可查询状态时执行的回调。该回调接收一个函数，此函数在布局可以计算时返回 [TextLayoutResult]，
 * 无法计算时则返回 null。该函数从快照状态对象中读取布局结果，并在布局结果发生变化时使其调用方失效。[TextLayoutResult] 对象包
 * 含段落信息、文本尺寸、基线和其他细节。该回调可用于为文本添加额外的装饰或功能，例如在文本周围绘制光标或选区。[Density] 作用域
 * 是创建该文本布局时所使用的那个。
 * @param 交互源 表示此 TextField 的 [Interaction] 流的 [MutableInteractionSource]。
 * 如果你想观察 [Interaction] 并为不同的 [Interaction] 自定义此 TextField 的外观/行为，可以创建并传入你自己记住的 [MutableInteractionSource]。
 * @param 光标画笔 用于绘制光标的 [Brush]。如果提供的是带有 [Color.Unspecified] 的 [SolidColor]，则不会绘制光标。
 * @param 输出转换  用于转换文本字段内容呈现方式的 [OutputTransformation]。
 * @param 装饰器 允许在文本字段周围添加装饰，例如图标、占位提示文本、辅助信息等，并自动增大文本字段的点击目标区域。
 * @param 滚动状态 管理 TextField 水平或垂直滚动的滚动状态。如果 [行限制] 为 [SingleLine]，则该文本字段被视为单行，具有水平滚动行为；
 * 在其他情况下，文本字段将变为垂直可滚动。
 */
// 这接收一个可组合项 lambda，但它主要不是用作容器。
@Suppress("ComposableLambdaParameterPosition", "ComposableNaming")
@Composable
fun 基础文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    输入转换: InputTransformation? = null,
    文本样式: TextStyle = TextStyle.Default,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作回调: KeyboardActionHandler? = null,
    行限制: TextFieldLineLimits = TextFieldLineLimits.Default,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    交互源: MutableInteractionSource? = null,
    光标画笔: Brush = 基本文本字段默认值.光标画笔,
    输出转换: OutputTransformation? = null,
    装饰器: TextFieldDecorator? = null,
    滚动状态: ScrollState = rememberScrollState(),
    // 最后一个参数不能是函数，除非它打算被常用作尾随 lambda。
) {
    BasicTextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        inputTransformation = 输入转换,
        textStyle = 文本样式,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        lineLimits = 行限制,
        onTextLayout = 文本布局回调,
        interactionSource = 交互源,
        cursorBrush = 光标画笔,
        outputTransformation = 输出转换,
        decorator = 装饰器,
        scrollState = 滚动状态,
    )
}


/**
 * 基础可组合项，允许用户通过硬件或软件键盘编辑文本，但不提供任何装饰（如提示或占位符）。
 *
 * 每当用户编辑文本时，都会调用 [值改变回调]，并传入以 [String] 表示的最新状态，开发者需要使用该值来更新自己的状态。
 *
 * 与 [TextFieldValue] 重载版本不同，此可组合项不允许开发者控制选区、光标和文本组合信息。如需了解更多信息，请查看 [TextFieldValue]
 * 及相应的 [基础文本字段] 重载版本。
 *
 * 必须将提供给 [值改变回调] 的值回传给 [基础文本字段]，才能实际在输入框中显示并继续编辑该文本。你回传给输入框的值可能与
 * [值改变回调] 回调提供的值不同，但需注意以下事项：
 * - 新值必须立即（即下一帧之前）提供给 [基础文本字段]，否则文本字段可能出现显示异常，例如光标跳动。有关此要求的更多信息，请参阅
 * [这篇文章](https://developer.android.com/jetpack/compose/text/user-input#state-practices)。
 * - 回传给输入框的值可以与传递给 [值改变回调] 的值不同，但这可能会导致输入连接被重新启动，从而使用户看到键盘闪烁。例如，
 * 当你使用回调来过滤掉某些类型的输入时，这种情况是可以接受的；但在输入自由格式文本时，不建议在每次更新时都这样做。
 *
 * 此可组合项提供基础的文本编辑功能，但不包含任何装饰（如边框、提示/占位符）。基于设计系统的实现（如 Material Design 填充式文本字段）通常能
 * 满足大多数需求。此可组合项旨在需要为不同设计系统实现自定义方案时使用。
 *
 * @param 值 要在文本字段中显示的输入 [String] 文本。
 * @param 值改变回调 当输入服务更新文本时触发的回调。更新后的文本将作为该回调的参数传入。
 * @param 修饰符 此文本字段的可选 [Modifier]。
 * @param 已启用 控制 [基础文本字段] 的启用状态。当设置为 `false` 时，文本字段将不可编辑且不可聚焦，其输入内容也无法被选中。
 * @param 只读 控制 [基础文本字段] 的可编辑状态。当设置为 `true` 时，文本字段无法被修改，但用户仍可以聚焦该字段并从中复制文本。
 * 只读文本字段通常用于显示用户无法编辑的预填充表单。
 * @param 文本样式 在字符级别应用的样式配置，如颜色、字体等。
 * @param 键盘选项 包含键盘类型（[KeyboardType]）和输入法操作（[ImeAction]）等配置的软件键盘选项。
 * @param 键盘操作 当输入服务发出 IME 操作时，将调用相应的回调。请注意，此 IME 操作可能与你指定的 [KeyboardOptions.imeAction] 不同。
 * @param 单行 当设置为 `true` 时，此文本字段将变为水平滚动的单行文本字段，而不再自动换行到多行。键盘将被告知不将回车键显示为 [ImeAction]。
 * [最大行数] 和 [最小行数] 将被忽略，因为两者都会自动设置为 1。
 * @param 最大行数 以最大可见行数表示的最大高度。要求满足 1 <= [最小行数] <= [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 最小行数 以最小可见行数表示的最小高度。要求满足 1 <= [最小行数] <= [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 视觉转换 用于更改输入内容视觉表现形式的视觉转换过滤器。默认情况下不应用任何视觉转换。
 * @param 文本布局回调 当计算新的文本布局时执行的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、文本尺寸、基线和其他细节。
 * 该回调可用于为文本添加额外的装饰或功能，例如在文本周围绘制光标或选区。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送此文本字段的 [Interaction]。
 * 你可以使用它来更改文本字段的外观，或在不同状态下预览文本字段。请注意，即使传入 `null`，交互仍会在内部发生。
 * @param 光标画笔 用于绘制光标的 [Brush]。如果提供的是带有 [Color.Unspecified] 的 [SolidColor]，则不会绘制光标。
 * @param 装饰盒子 可组合项 lambda，允许在文本字段周围添加装饰，例如图标、占位提示文本、辅助信息等，并自动增大文本字段的点击目标区域。
 * 为了让你能够控制内部文本字段相对于装饰的位置，文本字段实现会将一个由框架控制的可组合参数 "innerTextField" 传入你提供的
 * decorationBox lambda 中。你必须恰好调用一次 innerTextField。
 */
@Suppress("ComposableNaming")
@Composable
fun 基础文本字段(
    值: String,
    值改变回调: (String) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = TextStyle.Default,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作: KeyboardActions = KeyboardActions.Default,
    单行: Boolean = false,
    最大行数: Int = if (单行) 1 else Int.MAX_VALUE,
    最小行数: Int = 1,
    视觉转换: VisualTransformation = VisualTransformation.None,
    文本布局回调: (TextLayoutResult) -> Unit = {},
    交互源: MutableInteractionSource? = null,
    光标画笔: Brush = SolidColor(Color.Black),
    装饰盒子: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
        @Composable { innerTextField -> innerTextField() },
) {
    BasicTextField(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        textStyle = 文本样式,
        keyboardOptions = 键盘选项,
        keyboardActions = 键盘操作,
        singleLine = 单行,
        maxLines = 最大行数,
        minLines = 最小行数,
        visualTransformation = 视觉转换,
        onTextLayout = 文本布局回调,
        interactionSource = 交互源,
        cursorBrush = 光标画笔,
        decorationBox = 装饰盒子,
    )
}

/**
 * 基础可组合项，允许用户通过硬件或软件键盘编辑文本，但不提供任何装饰（如提示或占位符）。
 *
 * 每当用户编辑文本时，都会调用 [值改变回调]，并传入以 [TextFieldValue] 表示的最新状态。[TextFieldValue] 包含用户输入的文本，
 * 以及选区、光标和文本组合信息。有关其内容的详细说明，请查看 [TextFieldValue]。
 *
 * 必须将提供给 [值改变回调] 的值回传给 [基础文本字段]，才能实际在输入框中显示并继续编辑该文本。你回传给输入框的值可能与
 * [值改变回调] 回调提供的值不同，但需注意以下事项：
 * - 新值必须立即（即下一帧之前）提供给 [基础文本字段]，否则文本字段可能出现显示异常，例如光标跳动。有关此要求的更多信息，请参阅
 * [这篇文章](https://developer.android.com/jetpack/compose/text/user-input#state-practices)。
 * - 回传给输入框的值可以与传递给 [值改变回调] 的值不同，但这可能会导致输入连接被重新启动，从而使用户看到键盘闪烁。例如，
 * 当你使用回调来过滤掉某些类型的输入时，这种情况是可以接受的；但在输入自由格式文本时，不建议在每次更新时都这样做。
 *
 * 此可组合项提供基础的文本编辑功能，但不包含任何装饰（如边框、提示/占位符）。基于设计系统的实现（如 Material Design 填充式文本字段）
 * 通常能满足大多数需求。此可组合项旨在需要为不同设计系统实现自定义方案时使用。
 *
 * @param 值 要在 [基础文本字段] 中显示的 [androidx.compose.ui.text.input.TextFieldValue]。
 * @param 值改变回调 当输入服务更新 [TextFieldValue] 中的值时调用。
 * @param 修饰符 此文本字段的可选 [Modifier]。
 * @param 已启用 控制 [基础文本字段] 的启用状态。当设置为 `false` 时，文本字段将不可编辑且不可聚焦，其输入内容也无法被选中。
 * @param 只读 控制 [基础文本字段] 的可编辑状态。当设置为 `true` 时，文本字段无法被修改，但用户仍可以聚焦该字段并从中复制文本。
 * 只读文本字段通常用于显示用户无法编辑的预填充表单。
 * @param 文本样式 在字符级别应用的样式配置，如颜色、字体等。
 * @param 键盘选项 包含键盘类型（[KeyboardType]）和输入法操作（[ImeAction]）等配置的软件键盘选项。
 * @param 键盘操作 当输入服务发出 IME 操作时，将调用相应的回调。请注意，此 IME 操作可能与你指定的 [KeyboardOptions.imeAction] 不同。
 * @param 单行 当设置为 `true` 时，此文本字段将变为水平滚动的单行文本字段，而不再自动换行到多行。键盘将被告知不将回车键显示为 [ImeAction]。
 * [最大行数] 和 [最小行数] 将被忽略，因为两者都会自动设置为 1。
 * @param 最大行数 以最大可见行数表示的最大高度。要求满足 1 <= [最小行数] <= [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 最小行数 以最小可见行数表示的最小高度。要求满足 1 <= [最小行数] <= [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 视觉转换 用于更改输入内容视觉表现形式的视觉转换过滤器。默认情况下不应用任何视觉转换。
 * @param 文本布局回调 当计算新的文本布局时执行的回调。回调提供的 [TextLayoutResult] 对象包含段落信息、文本尺寸、基线和其他细节。
 * 该回调可用于为文本添加额外的装饰或功能，例如在文本周围绘制光标或选区。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送此文本字段的 [Interaction]。
 * 你可以使用它来更改文本字段的外观，或在不同状态下预览文本字段。请注意，即使传入 `null`，交互仍会在内部发生。
 * @param 光标画笔 用于绘制光标的 [Brush]。如果提供的是带有 [Color.Unspecified] 的 [SolidColor]，则不会绘制光标。
 * @param 装饰盒子 可组合项 lambda，允许在文本字段周围添加装饰，例如图标、占位提示文本、辅助信息等，并自动增大文本字段的点击目标区域。
 * 为了让你能够控制内部文本字段相对于装饰的位置，文本字段实现会将一个由框架控制的可组合参数 "innerTextField" 传入你提供的
 * decorationBox lambda 中。你必须恰好调用一次 innerTextField。
 */
@Suppress("ComposableNaming")
@Composable
fun 基础文本字段(
    值: TextFieldValue,
    值改变回调: (TextFieldValue) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = TextStyle.Default,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作: KeyboardActions = KeyboardActions.Default,
    单行: Boolean = false,
    最大行数: Int = if (单行) 1 else Int.MAX_VALUE,
    最小行数: Int = 1,
    视觉转换: VisualTransformation = VisualTransformation.None,
    文本布局回调: (TextLayoutResult) -> Unit = {},
    交互源: MutableInteractionSource? = null,
    光标画笔: Brush = SolidColor(Color.Black),
    装饰盒子: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
        @Composable { innerTextField -> innerTextField() },
) {
    BasicTextField(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        textStyle = 文本样式,
        keyboardOptions = 键盘选项,
        keyboardActions = 键盘操作,
        singleLine = 单行,
        maxLines = 最大行数,
        minLines = 最小行数,
        visualTransformation = 视觉转换,
        onTextLayout = 文本布局回调,
        interactionSource = 交互源,
        cursorBrush = 光标画笔,
        decorationBox = 装饰盒子,
    )
}

