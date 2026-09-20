package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.*
import 安卓x.组合.材质3.令牌集.FilledTonalButtonTokens
import 安卓x.组合.材质3.令牌集.ElevatedButtonTokens
import 安卓x.组合.材质3.令牌集.FilledButtonTokens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design toggle
 * button](https://m3.material.io/components/buttons/overview#f8ba981c-a363-4ccd-a332-ee1b0e124e5c)
 *
 * 切换按钮是一种可切换的按钮，根据 [已选中] 的值在主色调和表面色调之间切换。只要 [形状集] 中提供的三个形状均为 [CornerBasedShape]，
 * 它还会根据与切换按钮的交互状态在这三个形状之间变形过渡。如果 [形状集] 中的某个形状不是 [CornerBasedShape]，
 * 则切换按钮将根据用户交互在 [ToggleButtonShapes] 之间切换。
 *
 * ![Filled toggle button
 * image](https://developer.android.com/images/reference/androidx/compose/material3/filled-toggle-buttons.png)
 *
 * @param 已选中 切换按钮是开启还是关闭。
 * @param 已选中改变回调 切换按钮被点击时调用。
 * @param 修饰符 要应用于切换按钮的 [Modifier]。
 * @param 按钮大小 此开关按钮（toggle button）的 [ToggleButtonSize]，用于控制其高度、内边距以及图标尺寸。
 * @param 已启用 控制此切换按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，同时对无障碍服务也表现为禁用。
 * @param 图标 放置在 [内容] 之前的可选图标。
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
@Composable
fun 切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    按钮大小: ToggleButtonSize = ToggleButtonSize.Small,
    已启用: Boolean = true,
    图标: @Composable (() -> Unit)? = null,
    形状集: ToggleButtonShapes = ToggleButtonDefaults.shapesFor(buttonSize = 按钮大小),
    颜色集: ToggleButtonColors = ToggleButtonDefaults.colors(),
    阴影: ToggleButtonElevation? = ToggleButtonDefaults.elevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ToggleButtonDefaults.contentPaddingFor(buttonSize = 按钮大小, hasStartIcon = 图标 != null),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    ToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        buttonSize = 按钮大小,
        enabled = 已启用,
        icon = 图标,
        shapes = 形状集,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        contentPadding = 内容内边距,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design toggle
 * button](https://m3.material.io/components/buttons/overview#f8ba981c-a363-4ccd-a332-ee1b0e124e5c)
 *
 * 此重载接受一个显式的 [按钮大小] 和可选的 [图标]，以自动配置容器尺寸、形状、内容内边距、图标尺寸、图标间距和排版。
 *
 * 切换按钮是一种可切换的按钮，根据 [已选中] 的值在主色调和表面色调之间切换。只要 [形状集] 中提供的三个形状均为
 * [CornerBasedShape]，它还会根据与切换按钮的交互状态在这三个形状之间变形过渡。如果 [形状集] 中的某个形状不是
 * [CornerBasedShape]，则切换按钮将根据用户交互在 [ToggleButtonShapes] 之间切换。
 *
 * @param 已选中 切换按钮是开启还是关闭。
 * @param 已选中改变回调 切换按钮被点击时调用。
 * @param 修饰符 要应用于切换按钮的 [Modifier]。
 * @param 按钮大小 此开关按钮的 [ToggleButtonSize]。
 * @param 已启用 控制此切换按钮的启用状态。当为 `false` 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也表现为禁用。
 * @param 图标 放置在 [内容] 之前的可选图标。
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
@Composable
fun 凸起切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    按钮大小: ToggleButtonSize = ToggleButtonSize.Small,
    已启用: Boolean = true,
    图标: @Composable (() -> Unit)? = null,
    形状集: ToggleButtonShapes = ToggleButtonDefaults.shapesFor(buttonSize = 按钮大小),
    颜色集: ToggleButtonColors = ElevatedToggleButtonDefaults.colors(),
    阴影: ToggleButtonElevation? = ElevatedToggleButtonDefaults.elevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ToggleButtonDefaults.contentPaddingFor(buttonSize = 按钮大小, hasStartIcon = 图标 != null),
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
@Composable
fun 填充色调切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    按钮大小: ToggleButtonSize = ToggleButtonSize.Small,
    已启用: Boolean = true,
    图标: @Composable (() -> Unit)? = null,
    形状集: ToggleButtonShapes = ToggleButtonDefaults.shapesFor(buttonSize = 按钮大小),
    颜色集: ToggleButtonColors = FilledTonalToggleButtonDefaults.colors(),
    阴影: ToggleButtonElevation? = FilledTonalToggleButtonDefaults.elevation(),
    边框: BorderStroke? = null,
    内容内边距: PaddingValues = ToggleButtonDefaults.contentPaddingFor(buttonSize = 按钮大小, hasStartIcon = 图标 != null),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    FilledTonalToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        buttonSize = 按钮大小,
        enabled = 已启用,
        icon = 图标,
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
@Composable
fun 轮廓切换按钮(
    已选中: Boolean,
    已选中改变回调: (Boolean) -> Unit,
    修饰符: Modifier = Modifier,
    按钮大小: ToggleButtonSize = ToggleButtonSize.Small,
    已启用: Boolean = true,
    图标: @Composable (() -> Unit)? = null,
    形状集: ToggleButtonShapes = ToggleButtonDefaults.shapesFor(buttonSize = 按钮大小),
    颜色集: ToggleButtonColors = OutlinedToggleButtonDefaults.colors(),
    阴影: ToggleButtonElevation? = null,
    边框: BorderStroke? = OutlinedToggleButtonDefaults.border(enabled = 已启用, checked = 已选中),
    内容内边距: PaddingValues = ToggleButtonDefaults.contentPaddingFor(buttonSize = 按钮大小, hasStartIcon = 图标 != null),
    交互源: MutableInteractionSource? = null,
    内容: @Composable RowScope.() -> Unit,
) =
    OutlinedToggleButton(
        checked = 已选中,
        onCheckedChange = 已选中改变回调,
        modifier = 修饰符,
        buttonSize = 按钮大小,
        enabled = 已启用,
        icon = 图标,
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

    /**
     * 针对给定开关按钮高度的推荐 [PaddingValues]。
     *
     * 此内边距在所有开关按钮（toggle button）变体中都是相同的，应与 [ToggleButton]、[ElevatedToggleButton]、
     * [FilledTonalToggleButton] 和 [OutlinedToggleButton] 一起使用。
     *
     * 返回的内容内边距基于标准的容器高度值，而非直接从给定的 [按钮高度] 插值而来。
     *
     * @param 按钮高度 开关按钮的高度。
     * @param 是否有起始图标 开关按钮是否具有前置图标。
     * @param 是否有结束图标 开关按钮是否具有后置图标。
     */
    fun 用于内容内边距(
        按钮高度: Dp,
        是否有起始图标: Boolean = false,
        是否有结束图标: Boolean = false,
    ): PaddingValues =
        ToggleButtonDefaults.contentPaddingFor(
            buttonHeight = 按钮高度,
            hasStartIcon = 是否有起始图标,
            hasEndIcon = 是否有结束图标
        )

    /**
     * 针对给定的 [按钮大小] 的推荐 [PaddingValues]。
     *
     * 此内边距在所有开关按钮（toggle button）变体中都是相同的，应与 [ToggleButton]、[ElevatedToggleButton]、
     * [FilledTonalToggleButton] 和 [OutlinedToggleButton] 一起使用。
     *
     * @param 按钮大小 开关按钮的 [ToggleButtonSize]。
     * @param 是否有起始图标 开关按钮是否具有前置图标。
     * @param 是否有结束图标 开关按钮是否具有后置图标。
     */
    fun 用于内容内边距(
        按钮大小: ToggleButtonSize,
        是否有起始图标: Boolean = false,
        是否有结束图标: Boolean = false,
    ): PaddingValues =
        ToggleButtonDefaults.contentPaddingFor(
            buttonSize = 按钮大小,
            hasStartIcon = 是否有起始图标,
            hasEndIcon = 是否有结束图标,
        )


    /**
     * 创建一个 [ToggleButtonElevation]，它会根据 [ToggleButton] 的 Material 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 当 [ToggleButton] 处于启用状态且没有其他 [Interaction] 时使用的海拔高度。
     * @param 按压阴影 当此 [ToggleButton] 处于启用状态并被按下时使用的海拔高度。
     * @param 聚焦阴影 当 [ToggleButton] 处于启用状态且获得焦点时使用的海拔高度。
     * @param 悬停阴影 当 [ToggleButton] 处于启用状态且鼠标悬停在其上时使用的海拔高度。
     * @param 禁用阴影 当 [ToggleButton] 未启用时使用的海拔高度。
     */
    @Composable
    fun 阴影(
        默认阴影: Dp = FilledButtonTokens.ContainerElevation,
        按压阴影: Dp = FilledButtonTokens.PressedContainerElevation,
        聚焦阴影: Dp = FilledButtonTokens.FocusedContainerElevation,
        悬停阴影: Dp = FilledButtonTokens.HoveredContainerElevation,
        禁用阴影: Dp = FilledButtonTokens.DisabledContainerElevation,
    ): ToggleButtonElevation =
        ToggleButtonDefaults.elevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按压阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            disabledElevation = 禁用阴影,
        )


    /** [ToggleButton] 的默认未选中形状 */
    val 形状: Shape
        @Composable get() = ToggleButtonDefaults.shape

    /** [ToggleButton] 的默认按下形状 */
    val 按压形状: Shape
        @Composable get() = ToggleButtonDefaults.pressedShape

    /** [ToggleButton] 的默认选中形状 */
    val 已选中形状: Shape
        @Composable get() = ToggleButtonDefaults.checkedShape


    /** 创建一个 [ToggleButtonColors]，表示 [ToggleButton] 中使用的默认容器颜色和内容颜色。*/
    @Composable fun 颜色集() = ToggleButtonDefaults.colors()

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
    fun 颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
        已选中容器颜色: Color = Color.Unspecified,
        已选中内容颜色: Color = Color.Unspecified,
    ): ToggleButtonColors =
        ToggleButtonDefaults.colors(
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

    /**
     * 为给定的 [按钮大小] 解析推荐的 [ToggleButtonShapes]。
     *
     * 这些形状在所有开关按钮（toggle button）变体中都是相同的，应与 [ToggleButton]、[ElevatedToggleButton]、
     * [FilledTonalToggleButton] 和 [OutlinedToggleButton] 一起使用。
     *
     * @param 按钮大小 用于确定形状桶（shape bucket）的 [ToggleButtonSize]。
     */
    @Composable
    fun 用于形状集(按钮大小: ToggleButtonSize): ToggleButtonShapes =
        ToggleButtonDefaults.shapesFor(按钮大小.height)

}

/** 包含 [ElevatedToggleButton] 使用的默认值。 */
object 凸起切换按钮默认值 {

    /** 创建一个 [ToggleButtonColors]，表示 [ElevatedToggleButton] 中使用的默认容器颜色和内容颜色。*/
    @Composable
    public fun 颜色集(): ToggleButtonColors = ElevatedToggleButtonDefaults.colors()

    /**
     * 创建一个 [ToggleButtonColors]，表示 [ElevatedToggleButton] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [ElevatedToggleButton] 启用状态时的容器颜色。
     * @param 内容颜色 此 [ElevatedToggleButton] 启用状态时的内容颜色。
     * @param 禁用容器颜色 此 [ElevatedToggleButton] 未启用状态时的容器颜色。
     * @param 禁用内容颜色 此 [ElevatedToggleButton] 未启用状态时的内容颜色。
     * @param 已选中容器颜色 此 [ElevatedToggleButton] 选中状态时的容器颜色。
     * @param 已选中内容颜色 此 [ElevatedToggleButton] 选中状态时的内容颜色。
     */
    @Composable
    public fun 颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
        已选中容器颜色: Color = Color.Unspecified,
        已选中内容颜色: Color = Color.Unspecified,
    ): ToggleButtonColors =
        ElevatedToggleButtonDefaults.colors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
            checkedContainerColor = 已选中容器颜色,
            checkedContentColor = 已选中内容颜色,
        )

    /**
     * 创建一个 [ToggleButtonElevation]，它会根据 [ElevatedToggleButton] 的 Material
     * 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 当 [ElevatedToggleButton] 处于启用状态且没有其他 [Interaction] 时使用的海拔高度。
     * @param 按压阴影 当此 [ElevatedToggleButton] 处于启用状态并被按下时使用的海拔高度。
     * @param 聚焦阴影 当 [ElevatedToggleButton] 处于启用状态且获得焦点时使用的海拔高度。
     * @param 悬停阴影 当 [ElevatedToggleButton] 处于启用状态且鼠标悬停在其上时使用的海拔高度。
     * @param 禁用阴影 当 [ElevatedToggleButton] 未启用时使用的海拔高度。
     */
    @Composable
    public fun 阴影(
        默认阴影: Dp = ElevatedButtonTokens.ContainerElevation,
        按压阴影: Dp = ElevatedButtonTokens.PressedContainerElevation,
        聚焦阴影: Dp = ElevatedButtonTokens.FocusedContainerElevation,
        悬停阴影: Dp = ElevatedButtonTokens.HoveredContainerElevation,
        禁用阴影: Dp = ElevatedButtonTokens.DisabledContainerElevation,
    ): ToggleButtonElevation =
        ElevatedToggleButtonDefaults.elevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按压阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            disabledElevation = 禁用阴影,
        )

}

/** 包含 [FilledTonalToggleButton] 使用的默认值。 */
object 填充色调切换按钮默认值 {

    /**
     * 创建一个 [ToggleButtonColors]，表示 [FilledTonalToggleButton] 中使用的默认容器颜色和内容颜色。
     */
    @Composable
    public fun 颜色集(): ToggleButtonColors =
        FilledTonalToggleButtonDefaults.colors()

    /**
     * 创建一个 [ToggleButtonColors]，表示 [FilledTonalToggleButton] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [FilledTonalToggleButton] 启用状态时的容器颜色。
     * @param 内容颜色 此 [FilledTonalToggleButton] 启用状态时的内容颜色。
     * @param 禁用容器颜色 此 [FilledTonalToggleButton] 未启用状态时的容器颜色。
     * @param 禁用内容颜色 此 [FilledTonalToggleButton] 未启用状态时的内容颜色。
     * @param 已选中容器颜色 此 [FilledTonalToggleButton] 选中状态时的容器颜色。
     * @param 已选中内容颜色 此 [FilledTonalToggleButton] 选中状态时的内容颜色。
     */
    @Composable
    public fun 颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
        已选中容器颜色: Color = Color.Unspecified,
        已选中内容颜色: Color = Color.Unspecified,
    ): ToggleButtonColors =
        FilledTonalToggleButtonDefaults.colors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
            checkedContainerColor = 已选中容器颜色,
            checkedContentColor = 已选中内容颜色,
        )

    /**
     * 创建一个 [ToggleButtonElevation]，它会根据 [FilledTonalToggleButton] 的 Material 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 当 [FilledTonalToggleButton] 处于启用状态且没有其他 [Interaction] 时使用的海拔高度。
     * @param 按压阴影 当此 [FilledTonalToggleButton] 处于启用状态并被按下时使用的海拔高度。
     * @param 聚焦阴影 当 [FilledTonalToggleButton] 处于启用状态且获得焦点时使用的海拔高度。
     * @param 悬停阴影 当 [FilledTonalToggleButton] 处于启用状态且鼠标悬停在其上时使用的海拔高度。
     * @param 禁用阴影 当 [FilledTonalToggleButton] 未启用时使用的海拔高度。
     */
    @Composable
    public fun 阴影(
        默认阴影: Dp = FilledTonalButtonTokens.ContainerElevation,
        按压阴影: Dp = FilledTonalButtonTokens.PressedContainerElevation,
        聚焦阴影: Dp = FilledTonalButtonTokens.FocusContainerElevation,
        悬停阴影: Dp = FilledTonalButtonTokens.HoverContainerElevation,
        禁用阴影: Dp = 0.dp,
    ): ToggleButtonElevation =
        FilledTonalToggleButtonDefaults.elevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按压阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            disabledElevation = 禁用阴影,
        )

}

/** 包含 [OutlinedToggleButton] 使用的默认值。 */
object 轮廓切换按钮默认值 {

    /**
     * 创建一个 [ToggleButtonColors]，表示 [OutlinedToggleButton] 中使用的默认容器颜色和内容颜色。
     */
    @Composable
    public fun 颜色集(): ToggleButtonColors =
        OutlinedToggleButtonDefaults.colors()

    /**
     * 创建一个 [ToggleButtonColors]，表示 [OutlinedToggleButton] 中使用的默认容器颜色和内容颜色。
     *
     * @param 容器颜色 此 [OutlinedToggleButton] 启用状态时的容器颜色。
     * @param 内容颜色 此 [OutlinedToggleButton] 启用状态时的内容颜色。
     * @param 禁用容器颜色 此 [OutlinedToggleButton] 未启用状态时的容器颜色。
     * @param 禁用内容颜色 此 [OutlinedToggleButton] 未启用状态时的内容颜色。
     * @param 已选中容器颜色 此 [OutlinedToggleButton] 选中状态时的容器颜色。
     * @param 已选中内容颜色 此 [OutlinedToggleButton] 选中状态时的内容颜色。
     */
    @Composable
    public fun 颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = Color.Unspecified,
        已选中容器颜色: Color = Color.Unspecified,
        已选中内容颜色: Color = Color.Unspecified,
    ): ToggleButtonColors =
        OutlinedToggleButtonDefaults.colors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
            checkedContainerColor = 已选中容器颜色,
            checkedContentColor = 已选中内容颜色,
        )

    /**
     * 解析 [OutlinedToggleButton] 中使用的默认 [BorderStroke]。
     *
     * @param 已启用 控制按钮的启用状态。
     * @param 已选中 控制按钮的选中状态。
     */
    @Composable
    public fun 边框(已启用: Boolean, 已选中: Boolean, ): BorderStroke? =
        OutlinedToggleButtonDefaults.border(enabled = 已启用, checked = 已选中,)

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

