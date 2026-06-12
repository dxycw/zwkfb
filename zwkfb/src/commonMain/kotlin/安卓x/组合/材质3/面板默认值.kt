package 安卓x.组合.材质3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomSheet
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CancellationException

/**
 * [Material Design bottom sheet](https://m3.material.io/components/bottom-sheets/overview)
 *
 * 模态底部面板用作移动设备上内联菜单或简单对话框的替代方案，尤其适用于提供一长串操作项，或当各项需要更长的描述和图标时。
 *
 * 该组件为底部面板提供视觉表面和手势行为。关键的是，它直接在组合层级（主 UI 树）中渲染，不像 [模态底部面板]
 * 那样启动一个单独的 [androidx.compose.ui.window.Dialog] 窗口。
 *
 * 由于该组件存在于主 UI 树中：
 * - 它按照在布局中的位置（例如在 [Box] 内部）所确定的 Z 轴索引进行绘制。
 * - 它不会自动提供遮罩层（scrim），也不会阻止与屏幕其余部分的交互。
 * - 它与父级可组合项共享相同的生命周期和输入处理。
 *
 * 当构建自定义面板体验且不希望使用 [androidx.compose.ui.window.Dialog] 窗口，或需要自定义的
 * [androidx.compose.ui.window.Dialog] 时，请使用此组件。
 *
 * 如需一个自动处理 Dialog 窗口、遮罩层和焦点管理的模态底部面板，请使用 [模态底部面板]。
 *
 * 如需一个结构上集成到屏幕布局中的常驻底部面板，请使用 [底部面板脚手架]。
 *
 * 以下示例展示了该组件如何与您的 UI 配合使用。
 *
 * @param 修饰符 应用于底部面板的修饰符。
 * @param 状态 管理面板状态值和偏移量的状态对象。
 * @param 关闭请求回调 当面板被滑动至 [SheetValue.Hidden] 状态时调用的可选回调。
 * @param 最大宽度 [Dp] 值，定义面板将占用的最大宽度。传入 [Dp.Unspecified] 可使面板横跨整个屏幕宽度。
 * @param 手势已启用 是否启用手势。
 * @param 返回处理已启用 是否启用通过返回键关闭和预测性返回行为。
 * @param 拖拽手柄 可选的视觉标记，用于指示面板可拖拽。
 * @param 内容窗口插入 要应用于内容的窗口边衬区。
 * @param 形状 底部面板的形状。
 * @param 容器颜色 底部面板的背景颜色。
 * @param 内容颜色 首选的内容颜色。
 * @param 色调阴影 底部面板的色调高度。
 * @param 视觉阴影 底部面板的阴影高度。
 * @param 内容 面板的内容。
 */
@Suppress("ComposableNaming")
@Composable
@ExperimentalMaterial3Api
fun 底部面板(
    修饰符: Modifier = Modifier,
    状态: SheetState = rememberModalBottomSheetState(),
    关闭请求回调: () -> Unit = {},
    最大宽度: Dp = BottomSheetDefaults.SheetMaxWidth,
    手势已启用: Boolean = true,
    返回处理已启用: Boolean = true,
    拖拽手柄: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    内容窗口插入: @Composable () -> WindowInsets = {
        BottomSheetDefaults.standardWindowInsets
    },
    形状: Shape = BottomSheetDefaults.ExpandedShape,
    容器颜色: Color = BottomSheetDefaults.ContainerColor,
    内容颜色: Color = contentColorFor(容器颜色),
    色调阴影: Dp = BottomSheetDefaults.Elevation,
    视觉阴影: Dp = 0.dp,
    内容: @Composable ColumnScope.() -> Unit,
) {
    BottomSheet(
        modifier = 修饰符,
        state = 状态,
        onDismissRequest = 关闭请求回调,
        maxWidth = 最大宽度,
        gesturesEnabled = 手势已启用,
        backHandlerEnabled = 返回处理已启用,
        dragHandle = 拖拽手柄,
        contentWindowInsets = 内容窗口插入,
        shape = 形状,
        containerColor = 容器颜色,
        contentColor = 内容颜色,
        tonalElevation = 色调阴影,
        shadowElevation = 视觉阴影,
        content = 内容,
    )
}

/**
 * 底部面板可组合项的状态，例如 [模态底部面板]。
 *
 * 包含与其滑动位置以及状态值之间动画相关的状态。
 *
 * @param 跳过部分展开 如果面板足够大，是否应跳过部分展开状态。如果为 `true`，面板将始终展开至 [SheetValue.Expanded] 状态，
 * 并在隐藏面板时（无论是通过编程方式还是用户交互）移至 [SheetValue.Hidden] 状态（如果可用）。
 * @param 位置阈值 位置阈值，以像素为单位，用于在拖拽过程中以及拖拽结束后计算目标状态。这是从过渡起点开始的距离。
 * 根据交互方向的不同，它将被加到原点偏移量上或从原点偏移量中减去。该值应始终为正数。
 * @param 速度阈值 速度阈值（以像素/秒为单位），末端速度必须超过该值才能动画过渡到下一个状态，即使尚未达到 [位置阈值]。
 * @param 初始值 状态的初始值。
 * @param 确定值改变 可选的回调，用于确认或否决待处理的状态变更。
 * @param 跳过隐藏状态 是否应跳过隐藏状态。如果为 `true`，面板将始终展开至 [SheetValue.Expanded] 状态，并在隐藏时移至 [SheetValue.PartiallyExpanded]
 * 状态（如果可用），无论是通过编程方式还是用户交互。
 */
@Stable
@ExperimentalMaterial3Api
fun 面板状态( // SheetState
    跳过部分展开: Boolean,
    位置阈值: () -> Float,
    速度阈值: () -> Float,
    初始值: SheetValue = SheetValue.Hidden,
    确定值改变: (SheetValue) -> Boolean = { true },
    跳过隐藏状态: Boolean = false,
) {
    SheetState(
        skipPartiallyExpanded = 跳过部分展开,
        positionalThreshold = 位置阈值,
        velocityThreshold = 速度阈值,
        initialValue = 初始值,
        confirmValueChange = 确定值改变,
        skipHiddenState = 跳过隐藏状态,
    )
}


/**
 * 状态的当前值。
 *
 * 如果没有正在进行的滑动或动画，这对应于底部面板当前所处的状态。如果滑动或动画正在进行中，这对应于滑动或动画开始前面板所处的状态。
 */
@ExperimentalMaterial3Api
val SheetState.当前值: SheetValue
    // 注意：当前值映射到新引入的 settled 值，以实现与内部分支大致类似的行为。anchoredDraggableState.currentValue
    // 现在映射到触摸目标最接近的值，无论是否已释放/正在稳定。
    get() = this.currentValue


// TODO(b/477969920): 当基础依赖项更新时，移除分支的目标值逻辑。
/**
 * 底部面板状态的目标值。
 *
 * 如果滑动正在进行中，这是滑动结束时面板将动画过渡到的值。如果动画正在运行，这是该动画的目标值。最后，如果没有正在进行的滑动或动画，
 * 则与 [当前值] 相同。
 */
@ExperimentalMaterial3Api
val SheetState.目标值: SheetValue
    get() = this.targetValue


/** 模态底部面板是否可见。 */
@ExperimentalMaterial3Api
val SheetState.是否可见: Boolean
    get() = this.isVisible

/**
 * 底部面板的展开或折叠动画当前是否正在进行中。
 *
 * 有关更多信息，请参阅 [SheetState.expand]、[SheetState.partialExpand]、[SheetState.show] 或 [SheetState.hide]。
 */
@ExperimentalMaterial3Api
val SheetState.是否动画正在运行: Boolean
    get() = this.isAnimationRunning

/**
 * 获取底部面板当前的偏移量（以像素为单位）。
 *
 * 偏移量将在所提供面板内容的首次测量阶段进行初始化。
 *
 * 这些阶段为：组合 { -> 副作用 } -> 布局 { 测量 -> 放置 } -> 绘制
 *
 * 在首次组合期间，会抛出 [IllegalStateException]。在后续的组合中，偏移量将根据上一轮的锚点计算得出。
 * 始终建议从 LaunchedEffect 中访问偏移量，因为它将被安排在下一帧布局完成后执行。
 *
 * @throws IllegalStateException 如果偏移量尚未初始化
 */
@ExperimentalMaterial3Api
fun SheetState.要求偏移量(): Float = this.requireOffset()

/** 面板是否定义了展开状态。 */
@ExperimentalMaterial3Api
val SheetState.是否有展开状态: Boolean
    get() = this.hasExpandedState

/** 模态底部面板是否定义了部分展开状态。 */
@ExperimentalMaterial3Api
val SheetState.是否有部分展开状态: Boolean
    get() = this.hasPartiallyExpandedState

/**
 * 如果 [confirmValueChange] 返回 true，则以动画方式完全展开底部面板，并挂起直到面板完全展开或动画被取消。
 *
 * @throws [CancellationException] 如果动画被中断
 */
@ExperimentalMaterial3Api
suspend fun SheetState.展开() {
    this.expand()
}

/**
 * 如果 [confirmValueChange] 返回 true，则以动画方式展开底部面板，并挂起直到面板部分展开或动画被取消。
 *
 * @throws [CancellationException] 如果动画被中断
 * @throws [IllegalStateException] 如果 [skipPartiallyExpanded] 设置为 true
 */
@ExperimentalMaterial3Api
suspend fun SheetState.部分展开() {
    this.partialExpand()
}

/**
 * 如果 [confirmValueChange] 返回 true，则以动画方式展开底部面板，并挂起直到面板达到 [PartiallyExpanded]
 * 状态（如果已定义），否则达到 [SheetValue.Expanded] 状态。
 *
 * @throws [CancellationException] 如果动画被中断
 */
@ExperimentalMaterial3Api
suspend fun SheetState.显示() {
    this.show()
}

/**
 * 如果 [confirmValueChange] 返回 true，则以动画方式隐藏底部面板，并挂起直到面板完全隐藏或动画被取消。
 *
 * @throws [CancellationException] 如果动画被中断
 */
@ExperimentalMaterial3Api
suspend fun SheetState.隐藏() {
    this.hide()
}

object 面板状态{
    /** [SheetState] 的默认 [保存器] 实现。 */
    @ExperimentalMaterial3Api
    fun 保存器(
        跳过部分展开: Boolean,
        位置阈值: () -> Float,
        速度阈值: () -> Float,
        确定值改变: (SheetValue) -> Boolean,
        跳过隐藏状态: Boolean,
    ) =
        SheetState.Saver(
            skipPartiallyExpanded = 跳过部分展开,
            positionalThreshold = 位置阈值,
            velocityThreshold = 速度阈值,
            confirmValueChange = 确定值改变,
            skipHiddenState = 跳过隐藏状态,
        )
}


/** [SheetState] 的可能取值。 */
@ExperimentalMaterial3Api
object 面板值 { // SheetValue
    /** 面板不可见。 */
    val 隐藏 = SheetValue.Hidden

    /** 面板以完整高度可见。 */
    val 完全展开 = SheetValue.Expanded

    /** 面板部分可见。 */
    val 部分展开 = SheetValue.PartiallyExpanded
}


/** 包含 [模态底部面板] 和 [底部面板脚手架] 使用的默认值。 */
@Stable
@ExperimentalMaterial3Api
object 底部面板默认值 { // BottomSheetDefaults

    /** [SheetValue.Hidden] 状态下底部面板的默认形状。 */
    val 隐藏形状: Shape
        @Composable get() = BottomSheetDefaults.HiddenShape

    /** [SheetValue.PartiallyExpanded] 和 [SheetValue.Expanded] 状态下底部面板的默认形状。 */
    val 完全展开形状: Shape
        @Composable get() = BottomSheetDefaults.ExpandedShape

    /** 底部面板的默认容器颜色。 */
    val 容器颜色: Color
        @Composable get() = BottomSheetDefaults.ContainerColor

    /** 底部面板的默认海拔高度。 */
    val 阴影 = BottomSheetDefaults.Elevation

    /** 背景内容的遮罩层叠加默认颜色。 */
    val 遮罩颜色: Color
        @Composable get() = BottomSheetDefaults.ScrimColor

    /** [底部面板脚手架] 使用的默认窥视高度。 */
    val 面板预览高度 = BottomSheetDefaults.SheetPeekHeight

    /** [模态底部面板] 和 [底部面板脚手架] 使用的默认最大宽度。 */
    val 面板最大宽度 = BottomSheetDefaults.SheetMaxWidth

    /** [模态底部面板] 内容使用和消费的默认边衬区。 */
    @Deprecated(
        level = DeprecationLevel.WARNING,
        message = "Renamed as modalWindowInsets.",
        replaceWith = ReplaceWith("modalWindowInsets"),
    )
    val 窗口插入: WindowInsets
        @Composable
        get() = BottomSheetDefaults.windowInsets

    /** [BottomSheet] 内容使用和消费的默认边衬区。 */
    val 标准窗口插入: WindowInsets
        @Composable get() = BottomSheetDefaults.standardWindowInsets

    /** [模态底部面板] 内容使用和消费的默认边衬区。 */
    val 模态窗口插入: WindowInsets
        @Composable
        get() = BottomSheetDefaults.modalWindowInsets

    /** 放置于底部面板顶部的可选视觉标记，用于指示其可被拖拽。 */
    @Suppress("ComposableNaming")
    @Composable
    fun 拖拽手柄(
        修饰符: Modifier = Modifier,
        宽度: Dp = 32.0.dp,
        高度: Dp = 4.0.dp,
        形状: Shape = MaterialTheme.shapes.extraLarge,
        颜色: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    ) =
        BottomSheetDefaults.DragHandle(
            modifier = 修饰符,
            width = 宽度,
            height = 高度,
            shape = 形状,
            color = 颜色,
        )

}


