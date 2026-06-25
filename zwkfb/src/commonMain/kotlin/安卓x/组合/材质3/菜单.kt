package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuGroup
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.DropdownMenuPopup
import androidx.compose.material3.MenuGroupShapes
import androidx.compose.material3.MenuItemShapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 菜单在临时表面上显示一系列选项。当用户与按钮、操作项或其他控件交互时，菜单会出现。
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/menu.png)
 *
 * [下拉菜单] 的行为与 [Popup] 类似，会使用父布局的位置来确定自身在屏幕上的位置。通常 [下拉菜单] 会放置在一个 [Box] 中，
 * 并与其同级元素（sibling）一起使用，该同级元素将作为"锚点"。请注意，[下拉菜单] 本身不会在布局中占用任何空间，
 * 因为菜单显示在一个独立的窗口中，位于其他内容的上方。
 *
 * [下拉菜单] 的 [内容] 通常为 [DropdownMenuItem]，也可包含自定义内容。使用 [DropdownMenuItem]
 * 可使菜单符合 Material 设计规范中关于菜单的规定。另请注意，[内容] 被放置在一个可滚动的 [Column] 内部，
 * 因此在 [内容] 中将 [androidx.compose.foundation.lazy.LazyColumn] 作为根布局使用是不受支持的。
 *
 * [关闭请求回调] 会在菜单应当关闭时被调用——例如当点击菜单外部区域时，或按下返回键时。
 *
 * [下拉菜单] 会根据可用空间调整其定位，始终尝试保持完全可见。根据布局方向，首先尝试将其起始边与父布局的起始边对齐，
 * 然后尝试将其结束边与父布局的结束边对齐，最后尝试与窗口边缘对齐。在垂直方向上，首先尝试将其顶部与父布局的底部对齐，
 * 然后尝试将其底部与父布局的顶部对齐，最后尝试与窗口边缘对齐。
 *
 * 可以提供 [偏移量] 来调整菜单的定位，用于父布局的布局边界与其视觉边界不一致的情况。
 *
 * @param 已展开 菜单是否展开。
 * @param 关闭请求回调 当用户请求关闭菜单时调用，例如通过点击菜单边界外部区域。
 * @param 修饰符 要应用于菜单内容的 [Modifier]。
 * @param 偏移量 菜单原始位置的 [DpOffset] 偏移量。该偏移量遵循 [androidx.compose.ui.unit.LayoutDirection]，
 * 因此 x 方向的偏移量在 LTR 布局中会相加，在 RTL 布局中会相减。
 * @param 滚动状态 菜单内容用于列表项垂直滚动的 [ScrollState]。
 * @param 属性集 用于进一步自定义此弹出框行为的 [PopupProperties]。
 * @param 形状 菜单的形状。
 * @param 容器颜色 菜单的容器颜色。
 * @param 色调阴影 当 [containerColor] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 色调海拔值越高，在浅色主题下颜色越深，在深色主题下颜色越浅。另请参阅：[表面]。
 * @param 视觉阴影 菜单下方阴影的海拔高度。
 * @param 边框 围绕菜单容器绘制的边框。传 `null` 表示无边框。
 * @param 内容 此下拉菜单的内容，通常为 [DropdownMenuItem]。
 */
@Suppress("ComposableNaming")
@Composable
fun 下拉菜单(
    已展开: Boolean,
    关闭请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    偏移量: DpOffset = DpOffset(0.dp, 0.dp),
    滚动状态: ScrollState = rememberScrollState(),
    属性集: PopupProperties = DefaultMenuProperties,
    形状: Shape = MenuDefaults.shape,
    容器颜色: Color = MenuDefaults.containerColor,
    色调阴影: Dp = MenuDefaults.TonalElevation,
    视觉阴影: Dp = MenuDefaults.ShadowElevation,
    边框: BorderStroke? = null,
    内容: @Composable ColumnScope.() -> Unit,
){
    DropdownMenu(
        expanded = 已展开,
        onDismissRequest = 关闭请求回调,
        modifier = 修饰符,
        offset = 偏移量,
        scrollState = 滚动状态,
        properties = 属性集,
        shape = 形状,
        containerColor = 容器颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        content = 内容,
    )
}

/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 一个为构建自定义菜单提供基础的 [Popup]。
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/exposed-dropdown-menu-selectable-items.png)
 *
 * 此可组合项为菜单提供 [Popup] 和布局行为。适用于构建需要与默认 [下拉菜单] 不同的内容排列或样式的自定义菜单。
 *
 * @param 已展开 菜单是否已展开。
 * @param 关闭请求回调 当用户请求关闭菜单时调用，例如点击菜单外部区域时。
 * @param 修饰符 应用于菜单内容的 [Modifier]。
 * @param 偏移量 相对于菜单原始位置的 [DpOffset] 偏移量
 * @param 属性集 用于进一步自定义此弹出框行为的 [PopupProperties]。
 * @param 内容 此下拉菜单的内容
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单弹窗(
    已展开: Boolean,
    关闭请求回调: () -> Unit,
    修饰符: Modifier = Modifier,
    偏移量: DpOffset = DpOffset(0.dp, 0.dp),
    属性集: PopupProperties = DefaultMenuProperties,
    内容: @Composable ColumnScope.() -> Unit,
){
    DropdownMenuPopup(
        expanded = 已展开,
        onDismissRequest = 关闭请求回调,
        modifier = 修饰符,
        offset = 偏移量,
        properties = 属性集,
        content = 内容,
    )
}

/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 用于在 [下拉菜单弹窗] 中创建视觉上有明显区分的内容组的可组合项。
 *
 * 此组件为 [内容] 添加额外的样式，用于将相关的菜单项分组。
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/exposed-dropdown-menu-selectable-items.png)
 *
 * @param 形状集 菜单分组的 [MenuGroupShapes] 形状。所提供的形状应根据菜单中分组的数量以及该分组在菜单中的位置来确定。
 * 可使用便捷函数 [MenuDefaults.groupShape] 来轻松确定要使用的形状。
 * @param 修饰符 应用于此菜单分组的 [Modifier]。
 * @param 容器颜色 菜单分组的容器颜色。可使用 [MenuDefaults.groupStandardContainerColor] 和
 * [MenuDefaults.groupVibrantContainerColor] 这两个预定义的容器颜色。
 * @param 色调阴影 当 [容器颜色] 为 [ColorScheme.surface] 时，会在容器上方叠加一层半透明的主题色。
 * 色调海拔值越高，浅色主题下颜色越深，深色主题下颜色越浅。另请参阅：[表面]。
 * @param 视觉阴影 菜单分组下方阴影的海拔高度。
 * @param 边框 围绕菜单分组容器绘制的边框。
 * @param 内容内边距 应用于此菜单分组内容的内边距。
 * @param 交互源 用于观察和处理此菜单分组交互的可选提升式 [MutableInteractionSource]。
 * @param 内容 此菜单分组的内容，通常为 [DropdownMenuItem]。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单组(
    形状集: MenuGroupShapes,
    修饰符: Modifier = Modifier,
    容器颜色: Color = MenuDefaults.groupStandardContainerColor,
    色调阴影: Dp = MenuDefaults.TonalElevation,
    视觉阴影: Dp = MenuDefaults.ShadowElevation,
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuGroupContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) {
    DropdownMenuGroup(
        shapes = 形状集,
        modifier = 修饰符,
        containerColor = 容器颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 菜单在临时表面上显示一系列选项，当用户与按钮、操作或其他控件交互时显示。
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/menu.png)
 *
 * @param 文本 菜单项的文本。
 * @param 单击回调 当此菜单项被点击时调用。
 * @param 修饰符 应用于此菜单项的 [Modifier]。
 * @param 前导图标 在菜单项文本开头显示的可选前置图标。
 * @param 尾随图标 在菜单项文本末尾显示的可选后置图标。此后置图标插槽也可接受 [文本] 以指示键盘快捷键。
 * @param 已启用 控制此菜单项的启用状态。当为 `false` 时，此组件不会响应用户输入，视觉上呈现为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 颜色集 用于解析此菜单项在不同状态下所用颜色的 [MenuItemColors]。参见 [MenuDefaults.itemColors]。
 * @param 内容内边距 应用于此菜单项内容的内边距
 * @param 交互源 用于观察并发出此菜单项 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * 可用于更改菜单项的外观或在不同状态下预览菜单项。注意，即使传入 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 下拉菜单项(
    文本: @Composable () -> Unit,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    已启用: Boolean = true,
    颜色集: MenuItemColors = MenuDefaults.itemColors(),
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    交互源: MutableInteractionSource? = null,
){
    DropdownMenuItem(
        text = 文本,
        onClick = 单击回调,
        modifier = 修饰符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        enabled = 已启用,
        colors = 颜色集,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
    )
}

/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 菜单在临时表面上显示一系列选项，当用户与按钮、操作或其他控件交互时显示。
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/exposed-dropdown-menu-selectable-items.png)
 *
 * @param 单击回调 当此菜单项被点击时调用.
 * @param 文本 菜单项的文本
 * @param 形状 此菜单项的 [Shape] 形状。所提供的形状应根据分组或菜单中的项目数量以及该项目在菜单中的位置来确定。
 * 列表中的第一项请使用 [MenuDefaults.leadingItemShape]，中间项请使用 [MenuDefaults.middleItemShape]，
 * 最后一项请使用 [MenuDefaults.trailingItemShape]。
 * @param 修饰符 应用于此菜单项的 [Modifier]。
 * @param 前导图标 当菜单项未选中时显示的可选前置图标。
 * @param 尾随图标 在菜单项文本末尾显示的可选后置图标。
 * @param 已启用 控制此菜单项的启用状态。当为 `false` 时，此组件不会响应用户输入。
 * @param 颜色集 用于解析此菜单项颜色的 [MenuItemColors]。
 * @param 内容内边距 应用于此菜单项内容的内边距。
 * @param 交互源 用于观察并发出此菜单项 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * @param 辅助文本 菜单项的可选辅助文本。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单项(
    单击回调: () -> Unit,
    文本: @Composable () -> Unit,
    形状: Shape,
    修饰符: Modifier = Modifier,
    前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    已启用: Boolean = true,
    颜色集: MenuItemColors = MenuDefaults.itemColors(),
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuSelectableItemContentPadding,
    交互源: MutableInteractionSource? = null,
    辅助文本: @Composable (() -> Unit)? = null,
) {
    DropdownMenuItem(
        onClick = 单击回调,
        text = 文本,
        shape = 形状,
        modifier = 修饰符,
        leadingIcon = 前导图标,
        trailingIcon = 尾随图标,
        enabled = 已启用,
        colors = 颜色集,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        supportingText = 辅助文本,
    )
}



/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 根据 [已选中] 状态改变样式的菜单项。
 *
 * 此可组合项适用于表示开/关设置的菜单项，在菜单中行为类似于复选框或开关。
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/exposed-dropdown-menu-selectable-items.png)
 *
 * @param 已选中 此菜单项当前是否已选中
 * @param 已选中改变回调 当此菜单项被点击时调用，传入新的选中状态。
 * @param 文本 菜单项的文本。
 * @param 形状集 用于解析此菜单项形状的 [MenuItemShapes]。此项的形状由 [已选中] 的值决定。所提供的形状应根据分组
 * 或菜单中的项目数量以及该项目在菜单中的位置来确定。可使用便捷函数 [MenuDefaults.itemShape] 来轻松确定要使用的形状。
 * @param 修饰符 应用于此菜单项的 [Modifier]。
 * @param 前导图标 当菜单项未选中时显示的可选前置图标。
 * @param 已选中前导图标 当菜单项选中时显示的可选前置图标。
 * @param 尾随图标 在菜单项文本末尾显示的可选后置图标。
 * @param 已启用 控制此菜单项的启用状态。当为 `false` 时，此组件不会响应用户输入。
 * @param 颜色集 用于解析此菜单项颜色的 [MenuItemColors]。可使用或修改 [MenuDefaults.selectableItemColors]
 * 和 [MenuDefaults.selectableItemVibrantColors] 这两个预定义的 [MenuItemColors]。
 * @param 内容内边距 应用于此菜单项内容的内边距。
 * @param 交互源 用于观察并发出此菜单项 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * @param 辅助文本 菜单项的可选辅助文本。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单项(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    文本: @Composable () -> Unit,
    形状集: MenuItemShapes,
    修饰符: Modifier = Modifier,
    前导图标: @Composable (() -> Unit)? = null,
    已选中前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    已启用: Boolean = true,
    颜色集: MenuItemColors = MenuDefaults.selectableItemColors(),
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuSelectableItemContentPadding,
    交互源: MutableInteractionSource? = null,
    辅助文本: @Composable (() -> Unit)? = null,
) {
    DropdownMenuItem(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        text = 文本,
        shapes = 形状集,
        modifier = 修饰符,
        leadingIcon = 前导图标,
        checkedLeadingIcon = 已选中前导图标,
        trailingIcon = 尾随图标,
        enabled = 已启用,
        colors = 颜色集,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        supportingText = 辅助文本,
    )
}


/**
 * [Material Design dropdown menu](https://m3.material.io/components/menus/overview)
 *
 * 根据 [已选择] 状态改变样式的菜单项。
 *
 * 此可组合项适用于表示开/关设置的菜单项，在菜单中行为类似于单选按钮。
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/exposed-dropdown-menu-selectable-items.png)
 *
 * @param 已选择 此菜单项当前是否已选中。
 * @param 单击回调 当此菜单项被点击时调用。
 * @param 文本 菜单项的文本。
 * @param 形状集 用于解析此菜单项形状的 [MenuItemShapes]。此项的形状由 [已选择] 的值决定。所提供的形状应根据分组
 * 或菜单中的项目数量以及该项目在菜单中的位置来确定。可使用便捷函数 [MenuDefaults.itemShape] 来轻松确定要使用的形状。
 * @param 修饰符 应用于此菜单项的 [Modifier]。
 * @param 前导图标 当菜单项未选中时显示的可选前置图标。
 * @param 已选择前导图标 当菜单项选中时显示的可选前置图标。
 * @param 尾随图标 在菜单项文本末尾显示的可选后置图标。
 * @param 已启用 控制此菜单项的启用状态。当为 `false` 时，此组件不会响应用户输入。
 * @param 颜色集 用于解析此菜单项颜色的 [MenuItemColors]。可使用或修改 [MenuDefaults.selectableItemColors]
 * 和 [MenuDefaults.selectableItemVibrantColors] 这两个预定义的 [MenuItemColors]。
 * @param 内容内边距 应用于此菜单项内容的内边距。
 * @param 交互源 用于观察并发出此菜单项 [Interaction] 的可选提升式 [MutableInteractionSource]。
 * @param 辅助文本 菜单项的可选辅助文本。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 下拉菜单项(
    已选择: Boolean,
    单击回调: () -> Unit,
    文本: @Composable () -> Unit,
    形状集: MenuItemShapes,
    修饰符: Modifier = Modifier,
    前导图标: @Composable (() -> Unit)? = null,
    已选择前导图标: @Composable (() -> Unit)? = null,
    尾随图标: @Composable (() -> Unit)? = null,
    已启用: Boolean = true,
    颜色集: MenuItemColors = MenuDefaults.selectableItemColors(),
    内容内边距: PaddingValues = MenuDefaults.DropdownMenuSelectableItemContentPadding,
    交互源: MutableInteractionSource? = null,
    辅助文本: @Composable (() -> Unit)? = null,
) {
    DropdownMenuItem(
        selected = 已选择,
        onClick = 单击回调,
        text = 文本,
        shapes = 形状集,
        modifier = 修饰符,
        leadingIcon = 前导图标,
        selectedLeadingIcon = 已选择前导图标,
        trailingIcon = 尾随图标,
        enabled = 已启用,
        colors = 颜色集,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        supportingText = 辅助文本,
    )
}

// TODO: 考虑移入公开的 [MenuDefaults] 中
internal val DefaultMenuProperties: PopupProperties = PopupProperties(focusable = true)

/**
 * 表示菜单项在不同状态下使用的文本和图标颜色。
 *
 * @param 文本颜色 当此 [DropdownMenuItem] 启用时 的文本颜色。
 * @param 前导图标颜色 当此 [DropdownMenuItem] 启用时 的前置图标颜色。
 * @param 尾随图标颜色 当此 [DropdownMenuItem] 启用时 的后置图标颜色。
 * @param 禁用文本颜色 当此 [DropdownMenuItem] 未启用时 的文本颜色。
 * @param 禁用前导图标颜色 当此 [DropdownMenuItem] 未启用时 的前置图标颜色。
 * @param 禁用尾随图标颜色 当此 [DropdownMenuItem] 未启用时 的后置图标颜色。
 * @param 容器颜色 当此菜单项启用且未选中时的容器颜色。
 * @param 禁用容器颜色 当此菜单项未启用时的容器颜色。
 * @param 已选择文本颜色 当此菜单项启用且已选中时的文本颜色。
 * @param 已选择容器颜色 当此菜单项启用且已选中时的容器颜色。
 * @param 已选择前导图标颜色 当此菜单项启用且已选中时的前置图标颜色。
 * @param 已选择尾随图标颜色 当此菜单项启用且已选中时的后置图标颜色。
 * @constructor 使用任意颜色创建一个实例。有关 [DropdownMenuItem] 中使用的默认颜色，请参阅 [MenuDefaults.itemColors]。
 */
@ExperimentalMaterial3ExpressiveApi
fun 菜单项颜色集(
    文本颜色: Color,
    前导图标颜色: Color,
    尾随图标颜色: Color,
    禁用文本颜色: Color,
    禁用前导图标颜色: Color,
    禁用尾随图标颜色: Color,
    容器颜色: Color,
    禁用容器颜色: Color,
    已选择文本颜色: Color,
    已选择前导图标颜色: Color,
    已选择尾随图标颜色: Color,
    已选择容器颜色: Color,
) = MenuItemColors(
    textColor = 文本颜色,
    leadingIconColor = 前导图标颜色,
    trailingIconColor = 尾随图标颜色,
    disabledTextColor = 禁用文本颜色,
    disabledLeadingIconColor = 禁用前导图标颜色,
    disabledTrailingIconColor = 禁用尾随图标颜色,
    containerColor = 容器颜色,
    disabledContainerColor = 禁用容器颜色,
    selectedTextColor = 已选择文本颜色,
    selectedLeadingIconColor = 已选择前导图标颜色,
    selectedTrailingIconColor = 已选择尾随图标颜色,
    selectedContainerColor = 已选择容器颜色,
)

/**
 * 创建一个带有标准菜单项颜色的实例。
 *
 * 此构造函数用于 [DropdownMenuItem]。
 *
 * @param 文本颜色 当此菜单项启用时的文本颜色。
 * @param 前导图标颜色 当此菜单项启用时的前置图标颜色。
 * @param 尾随图标颜色 当此菜单项启用时的后置图标颜色。
 * @param 禁用文本颜色 当此菜单项未启用时的文本颜色。
 * @param 禁用前导图标颜色 当此菜单项未启用时的前置图标颜色。
 * @param 禁用尾随图标颜色 当此菜单项未启用时的后置图标颜色。
 */
@ExperimentalMaterial3ExpressiveApi
fun 菜单项颜色集(
    文本颜色: Color,
    前导图标颜色: Color,
    尾随图标颜色: Color,
    禁用文本颜色: Color,
    禁用前导图标颜色: Color,
    禁用尾随图标颜色: Color,
) = MenuItemColors(
    textColor = 文本颜色,
    leadingIconColor = 前导图标颜色,
    trailingIconColor = 尾随图标颜色,
    disabledTextColor = 禁用文本颜色,
    disabledLeadingIconColor = 禁用前导图标颜色,
    disabledTrailingIconColor = 禁用尾随图标颜色,
)

/** 当此菜单项启用且未选中时的容器颜色。 */
@ExperimentalMaterial3ExpressiveApi
val MenuItemColors.容器颜色: Color
    get() = this.containerColor

/** 当此菜单项未启用时的容器颜色。 */
@ExperimentalMaterial3ExpressiveApi
val MenuItemColors.禁用容器颜色
    get() = this.disabledContainerColor

/** 当此菜单项启用且已选中时的容器颜色。 */
@ExperimentalMaterial3ExpressiveApi
val MenuItemColors.已选择容器颜色: Color
    get() = this.selectedContainerColor

/** 当此菜单项启用且已选中时的文本颜色。 */
@ExperimentalMaterial3ExpressiveApi
val MenuItemColors.已选择文本颜色: Color
    get() = this.selectedTextColor

/** 当此菜单项启用且已选中时的前置图标颜色。 */
@ExperimentalMaterial3ExpressiveApi
val MenuItemColors.已选择前导图标颜色: Color
    get() = this.selectedLeadingIconColor

/** 当此菜单项启用且已选中时的后置图标颜色。 */
@ExperimentalMaterial3ExpressiveApi
val MenuItemColors.已选择尾随图标颜色: Color
    get() = this.selectedTrailingIconColor

/** 返回此 MenuItemColors 的副本，可选择性地覆盖其中某些值。这里使用 Color.Unspecified 来表示“使用源对象中的值”。*/
@ExperimentalMaterial3ExpressiveApi
fun MenuItemColors.复制(
    文本颜色: Color = this.textColor,
    容器颜色: Color = this.containerColor,
    前导图标颜色: Color = this.leadingIconColor,
    尾随图标颜色: Color = this.trailingIconColor,
    禁用文本颜色: Color = this.disabledTextColor,
    禁用容器颜色: Color = this.disabledContainerColor,
    禁用前导图标颜色: Color = this.disabledLeadingIconColor,
    禁用尾随图标颜色: Color = this.disabledTrailingIconColor,
    已选择文本颜色: Color = this.selectedTextColor,
    已选择容器颜色: Color = this.selectedContainerColor,
    已选择前导图标颜色: Color = this.selectedLeadingIconColor,
    已选择尾随图标颜色: Color = this.selectedTrailingIconColor,
) =
    this.copy(
        textColor = 文本颜色,
        containerColor = 容器颜色,
        leadingIconColor = 前导图标颜色,
        trailingIconColor = 尾随图标颜色,
        disabledTextColor = 禁用文本颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledLeadingIconColor = 禁用前导图标颜色,
        disabledTrailingIconColor = 禁用尾随图标颜色,
        selectedTextColor = 已选择文本颜色,
        selectedContainerColor = 已选择容器颜色,
        selectedLeadingIconColor = 已选择前导图标颜色,
        selectedTrailingIconColor = 已选择尾随图标颜色,
    )

/** 返回此 MenuItemColors 的副本，可选择性地覆盖其中某些值。这里使用 Color.Unspecified 来表示“使用源对象中的值”。*/
fun MenuItemColors.复制(
    文本颜色: Color = this.textColor,
    前导图标颜色: Color = this.leadingIconColor,
    尾随图标颜色: Color = this.trailingIconColor,
    禁用文本颜色: Color = this.disabledTextColor,
    禁用前导图标颜色: Color = this.disabledLeadingIconColor,
    禁用尾随图标颜色: Color = this.disabledTrailingIconColor,
) =
    this.copy(
        textColor = 文本颜色,
        leadingIconColor = 前导图标颜色,
        trailingIconColor = 尾随图标颜色,
        disabledTextColor = 禁用文本颜色,
        disabledLeadingIconColor = 禁用前导图标颜色,
        disabledTrailingIconColor = 禁用尾随图标颜色,
    )



/**
 * 表示 [下拉菜单项] 在各种状态下使用的形状。
 *
 * @param 形状 当该项未选中时使用的 [Shape]。
 * @param 已选择形状 当该项已选中时使用的 [Shape]。
 */
@ExperimentalMaterial3ExpressiveApi
fun 菜单项形状集(形状: Shape, 已选择形状: Shape) = // MenuItemShapes
    MenuItemShapes(shape = 形状, selectedShape = 已选择形状)

/** 返回此 MenuItemShapes 的副本，可选择性地覆盖其中某些值。 */
@ExperimentalMaterial3ExpressiveApi
fun MenuItemShapes.复制(形状: Shape? = this.shape, 已选择形状: Shape? = this.selectedShape) =
    this.copy(shape = 形状, selectedShape = 已选择形状)


/**
 * 表示 [下拉菜单组] 在各种状态下使用的形状。
 *
 * @param 形状 用于该组的默认 [Shape]。
 * @param 非激活形状 当该组不再悬停时使用的 [Shape]。
 */
@ExperimentalMaterial3ExpressiveApi
fun 菜单组形状集(形状: Shape, 非激活形状: Shape) = // MenuGroupShapes
    MenuGroupShapes(shape = 形状, inactiveShape = 非激活形状)


/** 返回此 MenuGroupShapes 的副本，可选择性地覆盖其中某些值。 */
@ExperimentalMaterial3ExpressiveApi
fun MenuGroupShapes.复制(形状: Shape? = this.shape, 非激活形状: Shape? = this.inactiveShape) =
    this.copy(shape = 形状, inactiveShape = 非激活形状)


