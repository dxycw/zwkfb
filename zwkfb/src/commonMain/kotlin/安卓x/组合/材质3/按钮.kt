package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起操作，从发送电子邮件、分享文档到点赞帖子。
 *
 * ![Filled button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-button.png)
 *
 * 填充按钮是高强调按钮。填充按钮在 [FloatingActionButton] 之后具有最强的视觉冲击力，应用于完成流程的重要且最终的操作，
 * 例如"保存"、"立即加入"或"确认"。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.buttonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。请参阅 [ButtonElevation.shadowElevation]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@Composable
fun 按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = ButtonDefaults.shape,
    颜色集: ButtonColors = ButtonDefaults.buttonColors(),
    阴影: ButtonElevation? = ButtonDefaults.buttonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )
}

// TODO 添加指向按下状态按钮图片的链接。
/**
 * [Material Design button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、分享文档到点赞帖子。只要 [形状集] 中提供的形状是 [CornerBasedShape]，
 * 它还会根据与按钮的交互状态在这些形状之间变形过渡。如果 [形状集] 中的某个形状不是 [CornerBasedShape]，
 * 则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * ![Filled button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-button.png)
 *
 * 填充按钮是高强调按钮。填充按钮在 [FloatingActionButton] 之后具有最强的视觉冲击力，应用于完成流程的重要且最终的操作，
 * 例如"保存"、"立即加入"或"确认"。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 形状集 此按钮根据用户与按钮的交互而在其间变形的 [ButtonShapes]。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.buttonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。请参阅 [ButtonElevation.shadowElevation]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = ButtonDefaults.buttonColors(),
    阴影: ButtonElevation? = ButtonDefaults.buttonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * [Material Design elevated button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起操作，从发送电子邮件、分享文档到点赞帖子。
 *
 * ![Elevated button image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-button.png)
 *
 * 凸起按钮是高强调按钮，本质上就是带有阴影的 [FilledTonalButton]。为避免阴影过度蔓延，仅在绝对必要时使用，例如当按钮需要从带有图案的容器中视觉分离出来时。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.elevatedButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色叠加应用的数量。请参阅 [ButtonDefaults.elevatedButtonElevation]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@Composable
fun 凸起按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = ButtonDefaults.elevatedShape,
    颜色集: ButtonColors = ButtonDefaults.elevatedButtonColors(),
    阴影: ButtonElevation? = ButtonDefaults.elevatedButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    ElevatedButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO 添加指向按下状态凸起按钮图片的链接。
/**
 * [Material Design elevated button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、分享文档到点赞帖子。只要 [形状集] 中提供的形状是 [CornerBasedShape]，
 * 它还会根据与按钮的交互状态在这些形状之间变形过渡。如果 [形状集] 中的某个形状不是 [CornerBasedShape]，
 * 则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * ![Elevated button image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-button.png)
 *
 * 凸起按钮是高强调按钮，本质上就是带有阴影的 [FilledTonalButton]。为避免阴影过度蔓延，仅在绝对必要时使用，
 * 例如当按钮需要从带有图案的容器中视觉分离出来时。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 形状集 此按钮根据用户与按钮的交互而在其间变形的 [ButtonShapes]。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.elevatedButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色叠加应用的数量。请参阅 [ButtonDefaults.elevatedButtonElevation]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 凸起按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = ButtonDefaults.elevatedButtonColors(),
    阴影: ButtonElevation? = ButtonDefaults.elevatedButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    ElevatedButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起操作，从发送电子邮件、分享文档到点赞帖子。
 *
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * 填充色调按钮是中强调按钮，是默认 [Button]（填充按钮）和 [OutlinedButton] 之间的替代中间方案。
 * 它们可用于较低优先级按钮需要比轮廓样式稍强一些的强调效果的场景，例如引导流程中的"下一步"。色调按钮使用次级配色方案。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.filledTonalButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色叠加应用的数量。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@Composable
fun 填充色调按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = ButtonDefaults.filledTonalShape,
    颜色集: ButtonColors = ButtonDefaults.filledTonalButtonColors(),
    阴影: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    FilledTonalButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO 添加指向按下状态填充色调按钮图片的链接。
/**
 * [Material Design filled tonal button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、分享文档到点赞帖子。只要 [形状集] 中提供的形状是 [CornerBasedShape]，
 * 它还会根据与按钮的交互状态在这些形状之间变形过渡。如果 [形状集] 中的某个形状不是 [CornerBasedShape]，
 * 则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * 填充色调按钮是中强调按钮，是默认 [Button]（填充按钮）和 [OutlinedButton] 之间的替代中间方案。
 * 它们可用于较低优先级按钮需要比轮廓样式稍强一些的强调效果的场景，例如引导流程中的"下一步"。色调按钮使用次级配色方案。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 形状集 此按钮根据用户与按钮的交互而在其间变形的 [ButtonShapes]。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.filledTonalButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色叠加应用的数量。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 填充色调按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = ButtonDefaults.filledTonalButtonColors(),
    阴影: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    FilledTonalButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起操作，从发送电子邮件、分享文档到点赞帖子。
 *
 * ![Outlined button image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-button.png)
 *
 * 轮廓按钮是中强调按钮。它们包含重要的操作，但不是应用中的主要操作。轮廓按钮与 [Button] 搭配使用，可表示备选的次要操作。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.outlinedButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色叠加应用的数量。
 * @param 边框 绘制在此按钮容器周围的边框。. Pass `null` for no border.
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@Composable
fun 轮廓按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = ButtonDefaults.outlinedShape,
    颜色集: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = ButtonDefaults.outlinedButtonBorder(已启用),
    内容内边距: PaddingValues = ButtonDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    OutlinedButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO 添加指向按下状态轮廓按钮图片的链接。
/**
 * [Material Design outlined button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、分享文档到点赞帖子。只要 [形状集] 中提供的形状是 [CornerBasedShape]，
 * 它还会根据与按钮的交互状态在这些形状之间变形过渡。如果 [形状集] 中的某个形状不是 [CornerBasedShape]，
 * 则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * ![Outlined button image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-button.png)
 *
 * 轮廓按钮是中强调按钮。它们包含重要的操作，但不是应用中的主要操作。轮廓按钮与 [Button] 搭配使用，可表示备选的次要操作。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 形状集 此按钮根据用户与按钮的交互而在其间变形的 [ButtonShapes]。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.outlinedButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色叠加应用的数量。
 * @param 边框 绘制在此按钮容器周围的边框。传入 `null` 表示无边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3ExpressiveApi
fun 轮廓按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = ButtonDefaults.outlinedButtonBorder(已启用),
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    OutlinedButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design text button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起操作，从发送电子邮件、分享文档到点赞帖子。
 *
 * ![Text button image](https://developer.android.com/images/reference/androidx/compose/material3/text-button.png)
 *
 * 文本按钮通常用于不太突出的操作，包括位于对话框和卡片中的操作。在卡片中，文本按钮有助于保持对卡片内容的强调。
 * 文本按钮用于优先级最低的操作，尤其是在呈现多个选项时。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 形状 定义此按钮容器的形状、边框（当 [边框] 不为 null 时）以及阴影（当使用 [阴影] 时）。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.textButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色叠加应用的数量。 TextButton 通常没有阴影高度，
 * 默认值为 `null`。有关带阴影高度的按钮，请参阅 [ElevatedButton]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本。
 */
@Suppress("ComposableNaming")
@Composable
fun 文本按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = ButtonDefaults.textShape,
    颜色集: ButtonColors = ButtonDefaults.textButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    TextButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO 添加指向按下状态文本按钮图片的链接。
/**
 * [Material Design text button](https://m3.material.io/components/buttons/overview)
 *
 * 按钮帮助人们发起各种操作，从发送邮件、分享文档到点赞帖子。只要 [形状集] 中提供的形状是 [CornerBasedShape]，
 * 它还会根据与按钮的交互状态在这些形状之间变形过渡。如果 [形状集] 中的某个形状不是 [CornerBasedShape]，
 * 则按钮将根据用户交互在 [ButtonShapes] 之间切换。
 *
 * ![Text button image](https://developer.android.com/images/reference/androidx/compose/material3/text-button.png)
 *
 * 文本按钮通常用于不太突出的操作，包括位于对话框和卡片中的操作。在卡片中，文本按钮有助于保持对卡片内容的强调。
 * 文本按钮用于优先级最低的操作，尤其是在呈现多个选项时。
 *
 * @param 单击回调 此按钮被点击时调用。
 * @param 形状集 此按钮根据用户与按钮的交互而在其间变形的 [ButtonShapes]。
 * @param 修饰符 应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，该组件将不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 颜色集 用于解析此按钮在不同状态下颜色的 [ButtonColors]。请参阅 [ButtonDefaults.textButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色叠加应用的数量。 TextButton 通常没有阴影高度，默认值为 `null`。
 * 有关带阴影高度的按钮，请参阅 [ElevatedButton]。
 * @param 边框 绘制在此按钮容器周围的边框。
 * @param 内容内边距 应用于容器与内容之间内部间距的值。
 * @param 交互源 用于观察和发送此按钮 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 您可以使用它来更改按钮的外观或在不同状态下预览按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 按钮上显示的内容，预期为文本。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 文本按钮(
    单击回调: () -> Unit,
    形状集: ButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: ButtonColors = ButtonDefaults.textButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    TextButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

// TODO(b/201341237): 使用 0 阴影（elevation）的令牌值？
// TODO(b/201341237): 使用 null 边框的令牌值？
// TODO(b/201341237): 使用无颜色（透明）的令牌值？
/**
 * 包含所有 5 种按钮类型使用的默认值。
 *
 * 适用于所有按钮类型的默认值包括 [最小宽度]、[最小高度]、[图标大小] 和 [图标间距]。
 *
 * 仅适用于 [按钮]、[凸起按钮]、[填充色调按钮] 和 [轮廓按钮] 的默认值是 [内容内边距]。
 *
 * 仅适用于 [按钮] 的默认值是 [按钮颜色集] 和 [按钮阴影]。仅适用于 [凸起按钮] 的默认值是 [凸起按钮颜色集]
 * 和 [凸起按钮阴影]。仅适用于 [填充色调按钮] 的默认值是 [填充色调按钮颜色集] 和 [填充色调按钮阴影]。
 * 仅适用于 [轮廓按钮] 的默认值是 [轮廓按钮颜色集]。仅适用于 [文本按钮] 的默认值是 [文本按钮颜色集]。
 */
object 按钮默认值 { // ButtonDefaults

    /**
     * [按钮]、[凸起按钮]、[填充色调按钮]、[轮廓按钮] 和 [文本按钮] 使用的默认内容内边距。
     * - 有关包含 [Icon] 的 [按钮] 使用的内容内边距，请参阅 [按钮带图标内容内边距]。
     */
    val 内容内边距 = ButtonDefaults.ContentPadding

    /** 包含 [Icon] 的 [按钮] 使用的默认内容内边距。 */
    val 按钮带图标内容内边距 = ButtonDefaults.ButtonWithIconContentPadding

    /** 用于小型 [按钮] 的默认内容内边距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 小型内容内边距
        get() = ButtonDefaults.SmallContentPadding

    /** 超小型按钮的默认内容内边距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超小型内容内边距
        get()= ButtonDefaults.ExtraSmallContentPadding

    /** 中型按钮的默认内容内边距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 中型内容内边距
        get() = ButtonDefaults.MediumContentPadding

    /** 大型按钮的默认内容内边距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 大型内容内边距
        get() = ButtonDefaults.LargeContentPadding

    /** 超大型按钮的默认内容内边距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超大型内容内边距
        get() = ButtonDefaults.ExtraLargeContentPadding

    /**
     *  [文本按钮] 使用的默认内容内边距。
     * -  有关包含 [Icon] 的 [文本按钮] 使用的内容内边距，请参阅 [文本按钮带图标内容内边距]。
     *
     * 注意: 建议改用 [内容内边距]，以便在所有按钮变体之间保持更一致的外观。
     */
    val 文本按钮内容内边距 = ButtonDefaults.TextButtonContentPadding

    /**
     *  包含 [Icon] 的 [文本按钮] 使用的默认内容内边距。
     *
     * 注意: 建议改用 [按钮带图标内容内边距]，以便在所有按钮变体之间保持更一致的外观。
     */
    val 文本按钮带图标内容内边距 = ButtonDefaults.TextButtonWithIconContentPadding

    /**
     * 应用于小型按钮的默认最小宽度。请注意，您可以通过在按钮可组合项上直接应用 Modifier.widthIn 来覆盖此值。
     */
    val 最小宽度 = ButtonDefaults.MinWidth

    /**
     * 应用于小型按钮的默认最小高度。请注意，您可以通过在按钮可组合项上直接应用 Modifier.heightIn 来覆盖此值。
     */
    val 最小高度 = ButtonDefaults.MinHeight

    /** 超小型按钮容器的默认高度。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超小型容器高度 = ButtonDefaults.ExtraSmallContainerHeight

    /**  中型按钮容器的默认高度。 */
    @ExperimentalMaterial3ExpressiveApi
    val 中型容器高度 = ButtonDefaults.MediumContainerHeight

    /**  大型按钮容器的默认高度。 */
    @ExperimentalMaterial3ExpressiveApi
    val 大型容器高度 = ButtonDefaults.LargeContainerHeight

    /**  超大型按钮容器的默认高度。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超大型容器高度 = ButtonDefaults.ExtraLargeContainerHeight

    /**  用于小型按钮内部时的图标默认尺寸。 */
    // TODO 在 BaselineButtonTokens 可用时使用正确的值进行更新。
    val 图标大小 = ButtonDefaults.IconSize

    /** 超小型按钮内部使用的图标默认尺寸。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超小型图标大小 = ButtonDefaults.ExtraSmallIconSize

    /** 小型按钮内部使用的图标表现力尺寸。*/
    @ExperimentalMaterial3ExpressiveApi
    val 小型图标大小 = ButtonDefaults.SmallIconSize

    /** 中型按钮内部使用的图标默认尺寸。 */
    @ExperimentalMaterial3ExpressiveApi
    val 中型图标大小 = ButtonDefaults.MediumIconSize

    /** 大型按钮内部使用的图标默认尺寸。 */
    @ExperimentalMaterial3ExpressiveApi
    val 大型图标大小 = ButtonDefaults.LargeIconSize

    /** 超大型按钮内部使用的图标默认尺寸。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超大型图标大小 = ButtonDefaults.ExtraLargeIconSize

    /** 用于小型按钮内部时，图标与文本之间的默认间距。*/
    val 图标间距 = ButtonDefaults.IconSpacing

    /** 用于超小型按钮内部时，图标与文本之间的默认间距。*/
    // TODO 在 ButtonXSmallTokens.kt 的值被修正后，使用该文件中的值。
    @ExperimentalMaterial3ExpressiveApi
    val 超小型图标间距 = ButtonDefaults.ExtraSmallIconSpacing

    /** 用于中型按钮内部时，图标与文本之间的默认间距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 中型图标间距 = ButtonDefaults.MediumIconSpacing

    /** 用于大型按钮内部时，图标与文本之间的默认间距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 大型图标间距 = ButtonDefaults.LargeIconSpacing

    /** 用于超大型按钮内部时，图标与文本之间的默认间距。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超大型图标间距 = ButtonDefaults.ExtraLargeIconSpacing

    /** 默认按钮的方形形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 方形形状: Shape
        @Composable get() = ButtonDefaults.squareShape

    /** 默认按钮的按压形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 按压形状: Shape
        @Composable get() = ButtonDefaults.pressedShape

    /** 超小型按钮的按压形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超小型按压形状: Shape
        @Composable get() = ButtonDefaults.extraSmallPressedShape

    /** 中型按钮的按压形状。*/
    @ExperimentalMaterial3ExpressiveApi
    val 中型按压形状: Shape
        @Composable get() = ButtonDefaults.mediumPressedShape

    /** 大型按钮的按压形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 大型按压形状: Shape
        @Composable get() = ButtonDefaults.largePressedShape

    /** 超大型按钮的按压形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 超大型按压形状: Shape
        @Composable get() = ButtonDefaults.extraLargePressedShape

    /** 按钮的默认形状。 */
    val 形状: Shape
        @Composable get() = ButtonDefaults.shape

    /** 凸起按钮的默认形状。 */
    val 凸起形状: Shape
        @Composable get() = ButtonDefaults.elevatedShape

    /** 填充色调按钮的默认形状。 */
    val 填充色调形状: Shape
        @Composable get() = ButtonDefaults.filledTonalShape

    /** 轮廓按钮的默认形状。 */
    val 轮廓形状: Shape
        @Composable get() = ButtonDefaults.outlinedShape

    /** 文本按钮的默认形状。 */
    val 文本形状: Shape
        @Composable get() = ButtonDefaults.textShape

    /** 创建一个 [ButtonShapes]，表示按钮中使用的默认形状和按压形状。 */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 形状集() = ButtonDefaults.shapes()

    /**
     * 创建一个 [ButtonShapes]，表示 [按钮] 及其变体中使用的默认形状和按压形状。
     *
     * @param 形状 [ButtonShapes] 的未选中形状。
     * @param 按压形状 [ButtonShapes] 的未选中形状。
     */
    @Composable
    @ExperimentalMaterial3ExpressiveApi
    fun 形状集(形状: Shape? = null, 按压形状: Shape? = null): ButtonShapes =
        ButtonDefaults.shapes(shape = 形状, pressedShape = 按压形状)


    /** 创建一个 [ButtonColors]，表示 [按钮] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    fun 按钮颜色集() = ButtonDefaults.buttonColors()

    /**
     * 创建一个 [ButtonColors]，表示 [按钮] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [按钮] 启用时的容器颜色。
     * @param 内容颜色 此 [按钮] 启用状态下的内容颜色。
     * @param 禁用容器颜色 此 [按钮] 在禁用状态下的容器颜色。
     * @param 禁用内容颜色 此 [按钮] 在禁用状态下的内容颜色。
     */
    @Composable
    fun 按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.buttonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /** 创建一个 [ButtonColors]，用于表示 [凸起按钮] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    fun 凸起按钮颜色集() = ButtonDefaults.elevatedButtonColors()

    /**
     * 创建一个 [ButtonColors]，用于表示 [凸起按钮] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [凸起按钮] 启用时的容器颜色
     * @param 内容颜色 此 [凸起按钮] 启用时的内容颜色。
     * @param 禁用容器颜色 此 [凸起按钮] 在禁用状态下的容器颜色。
     * @param 禁用内容颜色 此 [凸起按钮] 在禁用状态下的内容颜色。
     */
    @Composable
    fun 凸起按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.elevatedButtonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /** 创建一个 [ButtonColors]，用于表示 [填充色调按钮] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    fun 填充色调按钮颜色集() = ButtonDefaults.filledTonalButtonColors()

    /**
     * 创建一个 [ButtonColors]，用于表示 [填充色调按钮] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [填充色调按钮] 启用时的容器颜色。
     * @param 内容颜色 此 [填充色调按钮] 启用时的内容颜色。
     * @param 禁用容器颜色 此 [填充色调按钮] 在禁用状态下的容器颜色。
     * @param 禁用内容颜色 此 [填充色调按钮] 在禁用状态下的内容颜色。
     */
    @Composable
    fun 填充色调按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.filledTonalButtonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /** 创建一个 [ButtonColors]，用于表示 [轮廓按钮] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    fun 轮廓按钮颜色集() = ButtonDefaults.outlinedButtonColors()

    /**
     * 创建一个 [ButtonColors]，用于表示 [轮廓按钮] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [轮廓按钮] 启用时的容器颜色。
     * @param 内容颜色 此 [轮廓按钮] 启用时的内容颜色。
     * @param 禁用容器颜色 此 [轮廓按钮] 在禁用状态下的容器颜色。
     * @param 禁用内容颜色 此 [轮廓按钮] 在禁用状态下的内容颜色。
     */
    @Composable
    fun 轮廓按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.outlinedButtonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /** 创建一个 [ButtonColors]，用于表示 [文本按钮] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    fun 文本按钮颜色集() = ButtonDefaults.textButtonColors()

    /**
     *  创建一个 [ButtonColors]，用于表示 [文本按钮] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [文本按钮] 启用时的容器颜色。
     * @param 内容颜色 此 [文本按钮] 启用时的内容颜色。
     * @param 禁用容器颜色 此 [文本按钮] 在禁用状态下的容器颜色。
     * @param 禁用内容颜色 此 [文本按钮] 在禁用状态下的内容颜色。
     */
    @Composable
    fun 文本按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
    ): ButtonColors =
        ButtonDefaults.textButtonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /**
     * 创建一个 [ButtonElevation]，将根据 [按钮] 的 Material 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 [按钮] 处于启用状态且没有其他 [Interaction] 时使用的阴影高度。
     * @param 按下阴影 此 [按钮] 处于启用状态且被按下时使用的阴影高度。
     * @param 聚焦阴影 此 [按钮] 处于启用状态且获得焦点时使用的阴影高度。
     * @param 悬停阴影 此 [按钮] 处于启用状态且悬停时使用的阴影高度。
     * @param 禁用阴影 此 [按钮] 在禁用状态下的阴影高度。
     */
    @Composable
    fun 按钮阴影(
        默认阴影: Dp = 0.0.dp,
        按下阴影: Dp = 0.0.dp,
        聚焦阴影: Dp = 0.0.dp,
        悬停阴影: Dp = 1.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): ButtonElevation =
        ButtonDefaults.buttonElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [ButtonElevation]，将根据 [凸起按钮] 的 Material 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 [凸起按钮] 处于启用状态且没有其他 [Interaction] 时使用的阴影高度。
     * @param 按下阴影 此 [凸起按钮] 处于启用状态且被按下时使用的阴影高度。
     * @param 聚焦阴影 此 [凸起按钮] 处于启用状态且获得焦点时使用的阴影高度。
     * @param 悬停阴影 此 [凸起按钮] 处于启用状态且悬停时使用的阴影高度。
     * @param 禁用阴影 此 [凸起按钮] 在禁用状态下的阴影高度。
     */
    @Composable
    fun 凸起按钮阴影(
        默认阴影: Dp = 0.0.dp,
        按下阴影: Dp = 0.0.dp,
        聚焦阴影: Dp = 0.0.dp,
        悬停阴影: Dp = 1.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): ButtonElevation =
        ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [ButtonElevation]，将根据 [填充色调按钮] 的 材质 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 [填充色调按钮] 处于启用状态且没有其他 [Interaction] 时使用的阴影高度。
     * @param 按下阴影 此 [填充色调按钮] 处于启用状态且被按下时使用的阴影高度。
     * @param 聚焦阴影 此 [填充色调按钮] 处于启用状态且获得焦点时使用的阴影高度。
     * @param 悬停阴影 此 [填充色调按钮] 处于启用状态且悬停时使用的阴影高度。
     * @param 禁用阴影 此 [填充色调按钮] 在禁用状态下的阴影高度。
     */
    @Composable
    fun 填充色调按钮阴影(
        默认阴影: Dp = 0.0.dp,
        按下阴影: Dp = 0.0.dp,
        聚焦阴影: Dp = 0.0.dp,
        悬停阴影: Dp = 1.0.dp,
        禁用阴影: Dp = 0.dp,
    ): ButtonElevation =
        ButtonDefaults.filledTonalButtonElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            disabledElevation = 禁用阴影,
        )

    /** [轮廓按钮] 使用的默认 [BorderStroke]。 */
    @Suppress("DEPRECATION")
    val 轮廓按钮边框: BorderStroke
        @Composable
        @Deprecated(
            message = " 请使用接受 `已启用` 参数的版本，以获取具有正确不透明度的 `BorderStroke`。",
            replaceWith = ReplaceWith("轮廓按钮边框(已启用)"),
        )
        get() = ButtonDefaults.outlinedButtonBorder

    /**
     * [轮廓按钮] 使用的默认 [BorderStroke]。
     *
     * @param 已启用 按钮是否启用
     */
    @Composable
    fun 轮廓按钮边框(已启用: Boolean = true): BorderStroke =
        ButtonDefaults.outlinedButtonBorder(enabled = 已启用)

    /**
     * 根据提供的按钮高度推荐使用的 [ButtonShapes]。
     *
     * @param 按钮高度 按钮的高度
     */
    @Composable
    @ExperimentalMaterial3ExpressiveApi
    fun 用于形状集(按钮高度: Dp): ButtonShapes {
        return ButtonDefaults.shapesFor(buttonHeight = 按钮高度)
    }

    /**
     * 根据提供的按钮高度推荐使用的 [PaddingValues]。
     *
     * @param 按钮高度 按钮的高度
     * @param 包含前缀图标 按钮是否带有前置图标
     * @param 包含后缀图标 按钮是否带有后置图标
     */
    @OptIn(ExperimentalMaterial3ExpressiveApi::class)
    fun 用于内容内边距(
        按钮高度: Dp,
        包含前缀图标: Boolean = false,
        包含后缀图标: Boolean = false,
    ): PaddingValues {
        return ButtonDefaults.contentPaddingFor(
            buttonHeight = 按钮高度,
            hasStartIcon = 包含前缀图标,
            hasEndIcon = 包含后缀图标,
        )
    }

    /**
     * 根据提供的按钮高度推荐的图标尺寸。
     *
     * @param 按钮高度 按钮的高度
     */
    @ExperimentalMaterial3ExpressiveApi
    fun 用于图标大小(按钮高度: Dp): Dp {
        return ButtonDefaults.iconSizeFor(buttonHeight = 按钮高度)
    }

    /**
     * 根据提供的按钮高度推荐的 [图标] 后的间距。
     *
     * @param 按钮高度 按钮的高度
     */
    @ExperimentalMaterial3ExpressiveApi
    fun 用于图标间距(按钮高度: Dp): Dp {
        return ButtonDefaults.iconSpacingFor(buttonHeight = 按钮高度)
    }

    /**
     * 根据提供的按钮高度为 [文本] 推荐使用的 [TextStyle]。
     *
     * @param 按钮高度 按钮的高度
     */
    @Composable
    @ExperimentalMaterial3ExpressiveApi
    fun 用于文本样式(按钮高度: Dp): TextStyle {
        return ButtonDefaults.textStyleFor(buttonHeight = 按钮高度)
    }

}


/**
 * 表示按钮在不同状态下使用的容器颜色和内容颜色。
 *
 * @param 容器颜色 此 [按钮] 启用时的容器颜色。
 * @param 内容颜色 此 [按钮] 启用时的内容颜色。
 * @param 禁用容器颜色 此 [按钮] 禁用时的容器颜色。
 * @param 禁用内容颜色 此 [按钮] 禁用时的内容颜色。
 * @constructor 创建一个实例，使用任意颜色。
 * - 查看 [ButtonDefaults.buttonColors] 以获取 [按钮] 的默认颜色。
 * - 查看 [ButtonDefaults.elevatedButtonColors] 以获取 [凸起按钮] 的默认颜色。
 * - 查看 [ButtonDefaults.textButtonColors] 以获取 [文本按钮] 的默认颜色。
 */
@Immutable
class 按钮颜色 constructor(
    val 容器颜色: Color,
    val 内容颜色: Color,
    val 禁用容器颜色: Color,
    val 禁用内容颜色: Color,
) {
    /** 返回此 ButtonColors 的副本，可选择性地覆盖部分值。此处使用 Color.Unspecified 表示"采用源对象中的值"。*/
    fun 复制(
        容器颜色: Color = this.容器颜色,
        内容颜色: Color = this.内容颜色,
        禁用容器颜色: Color = this.禁用容器颜色,
        禁用内容颜色: Color = this.禁用内容颜色,
    ) = 按钮颜色(
        容器颜色.takeOrElse { this.容器颜色 },
        内容颜色.takeOrElse { this.内容颜色 },
        禁用容器颜色.takeOrElse { this.禁用容器颜色 },
        禁用内容颜色.takeOrElse { this.禁用内容颜色 },
    )

    /**
     * 根据 [已启用] 状态表示此按钮的容器颜色。
     *
     * @param 已启用 按钮是否启用
     */
    @Stable
    internal fun 容器颜色(已启用: Boolean): Color =
        if (已启用) 容器颜色 else 禁用容器颜色

    /**
     * 根据 [已启用] 的不同状态，表示此按钮的内容颜色。
     *
     * @param 已启用 按钮是否启用
     */
    @Stable
    internal fun 内容颜色(已启用: Boolean): Color =
        if (已启用) 内容颜色 else 禁用内容颜色

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is 按钮颜色) return false

        if (容器颜色 != other.容器颜色) return false
        if (内容颜色 != other.内容颜色) return false
        if (禁用容器颜色 != other.禁用容器颜色) return false
        if (禁用内容颜色 != other.禁用内容颜色) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 容器颜色.hashCode()
        result = 31 * result + 内容颜色.hashCode()
        result = 31 * result + 禁用容器颜色.hashCode()
        result = 31 * result + 禁用内容颜色.hashCode()
        return result
    }
}

/**
 * 将用于按钮的形状。按钮会根据交互状态在这些形状之间变形过渡，前提是所有形状均为 [CornerBasedShape]。
 *
 * @property 形状 是活动形状。
 * @property 按压形状 是按下状态的形状。
 */
@ExperimentalMaterial3ExpressiveApi
@Immutable
class 按钮形状(val 形状: Shape, val 按压形状: Shape) {
    /** 返回此 ButtonShapes 的副本，可选择性地覆盖部分值。 */
    fun 复制(形状: Shape? = this.形状, 按压形状: Shape? = this.按压形状) =
        按钮形状(
            形状 = 形状.takeOrElse { this.形状 },
            按压形状 = 按压形状.takeOrElse { this.按压形状 },
        )

    internal fun Shape?.takeOrElse(block: () -> Shape): Shape = this ?: block()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is 按钮形状) return false

        if (形状 != other.形状) return false
        if (按压形状 != other.按压形状) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 形状.hashCode()
        result = 31 * result + 按压形状.hashCode()

        return result
    }
}

