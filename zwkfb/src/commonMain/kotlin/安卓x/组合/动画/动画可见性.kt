package 安卓x.组合.动画

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Transition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

/**
 * [AnimatedVisibility] 可组合函数会在 [可见] 值变化时，为其内容的显示和隐藏添加动画效果。可以在 [进入] 和 [退出]
 * 参数中定义不同的 [EnterTransition] 和 [ExitTransition] 来控制显示和隐藏的动画。[EnterTransition] 和 [ExitTransition]
 * 包含四种类型：淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale）以及滑动（Slide）。进入动画可以通过 + 运算符进行组合，
 * 退出动画同样如此。组合的顺序并不重要，因为过渡动画会同时开始执行。有关这三种类型过渡的详细信息，请参阅 [EnterTransition] 和 [ExitTransition]。
 *
 * 除了这三种类型的 [EnterTransition] 和 [ExitTransition] 之外，[AnimatedVisibility] 还支持自定义进入/退出动画。
 * 某些使用场景可能需要在形状、缩放比例、颜色等方面实现自定义的进入/退出动画。可以使用来自 [AnimatedVisibilityScope]
 * （即 [AnimatedVisibilityScope.transition]）的 Transition<EnterExitState> 对象来创建自定义进入/退出动画。
 * 具体示例请参见下方的第二个代码片段。这些自定义动画将与在 [进入] 和 [退出] 中指定的内置动画同时运行。如果需要完全自定义进入/退出动画，
 * 可以根据需要将 [进入] 和/或 [退出] 指定为 [EnterTransition.None] 和/或 [ExitTransition.None]。[AnimatedVisibility]
 * 会等待所有进入/退出动画完成后，才将其状态视为空闲。只有在所有（内置和自定义）退出动画都结束后，[内容] 内容才会被移除。
 *
 * [AnimatedVisibility] 为其内容创建一个自定义的 [Layout]。该自定义布局的尺寸由子组件中最大的宽度和最高的高度决定。所有子组件都将对齐到该
 * [Layout] 的左上角（top start）。
 *
 * 注意：一旦退出动画完成，[内容] 可组合函数将从组件树中移除并被销毁。如果需要观察进入/退出动画的状态变化并执行后续操作
 * （例如移除数据、执行序列动画等），请考虑使用接受 [MutableTransitionState] 参数的 AnimatedVisibility API 变体。
 *
 * 默认情况下，进入动画将是内容的 [fadeIn]（淡入）和从底部末端开始的 [expandIn]（展开）的组合。退出动画则是将内容向底部末端收缩的同时淡出
 * （即 [fadeOut] + [shrinkOut]）。如果父组件或兄弟组件依赖于正在显示/隐藏的内容的尺寸，那么展开和收缩动画通常也会带动它们一起产生动画效果。
 * 当 [AnimatedVisibility] 可组合函数被放置在 [Row] 或 [Column] 中时，其默认的进入和退出动画会根据该特定容器进行定制。有关详细信息，
 * 请参阅 [RowScope.AnimatedVisibility] 和 [ColumnScope.AnimatedVisibility]。
 *
 * 这里有两个 [AnimatedVisibility] 的示例：一个使用内置的进入/退出过渡动画，另一个使用自定义的进入/退出动画。
 *
 * @param 可见 定义内容是否应该可见
 * @param 修饰符 用于包含 [内容] 的 [Layout]（布局）的修饰符
 * @param 进入 用于出现动画的 EnterTransition（进入过渡），默认情况下为淡入并扩展
 * @param 退出 用于消失动画的 ExitTransition（退出过渡），默认情况下为淡出并收缩
 * @param 标签 用于在 Android Studio 动画预览中区分其他动画的标签
 * @param 内容 根据 [可见] 的值显示或隐藏的内容
 * @see EnterTransition
 * @see ExitTransition
 * @see fadeIn
 * @see expandIn
 * @see fadeOut
 * @see shrinkOut
 * @see AnimatedVisibilityScope
 */
@Suppress("ComposableNaming")
@Composable
fun 动画可见性(
    可见: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    标签: String = "AnimatedVisibility",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visible = 可见,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容
    )
}

/**
 * [RowScope.AnimatedVisibility] 可组合函数会在 [AnimatedVisibility] 位于 [Row] 中时，为其内容的显示和隐藏添加动画效果。
 * 默认的动画是专门为 [Row] 布局定制的。更多详细信息请见下文。
 *
 * 可以在 [进入] 和 [退出] 参数中定义不同的 [EnterTransition] 和 [ExitTransition]，以控制内容的显示和隐藏动画。[EnterTransition]
 * 和 [ExitTransition] 包含四种类型：淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale）以及滑动（Slide）。
 * 进入动画可以通过 + 运算符进行组合，退出动画同样如此。组合的顺序并不重要，因为过渡动画会同时开始执行。有关这几种类型过渡的详细信息，
 * 请参阅 [EnterTransition] 和 [ExitTransition]。
 *
 * 默认的 [进入] 和 [退出] 过渡动画是根据 [Row] 的水平布局进行配置的。[进入] 默认为淡入（fading in）与水平方向展开
 * （expanding）内容的组合。（在内容展开至全宽时，其末端将作为前导边缘。）而 [退出] 默认为在淡出的同时，以内容末端为前导边缘进行水平收缩。
 * 由于行内的父组件和兄弟组件依赖于正在显示/隐藏的内容的尺寸，因此展开和收缩动画通常也会带动它们一起产生动画效果。
 *
 * 除了这三种类型的 [EnterTransition] 和 [ExitTransition] 之外，[动画可见性] 还支持自定义进入/退出动画。
 * 某些使用场景可能需要在形状、缩放比例、颜色等方面实现自定义的进入/退出动画。可以使用来自 [AnimatedVisibilityScope]
 * （即 [AnimatedVisibilityScope.transition]）的 Transition<EnterExitState> 对象来创建自定义进入/退出动画。
 * 有关自定义动画的示例，请参阅 [EnterExitState]。这些自定义动画将与在 [进入] 和 [退出] 中指定的内置动画同时运行。
 * 如果需要完全自定义进入/退出动画，可以根据需要将 [进入] 和/或 [退出] 指定为 [EnterTransition.None] 和/或 [ExitTransition.None]。
 * [动画可见性] 会等待所有进入/退出动画完成后，才将其状态视为空闲。只有在所有（内置和自定义）退出动画都结束后，[内容] 内容才会被移除。
 *
 * [动画可见性] 为其内容创建一个自定义的 [Layout]。该自定义布局的尺寸由子组件中最大的宽度和最高的高度决定。所有子组件都将对齐到该
 * [Layout] 的左上角（top start）。
 *
 * 注意：一旦退出动画完成，[内容] 可组合函数将从组件树中移除并被销毁。如果需要观察进入/退出动画的状态变化并执行后续操作
 * （例如移除数据、执行序列动画等），请考虑使用接受 [MutableTransitionState] 参数的 AnimatedVisibility API 变体。
 *
 * 以下是在 [Row] 中使用 [RowScope.AnimatedVisibility] 的示例：
 *
 * @param 可见 定义内容是否应该可见
 * @param 修饰符 用于包含 [内容] 的 [Layout]（布局）的修饰符
 * @param 进入 用于出现动画的 EnterTransition（进入过渡），默认情况下为淡入并水平扩展
 * @param 退出 用于消失动画的 ExitTransition（退出过渡），默认情况下为淡出并水平收缩
 * @param 标签 用于在 Android Studio 动画预览中区分其他动画的标签
 * @param 内容 根据 [可见] 的值显示或隐藏的内容
 * @see EnterTransition
 * @see ExitTransition
 * @see fadeIn
 * @see expandIn
 * @see fadeOut
 * @see shrinkOut
 * @see AnimatedVisibility
 * @see ColumnScope.AnimatedVisibility
 * @see AnimatedVisibilityScope
 */
@Suppress("ComposableNaming")
@Composable
fun RowScope.动画可见性(
    可见: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandHorizontally(),
    退出: ExitTransition = fadeOut() + shrinkHorizontally(),
    标签: String = "AnimatedVisibility",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visible = 可见,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容
    )
}

/**
 * [ColumnScope.AnimatedVisibility] 可组合函数会在 [AnimatedVisibility] 位于 [Column] 中时，为其内容的显示和隐藏添加动画效果。
 * 默认的动画是专门为 [Column] 布局定制的。更多详细信息请见下文。
 *
 * 可以在 [进入] 和 [退出] 参数中定义不同的 [EnterTransition] 和 [ExitTransition]，以控制内容的显示和隐藏动画。[EnterTransition]
 * 和 [ExitTransition] 包含四种类型：淡入淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale）以及滑动（Slide）。进入动画可以通过 +
 * 运算符进行组合，退出动画同样如此。组合的顺序并不重要，因为过渡动画会同时开始执行。有关这几种类型过渡的详细信息，请参阅 [EnterTransition]
 * 和 [ExitTransition]。
 *
 * 默认的 [进入] 和 [退出] 过渡动画是根据 [Column] 的垂直布局进行配置的。[进入] 默认为淡入（fading in）与垂直方向展开（expanding）
 * 内容的组合。（在内容展开至全高时，其底部将作为前导边缘。）而 [退出] 默认为在淡出的同时，以内容底部为前导边缘进行垂直收缩。
 * 由于列内的父组件和兄弟组件依赖于正在显示/隐藏的内容的尺寸，因此展开和收缩动画通常也会带动它们一起产生动画效果。
 *
 * 除了这三种类型的 [EnterTransition] 和 [ExitTransition] 之外，[动画可见性] 还支持自定义进入/退出动画。
 * 某些使用场景可能需要在形状、缩放比例、颜色等方面实现自定义的进入/退出动画。可以使用来自 [AnimatedVisibilityScope]
 * （即 [AnimatedVisibilityScope.transition]）的 Transition<EnterExitState> 对象来创建自定义进入/退出动画。
 * 有关自定义动画的示例，请参阅 [EnterExitState]。这些自定义动画将与在 [进入] 和 [退出] 中指定的内置动画同时运行。
 * 如果需要完全自定义进入/退出动画，可以根据需要将 [进入] 和/或 [退出] 指定为 [EnterTransition.None] 和/或 [ExitTransition.None]。
 * [动画可见性] 会等待所有进入/退出动画完成后，才将其状态视为空闲。只有在所有（内置和自定义）退出动画都结束后，[内容] 内容才会被移除。
 *
 * [动画可见性] 为其内容创建一个自定义的 [Layout]。该自定义布局的尺寸由子组件中最大的宽度和最高的高度决定。所有子组件都将对齐到该
 * [Layout] 的左上角（top start）。
 *
 * 注意：一旦退出动画完成，[内容] 可组合函数将从组件树中移除并被销毁。如果需要观察进入/退出动画的状态变化并执行后续操作
 * （例如移除数据、执行序列动画等），请考虑使用接受 [MutableTransitionState] 参数的 AnimatedVisibility API 变体。
 *
 * 以下是在 [Column] 中使用 [ColumnScope.AnimatedVisibility] 的示例：
 *
 * @param 可见 定义内容是否应该可见
 * @param 修饰符 用于包含 [内容] 的 [Layout]（布局）的修饰符
 * @param 进入 用于出现动画的 EnterTransition（进入过渡），默认情况下为淡入并垂直扩展
 * @param 退出 用于消失动画的 ExitTransition（退出过渡），默认情况下为淡出并垂直收缩
 * @param 标签 用于在 Android Studio 动画预览中区分其他动画的标签
 * @param 内容 根据 [可见] 的值显示或隐藏的内容
 * @see EnterTransition
 * @see ExitTransition
 * @see fadeIn
 * @see expandIn
 * @see fadeOut
 * @see shrinkOut
 * @see AnimatedVisibility
 * @see AnimatedVisibilityScope
 */
@Suppress("ComposableNaming")
@Composable
fun ColumnScope.动画可见性(
    可见: Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandVertically(),
    退出: ExitTransition = fadeOut() + shrinkVertically(),
    标签: String = "AnimatedVisibility",
    内容: @Composable AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visible = 可见,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容
    )
}

/**
 * [进入退出状态] 包含了 [动画可见性] 进入和退出过渡所涉及的三种状态。更具体地说，[预进入] 和 [可见]
 * 定义了进入过渡的初始状态和目标状态，而 [可见] 和 [已退出] 则是退出过渡的初始状态和目标状态。
 *
 * 请参见下方示例，了解如何在 [动画可见性] 中使用 Transition<EnterExitState>（即 [AnimatedVisibilityScope.transition]）实现自定义进入/退出动画：
 *
 * @see 动画可见性
 */
object 进入退出状态 {

    /** [动画可见性] 中自定义进入动画的初始状态。 */
    val 预进入 = EnterExitState.PreEnter

    /** `Visible` 状态是自定义进入动画的目标状态，也是自定义退出动画的初始状态。*/
    val 可见 = EnterExitState.Visible

    /** [动画可见性] 中自定义退出动画的目标状态。 */
    val 已退出 = EnterExitState.PostExit

}

/**
 * [动画可见性] 可组合项会在 [可见状态] 的 [targetState][MutableTransitionState.targetState]（目标状态）发生变化时，
 * 为其内容的出现和消失添加动画效果。[可见状态] 还可用于观察 [动画可见性] 的状态。例如：visibleState.isIdle
 * 表示 [动画可见性] 中所有动画是否已完成，visibleState.currentState 则返回当前动画的初始状态。
 *
 * 可以在 [进入] 和 [退出] 参数中定义不同的 [EnterTransition]（进入过渡）和 [ExitTransition]（退出过渡），用于控制出现和消失动画。
 * [EnterTransition] 和 [ExitTransition] 共有四种类型：Fade（淡入淡出）、Expand/Shrink（扩展/收缩）、Scale（缩放） 和 Slide（滑动）。
 * 进入过渡可以通过 + 运算符组合使用，退出过渡同理。组合顺序不影响效果，因为过渡动画会同时开始。有关这几种过渡类型的详细信息，请参见 [EnterTransition]
 * 和 [ExitTransition]。
 *
 * 除 [EnterTransition] 和 [ExitTransition] 这几种类型外，[动画可见性] 还支持自定义进入/退出动画。某些使用场景可能会从形状、
 * 缩放、颜色等方面的自定义进入/退出动画中受益。自定义进入/退出动画可以通过 [AnimatedVisibilityScope] 中的 Transition<EnterExitState>
 * 对象创建（即 [AnimatedVisibilityScope.transition]）。有关自定义动画的示例，请参见 [EnterExitState]。这些自定义动画将与 [进入] 和
 * [退出] 中指定的内置动画并行运行。如果需要完全自定义进入/退出动画，可以根据需要将 [进入] 和/或 [退出] 指定为 [EnterTransition.None]
 * 和/或 [ExitTransition.None]。[动画可见性] 将等待所有进入/退出动画完成后才会认为自己处于空闲状态。只有在所有（内置和自定义）
 * 退出动画完成后，[内容] 才会被移除。
 *
 * [动画可见性] 为其内容创建一个自定义的 [Layout]（布局）。该自定义布局的尺寸由子组件的最大宽度和最大高度决定。所有子组件将对齐到
 * [Layout] 的顶部起始位置（top start）。
 *
 * 注意：退出过渡动画完成后，[内容] 可组合项将从组件树中移除并被释放。[可见状态] 的 currentState 和 targetState 都将变为 false。
 *
 * 默认情况下，进入过渡动画将是 [fadeIn]（淡入）和内容从底部末端开始的 [expandIn]（扩展进入）的组合。退出过渡动画则是在淡出的同时向底部末端收缩内容
 * （即 [fadeOut] + [shrinkOut]）。如果父组件和兄弟组件依赖于出现/消失内容的尺寸，这种扩展和收缩动画很可能也会带动它们产生联动动画。
 * 当 [动画可见性] 可组合项放置在 [Row]（行布局）或 [Column]（列布局）中时，默认的进入和退出过渡会针对该特定容器进行优化。
 * 详情请参见 [RowScope.AnimatedVisibility] 和 [ColumnScope.AnimatedVisibility]。
 *
 * @param 可见状态 定义内容是否应该可见
 * @param 修饰符 用于包含 [内容] 的 [Layout]（布局）的修饰符
 * @param 进入 用于出现动画的 EnterTransition（进入过渡），默认情况下为淡入并扩展
 * @param 退出 用于消失动画的 ExitTransition（退出过渡），默认情况下为淡出并收缩
 * @param 标签 用于在 Android Studio 动画预览中区分其他动画的标签
 * @param 内容 根据 [可见状态] 的值显示或隐藏的内容
 * @see EnterTransition
 * @see ExitTransition
 * @see fadeIn
 * @see expandIn
 * @see fadeOut
 * @see shrinkOut
 * @see AnimatedVisibility
 * @see Transition.AnimatedVisibility
 * @see AnimatedVisibilityScope
 */
@Suppress("ComposableNaming")
@Composable
fun 动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = fadeOut() + shrinkOut(),
    标签: String = "AnimatedVisibility",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visibleState = 可见状态,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容
    )
}

/**
 * [RowScope.AnimatedVisibility] 可组合项会在 [可见状态] 的 [targetState][MutableTransitionState.targetState]
 * （目标状态）发生变化时，为其内容的出现和消失添加动画效果。默认的 [进入]（进入）和 [退出]（退出）过渡动画专门针对 [Row]（行布局）进行了优化。
 * 详见下文。[可见状态] 还可用于观察 [动画可见性] 的状态。例如：visibleState.isIdle 表示 [动画可见性]
 * 中所有动画是否已完成，visibleState.currentState 则返回当前动画的初始状态。
 *
 * 可以在 [进入] 和 [退出] 参数中定义不同的 [EnterTransition]（进入过渡）和 [ExitTransition]（退出过渡），用于控制出现和消失动画。
 * [EnterTransition] 和 [ExitTransition] 共有四种类型：Fade（淡入淡出）、Expand/Shrink（扩展/收缩）、Scale（缩放） 和 Slide（滑动）。
 * 进入过渡可以通过 + 运算符组合使用，退出过渡同理。组合顺序不影响效果，因为过渡动画会同时开始。有关这几种过渡类型的详细信息，
 * 请参见 [EnterTransition] 和 [ExitTransition]。
 *
 * 默认的 [进入]（进入）和 [退出]（退出）过渡动画基于 [Row]（行布局）的水平布局进行配置。[进入] 默认组合了淡入效果和内容的水平扩展动画
 * （内容末端将作为前缘，向完整宽度展开）。[退出] 默认则是在淡出的同时，以内容末端作为前缘进行水平收缩。由于行布局中的父组件和兄弟组件依赖于
 * 出现/消失内容的尺寸，因此这种扩展和收缩动画很可能也会带动它们产生联动动画。
 *
 * 除 [EnterTransition] 和 [ExitTransition] 这几种类型外，[动画可见性] 还支持自定义进入/退出动画。某些使用场景可能会从形状、
 * 缩放、颜色等方面的自定义进入/退出动画中受益。自定义进入/退出动画可以通过 [AnimatedVisibilityScope] 中的 Transition<EnterExitState>
 * 对象创建（即 [AnimatedVisibilityScope.transition]）。有关自定义动画的示例，请参见 [EnterExitState]。这些自定义动画将与 [进入] 和
 * [退出] 中指定的内置动画并行运行。如果需要完全自定义进入/退出动画，可以根据需要将 [进入] 和/或 [退出] 指定为 [EnterTransition.None]
 * 和/或 [ExitTransition.None]。[动画可见性] 将等待所有进入/退出动画完成后才会认为自己处于空闲状态。只有在所有（内置和自定义）
 * 退出动画完成后，[内容] 才会被移除。
 *
 * [动画可见性] 为其内容创建一个自定义的 [Layout]（布局）。该自定义布局的尺寸由子组件的最大宽度和最大高度决定。所有子组件将对齐到
 * [Layout] 的顶部起始位置（top start）。
 *
 * 注意：退出过渡动画完成后，[内容] 可组合项将从组件树中移除并被释放。[可见状态] 的 currentState 和 targetState 都将变为 false。
 *
 * @param 可见状态 定义内容是否应该可见
 * @param 修饰符 用于包含 [内容] 的 [Layout]（布局）的修饰符
 * @param 进入 用于出现动画的 EnterTransition（进入过渡），默认情况下为淡入并垂直扩展
 * @param 退出 用于消失动画的 ExitTransition（退出过渡），默认情况下为淡出并垂直收缩
 * @param 标签 用于在 Android Studio 动画预览中区分其他动画的标签
 * @param 内容 根据 [可见状态] 的值显示或隐藏的内容
 * @see EnterTransition
 * @see ExitTransition
 * @see fadeIn
 * @see expandIn
 * @see fadeOut
 * @see shrinkOut
 * @see AnimatedVisibility
 * @see Transition.AnimatedVisibility
 * @see AnimatedVisibilityScope
 */
@Suppress("ComposableNaming")
@Composable
fun RowScope.动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = expandHorizontally() + fadeIn(),
    退出: ExitTransition = shrinkHorizontally() + fadeOut(),
    标签: String = "AnimatedVisibility",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visibleState = 可见状态,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容
    )
}

/**
 * [ColumnScope.AnimatedVisibility] 可组合项会在 [可见状态] 的 [targetState][MutableTransitionState.targetState]
 * （目标状态）发生变化时，为其内容的出现和消失添加动画效果。默认的 [进入]（进入）和 [退出]（退出）过渡动画专门针对 [Column]（列布局）进行了优化。
 * 详见下文。[可见状态] 还可用于观察 [动画可见性] 的状态。例如：visibleState.isIdle 表示 [动画可见性] 中所有动画是否已完成，
 * visibleState.currentState 则返回当前动画的初始状态。
 *
 * 可以在 [进入] 和 [退出] 参数中定义不同的 [EnterTransition]（进入过渡）和 [ExitTransition]（退出过渡），用于控制出现和消失动画。
 * [EnterTransition] 和 [ExitTransition] 共有四种类型：Fade（淡入淡出）、Expand/Shrink（扩展/收缩）、Scale（缩放） 和 Slide（滑动）。
 * 进入过渡可以通过 + 运算符组合使用，退出过渡同理。组合顺序不影响效果，因为过渡动画会同时开始。有关这几种过渡类型的详细信息，请参见 [EnterTransition]
 * 和 [ExitTransition]。
 *
 * 默认的 [进入]（进入）和 [退出]（退出）过渡动画基于 [Column]（列布局）的垂直布局进行配置。[进入] 默认组合了淡入效果和内容的垂直扩展动画
 * （内容底部将作为前缘，向完整高度展开）。[退出] 默认则是在淡出的同时，以内容底部作为前缘进行垂直收缩。由于列布局中的父组件和兄弟组件依赖于
 * 出现/消失内容的尺寸，因此这种扩展和收缩动画很可能也会带动它们产生联动动画。
 *
 * 除 [EnterTransition] 和 [ExitTransition] 这三种类型外， [动画可见性] 还支持自定义进入/退出动画。
 * 某些使用场景可能会从形状、缩放、颜色等方面的自定义进入/退出动画中受益。自定义进入/退出动画可以通过 [AnimatedVisibilityScope] 中的
 * Transition<EnterExitState> 对象创建（即 [AnimatedVisibilityScope.transition] ）。有关自定义动画的示例，请参见 [EnterExitState]。
 * 这些自定义动画将与 [进入] 和 [退出] 中指定的内置动画并行运行。如果需要完全自定义进入/退出动画，可以根据需要将 [进入] 和/或 [退出]
 * 指定为 [EnterTransition.None] 和/或 [ExitTransition.None] 。 [动画可见性] 将等待所有进入/退出动画完成后才会认为自己处于空闲状态。
 * 只有在所有（内置和自定义）退出动画完成后， [内容] 才会被移除。
 *
 * [动画可见性] 为其内容创建一个自定义的 [Layout]（布局）。该自定义布局的尺寸由子组件的最大宽度和最大高度决定。所有子组件将对齐到
 * [Layout] 的顶部起始位置（top start）。
 *
 * 注意：退出过渡动画完成后，[内容] 可组合项将从组件树中移除并被释放。[可见状态] 的 currentState 和 targetState 都将变为 `false`。
 *
 * @param 可见状态 定义内容是否应该可见
 * @param 修饰符 用于包含 [内容] 的 [Layout]（布局）的修饰符
 * @param 进入 用于出现动画的 EnterTransition（进入过渡），默认情况下为淡入并垂直扩展
 * @param 退出 用于消失动画的 ExitTransition（退出过渡），默认情况下为淡出并垂直收缩
 * @param 标签 用于在 Android Studio 动画预览中区分其他动画的标签
 * @param 内容 根据 [可见状态] 的值显示或隐藏的内容
 * @see EnterTransition
 * @see ExitTransition
 * @see fadeIn
 * @see expandIn
 * @see fadeOut
 * @see shrinkOut
 * @see AnimatedVisibility
 * @see Transition.AnimatedVisibility
 * @see AnimatedVisibilityScope
 */
@Suppress("ComposableNaming")
@Composable
fun ColumnScope.动画可见性(
    可见状态: MutableTransitionState<Boolean>,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = expandVertically() + fadeIn(),
    退出: ExitTransition = shrinkVertically() + fadeOut(),
    标签: String = "AnimatedVisibility",
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visibleState = 可见状态,
        modifier = 修饰符,
        enter = 进入,
        exit = 退出,
        label = 标签,
        content = 内容
    )
}

/**
 * 此扩展函数创建一个 [动画可见性] 可组合项，作为给定 Transition 的子过渡。这意味着：1) 进入/退出过渡现在由提供的 [Transition]
 * 的 [targetState][Transition.targetState] 变化触发。当 targetState 改变时，可见性将使用 [可见] lambda 和 [Transition.targetState]
 * 派生。2) 进入/退出过渡以及在 [动画可见性] 中定义的任何自定义进入/退出动画现在都被提升到父 Transition 中。父 Transition
 * 将等待所有动画完成，然后才认为自身已完成（即 [Transition.currentState] = [Transition.targetState]），随后在退出情况下移除内容。
 *
 * 可以在 [进入] 和 [退出] 中定义不同的 [EnterTransition] 和 [ExitTransition]，用于出现和消失的动画效果。[EnterTransition]
 * 和 [ExitTransition] 有四种类型：淡入/淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale）和滑动（Slide）。进入过渡可以使用 +
 * 进行组合。退出过渡同样如此。组合的顺序无关紧要，因为过渡动画会同时开始。有关这三种过渡类型的详细信息，请参阅 [EnterTransition]
 * 和 [ExitTransition]。
 *
 * 除了这三种类型的 [EnterTransition] 和 [ExitTransition] 之外，[动画可见性] 还支持自定义进入/退出动画。
 * 某些用例可能受益于形状、缩放、颜色等方面的自定义进入/退出动画。可以使用来自 [AnimatedVisibilityScope] 的 Transition<EnterExitState>
 * 对象（即 [AnimatedVisibilityScope.transition]）创建自定义进入/退出动画。有关自定义动画的示例，请参阅 [EnterExitState]。
 * 这些自定义动画将与在 [进入] 和 [退出] 中指定的内置动画同时运行。在需要完全自定义进入/退出动画的情况下，可以根据需要将 [进入] 和/或 [退出]
 * 指定为 [EnterTransition.None] 和/或 [ExitTransition.None]。[动画可见性] 会等待所有进入/退出动画完成后才认为自身处于空闲状态。
 * [内容] 内容只有在所有（内置和自定义）退出动画完成后才会被移除。
 *
 * [动画可见性] 为其内容创建一个自定义的 [Layout]。该自定义布局的尺寸由子元素的最大宽度和最大高度决定。所有子元素都将对齐到 [Layout] 的顶部起始位置。
 *
 * 注意：一旦退出过渡完成，[内容] 可组合项将从树中移除并销毁。
 *
 * 默认情况下，进入过渡将是内容的 [fadeIn]（淡入）和从底部末端开始的 [expandIn]（展开）的组合。而退出过渡将是将内容向底部末端收缩同时淡出
 * （即 [fadeOut] + [shrinkOut]）。展开和收缩动画如果父元素和兄弟元素依赖于出现/消失内容的尺寸，也很可能会带动它们一起动画。
 *
 * @param 可见 定义内容是否应该可见 基于过渡状态 T
 * @param 修饰符 用于包含 [内容] 的 [Layout]（布局）的修饰符
 * @param 进入 用于出现动画的 EnterTransition（进入过渡），默认情况下为淡入并垂直扩展
 * @param 退出 用于消失动画的 ExitTransition（退出过渡），默认情况下为淡出并垂直收缩
 * @param 内容 根据从 [Transition.targetState] 和提供的 [可见] lambda 表达式派生的可见性来显示或隐藏的内容
 * @see EnterTransition
 * @see ExitTransition
 * @see fadeIn
 * @see expandIn
 * @see fadeOut
 * @see shrinkOut
 * @see AnimatedVisibilityScope
 * @see Transition.AnimatedVisibility
 */
@Suppress("ComposableNaming")
@Composable
fun <T> Transition<T>.动画可见性(
    可见: (T) -> Boolean,
    修饰符: Modifier = Modifier,
    进入: EnterTransition = fadeIn() + expandIn(),
    退出: ExitTransition = shrinkOut() + fadeOut(),
    内容: @Composable() AnimatedVisibilityScope.() -> Unit,
): Unit = AnimatedVisibility(visible = 可见, modifier = 修饰符, enter = 进入, exit = 退出, content = 内容)

/**
 * 这是 [动画可见性] 内容的作用域。在此作用域中，[动画可见性] 的直接和间接子元素将能够通过 [Modifier.动画进入退出]
 * 使用内置选项定义自己的进入/退出过渡。它们还可以使用 [过渡] 对象定义自定义的进入/退出动画。[动画可见性]
 * 会确保自定义和内置的进入/退出动画在完成之前不会被视为空闲状态，随后在退出时移除其内容。
 *
 * 注意： 如果自定义的进入/退出动画是独立于 [AnimatedVisibilityScope.transition] 创建的，那么在退出时无法保证这些动画能够完成，
 * 因为 [动画可见性] 无法感知到此类动画。
 */
interface 动画可见性范围 { // AnimatedVisibilityScope
    /**
     * [过渡] 允许指定自定义的进入/退出动画。它将与 [动画可见性] 中指定的内置进入/退出过渡同时运行。
     */
    val 过渡: Transition<EnterExitState>

    /**
     * [动画进入退出] 修饰符可用于 [动画可见性] 的任何直接或间接子元素，以创建与 [动画可见性]
     * 中指定的不同的进入/退出动画。这些子元素的视觉效果将是 [动画可见性] 的动画与其自身进入/退出动画的组合。
     *
     * [进入] 和 [退出] 定义了不同的 [EnterTransition] 和 [ExitTransition]，它们将用于出现和消失的动画效果。[EnterTransition]
     * 和 [ExitTransition] 有四种类型：淡入/淡出（Fade）、展开/收缩（Expand/Shrink）、缩放（Scale）和滑动（Slide）。进入过渡可以使用
     * + 进行组合。退出过渡同样如此。组合的顺序无关紧要，因为过渡动画会同时开始。有关这三种过渡类型的详细信息，请参阅 [EnterTransition]
     * 和 [ExitTransition]。
     *
     * 默认情况下，进入过渡将是内容的 [fadeIn]（淡入）效果。而退出过渡将使用 [fadeOut]（淡出）效果来隐藏内容。
     *
     * 在某些情况下，可能需要让 [动画可见性] 完全不应用进入和/或退出动画，以便 [动画可见性]的子元素可以各自拥有独立的动画。
     * 要实现这一点，可以为 [动画可见性] 使用 [EnterTransition.None] 和/或 [ExitTransition.None]。
     */
    fun Modifier.动画进入退出(
        进入: EnterTransition = fadeIn(),
        退出: ExitTransition = fadeOut(),
        标签: String = "动画进入退出",
    ): Modifier

}

