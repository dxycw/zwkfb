package 安卓x.组合.材质3

import androidx.annotation.IntRange
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.DragScope
import androidx.compose.foundation.gestures.DraggableState
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderDefaults.drawStopIndicator
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.SliderState
import androidx.compose.material3.VerticalSlider
import androidx.compose.material3.rememberRangeSliderState
import androidx.compose.material3.rememberSliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlin.jvm.JvmName

/**
 * [Material Design slider](https://m3.material.io/components/sliders/overview)
 *
 * 滑块允许用户从数值范围中进行选择。
 *
 * 它使用 [SliderDefaults.Thumb] 作为滑块 thumb，使用 [SliderDefaults.Track] 作为轨道。
 *
 * 滑块沿水平条显示一个数值范围，用户可以从中选择单个值。它们非常适合调整音量、亮度或应用图像滤镜等设置。
 *
 * ![Sliders image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flqe2zb2b-1.png?alt=media)
 *
 * @param 值 滑块的当前值。如果超出所提供的 [值范围] 范围，该值将被强制约束到此范围内。
 * @param 值改变回调 用于更新数值的回调。
 * @param 修饰符 要应用于此滑块的 [Modifier]。
 * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也呈禁用状态。
 * @param 值范围 此滑块可取的数值范围。传入的 [值] 将被强制约束到此范围内。
 * @param 步数 如果为正数，则指定 [值范围] 端点之间的离散允许值数量。例如，从 0 到 10 的范围配合 4 个 [步数]，
 * 允许 4 个均匀分布在 0 和 10 之间的值（即 2、4、6、8）。如果 [步数] 为 0，滑块将表现为连续模式，允许范围内的任意值。
 * 不可为负数。
 * @param 值改变完成回调 在数值变化结束时调用。此方法不应用于更新滑块数值（请改用 [值改变回调]），
 * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
 * @param 颜色集 用于解析此滑块在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
 * @param 交互源 表示此滑块 [Interaction] 流的 [MutableInteractionSource]。您可以创建并传入自己通过
 * remember 保存的实例，以观察 [Interaction] 并在不同状态下自定义此滑块的外观/行为。
 */
@Suppress("ComposableNaming")
@Composable
fun 滑块(
    值: Float,
    值改变回调: (Float) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
    @IntRange(from = 0) 步数: Int = 0,
    值改变完成回调: (() -> Unit)? = null,
    颜色集: SliderColors = SliderDefaults.colors(),
    交互源: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Slider(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        valueRange = 值范围,
        steps = 步数,
        onValueChangeFinished = 值改变完成回调,
        colors = 颜色集,
        interactionSource = 交互源,
    )
}

/**
 * [Material Design slider](https://m3.material.io/components/sliders/overview)
 *
 * 滑块允许用户从数值范围中进行选择。
 *
 * 滑块沿水平条显示一个数值范围，用户可以从中选择单个值。它们非常适合调整音量、亮度或应用图像滤镜等设置。
 *
 * ![Sliders image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flqe2zb2b-1.png?alt=media)
 *
 * @param 值 滑块的当前值。如果超出所提供的 [值范围] 范围，该值将被强制约束到此范围内。
 * @param 值改变回调 用于更新数值的回调。
 * @param 修饰符 要应用于此滑块的 [Modifier]。
 * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
 * 同时对无障碍服务也呈禁用状态。
 * @param 值改变完成回调 在数值变化结束时调用。此方法不应用于更新滑块数值（请改用 [值改变回调]），
 * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
 * @param 颜色集 用于解析此滑块在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
 * @param 交互源 表示此滑块 [Interaction] 流的 [MutableInteractionSource]。您可以创建并传入自己通过
 * remember 保存的实例，以观察 [Interaction] 并在不同状态下自定义此滑块的外观/行为。
 * @param 步数 如果为正数，则指定 [值范围] 端点之间的离散允许值数量。例如，从 0 到 10 的范围配合 4 个 [步数]，
 * 允许 4 个均匀分布在 0 和 10 之间的值（即 2、4、6、8）。如果 [步数] 为 0，滑块将表现为连续模式，允许范围内的任意值。
 * 不可为负数。
 * @param 滑块 要显示在滑块上的滑钮（thumb），它放置在轨道上方。该 lambda 接收一个 [SliderState]，用于获取当前激活的轨道。
 * @param 轨道 要显示在滑块上的轨道，它放置在滑钮下方。该 lambda 接收一个 [SliderState]，用于获取当前激活的轨道。
 * @param 值范围 此滑块可取的数值范围。传入的 [值] 将被强制约束到此范围内。
 */
@Suppress("ComposableNaming")
@Composable
fun 滑块(
    值: Float,
    值改变回调: (Float) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    值改变完成回调: (() -> Unit)? = null,
    颜色集: SliderColors = SliderDefaults.colors(),
    交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    @IntRange(from = 0) 步数: Int = 0,
    滑块: @Composable (SliderState) -> Unit = {
        SliderDefaults.Thumb(
            interactionSource = 交互源,
            colors = 颜色集,
            enabled = 已启用,
        )
    },
    轨道: @Composable (SliderState) -> Unit = { sliderState ->
        SliderDefaults.Track(colors = 颜色集, enabled = 已启用, sliderState = sliderState)
    },
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
) {
    Slider(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        onValueChangeFinished = 值改变完成回调,
        colors = 颜色集,
        interactionSource = 交互源,
        steps = 步数,
        thumb = 滑块,
        track = 轨道,
        valueRange = 值范围,
    )
}

/**
 * [Material Design slider](https://m3.material.io/components/sliders/overview)
 *
 * 滑块允许用户从数值范围中进行选择。
 *
 * 滑块沿水平条显示一个数值范围，用户可以从中选择单个值。它们非常适合调整音量、亮度或应用图像滤镜等设置。
 *
 * ![Sliders image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flqe2zb2b-1.png?alt=media)
 *
 * @param 状态 包含滑块当前值的 [SliderState]。
 * @param 修饰符 要应用于此滑块的 [Modifier]。
 * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，同时对无障碍服务也呈禁用状态。
 * @param 颜色集 用于解析此滑块在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
 * @param 交互源 表示此滑块 [Interaction] 流的 [MutableInteractionSource]。您可以创建并传入自己通过
 * remember 保存的实例，以观察 [Interaction] 并在不同状态下自定义此滑块的外观/行为。
 * @param 滑块 要显示在滑块上的滑钮（thumb），它放置在轨道上方。该 lambda 接收一个 [SliderState]，用于获取当前激活的轨道。
 * @param 轨道 要显示在滑块上的轨道，它放置在滑钮下方。该 lambda 接收一个 [SliderState]，用于获取当前激活的轨道。
 */
@Suppress("ComposableNaming")
@Composable
fun 滑块(
    状态: SliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: SliderColors = SliderDefaults.colors(),
    交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    滑块: @Composable (SliderState) -> Unit = {
        SliderDefaults.Thumb(
            interactionSource = 交互源,
            colors = 颜色集,
            enabled = 已启用,
        )
    },
    轨道: @Composable (SliderState) -> Unit = { sliderState ->
        SliderDefaults.Track(colors = 颜色集, enabled = 已启用, sliderState = sliderState)
    },
) {
    Slider(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        interactionSource = 交互源,
        thumb = 滑块,
        track = 轨道,
    )
}

/**
 * [Material Design slider](https://m3.material.io/components/sliders/overview)
 *
 * 垂直滑块允许用户从数值范围中进行选择。
 *
 * 垂直滑块沿垂直条显示一个数值范围，用户可以从中选择单个值。它们非常适合调整音量、亮度或应用图像滤镜等设置。
 *
 * ![Sliders image](https://firebasestorage.googleapis.com/v0/b/design-spec/o/projects%2Fgoogle-material-3%2Fimages%2Flqe2zb2b-1.png?alt=media)
 *
 * @param 状态 包含滑块当前值的 [SliderState]。
 * @param 修饰符 要应用于此滑块的 [Modifier]。
 * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，同时对无障碍服务也呈禁用状态。
 * @param 反转方向 控制此滑块的方向。默认为从上到下。
 * @param 颜色集 用于解析此滑块在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
 * @param 交互源 表示此滑块 [Interaction] 流的 [MutableInteractionSource]。您可以创建并传入自己通过
 * remember 保存的实例，以观察 [Interaction] 并在不同状态下自定义此滑块的外观/行为。
 * @param 滑块 要显示在滑块上的滑钮（thumb），它放置在轨道上方。该 lambda 接收一个 [SliderState]，用于获取当前激活的轨道。
 * @param 轨道 要显示在滑块上的轨道，它放置在滑钮下方。该 lambda 接收一个 [SliderState]，用于获取当前激活的轨道。
 */
@Suppress("ComposableNaming")
@ExperimentalMaterial3ExpressiveApi
@Composable
fun 垂直滑块(
    状态: SliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    反转方向: Boolean = false,
    颜色集: SliderColors = SliderDefaults.colors(),
    交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    滑块: @Composable (SliderState) -> Unit = { sliderState ->
        SliderDefaults.Thumb(
            interactionSource = 交互源,
            sliderState = sliderState,
            colors = 颜色集,
            enabled = 已启用,
            thumbSize = VerticalThumbSize,
        )
    },
    轨道: @Composable (SliderState) -> Unit = { sliderState ->
        SliderDefaults.Track(
            colors = 颜色集,
            enabled = 已启用,
            sliderState = sliderState,
            trackCornerSize = Dp.Unspecified,
        )
    },
) {
    VerticalSlider(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        reverseDirection = 反转方向,
        colors = 颜色集,
        interactionSource = 交互源,
        thumb = 滑块,
        track = 轨道,
    )
}

/**
 * [Material Design range slider](https://m3.material.io/components/sliders/overview)
 *
 * 范围滑块在 [Slider] 的基础上使用相同的概念，但允许用户选择两个值。
 *
 * 这两个值仍然受限于数值范围，但它们也不能相互交叉。
 *
 * @param 值 范围滑块的当前值。如果任一值超出所提供的 [值范围] 范围，它将被强制约束到此范围内。
 * @param 值改变回调 用于更新数值的 lambda。
 * @param 修饰符 范围滑块布局的修饰符。
 * @param 已启用 组件是否启用以及是否可以与之交互
 * @param 值范围 范围滑块值可取的数值范围。传入的 [值] 将被强制约束到此范围内。
 * @param 步数 如果为正数，则指定 [值范围] 端点之间的离散允许值数量。例如，从 0 到 10 的范围配合 4 个 [步数]，
 * 允许 4 个均匀分布在 0 和 10 之间的值（即 2、4、6、8）。如果 [步数] 为 0，滑块将表现为连续模式，允许范围内的任意值。
 * 不可为负数。
 * @param 值改变完成回调 在数值变化结束时调用的 lambda。此回调不应用于更新范围滑块的值（请改用 [值改变回调]），
 * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
 * @param 颜色集 用于确定范围滑块各部分在不同状态下颜色的 [SliderColors]。请参阅 [SliderDefaults.colors] 进行自定义。
 */
@Suppress("ComposableNaming")
@Composable
fun 范围滑块(
    值: ClosedFloatingPointRange<Float>,
    值改变回调: (ClosedFloatingPointRange<Float>) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
    @IntRange(from = 0) 步数: Int = 0,
    值改变完成回调: (() -> Unit)? = null,
    颜色集: SliderColors = SliderDefaults.colors(),
) {
    RangeSlider(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        valueRange = 值范围,
        steps = 步数,
        onValueChangeFinished = 值改变完成回调,
        colors = 颜色集,
    )
}

/**
 * [Material Design range slider](https://m3.material.io/components/sliders/overview)
 *
 * 范围滑块在 [Slider] 的基础上使用相同的概念，但允许用户选择两个值。
 *
 * 这两个值仍然受限于数值范围，但它们也不能相互交叉。
 *
 * 它使用提供的 开始滑块 作为滑块的起始滑钮，使用 结束滑块 作为结束滑钮。它还使用提供的 轨道 作为滑块的轨道。
 * 如果未传入这些参数，则滑钮和轨道将分别使用 [SliderDefaults.Thumb] 和 [SliderDefaults.Track]。
 *
 * @param 值 范围滑块的当前值。如果任一值超出所提供的 [值范围] 范围，它将被强制约束到此范围内。
 * @param 值改变回调 用于更新数值的 lambda。
 * @param 修饰符 范围滑块布局的修饰符。
 * @param 已启用 组件是否启用以及是否可以与之交互
 * @param 值改变完成回调 在数值变化结束时调用的 lambda。此回调不应用于更新范围滑块的值（请改用 [值改变回调]），
 * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
 * @param 颜色集 用于确定范围滑块各部分在不同状态下颜色的 [SliderColors]。请参阅 [SliderDefaults.colors] 进行自定义。
 * @param 开始起始交互源 表示起始滑钮 [Interaction] 流的 [MutableInteractionSource]。您可以创建并传入自己通过 remember 保存的实例进行观察。
 * @param 结束起始交互源 表示结束滑钮 [Interaction] 流的 [MutableInteractionSource]。您可以创建并传入自己通过 remember 保存的实例进行观察。
 * @param 步数 如果为正数，则指定 [值范围] 端点之间的离散允许值数量。例如，从 0 到 10 的范围配合 4 个 [步数]，
 * 允许 4 个均匀分布在 0 和 10 之间的值（即 2、4、6、8）。如果 [步数] 为 0，滑块将表现为连续模式，允许范围内的任意值。
 * 不可为负数。
 * @param 开始滑块 要显示在范围滑块上的起始滑钮。该 lambda 接收一个 [RangeSliderState]，用于获取当前激活的轨道。
 * @param 结束滑块 要显示在范围滑块上的结束滑钮。该 lambda 接收一个 [RangeSliderState]，用于获取当前激活的轨道。
 * @param 轨道 要显示在范围滑块上的轨道，它放置在滑钮下方。该 lambda 接收一个 [RangeSliderState]，用于获取当前激活的轨道。
 * @param 值范围 范围滑块值可取的数值范围。传入的 [值] 将被强制约束到此范围内。
 */
@Suppress("ComposableNaming")
@Composable
fun 范围滑块(
    值: ClosedFloatingPointRange<Float>,
    值改变回调: (ClosedFloatingPointRange<Float>) -> Unit,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
    值改变完成回调: (() -> Unit)? = null,
    颜色集: SliderColors = SliderDefaults.colors(),
    开始起始交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    结束起始交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    开始滑块: @Composable (RangeSliderState) -> Unit = {
        SliderDefaults.Thumb(
            interactionSource = 开始起始交互源,
            colors = 颜色集,
            enabled = 已启用,
        )
    },
    结束滑块: @Composable (RangeSliderState) -> Unit = {
        SliderDefaults.Thumb(
            interactionSource = 结束起始交互源,
            colors = 颜色集,
            enabled = 已启用,
        )
    },
    轨道: @Composable (RangeSliderState) -> Unit = { rangeSliderState ->
        SliderDefaults.Track(
            colors = 颜色集,
            enabled = 已启用,
            rangeSliderState = rangeSliderState,
        )
    },
    @IntRange(from = 0) 步数: Int = 0,
) {
    RangeSlider(
        value = 值,
        onValueChange = 值改变回调,
        modifier = 修饰符,
        enabled = 已启用,
        valueRange = 值范围,
        onValueChangeFinished = 值改变完成回调,
        colors = 颜色集,
        startInteractionSource = 开始起始交互源,
        endInteractionSource = 结束起始交互源,
        startThumb = 开始滑块,
        endThumb = 结束滑块,
        track = 轨道,
        steps = 步数,
    )
}

/**
 * [Material Design range slider](https://m3.material.io/components/sliders/overview)
 *
 * 范围滑块在 [Slider] 的基础上使用相同的概念，但允许用户选择两个值。
 *
 * 这两个值仍然受限于数值范围，但它们也不能相互交叉。
 *
 * 它使用提供的 开始滑块 作为滑块的起始滑钮，使用 结束滑块 作为结束滑钮。它还使用提供的 轨道 作为滑块的轨道。
 * 如果未传入这些参数，则滑钮和轨道将分别使用 [SliderDefaults.Thumb] 和 [SliderDefaults.Track]。
 *
 * @param 状态 包含范围滑块当前值的 [RangeSliderState]。
 * @param 修饰符 范围滑块布局的修饰符。
 * @param 已启用 组件是否启用以及是否可以与之交互
 * @param 颜色集 用于确定范围滑块各部分在不同状态下颜色的 [SliderColors]。请参阅 [SliderDefaults.colors] 进行自定义。
 * @param 开始起始交互源 表示起始滑钮 [Interaction] 流的 [MutableInteractionSource]。您可以创建并传入自己通过
 * remember 保存的实例进行观察。
 * @param 结束起始交互源 表示结束滑钮 [Interaction] 流的 [MutableInteractionSource]。您可以创建并传入自己通过
 * remember 保存的实例进行观察。
 * @param 开始滑块 要显示在范围滑块上的起始滑钮。该 lambda 接收一个 [RangeSliderState]，用于获取当前激活的轨道。
 * @param 结束滑块 要显示在范围滑块上的结束滑钮。该 lambda 接收一个 [RangeSliderState]，用于获取当前激活的轨道。
 * @param 轨道 要显示在范围滑块上的轨道，它放置在滑钮下方。该 lambda 接收一个 [RangeSliderState]，用于获取当前激活的轨道。
 */
@Suppress("ComposableNaming")
@Composable
fun 范围滑块(
    状态: RangeSliderState,
    修饰符: Modifier = Modifier,
    已启用: Boolean = true,
    颜色集: SliderColors = SliderDefaults.colors(),
    开始起始交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    结束起始交互源: MutableInteractionSource = remember { MutableInteractionSource() },
    开始滑块: @Composable (RangeSliderState) -> Unit = {
        SliderDefaults.Thumb(
            interactionSource = 开始起始交互源,
            colors = 颜色集,
            enabled = 已启用,
        )
    },
    结束滑块: @Composable (RangeSliderState) -> Unit = {
        SliderDefaults.Thumb(
            interactionSource = 结束起始交互源,
            colors = 颜色集,
            enabled = 已启用,
        )
    },
    轨道: @Composable (RangeSliderState) -> Unit = { rangeSliderState ->
        SliderDefaults.Track(
            colors = 颜色集,
            enabled = 已启用,
            rangeSliderState = rangeSliderState,
        )
    },
) {
    RangeSlider(
        state = 状态,
        modifier = 修饰符,
        enabled = 已启用,
        colors = 颜色集,
        startInteractionSource = 开始起始交互源,
        endInteractionSource = 结束起始交互源,
        startThumb = 开始滑块,
        endThumb = 结束滑块,
        track = 轨道,
    )
}


/** 用于存放 [Slider] 默认值的单例对象 */
@Stable
object 滑块默认值 { // SliderDefaults

    /** 创建一个 [SliderColors]，用于表示 [Slider] 各部分在不同状态下使用的不同颜色。*/
    @Composable
    fun 颜色集() = SliderDefaults.colors()

    /**
     * 创建一个 [SliderColors]，用于表示 [Slider] 各部分在不同状态下使用的不同颜色。
     *
     * 以下名称引用中使用了"active"（激活）和"inactive"（非激活）两个词。滑块的激活部分填充了进度，因此如果滑块的进度为
     * 100% 中的 30%，则轨道左侧（RTL 布局中为右侧）30% 的部分为激活状态，其余部分为非激活状态。
     *
     * @param 滑块颜色 启用状态下的滑钮颜色。
     * @param 激活轨道颜色 轨道"激活"部分的颜色，即滑钮前方的部分。
     * @param 激活刻度颜色 如果指定了 steps，用于在激活轨道上绘制刻度标记的颜色。
     * @param 非激活轨道颜 轨道"非激活"部分的颜色，即滑钮后方的部分。
     * @param 非激活刻度颜色 如果在滑块上指定了 steps，用于在非激活轨道上绘制刻度标记的颜色。
     * @param 禁用滑块颜色 禁用状态下的滑钮颜色。
     * @param 禁用激活轨道颜色 滑块禁用时轨道"激活"部分的颜色。
     * @param 禁用激活刻度颜色 滑块处于禁用状态且指定了 steps 时，用于在激活轨道上绘制刻度标记的颜色。
     * @param 禁用非激活轨道颜色 滑块禁用时轨道"非激活"部分的颜色。
     * @param 禁用非激活刻度颜色 滑块处于禁用状态且指定了 steps 时，用于在轨道非激活部分绘制刻度标记的颜色。
     */
    @Composable
    fun 颜色集(
        滑块颜色: Color = Color.Unspecified,
        激活轨道颜色: Color = Color.Unspecified,
        激活刻度颜色: Color = Color.Unspecified,
        非激活轨道颜: Color = Color.Unspecified,
        非激活刻度颜色: Color = Color.Unspecified,
        禁用滑块颜色: Color = Color.Unspecified,
        禁用激活轨道颜色: Color = Color.Unspecified,
        禁用激活刻度颜色: Color = Color.Unspecified,
        禁用非激活轨道颜色: Color = Color.Unspecified,
        禁用非激活刻度颜色: Color = Color.Unspecified,
    ): SliderColors =
        SliderDefaults.colors(
            thumbColor = 滑块颜色,
            activeTrackColor = 激活轨道颜色,
            activeTickColor = 激活刻度颜色,
            inactiveTrackColor = 非激活轨道颜,
            inactiveTickColor = 非激活刻度颜色,
            disabledThumbColor = 禁用滑块颜色,
            disabledActiveTrackColor = 禁用激活轨道颜色,
            disabledActiveTickColor = 禁用激活刻度颜色,
            disabledInactiveTrackColor = 禁用非激活轨道颜色,
            disabledInactiveTickColor = 禁用非激活刻度颜色,
        )



    /**
     * [Slider] 和 [RangeSlider] 的默认滑钮。
     *
     * @param 交互源 表示此滑钮 [Interaction] 流的 [MutableInteractionSource]。
     * 您可以创建并传入自己通过 remember 保存的实例进行观察。
     * @param 修饰符 要应用于滑钮的 [Modifier]。
     * @param 颜色集 用于解析此滑钮在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
     * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
     * 同时对无障碍服务也呈禁用状态。
     * @param 滑块大小 滑钮的大小。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 滑块(
        交互源: MutableInteractionSource,
        修饰符: Modifier = Modifier,
        颜色集: SliderColors = SliderDefaults.colors(),
        已启用: Boolean = true,
        滑块大小: DpSize = ThumbSize,
    ) = SliderDefaults.Thumb(
            interactionSource = 交互源,
            modifier = 修饰符,
            colors = 颜色集,
            enabled = 已启用,
            thumbSize = 滑块大小,
        )

    /**
     * [Slider]、[VerticalSlider] 和 [RangeSlider] 的默认滑钮。
     *
     * @param 交互源 表示此滑钮 [Interaction] 流的 [MutableInteractionSource]。
     * 您可以创建并传入自己通过 remember 保存的实例进行观察。
     * @param 滑块状态 用于获取当前激活轨道的 [SliderState]。
     * @param 修饰符 要应用于滑钮的 [Modifier]。
     * @param 颜色集 用于解析此滑钮在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
     * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
     * 同时对无障碍服务也呈禁用状态。
     * @param 滑块大小 滑钮的大小。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 滑块(
        交互源: MutableInteractionSource,
        滑块状态: SliderState,
        修饰符: Modifier = Modifier,
        颜色集: SliderColors = SliderDefaults.colors(),
        已启用: Boolean = true,
        滑块大小: DpSize = ThumbSize,
    ) = SliderDefaults.Thumb(
            interactionSource = 交互源,
            sliderState = 滑块状态,
            modifier = 修饰符,
            colors = 颜色集,
            enabled = 已启用,
            thumbSize = 滑块大小,
        )

    /**
     * [Slider] 和 [RangeSlider] 的默认轨道
     *
     * @param 滑块位置 用于获取当前激活轨道以及滑块为离散模式时刻度位置的 [SliderPositions]。
     * @param 修饰符 要应用于轨道的 [Modifier]。
     * @param 颜色集 用于解析此轨道在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
     * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
     * 同时对无障碍服务也呈禁用状态。
     */
    @Suppress("DEPRECATION", "ComposableNaming")
    @Composable
    @Deprecated("Use version that supports slider state")
    fun 轨道(
        滑块位置: SliderPositions,
        修饰符: Modifier = Modifier,
        颜色集: SliderColors = SliderDefaults.colors(),
        已启用: Boolean = true,
    ) = SliderDefaults.Track(
            sliderPositions = 滑块位置,
            modifier = 修饰符,
            colors = 颜色集,
            enabled = 已启用,
        )


    /**
     * [Slider] 的默认轨道
     *
     * @param 滑块状态 用于获取当前激活轨道的 [SliderState]。
     * @param 修饰符 要应用于轨道的 [Modifier]。
     * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
     * 同时对无障碍服务也呈禁用状态。
     * @param 颜色集 用于解析此轨道在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道末端绘制停止指示器的 lambda。
     * @param 绘制刻度 如果 steps 大于 0，将调用此 lambda 来绘制刻度。
     * @param 滑块与轨道间隙大小 滑钮与轨道之间的间隙大小。
     * @param 轨道内圆角大小 设置间隙时朝向滑钮一端的圆角大小。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 轨道(
        滑块状态: SliderState,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色集: SliderColors = SliderDefaults.colors(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            drawStopIndicator(
                offset = it,
                color = 颜色集.trackColor(已启用, active = true),
                size = SliderDefaults.TrackStopIndicatorSize,
            )
        },
        绘制刻度: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            drawStopIndicator(offset = offset, color = color, size = SliderDefaults.TickSize)
        },
        滑块与轨道间隙大小: Dp = ThumbTrackGapSize,
        轨道内圆角大小: Dp = TrackInsideCornerSize,
    ) {
        SliderDefaults.Track(
            sliderState = 滑块状态,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色集,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度,
            thumbTrackGapSize = 滑块与轨道间隙大小,
            trackInsideCornerSize = 轨道内圆角大小,
        )
    }

    /**
     * [Slider] 和 [VerticalSlider] 的默认轨道
     *
     * 此轨道采用不同的圆角处理方式，当滑钮靠近时圆角大小会减小。
     *
     * @param 滑块状态 用于获取当前激活轨道的 [SliderState]。
     * @param 轨道圆角大小 外部圆角大小。
     * @param 修饰符 要应用于轨道的 [Modifier]。
     * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
     * 同时对无障碍服务也呈禁用状态。
     * @param 颜色集 用于解析此轨道在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道末端绘制停止指示器的 lambda。
     * @param 绘制刻度 如果 steps 大于 0，将调用此 lambda 来绘制刻度。
     * @param 滑块与轨道间隙大小 滑钮与轨道之间的间隙大小。
     * @param 轨道内圆角大小 设置间隙时朝向滑钮一端的圆角大小。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 轨道(
        滑块状态: SliderState,
        轨道圆角大小: Dp,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色集: SliderColors = SliderDefaults.colors(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            drawStopIndicator(
                offset = it,
                color = 颜色集.trackColor(已启用, active = true),
                size = SliderDefaults.TrackStopIndicatorSize,
            )
        },
        绘制刻度: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            drawStopIndicator(offset = offset, color = color, size = SliderDefaults.TickSize)
        },
        滑块与轨道间隙大小: Dp = ThumbTrackGapSize,
        轨道内圆角大小: Dp = TrackInsideCornerSize,
    ) {
        SliderDefaults.Track(
            sliderState = 滑块状态,
            trackCornerSize = 轨道圆角大小,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色集,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度,
            thumbTrackGapSize = 滑块与轨道间隙大小,
            trackInsideCornerSize = 轨道内圆角大小,
        )
    }

    /**
     * [Slider] 和 [VerticalSlider] 的默认居中轨道。
     *
     * 此轨道从滑块的中心开始。
     *
     * @param 滑块状态 用于获取当前激活轨道的 [SliderState]。
     * @param 修饰符 要应用于轨道的 [Modifier]。
     * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
     * 同时对无障碍服务也呈禁用状态。
     * @param 颜色集 用于解析此轨道在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道起始/末端绘制停止指示器的 lambda。
     * @param 绘制刻度 如果 steps 大于 0，将调用此 lambda 来绘制刻度。
     * @param 滑块与轨道间隙大小 滑钮与轨道之间的间隙大小。
     * @param 轨道内圆角大小 设置间隙时朝向滑钮一端的圆角大小。
     * @param 轨道圆角大小 外部圆角大小。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 居中轨道(
        滑块状态: SliderState,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色集: SliderColors = SliderDefaults.colors(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            drawStopIndicator(
                offset = it,
                color = 颜色集.trackColor(已启用, active = true),
                size = SliderDefaults.TrackStopIndicatorSize,
            )
        },
        绘制刻度: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            drawStopIndicator(offset = offset, color = color, size = SliderDefaults.TickSize)
        },
        滑块与轨道间隙大小: Dp = ThumbTrackGapSize,
        轨道内圆角大小: Dp = TrackInsideCornerSize,
        轨道圆角大小: Dp = Dp.Unspecified,
    ) {
        SliderDefaults.CenteredTrack(
            sliderState = 滑块状态,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色集,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度,
            thumbTrackGapSize = 滑块与轨道间隙大小,
            trackInsideCornerSize = 轨道内圆角大小,
            trackCornerSize = 轨道圆角大小,
        )
    }

    /**
     * [RangeSlider] 的默认轨道。
     *
     * @param 范围滑块状态 用于获取当前激活轨道的 [RangeSliderState]。
     * @param 修饰符 要应用于轨道的 [Modifier]。
     * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
     * 同时对无障碍服务也呈禁用状态。
     * @param 颜色集 用于解析此轨道在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道起始/末端绘制停止指示器的 lambda。
     * @param 绘制刻度 如果 steps 大于 0，将调用此 lambda 来绘制刻度。
     * @param 滑块与轨道间隙大小 滑钮与轨道之间的间隙大小。
     * @param 轨道内圆角大小 设置间隙时朝向滑钮一端的圆角大小。
     */
    @Suppress("ComposableNaming")
    @Composable
    fun 轨道(
        范围滑块状态: RangeSliderState,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色集: SliderColors = SliderDefaults.colors(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            drawStopIndicator(
                offset = it,
                color = 颜色集.trackColor(已启用, active = true),
                size = SliderDefaults.TrackStopIndicatorSize,
            )
        },
        绘制刻度: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            drawStopIndicator(offset = offset, color = color, size = SliderDefaults.TickSize)
        },
        滑块与轨道间隙大小: Dp = ThumbTrackGapSize,
        轨道内圆角大小: Dp = TrackInsideCornerSize,
    ) {
        SliderDefaults.Track(
            rangeSliderState = 范围滑块状态,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色集,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度,
            thumbTrackGapSize = 滑块与轨道间隙大小,
            trackInsideCornerSize = 轨道内圆角大小,
        )
    }

    /**
     * [RangeSlider] 的默认轨道。
     *
     * @param 范围滑块状态 用于获取当前激活轨道的 [RangeSliderState]。
     * @param 轨道圆角大小 外部圆角大小。
     * @param 修饰符 要应用于轨道的 [Modifier]。
     * @param 已启用 控制此滑块的启用状态。当为 false 时，此组件不会响应用户输入，并且会在视觉上显示为禁用状态，
     * 同时对无障碍服务也呈禁用状态。
     * @param 颜色集 用于解析此轨道在不同状态下所使用颜色的 [SliderColors]。请参阅 [SliderDefaults.colors]。
     * @param 绘制停止指示器 用于在轨道起始/末端绘制停止指示器的 lambda。
     * @param 绘制刻度 如果 steps 大于 0，将调用此 lambda 来绘制刻度。
     * @param 滑块与轨道间隙大小 滑钮与轨道之间的间隙大小。
     * @param 轨道内圆角大小 设置间隙时朝向滑钮一端的圆角大小。
     */
    @Suppress("ComposableNaming")
    @ExperimentalMaterial3ExpressiveApi
    @Composable
    fun 轨道(
        范围滑块状态: RangeSliderState,
        轨道圆角大小: Dp,
        修饰符: Modifier = Modifier,
        已启用: Boolean = true,
        颜色集: SliderColors = SliderDefaults.colors(),
        绘制停止指示器: (DrawScope.(Offset) -> Unit)? = {
            drawStopIndicator(
                offset = it,
                color = 颜色集.trackColor(已启用, active = true),
                size = SliderDefaults.TrackStopIndicatorSize,
            )
        },
        绘制刻度: DrawScope.(Offset, Color) -> Unit = { offset, color ->
            drawStopIndicator(offset = offset, color = color, size = SliderDefaults.TickSize)
        },
        滑块与轨道间隙大小: Dp = ThumbTrackGapSize,
        轨道内圆角大小: Dp = TrackInsideCornerSize,
    ) {
        SliderDefaults.Track(
            rangeSliderState = 范围滑块状态,
            trackCornerSize = 轨道圆角大小,
            modifier = 修饰符,
            enabled = 已启用,
            colors = 颜色集,
            drawStopIndicator = 绘制停止指示器,
            drawTick = 绘制刻度,
            thumbTrackGapSize = 滑块与轨道间隙大小,
            trackInsideCornerSize = 轨道内圆角大小,
        )
    }


    /**
     * 默认停止指示器。
     *
     * @param 偏移量 指示器要绘制的坐标位置。
     * @param 大小 指示器的大小。
     * @param 颜色 指示器的颜色。
     */
    fun DrawScope.绘制停止指示器(偏移量: Offset, 大小: Dp, 颜色: Color) {
        this.drawStopIndicator(offset = 偏移量, size = 大小, color = 颜色)
    }

    /** 轨道末端停止指示器的默认大小。 */
    val 轨道停止指示器大小: Dp = SliderDefaults.TrackStopIndicatorSize

    /** 如果 steps 大于 0，刻度的默认大小。 */
    val 刻度大小: Dp = SliderDefaults.TickSize


    @Stable
    internal fun SliderColors.trackColor(已启用: Boolean, active: Boolean): Color =
        if (已启用) {
            if (active) activeTrackColor else inactiveTrackColor
        } else {
            if (active) disabledActiveTrackColor else disabledInactiveTrackColor
        }

}


/**
 * 表示 [Slider] 在不同状态下使用的颜色。
 *
 * @param 滑块颜色 启用状态下的滑钮颜色。
 * @param 激活轨道颜色 轨道"激活"部分的颜色，即滑钮前方的部分。
 * @param 激活刻度颜色 如果指定了 steps，用于在激活轨道上绘制刻度标记的颜色。
 * @param 非激活轨道颜 轨道"非激活"部分的颜色，即滑钮后方的部分。
 * @param 非激活刻度颜色 如果在滑块上指定了 steps，用于在非激活轨道上绘制刻度标记的颜色。
 * @param 禁用滑块颜色 禁用状态下的滑钮颜色。
 * @param 禁用激活轨道颜色 滑块禁用时轨道"激活"部分的颜色。
 * @param 禁用激活刻度颜色 滑块处于禁用状态且指定了 steps 时，用于在激活轨道上绘制刻度标记的颜色。
 * @param 禁用非激活轨道颜色 滑块禁用时轨道"非激活"部分的颜色。
 * @param 禁用非激活刻度颜色 滑块处于禁用状态且指定了 steps 时，用于在轨道非激活部分绘制刻度标记的颜色。
 * @constructor 使用任意颜色创建实例。请参阅 [SliderDefaults.colors] 了解遵循 Material 规范的默认实现。
 */
fun 滑块颜色集(  // SliderColors
    滑块颜色: Color,
    激活轨道颜色: Color,
    激活刻度颜色: Color,
    非激活轨道颜: Color,
    非激活刻度颜色: Color,
    禁用滑块颜色: Color,
    禁用激活轨道颜色: Color,
    禁用激活刻度颜色: Color,
    禁用非激活轨道颜色: Color,
    禁用非激活刻度颜色: Color,
) = SliderColors(
    thumbColor = 滑块颜色,
    activeTrackColor = 激活轨道颜色,
    activeTickColor = 激活刻度颜色,
    inactiveTrackColor = 非激活轨道颜,
    inactiveTickColor = 非激活刻度颜色,
    disabledThumbColor = 禁用滑块颜色,
    disabledActiveTrackColor = 禁用激活轨道颜色,
    disabledActiveTickColor = 禁用激活刻度颜色,
    disabledInactiveTrackColor = 禁用非激活轨道颜色,
    disabledInactiveTickColor = 禁用非激活刻度颜色,
)

/** 返回此 SelectableChipColors 的副本，可选择性地覆盖部分值。此处使用 Color.Unspecified 表示"使用源中的值"。*/
fun SliderColors.复制(
    滑块颜色: Color = this.thumbColor,
    激活轨道颜色: Color = this.activeTrackColor,
    激活刻度颜色: Color = this.activeTickColor,
    非激活轨道颜: Color = this.inactiveTrackColor,
    非激活刻度颜色: Color = this.inactiveTickColor,
    禁用滑块颜色: Color = this.disabledThumbColor,
    禁用激活轨道颜色: Color = this.disabledActiveTrackColor,
    禁用激活刻度颜色: Color = this.disabledActiveTickColor,
    禁用非激活轨道颜色: Color = this.disabledInactiveTrackColor,
    禁用非激活刻度颜色: Color = this.disabledInactiveTickColor,
) = this.copy(
    thumbColor = 滑块颜色,
    activeTrackColor = 激活轨道颜色,
    activeTickColor = 激活刻度颜色,
    inactiveTrackColor = 非激活轨道颜,
    inactiveTickColor = 非激活刻度颜色,
    disabledThumbColor = 禁用滑块颜色,
    disabledActiveTrackColor = 禁用激活轨道颜色,
    disabledActiveTickColor = 禁用激活刻度颜色,
    disabledInactiveTrackColor = 禁用非激活轨道颜色,
    disabledInactiveTickColor = 禁用非激活刻度颜色,
)


internal val ThumbWidth = 4.0.dp
private val ThumbHeight = 44.0.dp
private val ThumbSize = DpSize(ThumbWidth, ThumbHeight)
private val VerticalThumbSize = DpSize(ThumbHeight, ThumbWidth)
private val ThumbTrackGapSize: Dp = 6.0.dp
private val TrackInsideCornerSize: Dp = 2.dp


/** 用于保存 [Slider] 和 [RangeSlider] 的激活轨道信息，以及离散刻度应在轨道上绘制的分数位置的类。*/
@Suppress("DEPRECATION")
@Deprecated("Not necessary with the introduction of Slider state")
@Stable
class 滑块位置( // SliderPositions
    初始激活范围: ClosedFloatingPointRange<Float> = 0f..1f,
    初始刻度比例: FloatArray = floatArrayOf(),
) {

    private val _sliderPositions = SliderPositions(初始激活范围, 初始刻度比例)

    /**
     * 表示当前激活范围的 [ClosedFloatingPointRange]，对于 [Slider] 是从起始位置到滑钮，对于 [RangeSlider] 是从起始滑钮到结束滑钮。
     */
    var 激活范围: ClosedFloatingPointRange<Float> = _sliderPositions.activeRange
        internal set

    /**
     * 刻度应在轨道上绘制的离散点。刻度比例 的每个值应在 [0f, 1f] 范围内。如果轨道是连续的，则 tickFractions 将为空的 [FloatArray]。
     */
    var 刻度比例: FloatArray = _sliderPositions.tickFractions
        internal set

    override fun equals(other: Any?): Boolean {
        return _sliderPositions.equals(other)
    }

    override fun hashCode(): Int {
        return _sliderPositions.hashCode()
    }

}


/**
 * 用于保存 [Slider] 激活范围信息的类。
 *
 * @param 值 表示滑钮初始位置的 [Float]。如果超出所提供的 [值范围] 范围，该值将被强制约束到此范围内。
 * @param 步数 如果为正数，则指定 [值范围] 端点之间的离散允许值数量。例如，从 0 到 10 的范围配合 4 个 [步数]，
 * 允许 4 个均匀分布在 0 和 10 之间的值（即 2、4、6、8）。如果 [步数] 为 0，滑块将表现为连续模式，允许范围内的任意值。
 * 不可为负数。
 * @param 值改变完成回调 在数值变化结束时调用的 lambda。此回调不应用于更新范围滑块的值（请改用 [onValueChange]），
 * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
 * @param 值范围 滑块值可取的数值范围。[值] 将被强制约束到此范围内。
 */
class 滑块状态(  // SliderState
    值: Float = 0f,
    @field:IntRange(from = 0) val 步数: Int = 0,
    var 值改变完成回调: (() -> Unit)? = null,
    val 值范围: ClosedFloatingPointRange<Float> = 0f..1f,
) : DraggableState {

    private val _sliderState = SliderState(
        值, 步数, 值改变完成回调, 值范围)

    /** 表示滑钮当前相对于轨道所处位置的值的 [Float]。 */
    var 值: Float
        set(newVal) {
            _sliderState.value = newVal
        }
        get() = _sliderState.value

    override suspend fun drag(
        dragPriority: MutatePriority,
        block: suspend DragScope.() -> Unit,
    ): Unit = _sliderState.drag(dragPriority, block)


    override fun dispatchRawDelta(delta: Float) {
        _sliderState.dispatchRawDelta(delta)
    }

    /** 用于更新数值的回调。 */
    var 值改变回调: ((Float) -> Unit)? = _sliderState.onValueChange

    /** 控制自动吸附机制，禁用它可能对自定义动画有用。 */
    @get:JvmName("shouldAutoSnap")
    var 是否自动吸附: Boolean = _sliderState.shouldAutoSnap

    /** 滑钮当前所处轨道的分数位置。 */
    val 强制约束值分数: Float
        get() = _sliderState.coercedValueAsFraction

    var 是否正在拖动 = _sliderState.isDragging
        private set

    companion object {
        /**
         * [SliderState] 的默认 [保存器] 实现。
         *
         * @param 值改变完成回调 在数值变化结束时调用的 lambda。此回调不应用于更新范围滑块的值（请改用 [值改变回调]），
         * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
         * @param 值范围 滑块值可取的数值范围。[值] 将被强制约束到此范围内。
         */
        fun 保存器(
            值改变完成回调: (() -> Unit)?,
            值范围: ClosedFloatingPointRange<Float>,
        ): Saver<SliderState, *> =
            SliderState.Saver(
                onValueChangeFinished = 值改变完成回调,
                valueRange = 值范围,
            )
    }

}

/**
 * 创建一个在重组之间被记住的 [SliderState]。
 *
 * 如果状态已经创建，所提供的初始值发生变化不会导致状态以任何方式被重新创建或更改。
 *
 * @param 值 表示滑钮初始位置的 [Float]。如果超出所提供的 [值范围] 范围，该值将被强制约束到此范围内。
 * @param 步数 如果为正数，则指定 [值范围] 端点之间的离散允许值数量。例如，从 0 到 10 的范围配合 4 个 [步数]，
 * 允许 4 个均匀分布在 0 和 10 之间的值（即 2、4、6、8）。如果 [步数] 为 0，滑块将表现为连续模式，允许范围内的任意值。
 * 不可为负数。
 * @param 值改变完成回调 在数值变化结束时调用的 lambda。此回调不应用于更新范围滑块的值（请改用 [SliderState.onValueChange]），
 * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
 * @param 值范围 滑块值可取的数值范围。[值] 将被强制约束到此范围内。
 */
@Composable
fun 记住滑块状态(
    值: Float = 0f,
    @IntRange(from = 0) 步数: Int = 0,
    值改变完成回调: (() -> Unit)? = null,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
): SliderState =
    rememberSliderState(
        value = 值,
        steps = 步数,
        onValueChangeFinished = 值改变完成回调,
        valueRange = 值范围,
    )


/**
 * 用于保存 [RangeSlider] 激活范围信息的类。
 *
 * @param 激活范围开始 表示滑块激活范围初始起始位置的 [Float]。如果超出所提供的 [值范围] 范围，
 * 该值将被强制约束到此范围内。
 * @param 激活范围结束 表示滑块激活范围初始结束位置的 [Float]。如果超出所提供的 [值范围] 范围，
 * 该值将被强制约束到此范围内。
 * @param 步数 如果为正数，则指定 [值范围] 端点之间的离散允许值数量。例如，从 0 到 10 的范围配合 4 个 [步数]，
 * 允许 4 个均匀分布在 0 和 10 之间的值（即 2、4、6、8）。如果 [步数] 为 0，滑块将表现为连续模式，允许范围内的任意值。
 * 不可为负数。
 * @param 值改变完成回调 在数值变化结束时调用的 lambda。此回调不应用于更新范围滑块的值（请改用 [SliderState.onValueChange]），
 * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
 * @param 值范围 范围滑块值可取的数值范围。[激活范围开始] 和 [激活范围结束] 将被强制约束到此范围内。
 */
class 范围滑块状态( // RangeSliderState
    激活范围开始: Float = 0f,
    激活范围结束: Float = 1f,
    @field:IntRange(from = 0) val 步数: Int = 0,
    var 值改变完成回调: (() -> Unit)? = null,
    val 值范围: ClosedFloatingPointRange<Float> = 0f..1f,
) {

    private val _rangeSliderState = RangeSliderState(
        激活范围开始, 激活范围结束, 步数,
        值改变完成回调, 值范围)

    /** 表示 [RangeSlider] 当前激活范围起始位置的 [Float]。 */
    var 激活范围开始: Float
        set(newVal) {
            _rangeSliderState.activeRangeStart = newVal
        }
        get() = _rangeSliderState.activeRangeStart

    /** 表示 [RangeSlider] 当前激活范围结束位置的 [Float]。 */
    var 激活范围结束: Float
        set(newVal) {
            _rangeSliderState.activeRangeEnd = newVal
        }
        get() = _rangeSliderState.activeRangeEnd

    companion object {

        /**
         * [RangeSliderState] 的默认 [保存器] 实现。
         *
         * @param 值改变完成回调 在数值变化结束时调用的 lambda。此回调不应用于更新范围滑块的值（请改用 [值改变回调]），
         *   而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
         * @param 值范围 范围滑块值可取的数值范围。[激活范围开始] 和 [激活范围结束] 将被强制约束到此范围内。
         */
        fun 保存器(
            值改变完成回调: (() -> Unit)?,
            值范围: ClosedFloatingPointRange<Float>,
        ): Saver<RangeSliderState, *> =
            RangeSliderState.Saver(
                onValueChangeFinished = 值改变完成回调,
                valueRange = 值范围
            )

    }

}

/**
 * 创建一个在重组之间被记住的 [SliderState]。
 *
 * 如果状态已经创建，所提供的初始值发生变化不会导致状态以任何方式被重新创建或更改。
 *
 * @param 激活范围开始 表示滑钮初始位置的 [Float]。如果超出所提供的 [值范围] 范围，该值将被强制约束到此范围内。
 * @param 激活范围结束 表示滑块激活范围初始结束位置的 [Float]。如果超出所提供的 [值范围] 范围，该值将被强制约束到此范围内。
 * @param 步数 如果为正数，则指定 [值范围] 端点之间的离散允许值数量。例如，从 0 到 10 的范围配合 4 个 [步数]，
 * 允许 4 个均匀分布在 0 和 10 之间的值（即 2、4、6、8）。如果 [步数] 为 0，滑块将表现为连续模式，允许范围内的任意值。不可为负数。
 * @param 值改变完成回调 在数值变化结束时调用的 lambda。此回调不应用于更新范围滑块的值（请改用 [SliderState.onValueChange]），
 * 而是用于获知用户何时通过结束拖动或点击完成了新值的选择。
 * @param 值范围 范围滑块值可取的数值范围。[激活范围开始] 和 [激活范围结束] 将被强制约束到此范围内。
 */
@Composable
fun 记住范围滑块状态(
    激活范围开始: Float = 0f,
    激活范围结束: Float = 1f,
    @IntRange(from = 0) 步数: Int = 0,
    值改变完成回调: (() -> Unit)? = null,
    值范围: ClosedFloatingPointRange<Float> = 0f..1f,
): RangeSliderState =
     rememberRangeSliderState(
        activeRangeStart = 激活范围开始,
        activeRangeEnd = 激活范围结束,
        steps = 步数,
        onValueChangeFinished = 值改变完成回调,
        valueRange = 值范围,
    )

