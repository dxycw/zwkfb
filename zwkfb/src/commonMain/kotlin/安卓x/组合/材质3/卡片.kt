package 安卓x.组合.材质3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * [Material Design filled card](https://m3.material.io/components/cards/overview)
 *
 * 卡片包含与某个主题相关的信息和操作。填充式卡片与背景之间有细微的区分。其强调程度低于悬浮式卡片或轮廓式卡片。
 *
 * 此卡片不处理输入事件——如果你需要可点击或可选择的卡片，请参阅其他的卡片重载版本。
 *
 * ![Filled card image](https://developer.android.com/images/reference/androidx/compose/material3/filled-card.png)
 *
 * @param 修饰符 应用于此卡片的 [Modifier]
 * @param 形状 定义此卡片容器、边框（当 [边框] 不为空时）以及阴影（使用 [阴影] 时）的形状。
 * @param 颜色集 [CardColors]，用于解析此卡片在不同状态下使用的颜色。参见 [CardDefaults.cardColors]。
 * @param 阴影 [CardElevation]，用于解析此卡片在不同状态下的海拔高度。它控制卡片下方阴影的大小。此外，当容器颜色为
 * [ColorScheme.surface] 时，它还控制作为叠加层应用的主色调的量。另见：[表面]。
 * @param 边框 围绕此卡片容器绘制的边框
 * @param 内容 卡片上显示的内容
 */
@Suppress("ComposableNaming")
@Composable
fun 卡片(
    修饰符: Modifier = Modifier,
    形状: Shape = CardDefaults.shape,
    颜色集: CardColors = CardDefaults.cardColors(),
    阴影: CardElevation = CardDefaults.cardElevation(),
    边框: BorderStroke? = null,
    内容: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        content = 内容,
    )
}

/**
 * [Material Design filled card](https://m3.material.io/components/cards/overview)
 *
 * 卡片包含与某个主题相关的信息和操作。填充式卡片与背景之间有细微的区分。其强调程度低于悬浮式卡片或轮廓式卡片。
 *
 * 此卡片处理点击事件，并调用其 [单击回调]。
 *
 * ![Filled card image](https://developer.android.com/images/reference/androidx/compose/material3/filled-card.png)
 *
 * @param 单击回调 当此卡片被点击时调用
 * @param 修饰符 应用于此卡片的 [Modifier]
 * @param 已启用 控制此卡片的启用状态。当为 false 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 形状 定义此卡片容器、边框（当 [边框] 不为空时）以及阴影（使用 [阴影] 时）的形状。
 * @param 颜色集 [CardColors]，用于解析此卡片在不同状态下使用的颜色。参见 [CardDefaults.cardColors]。
 * @param 阴影 [CardElevation]，用于解析此卡片在不同状态下的海拔高度。它控制卡片下方阴影的大小。此外，当容器颜色为 [ColorScheme.surface]
 * 时，它还控制作为叠加层应用的主色调的量。另见：[表面]。
 * @param 边框 围绕此卡片容器绘制的边框
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发出此卡片的 [Interaction]。
 * 你可以使用它来更改卡片的外观或在不同状态下预览卡片。请注意，如果提供 null，交互仍将在内部发生。
 * @param 内容 卡片上显示的内容
 */
@Suppress("ComposableNaming")
@Composable
fun 卡片(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = CardDefaults.shape,
    颜色集: CardColors = CardDefaults.cardColors(),
    阴影: CardElevation = CardDefaults.cardElevation(),
    边框: BorderStroke? = null,
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) {
    Card(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )
}

/**
 * [Material Design elevated card](https://m3.material.io/components/cards/overview)
 *
 * 凸起卡片包含与某个主题相关的信息和操作。它们带有投影，与背景的分离程度比填充式卡片更高，但低于轮廓式卡片。
 *
 * 此凸起卡片不处理输入事件——如果你需要可点击或可选择的悬浮式卡片，请参阅其他的悬浮式卡片重载版本。
 *
 * ![Elevated card image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-card.png)
 *
 * @param 修饰符 应用于此卡片的 [Modifier]
 * @param 形状 定义此卡片容器以及阴影（使用 [阴影] 时）的形状。
 * @param 颜色集 [CardColors]，用于解析此卡片在不同状态下使用的颜色。参见 [CardDefaults.elevatedCardElevation]。
 * @param 阴影 [CardElevation]，用于解析此卡片在不同状态下的海拔高度。它控制卡片下方阴影的大小。此外，当容器颜色为 [ColorScheme.surface] 时，
 * 它还控制作为叠加层应用的主色调的量。另见：[表面]。
 * @param 内容 卡片上显示的内容
 */
@Suppress("ComposableNaming")
@Composable
fun 凸起卡片(
    修饰符: Modifier = Modifier,
    形状: Shape = CardDefaults.elevatedShape,
    颜色集: CardColors = CardDefaults.elevatedCardColors(),
    阴影: CardElevation = CardDefaults.elevatedCardElevation(),
    内容: @Composable ColumnScope.() -> Unit,
) =
    ElevatedCard(
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        content = 内容,
    )

/**
 * [Material Design elevated card](https://m3.material.io/components/cards/overview)
 *
 * 凸起卡片包含与某个主题相关的信息和操作。它们带有投影，与背景的分离程度比填充式卡片更高，但低于轮廓式卡片。
 *
 * 此悬浮式卡片处理点击事件，并调用其 [单击回调]。
 *
 * ![Elevated card image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-card.png)
 *
 * @param 单击回调 当此卡片被点击时调用
 * @param 修饰符 应用于此卡片的 [Modifier]
 * @param 已启动 控制此卡片的启用状态。当为 `false` 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 形状 定义此卡片容器以及阴影（使用 [阴影] 时）的形状。
 * @param 颜色集 [CardColors]，用于解析此卡片在不同状态下使用的颜色。参见 [CardDefaults.elevatedCardElevation]。
 * @param 阴影 [CardElevation]，用于解析此卡片在不同状态下的海拔高度。它控制卡片下方阴影的大小。此外，当容器颜色为 [ColorScheme.surface]
 * 时，它还控制作为叠加层应用的主色调的量。另见：[表面]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发出此卡片的 [Interaction]。
 * 你可以使用它来更改卡片的外观或在不同状态下预览卡片。请注意，如果提供 null，交互仍将在内部发生。
 * @param 内容 卡片上显示的内容
 */
@Suppress("ComposableNaming")
@Composable
fun 凸起卡片(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启动: Boolean = true,
    形状: Shape = CardDefaults.elevatedShape,
    颜色集: CardColors = CardDefaults.elevatedCardColors(),
    阴影: CardElevation = CardDefaults.elevatedCardElevation(),
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    ElevatedCard(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启动,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        interactionSource = 交互源,
        content = 内容,
    )

/**
 * [Material Design outlined card](https://m3.material.io/components/cards/overview)
 *
 * 轮廓式卡片包含与某个主题相关的信息和操作。它们在容器周围有一个视觉边界。这可以提供比其他类型更强的强调效果。
 *
 * 此轮廓式卡片不处理输入事件——如果你需要可点击或可选择的轮廓式卡片，请参阅其他的轮廓式卡片重载版本。
 *
 * ![Outlined card image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-card.png)
 *
 * @param 修饰符 应用于此卡片的 [Modifier]
 * @param 形状 定义此卡片容器、边框（当 [边框] 不为空时）以及阴影（使用 [阴影] 时）的形状。
 * @param 颜色集 [CardColors]，用于解析此卡片在不同状态下使用的颜色。参见 [CardDefaults.outlinedCardColors]。
 * @param 阴影 [CardElevation]，用于解析此卡片在不同状态下的海拔高度。它控制卡片下方阴影的大小。此外，当容器颜色为 [ColorScheme.surface] 时，
 * 它还控制作为叠加层应用的主色调的量。另见：[表面]。
 * @param 边框 围绕此卡片容器绘制的边框
 * @param 内容 卡片上显示的内容
 */
@Suppress("ComposableNaming")
@Composable
fun 轮廓卡片(
    修饰符: Modifier = Modifier,
    形状: Shape = CardDefaults.outlinedShape,
    颜色集: CardColors = CardDefaults.outlinedCardColors(),
    阴影: CardElevation = CardDefaults.outlinedCardElevation(),
    边框: BorderStroke = CardDefaults.outlinedCardBorder(),
    内容: @Composable ColumnScope.() -> Unit,
) =
    OutlinedCard(
        modifier = 修饰符,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        content = 内容,
    )

/**
 * [Material Design outlined card](https://m3.material.io/components/cards/overview)
 *
 * 轮廓式卡片包含与某个主题相关的信息和操作。它们在容器周围有一个视觉边界。这可以提供比其他类型更强的强调效果。
 *
 * 此轮廓式卡片处理点击事件，并调用其 [单击回调]。
 *
 * ![Outlined card image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-card.png)
 *
 * @param 单击回调 当此卡片被点击时调用
 * @param 修饰符 应用于此卡片的 [Modifier]
 * @param 已启用 控制此卡片的启用状态。当为 false 时，此组件将不会响应用户输入，并且在视觉上显示为禁用状态，对无障碍服务也显示为禁用。
 * @param 形状 定义此卡片容器、边框（当 [边框] 不为空时）以及阴影（使用 [阴影] 时）的形状。
 * @param 颜色集 [CardColors]，用于解析此卡片在不同状态下使用的颜色。参见 [CardDefaults.outlinedCardColors]。
 * @param 阴影 [CardElevation]，用于解析此卡片在不同状态下的海拔高度。它控制卡片下方阴影的大小。此外，当容器颜色为 [ColorScheme.surface]
 * 时，它还控制作为叠加层应用的主色调的量。另见：[表面]。
 * @param 边框 围绕此卡片容器绘制的边框
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发出此卡片的 [Interaction]。
 * 你可以使用它来更改卡片的外观或在不同状态下预览卡片。请注意，如果提供 null，交互仍将在内部发生。
 * @param 内容 卡片上显示的内容
 */
@Suppress("ComposableNaming")
@Composable
fun 轮廓卡片(
    单击回调: () -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    形状: Shape = CardDefaults.outlinedShape,
    颜色集: CardColors = CardDefaults.outlinedCardColors(),
    阴影: CardElevation = CardDefaults.outlinedCardElevation(),
    边框: BorderStroke = CardDefaults.outlinedCardBorder(已启用),
    交互源: MutableInteractionSource? = null,
    内容: @Composable ColumnScope.() -> Unit,
) =
    OutlinedCard(
        onClick = 单击回调,
        modifier = 修饰符,
        enabled = 已启用,
        shape = 形状,
        colors = 颜色集,
        elevation = 阴影,
        border = 边框,
        interactionSource = 交互源,
        content = 内容,
    )


/** 包含所有卡片类型使用的默认值。 */
object 卡片默认值 { // CardDefaults

    /** 卡片的默认形状。 */
    val 形状: Shape
        @Composable get() = CardDefaults.shape

    /** 凸起卡片的默认形状。 */
    val 凸起形状: Shape
        @Composable get() = CardDefaults.elevatedShape

    /** 轮廓式卡片的默认形状。 */
    val 轮廓形状: Shape
        @Composable get() = CardDefaults.outlinedShape

    /**
     * 创建一个 [CardElevation]，它将根据 [卡片] 的 Material 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 当 [卡片] 没有其他 [Interaction] 时使用的海拔高度。
     * @param 按下阴影 当 [卡片] 被按下时使用的海拔高度。
     * @param 聚焦阴影 当 [卡片] 被聚焦时使用的海拔高度。
     * @param 悬停阴影 当 [卡片] 被悬停时使用的海拔高度。
     * @param 拖拽阴影 当 [卡片] 被拖动时使用的海拔高度。
     * @param 禁用阴影 当 [卡片] 被禁用时使用的海拔高度。
     */
    @Composable
    fun 卡片阴影(
        默认阴影: Dp = 0.0.dp,
        按下阴影: Dp = 0.0.dp,
        聚焦阴影: Dp = 0.0.dp,
        悬停阴影: Dp = 1.0.dp,
        拖拽阴影: Dp = 6.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): CardElevation =
        CardDefaults.cardElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [CardElevation]，它将根据 [凸起卡片] 的 Material 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 当 [凸起卡片] 没有其他 [Interaction] 时使用的海拔高度。
     * @param 按下阴影 当 [凸起卡片] 被按下时使用的海拔高度。
     * @param 聚焦阴影 当 [凸起卡片] 被聚焦时使用的海拔高度。
     * @param 悬停阴影 当 [凸起卡片] 被悬停时使用的海拔高度。
     * @param 拖拽阴影 当 [凸起卡片] 被拖动时使用的海拔高度。
     * @param 禁用阴影 当 [凸起卡片] 被禁用时使用的海拔高度。
     */
    @Composable
    fun 凸起卡片阴影(
        默认阴影: Dp = 1.0.dp,
        按下阴影: Dp = 1.0.dp,
        聚焦阴影: Dp = 1.0.dp,
        悬停阴影: Dp = 3.0.dp,
        拖拽阴影: Dp = 8.0.dp,
        禁用阴影: Dp = 1.0.dp,
    ): CardElevation =
        CardDefaults.elevatedCardElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [CardElevation]，它将根据 [轮廓卡片] 的 Material 规范在提供的值之间进行动画过渡。
     *
     * @param 默认阴影 当 [轮廓卡片] 没有其他 [Interaction] 时使用的海拔高度。
     * @param 按下阴影 当 [轮廓卡片] 被按下时使用的海拔高度。
     * @param 聚焦阴影 当 [轮廓卡片] 被聚焦时使用的海拔高度。
     * @param 悬停阴影 当 [轮廓卡片] 被悬停时使用的海拔高度。
     * @param 拖拽阴影 当 [轮廓卡片] 被拖动时使用的海拔高度。
     * @param 禁用阴影 当 [轮廓卡片] 被禁用时使用的海拔高度。
     */
    @Composable
    fun 轮廓卡片阴影(
        默认阴影: Dp = 0.0.dp,
        按下阴影: Dp = 默认阴影,
        聚焦阴影: Dp = 默认阴影,
        悬停阴影: Dp = 默认阴影,
        拖拽阴影: Dp = 6.0.dp,
        禁用阴影: Dp = 0.0.dp,
    ): CardElevation =
        CardDefaults.outlinedCardElevation(
            defaultElevation = 默认阴影,
            pressedElevation = 按下阴影,
            focusedElevation = 聚焦阴影,
            hoveredElevation = 悬停阴影,
            draggedElevation = 拖拽阴影,
            disabledElevation = 禁用阴影,
        )

    /**
     * 创建一个 [CardColors]，表示 [卡片] 中使用的默认容器和内容颜色。
     */
    @Composable
    fun 卡片颜色集() = CardDefaults.cardColors()

    /**
     * 创建一个 [CardColors]，表示 [卡片] 中使用的默认容器和内容颜色。
     *
     * @param 容器颜色 此 [卡片] 在启用状态下的容器颜色。
     * @param 内容颜色 此 [卡片] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 此 [卡片] 在禁用状态下的容器颜色。
     * @param 禁用内容颜色 此 [卡片] 在禁用状态下的内容颜色。
     */
    @Composable
    fun 卡片颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = contentColorFor(容器颜色),
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = 内容颜色.copy(0.38f),
    ): CardColors =
        CardDefaults.cardColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /** 创建一个 [CardColors]，表示 [凸起卡片] 中使用的默认容器和内容颜色。*/
    @Composable
    fun 凸起卡片颜色集() = CardDefaults.elevatedCardColors()

    /**
     * 创建一个 [CardColors]，表示 [凸起卡片] 中使用的默认容器和内容颜色。
     *
     * @param 容器颜色 此 [凸起卡片] 在启用状态下的容器颜色。
     * @param 内容颜色 此 [凸起卡片] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 此 [凸起卡片] 在禁用状态下的容器颜色。
     * @param 禁用内容颜色 此 [凸起卡片] 在禁用状态下的内容颜色。
     */
    @Composable
    fun 凸起卡片颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = contentColorFor(容器颜色),
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = 内容颜色.copy(0.38f),
    ): CardColors =
        CardDefaults.elevatedCardColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /** 创建一个 [CardColors]，表示 [轮廓卡片] 中使用的默认容器和内容颜色。*/
    @Composable
    fun 轮廓卡片颜色集() = CardDefaults.outlinedCardColors()

    /**
     * 创建一个 [CardColors]，表示 [轮廓卡片] 中使用的默认容器和内容颜色。
     *
     * @param 容器颜色 此 [轮廓卡片] 在启用状态下的容器颜色。
     * @param 内容颜色 此 [轮廓卡片] 在启用状态下的内容颜色。
     * @param 禁用容器颜色 此 [轮廓卡片] 在禁用状态下的容器颜色。
     * @param 禁用内容颜色 此 [轮廓卡片] 在禁用状态下的内容颜色。
     */
    @Composable
    fun 轮廓卡片颜色集(
        容器颜色: Color = Color.Unspecified,
        内容颜色: Color = contentColorFor(容器颜色),
        禁用容器颜色: Color = Color.Unspecified,
        禁用内容颜色: Color = contentColorFor(容器颜色).copy(0.38f),
    ): CardColors =
        CardDefaults.outlinedCardColors(
            containerColor = 容器颜色,
            contentColor = 内容颜色,
            disabledContainerColor = 禁用容器颜色,
            disabledContentColor = 禁用内容颜色,
        )

    /**
     * 创建一个 [BorderStroke]，表示 [轮廓卡片] 中使用的默认边框。
     *
     * @param 已启动 卡片是否处于启用状态
     */
    @Composable
    fun 轮廓卡片边框(已启动: Boolean = true): BorderStroke {
        return CardDefaults.outlinedCardBorder(已启动)
    }

}


/**
 * 表示卡片在不同状态下使用的容器和内容颜色。
 *
 * @param 容器颜色 此 [卡片] 在启用状态下的容器颜色。
 * @param 内容颜色 此 [卡片] 在启用状态下的内容颜色。
 * @param 禁用容器颜色 此 [卡片] 在禁用状态下的容器颜色。
 * @param 禁用内容颜色 此 [卡片] 在禁用状态下的容器颜色。
 * @constructor 使用任意颜色创建实例。
 * - 参见 [CardDefaults.cardColors]，了解 [卡片] 使用的默认颜色。
 * - 参见 [CardDefaults.elevatedCardColors]，了解 [凸起卡片] 使用的默认颜色。
 * - 参见 [CardDefaults.outlinedCardColors]，了解 [轮廓卡片] 使用的默认颜色。
 */
@Immutable
class 卡片颜色集 // CardColors
constructor(
    val 容器颜色: Color,
    val 内容颜色: Color,
    val 禁用容器颜色: Color,
    val 禁用内容颜色: Color,
) {
    /** 返回此 [卡片颜色][CardColors] 的副本，并可选择性地覆盖某些值。此处使用 [颜色.未指定][Color.Unspecified] 来表示“使用源中的值”。*/
    fun 复制(
        容器颜色: Color = this.容器颜色,
        内容颜色: Color = this.内容颜色,
        禁用容器颜色: Color = this.禁用容器颜色,
        禁用内容颜色: Color = this.禁用内容颜色,
    ) =
        CardColors(
            容器颜色.takeOrElse { this.容器颜色 },
            内容颜色.takeOrElse { this.内容颜色 },
            禁用容器颜色.takeOrElse { this.禁用容器颜色 },
            禁用内容颜色.takeOrElse { this.禁用内容颜色 },
        )

    /**
     * 表示此卡片的容器颜色，具体取决于 [已启用] 是否为 true。
     *
     * @param 已启用 是否启用卡片。
     */
    @Stable
    internal fun 容器颜色(已启用: Boolean): Color =
        if (已启用) 容器颜色 else 禁用容器颜色

    /**
     * 表示此卡片的内容颜色，具体取决于 [已启用]。
     *
     * @param 已启用 卡片是否处于启用状态
     */
    @Stable
    internal fun 内容颜色(已启用: Boolean) =
        if (已启用) 内容颜色 else 禁用内容颜色

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is CardColors) return false

        if (容器颜色 != other.containerColor) return false
        if (内容颜色 != other.contentColor) return false
        if (禁用容器颜色 != other.disabledContainerColor) return false
        if (禁用内容颜色 != other.disabledContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = 容器颜色.hashCode()
        result = 31 * result + 内容颜色.hashCode()
        result = 31 * result + 禁用容器颜色.hashCode()
        result = 31 * result + 禁用内容颜色.hashCode()
        return result
    }
}
