package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * [Material Design tab](https://m3.material.io/components/tabs/overview)
 *
 * 默认标签页，也称为主导航标签页。标签页用于在不同屏幕、数据集和其他交互之间组织内容。
 *
 * ![Tabs image](https://developer.android.com/images/reference/androidx/compose/material3/secondary-tabs.png)
 *
 * 标签页使用文本标签和/或图标表示单个内容页面。它通过将文本标签和/或图像着色为 [已选择内容颜色] 来表示其选中状态。
 *
 * 这通常应在 [TabRow] 内部使用，有关示例用法请参阅相应文档。
 *
 * 此标签页为 [文本] 和/或 [图标] 提供了插槽——如需一个不对其内容做预设的通用标签页，请参见另一个 Tab 重载。
 *
 * @param 已选择 此标签页是否被选中。
 * @param 单击回调 当此标签页被点击时调用。
 * @param 修饰符 要应用于此标签页的 [Modifier]。
 * @param 已启用 控制此标签页的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 文本 此标签页中显示的文本标签。
 * @param 图标 此标签页中显示的图标。
 * @param 已选择内容颜色 此标签页内容在选中时的颜色，以及涟漪效果的颜色。
 * @param 未已选择内容颜色 此标签页内容在未选中时的颜色。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此标签页的 [Interaction]。
 * 你可以使用它来更改标签页的外观或在不同状态下预览标签页。请注意，如果提供 null，交互仍会在内部发生。
 * @see LeadingIconTab
 */
@Suppress("ComposableNaming")
@Composable
fun 标签页(
    已选择: Boolean,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    文本: @Composable (() -> Unit)? = null,
    图标: @Composable (() -> Unit)? = null,
    已选择内容颜色: Color = LocalContentColor.current,
    未已选择内容颜色: Color = 已选择内容颜色,
    交互源: MutableInteractionSource? = null,
) =
    Tab(
        selected = 已选择,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        text = 文本,
        icon = 图标,
        selectedContentColor = 已选择内容颜色,
        unselectedContentColor = 未已选择内容颜色,
        interactionSource = 交互源,
    )


/**
 * [Material Design tab](https://m3.material.io/components/tabs/overview)
 *
 * 标签页用于在不同屏幕、数据集和其他交互之间组织内容。
 *
 * LeadingIconTab 使用文本标签和标签前方的图标来表示单个内容页面。它通过将文本标签和图标着色为 [已选择内容颜色] 来表示其选中状态。
 *
 * 这通常应在 [TabRow] 内部使用，有关示例用法请参阅相应文档。
 *
 * @param 已选择 此标签页是否被选中。
 * @param 单击回调 当此标签页被点击时调用。
 * @param 文本 此标签页中显示的文本标签。
 * @param 图标 此标签页中显示的图标。应为 24.dp。
 * @param 修饰符 要应用于此标签页的 [Modifier]。
 * @param 已启用 控制此标签页的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 已选择内容颜色 此标签页内容在选中时的颜色，以及涟漪效果的颜色。
 * @param 未已选择内容颜色 此标签页内容在未选中时的颜色。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此标签页的 [Interaction]。
 * 你可以使用它来更改标签页的外观或在不同状态下预览标签页。请注意，如果提供 null，交互仍会在内部发生。
 * @see Tab
 */
@Suppress("ComposableNaming")
@Composable
fun 前导图标标签页(
    已选择: Boolean,
    单击回调: () -> Unit,
    文本: @Composable () -> Unit,
    图标: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    已选择内容颜色: Color = LocalContentColor.current,
    未已选择内容颜色: Color = 已选择内容颜色,
    交互源: MutableInteractionSource? = null,
) =
    LeadingIconTab(
        selected = 已选择,
        onClick = 单击回调,
        text = 文本,
        icon = 图标,
        modifier = 修饰符,
        enabled = 已启用,
        selectedContentColor = 已选择内容颜色,
        unselectedContentColor = 未已选择内容颜色,
        interactionSource = 交互源,
    )


/**
 * [Material Design tab](https://m3.material.io/components/tabs/overview)
 *
 * 标签页用于在不同屏幕、数据集和其他交互之间组织内容。
 *
 * ![Tabs image](https://developer.android.com/images/reference/androidx/compose/material3/secondary-tabs.png)
 *
 * 通用的 [Tab] 重载，不对内容/颜色做预设。如需一个为文本和/或图标提供特定插槽，同时为选中/未选中状态提供正确颜色的标签页，
 * 请参见另一个重载。
 *
 * @param 已选择 此标签页是否被选中。
 * @param 单击回调 当此标签页被点击时调用。
 * @param 修饰符 要应用于此标签页的 [Modifier]。
 * @param 已启用 控制此标签页的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，同时对无障碍服务也呈现为禁用。
 * @param 已选择内容颜色 此标签页内容在选中时的颜色，以及涟漪效果的颜色。
 * @param 未已选择内容颜色 此标签页内容在未选中时的颜色。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此标签页的 [Interaction]。
 * 你可以使用它来更改标签页的外观或在不同状态下预览标签页。请注意，如果提供 null，交互仍会在内部发生。
 * @param 内容 此标签页的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun 标签页(
    已选择: Boolean,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    已选择内容颜色: Color = LocalContentColor.current,
    未已选择内容颜色: Color = 已选择内容颜色,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    Tab(
        selected = 已选择,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        selectedContentColor = 已选择内容颜色,
        unselectedContentColor = 未已选择内容颜色,
        interactionSource = 交互源,
        content = 内容,
    )


