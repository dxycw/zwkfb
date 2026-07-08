package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconButtonShapes
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.IconToggleButtonShapes
import androidx.compose.material3.Material3ExpressiveApi
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape



/**
 * [Material Design standard icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Standard icon button image](https://developer.android.com/images/reference/androidx/compose/material3/standard-icon-button.png)
 *
 * [内容] 通常应为 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为 24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为 48 x 48 dp，以满足无障碍访问指南。
 *
 * @param 单击回调  当此图标按钮被点击时调用
 * @param 修饰符 应用于此图标按钮的修饰符
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上和无障碍服务中显示为禁用状态。
 * @param 颜色集 用于解析此图标按钮在不同状态下所用颜色的 `IconButtonColors`。参见 `IconButtonDefaults.iconButtonVibrantColors`
 * 和 `IconButtonDefaults.iconButtonColors`。
 * @param 交互源 一个可选的托管 `MutableInteractionSource`，用于观察和发送此图标按钮的 `Interaction`。
 * 你可以用它来改变图标按钮的外观或在不同状态下预览图标按钮。注意，如果提供 `null`，交互仍会在内部发生。
 * @param 形状 此图标按钮的形状。
 * @param 内容 此图标按钮的内容，通常为 [图标]。
 */
@Suppress("ComposableNaming")
@Composable
fun 图标按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    交互源: MutableInteractionSource? = null,
    形状: Shape = IconButtonDefaults.standardShape,
    内容: @Composable () -> Unit,
) =
    IconButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        shape = 形状,
        content = 内容,
    )

/**
 * [Material Design standard icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Standard icon button image](https://developer.android.com/images/reference/androidx/compose/material3/small_icon_button_round_enabled_pressed.png)
 *
 * [内容] 通常应为 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为 24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为 48 x 48 dp，以满足无障碍访问指南。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 形状集  图标按钮根据用户与此图标按钮的交互，在不同状态之间变换的 [IconButtonShapes]。
 * @param 修饰符 应用于此图标按钮的修饰符
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上和无障碍服务中显示为禁用状态。
 * @param 颜色集 用于解析此图标按钮在不同状态下所用颜色的 [IconButtonColors]。参见 [IconButtonDefaults.iconButtonVibrantColors]
 * 和 [IconButtonDefaults.iconButtonColors]。
 * @param 交互源 一个可选的托管 [MutableInteractionSource]，用于观察和发送此图标按钮的 [Interaction]。
 * 你可以用它来改变图标按钮的外观或在不同状态下预览图标按钮。注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常为 [图标]。
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 图标按钮(
    单击回调: () -> Unit,
    形状集: IconButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    IconButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )


/**
 * [Material Design standard icon toggle button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时使用，例如在工具栏或图片列表中。
 *
 * ![Standard icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/standard-icon-toggle-button.png)
 *
 * [内容] 通常应为 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为 24 x 24 dp。
 * 此图标按钮的整体最小触摸目标尺寸为 48 x 48 dp，以满足无障碍访问指南。
 *
 * @param 已选中 此图标按钮是开启还是关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 修饰符 应用于该图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，该组件不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用状态。
 * @param 颜色集 用于解析该图标按钮在不同状态下所使用颜色的 [IconToggleButtonColors]。参见 [IconButtonDefaults.iconToggleButtonVibrantColors]
 * 和 [IconButtonDefaults.iconToggleButtonColors]。
 * @param 交互源 一个可选的提升状态 [MutableInteractionSource]，用于观察和发送该图标按钮的 [Interaction]。
 * 您可以使用此参数来改变图标按钮的外观，或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 形状 此图标按钮的 [Shape]（形状）。
 * @param 内容 此图标按钮的内容，通常为一个 [图标]。
 */
@Composable
fun 图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconToggleButtonColors = IconButtonDefaults.iconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    形状: Shape = IconButtonDefaults.standardShape,
    内容: @Composable () -> Unit,
) =
    IconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        shape = 形状,
        content = 内容,
    )

/**
 * [Material Design standard icon toggle button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中）使用它们。
 *
 * ![Standard icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/small_icon_button_round_unselected_select.png)
 *
 * [内容] 通常应为 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为 24 x 24 dp。
 * 该图标按钮的整体最小触控目标尺寸为 48 x 48 dp，以符合无障碍指南要求。
 *
 * @param 已选中 此按钮是开启还是关闭状态。
 * @param 已选中改变回调 当此图标按钮被点击时调用。
 * @param 形状集 该图标切换按钮将根据用户与此按钮的交互，在其间变形的 [IconToggleButtonShapes]。
 * @param 修饰符 应用于该图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，该组件不会响应用户输入，并且在外观上显示为禁用状态，同时对无障碍服务也呈现为禁用状态。
 * @param 颜色集 用于解析该图标按钮在不同状态下所使用颜色的 [IconToggleButtonColors]。参见 [IconButtonDefaults.iconToggleButtonVibrantColors]。
 * @param 交互源 一个可选的提升状态 [MutableInteractionSource]，用于观察和发送该图标按钮的 [Interaction]。
 * 您可以使用此参数来改变图标按钮的外观，或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常为一个 [图标]。
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状集: IconToggleButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconToggleButtonColors = IconButtonDefaults.iconToggleButtonVibrantColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    IconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )



/**
 * [Material Design filled icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），通常会使用它们。
 *
 * ![Filled icon button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-icon-button.png)
 *
 * [内容] 通常应为一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为 24 x 24 dp。
 * 为了满足无障碍访问标准，该图标按钮的整体最小触摸目标尺寸为 48 x 48 dp。
 *
 * @param 单击回调 当此图标按钮被点击时调用。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当设置为 `false` 时，该组件将不会响应用户输入，并且在视觉上显示为禁用状态，同时向无障碍服务报告为禁用。
 * @param 形状 定义此图标按钮容器的形状。
 * @param 颜色集 [IconButtonColors] 用于解析此图标按钮在不同状态下所使用颜色的 [IconButtonColors]。
 * 参见 [IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的提升（hoisted）[MutableInteractionSource]，用于观察和发出此图标按钮的 [Interaction] 交互事件。
 * 你可以利用它来改变图标按钮的外观，或在不同状态下预览该按钮。请注意，即使传入 null，内部仍然会发生交互行为。
 * @param 内容 此图标按钮的内容，通常为一个 [图标]。
 */
@Suppress("ComposableNaming")
@Composable
fun 填充图标按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色集: IconButtonColors = IconButtonDefaults.filledIconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledIconButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），通常会使用它们。
 *
 * ![Filled icon button image](https://developer.android.com/images/reference/androidx/compose/material3/small_filled_icon_button_round_enabled_pressed.png)
 *
 * [内容] 通常应为一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为 24 x 24 dp。
 * 为了满足无障碍访问标准，该图标按钮的整体最小触摸目标尺寸为 48 x 48 dp。
 *
 * @param 单击回调 当此图标按钮被点击时调用。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当设置为 `false` 时，该组件将不会响应用户输入，并且在视觉上显示为禁用状态，同时向无障碍服务报告为禁用。
 * @param 形状集 该图标按钮将根据用户与此按钮的交互，在其间变形的 [IconButtonShapes]（图标按钮形状集）。
 * @param 颜色集 用于解析此图标按钮在不同状态下所使用颜色的 [IconButtonColors]。参见 [IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的提升（hoisted）[MutableInteractionSource]，用于观察和发出此图标按钮的 [Interaction] 交互事件。
 * 你可以利用它来改变图标按钮的外观，或在不同状态下预览该按钮。请注意，即使传入 null，内部仍然会发生交互行为。
 * @param 内容 此图标按钮的内容，通常为一个 [图标]。
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 填充图标按钮(
    单击回调: () -> Unit,
    形状集: IconButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconButtonColors = IconButtonDefaults.filledIconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledIconButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中）使用它们。
 *
 * ![Filled icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-icon-toggle-button.png)
 *
 * [内容] 通常应为 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，请注意内部图标的典型尺寸为 24 x 24 dp。
 * 该图标按钮的整体最小触控目标尺寸为 48 x 48 dp，以符合无障碍指南要求。
 *
 * @param 已选中 该图标按钮是否处于切换开启或关闭状态。
 * @param 已选中改变回调 当此图标按钮被点击时调用。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 形状 定义此图标按钮容器的形状。
 * @param 颜色集 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.filledIconToggleButtonColors]。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发射此图标按钮的 [Interaction]。
 * 您可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]
 */
@Suppress("ComposableNaming")
@Composable
fun 填充图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色集: IconToggleButtonColors = IconButtonDefaults.filledIconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled icon toggle button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * ![Filled icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/small_filled_icon_button_round_unselected_select.png)
 *
 * [内容] 通常应该是一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型大小为 24 x 24 dp。此图标按钮的总体最小触摸目标尺寸为 48 x 48dp，以满足无障碍指南要求。
 *
 * @param 已选中 该图标按钮是否处于切换开启或关闭状态。
 * @param 已选中改变回调 当此图标按钮被点击时调用。
 * @param 形状集 图标按钮将根据用户与图标按钮的交互在 [IconButtonShapes] 之间变形。
 * @param 修饰符 应用于此图标按钮的 [Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 颜色集 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.filledIconToggleButtonColors]。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发射此图标按钮的 [Interaction]。
 * 您可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 填充图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状集: IconToggleButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconToggleButtonColors = IconButtonDefaults.filledIconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * ![Filled tonal icon button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-icon-button.png)
 *
 * 填充色调图标按钮是一种中等强调的图标按钮，是默认 [FilledIconButton] 和 [OutlinedIconButton] 之间的替代中间选择。
 * 它们可用于需要比轮廓按钮稍高强调的低优先级图标按钮场景。
 *
 * [内容] 通常应该是一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型大小为 24 x 24 dp。此图标按钮的总体最小触摸目标尺寸为 48 x 48dp，以满足无障碍指南要求。
 *
 * @param 单击回调 当此图标按钮被点击时调用。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 形状 定义此图标按钮容器的形状。
 * @param 颜色集 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发射此图标按钮的 [Interaction]。
 * 您可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]
 */
@Suppress("ComposableNaming")
@Composable
fun 填充色调图标按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色集: IconButtonColors = IconButtonDefaults.filledTonalIconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledTonalIconButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * ![Filled tonal icon button image](https://developer.android.com/images/reference/androidx/compose/material3/small_tonal_filled_icon_button_round_enabled_pressed.png)
 *
 * 填充色调图标按钮是一种中等强调的图标按钮，是默认 [FilledIconButton] 和 [OutlinedIconButton] 之间的替代中间选择。
 * 它们可用于需要比轮廓按钮稍高强调的低优先级图标按钮场景。
 *
 * [内容] 通常应该是一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型大小为 24 x 24 dp。此图标按钮的总体最小触摸目标尺寸为 48 x 48dp，以满足无障碍指南要求。
 *
 * @param 单击回调 当此图标按钮被点击时调用
 * @param 形状集 图标按钮将根据用户与图标按钮的交互在 [IconButtonShapes] 之间变形。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 颜色集 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.filledIconButtonColors]。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发射此图标按钮的 [Interaction]。
 * 您可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 填充色调图标按钮(
    单击回调: () -> Unit,
    形状集: IconButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconButtonColors = IconButtonDefaults.filledTonalIconButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledTonalIconButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal icon toggle button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * ![Filled tonal icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-icon-toggle-button.png)
 *
 * 填充色调切换图标按钮是一种中等强调的图标按钮，是默认 [FilledIconToggleButton] 和 [OutlinedIconToggleButton] 之间的替代中间选择。
 * 它们可用于需要比轮廓按钮稍高强调的低优先级图标按钮场景。
 *
 * [内容] 通常应该是一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型大小为 24 x 24 dp。此图标按钮的总体最小触摸目标尺寸为 48 x 48dp，以满足无障碍指南要求。
 *
 * @param 已选中 该图标按钮是否处于切换开启或关闭状态。
 * @param 已选中改变回调 当此图标按钮被点击时调用。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 形状 定义此图标按钮容器的形状。
 * @param 颜色集 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.filledIconToggleButtonColors]。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发射此图标按钮的 [Interaction]。
 * 您可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]
 */
@Suppress("ComposableNaming")
@Composable
fun 填充色调图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.filledShape,
    颜色集: IconToggleButtonColors = IconButtonDefaults.filledTonalIconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledTonalIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design filled tonal icon toggle button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * ![Filled tonal icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/small_tonal_filled_icon_button_round_unselected_select.png)
 *
 * 填充色调切换图标按钮是一种中等强调的图标按钮，是默认 [FilledIconToggleButton] 和 [OutlinedIconToggleButton] 之间的替代中间选择。
 * 它们可用于需要比轮廓按钮稍高强调的低优先级图标按钮场景。
 *
 * [内容] 通常应该是一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型大小为 24 x 24 dp。此图标按钮的总体最小触摸目标尺寸为 48 x 48dp，以满足无障碍指南要求。
 *
 * @param 已选中 该图标按钮是否处于切换开启或关闭状态。
 * @param 已选中改变回调 当此图标按钮被点击时调用。
 * @param 形状集 图标按钮将根据用户与图标按钮的交互在 [IconButtonShapes] 之间变形。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 颜色集 [IconToggleButtonColors] 用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.filledIconToggleButtonColors]。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发射此图标按钮的 [Interaction]。
 * 您可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]。
 */
@Suppress("ComposableNaming")
@Material3ExpressiveApi
@Composable
fun 填充色调图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状集: IconToggleButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconToggleButtonColors = IconButtonDefaults.filledTonalIconToggleButtonColors(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FilledTonalIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * ![Outlined icon button image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-icon-button.png)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * 当组件需要从背景中进行更多视觉分离时，使用此"包含式"图标按钮。
 *
 * [内容] 通常应该是一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型大小为 24 x 24 dp。轮廓图标按钮的总体最小触摸目标尺寸为 48 x 48dp，以满足无障碍指南要求。
 *
 * @param 单击回调 当此图标按钮被点击时调用。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 形状 定义此图标按钮容器和边框的形状（当 [边框] 不为 null 时）
 * @param 颜色集 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.outlinedIconButtonVibrantColors]
 * 和 [IconButtonDefaults.outlinedIconButtonColors]。
 * @param 边框 在此图标按钮容器周围绘制的边框。传递 `null` 表示无边框。参见 [IconButtonDefaults.outlinedIconButtonBorder] 和
 * [IconButtonDefaults.outlinedIconButtonBorder]。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发射此图标按钮的 [Interaction]。
 * 您可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]。
 */
@Suppress("ComposableNaming")
@Composable
fun 轮廓图标按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.outlinedShape,
    颜色集: IconButtonColors = IconButtonDefaults.outlinedIconButtonColors(),
    边框: BorderStroke? = IconButtonDefaults.outlinedIconButtonBorder(已启用),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    OutlinedIconButton(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined icon button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * ![Outlined icon button image](https://developer.android.com/images/reference/androidx/compose/material3/small_outlined_icon_button_round_enabled_pressed.png)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * 当组件需要从背景中进行更多视觉分离时，使用此"包含式"图标按钮。
 *
 * [内容] 通常应该是一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型大小为 24 x 24 dp。轮廓图标按钮的总体最小触摸目标尺寸为 48 x 48dp，以满足无障碍指南要求。
 *
 * @param 单击回调 当此图标按钮被点击时调用。
 * @param 形状集 图标按钮将根据用户与图标按钮的交互在 [IconButtonShapes] 之间变形。
 * @param 修饰符 应用于此图标按钮的 [Modifier]。
 * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 颜色集 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.outlinedIconButtonVibrantColors]
 * 和 [IconButtonDefaults.outlinedIconButtonColors]。
 * @param 边框 在此图标按钮容器周围绘制的边框。传递 `null` 表示无边框。参见 [IconButtonDefaults.outlinedIconButtonBorder]
 * 和 [IconButtonDefaults.outlinedIconButtonBorder]。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发射此图标按钮的 [Interaction]。
 * 您可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]
 */
@Material3ExpressiveApi
@Composable
fun 轮廓图标按钮(
    单击回调: () -> Unit,
    形状集: IconButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconButtonColors = IconButtonDefaults.outlinedIconButtonColors(),
    边框: BorderStroke? = IconButtonDefaults.outlinedIconButtonBorder(已启用),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    OutlinedIconButton(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined icon toggle button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮可帮助用户通过单次点击执行辅助操作。当需要紧凑的按钮时（例如在工具栏或图片列表中），会使用图标按钮。
 *
 * ![Outlined icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-icon-toggle-button.png)
 *
 * [内容] 通常应该是一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型大小为 24 x 24 dp。此图标按钮的总体最小触摸目标尺寸为 48 x 48dp，以满足无障碍指南要求。
 *
 * @param 已选中 此图标按钮是否处于切换开启或关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 修饰符 要应用到此图标按钮的 [Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为 false 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 形状 定义此图标按钮容器和边框的形状（当 [边框] 不为 null 时）
 * @param 颜色集 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下的颜色。参见 [IconButtonDefaults.outlinedIconToggleButtonVibrantColors]
 * 和 [IconButtonDefaults.outlinedIconToggleButtonColors]。
 * @param 边框 绘制在此图标按钮容器周围的边框。若无需边框，请传递 null。参见 [IconButtonDefaults.outlinedIconToggleButtonVibrantBorder]
 * 和 [IconButtonDefaults.outlinedIconToggleButtonBorder]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发出此图标按钮的 [Interaction]。
 * 您可以利用它来改变图标按钮的外观或预览其在不同状态下的效果。请注意，即使传递 null，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]
 */
@Suppress("ComposableNaming")
@Composable
fun 轮廓图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = IconButtonDefaults.outlinedShape,
    颜色集: IconToggleButtonColors = IconButtonDefaults.outlinedIconToggleButtonColors(),
    边框: BorderStroke? = IconButtonDefaults.outlinedIconToggleButtonBorder(已启用, 已选中),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    OutlinedIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined icon toggle button](https://m3.material.io/components/icon-button/overview)
 *
 * 图标按钮帮助用户通过单次点击执行辅助操作。它们适用于需要紧凑按钮的场景，例如在工具栏或图片列表中。
 *
 * ![Outlined icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/small_outlined_icon_button_round_unselected_select.png)
 *
 * [内容] 通常应为一个 [图标]（参见 [androidx.compose.material3.internal.Icons]）。如果使用自定义图标，
 * 请注意内部图标的典型尺寸为 24 x 24 dp。为了满足无障碍指南的要求，此图标按钮的整体最小触摸目标尺寸为 48 x 48 dp。
 *
 * @param 已选中 此图标按钮是否处于切换开启或关闭状态
 * @param 已选中改变回调 当此图标按钮被点击时调用
 * @param 形状集 [IconButtonShapes]，图标按钮将根据用户的交互在此形状之间进行形变。
 * @param 修饰符 应用于此图标按钮的 [Modifier]
 * @param 已启用 控制此图标按钮的启用状态。当为 false 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 颜色集 [IconToggleButtonColors]，用于解析此图标按钮在不同状态下的颜色。参见 [IconButtonDefaults.outlinedIconToggleButtonVibrantColors]。
 * @param 边框 绘制在此图标按钮容器周围的边框。若无需边框，请传递 null。参见 [IconButtonDefaults.outlinedIconToggleButtonVibrantBorder]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发出此图标按钮的 [Interaction]。
 * 您可以利用它来改变图标按钮的外观或预览其在不同状态下的效果。请注意，即使传递 null，交互仍会在内部发生。
 * @param 内容 此图标按钮的内容，通常是一个 [图标]
 */
@Material3ExpressiveApi
@Composable
fun 轮廓图标切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状集: IconToggleButtonShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: IconToggleButtonColors = IconButtonDefaults.outlinedIconToggleButtonVibrantColors(),
    边框: BorderStroke? =
        IconButtonDefaults.outlinedIconToggleButtonVibrantBorder(已启用, 已选中),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    OutlinedIconToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )



/**
 * 表示图标按钮在不同状态下使用的容器和内容颜色。
 *
 * @param 容器颜色 此图标按钮在启用状态下的容器颜色。
 * @param 内容颜色 此图标按钮在启用状态下的内容颜色。
 * @param 禁用容器颜色 此图标按钮在未启用状态下的容器颜色。
 * @param 禁用内容颜色 此图标按钮在未启用状态下的内容颜色。
 * @constructor 使用任意颜色创建实例。
 * - 参见 [IconButtonDefaults.filledIconButtonColors] 和 [IconButtonDefaults.filledTonalIconButtonColors]，
 * 了解 [FilledIconButton] 的默认颜色。
 * - 参见 [IconButtonDefaults.outlinedIconButtonVibrantColors]，了解 [OutlinedIconButton] 的默认颜色。
 */
fun 图标按钮颜色集(
    容器颜色: Color,
    内容颜色: Color,
    禁用容器颜色: Color,
    禁用内容颜色: Color,
) =
    IconButtonColors(
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledContentColor = 禁用内容颜色,
    )

/** 返回此 IconButtonColors 的副本，可以选择覆盖某些值。这里使用 Color.Unspecified 表示“使用源中的值”。*/
fun IconButtonColors.复制(
    容器颜色: Color = this.容器颜色,
    内容颜色: Color = this.内容颜色,
    禁用容器颜色: Color = this.禁用容器颜色,
    禁用内容颜色: Color = this.禁用内容颜色,
) =
    this.copy(
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledContentColor = 禁用内容颜色,
    )

//==================================================================================

val IconButtonColors.容器颜色: Color
    get() = this.containerColor

val IconButtonColors.内容颜色: Color
    get() = this.contentColor

val IconButtonColors.禁用容器颜色: Color
    get() = this.disabledContainerColor

val IconButtonColors.禁用内容颜色: Color
    get() = this.disabledContentColor

//==================================================================================

/**
 * 表示可切换图标按钮在不同状态下使用的容器和内容颜色。
 *
 * @param 容器颜色 此图标按钮在启用状态下的容器颜色。
 * @param 内容颜色 此图标按钮在启用状态下的内容颜色。
 * @param 禁用容器颜色 此图标按钮在未启用状态下的容器颜色。
 * @param 禁用内容颜色 此图标按钮在未启用状态下的内容颜色。
 * @param 已选中容器颜色 此图标按钮在选中状态下的容器颜色。
 * @param 已选中内容颜色 此图标按钮在选中状态下的内容颜色。
 * @constructor 使用任意颜色创建实例。
 * - 参见 [IconButtonDefaults.filledIconToggleButtonColors] 和 [IconButtonDefaults.filledTonalIconToggleButtonColors]，
 * 了解 [FilledIconButton] 的默认颜色。
 * - 参见 [IconButtonDefaults.outlinedIconToggleButtonVibrantColors]，了解可切换 [OutlinedIconButton] 的默认颜色。
 */
fun 图标切换按钮颜色集(
    容器颜色: Color,
    内容颜色: Color,
    禁用容器颜色: Color,
    禁用内容颜色: Color,
    已选中容器颜色: Color,
    已选中内容颜色: Color,
)  =
    IconToggleButtonColors(
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledContentColor = 禁用内容颜色,
        checkedContainerColor = 已选中容器颜色,
        checkedContentColor = 已选中内容颜色,
    )

/** 返回此 IconToggleButtonColors 的副本，可以选择覆盖某些值。这里使用 Color.Unspecified 表示“使用源中的值”。*/
fun IconToggleButtonColors.复制(
    容器颜色: Color = this.containerColor,
    内容颜色: Color = this.contentColor,
    禁用容器颜色: Color = this.disabledContainerColor,
    禁用内容颜色: Color = this.disabledContentColor,
    已选中容器颜色: Color = this.checkedContainerColor,
    已选中内容颜色: Color = this.checkedContentColor,
) =
    this.copy(
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledContentColor = 禁用内容颜色,
        checkedContainerColor = 已选中容器颜色,
        checkedContentColor = 已选中内容颜色,
    )


//======================================================================

val IconToggleButtonColors.容器颜色: Color
    get() = this.containerColor

val IconToggleButtonColors.内容颜色: Color
    get() = this.contentColor

val IconToggleButtonColors.禁用容器颜色: Color
    get() = this.disabledContainerColor

val IconToggleButtonColors.禁用内容颜色: Color
    get() = this.disabledContentColor

val IconToggleButtonColors.已选中容器颜色: Color
    get() = this.checkedContainerColor

val IconToggleButtonColors.已选中内容颜色: Color
    get() = this.checkedContentColor

//======================================================================

/**
 * 将用于图标按钮的形状。图标按钮将根据其交互状态在这些形状之间进行形变，前提是所有形状均为 [CornerBasedShape]。
 *
 * @param 形状 是未选中状态的形状。
 * @param 按压形状 是按下状态的形状。
 */
fun 图标按钮形状集(形状: Shape, 按压形状: Shape = 形状) =
    IconButtonShapes(shape = 形状, pressedShape = 按压形状)

/** 返回此 IconButtonShapes 的副本，可以选择覆盖某些值。 */
fun IconButtonShapes.复制(形状: Shape? = this.shape, 按压形状: Shape? = this.pressedShape) =
    this.copy(
        shape = 形状,
        pressedShape = 按压形状,
    )

//======================================================================

val IconButtonShapes.形状: Shape
    get() = this.shape

val IconButtonShapes.按压形状: Shape
    get() = this.pressedShape


//======================================================================

/**
 * 将用于切换按钮的形状。切换按钮将根据其交互状态在这三种形状之间进行形变，前提是所有形状均为 [CornerBasedShape]。
 *
 * @param 形状 是未选中状态的形状。
 * @param 按压形状 是按下状态的形状。
 * @param 已选中形状 是选中状态的形状。
 */
fun 图标切换按钮形状集(
    形状: Shape,
    按压形状: Shape = 形状,
    已选中形状: Shape = 形状,
) =
    IconToggleButtonShapes(
        shape = 形状,
        pressedShape = 按压形状,
        checkedShape = 已选中形状,
    )

/** 返回此 IconButtonShapes 的副本，可以选择覆盖某些值。 */
fun IconToggleButtonShapes.复制(
    形状: Shape? = this.shape,
    按压形状: Shape? = this.pressedShape,
    已选中形状: Shape? = this.checkedShape,
) =
    this.copy(
        shape = 形状,
        pressedShape = 按压形状,
        checkedShape = 已选中形状,
    )

//======================================================================

val IconToggleButtonShapes.形状: Shape
    get() = this.shape

val IconToggleButtonShapes.按压形状: Shape
    get() = this.pressedShape

val IconToggleButtonShapes.已选中形状: Shape
    get() = this.checkedShape

//======================================================================