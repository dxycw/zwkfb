package 安卓x.组合.材质3

import androidx.compose.material3.BottomSheet
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetState
import 安卓x.组合.材质3.令牌集.SheetBottomTokens
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CancellationException

/**
 * 底部弹窗（Sheet）可组合项的状态，例如 [ModalBottomSheet]。
 *
 * 包含与其滑动位置相关的状态，以及状态值之间的动画。
 *
 * @param 已启用值 底部弹窗可以停靠的 [SheetValue] 集合。这是可用状态的直接事实来源；如果某个值包含在此集合中，
 * 组件将尝试为其创建一个锚点。
 * @param 位置阈值 位置阈值，单位为像素，用于在拖动进行中以及拖动结束后计算目标状态时。这是从过渡起点开始的距离。
 * 根据交互方向的不同，它会从原始偏移量中加上或减去。该值应始终为正数。
 * @param 速度阈值 末速度必须超过的速度阈值（以像素/秒为单位），才能动画过渡到下一个状态，即使 [位置阈值]
 * （位置阈值）尚未达到。
 * @param 初始值 状态的初始值。
 * @param 确定值改变 可选的回调，用于确认或否决待处理的状态变更。
 */
@Stable
@ExperimentalMaterial3Api
fun 面板状态( // SheetState
    已启用值: Set<SheetValue>,
    位置阈值: () -> Float,
    速度阈值: () -> Float,
    初始值: SheetValue = SheetValue.Hidden,
    确定值改变: (SheetValue) -> Boolean = { true },
) =
    SheetState(
        enabledValues = 已启用值,
        positionalThreshold = 位置阈值,
        velocityThreshold = 速度阈值,
        initialValue = 初始值,
        confirmValueChange = 确定值改变,
    )


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
 * @param 跳过隐藏状态 是否应跳过隐藏状态。如果为 `true`，面板将始终展开至 [SheetValue.Expanded] 状态，
 * 并在隐藏时移至 [SheetValue.PartiallyExpanded]状态（如果可用），无论是通过编程方式还是用户交互。
 */
@Deprecated(
    message = "Use the primary constructor that takes a set of enabled values.",
    replaceWith =
        ReplaceWith(
            "SheetState(enabledValues = buildSet { " +
                    "add(SheetValue.Expanded); " +
                    "if (!skipPartiallyExpanded) add(SheetValue.PartiallyExpanded); " +
                    "if (!skipHiddenState) add(SheetValue.Hidden) " +
                    "}, positionalThreshold, velocityThreshold, initialValue, confirmValueChange)",
            "androidx.compose.material3.SheetValue",
        ),
)
@Stable
@ExperimentalMaterial3Api
fun 面板状态( // SheetState
    跳过部分展开: Boolean,
    位置阈值: () -> Float,
    速度阈值: () -> Float,
    初始值: SheetValue = SheetValue.Hidden,
    确定值改变: (SheetValue) -> Boolean = { true },
    跳过隐藏状态: Boolean = false,
) =
    SheetState(
        skipPartiallyExpanded = 跳过部分展开,
        positionalThreshold = 位置阈值,
        velocityThreshold = 速度阈值,
        initialValue = 初始值,
        confirmValueChange = 确定值改变,
        skipHiddenState = 跳过隐藏状态,
    )


//=====================================================================

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
fun SheetState.要求偏移量(): Float =  this.requireOffset()

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
suspend fun SheetState.展开() = this.expand()

/**
 * 如果 [confirmValueChange] 返回 true，则以动画方式展开底部面板，并挂起直到面板部分展开或动画被取消。
 *
 * @throws [CancellationException] 如果动画被中断
 * @throws [IllegalStateException] 如果 [skipPartiallyExpanded] 设置为 true
 */
@ExperimentalMaterial3Api
suspend fun SheetState.部分展开() = this.partialExpand()

/**
 * 如果 [confirmValueChange] 返回 true，则以动画方式展开底部面板，并挂起直到面板达到 [PartiallyExpanded]
 * 状态（如果已定义），否则达到 [SheetValue.Expanded] 状态。
 *
 * @throws [CancellationException] 如果动画被中断
 */
@ExperimentalMaterial3Api
suspend fun SheetState.显示() =  this.show()


/**
 * 如果 [confirmValueChange] 返回 true，则以动画方式隐藏底部面板，并挂起直到面板完全隐藏或动画被取消。
 *
 * @throws [CancellationException] 如果动画被中断
 */
@ExperimentalMaterial3Api
suspend fun SheetState.隐藏() = this.hide()

//=====================================================================

object 面板状态 { // SheetState

    /** [SheetState] 的默认 [保存器] 实现。 */
    @ExperimentalMaterial3Api
    fun 保存器(
        已启用值: Set<SheetValue>,
        位置阈值: () -> Float,
        速度阈值: () -> Float,
        确定值改变: (SheetValue) -> Boolean,
    ): Saver<SheetState, SheetValue> =
        SheetState.Saver(
            enabledValues = 已启用值,
            positionalThreshold = 位置阈值,
            velocityThreshold = 速度阈值,
            confirmValueChange = 确定值改变,
        )


    @Deprecated(
        message = "Use the Saver that takes a set of enabled values.",
        replaceWith =
            ReplaceWith(
                "Saver(enabledValues = buildSet { " +
                        "add(SheetValue.Expanded); " +
                        "if (!skipPartiallyExpanded) add(SheetValue.PartiallyExpanded); " +
                        "if (!skipHiddenState) add(SheetValue.Hidden) " +
                        "}, positionalThreshold, velocityThreshold, confirmValueChange)",
                "androidx.compose.material3.SheetValue",
            ),
    )
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
        宽度: Dp = SheetBottomTokens.DockedDragHandleWidth,
        高度: Dp = SheetBottomTokens.DockedDragHandleHeight,
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



/**
 * 为 [BottomSheet]、[ModalBottomSheet] 或 [BottomSheetScaffold] 创建并[安卓x.组合.运行时.记住]一个 [SheetState]。
 *
 * @param 初始值 状态的初始值。
 * @param 已启用值 底部弹窗可以停靠的 [SheetValue] 集合。这是可用状态的直接事实来源；如果某个值包含在此集合中，
 * 组件将尝试为其创建一个锚点。
 * @param 确定值改变 可选的回调，用于确认或否决待处理的状态变更。
 */
@Composable
@ExperimentalMaterial3Api
fun 记住底部面板状态(
    初始值: SheetValue,
    已启用值: Set<SheetValue> = setOf(SheetValue.Hidden, SheetValue.PartiallyExpanded, SheetValue.Expanded),
    确定值改变: (SheetValue) -> Boolean = { true },
): SheetState =
    rememberBottomSheetState(
        initialValue = 初始值,
        enabledValues = 已启用值,
        confirmValueChange = 确定值改变,
    )
