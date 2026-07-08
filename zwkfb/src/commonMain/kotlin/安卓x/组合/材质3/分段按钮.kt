package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp


/**
 * [Material Design segmented Button](https://m3.material.io/components/segmented-buttons/overview)
 *
 * 分段按钮帮助用户选择选项、切换视图或对元素进行排序。
 *
 * 一个默认的可切换分段按钮。也称为轮廓分段按钮。参见 [androidx.compose.foundation.selection.toggleable]。
 *
 * 可切换分段按钮应适用于选择不是互斥的情况。
 *
 * 这通常应在 [多选分段按钮行] 内部使用。
 *
 * @param 已选中 此按钮是否被选中。
 * @param 已选中改变回调 当按钮被点击时调用的回调。因此，选中状态的更改被请求。
 * @param 形状 此按钮的形状。
 * @param 修饰符 要应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也呈现为禁用状态。
 * @param 颜色集 将用于解析此按钮所用颜色的 [SegmentedButtonColors]。
 * @param 边框 此按钮的边框，参见不同状态下的 [SegmentedButtonColors] 按钮。
 * @param 内容内边距 要应用于容器与内容之间的内部间距值。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发送此按钮的 [Interaction]。
 * 您可以使用它来更改按钮的外观或预览按钮在不同状态下的表现。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 图标 此按钮的图标插槽。在未选中状态下，您可以传入 `null`，此时内容会位移以显示选中图标；
 * 或者为未选中和选中状态传入不同的图标 lambda，此时图标之间会进行交叉淡入淡出。
 * @param 标签 要在该按钮内部渲染的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun MultiChoiceSegmentedButtonRowScope.分段按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    形状: Shape,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: SegmentedButtonColors = SegmentedButtonDefaults.colors(),
    边框: BorderStroke =
        SegmentedButtonDefaults.borderStroke(颜色集.borderColor(已启用, 已选中)),
    内容内边距: PaddingValues = SegmentedButtonDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    图标: @Composable () -> Unit = { SegmentedButtonDefaults.Icon(已选中) },
    标签: @Composable () -> Unit,
) =
    this.SegmentedButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        shape = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        icon = 图标,
        label = 标签
    )


/**
 * [Material Design segmented button](https://m3.material.io/components/segmented-buttons/overview)
 *
 * 分段按钮帮助用户选择选项、切换视图或对元素进行排序。
 *
 * 一个默认的可选择分段按钮。也称为轮廓分段按钮。参见 [androidx.compose.foundation.selection.selectable]。
 *
 * 可选择分段按钮应适用于选择是互斥的情况，即一次只能选中一个按钮。
 *
 * 这通常应在 [单选分段按钮行] 内部使用。
 *
 * @param 已选择 此按钮是否被选中。
 * @param 单击回调 当按钮被点击时调用的回调。因此，选中状态的更改被请求。
 * @param 形状 此按钮的形状。
 * @param 修饰符 要应用于此按钮的 [Modifier]。
 * @param 已启用 控制此按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也呈现为禁用状态。
 * @param 颜色集 将用于解析此按钮所用颜色的 [SegmentedButtonColors]。
 * @param 边框 此按钮的边框，参见不同状态下的 [SegmentedButtonColors] 按钮。
 * @param 内容内边距 要应用于容器与内容之间的内部间距值。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发送此按钮的 [Interaction]。
 * 您可以使用它来更改按钮的外观或预览按钮在不同状态下的表现。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 图标 此按钮的图标插槽。在未选中状态下，您可以传入 `null`，此时内容会位移以显示选中图标；
 * 或者为未选中和选中状态传入不同的图标 lambda，此时图标之间会进行交叉淡入淡出。
 * @param 标签 要在该按钮内部渲染的内容。
 */
@Suppress("ComposableNaming")
@Composable
fun SingleChoiceSegmentedButtonRowScope.分段按钮(
    已选择: Boolean,
    单击回调: () -> Unit,
    形状: Shape,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: SegmentedButtonColors = SegmentedButtonDefaults.colors(),
    边框: BorderStroke =
        SegmentedButtonDefaults.borderStroke(颜色集.borderColor(已启用, 已选择)),
    内容内边距: PaddingValues = SegmentedButtonDefaults.ContentPadding,
    交互源: MutableInteractionSource? = null,
    图标: @Composable () -> Unit = { SegmentedButtonDefaults.Icon(已选择) },
    标签: @Composable () -> Unit,
) =
    this.SegmentedButton(
        selected = 已选择,
        onClick = 单击回调,
        shape = 形状,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        icon = 图标,
        label = 标签
    )


/**
 * [Material Design segmented button](https://m3.material.io/components/segmented-buttons/overview)
 *
 * 一个用于在 Row 中正确放置和调整 [分段按钮] 大小的布局。它处理项目之间的重叠，使项目的描边正确地叠放在彼此之上。
 * 当选择仅允许一个值时，使用 [单选分段按钮行] 以获得正确的语义。
 *
 * @param 修饰符 要应用于此行的 [Modifier]。
 * @param 间隔 按钮之间重叠的尺寸。应等于项目所使用的描边宽度。
 * @param 内容 此分段按钮行的内容，通常是一组 [分段按钮]。
 */
@Suppress("ComposableNaming")
@Composable
fun 单选分段按钮行(
    修饰符: Modifier = Modifier,
    间隔: Dp = SegmentedButtonDefaults.BorderWidth,
    内容: @Composable SingleChoiceSegmentedButtonRowScope.() -> Unit,
) =
    SingleChoiceSegmentedButtonRow(
        modifier = 修饰符,
        space = 间隔,
        content = 内容,
    )


/**
 * [Material Design segmented button](https://m3.material.io/components/segmented-buttons/overview)
 *
 * 一个用于在 Row 中正确放置、调整大小并为 [分段按钮] 添加语义的布局。它处理项目之间的重叠，使项目的描边正确地叠放在彼此之上。
 *
 * [多选分段按钮行] 用于选择允许多个值的情况，以获得正确的语义。
 *
 * @param 修饰符 要应用于此行的 [Modifier]。
 * @param 间隔 按钮之间重叠的尺寸。应等于项目所使用的描边宽度。
 * @param 内容 此分段按钮行的内容，通常是一组 [分段按钮]。
 */
@Suppress("ComposableNaming")
@Composable
fun 多选分段按钮行(
    修饰符: Modifier = Modifier,
    间隔: Dp = SegmentedButtonDefaults.BorderWidth,
    内容: @Composable MultiChoiceSegmentedButtonRowScope.() -> Unit,
) =
    MultiChoiceSegmentedButtonRow(
        modifier = 修饰符,
        space = 间隔,
        content = 内容,
    )



/** [SingleChoiceSegmentedButtonRow] 子组件的作用域。 */
interface 单选分段按钮行范围 : RowScope // SingleChoiceSegmentedButtonRowScope


/** [MultiChoiceSegmentedButtonRow] 子组件的作用域。 */
interface 多选分段按钮行范围 : RowScope // MultiChoiceSegmentedButtonRowScope


/* 包含供 [分段按钮行] 和 [分段按钮] 使用的默认值。*/
@Stable
object 分段按钮默认值 { // SegmentedButtonDefaults

    /** 创建一个 [SegmentedButtonColors]，用于表示 [分段按钮] 在不同状态下的各种颜色。*/
    @Composable fun 颜色集() = SegmentedButtonDefaults.colors()

    /**
     * 创建一个 [SegmentedButtonColors]，用于表示 [分段按钮] 在不同状态下的各种颜色。
     *
     * @param 激活容器颜色 容器在启用且激活状态下的颜色
     * @param 激活内容颜色 内容在启用且激活状态下的颜色
     * @param 激活边框颜色 边框在启用且激活状态下的颜色
     * @param 未激活容器颜色 容器在启用但未激活状态下的颜色
     * @param 未激活内容颜色 内容在启用但未激活状态下的颜色
     * @param 未激活边框颜色 边框在启用且激活状态下的颜色
     * @param 禁用激活容器颜色 容器在禁用但激活状态下的颜色
     * @param 禁用激活内容颜色 内容在禁用但激活状态下的颜色
     * @param 禁用激活边框颜色 边框在禁用但激活状态下的颜色
     * @param 禁用未激活容器颜色 容器在禁用且未激活状态下的颜色
     * @param 禁用未激活内容颜色 内容在禁用且未选中状态下的颜色
     * @param 禁用未激活边框颜色 边框在禁用且未激活状态下的颜色
     */
    @Composable
    fun 颜色集(
        激活容器颜色: Color = Color.Unspecified,
        激活内容颜色: Color = Color.Unspecified,
        激活边框颜色: Color = Color.Unspecified,
        未激活容器颜色: Color = Color.Unspecified,
        未激活内容颜色: Color = Color.Unspecified,
        未激活边框颜色: Color = Color.Unspecified,
        禁用激活容器颜色: Color = Color.Unspecified,
        禁用激活内容颜色: Color = Color.Unspecified,
        禁用激活边框颜色: Color = Color.Unspecified,
        禁用未激活容器颜色: Color = Color.Unspecified,
        禁用未激活内容颜色: Color = Color.Unspecified,
        禁用未激活边框颜色: Color = Color.Unspecified,
    ): SegmentedButtonColors =
        SegmentedButtonDefaults.colors(
            activeContainerColor = 激活容器颜色,
            activeContentColor = 激活内容颜色,
            activeBorderColor = 激活边框颜色,
            inactiveContainerColor = 未激活容器颜色,
            inactiveContentColor = 未激活内容颜色,
            inactiveBorderColor = 未激活边框颜色,
            disabledActiveContainerColor = 禁用激活容器颜色,
            disabledActiveContentColor = 禁用激活内容颜色,
            disabledActiveBorderColor = 禁用激活边框颜色,
            disabledInactiveContainerColor = 禁用未激活容器颜色,
            disabledInactiveContentColor = 禁用未激活内容颜色,
            disabledInactiveBorderColor = 禁用未激活边框颜色,
        )



    /** 分段按钮容器的形状。为了获得正确的行为，应将此形状或所需的 [CornerBasedShape] 与 [项形状] 一起使用，并传递给每个分段按钮。*/
    val 基础形状: CornerBasedShape
        @Composable
        @ReadOnlyComposable
        get() = SegmentedButtonDefaults.baseShape

    /** 分段按钮中使用的默认边框宽度 */
    val 边框宽度: Dp = SegmentedButtonDefaults.BorderWidth


    /**
     * 当容器中有 [数量] 个按钮时，位于 [索引] 位置的按钮应具有的形状构造器。
     *
     * @param 索引 此行中该按钮的索引
     * @param 数量 此行中按钮的总数
     * @param 基础形状 用于不在开头或结尾位置的按钮的基础 [CornerBasedShape] 形状。
     */
    @Composable
    @ReadOnlyComposable
    fun 项形状(索引: Int, 数量: Int, 基础形状: CornerBasedShape = this.基础形状): Shape =
        SegmentedButtonDefaults.itemShape(index = 索引, count = 数量, baseShape = 基础形状)

    /** [SegmentedButton] 中使用的图标的图标尺寸。 */
    val 图标大小 = SegmentedButtonDefaults.IconSize

    /** 分段按钮使用的默认内容内边距 */
    val 内容内边距 = SegmentedButtonDefaults.ContentPadding

    /** 用于指示分段按钮已选中或已选定的图标 */
    @Suppress("ComposableNaming")
    @Composable
    fun 激活图标() = SegmentedButtonDefaults.ActiveIcon()

    /**
     * 分段按钮图标的默认实现。
     *
     * @param 激活 按钮是否处于激活状态。
     * @param 激活内容 通常为 [图标大小] 尺寸的勾选标记图标。
     * @param 未激活内容 通常为 [图标大小] 尺寸的图标。仅在按钮未选中时显示。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 图标(
        激活: Boolean,
        激活内容: @Composable () -> Unit = { SegmentedButtonDefaults.ActiveIcon() },
        未激活内容: (@Composable () -> Unit)? = null,
    ) =
        SegmentedButtonDefaults.Icon(
            active = 激活,
            activeContent = 激活内容,
            inactiveContent = 未激活内容,
        )

    /**
     * 分段按钮 [BorderStroke] 的默认工厂，可通过 [宽度] 和 [颜色] 进行自定义。使用非默认宽度时，请确保同时更新
     * [MultiChoiceSegmentedButtonRow] 或 [SingleChoiceSegmentedButtonRow] 的 space 参数。
     */
    fun 边框描边(颜色: Color, 宽度: Dp =  SegmentedButtonDefaults.BorderWidth): BorderStroke =
        SegmentedButtonDefaults.borderStroke(color = 颜色, width = 宽度)

}


/**
 * [分段按钮] 各部分在不同状态下使用的不同颜色
 *
 * @param 激活容器颜色 容器在启用且激活状态下的颜色
 * @param 激活内容颜色 内容在启用且激活状态下的颜色
 * @param 激活边框颜色 边框在启用且激活状态下的颜色
 * @param 未激活容器颜色 容器在启用但未激活状态下的颜色
 * @param 未激活内容颜色 内容在启用但未激活状态下的颜色
 * @param 未激活边框颜色 边框在启用且未激活状态下的颜色
 * @param 禁用激活容器颜色 容器在禁用但激活状态下的颜色
 * @param 禁用激活内容颜色 内容在禁用但激活状态下的颜色
 * @param 禁用激活边框颜色 边框在禁用但激活状态下的颜色
 * @param 禁用未激活容器颜色 容器在禁用且未激活状态下的颜色
 * @param 禁用未激活内容颜色 内容在禁用且未激活状态下的颜色
 * @param 禁用未激活边框颜色 边框在禁用且未激活状态下的颜色
 * @constructor 使用任意颜色创建实例，使用默认 Material3 规范的工厂方法请参见 [SegmentedButtonDefaults]。
 */
fun 分段按钮颜色集( // SegmentedButtonColors
    // 启用 & 激活
    激活容器颜色: Color,
    激活内容颜色: Color,
    激活边框颜色: Color,
    // 启用 & 未激活
    未激活容器颜色: Color,
    未激活内容颜色: Color,
    未激活边框颜色: Color,
    // 禁用 & 激活
    禁用激活容器颜色: Color,
    禁用激活内容颜色: Color,
    禁用激活边框颜色: Color,
    // 禁用 & 未激活
    禁用未激活容器颜色: Color,
    禁用未激活内容颜色: Color,
    禁用未激活边框颜色: Color,
) =
    SegmentedButtonColors(
        activeContainerColor = 激活容器颜色,
        activeContentColor = 激活内容颜色,
        activeBorderColor = 激活边框颜色,
        inactiveContainerColor = 未激活容器颜色,
        inactiveContentColor = 未激活内容颜色,
        inactiveBorderColor = 未激活边框颜色,
        disabledActiveContainerColor = 禁用激活容器颜色,
        disabledActiveContentColor = 禁用激活内容颜色,
        disabledActiveBorderColor = 禁用激活边框颜色,
        disabledInactiveContainerColor = 禁用未激活容器颜色,
        disabledInactiveContentColor = 禁用未激活内容颜色,
        disabledInactiveBorderColor = 禁用未激活边框颜色,
    )


/** 返回此 ChipColors 的副本，可选择性地覆盖部分值。使用 Color.Unspecified 表示"沿用源值"。*/
fun SegmentedButtonColors.复制(
    // 启用 & 激活
    激活容器颜色: Color = this.activeContainerColor,
    激活内容颜色: Color = this.activeContentColor,
    激活边框颜色: Color = this.activeBorderColor,
    // 启用 & 未激活
    未激活容器颜色: Color = this.inactiveContainerColor,
    未激活内容颜色: Color = this.inactiveContentColor,
    未激活边框颜色: Color = this.inactiveBorderColor,
    // 禁用 & 激活
    禁用激活容器颜色: Color = this.disabledActiveContainerColor,
    禁用激活内容颜色: Color = this.disabledActiveContentColor,
    禁用激活边框颜色: Color = this.disabledActiveBorderColor,
    // 禁用 & 未激活
    禁用未激活容器颜色: Color = this.disabledInactiveContainerColor,
    禁用未激活内容颜色: Color = this.disabledInactiveContentColor,
    禁用未激活边框颜色: Color = this.disabledInactiveBorderColor,
) =
    this.copy(
        activeContainerColor = 激活容器颜色,
        activeContentColor = 激活内容颜色,
        activeBorderColor = 激活边框颜色,
        inactiveContainerColor = 未激活容器颜色,
        inactiveContentColor = 未激活内容颜色,
        inactiveBorderColor = 未激活边框颜色,
        disabledActiveContainerColor = 禁用激活容器颜色,
        disabledActiveContentColor = 禁用激活内容颜色,
        disabledActiveBorderColor = 禁用激活边框颜色,
        disabledInactiveContainerColor = 禁用未激活容器颜色,
        disabledInactiveContentColor = 禁用未激活内容颜色,
        disabledInactiveBorderColor = 禁用未激活边框颜色,
    )


//=========================================================================================

// enabled & active
val SegmentedButtonColors.激活容器颜色: Color
    get() = this.activeContainerColor
val SegmentedButtonColors.激活内容颜色: Color
    get() = this.activeContentColor
val SegmentedButtonColors.激活边框颜色: Color
    get() = this.activeBorderColor
// enabled & inactive
val SegmentedButtonColors.未激活容器颜色: Color
    get() = this.inactiveContainerColor
val SegmentedButtonColors.未激活内容颜色: Color
    get() = this.inactiveContentColor
val SegmentedButtonColors.未激活边框颜色: Color
    get() = this.inactiveBorderColor
// disable & active
val SegmentedButtonColors.禁用激活容器颜色: Color
    get() = this.disabledActiveContainerColor
val SegmentedButtonColors.禁用激活内容颜色: Color
    get() = this.disabledActiveContentColor
val SegmentedButtonColors.禁用激活边框颜色: Color
    get() = this.disabledActiveBorderColor
// disable & inactive
val SegmentedButtonColors.禁用未激活容器颜色: Color
    get() = this.disabledInactiveContainerColor
val SegmentedButtonColors.禁用未激活内容颜色: Color
    get() = this.disabledInactiveContentColor
val SegmentedButtonColors.禁用未激活边框颜色: Color
    get() = this.disabledInactiveBorderColor

//=========================================================================================

/**
 * 表示分段按钮边框的颜色，根据 [enabled] 和 [active] 状态而定。
 *
 * @param enabled [分段按钮] 是否启用
 * @param active [分段按钮] 项是否已选中
 */
@Stable
internal fun SegmentedButtonColors.borderColor(enabled: Boolean, active: Boolean): Color {
    return when {
        enabled && active -> activeBorderColor
        enabled && !active -> inactiveBorderColor
        !enabled && active -> disabledActiveBorderColor
        else -> disabledInactiveBorderColor
    }
}

/**
 * 表示传递给各项目的内容颜色
 *
 * @param enabled [分段按钮] 是否启用
 * @param checked [分段按钮] 项是否已选中
 */
@Stable
internal fun SegmentedButtonColors.contentColor(enabled: Boolean, checked: Boolean): Color {
    return when {
        enabled && checked -> activeContentColor
        enabled && !checked -> inactiveContentColor
        !enabled && checked -> disabledActiveContentColor
        else -> disabledInactiveContentColor
    }
}

/**
 * 表示传递给各项目的容器颜色
 *
 * @param enabled [分段按钮] 是否启用
 * @param active [分段按钮] 项是否处于激活状态
 */
@Stable
internal fun SegmentedButtonColors.containerColor(enabled: Boolean, active: Boolean): Color {
    return when {
        enabled && active -> activeContainerColor
        enabled && !active -> inactiveContainerColor
        !enabled && active -> disabledActiveContainerColor
        else -> disabledInactiveContainerColor
    }
}