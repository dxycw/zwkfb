package 安卓x.组合.材质3

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldLineLimits.MultiLine
import androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

/**
 * [Material Design filled text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本字段 允许用户在界面中输入文本。它们通常出现在表单和对话框中。
 *
 * ![Filled text field image](https://developer.android.com/images/reference/androidx/compose/material3/filled-text-field.png)
 *
 * 如果你需要轮廓式版本，请查看 [OutlinedTextField]。如需专门用于密码或其他安全内容的文本字段，请查看 [SecureTextField]。
 *
 * 这个 [文本字段] 的重载版本使用 [TextFieldState] 来跟踪其文本内容以及光标或选区的位置。
 *
 * @param 状态 用于保存文本字段内部编辑状态的 [TextFieldState] 对象。
 * @param 修饰符 要应用于此文本字段的 [Modifier]。
 * @param 已启用 控制此文本字段的启用状态。当设置为 `false` 时，该组件将不响应用户输入，并且在视觉上呈现为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 只读 控制文本字段的可编辑状态。当设置为 true 时，文本字段无法被修改，但用户仍可以聚焦该字段并从中复制文本。
 * 只读文本字段通常用于显示用户无法编辑的预填充表单。
 * @param 文本样式 应用于输入文本的样式。默认为 [LocalTextStyle]。
 * @param 标签位置 标签的位置。参见 [TextFieldLabelPosition]。
 * @param 标签 与此文本字段一起显示的可选标签。默认文本样式在最小化时使用 [Typography.bodySmall]，在展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当输入文本为空时显示的可选占位提示文本。默认文本样式使用 [Typography.bodyLarge]。
 * @param 前导图标 可选的前置图标，显示在文本字段容器的起始位置。
 * @param 尾随图标 可选的后置图标，显示在文本字段容器的末尾位置。
 * @param 前缀 可选的前缀，显示在文本字段中输入文本之前。
 * @param 后缀 可选的后缀，显示在文本字段中输入文本之后。
 * @param 辅助文本 可选的辅助文本，显示在文本字段下方。
 * @param 是否错误 指示文本字段当前值是否处于错误状态。当设置为 `true` 时，文本字段的各个组件将以错误颜色显示，并向无障碍服务播报错误信息。
 * @param 输入转换 可选的 [InputTransformation]，用于转换用户对 [TextFieldState] 所做的更改。
 * 该转换将应用于硬件和软件键盘事件、粘贴或拖放文本、无障碍服务以及测试所产生的更改。不会在通过代码以编程方式更改 [状态] 时应用，
 * 也不会在转换本身发生变更时应用。如果在现有文本字段上更改转换规则，它将应用于下一次用户编辑，而不会立即影响当前的 [状态]。
 * @param 输出转换 可选的 [OutputTransformation]，用于转换文本字段内容的呈现方式。
 * @param 键盘选项 包含键盘类型 [KeyboardType] 和输入法操作 [ImeAction] 等配置的软件键盘选项。
 * @param 键盘操作回调 当用户按下输入法编辑器（IME）中的操作按钮，或在硬件键盘上按下回车键时调用。默认情况下此参数为 null，
 * 将执行接收到的 IME 操作的默认行为，例如：[ImeAction.Done] 会关闭键盘，[ImeAction.Next] 会将焦点切换到屏幕上下一个可聚焦的项。
 * @param 行限制 文本字段应为 [SingleLine]（单行，水平滚动并忽略换行符），还是 [MultiLine]（多行，垂直增长和滚动）。
 * 如果传入 [SingleLine]，文本中的所有换行符（'\n'）将被替换为普通空格（' '）。
 * @param 文本布局回调 当文本布局变为可查询状态时执行的回调。该回调接收一个函数，此函数在布局可以计算时返回 [TextLayoutResult]，
 * 无法计算时则返回 null。该函数从快照状态对象中读取布局结果，并在布局结果发生变化时使其调用方失效。[TextLayoutResult]
 * 对象包含段落信息、文本尺寸、基线和其他细节。[Density] 作用域是创建该文本布局时所使用的那个。
 * @param 滚动状态 管理文本字段水平或垂直滚动的滚动状态。如果 [行限制] 为 [SingleLine]，则该文本字段被视为单行，
 * 具有水平滚动行为；否则，文本字段将变为垂直可滚动。
 * @param 形状 定义此文本字段容器的形状。
 * @param 颜色集 用于解析此文本字段在不同状态下所使用的颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
 * @param 内容内边距 应用于内部文本字段的内边距，用于将其与文本字段周围的其他元素分隔开。请注意，如果这些内边距值与文本字段的尺寸约束或布局不兼容，
 * 则可能不会被采用。参见 [TextFieldDefaults.contentPaddingWithLabel] 和 [TextFieldDefaults.contentPaddingWithoutLabel]。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送此文本字段的 [Interaction]。
 * 你可以使用它来更改文本字段的外观，或在不同状态下预览文本字段。请注意，即使传入 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 文本字段(
    状态: TextFieldState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = LocalTextStyle.current,
    标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Inside(),
    标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    输入转换: InputTransformation? = null,
    输出转换: OutputTransformation? = null,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作回调: KeyboardActionHandler? = null,
    行限制: TextFieldLineLimits = TextFieldLineLimits.Default,
    文本布局回调: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null,
    滚动状态: ScrollState = rememberScrollState(),
    形状: Shape = TextFieldDefaults.shape,
    颜色集: TextFieldColors = TextFieldDefaults.colors(),
    内容内边距: PaddingValues = 文本字段默认值.默认内容内边距(标签, 标签位置),
    交互源: MutableInteractionSource? = null,
) =
    TextField(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
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
        outputTransformation = 输出转换,
        keyboardOptions = 键盘选项,
        onKeyboardAction = 键盘操作回调,
        lineLimits = 行限制,
        onTextLayout = 文本布局回调,
        scrollState = 滚动状态,
        shape = 形状,
        colors = 颜色集,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )

/**
 * [Material Design filled text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本字段允许用户在界面中输入文本。它们通常出现在表单和对话框中。
 * 填充式文本字段相比轮廓式文本字段具有更强的视觉强调效果，当周围有其他内容和组件时，它们会更加醒目突出。
 *
 * ![Filled text field image](https://developer.android.com/images/reference/androidx/compose/material3/filled-text-field.png)
 *
 * 如果你需要轮廓式版本，请查看 [OutlinedTextField]。
 *
 * 如果你除了输入文本的变化外，还想观察光标位置、选区范围或输入法组合状态，请改用带有 [TextFieldValue] 参数的 TextField 重载版本。
 *
 * @param 值 要在文本字段中显示的输入文本。
 * @param 值改变回调 当输入服务更新文本时触发的回调。更新后的文本将作为该回调的参数传入。
 * @param 修饰符 要应用于此文本字段的 [Modifier]。
 * @param 已启用 控制此文本字段的启用状态。当设置为 `false` 时，该组件将不响应用户输入，并且在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 只读 控制文本字段的可编辑状态。当设置为 `true` 时，文本字段无法被修改，但用户仍可以聚焦该字段并从中复制文本。
 * 只读文本字段通常用于显示用户无法编辑的预填充表单。
 * @param 文本样式 应用于输入文本的样式。默认为 [LocalTextStyle]。
 * @param 标签 与此文本字段一起显示的可选标签。默认文本样式在最小化时使用 [Typography.bodySmall]，在展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当文本字段获得焦点且输入文本为空时显示的可选占位提示文本。内部 [文本] 的默认文本样式为 [Typography.bodyLarge]。
 * @param 前导图标 可选的前置图标，显示在文本字段容器的起始位置。
 * @param 尾随图标 可选的后置图标，显示在文本字段容器的末尾位置。
 * @param 前缀 可选的前缀，显示在文本字段中输入文本之前。
 * @param 后缀 可选的后缀，显示在文本字段中输入文本之后。
 * @param 辅助文本 可选的辅助文本，显示在文本字段下方。
 * @param 是否错误 指示文本字段当前值是否处于错误状态。如果设置为 true，标签、底部指示器和后置图标默认将以错误颜色显示。
 * @param 视觉转换 转换输入值 [值] 的视觉表现形式。例如，你可以使用
 * [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation] 来创建密码文本字段。
 * 默认情况下不应用任何视觉转换。
 * @param 键盘选项 包含键盘类型（[KeyboardType]）和输入法操作（[ImeAction]）等配置的软件键盘选项。
 * @param 键盘操作 当输入服务发出 IME 操作时，将调用相应的回调。请注意，此 IME 操作可能与你指定的 [KeyboardOptions.imeAction] 不同。
 * @param 单行 当设置为 `true` 时，此文本字段将变为水平滚动的单行文本字段，而不再自动换行到多行。键盘将被告知不将回车键显示为 [ImeAction]。
 * 请注意，[最大行数] 参数将被忽略，因为最大行数属性会自动设置为 1。
 * @param 最大行数 以最大可见行数表示的最大高度。要求满足 1 <= [最小行数] <= [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 最小行数 以最小可见行数表示的最小高度。要求满足 1 <= [最小行数] <= [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送此文本字段的 [Interaction]。
 * 你可以使用它来更改文本字段的外观，或在不同状态下预览文本字段。请注意，即使传入 `null`，交互仍会在内部发生。
 * @param 形状 定义此文本字段容器的形状。
 * @param 颜色集 用于解析此文本字段在不同状态下所使用的颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 文本字段(
    值: String,
    值改变回调: (String) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = LocalTextStyle.current,
    标签: @Composable (() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    视觉转换: VisualTransformation = VisualTransformation.None,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作: KeyboardActions = KeyboardActions.Default,
    单行: Boolean = false,
    最大行数: Int = if (单行) 1 else Int.MAX_VALUE,
    最小行数: Int = 1,
    交互源: MutableInteractionSource? = null,
    形状: Shape = TextFieldDefaults.shape,
    颜色集: TextFieldColors = TextFieldDefaults.colors(),
) =
    TextField(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        textStyle = 文本样式,
        label = 标签,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        prefix = 前缀,
        suffix = 后缀,
        supportingText = 辅助文本,
        isError = 是否错误,
        visualTransformation = 视觉转换,
        keyboardOptions = 键盘选项,
        keyboardActions = 键盘操作,
        singleLine = 单行,
        maxLines = 最大行数,
        minLines = 最小行数,
        interactionSource = 交互源,
        shape = 形状,
        colors = 颜色集,
    )

/**
 * [Material Design filled text field](https://m3.material.io/components/text-fields/overview)
 *
 * 文本字段允许用户在界面中输入文本。它们通常出现在表单和对话框中。
 * 填充式文本字段相比轮廓式文本字段具有更强的视觉强调效果，当周围有其他内容和组件时，它们会更加醒目突出。
 *
 * ![Filled text field image](https://developer.android.com/images/reference/androidx/compose/material3/filled-text-field.png)
 *
 * 如果你需要轮廓式版本，请查看 [OutlinedTextField]。
 *
 * 这个重载版本提供了对输入文本、光标位置、选区范围和输入法组合状态的访问。如果你只想观察输入文本的变化，请改用带有 [String] 参数的 TextField 重载版本。
 *
 * @param 值 要在文本字段中显示的输入 [TextFieldValue]。
 * @param 值改变回调 当输入服务更新 [TextFieldValue] 中的值时触发的回调。更新后的 [TextFieldValue] 将作为该回调的参数传入。
 * @param 修饰符 要应用于此文本字段的 [Modifier]。
 * @param 已启用 控制此文本字段的启用状态。当设置为 `false` 时，该组件将不响应用户输入，并且在视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 只读 控制文本字段的可编辑状态。当设置为 `true` 时，文本字段无法被修改，但用户仍可以聚焦该字段并从中复制文本。
 * 只读文本字段通常用于显示用户无法编辑的预填充表单。
 * @param 文本样式 应用于输入文本的样式。默认为 [LocalTextStyle]。
 * @param 标签 与此文本字段一起显示的可选标签。默认文本样式在最小化时使用 [Typography.bodySmall]，在展开时使用 [Typography.bodyLarge]。
 * @param 占位符 当文本字段获得焦点且输入文本为空时显示的可选占位提示文本。内部 [文本] 的默认文本样式为 [Typography.bodyLarge]。
 * @param 前导图标 可选的前置图标，显示在文本字段容器的起始位置。
 * @param 尾随图标 可选的后置图标，显示在文本字段容器的末尾位置。
 * @param 前缀 可选的前缀，显示在文本字段中输入文本之前。
 * @param 后缀 可选的后缀，显示在文本字段中输入文本之后。
 * @param 辅助文本 可选的辅助文本，显示在文本字段下方。
 * @param 是否错误 指示文本字段当前值是否处于错误状态。如果设置为 true，标签、底部指示器和后置图标默认将以错误颜色显示。
 * @param 视觉转换 转换输入值 [值] 的视觉表现形式。例如，你可以使用
 * [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation] 来创建密码文本字段。
 * 默认情况下不应用任何视觉转换。
 * @param 键盘选项 包含键盘类型（[KeyboardType]）和输入法操作（[ImeAction]）等配置的软件键盘选项。
 * @param 键盘操作 当输入服务发出 IME 操作时，将调用相应的回调。请注意，此 IME 操作可能与你指定的 [KeyboardOptions.imeAction] 不同。
 * @param 单行 当设置为 `true` 时，此文本字段将变为水平滚动的单行文本字段，而不再自动换行到多行。键盘将被告知不将回车键显示为 [ImeAction]。
 * 请注意，[最大行数] 参数将被忽略，因为最大行数属性会自动设置为 1。
 * @param 最大行数 以最大可见行数表示的最大高度。要求满足 1 <= [最小行数] <= [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 最小行数 以最小可见行数表示的最小高度。要求满足 1 <= [最小行数] <= [最大行数]。当 [单行] 为 true 时，此参数将被忽略。
 * @param 交互源 可选的提升式 [MutableInteractionSource]，用于观察和发送此文本字段的 [Interaction]。
 * 你可以使用它来更改文本字段的外观，或在不同状态下预览文本字段。请注意，即使传入 `null`，交互仍会在内部发生。
 * @param 形状 定义此文本字段容器的形状。
 * @param 颜色集 用于解析此文本字段在不同状态下所使用的颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 文本字段(
    值: TextFieldValue,
    值改变回调: (TextFieldValue) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    只读: Boolean = false,
    文本样式: TextStyle = LocalTextStyle.current,
    标签: @Composable (() -> Unit)? = null,
    占位符: @Composable (() -> Unit)? = null,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    前缀: @Composable (() -> Unit)? = null,
    后缀: @Composable (() -> Unit)? = null,
    辅助文本: @Composable (() -> Unit)? = null,
    是否错误: Boolean = false,
    视觉转换: VisualTransformation = VisualTransformation.None,
    键盘选项: KeyboardOptions = KeyboardOptions.Default,
    键盘操作: KeyboardActions = KeyboardActions.Default,
    单行: Boolean = false,
    最大行数: Int = if (单行) 1 else Int.MAX_VALUE,
    最小行数: Int = 1,
    交互源: MutableInteractionSource? = null,
    形状: Shape = TextFieldDefaults.shape,
    颜色集: TextFieldColors = TextFieldDefaults.colors(),
) =
    TextField(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        readOnly = 只读,
        textStyle = 文本样式,
        label = 标签,
        placeholder = 占位符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        prefix = 前缀,
        suffix = 后缀,
        supportingText = 辅助文本,
        isError = 是否错误,
        visualTransformation = 视觉转换,
        keyboardOptions = 键盘选项,
        keyboardActions = 键盘操作,
        singleLine = 单行,
        maxLines = 最大行数,
        minLines = 最小行数,
        interactionSource = 交互源,
        shape = 形状,
        colors = 颜色集,
    )


/** 从文本字段顶部到标签顶部的内边距，以及从输入字段底部到文本字段底部的内边距。 */
/*@VisibleForTesting*/
internal val TextFieldWithLabelVerticalPadding = 8.dp
