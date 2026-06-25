package 安卓x.组合.材质3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuGroup
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuGroupShapes
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.MenuItemShapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp


/** 包含 [下拉菜单] 和 [下拉菜单项] 使用的默认值。 */
object 菜单默认值 { // MenuDefaults

    /** 菜单的默认色调高度。 */
    val 色调阴影 = MenuDefaults.TonalElevation

    /** 菜单的默认阴影高度。 */
    val 视觉阴影 = MenuDefaults.ShadowElevation

    /** 菜单项的默认前置图标尺寸。*/
    val 前导图标大小 = MenuDefaults.LeadingIconSize

    /** 菜单项的默认尾部图标尺寸。 */
    val 尾随图标大小 = MenuDefaults.TrailingIconSize

    /** 菜单的默认形状。 */
    val 形状
        @Composable get() = MenuDefaults.shape

    /** 菜单的默认容器颜色。 */
    val 容器颜色
        @Composable get() = MenuDefaults.containerColor

    /**
     * 菜单中分组的默认容器颜色。
     *
     * 菜单有两种颜色选项：标准（基于 surface）和鲜明（基于 tertiary）。
     *
     * 这些映射为较低或较高的视觉强调提供了选项。鲜艳的菜单（Vibrant menus）更为突出醒目，因此应当谨慎使用。
     */
    // TODO 当 token 可用时，用 token 进行更新。
    @ExperimentalMaterial3ExpressiveApi
    val 组标准容器颜色: Color
        @Composable get() = MenuDefaults.groupStandardContainerColor

    /**
     * 菜单中某个分组的鲜艳默认容器颜色。
     *
     * 菜单有两种颜色选项：标准（基于 surface 颜色）和鲜艳（基于 tertiary 颜色）。
     *
     * 这些映射为较低或较高的视觉强调提供了选项。鲜艳的菜单更为突出醒目，因此应当谨慎使用。
     */
    // TODO 当 token 可用时，用 token 进行更新。
    @ExperimentalMaterial3ExpressiveApi
    val 组变体容器颜色: Color
        @Composable get() = MenuDefaults.groupVibrantContainerColor

    /** 菜单中前置分组的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 前导组形状: Shape
        @Composable
        get() = MenuDefaults.leadingGroupShape

    /** 菜单中中间分组的默认形状。*/
    @ExperimentalMaterial3ExpressiveApi
    val 中间组形状: Shape
        @Composable get() = MenuDefaults.middleGroupShape

    /** 菜单中后置分组的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 尾随组形状: Shape
        @Composable
        get() = MenuDefaults.trailingGroupShape

    /** 菜单或分组中前置项的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 前导项形状: Shape
        @Composable
        get() = MenuDefaults.leadingItemShape

    /** 菜单或分组中中间项的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 中间项形状: Shape
        @Composable get() = MenuDefaults.middleItemShape

    /** 菜单或分组中后置项的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 尾随项形状: Shape
        @Composable
        get() = MenuDefaults.trailingItemShape

    /** 菜单或分组中独立项的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 独立项形状: Shape
        @Composable get() = MenuDefaults.standaloneItemShape

    /** 分组中各项的选中状态形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 选中项形状: Shape
        @Composable get() = MenuDefaults.selectedItemShape

    /** 菜单中独立分组的默认形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 独立组形状: Shape
        @Composable get() = MenuDefaults.standaloneGroupShape

    /** 菜单中不再处于悬停状态的分组的形状。 */
    @ExperimentalMaterial3ExpressiveApi
    val 非激活组形状: Shape
        @Composable get() = MenuDefaults.inactiveGroupShape

    /** 每个菜单分组之间的默认间距。通常用于 [Spacer] 的高度。 */
    @ExperimentalMaterial3ExpressiveApi
    val 组间距: Dp = MenuDefaults.GroupSpacing

    /** 用于菜单分组中 [HorizontalDivider] 的默认内边距。将此内边距值用于 [HorizontalDivider] 的 padding 修饰符中。*/
    @ExperimentalMaterial3ExpressiveApi
    val 水平分隔线内边距: PaddingValues = MenuDefaults.HorizontalDividerPadding

    /** 菜单分组标签的默认水平内边距。请参阅 [MenuDefaults.Label]。 */
    @ExperimentalMaterial3ExpressiveApi
    val 下拉菜单组标签水平内边距 = MenuDefaults.DropdownMenuGroupLabelHorizontalPadding

    /**
     * 一个 [MenuGroupShapes] 构造器，用于指定当菜单中共有 [数量] 个分组时，位于 [索引] 位置的分组应使用的形状。
     *
     * @param 索引 该分组在菜单中的索引位置。
     * @param 数量 此菜单中分组的总数。
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 组形状(索引: Int, 数量: Int): MenuGroupShapes =
        MenuDefaults.groupShape(index = 索引, count = 数量)


    /**
     * 一个 [MenuItemShapes] 构造器，用于指定当菜单或分组中共有 [数量] 个项时，位于 [索引] 位置的项应使用的形状。
     * 如果使用了 [DropdownMenuGroup]，请将分组内的项数作为 [数量] 传入。如果未使用 [DropdownMenuGroup]，
     * 请将整个菜单中的项数作为 [数量] 传入。
     *
     * @param 索引 该项在菜单或分组中的索引位置。
     * @param 数量 此菜单或分组中项的总数。
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 项形状(索引: Int, 数量: Int): MenuItemShapes =
        MenuDefaults.itemShape(index = 索引, count = 数量)


    /** 创建一个 [MenuItemColors]，表示 [DropdownMenuItem] 中使用的默认文本和图标颜色。*/
    @Composable
    fun 项颜色集(): MenuItemColors = MenuDefaults.itemColors()


    /**
     * 创建一个 [MenuItemShapes]，表示可切换或可选中的 [DropdownMenuItem] 中使用的形状，并允许进行覆盖。
     *
     * 有一个便捷函数可用于轻松确定应使用的形状，详见 [MenuDefaults.itemShape]。
     *
     * @param 形状 未选中时的形状。如果传入 null，则默认使用 [中间项形状]。
     * @param 选中形状 选中时的形状。如果传入 null，则默认使用 [选中项形状]。
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 项形状集(形状: Shape? = null, 选中形状: Shape? = null): MenuItemShapes =
        MenuDefaults.itemShapes(shape = 形状, selectedShape = 选中形状,)

    /**
     * 创建一个 [MenuItemShapes]，用于表示可切换（toggleable）或可选择（selectable）的[DropdownMenuItem] 中所使用的形状。
     *
     * 有一个便捷函数，可用于轻松确定要在 [MenuDefaults.itemShape] 中使用的形状。
     *
     * 此 [MenuItemShapes] 将 [MenuDefaults.standaloneItemShape] 作为普通形状，
     * 将 [MenuDefaults.selectedItemShape] 作为选中时的形状。
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 项形状集(): MenuItemShapes = MenuDefaults.itemShapes()

    /**
     * 创建一个 [MenuGroupShapes]，表示 [DropdownMenuGroup] 中使用的默认形状，同时允许进行覆盖。
     *
     * 有一个便捷函数，可用于轻松确定要使用的形状，详见 [MenuDefaults.groupShape]。
     *
     * @param 形状 菜单组的默认形状。如果传入 null，则默认使用 [独立组形状]。
     * @param 非激活形状 不再悬停时的形状。如果传入 null，则默认使用 [非激活组形状]。
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 组形状集(形状: Shape? = null, 非激活形状: Shape? = null): MenuGroupShapes =
        MenuDefaults.groupShapes(shape = 形状, inactiveShape = 非激活形状,)

    /**
     * 创建一个 [MenuGroupShapes]，表示 [DropdownMenuGroup] 中使用的默认形状。
     *
     * 此 [MenuGroupShapes] 的形状为 [MenuDefaults.standaloneGroupShape]，非激活形状为 [MenuDefaults.inactiveGroupShape]。
     * 非激活形状是指该菜单组不再被悬停时的形状。
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 组形状集() = MenuDefaults.groupShapes()

    /**
     * 建议在 [DropdownMenuGroup] 中使用的默认标签。
     *
     * 标签可用于对菜单组的部分内容或整个菜单组进行分类。
     *
     * @param 内容对齐 标签内容的对齐方式。
     * @param 内边距 应用于标签内容的内边距。
     * @param 内容 标签的内容。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 标签(
        内容对齐: Alignment = Alignment.CenterStart,
        内边距: PaddingValues = MenuDefaults.DropdownMenuGroupLabelHorizontalPadding,
        内容: @Composable () -> Unit,
    ) = MenuDefaults.Label(contentAlignment = 内容对齐, padding = 内边距, content = 内容,)

    /** 菜单组尾部标签的默认水平内边距。详见 [MenuDefaults.DropdownMenuItemTrailingLabel]。*/
    @ExperimentalMaterial3ExpressiveApi
    val 下拉菜单项尾随标签水平内边距 = MenuDefaults.DropdownMenuItemTrailingLabelHorizontalPadding

    /**
     * 建议在 [DropdownMenuItem] 中使用的默认尾部标签，可传入其 trailingIcon 参数。
     *
     * @param 内边距 应用于标签内容的内边距。
     * @param 内容 标签的内容。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 下拉菜单项尾随标签(
        内边距: PaddingValues = MenuDefaults.DropdownMenuItemTrailingLabelHorizontalPadding,
        内容: @Composable () -> Unit,
    ) = MenuDefaults.DropdownMenuItemTrailingLabel(padding = 内边距, content = 内容,)

    /**
     * 标签及其辅助文本组成的 [Column]。当需要辅助文本时，用于 [DropdownMenuItem] 的 text 参数。
     *
     * @param 辅助文本 标签的辅助文本。
     * @param 内容 标签的内容。
     */
    @Suppress("ComposableNaming")
    @Deprecated(
        "Removed in favor of the DropdownMenuItem APIs that have supportingText as a parameter.",
        level = DeprecationLevel.WARNING,
    )
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 标签带辅助文本(
        辅助文本: @Composable () -> Unit,
        内容: @Composable () -> Unit,
    ) = MenuDefaults.LabelWithSupportingText(supportingText = 辅助文本, content = 内容,)

    /**
     * 创建一个 [MenuItemColors]，表示 [DropdownMenuItem] 中使用的默认文本和图标颜色。
     *
     * @param 文本颜色 此 [DropdownMenuItem] 启用时的文本颜色。
     * @param 前导图标颜色 此 [DropdownMenuItem] 启用时的前置图标颜色。
     * @param 尾随图标颜色 此 [DropdownMenuItem] 启用时的尾部图标颜色。
     * @param 禁用文本颜色 此 [DropdownMenuItem] 未启用时的文本颜色。
     * @param 禁用前导图标颜色 此 [DropdownMenuItem] 未启用时的前置图标颜色。
     * @param 禁用尾随图标颜色 此 [DropdownMenuItem] 未启用时的尾部图标颜色。
     */
    @Composable
    fun 项颜色集(
        文本颜色: Color = Color.Unspecified,
        前导图标颜色: Color = Color.Unspecified,
        尾随图标颜色: Color = Color.Unspecified,
        禁用文本颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
    ): MenuItemColors =
        MenuDefaults.itemColors(
            textColor = 文本颜色,
            leadingIconColor = 前导图标颜色,
            trailingIconColor = 尾随图标颜色,
            disabledTextColor = 禁用文本颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
        )

    /**
     * 创建一个 [MenuItemColors]，表示标准颜色变体 [DropdownMenuItem] 中使用的默认文本、图标和容器颜色。
     *
     * @param 文本颜色 此 [DropdownMenuItem] 启用时的文本颜色。
     * @param 容器颜色 此 [DropdownMenuItem] 启用且未选中时的容器颜色。
     * @param 前导图标颜色 此 [DropdownMenuItem] 启用时的前置图标颜色。
     * @param 尾随图标颜色 此 [DropdownMenuItem] 启用时的尾部图标颜色。
     * @param 禁用文本颜色 此 [DropdownMenuItem] 未启用时的文本颜色。
     * @param 禁用前导图标颜色 此 [DropdownMenuItem] 未启用时的前置图标颜色。
     * @param 禁用尾随图标颜色 此 [DropdownMenuItem] 未启用时的尾部图标颜色。
     * @param 已选择容器颜色 此 [DropdownMenuItem] 启用且选中时的容器颜色。
     * @param 已选择文本颜色 此 [DropdownMenuItem] 启用且选中时的文本颜色。
     * @param 已选择前导图标颜色 此 [DropdownMenuItem] 启用且选中时的前置图标颜色。
     * @param 已选择尾随图标颜色 此 [DropdownMenuItem] 启用且选中时的尾部图标颜色。
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 选择项颜色集(
        文本颜色: Color = Color.Unspecified,
        容器颜色: Color = Color.Unspecified,
        前导图标颜色: Color = Color.Unspecified,
        尾随图标颜色: Color = Color.Unspecified,
        禁用文本颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        已选择容器颜色: Color = Color.Unspecified,
        已选择文本颜色: Color = Color.Unspecified,
        已选择前导图标颜色: Color = Color.Unspecified,
        已选择尾随图标颜色: Color = Color.Unspecified,
    ): MenuItemColors =
        MenuDefaults.selectableItemColors(
            textColor = 文本颜色,
            containerColor = 容器颜色,
            leadingIconColor = 前导图标颜色,
            trailingIconColor = 尾随图标颜色,
            disabledTextColor = 禁用文本颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            selectedContainerColor = 已选择容器颜色,
            selectedTextColor = 已选择文本颜色,
            selectedLeadingIconColor = 已选择前导图标颜色,
            selectedTrailingIconColor = 已选择尾随图标颜色,
        )

    /**
     * 创建一个 [MenuItemColors]，表示鲜明颜色变体 [DropdownMenuItem] 中使用的默认文本、图标和容器颜色。
     *
     * @param 文本颜色 此 [DropdownMenuItem] 启用时的文本颜色。
     * @param 容器颜色 此 [DropdownMenuItem] 启用且未选中时的容器颜色。
     * @param 前导图标颜色 此 [DropdownMenuItem] 启用时的前置图标颜色。
     * @param 尾随图标颜色 此 [DropdownMenuItem] 启用时的尾部图标颜色。
     * @param 禁用文本颜色 此 [DropdownMenuItem] 未启用时的文本颜色。
     * @param 禁用前导图标颜色 此 [DropdownMenuItem] 未启用时的前置图标颜色。
     * @param 禁用尾随图标颜色 此 [DropdownMenuItem] 未启用时的尾部图标颜色。
     * @param 已选择容器颜色 此 [DropdownMenuItem] 启用且选中时的容器颜色。
     * @param 已选择文本颜色 此 [DropdownMenuItem] 启用且选中时的文本颜色。
     * @param 已选择前导图标颜色 此 [DropdownMenuItem] 启用且选中时的前置图标颜色。
     * @param 已选择尾随图标颜色 此 [DropdownMenuItem] 启用且选中时的尾部图标颜色。
     */
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 选择项变体颜色集(
        文本颜色: Color = Color.Unspecified,
        容器颜色: Color = Color.Unspecified,
        前导图标颜色: Color = Color.Unspecified,
        尾随图标颜色: Color = Color.Unspecified,
        禁用文本颜色: Color = Color.Unspecified,
        禁用前导图标颜色: Color = Color.Unspecified,
        禁用尾随图标颜色: Color = Color.Unspecified,
        已选择容器颜色: Color = Color.Unspecified,
        已选择文本颜色: Color = Color.Unspecified,
        已选择前导图标颜色: Color = Color.Unspecified,
        已选择尾随图标颜色: Color = Color.Unspecified,
    ): MenuItemColors =
        MenuDefaults.selectableItemVibrantColors(
            textColor = 文本颜色,
            containerColor = 容器颜色,
            leadingIconColor = 前导图标颜色,
            trailingIconColor = 尾随图标颜色,
            disabledTextColor = 禁用文本颜色,
            disabledLeadingIconColor = 禁用前导图标颜色,
            disabledTrailingIconColor = 禁用尾随图标颜色,
            selectedContainerColor = 已选择容器颜色,
            selectedTextColor = 已选择文本颜色,
            selectedLeadingIconColor = 已选择前导图标颜色,
            selectedTrailingIconColor = 已选择尾随图标颜色,
        )



    /** [DropdownMenuItem] 使用的默认内边距。 */
    val 下拉菜单项内容内边距 = MenuDefaults.DropdownMenuItemContentPadding

    /** 用于可选 [DropdownMenuItem] 的默认内边距。 */
    val 下拉菜单可选中项内容内边距 = MenuDefaults.DropdownMenuSelectableItemContentPadding

    /** [DropdownMenuGroup] 使用的默认内边距。 */
    val 下拉菜单组内容内边距 = MenuDefaults.DropdownMenuGroupContentPadding

}