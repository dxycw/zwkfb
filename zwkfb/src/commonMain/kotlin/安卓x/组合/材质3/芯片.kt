package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * [Material Design assist chip](https://m3.material.io/components/chips/overview)
 *
 * 芯片帮助用户输入信息、做出选择、过滤内容或触发操作。芯片可以在同一区域展示多个交互元素，例如可选的电影时间列表或一系列
 * 电子邮件联系人。
 *
 * 辅助芯片代表可以跨越多个应用的智能或自动化操作，例如从主屏幕打开日历事件。辅助芯片的功能类似于用户请求助手完成该操作。
 * 它们应该在界面中动态且根据上下文出现。
 *
 * ![Assist chip image](https://developer.android.com/images/reference/androidx/compose/material3/assist-chip.png)
 *
 * 这个辅助芯片应用了扁平样式。如果你想要提升样式，请使用 [ElevatedAssistChip]。
 *
 * @param 单击回调 当此芯片被点击时调用。
 * @param 标签 此芯片的文本标签。
 * @param 修饰符 应用于该芯片的 [Modifier]。
 * @param 已启用 控制此芯片的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导图标 芯片开头可选的图标，位于 [标签] 文本之前。
 * @param 尾随图标 芯片末端可选的图标。
 * @param 形状 定义此芯片容器、边框（当 [边框] 不为 null 时）和阴影（当使用 [阴影] 时）的形状。
 * @param 颜色集 [ChipColors]，用于解析此芯片在不同状态下使用的颜色。请参阅 [AssistChipDefaults.assistChipColors]。
 * @param 阴影 用于解析此芯片在不同状态下高度的 [ChipElevation]。这控制芯片下方阴影的大小。此外，当容器颜色为
 * [ColorScheme.surface] 时，这控制作为主色调叠加层应用的数量。请参阅 [AssistChipDefaults.assistChipElevation]。
 * @param 边框 围绕此芯片容器绘制的边框。传入 `null` 表示无边框。请参阅 [AssistChipDefaults.assistChipBorder]。
 * @param 水平排列 芯片子项的水平排列方式。如果没有图标，那么 [标签] 和 [边框] 之间的水平内边距将是 [内容内边距]
 * 与此 [水平排列] 中间距的总和。
 * @param 内容内边距 此芯片内容的内边距，包括 [前导图标]、[标签] 和 [尾随图标]。请参阅 [AssistChipDefaults.ContentPadding]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此芯片的 [Interaction]。
 * 您可以使用它来更改芯片的外观或在不同状态下预览芯片。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 辅助芯片(
    单击回调: () -> Unit,
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = AssistChipDefaults.shape,
    颜色集: ChipColors = AssistChipDefaults.assistChipColors(),
    阴影: ChipElevation? = AssistChipDefaults.assistChipElevation(),
    边框: BorderStroke? = AssistChipDefaults.assistChipBorder(已启用),
    水平排列: Arrangement.Horizontal = AssistChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = AssistChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    AssistChip(
        onClick = 单击回调,
        label = 标签,
        modifier = 修饰符,
        enabled = 已启用,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        horizontalArrangement = 水平排列,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )


/**
 * [Material Design elevated assist chip](https://m3.material.io/components/chips/overview)
 *
 * 芯片帮助用户输入信息、做出选择、过滤内容或触发操作。芯片可以在同一区域展示多个交互元素，例如可选的电影时间列表或一系列
 * 电子邮件联系人。
 *
 * 辅助芯片代表可以跨越多个应用的智能或自动化操作，例如从主屏幕打开日历事件。辅助芯片的功能类似于用户请求助手完成该操作。
 * 它们应该在界面中动态且根据上下文出现。
 *
 * ![Assist chip image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-assist-chip.png)
 *
 * 这个辅助芯片应用了提升样式。如果你想要扁平样式，请使用 [AssistChip]。
 *
 * @param 单击回调 当此芯片被点击时调用。
 * @param 标签 此芯片的文本标签。
 * @param 修饰符 应用于该芯片的 [Modifier]。
 * @param 已启用 控制此芯片的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导图标 芯片开头可选的图标，位于 [标签] 文本之前。
 * @param 尾随图标 芯片末端可选的图标。
 * @param 形状 定义此芯片容器、边框（当 [边框] 不为 null 时）和阴影（当使用 [阴影] 时）的形状。
 * @param 颜色集 [ChipColors]，用于解析此芯片在不同状态下使用的颜色。请参阅 [AssistChipDefaults.elevatedAssistChipColors]。
 * @param 阴影 用于解析此芯片在不同状态下高度的 [ChipElevation]。这控制芯片下方阴影的大小。此外，当容器颜色为
 * [ColorScheme.surface] 时，这控制作为主色调叠加层应用的数量。请参阅 [AssistChipDefaults.elevatedAssistChipElevation]。
 * @param 边框 围绕此芯片容器绘制的边框。
 * @param 水平排列 芯片子项的水平排列方式。如果没有图标，那么 [标签] 和 [边框] 之间的水平内边距将是
 * [内容内边距] 与此 [水平排列] 中间距的总和。
 * @param 内容内边距 此芯片内容的内边距，包括 [前导图标]、[标签] 和 [尾随图标]。请参阅 [AssistChipDefaults.ContentPadding]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此芯片的 [Interaction]。
 * 您可以使用它来更改芯片的外观或在不同状态下预览芯片。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 凸起辅助芯片(
    单击回调: () -> Unit,
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = AssistChipDefaults.shape,
    颜色集: ChipColors = AssistChipDefaults.elevatedAssistChipColors(),
    阴影: ChipElevation? = AssistChipDefaults.elevatedAssistChipElevation(),
    边框: BorderStroke? = null,
    水平排列: Arrangement.Horizontal = AssistChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = AssistChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    ElevatedAssistChip(
        onClick = 单击回调,
        label = 标签,
        modifier = 修饰符,
        enabled = 已启用,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        horizontalArrangement = 水平排列,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )


/**
 * [Material Design filter chip](https://m3.material.io/components/chips/overview)
 *
 * 芯片帮助用户输入信息、做出选择、过滤内容或触发操作。芯片可以在同一区域展示多个交互元素，例如可选的电影时间列表或一系列
 * 电子邮件联系人。
 *
 * 过滤芯片使用标签或描述性词语来过滤内容。它们可以作为切换按钮或复选框的良好替代方案。
 *
 * ![Filter chip image](https://developer.android.com/images/reference/androidx/compose/material3/filter-chip.png)
 *
 * 这个过滤芯片应用了扁平样式。如果你想要提升样式，请使用 [ElevatedFilterChip]。
 *
 * 点击过滤芯片会切换其选中状态。可以提供选中状态的 [前导图标]（例如对勾），显示在芯片标签的起始边缘。
 *
 * @param 已选择 此芯片是否被选中。
 * @param 单击回调 当此芯片被点击时调用。
 * @param 标签 此芯片的文本标签。
 * @param 修饰符 应用于该芯片的 [Modifier]。
 * @param 已启用 控制此芯片的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导图标 芯片开头可选的图标，位于 [标签] 文本之前。当 [已选择] 为 true 时，此图标可以视觉上指示该
 * 芯片已被选中（例如，通过对勾图标）。
 * @param 尾随图标 芯片末端可选的图标。
 * @param 形状 定义此芯片容器、边框（当 [边框] 不为 null 时）和阴影（当使用 [阴影] 时）的形状。
 * @param 颜色集 [SelectableChipColors]，用于解析此芯片在不同状态下使用的颜色。请参阅 [FilterChipDefaults.filterChipColors]。
 * @param 阴影 用于解析此芯片在不同状态下高度的 [SelectableChipElevation]。这控制芯片下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加层应用的数量。请参阅 [FilterChipDefaults.filterChipElevation]。
 * @param 边框 围绕此芯片容器绘制的边框。传入 `null` 表示无边框。请参阅 [FilterChipDefaults.filterChipBorder]。
 * @param 水平排列 芯片子项的水平排列方式。如果没有图标，那么 [标签] 和 [边框] 之间的水平内边距将是
 * [内容内边距] 与此 [水平排列] 中间距的总和。
 * @param 内容内边距 此芯片内容的内边距，包括 [前导图标]、[标签] 和 [尾随图标]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此芯片的 [Interaction]。
 * 您可以使用它来更改芯片的外观或在不同状态下预览芯片。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 过滤芯片(
    已选择: Boolean,
    单击回调: () -> Unit,
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = FilterChipDefaults.shape,
    颜色集: SelectableChipColors = FilterChipDefaults.filterChipColors(),
    阴影: SelectableChipElevation? = FilterChipDefaults.filterChipElevation(),
    边框: BorderStroke? = FilterChipDefaults.filterChipBorder(已启用, 已选择),
    水平排列: Arrangement.Horizontal = FilterChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = FilterChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    FilterChip(
        selected = 已选择,
        onClick = 单击回调,
        label = 标签,
        modifier = 修饰符,
        enabled = 已启用,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        horizontalArrangement = 水平排列,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )



/**
 * [Material Design elevated filter chip](https://m3.material.io/components/chips/overview)
 *
 * 芯片帮助用户输入信息、做出选择、过滤内容或触发操作。芯片可以在同一区域展示多个交互元素，例如可选的电影时间列表或一系列电子邮件联系人。
 *
 * 过滤芯片使用标签或描述性词语来过滤内容。它们可以作为切换按钮或复选框的良好替代方案。
 *
 * ![Filter chip image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-filter-chip.png)
 *
 * 这个过滤芯片应用了提升样式。如果你想要扁平样式，请使用 [FilterChip]。
 *
 * 点击过滤芯片会切换其选中状态。可以提供选中状态的 [前导图标]（例如对勾），显示在芯片标签的起始边缘。
 *
 * @param 已选择 此芯片是否被选中。
 * @param 单击回调 当此芯片被点击时调用。
 * @param 标签 此芯片的文本标签。
 * @param 修饰符 应用于该芯片的 [Modifier]。
 * @param 已启用 控制此芯片的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导图标 芯片开头可选的图标，位于 [标签] 文本之前。当 [已选择] 为 true 时，此图标可以视觉上指示该芯片已被选中（例如，通过对勾图标）。
 * @param 尾随图标 芯片末端可选的图标。
 * @param 形状 定义此芯片容器、边框（当 [边框] 不为 null 时）和阴影（当使用 [阴影] 时）的形状。
 * @param 颜色集 [SelectableChipColors]，用于解析此芯片在不同状态下使用的颜色。请参阅 [FilterChipDefaults.elevatedFilterChipColors]。
 * @param 阴影 用于解析此芯片在不同状态下高度的 [SelectableChipElevation]。这控制芯片下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加层应用的数量。请参阅 [FilterChipDefaults.filterChipElevation]。
 * @param 边框 围绕此芯片容器绘制的边框。传入 `null` 表示无边框。请参阅 [FilterChipDefaults.filterChipBorder]。
 * @param 水平排列 芯片子项的水平排列方式。如果没有图标，那么 [标签] 和 [边框] 之间的水平内边距将是
 * [内容内边距] 与此 [水平排列] 中间距的总和。
 * @param 内容内边距 此芯片内容的内边距，包括 [前导图标]、[标签] 和 [尾随图标]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此芯片的 [Interaction]。
 * 您可以使用它来更改芯片的外观或在不同状态下预览芯片。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 凸起过滤芯片(
    已选择: Boolean,
    单击回调: () -> Unit,
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = FilterChipDefaults.shape,
    颜色集: SelectableChipColors = FilterChipDefaults.elevatedFilterChipColors(),
    阴影: SelectableChipElevation? = FilterChipDefaults.elevatedFilterChipElevation(),
    边框: BorderStroke? = null,
    水平排列: Arrangement.Horizontal = FilterChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = FilterChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    ElevatedFilterChip(
        selected = 已选择,
        onClick = 单击回调,
        label = 标签,
        modifier = 修饰符,
        enabled = 已启用,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        horizontalArrangement = 水平排列,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )


/**
 * [Material Design input chip](https://m3.material.io/components/chips/overview)
 *
 * 芯片帮助用户输入信息、做出选择、过滤内容或触发操作。芯片可以在同一区域展示多个交互元素，例如可选的电影时间列表或一系列
 * 电子邮件联系人。
 *
 * 输入芯片代表用户输入的离散信息片段。
 *
 * ![Input chip image](https://developer.android.com/images/reference/androidx/compose/material3/input-chip.png)
 *
 * 输入芯片可以在其开头位置有一个前置图标或头像。如果两者都提供了，头像将优先显示。
 *
 * @param 已选择 此芯片是否被选中。
 * @param 单击回调 当此芯片被点击时调用。
 * @param 标签 此芯片的文本标签。
 * @param 修饰符 应用于该芯片的 [Modifier]。
 * @param 已启用 控制此芯片的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导图标 芯片开头可选的图标，位于 [标签] 文本之前。
 * @param 头像 芯片开头可选的头像，位于 [标签] 文本之前。
 * @param 尾随图标 芯片末端可选的图标。
 * @param 形状 定义此芯片容器、边框（当 [边框] 不为 null 时）和阴影（当使用 [阴影] 时）的形状。
 * @param 颜色集 [ChipColors]，用于解析此芯片在不同状态下使用的颜色。请参阅 [InputChipDefaults.inputChipColors]。
 * @param 阴影 用于解析此芯片在不同状态下高度的 [ChipElevation]。这控制芯片下方阴影的大小。此外，当容器颜色为
 * [ColorScheme.surface] 时，这控制作为主色调叠加层应用的数量。请参阅 [InputChipDefaults.inputChipElevation]。
 * @param 边框 围绕此芯片容器绘制的边框。传入 `null` 表示无边框。请参阅 [InputChipDefaults.inputChipBorder]。
 * @param 水平排列 芯片子项的水平排列方式。如果没有图标，那么 [标签] 和 [边框] 之间的水平内边距将是
 * [内容内边距] 与此 [水平排列] 中间距的总和。
 * @param 内容内边距 此芯片内容的内边距，包括 [前导图标]、[头像]、[标签] 和 [尾随图标]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此芯片的 [Interaction]。
 * 您可以使用它来更改芯片的外观或在不同状态下预览芯片。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 输入芯片(
    已选择: Boolean,
    单击回调: () -> Unit,
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导图标: @Composable (() -> Unit)? = null,
    头像: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    形状: Shape = InputChipDefaults.shape,
    颜色集: SelectableChipColors = InputChipDefaults.inputChipColors(),
    阴影: SelectableChipElevation? = InputChipDefaults.inputChipElevation(),
    边框: BorderStroke? = InputChipDefaults.inputChipBorder(已启用, 已选择),
    水平排列: Arrangement.Horizontal = InputChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = InputChipDefaults.contentPadding(
        hasAvatar = 头像 != null,
        hasLeadingIcon = 前导图标 != null,
        hasTrailingIcon = 尾随图标 != null
    ),
    交互源: MutableInteractionSource? = null,
) =
    InputChip(
        selected = 已选择,
        onClick = 单击回调,
        label = 标签,
        modifier = 修饰符,
        enabled = 已启用,
        leadingIcon = 前导图标,
        avatar = 头像,
        trailingIcon = 尾随图标,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        horizontalArrangement = 水平排列,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )


/**
 * [Material Design suggestion chip](https://m3.material.io/components/chips/overview)
 *
 * 芯片帮助用户输入信息、做出选择、过滤内容或触发操作。芯片可以在同一区域展示多个交互元素，例如可选的电影时间列表或一系列电子邮件联系人。
 *
 * 建议 Chip 通过呈现动态生成的建议来帮助缩小用户的意图范围，例如可能的回复或搜索筛选条件。
 *
 * ![Suggestion chip image](https://developer.android.com/images/reference/androidx/compose/material3/suggestion-chip.png)
 *
 * 此建议 Chip 采用扁平样式。如果你需要带阴影的凸起样式，请使用 [ElevatedSuggestionChip]。
 *
 * @param 单击回调 当此芯片被点击时调用。
 * @param 标签 此芯片的文本标签。
 * @param 修饰符 应用于该芯片的 [Modifier]。
 * @param 已启用 控制此芯片的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 图标 芯片开头可选的图标，位于 [标签] 文本之前。
 * @param 形状 定义此芯片容器、边框（当 [边框] 不为 null 时）和阴影（当使用 [阴影] 时）的形状。
 * @param 颜色集 [ChipColors] 用于解析此 Chip 在不同状态下所使用的颜色。参见 [SuggestionChipDefaults.suggestionChipColors]。
 * @param 阴影 [ChipElevation] 用于解析此 Chip 在不同状态下的阴影高程。 这会控制 Chip 下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这还会控制作为主色叠加层应用的主色数量。参见 [SuggestionChipDefaults.suggestionChipElevation]。
 * @param 边框 围绕此芯片容器绘制的边框。传入 null 表示无边框。参见 [SuggestionChipDefaults.suggestionChipBorder]。
 * @param 水平排列 Chip 子组件的水平排列方式。请注意，虽然 [SuggestionChip] 只有 [标签] 和 [图标] 两个子组件，
 * 但水平排列设计为支持三个子组件（例如 [icon, label, icon]），以在所有 Chip 类型之间保持一致性。如果没有图标，则 [标签]
 * 与 [边框] 之间的水平内边距将为 [内容内边距] 与该 [水平排列] 中间距的总和。
 * @param 内容内边距 此 Chip 内容区域周围的内边距，包括 [图标] 和 [标签]。参见 [SuggestionChipDefaults.ContentPadding]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此芯片的 [Interaction]。
 * 您可以使用它来更改芯片的外观或在不同状态下预览芯片。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 建议芯片(
    单击回调: () -> Unit,
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    图标: @Composable (() -> Unit)? = null,
    形状: Shape = SuggestionChipDefaults.shape,
    颜色集: ChipColors = SuggestionChipDefaults.suggestionChipColors(),
    阴影: ChipElevation? = SuggestionChipDefaults.suggestionChipElevation(),
    边框: BorderStroke? = SuggestionChipDefaults.suggestionChipBorder(已启用),
    水平排列: Arrangement.Horizontal = SuggestionChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = SuggestionChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    SuggestionChip(
        onClick = 单击回调,
        label = 标签,
        modifier = 修饰符,
        enabled = 已启用,
        icon = 图标,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        horizontalArrangement = 水平排列,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )


/**
 * [Material Design elevated suggestion chip](https://m3.material.io/components/chips/overview)
 *
 * 芯片帮助用户输入信息、做出选择、过滤内容或触发操作。芯片可以在同一区域展示多个交互元素，例如可选的电影时间列表或一系列电子邮件联系人。
 *
 * 建议 Chip 通过呈现动态生成的建议来帮助缩小用户的意图范围，例如可能的回复或搜索筛选条件。
 *
 * ![Suggestion chip image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-suggestion-chip.png)
 *
 * 此建议 Chip 采用带阴影的凸起样式。如果你需要扁平样式，请使用 [SuggestionChip]。
 *
 * @param 单击回调 当此芯片被点击时调用。
 * @param 标签 此芯片的文本标签。
 * @param 修饰符 应用于该芯片的 [Modifier]。
 * @param 已启用 控制此芯片的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 图标 芯片开头可选的图标，位于 [标签] 文本之前。
 * @param 形状 定义此芯片容器、边框（当 [边框] 不为 null 时）和阴影（当使用 [阴影] 时）的形状。
 * @param 颜色集 [ChipColors]，用于解析此 Chip 在不同状态下所使用的颜色。
 * @param 阴影 [ChipElevation]，用于解析此 Chip 在不同状态下的阴影高程。
 * 这会控制 Chip 下方阴影的大小。此外，当容器颜色为 [ColorScheme.surface] 时，这还会控制作为主色叠加层应用的主色数量。
 * 参见 [Surface] 和 [SuggestionChipDefaults.elevatedSuggestionChipElevation]。
 * @param 边框 围绕此芯片容器绘制的边框。不同状态下。参见 [SuggestionChipDefaults.elevatedSuggestionChipColors]。
 * @param 水平排列 Chip 子组件的水平排列方式。请注意，虽然 [SuggestionChip] 只有 [标签] 和 [图标] 两个子组件，
 * 但水平排列设计为支持三个子组件（例如 [icon, label, icon]），以在所有 Chip 类型之间保持一致性。如果没有图标，则 [标签]
 * 与 [边框] 之间的水平内边距将为 [内容内边距] 与该 [水平排列] 中间距的总和。
 * @param 内容内边距 此 Chip 内容区域周围的内边距，包括 [图标] 和 [标签]。参见 [SuggestionChipDefaults.ContentPadding]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此芯片的 [Interaction]。
 * 您可以使用它来更改芯片的外观或在不同状态下预览芯片。请注意，如果提供 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 凸起建议芯片(
    单击回调: () -> Unit,
    标签: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    图标: @Composable (() -> Unit)? = null,
    形状: Shape = SuggestionChipDefaults.shape,
    颜色集: ChipColors = SuggestionChipDefaults.elevatedSuggestionChipColors(),
    阴影: ChipElevation? = SuggestionChipDefaults.elevatedSuggestionChipElevation(),
    边框: BorderStroke? = null,
    水平排列: Arrangement.Horizontal = SuggestionChipDefaults.horizontalArrangement(),
    内容内边距: PaddingValues = SuggestionChipDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
) =
    ElevatedSuggestionChip(
        onClick = 单击回调,
        label = 标签,
        modifier = 修饰符,
        enabled = 已启用,
        icon = 图标,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        horizontalArrangement = 水平排列,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )


/** 包含 [AssistChip] 使用的基准值。 */
object 辅助芯片默认设置 { // AssistChipDefaults

    /** 应用于辅助芯片的高度。请注意，您可以通过直接在芯片上应用 Modifier.height 来覆盖此值。*/
    val 高度 = AssistChipDefaults.Height

    /** 辅助芯片图标的大小。 */
    val 图标大小 = AssistChipDefaults.IconSize

    /** 辅助芯片图标与标签之间的间距。 */
    val 水平间距 = AssistChipDefaults.HorizontalSpacing

    /** 芯片内容周围的内边距，包括 leadingIcon、label 和 trailingIcon。*/
    val 内容内边距 = AssistChipDefaults.ContentPadding

    /** 返回辅助芯片内图标和标签的默认排列方式。 */
    fun 水平排列(): Arrangement.Horizontal = AssistChipDefaults.horizontalArrangement()

    /**
     * 创建一个 [Arrangement.Horizontal]，表示辅助芯片内图标和标签的默认排列方式。
     *
     * @param 间距 图标与标签之间的间距。
     */
    fun 水平排列(间距: Dp): Arrangement.Horizontal =
        AssistChipDefaults.horizontalArrangement(spacing = 间距)

    /** 创建一个 [ChipColors]，表示扁平 [AssistChip] 中使用的默认容器、标签和图标颜色。*/
    @Composable
    fun 辅助芯片颜色集() = AssistChipDefaults.assistChipColors()

    /**
     * 创建一个 [ChipColors]，表示扁平 [AssistChip] 中使用的默认容器、标签和图标颜色。
     *
     * @param 容器颜色 此芯片启用状态下的容器颜色。
     * @param 标签颜色 此芯片启用状态下的标签颜色。
     * @param 前导图标内容颜色 此芯片启用状态下起始图标的颜色。
     * @param 尾随图标内容颜色 此芯片启用状态下末尾图标的颜色。
     * @param 禁用容器颜色 此芯片未启用状态下的容器颜色。
     * @param 禁用容器颜色 此芯片未启用状态下的标签颜色。
     * @param 禁用前导图标内容颜色 此芯片未启用状态下起始图标的颜色。
     * @param 禁用尾随图标内容颜色 此芯片未启用状态下末尾图标的颜色。
     */
    @Composable
    fun 辅助芯片颜色集(
        容器颜色: Color = Color.Unspecified,
        标签颜色: Color = Color.Unspecified,
        前导图标内容颜色: Color = Color.Unspecified,
        尾随图标内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        禁用前导图标内容颜色: Color = Color.Unspecified,
        禁用尾随图标内容颜色: Color = Color.Unspecified,
    ): ChipColors =
        AssistChipDefaults.assistChipColors(
            containerColor = 容器颜色,
            labelColor = 标签颜色,
            leadingIconContentColor = 前导图标内容颜色,
            trailingIconContentColor = 尾随图标内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledLabelColor = 禁用标签颜色,
            disabledLeadingIconContentColor = 禁用前导图标内容颜色,
            disabledTrailingIconContentColor = 禁用尾随图标内容颜色,
        )


    /**
     * 创建一个 [ChipElevation]，它将根据 Material 规范为扁平 [AssistChip] 在提供的值之间进行动画过渡。
     *
     * @param 阴影 当 [AssistChip] 没有其他 [Interaction] 时使用的高度。
     * @param 按下阴影 当芯片被按下时使用的高度。
     * @param 聚焦阴影 当芯片获得焦点时使用的高度。
     * @param 悬停阴影 当芯片被悬停时使用的高度。
     * @param 拖拽阴影 当芯片被拖动时使用的高度。
     * @param 禁用阴影 当芯片未启用时使用的高度。
     */
    @Composable
    fun 辅助芯片阴影(
        阴影: Dp = 0.0.dp,
        按下阴影: Dp = 阴影,
        聚焦阴影: Dp = 阴影,
        悬停阴影: Dp = 阴影,
        拖拽阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 阴影,
    ): ChipElevation =
        AssistChipDefaults.assistChipElevation(
            elevation = 阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [ChipBorder]，表示扁平 [AssistChip] 中使用的默认边框。
     *
     * @param 已启用 芯片是否启用。
     * @param 边框颜色 此芯片启用状态下的边框颜色。
     * @param 禁用边框颜色 此芯片未启用状态下的边框颜色。
     * @param 边框宽度 此芯片的边框描边宽度。
     */
    @Composable
    fun 辅助芯片边框(
        已启用: Boolean,
        边框颜色: Color =MaterialTheme.colorScheme.outlineVariant,
        禁用边框颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        边框宽度: Dp = 1.0.dp,
    ): BorderStroke =
        AssistChipDefaults.assistChipBorder(
            enabled = 已启用,
            borderColor = 边框颜色,
            disabledBorderColor = 禁用边框颜色,
            borderWidth = 边框宽度,
        )

    /**
     * 创建一个 [ChipBorder]，表示扁平 [AssistChip] 中使用的默认边框。
     *
     * @param 边框颜色 此芯片启用状态下的边框颜色。
     * @param 禁用边框颜色 此芯片未启用状态下的边框颜色。
     * @param 边框宽度 此芯片的边框描边宽度。
     */
    @Suppress("DEPRECATION")
    @Deprecated(
        "Maintained for binary compatibility. Use the assistChipBorder function that returns" +
                " BorderStroke instead",
        replaceWith =
            ReplaceWith(
                "assistChipBorder(enabled, borderColor," + " disabledBorderColor, borderWidth)"
            ),
        level = DeprecationLevel.WARNING,
    )
    @Composable
    fun 辅助芯片边框(
        边框颜色: Color = MaterialTheme.colorScheme.outlineVariant,
        禁用边框颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        边框宽度: Dp = 1.0.dp,
    ): ChipBorder =
        AssistChipDefaults.assistChipBorder(
            borderColor = 边框颜色,
            disabledBorderColor = 禁用边框颜色,
            borderWidth = 边框宽度,
        )

    /** 创建一个 [ChipColors]，表示凸起 [AssistChip] 中使用的默认容器、标签和图标颜色。*/
    @Composable
    fun 凸起辅助芯片颜色集() = AssistChipDefaults.elevatedAssistChipColors()

    /**
     * 创建一个 [ChipColors]，表示凸起 [AssistChip] 中使用的默认容器、标签和图标颜色。
     *
     * @param 容器颜色 此芯片启用状态下的容器颜色。
     * @param 标签颜色 此芯片启用状态下的标签颜色。
     * @param 前导图标内容颜色 此芯片启用状态下的开始图标颜色。
     * @param 尾随图标内容颜色 此芯片启用状态下的结束图标颜色。
     * @param 禁用容器颜色 此芯片未启用状态下的容器颜色。
     * @param 禁用标签颜色 此芯片未启用状态下的标签颜色。
     * @param 禁用前导图标内容颜色 此芯片未启用状态下的开始图标颜色。
     * @param 禁用尾随图标内容颜色 此芯片未启用状态下的结束图标颜色。
     */
    @Composable
    fun 凸起辅助芯片颜色集(
        容器颜色: Color = Color.Unspecified,
        标签颜色: Color = Color.Unspecified,
        前导图标内容颜色: Color = Color.Unspecified,
        尾随图标内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        禁用前导图标内容颜色: Color = Color.Unspecified,
        禁用尾随图标内容颜色: Color = Color.Unspecified,
    ): ChipColors =
        AssistChipDefaults.elevatedAssistChipColors(
            containerColor = 容器颜色,
            labelColor = 标签颜色,
            leadingIconContentColor = 前导图标内容颜色,
            trailingIconContentColor = 尾随图标内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledLabelColor = 禁用标签颜色,
            disabledLeadingIconContentColor = 禁用前导图标内容颜色,
            disabledTrailingIconContentColor = 禁用尾随图标内容颜色,
        )

    /**
     * 创建一个 [ChipElevation]，它将根据 Material 规范为凸起 [AssistChip] 在提供的值之间进行动画过渡。
     *
     * @param 阴影 当 [AssistChip] 没有其他 [Interaction] 时使用的高度。
     * @param 按下阴影 当 [AssistChip] 被按下时使用的高度。
     * @param 聚焦阴影 当 [AssistChip] 被聚焦时使用的高度。
     * @param 悬停阴影 当 [AssistChip] 被悬停时使用的高度。
     * @param 拖拽阴影 当 [AssistChip] 被拖动时使用的高度。
     * @param 禁用阴影 当 [AssistChip] 未启用时使用的高度。
     */
    @Composable
    fun 凸起辅助芯片阴影(
        阴影: Dp = 1.0.dp,
        按下阴影: Dp = 1.0.dp,
        聚焦阴影: Dp = 1.0.dp,
        悬停阴影: Dp = 3.0.dp,
        拖拽阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): ChipElevation =
        AssistChipDefaults.elevatedAssistChipElevation(
            elevation = 阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /** 辅助芯片的默认形状。 */
    val 形状: Shape
        @Composable get() = AssistChipDefaults.shape

}

/** 包含 [FilterChip] 使用的基准值。 */
object 过滤芯片默认值 { // FilterChipDefaults

    /** 应用于筛选型 Chip 的高度。注意，你可以直接在 Chip 上应用 Modifier.height 来覆盖此值。*/
    val 高度 = FilterChipDefaults.Height

    /** 筛选型 Chip 的起始图标大小。 */
    val 图标大小 = FilterChipDefaults.IconSize

    /** 筛选型 Chip 的图标和标签之间的水平间距。 */
    val 水平间距 = FilterChipDefaults.HorizontalSpacing

    /** 返回筛选型 Chip 中图标和标签的默认排列方式。 */
    fun 水平排列(): Arrangement.Horizontal = FilterChipDefaults.horizontalArrangement()

    /**
     * 创建一个 [Arrangement.Horizontal]，用于表示筛选型 Chip 中图标和标签的默认排列方式。
     *
     * @param 间距 图标与标签之间的间距
     */
    fun 水平排列(间距: Dp): Arrangement.Horizontal =
        FilterChipDefaults.horizontalArrangement(spacing = 间距)

    /** 此 Chip 内容周围的内边距，包括前置图标、标签和后置图标。*/
    val 内容内边距 = FilterChipDefaults.ContentPadding

    /** 创建一个 [SelectableChipColors]，用于表示扁平 [FilterChip] 中默认的容器和内容颜色。*/
    @Composable
    fun 过滤芯片颜色集() = FilterChipDefaults.filterChipColors()

    /**
     * 创建一个 [SelectableChipColors]，用于表示扁平 [FilterChip] 中默认的容器和内容颜色。
     *
     * @param 容器颜色 此 Chip 在启用状态下的容器颜色
     * @param 标签颜色 此 Chip 在启用状态下的标签颜色
     * @param 图标颜色 此 Chip 的前置和后置图标在启用状态下的颜色
     * @param 禁用容器颜色 此 Chip 在禁用状态下的容器颜色
     * @param 禁用标签颜色 此 Chip 在禁用状态下的标签颜色
     * @param 禁用前导图标颜色 此 Chip 的前置图标在禁用状态下的颜色
     * @param 禁用尾随图标颜色 此 Chip 的后置图标在禁用状态下的颜色
     * @param 已选择容器颜色 此 Chip 在选中状态下的容器颜色
     * @param 禁用已选择容器颜色 此 Chip 在禁用且选中状态下的容器颜色
     * @param 已选择标签颜色 此 Chip 在选中状态下的标签颜色
     * @param 已选择前导图标颜色 此 Chip 的前置图标在选中状态下的颜色
     * @param 已选择尾随图标颜色 此芯片选中时末尾图标的颜色
     */
    @Composable
    fun 过滤芯片颜色集(
        容器颜色: Color = Color.Unspecified,
        标签颜色: Color = Color.Unspecified,
        图标颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        已选择容器颜色: Color = Color.Unspecified,
        禁用已选择容器颜色: Color = Color.Unspecified,
        已选择标签颜色: Color = Color.Unspecified,
        已选择前导图标颜色: Color = Color.Unspecified,
        已选择尾随图标颜色: Color = Color.Unspecified,
    ): SelectableChipColors =
        FilterChipDefaults.filterChipColors(
            containerColor = 容器颜色,
            labelColor = 标签颜色,
            iconColor = 图标颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledLabelColor = 禁用标签颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            selectedContainerColor = 已选择容器颜色,
            disabledSelectedContainerColor = 禁用已选择容器颜色,
            selectedLabelColor = 已选择标签颜色,
            selectedLeadingIconColor = 已选择前导图标颜色,
            selectedTrailingIconColor = 已选择尾随图标颜色,
        )


    /**
     * 创建一个 [SelectableChipElevation]，它将根据 Material 规范为扁平 [FilterChip] 在提供的值之间进行动画过渡。
     *
     * @param 阴影 当 [FilterChip] 没有其他 [Interaction] 时使用的高度。
     * @param 按下阴影 当芯片被按下时使用的高度。
     * @param 聚焦阴影 当芯片获得焦点时使用的高度。
     * @param 悬停阴影 当芯片被悬停时使用的高度。
     * @param 拖拽阴影 当芯片被拖动时使用的高度。
     * @param 禁用阴影 当芯片未启用时使用的高度。
     */
    @Composable
    fun 过滤芯片阴影(
        阴影: Dp = 0.0.dp,
        按下阴影: Dp = 0.0.dp,
        聚焦阴影: Dp = 0.0.dp,
        悬停阴影: Dp = 1.0.dp,
        拖拽阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 阴影,
    ): SelectableChipElevation =
        FilterChipDefaults.filterChipElevation(
            elevation = 阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )


    /**
     * 创建一个 [BorderStroke]，表示扁平 [FilterChip] 中使用的默认边框。
     *
     * @param 已选择 此芯片是否被选中。
     * @param 已启用 控制此芯片的启用状态。当为 `false` 时，该组件不会响应用户输入，并且会在视觉上呈现为禁用状态，
     * 同时对无障碍服务而言也是禁用的。
     * @param 边框颜色 此芯片在启用且未选中状态下的边框颜色。
     * @param 已选择边框颜色 此芯片在启用且选中状态下的边框颜色。
     * @param 禁用边框颜色 此芯片在未启用且未选中状态下的边框颜色。
     * @param 禁用已选择边框颜色 此芯片在未启用但已选中状态下的边框颜色。
     * @param 边框宽度 此芯片未选中状态下的边框描边宽度。
     * @param 已选择边框宽度 此芯片选中状态下的边框描边宽度。
     */
    @Composable
    fun 过滤芯片边框(
        已启用: Boolean,
        已选择: Boolean,
        边框颜色: Color = MaterialTheme.colorScheme.outlineVariant,
        已选择边框颜色: Color = Color.Transparent,
        禁用边框颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        禁用已选择边框颜色: Color = Color.Transparent,
        边框宽度: Dp = 1.0.dp,
        已选择边框宽度: Dp = 0.0.dp,
    ): BorderStroke =
        FilterChipDefaults.filterChipBorder(
            enabled = 已启用,
            selected = 已选择,
            borderColor = 边框颜色,
            selectedBorderColor = 已选择边框颜色,
            disabledBorderColor = 禁用边框颜色,
            disabledSelectedBorderColor = 禁用已选择边框颜色,
            borderWidth = 边框宽度,
            selectedBorderWidth = 已选择边框宽度,
        )


    /** 创建一个 [SelectableChipColors]，表示凸起 [FilterChip] 中使用的默认容器和内容颜色。*/
    @Composable
    fun 凸起过滤芯片颜色集() = FilterChipDefaults.elevatedFilterChipColors()


    /**
     * 创建一个 [SelectableChipColors]，表示凸起 [FilterChip] 中使用的默认容器和内容颜色。
     *
     * @param 容器颜色 此芯片在启用且未选中状态下的容器颜色。
     * @param 标签颜色 此芯片在启用且未选中状态下的标签颜色。
     * @param 图标颜色 此芯片在启用且未选中状态下的图标颜色。
     * @param 禁用容器颜色 此芯片在未启用且未选中状态下的容器颜色。
     * @param 禁用标签颜色 此芯片在未启用且未选中状态下的标签颜色。
     * @param 禁用前导图标颜色 此芯片在未启用且未选中状态下的起始图标颜色。
     * @param 禁用尾随图标颜色 此芯片在未启用且未选中状态下的结束图标颜色。
     * @param 已选择容器颜色 此芯片选中状态下的容器颜色。
     * @param 禁用已选择容器颜色 此芯片未启用且已选中状态下的容器颜色。
     * @param 已选择标签颜色 此芯片选中状态下的标签颜色。
     * @param 已选择前导图标颜色 此芯片选中状态下起始图标的颜色。
     * @param 已选择尾随图标颜色 此芯片选中状态下末尾图标的颜色。
     */
    @Composable
    fun 凸起过滤芯片颜色集(
        容器颜色: Color = Color.Unspecified,
        标签颜色: Color = Color.Unspecified,
        图标颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        已选择容器颜色: Color = Color.Unspecified,
        禁用已选择容器颜色: Color = Color.Unspecified,
        已选择标签颜色: Color = Color.Unspecified,
        已选择前导图标颜色: Color = Color.Unspecified,
        已选择尾随图标颜色: Color = Color.Unspecified,
    ): SelectableChipColors =
        FilterChipDefaults.elevatedFilterChipColors(
            containerColor = 容器颜色,
            labelColor = 标签颜色,
            iconColor = 图标颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledLabelColor = 禁用标签颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            selectedContainerColor = 已选择容器颜色,
            disabledSelectedContainerColor = 禁用已选择容器颜色,
            selectedLabelColor = 已选择标签颜色,
            selectedLeadingIconColor = 已选择前导图标颜色,
            selectedTrailingIconColor = 已选择尾随图标颜色,
        )


    /**
     * 创建一个 [SelectableChipElevation]，它将根据 Material 规范为凸起 [FilterChip] 在提供的值之间进行动画过渡。
     *
     * @param 阴影 当芯片没有其他 [Interaction] 时使用的高度。
     * @param 按下阴影 当芯片被按下时使用的高度。
     * @param 聚焦阴影 当芯片获得焦点时使用的高度。
     * @param 悬停阴影 当芯片被悬停时使用的高度。
     * @param 拖拽阴影 当芯片被拖动时使用的高度。
     * @param 禁用阴影 当芯片未启用时使用的高度。
     */
    @Composable
    fun 凸起过滤芯片阴影(
        阴影: Dp = 1.0.dp,
        按下阴影: Dp = 1.0.dp,
        聚焦阴影: Dp = 1.0.dp,
        悬停阴影: Dp = 3.0.dp,
        拖拽阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): SelectableChipElevation =
        FilterChipDefaults.elevatedFilterChipElevation(
            elevation = 阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /** 过滤芯片的默认形状。 */
    val 形状: Shape
        @Composable get() = FilterChipDefaults.shape

}

/** 包含 [InputChip] 使用的基准值。 */
object 输入芯片默认值 { // InputChipDefaults

    /** 输入 Chip 应用的高度。请注意，你可以通过在 Chip 上直接应用 Modifier.height 来覆盖此值。*/
    val 高度 = InputChipDefaults.Height

    /** 输入 Chip 图标的大小。 */
    val 图标大小 = InputChipDefaults.IconSize

    /** 输入 Chip 头像的大小。 */
    val 头像大小 = InputChipDefaults.AvatarSize

    /** 输入型 Chip 中各元素之间的默认间距。 */
    val 水平间距 = InputChipDefaults.HorizontalSpacing

    /** 返回输入型 Chip 中图标/头像和标签的默认排列方式。 */
    fun 水平排列(): Arrangement.Horizontal = InputChipDefaults.horizontalArrangement()

    /**
     * 创建一个 [Arrangement.Horizontal]，用于表示输入型 Chip 中图标/头像和标签的默认排列方式。
     *
     * @param 间距 图标与标签之间的间距
     */
    fun 水平排列(间距: Dp): Arrangement.Horizontal =
        InputChipDefaults.horizontalArrangement(spacing = 间距)

    /** 返回此 Chip 内容周围的内边距，包括前置图标/头像、标签和后置图标。*/
    fun 内容内边距(
        有头像: Boolean,
        有前导图标: Boolean,
        有尾随图标: Boolean,
    ): PaddingValues =
        InputChipDefaults.contentPadding(
            hasAvatar = 有头像,
            hasLeadingIcon = 有前导图标,
            hasTrailingIcon = 有尾随图标,
        )

    /** 创建一个 [SelectableChipColors]，用于表示 [InputChip] 中默认的容器、标签和图标颜色。*/
    @Composable
    fun 输入芯片颜色集() = InputChipDefaults.inputChipColors()

    /**
     * 创建一个 [SelectableChipColors]，用于表示 [InputChip] 中默认的容器、标签和图标颜色。
     *
     * @param 容器颜色 此 Chip 在启用状态下的容器颜色
     * @param 标签颜色 此 Chip 在启用状态下的标签颜色
     * @param 前导图标颜色 此 Chip 的前置图标在启用状态下的颜色
     * @param 尾随图标颜色 此 Chip 的前置/后置图标在启用状态下的颜色
     * @param 禁用容器颜色 此 Chip 在禁用状态下的容器颜色
     * @param 禁用标签颜色 此 Chip 在禁用状态下的标签颜色
     * @param 禁用前导图标颜色 此 Chip 的前置图标在禁用状态下的颜色
     * @param 禁用尾随图标颜色 此 Chip 的后置图标在禁用状态下的颜色
     * @param 已选择容器颜色 此 Chip 在选中状态下的容器颜色
     * @param 禁用已选择容器颜色 此 Chip 在禁用且选中状态下的容器颜色
     * @param 已选择标签颜色 此 Chip 在选中状态下的标签颜色
     * @param 已选择前导图标颜色 此 Chip 的前置图标在选中状态下的颜色
     * @param 已选择尾随图标颜色 此 Chip 的后置图标在选中状态下的颜色
     */
    @Composable
    fun 输入芯片颜色集(
        容器颜色: Color = Color.Unspecified,
        标签颜色: Color = Color.Unspecified,
        前导图标颜色: Color = Color.Unspecified,
        尾随图标颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        已选择容器颜色: Color = Color.Unspecified,
        禁用已选择容器颜色: Color = Color.Unspecified,
        已选择标签颜色: Color = Color.Unspecified,
        已选择前导图标颜色: Color = Color.Unspecified,
        已选择尾随图标颜色: Color = Color.Unspecified,
    ): SelectableChipColors =
        InputChipDefaults.inputChipColors(
            containerColor = 容器颜色,
            labelColor = 标签颜色,
            leadingIconColor = 前导图标颜色,
            trailingIconColor = 尾随图标颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledLabelColor = 禁用标签颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            selectedContainerColor = 已选择容器颜色,
            disabledSelectedContainerColor = 禁用已选择容器颜色,
            selectedLabelColor = 已选择标签颜色,
            selectedLeadingIconColor = 已选择前导图标颜色,
            selectedTrailingIconColor = 已选择尾随图标颜色,
        )


    /**
     * 创建一个 [SelectableChipElevation]，它会根据 Material 规范，在提供的值之间进行动画过渡，用于 [InputChip]。
     *
     * @param 阴影 [FilterChip] 在没有其他 [Interaction] 时使用的阴影高度
     * @param 按下阴影 此 Chip 在被按压时使用的阴影高度
     * @param 聚焦阴影 此 Chip 在获得焦点时使用的阴影高度
     * @param 悬停阴影 此 Chip 在悬停时使用的阴影高度
     * @param 拖拽阴影 此 Chip 在被拖拽时使用的阴影高度
     * @param 禁用阴影 此 Chip 在禁用状态下使用的阴影高度
     */
    @Composable
    fun 输入芯片阴影(
        阴影: Dp = 0.0.dp,
        按下阴影: Dp = 阴影,
        聚焦阴影: Dp = 阴影,
        悬停阴影: Dp = 阴影,
        拖拽阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 阴影,
    ): SelectableChipElevation =
        InputChipDefaults.inputChipElevation(
            elevation = 阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [BorderStroke]，用于表示 [InputChip] 中默认的边框。
     *
     * @param 已选择 此芯片是否被选中。
     * @param 已启用 控制此 Chip 的启用状态。当为 `false` 时，此组件不会响应用户输入，并且在视觉上显示为禁用状态，
     * 同时辅助功能服务也会将其视为禁用。
     * @param 边框颜色 此 Chip 在启用且未选中状态下的边框颜色
     * @param 已选择边框颜色 此 Chip 在启用且选中状态下的边框颜色
     * @param 禁用边框颜色 此 Chip 在禁用且未选中状态下的边框颜色
     * @param 禁用已选择边框颜色 此 Chip 在禁用但选中状态下的边框颜色
     * @param 边框宽度 此 Chip 在未选中状态下的边框描边宽度
     * @param 已选择边框宽度 此 Chip 在选中状态下的边框描边宽度
     */
    @Composable
    fun 输入芯片边框(
        已启用: Boolean,
        已选择: Boolean,
        边框颜色: Color = MaterialTheme.colorScheme.outlineVariant,
        已选择边框颜色: Color = Color.Transparent,
        禁用边框颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        禁用已选择边框颜色: Color = Color.Transparent,
        边框宽度: Dp = 1.0.dp,
        已选择边框宽度: Dp = 0.0.dp,
    ): BorderStroke =
        InputChipDefaults.inputChipBorder(
            enabled = 已启用,
            selected = 已选择,
            borderColor = 边框颜色,
            selectedBorderColor = 已选择边框颜色,
            disabledBorderColor = 禁用边框颜色,
            disabledSelectedBorderColor = 禁用已选择边框颜色,
            borderWidth = 边框宽度,
            selectedBorderWidth = 已选择边框宽度,
        )

    /** 输入型 Chip 的默认形状。 */
    val 形状: Shape
        @Composable get() = InputChipDefaults.shape

}

/** 包含 [SuggestionChip] 使用的基准值。 */
object 建议芯片默认值 { // SuggestionChipDefaults

    /** 建议 Chip 应用的高度。请注意，你可以通过在 Chip 上直接应用 Modifier.height 来覆盖此值。*/
    val 高度 = SuggestionChipDefaults.Height

    /** 建议 Chip 图标的大小。 */
    val 图标大小 = SuggestionChipDefaults.IconSize

    /** Chip 内容区域周围的内边距，包括图标和标签。 */
    val 内容内边距 = SuggestionChipDefaults.ContentPadding

    /** 建议 Chip 中元素之间的默认间距。 */
    val 水平间距 = SuggestionChipDefaults.HorizontalSpacing

    /** 返回建议 Chip 中图标和标签的默认排列方式。 */
    fun 水平排列(): Arrangement.Horizontal = SuggestionChipDefaults.horizontalArrangement()

    /**
     * 创建一个 [Arrangement.Horizontal]，表示建议 Chip 中图标和标签的默认排列方式。
     *
     * @param 间距 图标与标签之间的间距。
     */
    fun 水平排列(间距: Dp): Arrangement.Horizontal =
        SuggestionChipDefaults.horizontalArrangement(spacing = 间距)

    /** 创建一个 [ChipColors]，表示扁平样式 [SuggestionChip] 中使用的默认容器颜色、标签颜色和图标颜色。*/
    @Composable
    fun 建议芯片颜色集() = SuggestionChipDefaults.suggestionChipColors()

    /**
     * 创建一个 [ChipColors]，表示扁平样式 [SuggestionChip] 中使用的默认容器颜色、标签颜色和图标颜色。
     *
     * @param 容器颜色 此 Chip 的容器在启用状态时的颜色。
     * @param 标签颜色 此 Chip 的标签在启用状态时的颜色。
     * @param 图标内容颜色 此 Chip 的图标在启用状态时的颜色。
     * @param 禁用容器颜色 此 Chip 的容器在禁用状态（未启用）时的颜色。
     * @param 禁用标签颜色 此 Chip 的标签在禁用状态（未启用）时的颜色。
     * @param 禁用图标内容颜色 此 Chip 的图标在禁用状态（未启用）时的颜色。
     */
    @Composable
    fun 建议芯片颜色集(
        容器颜色: Color = Color.Unspecified,
        标签颜色: Color = Color.Unspecified,
        图标内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        禁用图标内容颜色: Color = Color.Unspecified,
    ): ChipColors =
        SuggestionChipDefaults.suggestionChipColors(
            containerColor = 容器颜色,
            labelColor = 标签颜色,
            iconContentColor = 图标内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledLabelColor = 禁用标签颜色,
            disabledIconContentColor = 禁用图标内容颜色,
        )

    /**
     * 创建一个 [ChipElevation]，它将根据 Material 规范在提供的值之间进行动画过渡，用于扁平样式的 [SuggestionChip]。
     *
     * @param 阴影 Chip 在没有其他[Interaction]时使用的阴影高程。
     * @param 按下阴影 Chip 在按下状态时使用的阴影高程。
     * @param 聚焦阴影 Chip 在聚焦状态时使用的阴影高程。
     * @param 悬停阴影 Chip 在悬停状态时使用的阴影高程。
     * @param 拖拽阴影 Chip 在被拖动状态时使用的阴影高程。
     * @param 禁用阴影 Chip 在禁用状态（未启用）时使用的阴影高程。
     */
    @Composable
    fun 建议芯片阴影(
        阴影: Dp = 0.0.dp,
        按下阴影: Dp = 阴影,
        聚焦阴影: Dp = 阴影,
        悬停阴影: Dp = 阴影,
        拖拽阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 阴影,
    ): ChipElevation =
        SuggestionChipDefaults.suggestionChipElevation(
            elevation = 阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [BorderStroke]，表示扁平样式 [SuggestionChip] 中使用的默认边框。
     *
     * @param 已启用 此 Chip 是否启用。
     * @param 边框颜色 此 Chip 的边框在启用状态时的颜色。
     * @param 禁用边框颜色 此 Chip 的边框在禁用状态（未启用）时的颜色。
     * @param 边框宽度 此 Chip 的边框描边宽度。
     */
    @Composable
    fun 建议芯片边框(
        已启用: Boolean,
        边框颜色: Color = MaterialTheme.colorScheme.outlineVariant,
        禁用边框颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        边框宽度: Dp = 1.0.dp,
    ): BorderStroke =
        SuggestionChipDefaults.suggestionChipBorder(
            enabled = 已启用,
            borderColor = 边框颜色,
            disabledBorderColor = 禁用边框颜色,
            borderWidth = 边框宽度,
        )

    /**
     * 创建一个 [ChipBorder]，表示扁平样式 [SuggestionChip] 中使用的默认边框。
     *
     * @param 边框颜色 此 Chip 的边框在启用状态时的颜色。
     * @param 禁用边框颜色 此 Chip 的边框在禁用状态（未启用）时的颜色。
     * @param 边框宽度 此 Chip 的边框描边宽度。
     */
    @Suppress("DEPRECATION")
    @Deprecated(
        "Maintained for binary compatibility. Use the suggestChipBorder functions instead",
        replaceWith =
            ReplaceWith(
                "suggestionChipBorder(enabled, borderColor," + " disabledBorderColor, borderWidth)"
            ),
        level = DeprecationLevel.WARNING,
    )
    @Composable
    fun 建议芯片边框(
        边框颜色: Color = MaterialTheme.colorScheme.outlineVariant,
        禁用边框颜色: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        边框宽度: Dp = 1.0.dp,
    ): ChipBorder =
        SuggestionChipDefaults.suggestionChipBorder(
            borderColor = 边框颜色,
            disabledBorderColor = 禁用边框颜色,
            borderWidth = 边框宽度,
        )


    /** 创建一个 [ChipColors]，表示凸起样式 [SuggestionChip] 中使用的默认容器颜色、标签颜色和图标颜色。*/
    @Composable
    fun 凸起建议芯片颜色集() = SuggestionChipDefaults.elevatedSuggestionChipColors()

    /**
     * 创建一个 [ChipColors]，表示凸起样式 [SuggestionChip] 中使用的默认容器颜色、标签颜色和图标颜色。
     *
     * @param 容器颜色 此 Chip 的容器在启用状态时的颜色。
     * @param 标签颜色 此 Chip 的标签在启用状态时的颜色。
     * @param 图标内容颜色 此 Chip 的图标在启用状态时的颜色。
     * @param 禁用容器颜色 此 Chip 的容器在禁用状态（未启用）时的颜色。
     * @param 禁用标签颜色 此 Chip 的标签在禁用状态（未启用）时的颜色。
     * @param 禁用图标内容颜色 此 Chip 的图标在禁用状态（未启用）时的颜色。
     */
    @Composable
    fun 凸起建议芯片颜色集(
        容器颜色: Color = Color.Unspecified,
        标签颜色: Color = Color.Unspecified,
        图标内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用标签颜色: Color = Color.Unspecified,
        禁用图标内容颜色: Color = Color.Unspecified,
    ): ChipColors =
        SuggestionChipDefaults.elevatedSuggestionChipColors(
            containerColor = 容器颜色,
            labelColor = 标签颜色,
            iconContentColor = 图标内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledLabelColor = 禁用标签颜色,
            disabledIconContentColor = 禁用图标内容颜色,
        )


    /**
     * 创建一个 [ChipElevation]，它将根据 Material 规范在提供的值之间进行动画过渡，用于凸起样式的 [SuggestionChip]。
     *
     * @param 阴影 Chip 在没有其他[Interaction]时使用的阴影高程。
     * @param 按下阴影 Chip 在按下状态时使用的阴影高程。
     * @param 聚焦阴影 Chip 在聚焦状态时使用的阴影高程。
     * @param 悬停阴影 Chip 在悬停状态时使用的阴影高程。
     * @param 拖拽阴影 Chip 在被拖动状态时使用的阴影高程。
     * @param 禁用阴影 Chip 在禁用状态（未启用）时使用的阴影高程。
     */
    @Composable
    fun 凸起建议芯片阴影(
        阴影: Dp = 1.0.dp,
        按下阴影: Dp = 1.0.dp,
        聚焦阴影: Dp = 1.0.dp,
        悬停阴影: Dp = 3.0.dp,
        拖拽阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): ChipElevation =
        SuggestionChipDefaults.elevatedSuggestionChipElevation(
            elevation = 阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /** 建议 Chip 的默认形状。 */
    val 形状: Shape
        @Composable get() = SuggestionChipDefaults.shape

}

//=========================================================================================

/**
 * 表示可选中 Chip 在不同状态下使用的阴影高程。
 *
 * 请注意，此默认实现不会考虑传入其 [shadowElevation] 的 selectable 状态。如果你希望应用该状态，请使用不同的
 * [SelectableChipElevation]。
 *
 * @param 阴影 Chip 在启用状态时使用的阴影高程。
 * @param 按下阴影 Chip 在按下状态时使用的阴影高程。
 * @param 聚焦阴影 Chip 在聚焦状态时使用的阴影高程。
 * @param 悬停阴影 Chip 在悬停状态时使用的阴影高程。
 * @param 拖拽阴影 Chip 在被拖动状态时使用的阴影高程。
 * @param 禁用阴影 Chip 在禁用状态（未启用）时使用的阴影高程。
 */
fun 芯片阴影(
    阴影: Dp,
    按下阴影: Dp,
    聚焦阴影: Dp,
    悬停阴影: Dp,
    拖拽阴影: Dp,
    禁用阴影: Dp,
) =
    ChipElevation(
        elevation = 阴影,
        pressedElevation = 按下阴影,
        focusedElevation = 聚焦阴影,
        hoveredElevation = 悬停阴影,
        draggedElevation = 拖拽阴影,
        disabledElevation = 禁用阴影,
    )


val ChipElevation.阴影: Dp
    get() = this.elevation

val ChipElevation.按下阴影: Dp
    get() = this.pressedElevation

val ChipElevation.聚焦阴影: Dp
    get() = this.focusedElevation

val ChipElevation.悬停阴影: Dp
    get() = this.hoveredElevation

val ChipElevation.拖拽阴影: Dp
    get() = this.draggedElevation

val ChipElevation.禁用阴影: Dp
    get() = this.disabledElevation

//=========================================================================================

/**
 * 表示可选中 Chip 在不同状态下使用的阴影高程。
 *
 * @param 阴影 Chip 在启用状态时使用的阴影高程。
 * @param 按下阴影 Chip 在按下状态时使用的阴影高程。
 * @param 聚焦阴影 Chip 在聚焦状态时使用的阴影高程。
 * @param 悬停阴影 Chip 在悬停状态时使用的阴影高程。
 * @param 拖拽阴影 Chip 在被拖动状态时使用的阴影高程。
 * @param 禁用阴影 Chip 在禁用状态（未启用）时使用的阴影高程。
 */
fun 可选芯片阴影(
    阴影: Dp,
    按下阴影: Dp,
    聚焦阴影: Dp,
    悬停阴影: Dp,
    拖拽阴影: Dp,
    禁用阴影: Dp,
) =
    SelectableChipElevation(
        elevation = 阴影,
        pressedElevation = 按下阴影,
        focusedElevation = 聚焦阴影,
        hoveredElevation = 悬停阴影,
        draggedElevation = 拖拽阴影,
        disabledElevation = 禁用阴影,
    )


val SelectableChipElevation.阴影: Dp
    get() = this.elevation

val SelectableChipElevation.按下阴影: Dp
    get() = this.pressedElevation

val SelectableChipElevation.聚焦阴影: Dp
    get() = this.focusedElevation

val SelectableChipElevation.悬停阴影: Dp
    get() = this.hoveredElevation

val SelectableChipElevation.拖拽阴影: Dp
    get() = this.draggedElevation

val SelectableChipElevation.禁用阴影: Dp
    get() = this.disabledElevation


//=========================================================================================

/**
 * 表示可点击 Chip 在不同状态下使用的容器颜色和内容颜色。
 *
 * @param 容器颜色 此 Chip 的容器在启用状态时的颜色。
 * @param 标签颜色 此 Chip 的标签在启用状态时的颜色。
 * @param 前导图标内容颜色 此 Chip 起始图标在启用状态时的颜色。
 * @param 尾随图标内容颜色 此 Chip 末端图标在启用状态时的颜色。
 * @param 禁用容器颜色 此 Chip 的容器在禁用状态（未启用）时的颜色。
 * @param 禁用标签颜色 此 Chip 的标签在禁用状态（未启用）时的颜色。
 * @param 禁用前导图标内容颜色 此 Chip 起始图标在禁用状态（未启用）时的颜色。
 * @param 禁用尾随图标内容颜色 此 Chip 末端图标在禁用状态（未启用）时的颜色。
 * @constructor 要使用任意颜色创建实例，请参见 [AssistChipDefaults]、[InputChipDefaults] 和
 * [SuggestionChipDefaults]，了解各种 Chip 配置使用的默认颜色。
 */
fun 芯片颜色集(
    容器颜色: Color,
    标签颜色: Color,
    前导图标内容颜色: Color,
    尾随图标内容颜色: Color,
    禁用容器颜色: Color,
    禁用标签颜色: Color,
    禁用前导图标内容颜色: Color,
    禁用尾随图标内容颜色: Color,
    // TODO(b/113855296): 支持其他状态：悬停（hover）、聚焦（focus）、拖动（drag）
) =
    ChipColors(
        containerColor = 容器颜色,
        labelColor = 标签颜色,
        leadingIconContentColor = 前导图标内容颜色,
        trailingIconContentColor = 尾随图标内容颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledLabelColor = 禁用标签颜色,
        disabledLeadingIconContentColor = 禁用前导图标内容颜色,
        disabledTrailingIconContentColor = 禁用尾随图标内容颜色,
    )


/** 返回此 ChipColors 的副本，可选择性地覆盖部分值。这里使用 Color.Unspecified 表示"沿用源对象中的值"。*/
fun ChipColors.复制(
    容器颜色: Color = this.containerColor,
    标签颜色: Color = this.labelColor,
    前导图标内容颜色: Color = this.leadingIconContentColor,
    尾随图标内容颜色: Color = this.trailingIconContentColor,
    禁用容器颜色: Color = this.disabledContainerColor,
    禁用标签颜色: Color = this.disabledLabelColor,
    禁用前导图标内容颜色: Color = this.disabledLeadingIconContentColor,
    禁用尾随图标内容颜色: Color = this.disabledTrailingIconContentColor,
) =
    this.copy(
        containerColor = 容器颜色,
        labelColor = 标签颜色,
        leadingIconContentColor = 前导图标内容颜色,
        trailingIconContentColor = 尾随图标内容颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledLabelColor = 禁用标签颜色,
        disabledLeadingIconContentColor = 禁用前导图标内容颜色,
        disabledTrailingIconContentColor = 禁用尾随图标内容颜色,
    )


val ChipColors.容器颜色: Color
    get() = this.containerColor

val ChipColors.标签颜色: Color
    get() = this.labelColor

val ChipColors.前导图标内容颜色: Color
    get() = this.leadingIconContentColor

val ChipColors.尾随图标内容颜色: Color
    get() = this.trailingIconContentColor

val ChipColors.禁用容器颜色: Color
    get() = this.disabledContainerColor

val ChipColors.禁用标签颜色: Color
    get() = this.disabledLabelColor

val ChipColors.禁用前导图标内容颜色: Color
    get() = this.disabledLeadingIconContentColor

val ChipColors.禁用尾随图标内容颜色: Color
    get() = this.disabledTrailingIconContentColor


//=========================================================================================

/**
 * 表示可选中 Chip 在不同状态下使用的容器颜色和内容颜色。
 *
 * 参见 [FilterChipDefaults.filterChipColors] 和 [FilterChipDefaults.elevatedFilterChipColors]，
 * 了解 [FilterChip] 使用的默认颜色。
 */
fun 可选芯片颜色集(
    容器颜色: Color,
    标签颜色: Color,
    前导图标颜色: Color,
    尾随图标颜色: Color,
    禁用容器颜色: Color,
    禁用标签颜色: Color,
    禁用前导图标颜色: Color,
    禁用尾随图标颜色: Color,
    已选择容器颜色: Color,
    禁用已选择容器颜色: Color,
    已选择标签颜色: Color,
    已选择前导图标颜色: Color,
    已选择尾随图标颜色: Color,
    // TODO(b/113855296): 支持其他状态：悬停（hover）、聚焦（focus）、拖动（drag）
) =
    SelectableChipColors(
        containerColor = 容器颜色,
        labelColor = 标签颜色,
        leadingIconColor = 前导图标颜色,
        trailingIconColor = 尾随图标颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledLabelColor = 禁用标签颜色,
        disabledLeadingIconColor = 禁用前导图标颜色,
        disabledTrailingIconColor = 禁用尾随图标颜色,
        selectedContainerColor = 已选择容器颜色,
        disabledSelectedContainerColor = 禁用已选择容器颜色,
        selectedLabelColor = 已选择标签颜色,
        selectedLeadingIconColor = 已选择前导图标颜色,
        selectedTrailingIconColor = 已选择尾随图标颜色,
    )


/** 返回此 SelectableChipColors 的副本，可选择性地覆盖部分值。这里使用 Color.Unspecified 表示"沿用源对象中的值"。*/
fun SelectableChipColors.复制(
    容器颜色: Color = Color.Unspecified,
    标签颜色: Color = Color.Unspecified,
    前导图标颜色: Color = Color.Unspecified,
    尾随图标颜色: Color = Color.Unspecified,
    禁用容器颜色: Color = Color.Unspecified,
    禁用标签颜色: Color = Color.Unspecified,
    禁用前导图标颜色: Color = Color.Unspecified,
    禁用尾随图标颜色: Color = Color.Unspecified,
    已选择容器颜色: Color = Color.Unspecified,
    禁用已选择容器颜色: Color = Color.Unspecified,
    已选择标签颜色: Color = Color.Unspecified,
    已选择前导图标颜色: Color = Color.Unspecified,
    已选择尾随图标颜色: Color = Color.Unspecified,
) =
    this.copy(
        containerColor = 容器颜色,
        labelColor = 标签颜色,
        leadingIconColor = 前导图标颜色,
        trailingIconColor = 尾随图标颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledLabelColor = 禁用标签颜色,
        disabledLeadingIconColor = 禁用前导图标颜色,
        disabledTrailingIconColor = 禁用尾随图标颜色,
        selectedContainerColor = 已选择容器颜色,
        disabledSelectedContainerColor = 禁用已选择容器颜色,
        selectedLabelColor = 已选择标签颜色,
        selectedLeadingIconColor = 已选择前导图标颜色,
        selectedTrailingIconColor = 已选择尾随图标颜色,
    )


