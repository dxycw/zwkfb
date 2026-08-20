package 安卓x.组合.材质3

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.DragHandleColors
import androidx.compose.material3.DragHandleShapes
import androidx.compose.material3.DragHandleSizes
import androidx.compose.material3.VerticalDragHandle
import androidx.compose.material3.VerticalDragHandleDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.DpSize


/**
 * [Material Design drag
 * handle](https://m3.material.io/foundations/layout/understanding-layout/parts-of-layout#314a4c32-be52-414c-8da7-31f059f1776d)
 *
 * 拖拽手柄是一种胶囊状的形状，用户可以通过拖拽它来更改组件的大小和/或位置。它的一个典型用途是窗格扩展——当你将屏幕分割成多
 * 个窗格时，建议使用拖拽手柄，以便用户可以通过拖拽它来更改屏幕分割的比例。请注意，垂直方向的拖拽手柄用于表示水平拖拽动作。
 *
 * @param 修饰符 要应用于此拖拽手柄的 [Modifier]。
 * @param 大小集 此拖拽手柄的尺寸；默认值请参阅 [VerticalDragHandleDefaults.sizes]。
 * @param 颜色集 此拖拽手柄的颜色；默认值请参阅 [VerticalDragHandleDefaults.colors]。
 * @param 形状集 此拖拽手柄的形状；默认值请参阅 [VerticalDragHandleDefaults.colors]。
 * @param 交互源 一个可选的提升式 [MutableInteractionSource]，用于观察和发送此拖拽手柄的 [Interaction]。
 * 你可以使用它来更改拖拽手柄的外观，或在不同状态下预览拖拽手柄。请注意，如果提供了 `null`，交互仍会在内部发生。
 */
@Suppress("ComposableNaming")
@Composable
fun 垂直拖拽手柄(
    修饰符: Modifier = Modifier,
    大小集: DragHandleSizes = VerticalDragHandleDefaults.sizes(),
    颜色集: DragHandleColors = VerticalDragHandleDefaults.colors(),
    形状集: DragHandleShapes = VerticalDragHandleDefaults.shapes(),
    交互源: MutableInteractionSource? = null,
) =
    VerticalDragHandle(
        modifier = 修饰符,
        sizes = 大小集,
        colors = 颜色集,
        shapes = 形状集,
        interactionSource = 交互源,
    )

//=================================================================================

/**
 * 指定拖拽手柄在不同状态下使用的颜色。
 *
 * @param 颜色 拖拽手柄在未被按下时的默认颜色。
 * @param 按压颜色 拖拽手柄在被按下但未被拖拽时的颜色，默认情况下与 [拖拽颜色] 相同。
 * @param 拖拽颜色 拖拽手柄在被拖拽时的颜色。
 */
fun 拖拽手柄颜色集(
    颜色: Color,
    按压颜色: Color,
    拖拽颜色: Color
) =
    DragHandleColors(
        color = 颜色,
        pressedColor = 按压颜色,
        draggedColor = 拖拽颜色
    )


val DragHandleColors.颜色: Color
    get() = this.color

val DragHandleColors.按压颜色: Color
    get() = this.pressedColor

val DragHandleColors.拖拽颜色: Color
    get() = this.draggedColor

//=================================================================================

/**
 * 指定拖拽手柄在不同状态下使用的形状。
 *
 * @param 形状 拖拽手柄在未被按下时的默认形状。
 * @param 按压形状 拖拽手柄在被按下但未被拖拽时的形状，默认情况下与 [拖拽形状] 相同。
 * @param 拖拽形状 拖拽手柄在被拖拽时的形状。
 */
fun 拖拽手柄形状集(
    形状: Shape,
    按压形状: Shape,
    拖拽形状: Shape
) =
    DragHandleShapes(
        shape = 形状,
        pressedShape = 按压形状,
        draggedShape = 拖拽形状
    )


val DragHandleShapes.形状: Shape
    get() = this.shape

val DragHandleShapes.按压形状: Shape
    get() = this.pressedShape

val DragHandleShapes.拖拽形状: Shape
    get() = this.draggedShape

//=================================================================================

/**
 * 指定拖拽手柄在不同状态下使用的尺寸。
 *
 * @param 大小 拖拽手柄在未被按下时的默认尺寸。
 * @param 按压大小 拖拽手柄在被按下但未被拖拽时的尺寸，默认情况下与 [拖拽大小] 相同。
 * @param 拖拽大小 拖拽手柄在被拖拽时的尺寸。
 */
fun 拖拽手柄大小集(
    大小: DpSize,
    按压大小: DpSize,
    拖拽大小: DpSize
) =
    DragHandleSizes(
        size = 大小,
        pressedSize = 按压大小,
        draggedSize = 拖拽大小
    )


val DragHandleSizes.大小: DpSize
    get() = this.size

val DragHandleSizes.按压大小: DpSize
    get() = this.pressedSize

val DragHandleSizes.拖拽大小: DpSize
    get() = this.draggedSize

//=================================================================================

/** 包含 [VerticalDragHandle] 所使用的基准值。 */
object 垂直拖拽手柄默认值 { // VerticalDragHandleDefaults

    /** 创建一个 [DragHandleColors]，表示 [VerticalDragHandle] 在默认、按下和拖拽状态下所使用的颜色。*/
    @Composable fun 颜色集(): DragHandleColors = VerticalDragHandleDefaults.colors()

    /**
     * 创建一个 [DragHandleColors]，表示 [VerticalDragHandle] 在默认、按下和拖拽状态下所使用的颜色。
     *
     * @param 颜色 提供一个不同的颜色，以覆盖拖拽手柄在未被按下时的默认颜色。
     * @param 按压颜色 提供一个不同的颜色，以覆盖拖拽手柄在被按下但未被拖拽时的颜色。
     * @param 拖拽颜色 提供一个不同的颜色，以覆盖拖拽手柄在被拖拽时的颜色。
     */
    @Composable
    fun 颜色集(
        颜色: Color = Color.Unspecified,
        按压颜色: Color = Color.Unspecified,
        拖拽颜色: Color = Color.Unspecified,
    ): DragHandleColors =
        VerticalDragHandleDefaults.colors(
            color = 颜色,
            pressedColor = 按压颜色,
            draggedColor = 拖拽颜色,
        )


    /** 创建一个 [DragHandleShapes]，表示 [VerticalDragHandle] 在默认、按下和拖拽状态下所使用的形状。*/
    @Composable fun 形状集(): DragHandleShapes = VerticalDragHandleDefaults.shapes()

    /**
     * 创建一个 [DragHandleShapes]，表示 [VerticalDragHandle] 在默认、按下和拖拽状态下所使用的形状。
     *
     * @param 形状 提供一个不同的形状，以覆盖拖拽手柄在未被按下时的默认形状。
     * @param 按压形状 提供一个不同的形状，以覆盖拖拽手柄在被按下但未被拖拽时的形状。
     * @param 拖拽形状 提供一个不同的形状，以覆盖拖拽手柄在被拖拽时的形状。
     */
    @Composable
    fun 形状集(
        形状: Shape? = null,
        按压形状: Shape? = null,
        拖拽形状: Shape? = null,
    ): DragHandleShapes =
        VerticalDragHandleDefaults.shapes(
            shape = 形状,
            pressedShape = 按压形状,
            draggedShape = 拖拽形状,
        )


    /** 创建一个 [DragHandleSizes]，表示 [VerticalDragHandle] 在默认、按下和拖拽状态下所使用的尺寸。*/
    fun 大小集(): DragHandleSizes = VerticalDragHandleDefaults.sizes()

    /**
     * 创建一个 [DragHandleSizes]，表示 [VerticalDragHandle] 在默认、按下和拖拽状态下所使用的尺寸。
     *
     * @param 大小 提供一个不同的尺寸，以覆盖拖拽手柄在未被按下时的默认尺寸。
     * @param 按压大小 提供一个不同的尺寸，以覆盖拖拽手柄在被按下但未被拖拽时的尺寸。
     * @param 拖拽大小 提供一个不同的尺寸，以覆盖拖拽手柄在被拖拽时的尺寸。
     */
    fun 大小集(
        大小: DpSize = DpSize.Unspecified,
        按压大小: DpSize = DpSize.Unspecified,
        拖拽大小: DpSize = DpSize.Unspecified,
    ): DragHandleSizes =
        VerticalDragHandleDefaults.sizes(
            size = 大小,
            pressedSize = 按压大小,
            draggedSize = 拖拽大小,
        )

}

