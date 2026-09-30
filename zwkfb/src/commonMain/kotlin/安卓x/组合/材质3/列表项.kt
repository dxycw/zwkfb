package 安卓x.组合.材质3

import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.ListItemElevation
import androidx.compose.material3.ListItemShapes
import androidx.compose.material3.RadioButton
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ListItem
import androidx.compose.material3.SegmentedListItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


/**
 * [Material Design list item](https://m3.material.io/components/lists/overview)
 *
 * 列表是由文本或图像组成的连续垂直索引。
 *
 * 列表项的这个重载不处理任何用户交互。有关处理一般点击操作、单选或多选，请参阅其他重载。
 *
 * ![Lists image](https://developer.android.com/images/reference/androidx/compose/material3/lists.png)
 *
 * 该组件可用于实现规范中现有的列表项模板。单行列表项具有一行标题内容。双行列表项额外具有辅助内容或上标内容。
 * 三行列表项要么同时具有辅助内容和上标内容，要么具有扩展（两行）辅助文本。
 *
 * @param 标题内容 列表项的标题内容。
 * @param 修饰符 要应用于列表项的 [Modifier]。
 * @param 上划线内容 显示在标题内容上方的内容。
 * @param 辅助内容 列表项的辅助内容。
 * @param 前导内容 表项的前置内容。
 * @param 尾随内容 尾部的元文本、图标、开关或复选框。
 * @param 颜色集 将用于解析此列表项在不同状态下的背景色和内容颜色的 [ListItemColors]。请参阅 [ListItemDefaults.colors]。
 * @param 色调阴影 此列表项的色调阴影。
 * @param 视觉阴影 此列表项的阴影高度。
 */
@Suppress("ComposableNaming")
@Composable
fun 列表项(
    标题内容: @Composable () -> Unit,
    修饰符: Modifier = Modifier,
    上划线内容: @Composable (() -> Unit)? = null,
    辅助内容: @Composable (() -> Unit)? = null,
    前导内容: @Composable (() -> Unit)? = null,
    尾随内容: @Composable (() -> Unit)? = null,
    颜色集: ListItemColors = ListItemDefaults.colors(),
    色调阴影: Dp = ListItemDefaults.Elevation,
    视觉阴影: Dp = ListItemDefaults.Elevation,
) =
    ListItem(
        headlineContent = 标题内容,
        modifier = 修饰符,
        overlineContent = 上划线内容,
        supportingContent = 辅助内容,
        leadingContent = 前导内容,
        trailingContent = 尾随内容,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
    )


/**
 * [Material Design standard list item](https://m3.material.io/components/lists/overview)
 *
 * 列表是文本或图像的连续垂直索引。
 *
 * 此 [ListItem] 重载会处理点击事件，调用其 [单击回调] lambda 来触发一个操作。有关处理单选、多选或不处理交互的其他重载，
 * 请参阅其他重载。
 *
 * @param 单击回调 当点击此列表项时调用。
 * @param 修饰符 应用于此列表项的 [Modifier]。
 * @param 已启用 控制此列表项的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上会显示为禁用，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导内容 此列表项的前置内容，例如图标或头像。
 * @param 尾随内容 此列表项的后置内容，例如复选框、开关或图标。
 * @param 上划线内容 显示在列表项主要内容上方的内容。
 * @param 辅助内容 显示在列表项主要内容下方的内容。
 * @param 垂直对齐 在计入 [内容内边距] 后，列表项内子项的垂直对齐方式。
 * @param 长按回调 当长按（长点击）此列表项时调用。
 * @param 长按标签回调 用于 [长按回调] 操作的语义/无障碍标签。
 * @param 形状集 此列表项将根据用户与列表项的交互，用于在 [ListItemShapes] 之间进行形变（morph）的 [ListItemShapes]。
 * 参见 [ListItemDefaults.shapes]。
 * @param 颜色集 用于在不同状态下解析此列表项所用颜色的 [ListItemColors]。参见 [ListItemDefaults.colors]。
 * @param 阴影 用于在不同状态下解析此列表项阴影高度（elevation）的 [ListItemElevation]。
 * 参见 [ListItemDefaults.elevation]。
 * @param 内容内边距 应用于此列表项内容的内边距。
 * @param 交互源 一个可选的、提升（hoisted）的 [MutableInteractionSource]，用于观察和发出此列表项的
 * [Interaction]。你可以使用它来更改列表项的外观，或在不同状态下预览列表项。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此列表项的主要内容。也称为标题或标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 列表项(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导内容: @Composable (() -> Unit)? = null,
    尾随内容: @Composable (() -> Unit)? = null,
    上划线内容: @Composable (() -> Unit)? = null,
    辅助内容: @Composable (() -> Unit)? = null,
    垂直对齐: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
    长按回调: (() -> Unit)? = null,
    长按标签回调: String? = null,
    形状集: ListItemShapes = ListItemDefaults.shapes(),
    颜色集: ListItemColors = ListItemDefaults.colors(),
    阴影: ListItemElevation = ListItemDefaults.elevation(),
    内容内边距: PaddingValues = ListItemDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    ListItem(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        leadingContent = 前导内容,
        trailingContent = 尾随内容,
        overlineContent = 上划线内容,
        supportingContent = 辅助内容,
        verticalAlignment = 垂直对齐,
        onLongClick = 长按回调,
        onLongClickLabel = 长按标签回调,
        shapes = 形状集,
        colors = 颜色集,
        elevation = 阴影,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容
    )

/**
 * [Material Design standard list item](https://m3.material.io/components/lists/overview)
 *
 * 列表是文本或图像的连续垂直索引。
 *
 * 此 [ListItem] 重载表示一个单选条目，类似于 [RadioButton]。有关处理常规点击操作、多选或不处理交互的其他重载，
 * 请参阅其他重载。
 *
 * @param 已选择 此列表项是否被选中。
 * @param 单击回调 当点击此列表项时调用。
 * @param 修饰符 应用于此列表项的 [Modifier]。
 * @param 已启用 控制此列表项的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上会显示为禁用，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导内容 此列表项的前置内容，例如图标或头像。
 * @param 尾随内容 此列表项的后置内容，例如复选框、开关或图标。
 * @param 上划线内容 显示在列表项主要内容上方的内容。
 * @param 辅助内容 显示在列表项主要内容下方的内容。
 * @param 垂直对齐 在计入 [内容内边距] 后，列表项内子项的垂直对齐方式。
 * @param 长按回调 当此列表项被长按（长点击）时调用。
 * @param 长按标签回调 用于 [长按回调] 操作的语义/无障碍标签。
 * @param 形状集 此列表项将根据用户与其的交互，用来在多个 [ListItemShapes] 之间进行形变（morph）的 [ListItemShapes]。
 * 参见 [ListItemDefaults.shapes]。
 * @param 颜色集 用于在不同状态下解析此列表项所用颜色的 [ListItemColors]。参见 [ListItemDefaults.colors]。
 * @param 阴影 用于在不同状态下解析此列表项阴影高度（elevation）的 [ListItemElevation]。
 * 参见 [ListItemDefaults.elevation]。
 * @param 内容内边距 应用于此列表项内容的内边距。
 * @param 交互源 一个可选的、提升（hoisted）的 [MutableInteractionSource]，用于观察和发出此列表项的
 * [Interaction]。你可以使用它来更改列表项的外观，或在不同状态下预览列表项。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 此列表项的主要内容。也称为标题或标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 列表项(
    已选择: Boolean,
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导内容: @Composable (() -> Unit)? = null,
    尾随内容: @Composable (() -> Unit)? = null,
    上划线内容: @Composable (() -> Unit)? = null,
    辅助内容: @Composable (() -> Unit)? = null,
    垂直对齐: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
    长按回调: (() -> Unit)? = null,
    长按标签回调: String? = null,
    形状集: ListItemShapes = ListItemDefaults.shapes(),
    颜色集: ListItemColors = ListItemDefaults.colors(),
    阴影: ListItemElevation = ListItemDefaults.elevation(),
    内容内边距: PaddingValues = ListItemDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    ListItem(
        selected = 已选择,
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        leadingContent = 前导内容,
        trailingContent = 尾随内容,
        overlineContent = 上划线内容,
        supportingContent = 辅助内容,
        verticalAlignment = 垂直对齐,
        onLongClick = 长按回调,
        onLongClickLabel = 长按标签回调,
        shapes = 形状集,
        colors = 颜色集,
        elevation = 阴影,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容
    )


/**
 * [Material Design standard list item](https://m3.material.io/components/lists/overview)
 *
 * 列表是文本或图像的连续、垂直索引。
 *
 * [ListItem]的这个重载表示一个多选（可切换）项，类似于[Checkbox]。有关处理常规点击操作、单选或不进行交互处理的其他重载，
 * 请参阅相应重载。
 *
 * @param 已选中 此列表项是处于开启状态还是关闭状态。
 * @param 已选中改变回调 当此可切换列表项被点击时调用。
 * @param 修饰符 应用于此列表项的 [Modifier]。
 * @param 已启用 控制此列表项的启用状态。当为 `false` 时，此组件将不响应用户输入，并且在视觉上显示为禁用，
 * 对无障碍服务也表现为禁用。
 * @param  前导内容 此列表项的前导内容，例如图标或头像。
 * @param 尾随内容 此列表项的尾随内容，例如复选框、开关或图标。
 * @param 上划线内容 显示在列表项主要内容上方的内容。
 * @param 辅助内容 显示在列表项主要内容下方的内容。
 * @param 垂直对齐 在考虑 [内容内边距] 之后，列表项内子项的垂直对齐方式。
 * @param 长按回调 当此列表项被长点击（长按）时调用。
 * @param 长按标签回调 用于 [长按回调] 操作的语义/无障碍标签。
 * @param 形状集 此列表项将根据用户与列表项的交互，使用 [ListItemShapes] 在其间进行变形。请参阅 [ListItemDefaults.shapes]。
 * @param 颜色集 [ListItemColors]将用于解析此列表项在不同状态下所使用的颜色。请参阅 [ListItemDefaults.colors]。
 * @param 阴影 用于在不同状态下解析此列表项高度的 [ListItemElevation]。请参阅 [ListItemDefaults.elevation]。
 * @param 内容内边距 应用于此列表项内容的内边距。
 * @param 交互源 一个可选的提升的 [MutableInteractionSource]，用于观察和发出此列表项的 [Interaction]。
 * 你可以使用它来更改列表项的外观或预览不同状态下的列表项。请注意，如果提供了 `null`，交互仍将在内部发生。
 * @param 内容 此列表项的主要内容。也称为标题或标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 列表项(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导内容: @Composable (() -> Unit)? = null,
    尾随内容: @Composable (() -> Unit)? = null,
    上划线内容: @Composable (() -> Unit)? = null,
    辅助内容: @Composable (() -> Unit)? = null,
    垂直对齐: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
    长按回调: (() -> Unit)? = null,
    长按标签回调: String? = null,
    形状集: ListItemShapes = ListItemDefaults.shapes(),
    颜色集: ListItemColors = ListItemDefaults.colors(),
    阴影: ListItemElevation = ListItemDefaults.elevation(),
    内容内边距: PaddingValues = ListItemDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    ListItem(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        leadingContent =  前导内容,
        trailingContent = 尾随内容,
        overlineContent = 上划线内容,
        supportingContent = 辅助内容,
        verticalAlignment = 垂直对齐,
        onLongClick = 长按回调,
        onLongClickLabel = 长按标签回调,
        shapes = 形状集,
        colors = 颜色集,
        elevation = 阴影,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容
    )


/**
 * [Material Design segmented list item](https://m3.material.io/components/lists/overview)
 *
 * 列表是文本或图像的连续、垂直索引。
 *
 * [SegmentedListItem] 的这个重载处理点击事件，调用其 [单击回调] lambda 来触发一个操作。有关处理单选、多选或不处理交互的情况，
 * 请参阅其他重载。
 *
 * @param 单击回调 当此列表项被点击时调用。
 * @param 形状集 此列表项将使用的 [ListItemShapes]，用于根据用户与列表项的交互在多个形状之间进行变形。
 * 基础形状取决于该项在整个列表中的索引。请参阅 [ListItemDefaults.segmentedShapes]。
 * @param 修饰符 要应用于此列表项的 [Modifier]。
 * @param 已启用 控制此列表项的启用状态。当为 `false` 时，此组件将不响应用户输入，并且在视觉上会显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导内容 此列表项的前置内容，例如图标或头像。
 * @param 尾随内容 此列表项的后置内容，例如复选框、开关或图标。
 * @param 上划线内容 显示在列表项主要内容上方的内容。
 * @param 辅助内容 显示在列表项主要内容下方的内容。
 * @param 垂直对齐 在考虑 [内容内边距] 之后，列表项内子项的垂直对齐方式。
 * @param 长按回调 当此列表项被长点击（长按）时调用。
 * @param 长按标签回调 [长按回调] 操作的语义/无障碍标签。
 * @param 颜色集 将用于解析此列表项在不同状态下所使用的颜色的 [ListItemColors]。请参阅 [ListItemDefaults.segmentedColors]。
 * @param 阴影 用于在不同状态下解析此列表项高度的 [ListItemElevation]。请参阅 [ListItemDefaults.elevation]。
 * @param 内容内边距 要应用于此列表项内容的内边距。
 * @param 交互源 一个可选的、提升的 [MutableInteractionSource]，用于观察和发出此列表项的 [Interaction]。
 * 你可以使用它来更改列表项的外观，或在不同的状态下预览列表项。请注意，如果提供了 `null`，交互仍将在内部发生。
 * @param 内容 此列表项的主要内容。也称为标题或标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 分段列表项(
    单击回调: () -> Unit,
    形状集: ListItemShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导内容: @Composable (() -> Unit)? = null,
    尾随内容: @Composable (() -> Unit)? = null,
    上划线内容: @Composable (() -> Unit)? = null,
    辅助内容: @Composable (() -> Unit)? = null,
    垂直对齐: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
    长按回调: (() -> Unit)? = null,
    长按标签回调: String? = null,
    颜色集: ListItemColors = ListItemDefaults.segmentedColors(),
    阴影: ListItemElevation = ListItemDefaults.elevation(),
    内容内边距: PaddingValues = ListItemDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    SegmentedListItem(
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        leadingContent = 前导内容,
        trailingContent = 尾随内容,
        overlineContent = 上划线内容,
        supportingContent = 辅助内容,
        verticalAlignment = 垂直对齐,
        onLongClick = 长按回调,
        onLongClickLabel = 长按标签回调,
        colors = 颜色集,
        elevation = 阴影,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容
    )


/**
 * [Material Design segmented list item](https://m3.material.io/components/lists/overview)
 *
 * 列表是文本或图像的连续、垂直索引。
 *
 * [SegmentedListItem] 的这个重载表示一个单选项目，类似于 [RadioButton]。有关处理常规点击操作、多选或不处理交互的情况，
 * 请参阅其他重载。
 *
 * @param 已选择 此列表项是否被选中。
 * @param 单击回调 当此列表项被点击时调用。
 * @param 形状集 此列表项将使用的 [ListItemShapes]，用于根据用户与列表项的交互在它们之间进行变形。
 * 基础形状取决于该项在整个列表中的索引。请参阅 [ListItemDefaults.segmentedShapes]。
 * @param 修饰符 要应用于此列表项的 [Modifier]。
 * @param 已启用 控制此列表项的启用状态。当为 `false` 时，此组件将不响应用户输入，并且在视觉上会显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导内容 此列表项的前置内容，例如图标或头像。
 * @param 尾随内容 此列表项的后置内容，例如复选框、开关或图标。
 * @param 上划线内容 显示在列表项主要内容上方的内容。
 * @param 辅助内容 显示在列表项主要内容下方的内容。
 * @param 垂直对齐 在考虑 [内容内边距] 之后，列表项内子项的垂直对齐方式。
 * @param 长按回调 当此列表项被长点击（长按）时调用。
 * @param 长按标签回调 [长按回调] 操作的语义/无障碍标签。
 * @param 颜色集 将用于解析此列表项在不同状态下所使用的颜色的 [ListItemColors]。请参阅 [ListItemDefaults.segmentedColors]。
 * @param 阴影 用于在不同状态下解析此列表项高程（elevation）的 [ListItemElevation]。请参阅 [ListItemDefaults.elevation]。
 * @param 内容内边距 要应用于此列表项内容的内边距。
 * @param 交互源 一个可选的、提升的 [MutableInteractionSource]，用于观察和发出此列表项的 [Interaction]。
 * 你可以使用它来更改列表项的外观，或在不同的状态下预览列表项。请注意，如果提供了 `null`，交互仍将在内部发生。
 * @param 内容 此列表项的主要内容。也称为标题或标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 分段列表项(
    已选择: Boolean,
    单击回调: () -> Unit,
    形状集: ListItemShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导内容: @Composable (() -> Unit)? = null,
    尾随内容: @Composable (() -> Unit)? = null,
    上划线内容: @Composable (() -> Unit)? = null,
    辅助内容: @Composable (() -> Unit)? = null,
    垂直对齐: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
    长按回调: (() -> Unit)? = null,
    长按标签回调: String? = null,
    颜色集: ListItemColors = ListItemDefaults.segmentedColors(),
    阴影: ListItemElevation = ListItemDefaults.elevation(),
    内容内边距: PaddingValues = ListItemDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    SegmentedListItem(
        selected = 已选择,
        onClick = 单击回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        leadingContent = 前导内容,
        trailingContent = 尾随内容,
        overlineContent = 上划线内容,
        supportingContent = 辅助内容,
        verticalAlignment = 垂直对齐,
        onLongClick = 长按回调,
        onLongClickLabel = 长按标签回调,
        colors = 颜色集,
        elevation = 阴影,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容
    )


/**
 * [Material Design segmented list item](https://m3.material.io/components/lists/overview)
 *
 * 列表是文本或图像的连续、垂直索引。
 *
 * [SegmentedListItem] 的这个重载表示一个多选（可切换）项目，类似于 [Checkbox]。有关处理常规点击操作、单选或不处理交互的情况，
 * 请参阅其他重载。
 *
 * @param 已选中 此列表项是开启还是关闭。
 * @param 已选中改变回调 当此可切换列表项被点击时调用。
 * @param 形状集 此列表项将使用的 [ListItemShapes]，用于根据用户与列表项的交互在多个形状之间进行变形。
 * 基础形状取决于该项在整个列表中的索引。请参阅 [ListItemDefaults.segmentedShapes]。
 * @param 修饰符 要应用于此列表项的 [Modifier]。
 * @param 已启用 控制此列表项的启用状态。当为 `false` 时，此组件将不响应用户输入，并且在视觉上会显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 前导内容 此列表项的前置内容，例如图标或头像。
 * @param 尾随内容 此列表项的后置内容，例如复选框、开关或图标。
 * @param 上划线内容 t显示在列表项主要内容上方的内容。
 * @param 辅助内容 显示在列表项主要内容下方的内容。
 * @param 垂直对齐 在考虑 [内容内边距] 之后，列表项内子项的垂直对齐方式。
 * @param 长按回调 当此列表项被长点击（长按）时调用。
 * @param 长按标签回调 [长按回调] 操作的语义/无障碍标签。
 * @param 颜色集 将用于解析此列表项在不同状态下所使用的颜色的 [ListItemColors]。请参阅 [ListItemDefaults.segmentedColors]。
 * @param 阴影 用于在不同状态下解析此列表项高程（elevation）的 [ListItemElevation]。请参阅 [ListItemDefaults.elevation]。
 * @param 内容内边距 要应用于此列表项内容的内边距。
 * @param 交互源 一个可选的、提升的 [MutableInteractionSource]，用于观察和发出此列表项的 [Interaction]。
 * 你可以使用它来更改列表项的外观，或在不同的状态下预览列表项。请注意，如果提供了 `null`，交互仍将在内部发生。
 * @param 内容 此列表项的主要内容。也称为标题或标签。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 分段列表项(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状集: ListItemShapes,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    前导内容: @Composable (() -> Unit)? = null,
    尾随内容: @Composable (() -> Unit)? = null,
    上划线内容: @Composable (() -> Unit)? = null,
    辅助内容: @Composable (() -> Unit)? = null,
    垂直对齐: Alignment.Vertical = ListItemDefaults.verticalAlignment(),
    长按回调: (() -> Unit)? = null,
    长按标签回调: String? = null,
    颜色集: ListItemColors = ListItemDefaults.segmentedColors(),
    阴影: ListItemElevation = ListItemDefaults.elevation(),
    内容内边距: PaddingValues = ListItemDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    内容: @Composable () -> Unit,
) =
    SegmentedListItem(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shapes = 形状集,
        modifier = 修饰符,
        enabled = 已启用,
        leadingContent = 前导内容,
        trailingContent = 尾随内容,
        overlineContent = 上划线内容,
        supportingContent = 辅助内容,
        verticalAlignment = 垂直对齐,
        onLongClick = 长按回调,
        onLongClickLabel = 长按标签回调,
        colors = 颜色集,
        elevation = 阴影,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容
    )
