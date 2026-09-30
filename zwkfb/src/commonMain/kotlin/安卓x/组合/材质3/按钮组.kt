package 安卓x.组合.材质3

import androidx.annotation.FloatRange
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ButtonGroupMenuState
import androidx.compose.material3.ButtonGroupScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.ToggleButtonShapes
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp


// TODO 待 MIO 页面可用后添加链接。
// TODO 待图片资源可用后添加链接。
/**
 * 一种布局可组合函数，将其子元素按水平顺序排列。当子元素使用带有相关 [MutableInteractionSource] 的 [ButtonGroupScope.animateWidth]
 * 时，此按钮组可以监听交互事件，并展开被按下子元素的宽度，同时压缩相邻的子元素。此外，如果项目过多或项目过宽无法全部容纳在屏幕上，
 * 这些项目将溢出到一个下拉菜单中。
 *
 * @param 溢出指示器 当按钮组需要溢出时，显示在按钮组末尾的可组合函数。它接收一个 [ButtonGroupMenuState]。
 * @param 修饰符 要应用于按钮组的 [Modifier]。
 * @param 展开比例 一个浮点数，表示用于展开被交互子元素以及压缩相邻子元素的宽度百分比。默认情况下，标准按钮组会将受交互的子元素按其宽度的
 * [ButtonGroupDefaults.ExpandedRatio] 进行扩展，并将此效果传播到其相邻元素。如果传入 0f，则被交互的子元素完全不会扩展，相邻元素也不会压缩。
 * 如果传入 1f，则被交互的子元素在被按下时将扩展到其默认宽度的 200%。
 * @param 水平排列 按钮组子元素的水平排列方式。
 * @param 垂直对齐 按钮组子元素的垂直对齐方式。
 * @param 内容 按钮组中显示的内容，预期使用带有 [ButtonGroupScope.animateWidth] 标记的可组合函数。
 */
@Suppress("ComposableNaming")
@Composable
fun 按钮组(
    溢出指示器: @Composable (ButtonGroupMenuState) -> Unit,
    修饰符: Modifier = Modifier,
    @FloatRange(0.0) 展开比例: Float = ButtonGroupDefaults.ExpandedRatio,
    水平排列: Arrangement.Horizontal = ButtonGroupDefaults.HorizontalArrangement,
    垂直对齐: Alignment.Vertical = Alignment.Top,
    内容: ButtonGroupScope.() -> Unit,
) =
    ButtonGroup(
        overflowIndicator = 溢出指示器,
        modifier = 修饰符,
        expandedRatio = 展开比例,
        horizontalArrangement = 水平排列,
        verticalAlignment = 垂直对齐,
        content = 内容
    )


/** [按钮组] 使用的默认值 */
object 按钮组默认值 { // ButtonGroupDefaults

    /**
     * 默认的百分比值（以浮点数表示），用于展开被交互的子元素以及压缩相邻的子元素。默认情况下，标准按钮组会将受交互的子元素按其宽度的 15% 进行扩展，
     * 并将此效果传播到其相邻元素。
     */
    val 展开比例 = ButtonGroupDefaults.ExpandedRatio

    /** 标准按钮组中子元素之间使用的默认排列方式。 */
    val 水平排列: Arrangement.Horizontal =
        ButtonGroupDefaults.HorizontalArrangement

    /** 连接按钮组中子元素之间使用的默认间距。 */
    val 连接间距分布: Dp = ButtonGroupDefaults.ConnectedSpaceBetween

    /** 连接按钮组中前导按钮的默认形状。 */
    val 连接前导按钮形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedLeadingButtonShape

    /** 连接按钮组中前导按钮按下状态的默认形状。 */
    val 连接前导按钮按压形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedLeadingButtonPressShape

    /** 连接按钮组中末尾按钮的默认形状。 */
    val 连接尾随按钮形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedTrailingButtonShape

    /** 连接按钮组中末尾按钮按下状态的默认形状。 */
    val 连接尾随按钮按压形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedTrailingButtonPressShape

    /** 连接按钮组中按钮选中状态的默认形状。*/
    val 连接按钮选中形状 = ButtonGroupDefaults.connectedButtonCheckedShape

    /** 连接按钮组中中间按钮按压状态的默认形状。 */
    val 连接中间按钮按压形状: Shape
        @Composable
        get() = ButtonGroupDefaults.connectedMiddleButtonPressShape

    /** [ConnectedButtonGroup] 中起始按钮的默认形状组合。*/
    @Composable
    fun 连接前导按钮形状集(
        形状: Shape = ButtonGroupDefaults.connectedLeadingButtonShape,
        按压形状: Shape = ButtonGroupDefaults.connectedLeadingButtonPressShape,
        已选中形状: Shape = ButtonGroupDefaults.connectedButtonCheckedShape,
    ): ToggleButtonShapes =
        ButtonGroupDefaults.connectedLeadingButtonShapes(
            shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状
        )

    /** [ConnectedButtonGroup] 中中间按钮的默认形状组合。中间按钮是指按钮组中既不是起始按钮也不是末尾按钮的按钮。*/
    @Composable
    fun 连接中间按钮形状集(
        形状: Shape = ShapeDefaults.Small,
        按压形状: Shape = ButtonGroupDefaults.connectedMiddleButtonPressShape,
        已选中形状: Shape = ButtonGroupDefaults.connectedButtonCheckedShape,
    ): ToggleButtonShapes =
        ButtonGroupDefaults.connectedMiddleButtonShapes(
            shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状
        )

    /** [ConnectedButtonGroup] 中末尾按钮的默认形状组合。 */
    @Composable
    fun 连接尾随按钮形状集(
        形状: Shape = ButtonGroupDefaults.connectedTrailingButtonShape,
        按压形状: Shape = ButtonGroupDefaults.connectedTrailingButtonPressShape,
        已选中形状: Shape = ButtonGroupDefaults.connectedButtonCheckedShape,
    ): ToggleButtonShapes =
        ButtonGroupDefaults.connectedTrailingButtonShapes(
            shape = 形状, pressedShape = 按压形状, checkedShape = 已选中形状
        )

    /**
     * [按钮组] 的默认溢出指示器。它使用一个 [填充图标按钮]。点击时，它将打开与提供的 [ButtonGroupMenuState] 关联的菜单。
     *
     * @param 菜单状态 用于显示或关闭溢出菜单的 [ButtonGroupMenuState]。
     * @param 修饰符 要应用于溢出指示器的 [Modifier]。
     * @param 已启用 控制此图标按钮的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，同时对无障碍服务也表现为禁用。
     * @param 形状 定义此图标按钮容器的形状。
     * @param 颜色集 [IconButtonColors]，用于解析此图标按钮在不同状态下使用的颜色。参见 [IconButtonDefaults.filledIconButtonColors]。
     * @param 交互源 一个可选的提升[MutableInteractionSource]，用于观察和发射此图标按钮的
     * [androidx.compose.foundation.interaction.Interaction] 交互事件。你可以使用它来更改图标按钮的外观或在不同状态下预览图标按钮。
     * 请注意，如果提供 null，交互事件仍将在内部发生。
     */
    @Suppress("ComposableNaming")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun 溢出指示器(
        菜单状态: ButtonGroupMenuState,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        形状: Shape = IconButtonDefaults.filledShape,
        颜色集: IconButtonColors = IconButtonDefaults.filledIconButtonColors(),
        交互源: MutableInteractionSource? = null,
    ) =
        ButtonGroupDefaults.OverflowIndicator(
            menuState = 菜单状态,
            modifier = 修饰符,
            enabled = 已启用,
            shape = 形状,
            colors = 颜色集,
            interactionSource = 交互源,
        )

}

//=============================================================

/** [按钮组] 中溢出菜单的状态类。 */
fun 按钮组菜单状态(
    初始显示: Boolean = false
) = ButtonGroupMenuState(initialIsShowing = 初始显示)

//=============================================================

/** 指示溢出菜单当前是否正在显示。 */
val ButtonGroupMenuState.是否正在显示
    get() = this.isShowing

/** 关闭溢出菜单。 */
fun ButtonGroupMenuState.关闭() = this.dismiss()


/** 显示溢出菜单。 */
fun ButtonGroupMenuState.显示() = this.show()

//=============================================================


/** 按钮组作用域，用于指示子元素的 [Modifier.权重] 和 [Modifier.动画宽度]。同时还定义了用于构建 [按钮组] 内容的 DSL。*/
interface 按钮组范围 {  // ButtonGroupScope

    /**
     * 根据元素的 [权重] 相对于 [按钮组] 中其他有权重的同级元素的比例来调整元素的宽度。父容器会在测量完未加权的子元素后，
     * 将剩余的水平空间按照权重进行分配。
     *
     * @param 权重 此元素的权重值，用于计算其相对于所有有权重同级元素总权重的比例宽度。必须为正数。
     */
    fun Modifier.权重(@FloatRange(from = 0.0, fromInclusive = false) 权重: Float): Modifier

    /**
     * 指定用于此项目的交互源。这用于监听事件，并在按下按钮时使其放大，同时缩小相邻的按钮。
     *
     * @param 交互源 供按钮组监听和观察的 [InteractionSource]。
     * @param 压缩限制 按钮压缩的限制，用于防止按钮压缩到小于其最小宽度的宽度。
     */
    fun Modifier.动画宽度(
        交互源: InteractionSource,
        压缩限制: PaddingValues = ButtonDefaults.ContentPadding,
    ): Modifier

    /**
     * 在 [按钮组] 中对元素进行垂直对齐。此对齐方式的优先级高于 [按钮组] 的 verticalAlignment 参数。
     *
     * @param 对齐 元素的垂直对齐方式
     */
    @Stable fun Modifier.对齐(对齐: Alignment.Vertical): Modifier


    /**
     * 向 [按钮组] 添加一个可点击的项目。
     *
     * @param 单击回调 当项目被点击时要执行的操作。
     * @param 标签 该项目的文本标签。
     * @param 图标 一个可选的可组合项，用于表示该项目的图标。
     * @param 权重 应用于该项目的权重，请参阅 [ButtonGroupScope.weight]。
     * @param 已启用 该项目是否处于启用状态。
     */
    fun 可单击项( // clickableItem
        单击回调: () -> Unit,
        标签: String,
        图标: (@Composable () -> Unit)? = null,
        权重: Float = Float.NaN,
        已启用: Boolean = true,
    )

    /**
     * 向 [按钮组] 添加一个可切换状态的项目。
     *
     * @param 已选中 该项目当前是否处于选中状态。
     * @param 已选中改变回调 当项目的选中状态改变时要执行的操作。
     * @param 图标 一个可选的可组合项，用于表示该项目的图标。
     * @param 已启用 该项目是否处于启用状态。
     * @param 权重 应用于该项目的权重，请参阅 [ButtonGroupScope.weight]。
     * @param 标签 该项目的文本标签。
     */
    fun 可切换项( // toggleableItem
        已选中: Boolean,
        标签: String,
        已选中改变回调: (Boolean) -> Unit,
        图标: (@Composable () -> Unit)? = null,
        权重: Float = Float.NaN,
        已启用: Boolean = true,
    )

    /**
     * 向 [按钮组] 添加一个自定义项目。
     *
     * @param 按钮组内容 在应用栏中显示的可组合项。
     * @param 菜单内容 在溢出菜单中显示的可组合项。它接收一个 [按钮组菜单状态] 实例。
     */
    fun 自定义项(
        按钮组内容: @Composable () -> Unit,
        菜单内容: @Composable (ButtonGroupMenuState) -> Unit,
    )

}

/**
 * 向 [按钮组] 添加一个可点击的项目。
 *
 * @param 单击回调 当项目被点击时要执行的操作。
 * @param 标签 该项目的文本标签。
 * @param 图标 一个可选的可组合项，用于表示该项目的图标。
 * @param 权重 应用于该项目的权重，请参阅 [ButtonGroupScope.weight]。
 * @param 已启用 该项目是否处于启用状态。
 */
fun ButtonGroupScope.可单击项( // clickableItem
    单击回调: () -> Unit,
    标签: String,
    图标: (@Composable () -> Unit)? = null,
    权重: Float = Float.NaN,
    已启用: Boolean = true,
) =
    this.clickableItem(
        onClick = 单击回调,
        label = 标签,
        icon = 图标,
        weight = 权重,
        enabled = 已启用
    )

/**
 * 向 [按钮组] 添加一个可切换状态的项目。
 *
 * @param 已选中 该项目当前是否处于选中状态。
 * @param 已选中改变回调 当项目的选中状态改变时要执行的操作。
 * @param 图标 一个可选的可组合项，用于表示该项目的图标。
 * @param 已启用 该项目是否处于启用状态。
 * @param 权重 应用于该项目的权重，请参阅 [ButtonGroupScope.weight]。
 * @param 标签 该项目的文本标签。
 */
fun ButtonGroupScope.可切换项( // toggleableItem
    已选中: Boolean,
    标签: String,
    已选中改变回调: (Boolean) -> Unit,
    图标: (@Composable () -> Unit)? = null,
    权重: Float = Float.NaN,
    已启用: Boolean = true,
) =
    this.toggleableItem(
        checked = 已选中,
        label = 标签,
        onCheckedChange = 已选中改变回调,
        icon = 图标,
        weight = 权重,
        enabled = 已启用
    )

/**
 * 向 [按钮组] 添加一个自定义项目。
 *
 * @param 按钮组内容 在应用栏中显示的可组合项。
 * @param 菜单内容 在溢出菜单中显示的可组合项。它接收一个 [按钮组菜单状态] 实例。
 */
fun ButtonGroupScope.自定义项(
    按钮组内容: @Composable () -> Unit,
    菜单内容: @Composable (ButtonGroupMenuState) -> Unit,
) =
    this.customItem(
        buttonGroupContent = 按钮组内容,
        menuContent = 菜单内容,
    )
