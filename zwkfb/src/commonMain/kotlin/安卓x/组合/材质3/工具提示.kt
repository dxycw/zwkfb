package 安卓x.组合.材质3

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.MutatorMutex
import androidx.compose.material3.DefaultTooltipCaretShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.RichTooltipColors
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TooltipScope
import androidx.compose.material3.TooltipState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.CacheDrawScope
import androidx.compose.ui.draw.DrawResult
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider
import kotlin.jvm.JvmInline


/**
 * Material TooltipBox，用于为可组合项包裹一个工具提示。
 *
 * 工具提示为锚点提供描述性消息。它可以用于吸引用户对锚点的注意。
 *
 * @param 位置提供器 [PopupPositionProvider]，用于将工具提示相对于锚点内容进行定位。
 * @param 工具提示 用于填充工具提示内容的可组合项。
 * @param 状态 处理工具提示可见性的状态。
 * @param 修饰符 要应用于 TooltipBox 的 [Modifier]。
 * @param 关闭请求回调 当用户点击工具提示外部时执行。默认情况下，当工具提示显示时，用户点击其外部区域，工具提示将会关闭。
 * @param 可聚焦 [Boolean]，用于确定工具提示是否可获取焦点。为 `true` 时，工具提示在显示期间会消费触摸事件，
 * 并且无障碍焦点会移动到该组件的第一个元素。为 `false` 时，工具提示在显示期间不会消费触摸事件，但辅助技术用户需要滑动或拖动
 * 才能到达该组件的第一个元素。对于某些无障碍场景，例如当工具提示包含操作且 Talkback 开启时，`可聚焦` 将被强制设为
 * `true`，以确保正确的无障碍行为。
 * @param 启用用户输入 [Boolean]，用于确定此 TooltipBox 是否会处理长按、鼠标悬停和键盘焦点，以通过提供的状态触发工具提示。
 * @param 有操作 关联的工具提示是否包含操作。
 * @param 内容 工具提示将锚定到的可组合项。
 */
@Suppress("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun 工具提示框(
    位置提供器: PopupPositionProvider,
    工具提示: @Composable TooltipScope.() -> Unit,
    状态: TooltipState,
    修饰符: Modifier = Modifier,
    关闭请求回调: (() -> Unit)? = null,
    可聚焦: Boolean = false,
    启用用户输入: Boolean = true,
    有操作: Boolean = false,
    内容: @Composable () -> Unit,
) =
    TooltipBox(
        positionProvider = 位置提供器,
        tooltip = 工具提示,
        state = 状态,
        modifier = 修饰符,
        onDismissRequest = 关闭请求回调,
        focusable = 可聚焦,
        enableUserInput = 启用用户输入,
        hasAction = 有操作,
        content = 内容,
    )


/** 用于 [TooltipBox] 的工具提示作用域，可用于获取锚点内容的 [LayoutCoordinates]，以及为工具提示绘制指示箭头（caret）。*/
sealed interface 工具提示范围 { // TooltipScope

    /** 用于获取锚点内容的 [LayoutCoordinates]。这可用于帮助绘制指向锚点内容的指示箭头。*/
    fun MeasureScope.获取锚点边界(): LayoutCoordinates?

    /** 用于获取所使用的 [PopupPositionProvider]。这可用于帮助绘制指向锚点内容的指示箭头。*/
    fun 获取定位提供器(): PopupPositionProvider

}

// ===================================================================

/** 用于获取所使用的 [PopupPositionProvider]。这可用于帮助绘制指向锚点内容的指示箭头。*/
fun TooltipScope.取定位提供器(): PopupPositionProvider = this.obtainPositionProvider()

// ===================================================================

/**
 * 提供描述性消息的纯文本工具提示。
 *
 * 通常与 [TooltipBox] 一起使用。
 *
 * @param 修饰符 要应用于工具提示的 [Modifier]。
 * @param 箭头形状 工具提示指示箭头（caret）的 [形状]。如果需要具有特定尺寸默认指示箭头，请使用 [TooltipDefaults.caretShape]。
 * 要查看默认尺寸，请参阅 [TooltipDefaults.caretSize]。如果不需要指示箭头，请传入 null。
 * @param 最大宽度 纯文本工具提示的最大宽度。
 * @param 形状 应应用于工具提示容器的 [Shape]。
 * @param 内容颜色 将应用于工具提示内容的 [Color]。
 * @param 容器颜色 将应用于工具提示容器的 [Color]。
 * @param 色调阴影 工具提示的色调高度。
 * @param 视觉阴影 工具提示的阴影高度。
 * @param 内容 用于填充工具提示内容的可组合项。
 */
@Suppress("ComposableNaming")
@Composable
fun TooltipScope.普通工具提示(
    修饰符: Modifier = Modifier,
    箭头形状: (Shape)? = null,
    最大宽度: Dp = TooltipDefaults.plainTooltipMaxWidth,
    形状: Shape = TooltipDefaults.plainTooltipContainerShape,
    内容颜色: Color = TooltipDefaults.plainTooltipContentColor,
    容器颜色: Color = TooltipDefaults.plainTooltipContainerColor,
    色调阴影: Dp = 0.dp,
    视觉阴影: Dp = 0.dp,
    内容: @Composable () -> Unit,
) =
    this.PlainTooltip(
        modifier = 修饰符,
        caretShape = 箭头形状,
        maxWidth = 最大宽度,
        shape = 形状,
        contentColor = 内容颜色,
        containerColor = 容器颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        content = 内容,
    )


/**
 * 富文本工具提示，允许用户传入标题、文本和操作。工具提示用于提供描述性消息。
 *
 * 通常与 [TooltipBox] 一起使用。
 *
 * @param 修饰符 要应用于工具提示的 [Modifier]。
 * @param 标题 工具提示的可选标题。
 * @param 操作 工具提示的可选操作。
 * @param 箭头形状 工具提示指示箭头（caret）的 [形状]。如果需要具有特定尺寸默认指示箭头，请使用 [TooltipDefaults.caretShape]。
 * 要查看默认尺寸，请参阅 [TooltipDefaults.caretSize]。如果不需要指示箭头，请传入 null。
 * @param 最大宽度 纯文本工具提示的最大宽度。
 * @param 形状 应应用于工具提示容器的 [Shape]。
 * @param 颜色集 将应用于工具提示容器和内容的 [RichTooltipColors]。
 * @param 色调阴影 工具提示的色调高度。
 * @param 视觉阴影 工具提示的阴影高度。
 * @param 文本 用于填充富文本工具提示文本的可组合项。
 */
@Suppress("ComposableNaming")
@Composable
fun TooltipScope.富工具提示(
    修饰符: Modifier = Modifier,
    标题: (@Composable () -> Unit)? = null,
    操作: (@Composable () -> Unit)? = null,
    箭头形状: (Shape)? = null,
    最大宽度: Dp = TooltipDefaults.richTooltipMaxWidth,
    形状: Shape = TooltipDefaults.richTooltipContainerShape,
    颜色集: RichTooltipColors = TooltipDefaults.richTooltipColors(),
    色调阴影: Dp = 0.0.dp,
    视觉阴影: Dp = 3.0.dp,
    文本: @Composable () -> Unit,
) =
    this.RichTooltip(
        modifier = 修饰符,
        title = 标题,
        action = 操作,
        caretShape = 箭头形状,
        maxWidth = 最大宽度,
        shape = 形状,
        colors = 颜色集,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        text = 文本,
    )


/** 包含 [PlainTooltip] 和 [RichTooltip] 默认值的工具提示默认值。 */
object 工具提示默认值 { // TooltipDefaults

    /** [PlainTooltip] 容器的默认 [Shape]。 */
    val 普通工具提示容器形状: Shape
        @Composable get() = TooltipDefaults.plainTooltipContainerShape

    /** [PlainTooltip] 容器的默认 [Color]。 */
    val 普通工具提示容器颜色: Color
        @Composable get() = TooltipDefaults.plainTooltipContainerColor

    /** [PlainTooltip] 内内容的默认 [Color]。 */
    val 普通工具提示内容颜色: Color
        @Composable get() = TooltipDefaults.plainTooltipContentColor

    /** [RichTooltip] 容器的默认 [Shape]。 */
    val 富工具提示容器形状: Shape
        @Composable get() = TooltipDefaults.richTooltipContainerShape

    /** 工具提示指示箭头（caret）的默认 [DpSize]。 */
    val 箭头大小: DpSize = TooltipDefaults.caretSize

    /** 纯文本工具提示的默认最大宽度。 */
    val 普通工具提示最大宽度: Dp = TooltipDefaults.plainTooltipMaxWidth

    /** 富文本工具提示的默认最大宽度。 */
    val 富工具提示最大宽度: Dp = TooltipDefaults.richTooltipMaxWidth

    /** 工具提示使用的默认指示箭头形状，尺寸为 [TooltipDefaults.caretSize]。 */
    fun 箭头形状() = TooltipDefaults.caretShape()

    /**
     * 工具提示使用的指示箭头形状。
     *
     * @param 箭头大小 用于绘制指示箭头形状的 [DpSize]。
     */
    fun 箭头形状(箭头大小: DpSize = TooltipDefaults.caretSize): Shape =
        TooltipDefaults.caretShape(caretSize = 箭头大小)

    /** 使用 [RichTooltipTokens] 为 [RichTooltip] 创建 [RichTooltipColors] 的方法，以获取默认颜色。*/
    @Composable
    fun 富工具提示颜色集() = TooltipDefaults.richTooltipColors()

    /** 使用 [RichTooltipTokens] 为 [RichTooltip] 创建 [RichTooltipColors] 的方法，以获取默认颜色。*/
    @Composable
    fun 富工具提示颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = Color.Unspecified,
        标题内容颜色: Color = Color.Unspecified,
        操作内容颜色: Color = Color.Unspecified,
    ): RichTooltipColors =
        TooltipDefaults.richTooltipColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            titleContentColor = 标题内容颜色,
            actionContentColor = 操作内容颜色,
        )


    /**
     * 应与 [PlainTooltip] 一起使用的 [PopupPositionProvider]。它会根据锚点内容正确放置工具提示。
     *
     * @param 工具提示与锚点间距 工具提示与锚点内容之间的间距。
     */
    @Deprecated(
        "Deprecated in favor of rememberTooltipPositionProvider API.",
        replaceWith =
            ReplaceWith("rememberTooltipPositionProvider(spacingBetweenTooltipAndAnchor)"),
        level = DeprecationLevel.WARNING,
    )
    @Composable
    fun 记住普通工具提示位置提供器(
        工具提示与锚点间距: Dp = SpacingBetweenTooltipAndAnchor
    ): PopupPositionProvider =
        TooltipDefaults.rememberPlainTooltipPositionProvider(
            spacingBetweenTooltipAndAnchor = 工具提示与锚点间距
        )

    /**
     *  应与 [RichTooltip] 一起使用的 [PopupPositionProvider]。它会根据锚点内容正确放置工具提示。
     *
     * @param 工具提示与锚点间距 工具提示与锚点内容之间的间距。
     */
    @Deprecated(
        "Deprecated in favor of rememberTooltipPositionProvider API.",
        replaceWith =
            ReplaceWith("rememberTooltipPositionProvider(spacingBetweenTooltipAndAnchor)"),
        level = DeprecationLevel.WARNING,
    )
    @Composable
    fun 记住富工具提示位置提供器(
        工具提示与锚点间距: Dp = SpacingBetweenTooltipAndAnchor
    ): PopupPositionProvider =
        TooltipDefaults.rememberRichTooltipPositionProvider(
            spacingBetweenTooltipAndAnchor = 工具提示与锚点间距
        )

    /**
     * 应与 [RichTooltip] 或 [PlainTooltip] 一起使用的 [PopupPositionProvider]。它会根据锚点内容正确放置工具提示。
     *
     * @param 工具提示与锚点间距 工具提示与锚点内容之间的间距。
     */
    @Deprecated(
        "Deprecated in favor of rememberTooltipPositionProvider API that " +
                "takes a preferred positioning. Please use rememberTooltipPositionProvider with " +
                "TooltipAnchorPosition.Above if this same behavior is desired.",
        replaceWith =
            ReplaceWith(
                "rememberTooltipPositionProvider(TooltipAnchorPosition.ABOVE, spacingBetweenTooltipAndAnchor)"
            ),
        level = DeprecationLevel.WARNING,
    )
    @Composable
    fun 记住工具提示位置提供器(
        工具提示与锚点间距: Dp = SpacingBetweenTooltipAndAnchor
    ): PopupPositionProvider =
        TooltipDefaults.rememberTooltipPositionProvider(
            spacingBetweenTooltipAndAnchor = 工具提示与锚点间距
        )

    /**
     * 应与 [RichTooltip] 或 [PlainTooltip] 一起使用的 [PopupPositionProvider]。它会根据锚点内容正确放置工具提示。
     *
     * @param 定位 [TooltipAnchorPosition]，用于确定工具提示相对于锚点的放置位置。
     * @param 工具提示与锚点间距 工具提示与锚点内容之间的间距。
     */
    @Composable
    fun 记住工具提示位置提供器(
        定位: TooltipAnchorPosition,
        工具提示与锚点间距: Dp = SpacingBetweenTooltipAndAnchor,
    ): PopupPositionProvider =
        TooltipDefaults.rememberTooltipPositionProvider(
            positioning = 定位,
            spacingBetweenTooltipAndAnchor = 工具提示与锚点间距
        )

}



fun 富工具提示颜色集(
    容器颜色: Color,
    内容颜色: Color,
    标题内容颜色: Color,
    操作内容颜色: Color,
) =
    RichTooltipColors(
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        titleContentColor = 标题内容颜色,
        actionContentColor = 操作内容颜色,
    )

/** 返回此 RichTooltipColors 的副本，可选择性地覆盖部分值。此处使用 Color.Unspecified 表示"使用源中的值"。*/
fun RichTooltipColors.复制(
    容器颜色: Color = this.containerColor,
    内容颜色: Color = this.contentColor,
    标题内容颜色: Color = this.titleContentColor,
    操作内容颜色: Color = this.actionContentColor,
) =
    this.copy(
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        titleContentColor = 标题内容颜色,
        actionContentColor = 操作内容颜色,
    )


object 工具提示锚点位置{

    /** 将工具提示放置在锚点上方。 */
    val 上面 = TooltipAnchorPosition.Above

    /** 将工具提示放置在锚点下方。 */
    val 下面 = TooltipAnchorPosition.Below

    /** 将工具提示放置在锚点左侧。 */
    val 左侧 = TooltipAnchorPosition.Left

    /** 将工具提示放置在锚点右侧。 */
    val 右侧 = TooltipAnchorPosition.Right

    /** 将工具提示放置在锚点的起始位置。 */
    val 起始 = TooltipAnchorPosition.Start

    /** 将工具提示放置在锚点的结束位置。 */
    val 结束 = TooltipAnchorPosition.End

}


/**
 * 为 [TooltipBox] 创建并记住默认的 [TooltipState]。
 *
 * @param 初始可见 工具提示绘制时可见性的初始值。
 * @param 是否持久 [Boolean]，用于确定与此关联的工具提示是否为持久性的。如果 `是否持久` 为 `true`，则工具提示
 * 仅在用户点击工具提示边界外部或调用 [TooltipState.dismiss] 时才会关闭。当 `是否持久` 为 `false` 时，工具提示
 * 将在短时间后自动关闭。理想情况下，当工具提示内显示有可操作内容时，应将此值设为 `true`。
 * @param 变异器互斥锁 [MutatorMutex]，用于确保与该互斥锁关联的所有工具提示中，任何时刻只有一个会显示在屏幕上。
 */
@Composable
fun 记住工具提示状态(
    初始可见: Boolean = false,
    是否持久: Boolean = false,
    变异器互斥锁: MutatorMutex = MutatorMutex(),
): TooltipState =
    rememberTooltipState(
        initialIsVisible = 初始可见,
        isPersistent = 是否持久,
        mutatorMutex = 变异器互斥锁,
    )


/**
 * [TooltipState] 的构造函数扩展函数。
 *
 * @param 初始可见 工具提示绘制时可见性的初始值。
 * @param 是否持久 [Boolean]，用于确定与此关联的工具提示是否为持久性的。如果 `是否持久` 为 `true`，则工具提示
 * 仅在用户点击工具提示边界外部或调用 [TooltipState.dismiss] 时才会关闭。当 `是否持久` 为 `false` 时，工具提示
 * 将在短时间后自动关闭。理想情况下，当工具提示内显示有可操作内容时，应将此值设为 `true`。
 * @param 变异器互斥锁 [MutatorMutex]，用于确保与该互斥锁关联的所有工具提示中，任何时刻只有一个会显示在屏幕上。
 */
fun 工具提示状态(
    初始可见: Boolean = false,
    是否持久: Boolean = true,
    变异器互斥锁: MutatorMutex = MutatorMutex(),
): TooltipState =
    TooltipState(
        initialIsVisible = 初始可见,
        isPersistent = 是否持久,
        mutatorMutex = 变异器互斥锁,
    )


/** 与 [TooltipBox] 关联的状态。[TooltipBox] 的每个实例都应拥有自己的 [TooltipState]。*/
interface 工具提示状态 { // TooltipState

    /** 工具提示的当前过渡状态。用于在淡入和淡出时启动工具提示的过渡动画。*/
    val 过渡: MutableTransitionState<Boolean> // transition

    /**  [Boolean]，用于指示工具提示当前是否正在显示。 */
    val 是否可见: Boolean // isVisible

    /**
     * [Boolean]，用于确定与此关联的工具提示是否为持久性的。如果 `isPersistent` 为 `true`，则工具提示仅在用户点击工具提示
     * 边界外部或调用 [TooltipState.dismiss] 时才会关闭。当 `isPersistent` 为 `false` 时，工具提示将在短时间后
     * 自动关闭。理想情况下，当工具提示内显示有可操作内容时，应将此值设为 `true`。
     */
    val 是否持久: Boolean // isPersistent

    /**
     * 显示与当前 [TooltipState] 关联的工具提示。当调用此方法时，当前正在显示的所有其他工具提示都将关闭。
     *
     * @param mutatePriority 要使用的 [MutatePriority]。
     */
    suspend fun 显示(mutatePriority: MutatePriority = MutatePriority.Default) // show

    /** 如果当前正在显示，则关闭与此 [TooltipState] 关联的工具提示。 */
    fun 关闭() // dismiss

    /** 当此状态离开组合时进行清理。 */
    fun 销毁回调() // onDispose

}

// ===================================================================

/** 工具提示的当前过渡状态。用于在淡入和淡出时启动工具提示的过渡动画。*/
val TooltipState.过渡: MutableTransitionState<Boolean>
    get() = this.transition

/**  [Boolean]，用于指示工具提示当前是否正在显示。 */
val TooltipState.是否可见: Boolean
    get() = this.isVisible

/**
 * [Boolean]，用于确定与此关联的工具提示是否为持久性的。如果 `是否持久` 为 `true`，则工具提示仅在用户点击工具提示
 * 边界外部或调用 [TooltipState.dismiss] 时才会关闭。当 `是否持久` 为 `false` 时，工具提示将在短时间后
 * 自动关闭。理想情况下，当工具提示内显示有可操作内容时，应将此值设为 `true`。
 */
val TooltipState.是否持久: Boolean
    get() = this.isPersistent

/**
 * 显示与当前 [TooltipState] 关联的工具提示。当调用此方法时，当前正在显示的所有其他工具提示都将关闭。
 *
 * @param 变异优先级 要使用的 [MutatePriority]。
 */
suspend fun TooltipState.显示(变异优先级: MutatePriority = MutatePriority.Default) =
    this.show(mutatePriority = 变异优先级)

/** 如果当前正在显示，则关闭与此 [TooltipState] 关联的工具提示。 */
fun TooltipState.关闭() = this.dismiss()

/** 当此状态离开组合时进行清理。 */
fun TooltipState.销毁回调() = this.onDispose()

// ===================================================================

/**
 * 工具提示使用的指示箭头的默认 [Shape]。
 *
 * @param 箭头大小 使用的指示箭头尺寸
 */
fun 默认工具提示箭头形状(箭头大小: DpSize = TooltipDefaults.caretSize) =
    DefaultTooltipCaretShape(caretSize = 箭头大小)

val DefaultTooltipCaretShape.箭头大小: DpSize
    get() = this.caretSize

fun DefaultTooltipCaretShape.创建轮廓(
    大小: Size,
    布局方向: LayoutDirection,
    密度: Density,
): Outline =
    this.createOutline(
        size = 大小,
        layoutDirection = 布局方向,
        density = 密度
    )


internal val SpacingBetweenTooltipAndAnchor = 4.dp

