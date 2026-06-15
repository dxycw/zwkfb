package 安卓x.组合.材质3

import androidx.annotation.FloatRange
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldDecorator
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldLineLimits.MultiLine
import androidx.compose.foundation.text.input.TextFieldLineLimits.SingleLine
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.material3.TextFieldLabelScope
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import 安卓x.组合.基础.文本.基础文本字段

/** 包含 [文本字段] 使用的默认值。有关 [轮廓文本字段] 使用的默认值，请参见 [文本字段默认值]。*/
@Immutable
object 文本字段默认值 { // TextFieldDefaults

    /** [文本字段] 的默认形状。 */
    val 形状: Shape
        @Composable get() = TextFieldDefaults.shape

    /** 应用于 [文本字段] 的默认最小高度。请注意，你可以通过在文本字段上直接应用 `Modifier.heightIn` 来覆盖它。*/
    val 最小高度 = TextFieldDefaults.MinHeight

    /** 应用于 [文本字段] 的默认最小宽度。请注意，你可以通过在文本字段上直接应用 `Modifier.widthIn` 来覆盖它。*/
    val 最小宽度 = TextFieldDefaults.MinWidth

    /** [文本字段] 指示器线条在未聚焦状态下的默认粗细。 */
    val 未聚焦指示器厚度 = TextFieldDefaults.UnfocusedIndicatorThickness

    /** [文本字段] 指示器线条在聚焦状态下的默认粗细。 */
    val 聚焦指示器厚度 = TextFieldDefaults.FocusedIndicatorThickness

    /**
     * 用于创建自定义文本字段的装饰器，基于[Material Design filled text field](https://m3.material.io/components/text-fields/overview).
     *
     * 如果你的文本字段需要自定义 [文本字段] 未暴露的元素（例如指示器线条粗细），请考虑使用此装饰器来实现所需的设计。
     *
     * 例如，如果你想自定义底部指示器线条，可以向此装饰器的 [容器] 传入自定义的 [容器]。
     *
     * 此装饰器旨在与接受 [TextFieldDecorator] 参数的 [基础文本字段] 重载版本配合使用。对于使用 `decorationBox` 的
     * 其他 [基础文本字段] 重载版本，请参见 [装饰盒子]。
     *
     * @param 状态 用于保存文本字段内部编辑状态的 [TextFieldState] 对象。
     * @param 已启用 文本字段的启用状态。当设置为 `false` 时，此装饰器将在视觉上呈现为禁用状态。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 行限制 文本字段是 [SingleLine]（单行）还是 [MultiLine]（多行）。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 输出转换 用于转换文本字段内容呈现方式的 [OutputTransformation]。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 交互源 表示此文本字段的 [Interaction] 流的只读 [InteractionSource]。你必须先创建并传入你自己 `remember`
     * 的 [MutableInteractionSource] 实例到 [基础文本字段] 中，以便其分发事件。然后将同一实例传递给此装饰器，
     * 以观察 [Interaction] 并自定义文本字段在不同状态下的外观/行为。
     * @param 标签位置 标签的位置。参见 [TextFieldLabelPosition]。
     * @param 标签 与此文本字段一起显示的可选标签。默认文本样式在最小化时使用 [Typography.bodySmall]，在展开时使用 [Typography.bodyLarge]。
     * @param 占位符 当输入文本为空时显示的可选占位提示文本。默认文本样式使用 [Typography.bodyLarge]。
     * @param 前导图标 可选的前置图标，显示在文本字段容器的起始位置。
     * @param 尾随图标 可选的后置图标，显示在文本字段容器的末尾位置。
     * @param 前缀 可选的前缀，显示在文本字段中输入文本之前。
     * @param 后缀 可选的后缀，显示在文本字段中输入文本之后。
     * @param 辅助文本 可选的辅助文本，显示在文本字段下方。
     * @param 是否错误 指示文本字段当前值是否处于错误状态。当设置为 `true` 时，此装饰器将以其内容以错误颜色显示。
     * @param 颜色集 用于解析此文本字段装饰器在不同状态下所使用的颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
     * 注意：此参数仅影响装饰框中元素的颜色。[基础文本字段] 的元素（如文本颜色或光标颜色）不受影响，必须使用 [基础文本字段]
     * 的相关参数进行更改。
     * @param 内容内边距 输入框与装饰器周围元素之间的内边距。请注意，如果这些内边距值与文本字段的尺寸约束或布局不兼容，则可能不会被采用。
     * 参见 [TextFieldDefaults.contentPaddingWithLabel] 和 [TextFieldDefaults.contentPaddingWithoutLabel]。
     * @param 容器 绘制在文本字段后方的容器。默认情况下使用 [容器]。容器的默认颜色来自 [颜色集]。
     */
    @Composable
    fun 装饰器(
        状态: TextFieldState,
        已启用: Boolean,
        行限制: TextFieldLineLimits,
        输出转换: OutputTransformation?,
        交互源: InteractionSource,
        标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Attached(),
        标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        辅助文本: @Composable (() -> Unit)? = null,
        是否错误: Boolean = false,
        颜色集: TextFieldColors = TextFieldDefaults.colors(),
        内容内边距: PaddingValues =
            if (标签 == null || 标签位置 is TextFieldLabelPosition.Above) {
                TextFieldDefaults.contentPaddingWithoutLabel()
            } else {
                TextFieldDefaults.contentPaddingWithLabel()
            },
        容器: @Composable () -> Unit = {
            TextFieldDefaults.Container(
                enabled = 已启用,
                isError = 是否错误,
                interactionSource = 交互源,
                colors = 颜色集,
                shape = TextFieldDefaults.shape,
                focusedIndicatorLineThickness = TextFieldDefaults.FocusedIndicatorThickness,
                unfocusedIndicatorLineThickness = TextFieldDefaults.UnfocusedIndicatorThickness,
            )
        },
    ): TextFieldDecorator =
        TextFieldDefaults.decorator(
            state = 状态,
            enabled = 已启用,
            lineLimits = 行限制,
            outputTransformation = 输出转换,
            interactionSource = 交互源,
            labelPosition = 标签位置,
            label = 标签,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            supportingText = 辅助文本,
            isError = 是否错误,
            colors = 颜色集,
            contentPadding = 内容内边距,
            container = 容器,
        )


    /**
     * 用于为 [文本字段] 绘制默认容器的可组合项，底部带有一条指示器线条。你可以通过 [装饰器] 或 [装饰盒子] 将其应用
     * 到 [基础文本字段]，以基于 Material 填充式文本字段的样式创建自定义文本字段。[文本字段] 组件会自动应用它。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 交互源 文本字段的 [InteractionSource]。用于确定文本字段是否处于聚焦状态。
     * @param 修饰符 此容器的 [Modifier]。
     * @param 颜色集 用于解析文本字段颜色的 [TextFieldColors]。
     * @param 形状 此容器的形状。
     * @param 聚焦指示线厚度 文本字段聚焦时指示器线条的粗细。
     * @param 未聚焦指示线厚度 文本字段未聚焦时指示器线条的粗细。
     */
    @Suppress("ComposableNaming")
    @OptIn(ExperimentalFoundationStyleApi::class)
    @Composable
    fun 容器(
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        修饰符: Modifier = Modifier,
        颜色集: TextFieldColors = TextFieldDefaults.colors(),
        形状: Shape = TextFieldDefaults.shape,
        聚焦指示线厚度: Dp = TextFieldDefaults.FocusedIndicatorThickness,
        未聚焦指示线厚度: Dp = TextFieldDefaults.UnfocusedIndicatorThickness,
    ) {
        TextFieldDefaults.Container(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            modifier = 修饰符,
            colors = 颜色集,
            shape = 形状,
            focusedIndicatorLineThickness = 聚焦指示线厚度,
            unfocusedIndicatorLineThickness = 未聚焦指示线厚度,
        )
    }

    /**
     * 用于为 [文本字段] 绘制默认底部指示器线条的修饰符。你可以将其应用到 [安卓x.组合.基础.文本.基础文本字段]，
     * 以基于 Material 填充式文本字段的样式创建自定义文本字段。
     *
     * 考虑使用 [容器]，它会自动应用此修饰符以及其他文本字段容器样式。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 交互源 文本字段的 [InteractionSource]。用于确定文本字段是否处于聚焦状态。
     * @param 颜色集 [TextFieldColors] 用于解析文本字段的颜色。如果为 `null`，则默认为 [TextFieldDefaults.colors]。
     * @param 文本字段形状 文本字段容器的形状。用于裁剪指示器。如果为 `null`，则默认为 [TextFieldDefaults.shape]。
     * @param 聚焦指示线厚度 文本字段聚焦时指示器线条的粗细。
     * @param 未聚焦指示线厚度 文本字段未聚焦时指示器线条的粗细。
     */
    fun Modifier.指示线( // indicatorLine
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        颜色集: TextFieldColors? = null,
        文本字段形状: Shape? = null,
        聚焦指示线厚度: Dp = TextFieldDefaults.FocusedIndicatorThickness,
        未聚焦指示线厚度: Dp = TextFieldDefaults.UnfocusedIndicatorThickness,
    ) = this.indicatorLine(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            colors = 颜色集,
            textFieldShape = 文本字段形状,
            focusedIndicatorLineThickness = 聚焦指示线厚度,
            unfocusedIndicatorLineThickness = 未聚焦指示线厚度,
        )

    /**
     * 用于创建自定义文本字段的装饰框，基于[Material Design filled text field](https://m3.material.io/components/text-fields/overview).
     *
     * 如果你的文本字段需要自定义 [文本字段] 未暴露的元素，请考虑使用此装饰框来实现所需的设计。
     *
     * 例如，如果你想自定义底部指示器线条，可以向此装饰框的 [容器] 传入自定义的 [容器]。
     *
     * 此装饰框旨在与接受 `decorationBox` 参数的 [基础文本字段] 重载版本配合使用。对于使用 [TextFieldDecorator] 的
     * 其他 [基础文本字段] 重载版本，请参见 [装饰器]。
     *
     * @param 值 文本字段显示的输入 [String]。
     * @param 内部文本字段 此装饰框所包裹的输入文本字段。请从 [基础文本字段] 的 `decorationBox` lambda 中传入由框架
     * 控制的可组合参数 `innerTextField`。
     * @param 已启用 文本字段的启用状态。当设置为 `false` 时，此装饰框将在视觉上呈现为禁用状态。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 单行 指示这是单行还是多行文本字段。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 视觉转换 转换输入值 [值] 的视觉表现形式。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 交互源 表示此文本字段的 [Interaction] 流的只读 [InteractionSource]。你必须先创建并传入你自己 `remember`
     * 的 [MutableInteractionSource] 实例到 [基础文本字段] 中，以便其分发事件。然后将同一实例传递给此装饰框，
     * 以观察 [Interaction] 并自定义此文本字段在不同状态下的外观/行为。
     * @param 是否错误 指示文本字段当前值是否处于错误状态。当设置为 `true` 时，此装饰框将以其内容以错误颜色显示。
     * @param 标签 与此文本字段一起显示的可选标签。默认文本样式在最小化时使用 [Typography.bodySmall]，在展开时使用 [Typography.bodyLarge]。
     * @param 占位符 当文本字段获得焦点且输入文本为空时显示的可选占位提示文本。内部 [文本] 的默认文本样式为 [Typography.bodyLarge]。
     * @param 前导图标 可选的前置图标，显示在文本字段容器的起始位置。
     * @param 尾随图标 可选的后置图标，显示在文本字段容器的末尾位置。
     * @param 前缀 可选的前缀，显示在文本字段中输入文本之前。
     * @param 后缀 可选的后缀，显示在文本字段中输入文本之后。
     * @param 辅助文本 可选的辅助文本，显示在文本字段下方。
     * @param 形状 定义此装饰框容器的形状。
     * @param 颜色集 用于解析此文本字段装饰框在不同状态下所使用的颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
     * 注意：此参数仅影响装饰框中元素的颜色。[BasicTextField] 的元素（如文本颜色或光标颜色）不受影响，必须使用 [BasicTextField]
     * 的相关参数进行更改。
     * @param 内容内边距 输入框与装饰框周围元素之间的内边距。请注意，如果这些内边距值与文本字段的尺寸约束或布局不兼容，则可能不会被采用。
     * 参见 [TextFieldDefaults.contentPaddingWithLabel] 和 [TextFieldDefaults.contentPaddingWithoutLabel]。
     * @param 容器 绘制在文本字段后方的容器。默认情况下使用 [容器]。容器的默认颜色来自 [颜色集]。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 装饰盒子(
        值: String,
        内部文本字段: @Composable () -> Unit,
        已启用: Boolean,
        单行: Boolean,
        视觉转换: VisualTransformation,
        交互源: InteractionSource,
        是否错误: Boolean = false,
        标签: @Composable (() -> Unit)? = null,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        辅助文本: @Composable (() -> Unit)? = null,
        形状: Shape = TextFieldDefaults.shape,
        颜色集: TextFieldColors = TextFieldDefaults.colors(),
        内容内边距: PaddingValues =
            if (标签 == null) {
                TextFieldDefaults.contentPaddingWithoutLabel()
            } else {
                TextFieldDefaults.contentPaddingWithLabel()
            },
        容器: @Composable () -> Unit = {
            TextFieldDefaults.Container(
                enabled = 已启用,
                isError = 是否错误,
                interactionSource = 交互源,
                modifier = Modifier,
                colors = 颜色集,
                shape = 形状,
                focusedIndicatorLineThickness = TextFieldDefaults.FocusedIndicatorThickness,
                unfocusedIndicatorLineThickness = TextFieldDefaults.UnfocusedIndicatorThickness,
            )
        },
    ) {
        TextFieldDefaults.DecorationBox(
            value = 值,
            innerTextField = 内部文本字段,
            enabled = 已启用,
            singleLine = 单行,
            visualTransformation = 视觉转换,
            interactionSource = 交互源,
            isError = 是否错误,
            label = 标签,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            supportingText = 辅助文本,
            shape = 形状,
            colors = 颜色集,
            contentPadding = 内容内边距,
            container = 容器,
        )
    }

    /**
     * [文本字段] 中带有内部标签时输入框的默认内容内边距。请注意，顶部内边距表示聚焦状态下标签上方的内边距。输入框直接放置在标签下方。
     *
     * 水平内边距表示输入框与前置/后置图标（如果存在）之间的距离；如果没有图标，则表示与容器水平边缘之间的距离。
     */
    fun 内容内边距带标签(
        开始: Dp = 16.dp,
        结束: Dp = 16.dp,
        上: Dp = 8.dp,
        下: Dp = 8.dp,
    ): PaddingValues = TextFieldDefaults.contentPaddingWithLabel(start = 开始, end = 结束, top = 上, bottom = 下)

    /**
     * [文本字段] 中当标签为 null 或位于 [TextFieldLabelPosition.Above]（上方）时，输入框的默认内容内边距。
     *
     * 水平内边距表示输入框与前置/后置图标（如果存在）之间的距离；如果没有图标，则表示与容器水平边缘之间的距离。
     */
    fun 内容内边距无标签(
        开始: Dp = 16.dp,
        上: Dp = 16.dp,
        结束: Dp = 16.dp,
        下: Dp = 16.dp,
    ): PaddingValues = TextFieldDefaults.contentPaddingWithoutLabel(start = 开始, top = 上, end = 结束, bottom = 下)

    /** 应用于 [文本字段] 和 [轮廓文本字段] 辅助文本的默认内边距。更多详情请参见 [PaddingValues]。*/
    // TODO(246775477): 考虑将此设为公开（public）。
    internal fun 辅助文本内边距(
        开始: Dp = 16.dp,
        上: Dp = 4.dp,
        结束: Dp = 16.dp,
        下: Dp = 0.dp,
    ): PaddingValues = PaddingValues(start = 开始, top = 上, end = 结束, bottom = 下)

    /**
     * 创建一个 [TextFieldColors]，表示 [文本字段] 中使用的默认输入文本、容器和内容颜色（包括标签、占位符、图标等）。
     */
    @Composable
    fun 颜色集() = TextFieldDefaults.colors()

    /**
     * 创建一个 [TextFieldColors]，表示 [文本字段] 中使用的默认输入文本、容器和内容颜色（包括标签、占位符、图标等）。
     *
     * @param 聚焦文本颜色 此文本字段在聚焦状态下输入文本所使用的颜色。
     * @param 未聚焦文本颜色 此文本字段在未聚焦状态下输入文本所使用的颜色。
     * @param 禁用文本颜色 此文本字段在禁用状态下输入文本所使用的颜色。
     * @param 错误文本颜色 此文本字段在错误状态下输入文本所使用的颜色。
     * @param 聚焦容器颜色 此文本字段在聚焦状态下的容器颜色。
     * @param 未聚焦容器颜色 此文本字段在未聚焦状态下的容器颜色。
     * @param 禁用容器颜色 此文本字段在禁用状态下的容器颜色。
     * @param 错误容器颜色 此文本字段在错误状态下的容器颜色。
     * @param 光标颜色 此文本字段的光标颜色。
     * @param 错误光标颜色 此文本字段在错误状态下的光标颜色。
     * @param 选择颜色集 此文本字段的输入文本被选中时使用的颜色。
     * @param 聚焦指示器颜色 此文本字段在聚焦状态下的指示器颜色。
     * @param 未聚焦指示器颜色 此文本字段在未聚焦状态下的指示器颜色。
     * @param 禁用指示器颜色 此文本字段在禁用状态下的指示器颜色。
     * @param 错误指示器颜色 此文本字段在错误状态下的指示器颜色。
     * @param 聚焦前导图标颜色 此文本字段在聚焦状态下的前置图标颜色。
     * @param 未聚焦前导图标颜色 此文本字段在未聚焦状态下的前置图标颜色。
     * @param 禁用前导图标颜色 此文本字段在禁用状态下的前置图标颜色。
     * @param 错误前导图标颜色 此文本字段在错误状态下的前置图标颜色。
     * @param 聚焦尾随图标颜色 此文本字段在聚焦状态下的后置图标颜色。
     * @param 未聚焦尾随图标颜色 此文本字段在未聚焦状态下的后置图标颜色。
     * @param 禁用尾随图标颜色 此文本字段在禁用状态下的后置图标颜色。
     * @param 错误尾随图标颜色 此文本字段在错误状态下的后置图标颜色。
     * @param 聚焦标签颜色 此文本字段在聚焦状态下的标签颜色。
     * @param 未聚焦标签颜色 此文本字段在未聚焦状态下的标签颜色。
     * @param 禁用标签颜色 此文本字段在禁用状态下的标签颜色。
     * @param 错误标签颜色 此文本字段在错误状态下的标签颜色。
     * @param 聚焦占位符颜色 此文本字段在聚焦状态下的占位提示文本颜色。
     * @param 未聚焦占位符颜色 此文本字段在未聚焦状态下的占位提示文本颜色。
     * @param 禁用占位符颜色 此文本字段在禁用状态下的占位提示文本颜色。
     * @param 错误占位符颜色 此文本字段在错误状态下的占位提示文本颜色。
     * @param 聚焦辅助文本颜色 此文本字段在聚焦状态下的辅助文本颜色。
     * @param 未聚焦辅助文本颜色 此文本字段在未聚焦状态下的辅助文本颜色。
     * @param 禁用辅助文本颜色 此文本字段在禁用状态下的辅助文本颜色。
     * @param 错误辅助文本颜色 此文本字段在错误状态下的辅助文本颜色。
     * @param 聚焦前缀颜色 此文本字段在聚焦状态下的前缀颜色。
     * @param 未聚焦前缀颜色 此文本字段在未聚焦状态下的前缀颜色。
     * @param 禁用前缀颜色 此文本字段在禁用状态下的前缀颜色。
     * @param 错误前缀颜色 此文本字段在错误状态下的前缀颜色。
     * @param 聚焦后缀颜色 此文本字段在聚焦状态下的后缀颜色。
     * @param 未聚焦后缀颜色 此文本字段在未聚焦状态下的后缀颜色。
     * @param 禁用后缀颜色 此文本字段在禁用状态下的后缀颜色。
     * @param 错误后缀颜色 此文本字段在错误状态下的后缀颜色。
     */
    @Composable
    fun 颜色集(
        聚焦文本颜色: Color = Color.Unspecified,
        未聚焦文本颜色: Color = Color.Unspecified,
        禁用文本颜色: Color = Color.Unspecified,
        错误文本颜色: Color = Color.Unspecified,
        聚焦容器颜色: Color = Color.Unspecified,
        未聚焦容器颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        错误容器颜色: Color = Color.Unspecified,
        光标颜色: Color = Color.Unspecified,
        错误光标颜色: Color = Color.Unspecified,
        选择颜色集: TextSelectionColors? = null,
        聚焦指示器颜色: Color = Color.Unspecified,
        未聚焦指示器颜色: Color = Color.Unspecified,
        禁用指示器颜色: Color = Color.Unspecified,
        错误指示器颜色: Color = Color.Unspecified,
        聚焦前导图标颜色: Color = Color.Unspecified,
        未聚焦前导图标颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        错误前导图标颜色: Color = Color.Unspecified,
        聚焦尾随图标颜色: Color = Color.Unspecified,
        未聚焦尾随图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        错误尾随图标颜色: Color = Color.Unspecified,
        聚焦标签颜色: Color = Color.Unspecified,
        未聚焦标签颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        错误标签颜色: Color = Color.Unspecified,
        聚焦占位符颜色: Color = Color.Unspecified,
        未聚焦占位符颜色: Color = Color.Unspecified,
        禁用占位符颜色: Color = Color.Unspecified,
        错误占位符颜色: Color = Color.Unspecified,
        聚焦辅助文本颜色: Color = Color.Unspecified,
        未聚焦辅助文本颜色: Color = Color.Unspecified,
        禁用辅助文本颜色: Color = Color.Unspecified,
        错误辅助文本颜色: Color = Color.Unspecified,
        聚焦前缀颜色: Color = Color.Unspecified,
        未聚焦前缀颜色: Color = Color.Unspecified,
        禁用前缀颜色: Color = Color.Unspecified,
        错误前缀颜色: Color = Color.Unspecified,
        聚焦后缀颜色: Color = Color.Unspecified,
        未聚焦后缀颜色: Color = Color.Unspecified,
        禁用后缀颜色: Color = Color.Unspecified,
        错误后缀颜色: Color = Color.Unspecified,
    ): TextFieldColors =
        TextFieldDefaults.colors(
                focusedTextColor = 聚焦文本颜色,
                unfocusedTextColor = 未聚焦文本颜色,
                disabledTextColor = 禁用文本颜色,
                errorTextColor = 错误文本颜色,
                focusedContainerColor = 聚焦容器颜色,
                unfocusedContainerColor = 未聚焦容器颜色,
                disabledContainerColor = 禁用容器颜色,
                errorContainerColor = 错误容器颜色,
                cursorColor = 光标颜色,
                errorCursorColor = 错误光标颜色,
                selectionColors = 选择颜色集,
                focusedIndicatorColor = 聚焦指示器颜色,
                unfocusedIndicatorColor = 未聚焦指示器颜色,
                disabledIndicatorColor = 禁用指示器颜色,
                errorIndicatorColor = 错误指示器颜色,
                focusedLeadingIconColor = 聚焦前导图标颜色,
                unfocusedLeadingIconColor = 未聚焦前导图标颜色,
                disabledLeadingIconColor = 禁用前导图标颜色,
                errorLeadingIconColor = 错误前导图标颜色,
                focusedTrailingIconColor = 聚焦尾随图标颜色,
                unfocusedTrailingIconColor = 未聚焦尾随图标颜色,
                disabledTrailingIconColor = 禁用尾随图标颜色,
                errorTrailingIconColor = 错误尾随图标颜色,
                focusedLabelColor = 聚焦标签颜色,
                unfocusedLabelColor = 未聚焦标签颜色,
                disabledLabelColor = 禁用标签颜色,
                errorLabelColor = 错误标签颜色,
                focusedPlaceholderColor = 聚焦占位符颜色,
                unfocusedPlaceholderColor = 未聚焦占位符颜色,
                disabledPlaceholderColor = 禁用占位符颜色,
                errorPlaceholderColor = 错误占位符颜色,
                focusedSupportingTextColor = 聚焦辅助文本颜色,
                unfocusedSupportingTextColor = 未聚焦辅助文本颜色,
                disabledSupportingTextColor = 禁用辅助文本颜色,
                errorSupportingTextColor = 错误辅助文本颜色,
                focusedPrefixColor = 聚焦前缀颜色,
                unfocusedPrefixColor = 未聚焦前缀颜色,
                disabledPrefixColor = 禁用前缀颜色,
                errorPrefixColor = 错误前缀颜色,
                focusedSuffixColor = 聚焦后缀颜色,
                unfocusedSuffixColor = 未聚焦后缀颜色,
                disabledSuffixColor = 禁用后缀颜色,
                errorSuffixColor = 错误后缀颜色,
            )

    @Suppress("ComposableNaming")
    @Deprecated(
        message = "Renamed to TextFieldDefaults.Container",
        replaceWith =
            ReplaceWith(
                "Container(\n" +
                        "    enabled = enabled,\n" +
                        "    isError = isError,\n" +
                        "    interactionSource = interactionSource,\n" +
                        "    colors = colors,\n" +
                        "    shape = shape,\n" +
                        ")"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 容器盒子( // ContainerBox
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        颜色集: TextFieldColors,
        形状: Shape = TextFieldDefaults.shape,
    ) =
        TextFieldDefaults.ContainerBox(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            colors = 颜色集,
            shape = 形状,
        )

    @Deprecated(
        message = "Renamed to `OutlinedTextFieldDefaults.shape`",
        replaceWith =
            ReplaceWith(
                "OutlinedTextFieldDefaults.shape",
                "androidx.compose.material.OutlinedTextFieldDefaults",
            ),
        level = DeprecationLevel.WARNING,
    )
    val 轮廓形状: Shape
        @Composable get() = TextFieldDefaults.outlinedShape

    @Deprecated(
        message = "Renamed to `TextFieldDefaults.shape`",
        replaceWith = ReplaceWith("TextFieldDefaults.shape"),
        level = DeprecationLevel.WARNING,
    )
    val 填充形状: Shape
        @Composable get() = TextFieldDefaults.filledShape

    @Deprecated(
        message =
            "Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and " +
                    "`OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.",
        replaceWith = ReplaceWith("TextFieldDefaults.UnfocusedIndicatorThickness"),
        level = DeprecationLevel.WARNING,
    )
    val 未聚焦边框厚度 = TextFieldDefaults.UnfocusedBorderThickness

    @Deprecated(
        message =
            "Split into `TextFieldDefaults.FocusedIndicatorThickness` and " +
                    "`OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.",
        replaceWith = ReplaceWith("TextFieldDefaults.FocusedIndicatorThickness"),
        level = DeprecationLevel.WARNING,
    )
    val 聚焦边框厚度 = TextFieldDefaults.FocusedBorderThickness

    @Deprecated(
        message = "Renamed to `TextFieldDefaults.contentPaddingWithLabel`",
        replaceWith =
            ReplaceWith(
                "TextFieldDefaults.contentPaddingWithLabel(\n" +
                        "        start = start,\n" +
                        "        top = top,\n" +
                        "        end = end,\n" +
                        "        bottom = bottom,\n" +
                        "    )"
            ),
        level = DeprecationLevel.WARNING,
    )
    fun 文本字段带标签内边距(
        开始: Dp = 16.dp,
        结束: Dp = 16.dp,
        上: Dp = 8.dp,
        下: Dp = 8.dp,
    ): PaddingValues = TextFieldDefaults.textFieldWithLabelPadding(
        start = 开始, end = 结束, top = 上, bottom = 下)

    @Deprecated(
        message = "Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`",
        replaceWith =
            ReplaceWith(
                "TextFieldDefaults.contentPaddingWithoutLabel(\n" +
                        "        start = start,\n" +
                        "        top = top,\n" +
                        "        end = end,\n" +
                        "        bottom = bottom,\n" +
                        "    )"
            ),
        level = DeprecationLevel.WARNING,
    )
    fun 文本字段无标签内边距(
        开始: Dp = 16.dp,
        上: Dp = 16.dp,
        结束: Dp = 16.dp,
        下: Dp = 16.dp,
    ): PaddingValues =
        TextFieldDefaults.textFieldWithoutLabelPadding(
            start = 开始, top = 上, end = 结束, bottom = 下)

    @Deprecated(
        message = "Renamed to `OutlinedTextFieldDefaults.contentPadding`",
        replaceWith =
            ReplaceWith(
                "OutlinedTextFieldDefaults.contentPadding(\n" +
                        "        start = start,\n" +
                        "        top = top,\n" +
                        "        end = end,\n" +
                        "        bottom = bottom,\n" +
                        "    )",
                "androidx.compose.material.OutlinedTextFieldDefaults",
            ),
        level = DeprecationLevel.WARNING,
    )
    fun 轮廓文本字段内边距(
        开始: Dp = 16.dp,
        上: Dp = 16.dp,
        结束: Dp = 16.dp,
        下: Dp = 16.dp,
    ): PaddingValues =
        TextFieldDefaults.outlinedTextFieldPadding(
            start = 开始, top = 上, end = 结束, bottom = 下,)
}

/** 包含 [轮廓文本字段] 使用的默认值。有关 [文本字段] 使用的默认值，请参见 [文本字段默认值]。*/
@Immutable
object 轮廓文本字段默认值 { // OutlinedTextFieldDefaults

    /** [轮廓文本字段] 的默认形状。 */
    val 形状: Shape
        @Composable get() = OutlinedTextFieldDefaults.shape

    /** 应用于 [轮廓文本字段] 的默认最小高度。请注意，你可以通过在文本字段上直接应用 `Modifier.heightIn` 来覆盖它。*/
    val 最小高度 = OutlinedTextFieldDefaults.MinHeight

    /** 应用于 [轮廓文本字段] 的默认最小宽度。请注意，你可以通过在文本字段上直接应用 `Modifier.widthIn` 来覆盖它。*/
    val 最小宽度 = OutlinedTextFieldDefaults.MinWidth

    /** [轮廓文本字段] 边框在未聚焦状态下的默认粗细。 */
    val 未聚焦指示器厚度 = OutlinedTextFieldDefaults.UnfocusedBorderThickness

    /** [轮廓文本字段] 边框在聚焦状态下的默认粗细。 */
    val 聚焦指示器厚度 = OutlinedTextFieldDefaults.FocusedBorderThickness

    /**
     * 用于创建自定义文本字段的装饰器，基于[Material Design outlined text field](https://m3.material.io/components/text-fields/overview).
     *
     * 如果你的文本字段需要自定义 [轮廓文本字段] 未暴露的元素（例如边框粗细），请考虑使用此装饰器来实现所需的设计。
     *
     * 例如，如果你想自定义边框粗细，可以向此装饰框的 [容器] 传入自定义的 [容器]。
     *
     * 此装饰器旨在与接受 [TextFieldDecorator] 参数的 [基础文本字段] 重载版本配合使用。对于使用 `decorationBox` 的
     * 其他 [基础文本字段] 重载版本，请参见 [装饰盒子]。
     *
     * @param 状态 用于保存文本字段内部编辑状态的 [TextFieldState] 对象。
     * @param 已启用 文本字段的启用状态。当设置为 `false` 时，此装饰器将在视觉上呈现为禁用状态。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 行限制 文本字段是 [SingleLine]（单行）还是 [MultiLine]（多行）。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 输出转换 用于转换文本字段内容呈现方式的 [OutputTransformation]。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 交互源 表示此文本字段的 [Interaction] 流的只读 [InteractionSource]。你必须先创建并传入你自己 `remember`
     * 的 [MutableInteractionSource] 实例到 [基础文本字段] 中，以便其分发事件。然后将同一实例传递给此装饰器，
     * 以观察 [Interaction] 并自定义文本字段在不同状态下的外观/行为。
     * @param 标签位置 标签的位置。参见 [TextFieldLabelPosition]。
     * @param 标签 与此文本字段一起显示的可选标签。默认文本样式在最小化时使用 [Typography.bodySmall]，在展开时使用 [Typography.bodyLarge]。
     * @param 占位符 当输入文本为空时显示的可选占位提示文本。默认文本样式使用 [Typography.bodyLarge]。
     * @param 前导图标 可选的前置图标，显示在文本字段容器的起始位置。
     * @param 尾随图标 可选的后置图标，显示在文本字段容器的末尾位置。
     * @param 前缀 可选的前缀，显示在文本字段中输入文本之前。
     * @param 后缀 可选的后缀，显示在文本字段中输入文本之后。
     * @param 辅助文本 可选的辅助文本，显示在文本字段下方。
     * @param 是否错误 指示文本字段当前值是否处于错误状态。当设置为 `true` 时，此装饰器将以其内容以错误颜色显示。
     * @param 颜色集 用于解析此文本字段装饰器在不同状态下所使用的颜色的 [TextFieldColors]。
     * 参见 [OutlinedTextFieldDefaults.colors]。注意：此参数仅影响装饰框中元素的颜色。[基础文本字段] 的元素
     * （如文本颜色或光标颜色）不受影响，必须使用 [基础文本字段] 的相关参数进行更改。
     * @param 内容内边距 输入框与装饰器周围元素之间的内边距。请注意，如果这些内边距值与文本字段的尺寸约束或布局不兼容，则可能不会被采用。
     * 参见 [OutlinedTextFieldDefaults.contentPadding]。
     * @param 容器 绘制在文本字段后方的容器。默认情况下它是透明的，仅包含边框。框架会自动在边框中添加切口以容纳 [标签]。
     * 容器的默认颜色来自 [颜色集]。
     */
    @Composable
    fun 装饰器(
        状态: TextFieldState,
        已启用: Boolean,
        行限制: TextFieldLineLimits,
        输出转换: OutputTransformation?,
        交互源: InteractionSource,
        标签位置: TextFieldLabelPosition = TextFieldLabelPosition.Attached(),
        标签: @Composable (TextFieldLabelScope.() -> Unit)? = null,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        辅助文本: @Composable (() -> Unit)? = null,
        是否错误: Boolean = false,
        颜色集: TextFieldColors = OutlinedTextFieldDefaults.colors(),
        内容内边距: PaddingValues = OutlinedTextFieldDefaults.contentPadding(),
        容器: @Composable () -> Unit = {
            OutlinedTextFieldDefaults.Container(
                enabled = 已启用,
                isError = 是否错误,
                interactionSource = 交互源,
                colors = 颜色集,
                shape = OutlinedTextFieldDefaults.shape,
                focusedBorderThickness = OutlinedTextFieldDefaults.FocusedBorderThickness,
                unfocusedBorderThickness = OutlinedTextFieldDefaults.UnfocusedBorderThickness,
            )
        },
    ): TextFieldDecorator =
        OutlinedTextFieldDefaults.decorator(
            state = 状态,
            enabled = 已启用,
            lineLimits = 行限制,
            outputTransformation = 输出转换,
            interactionSource = 交互源,
            labelPosition = 标签位置,
            label = 标签,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            supportingText = 辅助文本,
            isError = 是否错误,
            colors = 颜色集,
            contentPadding = 内容内边距,
            container = 容器,
        )


    /**
     * 用于为 [轮廓文本字段] 绘制默认容器的可组合项，带有边框描边。你可以通过 [装饰器] 或 [装饰盒子] 将其应用到
     * [基础文本字段]，以基于 Material 轮廓式文本字段的样式创建自定义文本字段。[轮廓文本字段] 组件会自动应用它。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 交互源 文本字段的 [InteractionSource]。用于确定文本字段是否处于聚焦状态。
     * @param 修饰符 此容器的 [Modifier]。
     * @param 颜色集 用于解析文本字段颜色的 [TextFieldColors]。
     * @param 形状 此容器的形状。
     * @param 聚焦边框厚度 文本字段聚焦时指示器线条的粗细。
     * @param 未聚焦边框厚度 文本字段未聚焦时指示器线条的粗细。
     */
    @Suppress("ComposableNaming")
    @OptIn(ExperimentalFoundationStyleApi::class)
    @Composable
    fun 容器(
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        修饰符: Modifier = Modifier,
        颜色集: TextFieldColors = OutlinedTextFieldDefaults.colors(),
        形状: Shape = OutlinedTextFieldDefaults.shape,
        聚焦边框厚度: Dp = OutlinedTextFieldDefaults.FocusedBorderThickness,
        未聚焦边框厚度: Dp = OutlinedTextFieldDefaults.UnfocusedBorderThickness,
    ) {
        OutlinedTextFieldDefaults.Container(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            modifier = 修饰符,
            colors = 颜色集,
            shape = 形状,
            focusedBorderThickness = 聚焦边框厚度,
            unfocusedBorderThickness = 未聚焦边框厚度,
        )
    }

    /**
     * 用于创建自定义文本字段的装饰框，基于[Material Design outlined text field](https://m3.material.io/components/text-fields/overview).
     *
     * 如果你的文本字段需要自定义 [轮廓文本字段] 未暴露的元素，请考虑使用此装饰框来实现所需的设计。
     *
     * 例如，如果你想自定义边框粗细，可以向此装饰框的 [容器] 传入自定义的 [容器]。
     *
     * 此装饰框旨在与接受 `decorationBox` 参数的 [基础文本字段] 重载版本配合使用。对于使用 [TextFieldDecorator] 的
     * 其他 [基础文本字段] 重载版本，请参见 [装饰器]。
     *
     * @param 值 文本字段显示的输入 [String]。
     * @param 内部文本字段 此装饰框所包裹的输入文本字段。请从 [基础文本字段] 的 `decorationBox` lambda 中传入由框架
     * 控制的可组合参数 `innerTextField`。
     * @param 已启用 文本字段的启用状态。当设置为 `false` 时，此装饰框将在视觉上呈现为禁用状态。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 单行 指示这是单行还是多行文本字段。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 视觉转换 转换输入值 [值] 的视觉表现形式。该值必须与传递给 [基础文本字段] 的值相同。
     * @param 交互源 表示此文本字段的 [Interaction] 流的只读 [InteractionSource]。你必须先创建并传入你自己 `remember`
     * 的 [MutableInteractionSource] 实例到 [基础文本字段] 中，以便其分发事件。然后将同一实例传递给此装饰框，
     * 以观察 [Interaction] 并自定义此文本字段在不同状态下的外观/行为。
     * @param 是否错误 指示文本字段当前值是否处于错误状态。当设置为 `true` 时，此装饰框将以其内容以错误颜色显示。
     * @param 标签 与此文本字段一起显示的可选标签。默认文本样式在最小化时使用 [Typography.bodySmall]，在展开时使用 [Typography.bodyLarge]。
     * @param 占位符 当文本字段获得焦点且输入文本为空时显示的可选占位提示文本。内部 [文本] 的默认文本样式为 [Typography.bodyLarge]。
     * @param 前导图标 可选的前置图标，显示在文本字段容器的起始位置。
     * @param 尾随图标 可选的后置图标，显示在文本字段容器的末尾位置。
     * @param 前缀 可选的前缀，显示在文本字段中输入文本之前。
     * @param 后缀 可选的后缀，显示在文本字段中输入文本之后。
     * @param 辅助文本 可选的辅助文本，显示在文本字段下方。
     * @param 颜色集 用于解析此文本字段装饰框在不同状态下所使用的颜色的 [TextFieldColors]。参见 [TextFieldDefaults.colors]。
     * 注意：此参数仅影响装饰框中元素的颜色。[基础文本字段] 的元素（如文本颜色或光标颜色）不受影响，必须使用 [基础文本字段]
     * 的相关参数进行更改。
     * @param 内容内边距 输入框与装饰框周围元素之间的内边距。请注意，如果这些内边距值与文本字段的尺寸约束或布局不兼容，则可能不会被采用。
     * 参见 [TextFieldDefaults.contentPaddingWithLabel] 和 [TextFieldDefaults.contentPaddingWithoutLabel]。
     * @param 容器 绘制在文本字段后方的容器。默认情况下它是透明的，仅包含边框。框架会自动在边框中添加切口以容纳 [标签]。容器的默认颜色来自 [颜色集]。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 装饰盒子(
        值: String,
        内部文本字段: @Composable () -> Unit,
        已启用: Boolean,
        单行: Boolean,
        视觉转换: VisualTransformation,
        交互源: InteractionSource,
        是否错误: Boolean = false,
        标签: @Composable (() -> Unit)? = null,
        占位符: @Composable (() -> Unit)? = null,
        前导图标: @Composable (() -> Unit)? = null,
        尾随图标: @Composable (() -> Unit)? = null,
        前缀: @Composable (() -> Unit)? = null,
        后缀: @Composable (() -> Unit)? = null,
        辅助文本: @Composable (() -> Unit)? = null,
        颜色集: TextFieldColors = OutlinedTextFieldDefaults.colors(),
        内容内边距: PaddingValues = OutlinedTextFieldDefaults.contentPadding(),
        容器: @Composable () -> Unit = {
            OutlinedTextFieldDefaults.Container(
                enabled = 已启用,
                isError = 是否错误,
                interactionSource = 交互源,
                modifier = Modifier,
                colors = 颜色集,
                shape = OutlinedTextFieldDefaults.shape,
                focusedBorderThickness = OutlinedTextFieldDefaults.FocusedBorderThickness,
                unfocusedBorderThickness = OutlinedTextFieldDefaults.UnfocusedBorderThickness,
            )
        },
    ) {
        OutlinedTextFieldDefaults.DecorationBox(
            value = 值,
            innerTextField = 内部文本字段,
            enabled = 已启用,
            singleLine = 单行,
            visualTransformation = 视觉转换,
            interactionSource = 交互源,
            isError = 是否错误,
            label = 标签,
            placeholder = 占位符,
            leadingIcon = 前导图标,
            trailingIcon = 尾随图标,
            prefix = 前缀,
            suffix = 后缀,
            supportingText = 辅助文本,
            colors = 颜色集,
            contentPadding = 内容内边距,
            container = 容器,
        )
    }

    /**
     * [轮廓文本字段] 中输入框的默认内容内边距。
     *
     * 水平内边距表示输入框与前置/后置图标（如果存在）之间的距离；如果没有图标，则表示与容器水平边缘之间的距离。
     */
    fun 内容内边距(
        开始: Dp = 16.dp,
        上: Dp = 16.dp,
        结束: Dp = 16.dp,
        下: Dp = 16.dp,
    ): PaddingValues = OutlinedTextFieldDefaults.contentPadding(
        start = 开始, top = 上, end = 结束, bottom = 下)

    /** 创建一个 [TextFieldColors]，表示 [轮廓文本字段] 中使用的默认输入文本、容器和内容颜色（包括标签、占位符、图标等）。*/
    @Composable
    fun 颜色集() = OutlinedTextFieldDefaults.colors()

    /**
     *  创建一个 [TextFieldColors]，表示 [轮廓文本字段] 中使用的默认输入文本、容器和内容颜色（包括标签、占位符、图标等）。
     *
     * @param 聚焦文本颜色 此文本字段在聚焦状态下输入文本所使用的颜色。
     * @param 未聚焦文本颜色 此文本字段在未聚焦状态下输入文本所使用的颜色。
     * @param 禁用文本颜色 此文本字段在禁用状态下输入文本所使用的颜色。
     * @param 错误文本颜色 此文本字段在错误状态下输入文本所使用的颜色。
     * @param 聚焦容器颜色 此文本字段在聚焦状态下的容器颜色。
     * @param 未聚焦容器颜色 此文本字段在未聚焦状态下的容器颜色。
     * @param 禁用容器颜色 此文本字段在禁用状态下的容器颜色。
     * @param 错误容器颜色 此文本字段在错误状态下的容器颜色。
     * @param 光标颜色 此文本字段的光标颜色。
     * @param 错误光标颜色 此文本字段在错误状态下的光标颜色。
     * @param 选择颜色集 此文本字段的输入文本被选中时使用的颜色。
     * @param 聚焦边框颜色 此文本字段在聚焦状态下的边框颜色。
     * @param 未聚焦边框颜色 此文本字段在未聚焦状态下的边框颜色。
     * @param 禁用边框颜色 此文本字段在禁用状态下的边框颜色。
     * @param 错误边框颜色 此文本字段在错误状态下的边框颜色。
     * @param 聚焦前导图标颜色 此文本字段在聚焦状态下的前置图标颜色。
     * @param 未聚焦前导图标颜色 此文本字段在未聚焦状态下的前置图标颜色。
     * @param 禁用前导图标颜色 此文本字段在禁用状态下的前置图标颜色。
     * @param 错误前导图标颜色 此文本字段在错误状态下的前置图标颜色。
     * @param 聚焦尾随图标颜色 此文本字段在聚焦状态下的后置图标颜色。
     * @param 未聚焦尾随图标颜色 此文本字段在未聚焦状态下的后置图标颜色。
     * @param 禁用尾随图标颜色 此文本字段在禁用状态下的后置图标颜色。
     * @param 错误尾随图标颜色 此文本字段在错误状态下的后置图标颜色。
     * @param 聚焦标签颜色 此文本字段在聚焦状态下的标签颜色。
     * @param 未聚焦标签颜色 此文本字段在未聚焦状态下的标签颜色。
     * @param 禁用标签颜色 此文本字段在禁用状态下的标签颜色。
     * @param 错误标签颜色 此文本字段在错误状态下的标签颜色。
     * @param 聚焦占位符颜色 此文本字段在聚焦状态下的占位提示文本颜色。
     * @param 未聚焦占位符颜色 此文本字段在未聚焦状态下的占位提示文本颜色。
     * @param 禁用占位符颜色 此文本字段在禁用状态下的占位提示文本颜色。
     * @param 错误占位符颜色 此文本字段在错误状态下的占位提示文本颜色。
     * @param 聚焦辅助文本颜色 此文本字段在聚焦状态下的辅助文本颜色。
     * @param 未聚焦辅助文本颜色 此文本字段在未聚焦状态下的辅助文本颜色。
     * @param 禁用辅助文本颜色 此文本字段在禁用状态下的辅助文本颜色。
     * @param 错误辅助文本颜色 此文本字段在错误状态下的辅助文本颜色。
     * @param 聚焦前缀颜色 此文本字段在聚焦状态下的前缀颜色。
     * @param 未聚焦前缀颜色 此文本字段在未聚焦状态下的前缀颜色。
     * @param 禁用前缀颜色 此文本字段在禁用状态下的前缀颜色。
     * @param 错误前缀颜色 此文本字段在错误状态下的前缀颜色。
     * @param 聚焦后缀颜色 此文本字段在聚焦状态下的后缀颜色。
     * @param 未聚焦后缀颜色 此文本字段在未聚焦状态下的后缀颜色。
     * @param 禁用后缀颜色 此文本字段在禁用状态下的后缀颜色。
     * @param 错误后缀颜色 此文本字段在错误状态下的后缀颜色。
     */
    @Composable
    fun 颜色集(
        聚焦文本颜色: Color = Color.Unspecified,
        未聚焦文本颜色: Color = Color.Unspecified,
        禁用文本颜色: Color = Color.Unspecified,
        错误文本颜色: Color = Color.Unspecified,
        聚焦容器颜色: Color = Color.Unspecified,
        未聚焦容器颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        错误容器颜色: Color = Color.Unspecified,
        光标颜色: Color = Color.Unspecified,
        错误光标颜色: Color = Color.Unspecified,
        选择颜色集: TextSelectionColors? = null,
        聚焦边框颜色: Color = Color.Unspecified,
        未聚焦边框颜色: Color = Color.Unspecified,
        禁用边框颜色: Color = Color.Unspecified,
        错误边框颜色: Color = Color.Unspecified,
        聚焦前导图标颜色: Color = Color.Unspecified,
        未聚焦前导图标颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        错误前导图标颜色: Color = Color.Unspecified,
        聚焦尾随图标颜色: Color = Color.Unspecified,
        未聚焦尾随图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        错误尾随图标颜色: Color = Color.Unspecified,
        聚焦标签颜色: Color = Color.Unspecified,
        未聚焦标签颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        错误标签颜色: Color = Color.Unspecified,
        聚焦占位符颜色: Color = Color.Unspecified,
        未聚焦占位符颜色: Color = Color.Unspecified,
        禁用占位符颜色: Color = Color.Unspecified,
        错误占位符颜色: Color = Color.Unspecified,
        聚焦辅助文本颜色: Color = Color.Unspecified,
        未聚焦辅助文本颜色: Color = Color.Unspecified,
        禁用辅助文本颜色: Color = Color.Unspecified,
        错误辅助文本颜色: Color = Color.Unspecified,
        聚焦前缀颜色: Color = Color.Unspecified,
        未聚焦前缀颜色: Color = Color.Unspecified,
        禁用前缀颜色: Color = Color.Unspecified,
        错误前缀颜色: Color = Color.Unspecified,
        聚焦后缀颜色: Color = Color.Unspecified,
        未聚焦后缀颜色: Color = Color.Unspecified,
        禁用后缀颜色: Color = Color.Unspecified,
        错误后缀颜色: Color = Color.Unspecified,
    ): TextFieldColors =
        OutlinedTextFieldDefaults.colors(
            focusedTextColor = 聚焦文本颜色 ,
            unfocusedTextColor = 未聚焦文本颜色 ,
            disabledTextColor = 禁用文本颜色,
            errorTextColor = 错误文本颜色 ,
            focusedContainerColor = 聚焦容器颜色,
            unfocusedContainerColor = 未聚焦容器颜色,
            disabledContainerColor = 禁用容器颜色,
            errorContainerColor = 错误容器颜色,
            cursorColor = 光标颜色,
            errorCursorColor = 错误光标颜色,
            selectionColors = 选择颜色集,
            focusedBorderColor = 聚焦边框颜色,
            unfocusedBorderColor = 未聚焦边框颜色,
            disabledBorderColor = 禁用边框颜色,
            errorBorderColor = 错误边框颜色,
            focusedLeadingIconColor = 聚焦前导图标颜色,
            unfocusedLeadingIconColor = 未聚焦前导图标颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            errorLeadingIconColor = 错误前导图标颜色,
            focusedTrailingIconColor = 聚焦尾随图标颜色,
            unfocusedTrailingIconColor = 未聚焦尾随图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            errorTrailingIconColor = 错误尾随图标颜色,
            focusedLabelColor = 聚焦标签颜色,
            unfocusedLabelColor = 未聚焦标签颜色,
            disabledLabelColor = 禁用标签颜色,
            errorLabelColor = 错误标签颜色,
            focusedPlaceholderColor = 聚焦占位符颜色,
            unfocusedPlaceholderColor = 未聚焦占位符颜色,
            disabledPlaceholderColor = 禁用占位符颜色,
            errorPlaceholderColor = 错误占位符颜色,
            focusedSupportingTextColor = 聚焦辅助文本颜色,
            unfocusedSupportingTextColor = 未聚焦辅助文本颜色,
            disabledSupportingTextColor = 禁用辅助文本颜色,
            errorSupportingTextColor = 错误辅助文本颜色,
            focusedPrefixColor = 聚焦前缀颜色,
            unfocusedPrefixColor = 未聚焦前缀颜色,
            disabledPrefixColor = 禁用前缀颜色,
            errorPrefixColor = 错误前缀颜色,
            focusedSuffixColor = 聚焦后缀颜色,
            unfocusedSuffixColor = 未聚焦后缀颜色,
            disabledSuffixColor = 禁用后缀颜色,
            errorSuffixColor = 错误后缀颜色,
        )

    @Suppress("ComposableNaming")
    @Deprecated(
        message = "Renamed to OutlinedTextFieldDefaults.Container",
        replaceWith =
            ReplaceWith(
                "Container(\n" +
                        "    enabled = enabled,\n" +
                        "    isError = isError,\n" +
                        "    interactionSource = interactionSource,\n" +
                        "    colors = colors,\n" +
                        "    shape = shape,\n" +
                        "    focusedBorderThickness = focusedBorderThickness,\n" +
                        "    unfocusedBorderThickness = unfocusedBorderThickness,\n" +
                        ")"
            ),
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3Api
    @Composable
    fun 容器盒子(
        已启用: Boolean,
        是否错误: Boolean,
        交互源: InteractionSource,
        颜色集: TextFieldColors = OutlinedTextFieldDefaults.colors(),
        形状: Shape = OutlinedTextFieldDefaults.shape,
        聚焦边框厚度: Dp = OutlinedTextFieldDefaults.FocusedBorderThickness,
        未聚焦边框厚度: Dp = OutlinedTextFieldDefaults.UnfocusedBorderThickness,
    ) =
        OutlinedTextFieldDefaults.ContainerBox(
            enabled = 已启用,
            isError = 是否错误,
            interactionSource = 交互源,
            colors = 颜色集,
            shape = 形状,
            focusedBorderThickness = 聚焦边框厚度,
            unfocusedBorderThickness = 未聚焦边框厚度,
        )
}

/**
 * 表示文本字段在不同状态下使用的输入文本、容器和内容（包括标签、占位符、前置和后置图标）的颜色。
 *
 * @param 聚焦文本颜色 此文本字段在聚焦状态下输入文本所使用的颜色。
 * @param 未聚焦文本颜色 此文本字段在未聚焦状态下输入文本所使用的颜色。
 * @param 禁用文本颜色 此文本字段在禁用状态下输入文本所使用的颜色。
 * @param 错误文本颜色 此文本字段在错误状态下输入文本所使用的颜色。
 * @param 聚焦容器颜色 此文本字段在聚焦状态下的容器颜色。
 * @param 未聚焦容器颜色 此文本字段在未聚焦状态下的容器颜色。
 * @param 禁用容器颜色 此文本字段在禁用状态下的容器颜色。
 * @param 错误容器颜色 此文本字段在错误状态下的容器颜色。
 * @param 光标颜色 此文本字段的光标颜色。
 * @param 错误光标颜色 此文本字段在错误状态下的光标颜色。
 * @param 文本选择颜色集 此文本字段的输入文本被选中时使用的颜色。
 * @param 聚焦指示器颜色 此文本字段在聚焦状态下的指示器颜色。
 * @param 未聚焦指示器颜色 此文本字段在未聚焦状态下的指示器颜色。
 * @param 禁用指示器颜色 此文本字段在禁用状态下的指示器颜色。
 * @param 错误指示器颜色 此文本字段在错误状态下的指示器颜色。
 * @param 聚焦前导图标颜色 此文本字段在聚焦状态下的前置图标颜色。
 * @param 未聚焦前导图标颜色 此文本字段在未聚焦状态下的前置图标颜色。
 * @param 禁用前导图标颜色 此文本字段在禁用状态下的前置图标颜色。
 * @param 错误前导图标颜色 此文本字段在错误状态下的前置图标颜色。
 * @param 聚焦尾随图标颜色 此文本字段在聚焦状态下的后置图标颜色。
 * @param 未聚焦尾随图标颜色 此文本字段在未聚焦状态下的后置图标颜色。
 * @param 禁用尾随图标颜色 此文本字段在禁用状态下的后置图标颜色。
 * @param 错误尾随图标颜色 此文本字段在错误状态下的后置图标颜色。
 * @param 聚焦标签颜色 此文本字段在聚焦状态下的标签颜色。
 * @param 未聚焦标签颜色 此文本字段在未聚焦状态下的标签颜色。
 * @param 禁用标签颜色 此文本字段在禁用状态下的标签颜色。
 * @param 错误标签颜色 此文本字段在错误状态下的标签颜色。
 * @param 聚焦占位符颜色 此文本字段在聚焦状态下的占位提示文本颜色。
 * @param 未聚焦占位符颜色 此文本字段在未聚焦状态下的占位提示文本颜色。
 * @param 禁用占位符颜色 此文本字段在禁用状态下的占位提示文本颜色。
 * @param 错误占位符颜色 此文本字段在错误状态下的占位提示文本颜色。
 * @param 聚焦辅助文本颜色 此文本字段在聚焦状态下的辅助文本颜色。
 * @param 未聚焦辅助文本颜色 此文本字段在未聚焦状态下的辅助文本颜色。
 * @param 禁用辅助文本颜色 此文本字段在禁用状态下的辅助文本颜色。
 * @param 错误辅助文本颜色 此文本字段在错误状态下的辅助文本颜色。
 * @param 聚焦前缀颜色 此文本字段在聚焦状态下的前缀颜色。
 * @param 未聚焦前缀颜色 此文本字段在未聚焦状态下的前缀颜色。
 * @param 禁用前缀颜色 此文本字段在禁用状态下的前缀颜色。
 * @param 错误前缀颜色 此文本字段在错误状态下的前缀颜色。
 * @param 聚焦后缀颜色 此文本字段在聚焦状态下的后缀颜色。
 * @param 未聚焦后缀颜色 此文本字段在未聚焦状态下的后缀颜色。
 * @param 禁用后缀颜色 此文本字段在禁用状态下的后缀颜色。
 * @param 错误后缀颜色 此文本字段在错误状态下的后缀颜色。
 * @constructor 使用任意颜色创建实例。有关 [文本字段] 使用的默认颜色，请参见 [TextFieldDefaults.colors]。有关 [轮廓文本字段]
 * 使用的默认颜色，请参见 [OutlinedTextFieldDefaults.colors]。
 */
@Immutable
class 文本字段颜色集 // TextFieldColors
constructor(
    val 聚焦文本颜色: Color,
    val 未聚焦文本颜色: Color,
    val 禁用文本颜色: Color,
    val 错误文本颜色: Color,
    val 聚焦容器颜色: Color,
    val 未聚焦容器颜色: Color,
    val 禁用容器颜色: Color,
    val 错误容器颜色: Color,
    val 光标颜色: Color,
    val 错误光标颜色: Color,
    val 文本选择颜色集: TextSelectionColors,
    val 聚焦指示器颜色: Color,
    val 未聚焦指示器颜色: Color,
    val 禁用指示器颜色: Color,
    val 错误指示器颜色: Color,
    val 聚焦前导图标颜色: Color,
    val 未聚焦前导图标颜色: Color,
    val 禁用前导图标颜色: Color,
    val 错误前导图标颜色: Color,
    val 聚焦尾随图标颜色: Color,
    val 未聚焦尾随图标颜色: Color,
    val 禁用尾随图标颜色: Color,
    val 错误尾随图标颜色: Color,
    val 聚焦标签颜色: Color,
    val 未聚焦标签颜色: Color,
    val 禁用标签颜色: Color,
    val 错误标签颜色: Color,
    val 聚焦占位符颜色: Color,
    val 未聚焦占位符颜色: Color,
    val 禁用占位符颜色: Color,
    val 错误占位符颜色: Color,
    val 聚焦辅助文本颜色: Color,
    val 未聚焦辅助文本颜色: Color,
    val 禁用辅助文本颜色: Color,
    val 错误辅助文本颜色: Color,
    val 聚焦前缀颜色: Color,
    val 未聚焦前缀颜色: Color,
    val 禁用前缀颜色: Color,
    val 错误前缀颜色: Color,
    val 聚焦后缀颜色: Color,
    val 未聚焦后缀颜色: Color,
    val 禁用后缀颜色: Color,
    val 错误后缀颜色: Color,
) {

    /** 返回此 ChipColors 的副本，可选择性地覆盖部分值。这里使用 Color.Unspecified 表示"使用源对象中的值"。*/
    fun 复制(
        focusedTextColor: Color = this.聚焦文本颜色,
        unfocusedTextColor: Color = this.未聚焦文本颜色,
        disabledTextColor: Color = this.禁用文本颜色,
        errorTextColor: Color = this.错误文本颜色,
        focusedContainerColor: Color = this.聚焦容器颜色,
        unfocusedContainerColor: Color = this.未聚焦容器颜色,
        disabledContainerColor: Color = this.禁用容器颜色,
        errorContainerColor: Color = this.错误容器颜色,
        cursorColor: Color = this.光标颜色,
        errorCursorColor: Color = this.错误光标颜色,
        textSelectionColors: TextSelectionColors? = this.文本选择颜色集,
        focusedIndicatorColor: Color = this.聚焦指示器颜色,
        unfocusedIndicatorColor: Color = this.未聚焦指示器颜色,
        disabledIndicatorColor: Color = this.禁用指示器颜色,
        errorIndicatorColor: Color = this.错误指示器颜色,
        focusedLeadingIconColor: Color = this.聚焦前导图标颜色,
        unfocusedLeadingIconColor: Color = this.未聚焦前导图标颜色,
        disabledLeadingIconColor: Color = this.禁用前导图标颜色,
        errorLeadingIconColor: Color = this.错误前导图标颜色,
        focusedTrailingIconColor: Color = this.聚焦尾随图标颜色,
        unfocusedTrailingIconColor: Color = this.未聚焦尾随图标颜色,
        disabledTrailingIconColor: Color = this.禁用尾随图标颜色,
        errorTrailingIconColor: Color = this.错误尾随图标颜色,
        focusedLabelColor: Color = this.聚焦标签颜色,
        unfocusedLabelColor: Color = this.未聚焦标签颜色,
        disabledLabelColor: Color = this.禁用标签颜色,
        errorLabelColor: Color = this.错误标签颜色,
        focusedPlaceholderColor: Color = this.聚焦占位符颜色,
        unfocusedPlaceholderColor: Color = this.未聚焦占位符颜色,
        disabledPlaceholderColor: Color = this.禁用占位符颜色,
        errorPlaceholderColor: Color = this.错误占位符颜色,
        focusedSupportingTextColor: Color = this.聚焦辅助文本颜色,
        unfocusedSupportingTextColor: Color = this.未聚焦辅助文本颜色,
        disabledSupportingTextColor: Color = this.禁用辅助文本颜色,
        errorSupportingTextColor: Color = this.错误辅助文本颜色,
        focusedPrefixColor: Color = this.聚焦前缀颜色,
        unfocusedPrefixColor: Color = this.未聚焦前缀颜色,
        disabledPrefixColor: Color = this.禁用前缀颜色,
        errorPrefixColor: Color = this.错误前缀颜色,
        focusedSuffixColor: Color = this.聚焦后缀颜色,
        unfocusedSuffixColor: Color = this.未聚焦后缀颜色,
        disabledSuffixColor: Color = this.禁用后缀颜色,
        errorSuffixColor: Color = this.错误后缀颜色,
    ) =
        TextFieldColors(
            focusedTextColor.takeOrElse { this.聚焦文本颜色 },
            unfocusedTextColor.takeOrElse { this.未聚焦文本颜色 },
            disabledTextColor.takeOrElse { this.禁用文本颜色 },
            errorTextColor.takeOrElse { this.错误文本颜色 },
            focusedContainerColor.takeOrElse { this.聚焦容器颜色 },
            unfocusedContainerColor.takeOrElse { this.未聚焦容器颜色 },
            disabledContainerColor.takeOrElse { this.禁用容器颜色 },
            errorContainerColor.takeOrElse { this.错误容器颜色 },
            cursorColor.takeOrElse { this.光标颜色 },
            errorCursorColor.takeOrElse { this.错误光标颜色 },
            textSelectionColors.takeOrElse { this.文本选择颜色集 },
            focusedIndicatorColor.takeOrElse { this.聚焦指示器颜色 },
            unfocusedIndicatorColor.takeOrElse { this.未聚焦指示器颜色 },
            disabledIndicatorColor.takeOrElse { this.禁用指示器颜色 },
            errorIndicatorColor.takeOrElse { this.错误指示器颜色 },
            focusedLeadingIconColor.takeOrElse { this.聚焦前导图标颜色 },
            unfocusedLeadingIconColor.takeOrElse { this.未聚焦前导图标颜色 },
            disabledLeadingIconColor.takeOrElse { this.禁用前导图标颜色 },
            errorLeadingIconColor.takeOrElse { this.错误前导图标颜色 },
            focusedTrailingIconColor.takeOrElse { this.聚焦尾随图标颜色 },
            unfocusedTrailingIconColor.takeOrElse { this.未聚焦尾随图标颜色 },
            disabledTrailingIconColor.takeOrElse { this.禁用尾随图标颜色 },
            errorTrailingIconColor.takeOrElse { this.错误尾随图标颜色 },
            focusedLabelColor.takeOrElse { this.聚焦标签颜色 },
            unfocusedLabelColor.takeOrElse { this.未聚焦标签颜色 },
            disabledLabelColor.takeOrElse { this.禁用标签颜色 },
            errorLabelColor.takeOrElse { this.错误标签颜色 },
            focusedPlaceholderColor.takeOrElse { this.聚焦占位符颜色 },
            unfocusedPlaceholderColor.takeOrElse { this.未聚焦占位符颜色 },
            disabledPlaceholderColor.takeOrElse { this.禁用占位符颜色 },
            errorPlaceholderColor.takeOrElse { this.错误占位符颜色 },
            focusedSupportingTextColor.takeOrElse { this.聚焦辅助文本颜色 },
            unfocusedSupportingTextColor.takeOrElse { this.未聚焦辅助文本颜色 },
            disabledSupportingTextColor.takeOrElse { this.禁用辅助文本颜色 },
            errorSupportingTextColor.takeOrElse { this.错误辅助文本颜色 },
            focusedPrefixColor.takeOrElse { this.聚焦前缀颜色 },
            unfocusedPrefixColor.takeOrElse { this.未聚焦前缀颜色 },
            disabledPrefixColor.takeOrElse { this.禁用前缀颜色 },
            errorPrefixColor.takeOrElse { this.错误前缀颜色 },
            focusedSuffixColor.takeOrElse { this.聚焦后缀颜色 },
            unfocusedSuffixColor.takeOrElse { this.未聚焦后缀颜色 },
            disabledSuffixColor.takeOrElse { this.禁用后缀颜色 },
            errorSuffixColor.takeOrElse { this.错误后缀颜色 },
        )

    internal fun TextSelectionColors?.takeOrElse(
        block: () -> TextSelectionColors
    ): TextSelectionColors = this ?: block()

    /**
     * 表示此文本字段前置图标所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 前导图标颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用前导图标颜色
            是否错误 -> 错误前导图标颜色
            已聚焦 -> 聚焦前导图标颜色
            else -> 未聚焦前导图标颜色
        }

    /**
     * 表示此文本字段后置图标所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 尾随图标颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用尾随图标颜色
            是否错误 -> 错误尾随图标颜色
            已聚焦 -> 聚焦尾随图标颜色
            else -> 未聚焦尾随图标颜色
        }

    /**
     * 表示此文本字段边框指示器所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 指示器颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用指示器颜色
            是否错误 -> 错误指示器颜色
            已聚焦 -> 聚焦指示器颜色
            else -> 未聚焦指示器颜色
        }

    /**
     * 表示此文本字段的容器颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 容器颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用容器颜色
            是否错误 -> 错误容器颜色
            已聚焦 -> 聚焦容器颜色
            else -> 未聚焦容器颜色
        }

    /**
     * 表示此文本字段占位提示文本所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 占位符颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用占位符颜色
            是否错误 -> 错误占位符颜色
            已聚焦 -> 聚焦占位符颜色
            else -> 未聚焦占位符颜色
        }

    /**
     * 表示此文本字段标签所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 标签颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用标签颜色
            是否错误 -> 错误标签颜色
            已聚焦 -> 聚焦标签颜色
            else -> 未聚焦标签颜色
        }

    /**
     * 表示此文本字段输入框所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 文本颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用文本颜色
            是否错误 -> 错误文本颜色
            已聚焦 -> 聚焦文本颜色
            else -> 未聚焦文本颜色
        }

    /**
     * 表示此文本字段辅助文本所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 辅助文本颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用辅助文本颜色
            是否错误 -> 错误辅助文本颜色
            已聚焦 -> 聚焦辅助文本颜色
            else -> 未聚焦辅助文本颜色
        }

    /**
     * 表示此文本字段前缀所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 前缀颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用前缀颜色
            是否错误 -> 错误前缀颜色
            已聚焦 -> 聚焦前缀颜色
            else -> 未聚焦前缀颜色
        }

    /**
     * 表示此文本字段后缀所使用的颜色。
     *
     * @param 已启用 文本字段是否启用
     * @param 是否错误 文本字段当前值是否处于错误状态
     * @param 已聚焦 文本字段是否处于聚焦状态
     */
    @Stable
    fun 后缀颜色(已启用: Boolean, 是否错误: Boolean, 已聚焦: Boolean): Color =
        when {
            !已启用 -> 禁用后缀颜色
            是否错误 -> 错误后缀颜色
            已聚焦 -> 聚焦后缀颜色
            else -> 未聚焦后缀颜色
        }

    /**
     * 表示此文本字段光标所使用的颜色。
     *
     * @param 是否错误 文本字段当前值是否处于错误状态
     */
    @Stable
    fun 光标颜色(是否错误: Boolean): Color = if (是否错误) 错误光标颜色 else 光标颜色

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is TextFieldColors) return false

        if (聚焦文本颜色 != other.focusedTextColor) return false
        if (未聚焦文本颜色 != other.unfocusedTextColor) return false
        if (禁用文本颜色 != other.disabledTextColor) return false
        if (错误文本颜色 != other.errorTextColor) return false
        if (聚焦容器颜色 != other.focusedContainerColor) return false
        if (未聚焦容器颜色 != other.unfocusedContainerColor) return false
        if (禁用容器颜色 != other.disabledContainerColor) return false
        if (错误容器颜色 != other.errorContainerColor) return false
        if (光标颜色 != other.cursorColor) return false
        if (错误光标颜色 != other.errorCursorColor) return false
        if (文本选择颜色集 != other.textSelectionColors) return false
        if (聚焦指示器颜色 != other.focusedIndicatorColor) return false
        if (未聚焦指示器颜色 != other.unfocusedIndicatorColor) return false
        if (禁用指示器颜色 != other.disabledIndicatorColor) return false
        if (错误指示器颜色 != other.errorIndicatorColor) return false
        if (聚焦前导图标颜色 != other.focusedLeadingIconColor) return false
        if (未聚焦前导图标颜色 != other.unfocusedLeadingIconColor) return false
        if (禁用前导图标颜色 != other.disabledLeadingIconColor) return false
        if (错误前导图标颜色 != other.errorLeadingIconColor) return false
        if (聚焦尾随图标颜色 != other.focusedTrailingIconColor) return false
        if (未聚焦尾随图标颜色 != other.unfocusedTrailingIconColor) return false
        if (禁用尾随图标颜色 != other.disabledTrailingIconColor) return false
        if (错误尾随图标颜色 != other.errorTrailingIconColor) return false
        if (聚焦标签颜色 != other.focusedLabelColor) return false
        if (未聚焦标签颜色 != other.unfocusedLabelColor) return false
        if (禁用标签颜色 != other.disabledLabelColor) return false
        if (错误标签颜色 != other.errorLabelColor) return false
        if (聚焦占位符颜色 != other.focusedPlaceholderColor) return false
        if (未聚焦占位符颜色 != other.unfocusedPlaceholderColor) return false
        if (禁用占位符颜色 != other.disabledPlaceholderColor) return false
        if (错误占位符颜色 != other.errorPlaceholderColor) return false
        if (聚焦辅助文本颜色 != other.focusedSupportingTextColor) return false
        if (未聚焦辅助文本颜色 != other.unfocusedSupportingTextColor) return false
        if (禁用辅助文本颜色 != other.disabledSupportingTextColor) return false
        if (错误辅助文本颜色 != other.errorSupportingTextColor) return false
        if (聚焦前缀颜色 != other.focusedPrefixColor) return false
        if (未聚焦前缀颜色 != other.unfocusedPrefixColor) return false
        if (禁用前缀颜色 != other.disabledPrefixColor) return false
        if (错误前缀颜色 != other.errorPrefixColor) return false
        if (聚焦后缀颜色 != other.focusedSuffixColor) return false
        if (未聚焦后缀颜色 != other.unfocusedSuffixColor) return false
        if (禁用后缀颜色 != other.disabledSuffixColor) return false
        if (错误后缀颜色 != other.errorSuffixColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 聚焦文本颜色.hashCode()
        result = 31 * result + 未聚焦文本颜色.hashCode()
        result = 31 * result + 禁用文本颜色.hashCode()
        result = 31 * result + 错误文本颜色.hashCode()
        result = 31 * result + 聚焦容器颜色.hashCode()
        result = 31 * result + 未聚焦容器颜色.hashCode()
        result = 31 * result + 禁用容器颜色.hashCode()
        result = 31 * result + 错误容器颜色.hashCode()
        result = 31 * result + 光标颜色.hashCode()
        result = 31 * result + 错误光标颜色.hashCode()
        result = 31 * result + 文本选择颜色集.hashCode()
        result = 31 * result + 聚焦指示器颜色.hashCode()
        result = 31 * result + 未聚焦指示器颜色.hashCode()
        result = 31 * result + 禁用指示器颜色.hashCode()
        result = 31 * result + 错误指示器颜色.hashCode()
        result = 31 * result + 聚焦前导图标颜色.hashCode()
        result = 31 * result + 未聚焦前导图标颜色.hashCode()
        result = 31 * result + 禁用前导图标颜色.hashCode()
        result = 31 * result + 错误前导图标颜色.hashCode()
        result = 31 * result + 聚焦尾随图标颜色.hashCode()
        result = 31 * result + 未聚焦尾随图标颜色.hashCode()
        result = 31 * result + 禁用尾随图标颜色.hashCode()
        result = 31 * result + 错误尾随图标颜色.hashCode()
        result = 31 * result + 聚焦标签颜色.hashCode()
        result = 31 * result + 未聚焦标签颜色.hashCode()
        result = 31 * result + 禁用标签颜色.hashCode()
        result = 31 * result + 错误标签颜色.hashCode()
        result = 31 * result + 聚焦占位符颜色.hashCode()
        result = 31 * result + 未聚焦占位符颜色.hashCode()
        result = 31 * result + 禁用占位符颜色.hashCode()
        result = 31 * result + 错误占位符颜色.hashCode()
        result = 31 * result + 聚焦辅助文本颜色.hashCode()
        result = 31 * result + 未聚焦辅助文本颜色.hashCode()
        result = 31 * result + 禁用辅助文本颜色.hashCode()
        result = 31 * result + 错误辅助文本颜色.hashCode()
        result = 31 * result + 聚焦前缀颜色.hashCode()
        result = 31 * result + 未聚焦前缀颜色.hashCode()
        result = 31 * result + 禁用前缀颜色.hashCode()
        result = 31 * result + 错误前缀颜色.hashCode()
        result = 31 * result + 聚焦后缀颜色.hashCode()
        result = 31 * result + 未聚焦后缀颜色.hashCode()
        result = 31 * result + 禁用后缀颜色.hashCode()
        result = 31 * result + 错误后缀颜色.hashCode()
        return result
    }
}

/** 标签相对于文本字段的位置。 */
object 文本字段标签位置{ // TextFieldLabelPosition
    /**
     * 根据 Material 规范定义的默认标签位置。
     *
     * 对于 [文本字段]，标签位于文本字段容器内部。对于 [轮廓文本字段]，标签在展开时位于文本字段容器内部，在最小化时切入边框。
     *
     * @param 始终最小化 是否始终保持文本字段的标签为最小化状态。如果为 `false`，当文本字段未聚焦且为空时，标签将展开以占据输入区域。
     * 如果为 `true`，则允许在文本字段未聚焦且为空时，与标签一起显示占位提示文本、前缀和后缀。
     * @param 最小化对齐方式 文本字段最小化时的标签水平对齐方式。
     * @param 展开对齐方式 文本字段展开时的标签水平对齐方式。
     */
    fun 已附加(
        始终最小化: Boolean = false,
        最小化对齐方式: Alignment.Horizontal = Alignment.Start,
        展开对齐方式: Alignment.Horizontal = Alignment.Start
    ) = TextFieldLabelPosition.Attached(
        alwaysMinimize = 始终最小化,
        minimizedAlignment = 最小化对齐方式,
        expandedAlignment = 展开对齐方式
    )

    fun 上方(
        对齐: Alignment.Horizontal = Alignment.Start
    ) = TextFieldLabelPosition.Above(alignment = 对齐)
}
//abstract class 文本字段标签位置 private constructor() { // TextFieldLabelPosition
//    /**
//     * 根据 Material 规范定义的默认标签位置。
//     *
//     * 对于 [文本字段]，标签位于文本字段容器内部。对于 [轮廓文本字段]，标签在展开时位于文本字段容器内部，在最小化时切入边框。
//     *
//     * @param 始终最小化 是否始终保持文本字段的标签为最小化状态。如果为 `false`，当文本字段未聚焦且为空时，标签将展开以占据输入区域。
//     * 如果为 `true`，则允许在文本字段未聚焦且为空时，与标签一起显示占位提示文本、前缀和后缀。
//     * @param 最小化对齐方式 文本字段最小化时的标签水平对齐方式。
//     * @param 展开对齐方式 文本字段展开时的标签水平对齐方式。
//     */
//    class 已附加(
//        @get:Suppress("GetterSetterNames") val 始终最小化: Boolean = false,
//        val 最小化对齐方式: Alignment.Horizontal = Alignment.Start,
//        val 展开对齐方式: Alignment.Horizontal = Alignment.Start,
//    ) : 文本字段标签位置() {
//        override fun equals(other: Any?): Boolean {
//            if (this === other) return true
//            if (other !is 已附加) return false
//
//            if (始终最小化  != other.始终最小化) return false
//            if (最小化对齐方式 != other.最小化对齐方式) return false
//            if (展开对齐方式 != other.展开对齐方式) return false
//
//            return true
//        }
//
//        override fun hashCode(): Int {
//            var result = 始终最小化.hashCode()
//            result = 31 * result + 最小化对齐方式.hashCode()
//            result = 31 * result + 展开对齐方式.hashCode()
//            return result
//        }
//
//        override fun toString(): String {
//            return "已附加(" +
//                    "始终最小化=$始终最小化, " +
//                    "最小化对齐方式=$最小化对齐方式, " +
//                    "展开对齐方式=$展开对齐方式" +
//                    ")"
//        }
//    }
//
//    /**
//     * 标签位于文本字段容器的上方和外部。这使得标签始终保持最小化状态。
//     *
//     * @param 对齐 标签的对齐方式。
//     */
//    class 上方(val 对齐: Alignment.Horizontal = Alignment.Start) : 文本字段标签位置() {
//        override fun equals(other: Any?): Boolean {
//            if (this === other) return true
//            if (other !is 上方) return false
//
//            return 对齐 == other.对齐
//        }
//
//        override fun hashCode(): Int {
//            return 对齐.hashCode()
//        }
//
//        override fun toString(): String = "上方(对齐=$对齐)"
//    }
//
//}

/**  [文本字段] 或 [轮廓文本字段] 标签的作用域。 */
@Stable
interface 文本字段标签范围 { // TextFieldLabelScope
    /**
     * 标签在展开尺寸和最小化尺寸之间的动画进度，其中 0 表示展开的标签，1 表示最小化的标签。
     *
     * 当使用从 [LocalTextStyle] 读取的组件（如默认的 [文本]）时，标签动画由框架自动处理。
     * 此 [标签最小化进度] 值可用于与默认动画协调配合其他动画。
     */
    @get:FloatRange(from = 0.0, to = 1.0)
    val 标签最小化进度: Float // labelMinimizedProgress
}
