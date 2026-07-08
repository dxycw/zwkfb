package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * TODO 当 Mio 页面可用时提供链接
 *
 * 切换按钮是一种可切换的按钮，根据 [已选中] 的值在主色调和表面色调之间切换。只要 [形状集] 中提供的三个形状均为 [CornerBasedShape]，
 * 它还会根据与切换按钮的交互状态在这三个形状之间变形过渡。如果 [形状集] 中的某个形状不是 [CornerBasedShape]，
 * 则切换按钮将根据用户交互在 [ToggleButtonShapes] 之间切换。
 *
 * TODO 当图片可用时提供图片链接
 *
 * 如需不需要切换的静态按钮，请参阅 [Button]。如需内容为 [Icon] 的可切换按钮，请参阅 [IconToggleButton]。
 *
 * @param 已选中 切换按钮是开启还是关闭。
 * @param 已选中改变回调 切换按钮被点击时调用。
 * @param 修饰符 要应用于切换按钮的 [Modifier]。
 * @param 已启用 控制此切换按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 形状集 切换按钮根据用户交互将在其间变形过渡的 [ToggleButtonShapes]。
 * @param 颜色集 用于解析此切换按钮在不同状态下所使用颜色的 [ToggleButtonColors]。请参阅 [ToggleButtonDefaults.toggleButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。请参阅
 * [ButtonElevation.shadowElevation]。此外，当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。
 * @param 边框 要绘制在此切换按钮容器周围的边框。
 * @param 内容内边距 要应用于容器与内容之间内部间距的间距值。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此切换按钮的 [Interaction]。
 * 你可以使用它来更改切换按钮的外观或在不同状态下预览切换按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 切换按钮上显示的内容，应为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun 切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状集: ToggleButtonShapes = ToggleButtonDefaults.shapesFor(ButtonDefaults.MinHeight),
    颜色集: ToggleButtonColors = ToggleButtonDefaults.toggleButtonColors(),
    阴影: ButtonElevation? = ButtonDefaults.buttonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    ToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shapes = 形状集,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * TODO 当 Mio 页面可用时提供链接
 *
 * 切换按钮是一种可切换的按钮，根据 [已选中] 的值在主色调和表面色调之间切换。只要 [形状集] 中提供的三个形状均为
 * [CornerBasedShape]，它还会根据与切换按钮的交互状态在这三个形状之间变形过渡。如果 [形状集] 中的某个形状不是
 * [CornerBasedShape]，则切换按钮将根据用户交互在 [ToggleButtonShapes] 之间切换。
 *
 * TODO 当图片可用时提供图片链接
 *
 * 凸起切换按钮是高强调级别的切换按钮。为防止阴影蔓延，仅在绝对必要时使用，例如当切换按钮需要与带图案的容器进行视觉区分时。
 *
 * 如需不需要切换的静态凸起按钮，请参阅 [ElevatedButton]。
 *
 * @param 已选中 切换按钮是开启还是关闭。
 * @param 已选中改变回调 切换按钮被点击时调用。
 * @param 修饰符 要应用于切换按钮的 [Modifier]。
 * @param 已启用 控制此切换按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 形状集 切换按钮根据用户交互将在其间变形过渡的 [ToggleButtonShapes]。
 * @param 颜色集 用于解析此切换按钮在不同状态下所使用颜色的 [ToggleButtonColors]。请参阅
 * [ToggleButtonDefaults.elevatedToggleButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。
 * @param 边框 要绘制在此切换按钮容器周围的边框。
 * @param 内容内边距 要应用于容器与内容之间内部间距的间距值。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此切换按钮的 [Interaction]。
 * 你可以使用它来更改切换按钮的外观或在不同状态下预览切换按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 切换按钮上显示的内容，应为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun 凸起切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状集: ToggleButtonShapes = ToggleButtonDefaults.shapesFor(ButtonDefaults.MinHeight),
    颜色集: ToggleButtonColors = ToggleButtonDefaults.elevatedToggleButtonColors(),
    阴影: ButtonElevation? = ButtonDefaults.elevatedButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    ElevatedToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shapes = 形状集,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * TODO 当 Mio 页面可用时提供链接
 *
 * 切换按钮是一种可切换的按钮，根据 [已选中] 的值在主色调和表面色调之间切换。只要 [形状集] 中提供的三个形状均为
 * [CornerBasedShape]，它还会根据与切换按钮的交互状态在这三个形状之间变形过渡。如果 [形状集] 中的某个形状不是
 * [CornerBasedShape]，则切换按钮将根据用户交互在 [ToggleButtonShapes] 之间切换。
 *
 * TODO 当图片可用时提供图片链接
 *
 * 色调切换按钮是中强调级别的按钮，是默认 [ToggleButton]（填充式）与 [OutlinedToggleButton]（轮廓式）之间的折中方案。
 * 它们可用于低优先级按钮需要比轮廓按钮稍强一些的强调效果的场景。色调切换按钮使用辅助色映射。
 *
 * 如需不需要切换的静态填充色调按钮，请参阅 [FilledTonalButton]。如需内容为 [Icon] 的可切换按钮，请参阅 [FilledTonalIconToggleButton]。
 *
 * @param 已选中 切换按钮是开启还是关闭。
 * @param 已选中改变回调 切换按钮被点击时调用。
 * @param 修饰符 要应用于切换按钮的 [Modifier]。
 * @param 已启用 控制此切换按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 形状集 切换按钮根据用户交互将在其间变形过渡的 [ToggleButtonShapes]。
 * @param 颜色集 用于解析此切换按钮在不同状态下所使用颜色的 [ToggleButtonColors]。请参阅 [ToggleButtonDefaults.tonalToggleButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，
 * 当容器颜色为 [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。
 * @param 边框 要绘制在此切换按钮容器周围的边框。
 * @param 内容内边距 要应用于容器与内容之间内部间距的间距值。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此切换按钮的 [Interaction]。
 * 你可以使用它来更改切换按钮的外观或在不同状态下预览切换按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 切换按钮上显示的内容，应为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun 色调切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状集: ToggleButtonShapes = ToggleButtonDefaults.shapesFor(ButtonDefaults.MinHeight),
    颜色集: ToggleButtonColors = ToggleButtonDefaults.tonalToggleButtonColors(),
    阴影: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    TonalToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shapes = 形状集,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * TODO 当 Mio 页面可用时提供链接
 *
 * 切换按钮是一种可切换的按钮，根据 [已选中] 的值在主色调和表面色调之间切换。只要 [形状集] 中提供的三个形状均为
 * [CornerBasedShape]，它还会根据与切换按钮的交互状态在这三个形状之间变形过渡。如果 [形状集] 中的某个形状不是
 * [CornerBasedShape]，则切换按钮将根据用户交互在 [ToggleButtonShapes] 之间切换。
 *
 * TODO 当图片可用时提供图片链接
 *
 * 轮廓切换按钮是中强调级别的按钮。它们包含重要的操作，但并非应用中的主要操作。轮廓按钮与 [ToggleButton] 搭配使用，可表示替代性的次要操作。
 *
 * 如需不需要切换的静态轮廓按钮，请参阅 [OutlinedButton]。如需内容为 [Icon] 的可切换按钮，请参阅 [OutlinedIconToggleButton]。
 *
 * @param 已选中 切换按钮是开启还是关闭。
 * @param 已选中改变回调 切换按钮被点击时调用。
 * @param 修饰符 要应用于切换按钮的 [Modifier]。
 * @param 已启用 控制此切换按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 形状集 切换按钮根据用户交互将在其间变形过渡的 [ToggleButtonShapes]。
 * @param 颜色集 用于解析此切换按钮在不同状态下所使用颜色的 [ToggleButtonColors]。请参阅 [ToggleButtonDefaults.outlinedToggleButtonColors]。
 * @param 阴影 用于解析此按钮在不同状态下阴影高度的 [ButtonElevation]。这控制按钮下方阴影的大小。此外，当容器颜色为
 * [ColorScheme.surface] 时，这控制作为主色调叠加应用的数量。
 * @param 边框 要绘制在此切换按钮容器周围的边框。
 * @param 内容内边距 要应用于容器与内容之间内部间距的间距值。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发射此切换按钮的 [Interaction]。
 * 你可以使用它来更改切换按钮的外观或在不同状态下预览切换按钮。请注意，如果提供 `null`，交互仍会在内部发生。
 * @param 内容 切换按钮上显示的内容，应为文本、图标或图片。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun 轮廓切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状集: ToggleButtonShapes = ToggleButtonDefaults.shapesFor(ButtonDefaults.MinHeight),
    颜色集: ToggleButtonColors = ToggleButtonDefaults.outlinedToggleButtonColors(),
    阴影: ButtonElevation? = null,
    边框: BorderStroke? = if (!已选中) ButtonDefaults.outlinedButtonBorder(已启用) else null,
    内容内边距: PaddingValues = ButtonDefaults.contentPaddingFor(ButtonDefaults.MinHeight),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    OutlinedToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        shapes = 形状集,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )


/** 包含所有五种切换按钮类型的默认值。 */
object 切换按钮默认值 { // ToggleButtonDefaults

    /** 应用于所有切换按钮的默认最小高度。请注意，你可以通过在切换按钮可组合函数上直接应用 Modifier.heightIn 来覆盖此值。*/
    val 最小高度 = ToggleButtonDefaults.MinHeight

    /** 图标和文本在任何切换按钮中使用时，它们之间间距的默认大小。*/
    val 图标间距 = ToggleButtonDefaults.IconSpacing

    /** 图标和文本在任何切换按钮中使用时，它们之间间距的默认大小。*/
    val 图标大小 = ToggleButtonDefaults.IconSize

    /** 所有切换按钮使用的默认内容内边距。 */
    val 内容内边距 = ToggleButtonDefaults.ContentPadding

    /** 创建一个 [ToggleButtonShapes]，表示 [ToggleButton] 中使用的默认形状、按下形状和选中形状。*/
    @Composable fun 形状集() = ToggleButtonDefaults.shapes()

    /**
     * 创建一个 [ToggleButtonShapes]，表示 [ToggleButton] 中使用的默认形状、按下形状和选中形状。
     *
     * @param 形状 [ToggleButtonShapes] 的未选中形状
     * @param 按压形状 [ToggleButtonShapes] 的未选中形状
     * @param 已选中形状 [ToggleButtonShapes] 的未选中形状
     */
    @Composable
    fun 形状集(
        形状: Shape? = null,
        按压形状: Shape? = null,
        已选中形状: Shape? = null,
    ): ToggleButtonShapes =
        ToggleButtonDefaults.shapes(
            shape = 形状,
            pressedShape = 按压形状,
            checkedShape = 已选中形状,
        )

    /** 可用于所有 [ToggleButton] 及其变体的圆形形状。 */
    val 圆角形状: Shape
        @Composable get() = ToggleButtonDefaults.roundShape

    /** 可用于所有 [ToggleButton] 及其变体的方形形状。 */
    val 方形形状: Shape
        @Composable get() = ToggleButtonDefaults.squareShape

    /** [ToggleButton] 的默认未选中形状 */
    val 形状: Shape
        @Composable get() = ToggleButtonDefaults.shape

    /** [ToggleButton] 的默认按下形状 */
    val 按压形状: Shape
        @Composable get() = ToggleButtonDefaults.pressedShape

    /** [ToggleButton] 的默认选中形状 */
    val 已选中形状: Shape
        @Composable get() = ToggleButtonDefaults.checkedShape

    /** 超小切换按钮的默认方形形状 */
    val 超小方形形状: Shape
        @Composable get() = ToggleButtonDefaults.extraSmallSquareShape

    /** 中等切换按钮的默认方形形状 */
    val 中等方形形状: Shape
        @Composable get() = ToggleButtonDefaults.mediumSquareShape

    /** 大切换按钮的默认方形形状 */
    val 大方形形状: Shape
        @Composable get() = ToggleButtonDefaults.largeSquareShape

    /** 超大切换按钮的默认方形形状 */
    val 超大方形形状: Shape
        @Composable get() = ToggleButtonDefaults.extraLargeSquareShape

    /** 超小切换按钮的默认按下形状 */
    val 超小按压形状: Shape
        @Composable get() = ToggleButtonDefaults.extraSmallPressedShape

    /** 中等切换按钮的默认按下形状 */
    val 中等按压形状: Shape
        @Composable get() = ToggleButtonDefaults.mediumPressedShape

    /** 大切换按钮的默认按下形状 */
    val 大按压形状: Shape
        @Composable get() = ToggleButtonDefaults.largePressedShape

    /** 超大切换按钮的默认按下形状 */
    val 超大按压形状: Shape
        @Composable get() = ToggleButtonDefaults.extraLargePressedShape

    /** 超小切换按钮的默认选中方形形状 */
    val 超小已选中方形形状: Shape
        @Composable get() = ToggleButtonDefaults.extraSmallCheckedSquareShape

    /** 中等切换按钮的默认选中方形形状 */
    val 中等已选中方形形状: Shape
        @Composable get() = ToggleButtonDefaults.mediumCheckedSquareShape

    /** 大切换按钮的默认选中方形形状 */
    val 大已选中方形形状: Shape
        @Composable get() = ToggleButtonDefaults.largeCheckedSquareShape

    /** 超大切换按钮的默认选中方形形状 */
    val 超大已选中方形形状: Shape
        @Composable get() = ToggleButtonDefaults.extraLargeCheckedSquareShape

    /** 创建一个 [ToggleButtonColors]，表示 [ToggleButton] 中使用的默认容器颜色和内容颜色。*/
    @Composable fun 切换按钮颜色集() = ToggleButtonDefaults.toggleButtonColors()

    /**
     * 创建一个 [ToggleButtonColors]，表示 [ToggleButton] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [ToggleButton] 在启用状态下的容器颜色。
     * @param 内容颜色 此 [ToggleButton] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 此 [ToggleButton] 在未启用状态下的容器颜色。
     * @param 禁用内容颜色 此 [ToggleButton] 在未启用状态下的内容颜色。
     * @param 已选中容器颜色 此 [ToggleButton] 在选中状态下的容器颜色。
     * @param 已选中内容颜色 此 [ToggleButton] 在选中状态下的内容颜色。
     */
    @Composable
    fun 切换按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
        已选中容器颜色: Color = Color.Unspecified,
        已选中内容颜色: Color = Color.Unspecified,
    ): ToggleButtonColors =
        ToggleButtonDefaults.toggleButtonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
            checkedContainerColor = 已选中容器颜色,
            checkedContentColor = 已选中内容颜色,
        )


    /** 创建一个 [ToggleButtonColors]，表示 [ElevatedToggleButton] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    fun 凸起切换按钮颜色集() = ToggleButtonDefaults.elevatedToggleButtonColors()

    /**
     * 创建一个 [ToggleButtonColors]，表示 [ElevatedToggleButton] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [ElevatedToggleButton] 在启用状态下的容器颜色。
     * @param 内容颜色 此 [ElevatedToggleButton] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 此 [ElevatedToggleButton] 在未启用状态下的容器颜色。
     * @param 禁用内容颜色 此 [ElevatedToggleButton] 在未启用状态下的内容颜色。
     * @param 已选中容器颜色 此 [ElevatedToggleButton] 在选中状态下的容器颜色。
     * @param 已选中内容颜色 此 [ElevatedToggleButton] 在选中状态下的内容颜色。
     */
    @Composable
    fun 凸起切换按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
        已选中容器颜色: Color = Color.Unspecified,
        已选中内容颜色: Color = Color.Unspecified,
    ): ToggleButtonColors =
        ToggleButtonDefaults.elevatedToggleButtonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
            checkedContainerColor = 已选中容器颜色,
            checkedContentColor = 已选中内容颜色,
        )


    /** 创建一个 [ToggleButtonColors]，表示 [TonalToggleButton] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    fun 色调切换按钮颜色集() = ToggleButtonDefaults.tonalToggleButtonColors()

    /**
     * 创建一个 [ToggleButtonColors]，表示 [TonalToggleButton] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [TonalToggleButton] 在启用状态下的容器颜色。
     * @param 内容颜色 此 [TonalToggleButton] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 此 [TonalToggleButton] 在未启用状态下的容器颜色。
     * @param 禁用内容颜色 此 [TonalToggleButton] 在未启用状态下的内容颜色。
     * @param 已选中容器颜色 此 [TonalToggleButton] 在选中状态下的容器颜色。
     * @param 已选中内容颜色 此 [TonalToggleButton] 在选中状态下的内容颜色。
     */
    @Composable
    fun 色调切换按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
        已选中容器颜色: Color = Color.Unspecified,
        已选中内容颜色: Color = Color.Unspecified,
    ): ToggleButtonColors =
        ToggleButtonDefaults.tonalToggleButtonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
            checkedContainerColor = 已选中容器颜色,
            checkedContentColor = 已选中内容颜色,
        )


    /** 创建一个 [ToggleButtonColors]，表示 [OutlinedToggleButton] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    fun 轮廓切换按钮颜色集() = ToggleButtonDefaults.outlinedToggleButtonColors()

    /**
     * 创建一个 [ToggleButtonColors]，表示 [OutlinedToggleButton] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [OutlinedToggleButton] 在启用状态下的容器颜色。
     * @param 内容颜色 此 [OutlinedToggleButton] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 此 [OutlinedToggleButton] 在未启用状态下的容器颜色。
     * @param 禁用内容颜色 此 [OutlinedToggleButton] 在未启用状态下的内容颜色。
     * @param 已选中容器颜色 此 [OutlinedToggleButton] 在选中状态下的容器颜色。
     * @param 已选中内容颜色 此 [OutlinedToggleButton] 在选中状态下的内容颜色。
     */
    @Composable
    fun 轮廓切换按钮颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
        已选中容器颜色: Color = Color.Unspecified,
        已选中内容颜色: Color = Color.Unspecified,
    ): ToggleButtonColors =
        ToggleButtonDefaults.outlinedToggleButtonColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
            checkedContainerColor = 已选中容器颜色,
            checkedContentColor = 已选中内容颜色,
        )


    /**
     * 针对给定切换按钮高度推荐的 [ToggleButtonShapes]。
     *
     * @param 按钮高度 按钮的高度
     */
    @Composable
    fun 用于形状集(按钮高度: Dp): ToggleButtonShapes =
        ToggleButtonDefaults.shapesFor(buttonHeight = 按钮高度)

}


/**
 * 表示切换按钮在不同状态下使用的容器颜色和内容颜色。
 *
 * @param 容器颜色 此 [ToggleButton] 在启用状态下的容器颜色。
 * @param 内容颜色 此 [ToggleButton] 在启用状态下的内容颜色。
 * @param 禁用容器颜色 此 [ToggleButton] 在未启用状态下的容器颜色。
 * @param 禁用内容颜色 此 [ToggleButton] 在未启用状态下的内容颜色。
 * @param 已选中容器颜色 此 [ToggleButton] 在选中状态下的容器颜色。
 * @param 已选中内容颜色 此 [ToggleButton] 在选中状态下的内容颜色。
 * @constructor 使用任意颜色创建一个实例。
 * - 请参阅 [ToggleButtonDefaults.toggleButtonColors] 了解 [ToggleButton] 使用的默认颜色。
 * - 请参阅 [ToggleButtonDefaults.elevatedToggleButtonColors] 了解 [ElevatedToggleButton] 使用的默认颜色。
 * - 请参阅 [ToggleButtonDefaults.tonalToggleButtonColors] 了解 [TonalToggleButton] 使用的默认颜色。
 * - 请参阅 [ToggleButtonDefaults.outlinedToggleButtonColors] 了解 [OutlinedToggleButton] 使用的默认颜色。
 */
fun 切换按钮颜色集(
    容器颜色: Color,
    内容颜色: Color,
    禁用容器颜色: Color,
    禁用内容颜色: Color,
    已选中容器颜色: Color,
    已选中内容颜色: Color,
) =
    ToggleButtonColors(
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        disabledContainerColor = 禁用容器颜色,
        disabledContentColor = 禁用内容颜色,
        checkedContainerColor = 已选中容器颜色,
        checkedContentColor = 已选中内容颜色,
    )


/** 返回此 ToggleButtonColors 的副本，可选择性地覆盖部分值。这里使用 Color.Unspecified 表示"使用源值"。*/
fun ToggleButtonColors.复制(
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

//================================================================

val ToggleButtonColors.容器颜色: Color
    get() = this.containerColor

val ToggleButtonColors.内容颜色: Color
    get() = this.contentColor

val ToggleButtonColors.禁用容器颜色: Color
    get() = this.disabledContainerColor

val ToggleButtonColors.禁用内容颜色: Color
    get() = this.disabledContentColor

val ToggleButtonColors.已选中容器颜色: Color
    get() = this.checkedContainerColor

val ToggleButtonColors.已选中内容颜色: Color
    get() = this.checkedContentColor

//================================================================

/**
 * 切换按钮将使用的形状。假设所有形状均为 [CornerBasedShape]，切换按钮将根据交互状态在这三个形状之间变形过渡。
 *
 * @param 形状 未选中形状。
 * @param 按压形状 按下形状。
 * @param 已选中形状 选中形状。
 */
fun 切换按钮形状集(
    形状: Shape,
    按压形状: Shape,
    已选中形状: Shape,
) =
    ToggleButtonShapes(
        shape = 形状,
        pressedShape = 按压形状,
        checkedShape = 已选中形状,
    )

/** 返回此 ToggleButtonShapes 的副本，可选择性地覆盖部分值。 */
fun ToggleButtonShapes.复制(
    形状: Shape? = this.shape,
    按压形状: Shape? = this.pressedShape,
    已选中形状: Shape? = this.checkedShape,
) =
    this.copy(
        shape = 形状,
        pressedShape = 按压形状,
        checkedShape = 已选中形状,
    )

//================================================================

val ToggleButtonShapes.形状: Shape
    get() = this.shape

val ToggleButtonShapes.按压形状: Shape
    get() = this.pressedShape

val ToggleButtonShapes.已选中形状
    get() = this.checkedShape

//================================================================

