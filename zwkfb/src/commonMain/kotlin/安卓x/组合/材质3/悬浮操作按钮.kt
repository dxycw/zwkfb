package 安卓x.组合.材质3

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.LargeExtendedFloatingActionButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MediumExtendedFloatingActionButton
import androidx.compose.material3.MediumFloatingActionButton
import androidx.compose.material3.SmallExtendedFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.animateFloatingActionButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design floating action button](https://m3.material.io/components/floating-action-button/overview)
 *
 * FAB 代表屏幕上最重要的操作。它将关键操作置于触手可及的位置。
 *
 * ![FAB image](https://developer.android.com/images/reference/androidx/compose/material3/fab.png)
 *
 * FAB 通常包含一个图标，如需带有文本和图标的 FAB，请参阅 [ExtendedFloatingActionButton]。
 *
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [containerColor] 对应的匹配内容色，或者当 [containerColor]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 用于解析此 FAB 在不同状态下海拔高度的 [FloatingActionButtonElevation]。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此 FAB 的内容，通常为 [图标]。
 */
@Suppress("ComposableNaming")
@Composable
fun 悬浮操作按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = FloatingActionButtonDefaults.shape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    FloatingActionButton(
        onClick = 单击回调,
        modifier = 修饰符,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design small floating action button](https://m3.material.io/components/floating-action-button/overview)
 *
 * FAB 代表屏幕上最重要的操作。它将关键操作置于触手可及的位置。
 *
 * ![Small FAB image](https://developer.android.com/images/reference/androidx/compose/material3/small-fab.png)
 *
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此 FAB 的内容，通常为 [图标]。
 */
@Suppress("ComposableNaming")
@Composable
fun 小型悬浮操作按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = FloatingActionButtonDefaults.smallShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    SmallFloatingActionButton(
        onClick = 单击回调,
        modifier = 修饰符,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )


/**
 * [Material Design medium floating action button](https://m3.material.io/components/floating-action-button/overview)
 *
 * FAB 代表屏幕上最重要的操作。它将关键操作置于触手可及的位置。
 *
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此 FAB 的内容，通常为 [图标]。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 中等悬浮操作按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = FloatingActionButtonDefaults.mediumShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    MediumFloatingActionButton(
        onClick = 单击回调,
        modifier = 修饰符,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )


/**
 * [Material Design large floating action button](https://m3.material.io/components/floating-action-button/overview)
 *
 * FAB 代表屏幕上最重要的操作。它将关键操作置于触手可及的位置。
 *
 * ![Large FAB image](https://developer.android.com/images/reference/androidx/compose/material3/large-fab.png)
 *
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此 FAB 的内容，通常为 [图标]。
 */
@Suppress("ComposableNaming")
@Composable
fun 大型悬浮操作按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = FloatingActionButtonDefaults.largeShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    LargeFloatingActionButton(
        onClick = 单击回调,
        modifier = 修饰符,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )


// TODO 图片链接
/**
 * [Material Design small extended floating action button](https://m3.material.io/components/extended-fab/overview)
 *
 * 扩展 FAB 帮助用户执行主要操作。它们比 FAB 更宽，以容纳文本标签和更大的目标区域。
 *
 * 另一个小型扩展浮动操作按钮的重载支持文本标签和图标。
 *
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此 FAB 的内容，通常为 [文本] 标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 小型扩展悬浮操作按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = FloatingActionButtonDefaults.smallExtendedFabShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    SmallExtendedFloatingActionButton(
        onClick = 单击回调,
        modifier = 修饰符,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )


// TODO 图片链接
/**
 * [Material Design medium extended floating action button](https://m3.material.io/components/extended-fab/overview)
 *
 * 扩展 FAB 帮助用户执行主要操作。它们比 FAB 更宽，以容纳文本标签和更大的目标区域。
 *
 * 另一个中等扩展浮动操作按钮的重载支持文本标签和图标。
 *
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此 FAB 的内容，通常为 [文本] 标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 中等扩展悬浮操作按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = FloatingActionButtonDefaults.mediumExtendedFabShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    MediumExtendedFloatingActionButton(
        onClick = 单击回调,
        modifier = 修饰符,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容
    )


// TODO 图片链接
/**
 * [Material Design large extended floating action button](https://m3.material.io/components/extended-fab/overview)
 *
 * 扩展 FAB 帮助用户执行主要操作。它们比 FAB 更宽，以容纳文本标签和更大的目标区域。
 *
 * 另一个大型扩展浮动操作按钮的重载支持文本标签和图标。
 *
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此 FAB 的内容，通常为 [文本] 标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 大型扩展悬浮操作按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = FloatingActionButtonDefaults.largeExtendedFabShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    LargeExtendedFloatingActionButton(
        onClick = 单击回调,
        modifier = 修饰符,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )


/**
 * [Material Design extended floating action button](https://m3.material.io/components/extended-fab/overview)
 *
 * 扩展 FAB 帮助用户执行主要操作。它们比 FAB 更宽，以容纳文本标签和更大的目标区域。
 *
 * ![Extended FAB image](https://developer.android.com/images/reference/androidx/compose/material3/extended-fab.png)
 *
 * 另一个扩展浮动操作按钮的重载支持文本标签和图标。
 *
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此 FAB 的内容，通常为 [文本] 标签。
 */
@Suppress("ComposableNaming")
@Composable
fun 扩展悬浮操作按钮(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    形状: Shape = FloatingActionButtonDefaults.extendedFabShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    ExtendedFloatingActionButton(
        onClick = 单击回调,
        modifier = 修饰符,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )


/**
 * [Material Design small extended floating action button](https://m3.material.io/components/extended-fab/overview)
 *
 * 扩展 FAB 帮助用户执行主要操作。它们比 FAB 更宽，以容纳文本标签和更大的目标区域。
 *
 * 另一个不带图标的小型扩展浮动操作按钮重载。
 *
 * 无障碍功能的默认内容描述继承自扩展 FAB 的图标。如需自定义行为，可通过 [Modifier.semantics] 提供你自己的描述。
 *
 * @param 文本 显示在此 FAB 内部的标签。
 * @param 图标 此 FAB 的图标，通常为 [图标]。
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 已展开 控制此 FAB 的展开状态。在展开状态下，FAB 会同时显示 [图标] 和 [文本]；在收起状态下，FAB 仅显示 [图标]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 小型扩展悬浮操作按钮(
    文本: @Composable () -> Unit,
    图标: @Composable () -> Unit,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已展开: Boolean = true,
    形状: Shape = FloatingActionButtonDefaults.smallExtendedFabShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
) =
    SmallExtendedFloatingActionButton(
        text = 文本,
        icon = 图标,
        onClick = 单击回调,
        modifier = 修饰符,
        expanded = 已展开,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
    )

/**
 * [Material Design medium extended floating action button](https://m3.material.io/components/extended-fab/overview)
 *
 * 扩展 FAB 帮助用户执行主要操作。它们比 FAB 更宽，以容纳文本标签和更大的目标区域。
 *
 * 另一个不带图标的中等扩展浮动操作按钮重载。
 *
 * 无障碍功能的默认内容描述继承自扩展 FAB 的图标。如需自定义行为，可通过 [Modifier.semantics] 提供你自己的描述。
 *
 * @param 文本 显示在此 FAB 内部的标签。
 * @param 图标 此 FAB 的图标，通常为 [图标]。
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 已展开 控制此 FAB 的展开状态。在展开状态下，FAB 会同时显示 [图标] 和 [文本]；在收起状态下，FAB 仅显示 [图标]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 中等扩展悬浮操作按钮(
    文本: @Composable () -> Unit,
    图标: @Composable () -> Unit,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已展开: Boolean = true,
    形状: Shape = FloatingActionButtonDefaults.mediumExtendedFabShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
) =
    MediumExtendedFloatingActionButton(
        text = 文本,
        icon = 图标,
        onClick = 单击回调,
        modifier = 修饰符,
        expanded = 已展开,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
    )

/**
 * [Material Design large extended floating action button](https://m3.material.io/components/extended-fab/overview)
 *
 * 扩展 FAB 帮助用户执行主要操作。它们比 FAB 更宽，以容纳文本标签和更大的目标区域。
 *
 * 另一个不带图标的大型扩展浮动操作按钮重载。
 *
 * 无障碍功能的默认内容描述继承自扩展 FAB 的图标。如需自定义行为，可通过 [Modifier.semantics] 提供你自己的描述。
 *
 * @param 文本 显示在此 FAB 内部的标签。
 * @param 图标 此 FAB 的图标，通常为 [图标]。
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 已展开 控制此 FAB 的展开状态。在展开状态下，FAB 会同时显示 [图标] 和 [文本]；在收起状态下，FAB 仅显示 [图标]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 大型扩展悬浮操作按钮(
    文本: @Composable () -> Unit,
    图标: @Composable () -> Unit,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已展开: Boolean = true,
    形状: Shape = FloatingActionButtonDefaults.largeExtendedFabShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
) =
    LargeExtendedFloatingActionButton(
        text = 文本,
        icon = 图标,
        onClick = 单击回调,
        modifier = 修饰符,
        expanded = 已展开,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
    )

/**
 * [Material Design extended floating action button](https://m3.material.io/components/extended-fab/overview)
 *
 * 扩展 FAB 帮助用户执行主要操作。它们比 FAB 更宽，以容纳文本标签和更大的目标区域。
 *
 * ![Extended FAB image](https://developer.android.com/images/reference/androidx/compose/material3/extended-fab.png)
 *
 * 另一个扩展浮动操作按钮的重载适用于不带图标的 FAB。
 *
 * 无障碍功能的默认内容描述继承自扩展 FAB 的图标。如需自定义行为，可通过 [Modifier.semantics] 提供你自己的描述。
 *
 * @param 文本 显示在此 FAB 内部的标签。
 * @param 图标 此 FAB 的图标，通常为 [图标]。
 * @param 单击回调 当此 FAB 被点击时调用。
 * @param 修饰符 要应用于此 FAB 的 [Modifier]。
 * @param 已展开 控制此 FAB 的展开状态。在展开状态下，FAB 会同时显示 [图标] 和 [文本]；在收起状态下，FAB 仅显示 [图标]。
 * @param 形状 定义此 FAB 容器和阴影（使用 [阴影] 时）的形状。
 * @param 容器颜色 此 FAB 背景所使用的颜色。使用 [Color.Transparent] 表示无颜色。
 * @param 内容颜色 此 FAB 内部内容的首选颜色。默认为 [容器颜色] 对应的匹配内容色，或者当 [容器颜色]
 * 不是主题中的颜色时，默认为当前的 [LocalContentColor]。
 * @param 阴影 [FloatingActionButtonElevation]，用于解析此 FAB 在不同状态下的海拔高度。这控制 FAB 下方阴影的大小。
 * 此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。另请参阅：[表面]。
 * @param 交互源 一个可选的提升状态的 [MutableInteractionSource]，用于观察和发送此 FAB 的 [Interaction]。
 * 你可以用它来改变 FAB 的外观或在不同状态下预览 FAB。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 扩展悬浮操作按钮(
    文本: @Composable () -> Unit,
    图标: @Composable () -> Unit,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已展开: Boolean = true,
    形状: Shape = FloatingActionButtonDefaults.extendedFabShape,
    容器颜色: Color = FloatingActionButtonDefaults.containerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    阴影: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    交互源: MutableInteractionSource? = null,
) =
    ExtendedFloatingActionButton(
        text = 文本,
        icon = 图标,
        onClick = 单击回调,
        modifier = 修饰符,
        expanded = 已展开,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        elevation = 阴影,
        interactionSource = 交互源,
    )


/** 包含 [FloatingActionButton] 使用的默认值。 */
object 悬浮操作按钮默认值 { // FloatingActionButtonDefaults

    /** [MediumFloatingActionButton] 内部图标的推荐尺寸。 */
    @ExperimentalMaterial3ExpressiveApi
    val 中等图标大小 = FloatingActionButtonDefaults.MediumIconSize

    /** [LargeFloatingActionButton] 内部图标的推荐尺寸。 */
    val 大型图标大小 = FloatingActionButtonDefaults.LargeIconSize // TODO: FabLargeTokens.IconSize 不正确

    /** 浮动操作按钮的默认形状。 */
    val 形状: Shape
        @Composable get() = FloatingActionButtonDefaults.shape

    /** 小型浮动操作按钮的默认形状。 */
    val 小型形状: Shape
        @Composable get() = FloatingActionButtonDefaults.smallShape

    /** 中型浮动操作按钮的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 中等形状: Shape
        @Composable get() = FloatingActionButtonDefaults.mediumShape // TODO: 更新以使用 token

    /** 大型浮动操作按钮的默认形状。 */
    val 大型形状: Shape
        @Composable get() = FloatingActionButtonDefaults.largeShape

    /** 扩展浮动操作按钮的默认形状。 */
    val 已扩展悬浮形状: Shape
        @Composable get() = FloatingActionButtonDefaults.extendedFabShape

    /** 小型扩展浮动操作按钮的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 小型已扩展悬浮形状: Shape
        @Composable get() = FloatingActionButtonDefaults.smallExtendedFabShape

    /** 中型扩展浮动操作按钮的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 中等已扩展悬浮形状: Shape
        @Composable get() = FloatingActionButtonDefaults.mediumExtendedFabShape // TODO: 更新以使用 token

    /** 大型扩展浮动操作按钮的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 大型已扩展悬浮形状: Shape
        @Composable get() = FloatingActionButtonDefaults.largeExtendedFabShape

    /** 浮动操作按钮的默认容器颜色。 */
    val 容器颜色: Color
        @Composable get() = FloatingActionButtonDefaults.containerColor

    /**
     *  创建一个 [FloatingActionButtonElevation]，用于表示 [FloatingActionButton] 在不同状态下的海拔高度。
     *  对于需要较不突出的 [FloatingActionButton] 的用例，请考虑使用 [降低阴影]。
     *
     * @param 默认阴影 [FloatingActionButton] 没有其他 [Interaction] 时使用的海拔高度。
     * @param 按下阴影 当 [FloatingActionButton] 被按下时使用的海拔高度。
     * @param 聚焦阴影 当 [FloatingActionButton] 获得焦点时使用的高度。
     * @param 悬停阴影 当 [FloatingActionButton] 被悬停时使用的高度。
     */
    @Composable
    fun 阴影(
        默认阴影: Dp = 6.0.dp,
        按下阴影: Dp = 6.0.dp,
        聚焦阴影: Dp = 6.0.dp,
        悬停阴影: Dp = 6.0.dp,
    ): FloatingActionButtonElevation =
        FloatingActionButtonDefaults.elevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
        )

    /**
     * 使用此参数创建一个降低高度的 [FloatingActionButton]，以减少视觉强调。使用 [阴影] 获取普通高度的 [FloatingActionButton]。
     *
     * @param 默认阴影 当 [FloatingActionButton] 没有其他 [Interaction] 时使用的高度。
     * @param 按下阴影 当 [FloatingActionButton] 被按下时使用的高度。
     * @param 聚焦阴影 当 [FloatingActionButton] 获得焦点时使用的高度。
     * @param 悬停阴影 当 [FloatingActionButton] 被悬停时使用的高度。
     */
    @Composable
    fun 降低阴影(
        默认阴影: Dp = 1.0.dp,
        按下阴影: Dp = 1.0.dp,
        聚焦阴影: Dp = 1.0.dp,
        悬停阴影: Dp = 3.0.dp,
    ): FloatingActionButtonElevation =
        FloatingActionButtonDefaults.loweredElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
        )

    /**
     * 使用此函数创建一个 [FloatingActionButton]，用于表示在不同状态下与 [底部应用栏] 配合使用的 [FloatingActionButton] 的默认高度。
     *
     * @param 默认阴影 当 [FloatingActionButton] 没有其他 [Interaction] 时使用的高度。
     * @param 按下阴影 当 [FloatingActionButton] 被按下时使用的高度。
     * @param 聚焦阴影 当 [FloatingActionButton] 获得焦点时使用的高度。
     * @param 悬停阴影 当 [FloatingActionButton] 被悬停时使用的高度。
     */
    fun 底部应用栏悬浮阴影(
        默认阴影: Dp = 0.dp,
        按下阴影: Dp = 0.dp,
        聚焦阴影: Dp = 0.dp,
        悬停阴影: Dp = 0.dp,
    ): FloatingActionButtonElevation =
        FloatingActionButtonDefaults.bottomAppBarFabElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
        )

}

/**
 * 将此修饰符应用于 [FloatingActionButton]，以动画方式显示或隐藏它，通常基于应用主内容的滚动状态。
 *
 * @param 可见 FAB 是否应以动画方式显示或隐藏。
 * @param 对齐 FAB 应缩放朝向的方向。
 * @param 目标缩放 显示 FAB 时的初始缩放值，以及隐藏 FAB 时的最终缩放值。
 * @param 缩放动画规格 动画缩放部分使用的 [AnimationSpec]，如果为 null，则使用 [MotionScheme] 中的 Fast Spatial 弹性动画规范。
 * @param 透明度动画规格 动画透明度部分使用的 [AnimationSpec]，如果为 null，则使用 [MotionScheme] 中的 Fast Effects 弹性动画规范。
 */
@ExperimentalMaterial3ExpressiveApi
fun Modifier.动画悬浮操作按钮(
    可见: Boolean,
    对齐: Alignment,
    目标缩放: Float = 0.2f,
    缩放动画规格: AnimationSpec<Float>? = null,
    透明度动画规格: AnimationSpec<Float>? = null,
): Modifier =
    this.animateFloatingActionButton(
        visible = 可见,
        alignment = 对齐,
        targetScale = 目标缩放,
        scaleAnimationSpec = 缩放动画规格,
        alphaAnimationSpec = 透明度动画规格,
    )

